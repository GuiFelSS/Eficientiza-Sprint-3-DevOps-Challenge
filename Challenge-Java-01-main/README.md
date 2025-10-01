# Integrantes:

- Alexsandro Macedo: RM557068
- Leonardo Faria Salazar: RM557484
- Guilherme Felipe da Silva Souza: RM558282


# 🚀 Eficientiza API - Challenge Java Advanced

Sistema de gerenciamento de motos, estações e histórico de movimentações, desenvolvido com Spring Boot, seguindo as boas práticas de REST, DTOs, tratamento de erros. A solução consiste em implementar um sistema que vai utilizar de 
estações no galpão da Mottu, esse sistema irá controlar para liberar/devolver uma moto, similar ao sistema de aluguel de bicicletas, dessa forma conseguiremos ter um mapeamento completo do pátio.
Para melhor contexto segue abaixo imagens de como funcionará o nosso sistema.

![image](https://github.com/user-attachments/assets/8b992276-597c-4d3e-bd48-4719801ec19c)
![image](https://github.com/user-attachments/assets/9718ec2f-9c85-4e70-81c4-94363cbb6b65)
![image](https://github.com/user-attachments/assets/bf81452e-15d7-49f8-bf7e-7024dfaa0651)
![image](https://github.com/user-attachments/assets/854f1f1c-4747-430a-aa19-0cab331c853b)
![image](https://github.com/user-attachments/assets/f4de5c04-41fc-4dc0-9261-0edf04ff4306)

---

## 📦 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring Web
- Bean Validation
- H2 (para testes) ou Oracle Database
- Maven
- DTOs + Services + Controllers organizados
- Swagger (opcional)
- Insomnia/Postman para testes

---

## 🧱 Entidades Modeladas

- `Usuario`: responsável por registrar ações no sistema
- `Estacao`: ponto físico onde as motos são alocadas
- `Moto`: veículo monitorado
- `HistoricoMoto`: registro de movimentações (entrada/saída)

---

## 📂 Estrutura de Pacotes

```
fiap.com.br.eficientiza
├── controller
├── dto
├── entity
├── exception
├── mapper (opcional)
├── repository
├── service
└── config
```

---

## 🔁 Endpoints REST

### Usuários

| Método | Rota               | Descrição                  |
|--------|--------------------|----------------------------|
| POST   | /usuarios          | Criar novo usuário         |
| GET    | /usuarios          | Listar todos os usuários   |
| GET    | /usuarios/{id}     | Buscar usuário por ID      |
| PUT    | /usuarios/{id}     | Atualizar usuário          |
| DELETE | /usuarios/{id}     | Deletar usuário            |

### Estações

| Método | Rota               | Descrição                    |
|--------|--------------------|------------------------------|
| POST   | /estacoes          | Criar nova estação           |
| GET    | /estacoes          | Listar todas as estações     |
| GET    | /estacoes/{id}     | Buscar estação por ID        |
| PUT    | /estacoes/{id}     | Atualizar estação            |
| DELETE | /estacoes/{id}     | Deletar estação              |

### Motos

| Método | Rota               | Descrição                  |
|--------|--------------------|----------------------------|
| POST   | /motos             | Criar nova moto            |
| GET    | /motos             | Listar todas as motos      |
| GET    | /motos/{id}        | Buscar moto por ID         |
| PUT    | /motos/{id}        | Atualizar moto             |
| DELETE | /motos/{id}        | Deletar moto               |

### Histórico de Motos

| Método | Rota               | Descrição                    |
|--------|--------------------|------------------------------|
| POST   | /historicos        | Criar novo histórico         |
| GET    | /historicos        | Listar históricos            |
| GET    | /historicos/{id}   | Buscar histórico por ID      |
| DELETE | /historicos/{id}   | Deletar histórico            |

---

## ⚙️ Configuração Oracle (application.properties)

```properties
spring.datasource.url=jdbc:oracle:thin:@//HOST:PORT/SERVICENAME
spring.datasource.username=usuario
spring.datasource.password=senha
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ✅ Como executar o projeto

1. Clone o repositório
2. Configure o `application.properties`
3. Suba seu banco Oracle (ou use H2)
4. Execute o projeto com `./gradlew bootRun` ou via IDE

---

## 📬 Testes via Insomnia/Postman

- Use o `POST /usuarios` para criar seu primeiro usuário
- Exemplo de JSON:
```json
{
  "nome": "João da Silva",
  "email": "joao@eficientiza.com",
  "senha": "123456",
  "tipo": "ADMIN"
}
```

---
