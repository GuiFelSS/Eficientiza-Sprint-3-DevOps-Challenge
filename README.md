# 🚀 Eficientiza API - Challenge DevOps Tools & Cloud Computing

Este repositório contém a entrega da Sprint 3 para a disciplina de DevOps Tools & Cloud Computing. O projeto consiste na API "Eficientiza", um sistema de gerenciamento de motos e estações para a Mottu, totalmente implantado na nuvem da Microsoft Azure.
video: [https://youtu.be/QpT2cGKpidU](https://youtu.be/QpT2cGKpidU)
## 👥 Integrantes

* **Alexsandro Macedo:** RM557068
* **Leonardo Faria Salazar:** RM557484
* **Guilherme Felipe da Silva Souza:** RM558282

---

## 🛠️ Tecnologias e Arquitetura

A solução foi desenvolvida utilizando uma arquitetura moderna baseada em containers na nuvem, composta por:

* **Backend:** Java 17 com Spring Boot 3
* **Banco de Dados:** Azure Database for PostgreSQL (PaaS)
* **Hospedagem:** Azure App Service for Containers
* **Containerização:** Docker
* **Registro de Imagem:** Azure Container Registry (ACR)
* **Infraestrutura como Código:** Azure CLI

---

## 📋 Pré-requisitos

Antes de iniciar o deploy, certifique-se de ter as seguintes ferramentas instaladas e configuradas:

1.  **[Azure CLI](https://learn.microsoft.com/pt-br/cli/azure/install-azure-cli):** Ferramenta de linha de comando para interagir com o Azure.
2.  **[Docker Desktop](https://www.docker.com/products/docker-desktop/):** Para construir e gerenciar as imagens Docker.
3.  **Conta no Azure:** Logado com as credenciais fornecidas pela FIAP (`az login`).

---

## ⚙️ Passo a Passo para o Deploy na Azure

Siga os comandos abaixo em um terminal **PowerShell** para recriar toda a infraestrutura e implantar a aplicação, conforme a sequência executada.

**Passo 1: Criar o Grupo de Recursos**
*Um contêiner lógico para agrupar todos os serviços da solução.*
```powershell
az group create --name GrupoRecursosChallenge --location "Brazil South"
```

### Passo 2: Criar o Servidor de Banco de Dados PostgreSQL
Criação do servidor e do banco de dados que a aplicação utilizará.
```
az postgres flexible-server create --resource-group GrupoRecursosChallenge --name "bancochallengeRM558282" --location "Brazil South" --tier Burstable --sku-name Standard_B1ms --storage-size 32 --admin-user "adminchallenge" --admin-password "Challenge123" --public-access 0.0.0.0
```

### 3: Criar o Banco de Dados
Cria a base de dados "eficientiza_db" dentro do servidor.
```
az postgres flexible-server db create --resource-group GrupoRecursosChallenge --server-name "bancochallengerm558282" --database-name "eficientiza_db"
```

### 4: Criar o Azure Container Registry (ACR)
Cria o registro para armazenar nossa imagem Docker na nuvem.
```
az acr create --resource-group GrupoRecursosChallenge --name "acrchallengerm558282" --sku Basic --admin-enabled true
```

### 5: Fazer Login no ACR
Autentica o Docker local com o registro na nuvem. É necessário ter o Docker Desktop em execução.
```
az acr login --name "acrchallengerm558282"
```

### 6: Construir a Imagem Docker
Empacota a aplicação Java em uma imagem Docker a partir do Dockerfile.
```
docker build -t acrchallengerm558282.azurecr.io/eficientiza:latest .
```

### 7: Enviar a Imagem para o ACR
Envia a imagem construída localmente para o repositório na Azure.
```
docker push acrchallengerm558282.azurecr.io/eficientiza:latest
```

### 8: Criar o Plano de Serviço de Aplicativo
Define os recursos de computação (nível gratuito F1) para hospedar a aplicação.
```
az appservice plan create --name PlanoAppChallenge --resource-group GrupoRecursosChallenge --sku F1 --is-linux
```

### 9: Criar a Aplicação Web (App Service)
Cria o App Service e o configura para usar a imagem do ACR.
```
az webapp create --resource-group GrupoRecursosChallenge --plan PlanoAppChallenge --name "appchallengerm558282" --deployment-container-image-name "acrchallengerm558282.azurecr.io/eficientiza:latest" --docker-registry-server-user $(az acr credential show -n "acrchallengerm558282" --query "username" -o tsv) --docker-registry-server-password $(az acr credential show -n "acrchallengerm558282" --query "passwords[0].value" -o tsv)
```

### 10: Configurar a Porta da Aplicação
Informa ao App Service que a aplicação está rodando na porta 8080 dentro do container.
```
az webapp config appsettings set --resource-group GrupoRecursosChallenge --name "appchallengerm558282" --settings WEBSITES_PORT=8080
```

## 🔬 Como Testar a API

A aplicação estará disponível na URL do App Service.

* **URL Base da API:** `https://appchallengerm558282.azurewebsites.net`

Use uma ferramenta como Insomnia ou Postman para testar os endpoints.

#### Exemplo: Testando o CRUD de Usuários (`/usuarios`)

##### 1. Criar um novo usuário (POST)

* **Método:** `POST`
* **URL:** `https://appchallengerm558282.azurewebsites.net/usuarios`
* **Body (JSON):**
```json
{
  "nome": "Guilherme Souza",
  "email": "guilherme@email.com",
  "senha": "uma_senha_forte_123",
  "tipo": "ADMIN"
}
```

##### 2. Listar todos os usuários (GET)
* **Método:** `GET`
* **URL:** `https://appchallengerm558282.azurewebsites.net/usuarios`

##### 3. Buscar um usuário por ID (GET)
* **Método:** `GET`
* **URL:** `https://appchallengerm558282.azurewebsites.net/usuarios/1`

##### 4. Atualizar um usuário (PUT)
* **Método:** `PUT`
* **URL:** `https://appchallengerm558282.azurewebsites.net/usuarios/1`
* **Body (JSON):**
```json
{
  "nome": "Guilherme Felipe Souza",
  "email": "guilherme.souza@email.com",
  "senha": "uma_nova_senha_456",
  "tipo": "ADMIN"
}
```

##### 5. Deletar um usuário (DELETE)
* **Método:** `DELETE`
* **URL:** `https://appchallengerm558282.azurewebsites.net/usuarios/1`
