<div align="center">

# FIAP Hackathon - Mail

![GitHub Release Date](https://img.shields.io/badge/Release%20Date-Abril%202025-yellowgreen)
![](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellowgreen)
<br>
![](https://img.shields.io/badge/Version-%20v1.0.0-brightgreen)
</div>

## 💻 Descrição
Este repositório é responsável enviar o e-mail para o usuario sobre o fim do processamento do video.

## 🛠 Tecnologias Utilizadas

![Java](https://img.shields.io/badge/java_21-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring_3-%236DB33F.svg?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-C71A36.svg?style=for-the-badge&logo=Apache-Maven&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=white)
![Sonnar](https://img.shields.io/badge/Sonar-FD3456.svg?style=for-the-badge&logo=Sonar&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-2088FF.svg?style=for-the-badge&logo=GitHub-Actions&logoColor=white)
![Terraform](https://img.shields.io/badge/Terraform-7B42BC?style=for-the-badge&logo=terraform&logoColor=white)

## 💫 Arquitetura

O projeto adota a **Clean Architecture**, garantindo flexibilidade, testabilidade e manutenção escalável.

## ⚙️ Configuração

### Desenvolvimento

- **[Java 21](https://docs.oracle.com/en/java/javase/21/)**: Documentação oficial do Java 21.
- **[Maven 3.6.3+](https://maven.apache.org/)**: Site oficial do Maven.
- **[Docker](https://www.docker.com/)**: Site oficial do Docker.
- **[Docker Compose](https://docs.docker.com/compose/)**: Documentação oficial do Docker Compose.
- **[Sonarqube](https://www.sonarsource.com/products/sonarqube/)**: Site oficial do Sonarqube.
- **[Kubernetes](https://kubernetes.io/pt-br/docs/home/)**: Documentação oficial do Kubernetes.
- **[Terraform](https://www.terraform.io/)**: Site oficial do Terraform.
- **[AWS](https://aws.amazon.com/pt/)**: Site oficial da AWS.

### 🚀 Execução

### Subindo a aplicação com Docker Compose

1. Executar o comando:

```sh
docker compose up
```

### Subindo o Mail
Caso deseje subir a Mail, basta seguir os seguintes passos:

1. Certificar que o Terraform esteja instalado executando o comando `terraform --version`;
2. Certificar que o `aws cli` está instalado e configurado com as credenciais da sua conta AWS;
3. Acessar a pasta `terraform` que contém os arquivos que irão criar o Mail;
4. Inicializar o Terraform no projeto `terraform init`;
5. Verificar que o script do Terraform é valido rodando o comando `terraform validate`;
6. Executar o comando `terraform plan` para executar o planejamento da execução/implementação;
7. Executar o comando `terraform apply` para criar o Mail;
8. Após a execução do Terraform finalizar, verificar se o Mail subiu corretamente na AWS;

## ✅ Cobertura de Testes

### Testes Unitarios
![unit-test](./assets/unit_test_mail.png)

### Scan do Sonar
![Sonar_1](./assets/sonar_mail_1.png)
![Sonar_1](./assets/sonar_mail_2.png)

## 🎲 Seeds

Este projeto utiliza **seeds** para criar a tabela e configurar as filas de forma local usando o localstack foi utilizado um arquivo bash.
```bash
.bash/create_setup.sh
```