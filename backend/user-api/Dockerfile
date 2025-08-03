# -------- STAGE 1: Build com Maven --------
FROM maven:3.9.6-eclipse-temurin-21 as builder

WORKDIR /app

# Copia o projeto inteiro
COPY pom.xml .
COPY src ./src

# Compilar sem testes
RUN mvn clean package -DskipTests

# -------- STAGE 2: Runtime --------
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copia o .jar
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão
EXPOSE 8080

# Variáveis de ambiente via docker-compose ou .env
ENV JAVA_OPTS=""

# Comando para iniciar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]

