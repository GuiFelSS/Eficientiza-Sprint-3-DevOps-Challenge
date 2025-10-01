# Estágio 1: Build da aplicação com o Maven
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Estágio 2: Criação da imagem final com a JRE
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copia o .jar gerado no estágio anterior
COPY --from=build /app/target/eficientiza-0.0.1-SNAPSHOT.jar ./app.jar
# Expõe a porta que o Spring Boot usa
EXPOSE 8080
# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]