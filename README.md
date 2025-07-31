# Desafio anota ai (Pleno) - Back-End

<p align="center">

  <img src="https://www.vectorlogo.zone/logos/springio/springio-icon.svg" alt="Spring Boot" width="70"/>
  <img src="https://www.vectorlogo.zone/logos/java/java-icon.svg" alt="Java" width="70"/>
  <img src="https://www.vectorlogo.zone/logos/mongodb/mongodb-ar21~bgwhite.svg" alt="Java" width="120"/>
 <img src="https://www.vectorlogo.zone/logos/amazon_aws/amazon_aws-ar21~bgwhite.svg" alt="Java" width="120"/>
</p>

---

## 📌 Descrição
Esta aplicação é uma API em java, Java Spring,
AWS Simple Queue Service, Mongo DB, AWS Simple Storage Service
e AWS Bucket S3.
Este projeto foi desenvolvido com foco em boas práticas, arquitetura limpa,
uso do Mongo DB como banco de dados NoSQL e integrações com serviços da AWS,
como o SNS(Simple Notification Service).

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Web**
- **Spring Data MongoDB**
- **MapStruct 1.6.3**
- **AWS SDK - SNS**
- **org.json**
- **Open-Api/Swagger:** Para documentação da API
    (Endpoints, requests, respostas e etc.)

---

## 📦 Requisitos para execução

- Java 21
- Maven 3.8+ (ou utilize o wrapper `mvnw`)
- MongoDB em execução (localmente ou em container docker versão latest)
- MongoDB Compass instalado localmente
- Conta AWS configurada para utilização do SNS
---

## ⚙️ Como executar o projeto

``` bash

# Clone o repositório
git clone https://github.com/smfmo/desafio-anotaAi-Pleno-estudo

# navegue até a pasta
cd desafio-anotaAi-Pleno-estudo

# Construa o projeto
./mvnw clean install -DskipTests

# Execute a aplicação
./mvnw spring-boot:run
```
A aplicação estará disponível em: [http://localhost:8080](http://localhost:8080)

---

## 🌐 Documentação da API
A API esta documentada com Swagger, que permite vizualizar e testar todos
os endpoints interativamente.

### 🔗 Acessar o Swagger UI
Após startar o projeto, será possível acessar a documentação da API:
- **Local:** `http://localhost:8080/swagger-ui.html`

---

## 🧠 Principais Funcionalidades

- Persistência de dados com MongoDB
- Conversão de entidades com MapStruct
- Integração com AWS SNS para notificações assíncronas
- Estrutura modular seguindo princípios SOLID e boas práticas REST
