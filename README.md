# 🖼️ ImageLite

## 📌 Sobre o projeto

O **ImageLite** é um projeto desenvolvido com foco em **estudo e prática de upload de arquivos**, especificamente imagens, em uma aplicação backend simples e segura. O sistema permite o envio apenas de **imagens com extensões específicas**, garantindo maior controle e validação no processo de upload.

Este projeto foi idealizado para consolidar conhecimentos em **API REST**, **segurança com JWT**, **arquitetura limpa** e **integração com banco de dados**, sendo totalmente containerizado com Docker.

---

## 🎯 Objetivos

* Estudar diferentes formas de realizar **upload de arquivos** em uma API REST
* Trabalhar validações de **tipos e extensões de imagens**
* Implementar **autenticação e autorização** com Spring Security e JWT
* Aplicar conceitos de **Clean Architecture**

---

## 🛠️ Tecnologias Utilizadas

* ☕ **Java 17**
* 🌱 **Spring Boot**
* 🔐 **Spring Security**
* 🔑 **JWT (JSON Web Token)**
* 🗄️ **JPA / Hibernate**
* 🐘 **PostgreSQL**
* 🐳 **Docker & Docker Compose**
* 🧪 **Postman**
* ⚙️ **Lombok**

---

## ⚙️ Funcionalidades

* ✅ Cadastro de usuários
* ✅ Autenticação (Login) com JWT
* ✅ Upload de imagens
* ✅ Cadastro e gerenciamento de imagens
* ✅ Validação de extensões permitidas para upload

---

## 🧱 Arquitetura

O projeto segue os princípios da **Clean Architecture**, promovendo:

* Separação de responsabilidades
* Código mais organizado e testável
* Facilidade de manutenção e evolução

Além disso, a aplicação é estruturada como uma **RESTful API**, seguindo boas práticas de padronização de endpoints e respostas HTTP.

---

## 🚀 Como executar o projeto

### Pré-requisitos

* Docker
* Docker Compose

### Passo a passo

```bash
# Subir os containers da aplicação e do banco de dados
docker-compose up
```

Após a inicialização, a API estará disponível para consumo via **Postman** ou qualquer outro cliente HTTP.

---

## 🧪 Testes das Funcionalidades (Postman)

> 📸 **Espaço reservado para imagens dos testes realizados no Postman**

Você pode adicionar aqui:

* Print da criação do DB.
* Print pesquisa customizada de imagens salvas pela sua extensão.
* Print pesquisa de imagem pelo id.
* Print do cadastro de uma nova imagem.
* Print obtendo o token de usuário.

Exemplo:

![Banco de dados - Criado](https://github.com/user-attachments/assets/610af3ed-4d1b-49a7-b872-fe1bef022768)
![Endpoins de imagens](https://github.com/user-attachments/assets/a73709b1-6fad-44bc-af04-ab5d96c5e519)
<img width="1072" height="835" alt="image" src="https://github.com/user-attachments/assets/fb2cdf54-0bbc-460d-98d7-35fb46fbc023" />
<img width="2115" height="700" alt="image" src="https://github.com/user-attachments/assets/61f2ab8b-86e6-4499-a1e7-d9bf24fe43b5" />
<img width="2127" height="766" alt="image" src="https://github.com/user-attachments/assets/98859360-5063-4064-b087-f33fe9d2afc6" />

---

## 📚 Aprendizados

* Implementação de autenticação e autorização com JWT
* Manipulação de upload de arquivos no Spring Boot
* Validações de segurança para tipos de arquivos
* Uso de Docker para padronizar o ambiente de desenvolvimento

---

## 🔮 Melhorias Futuras

* 🔄 Paginação e filtros de imagens
* 🧹 Tratamento global de exceções
* 🧪 Testes automatizados
* ☁️ Integração com serviços de armazenamento em nuvem (ex: S3)

---

## 👤 Autor

Projeto desenvolvido por **Fábio Simones** 🚀

Se este projeto te ajudou de alguma forma, considere deixar uma ⭐ no repositório!
