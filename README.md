# 💻 springboot-crud-h2-api  

Aplicação desenvolvida em **Java com Spring Boot**, integrando **HTML**, **Fetch API** e **H2 Database**.  
O objetivo é praticar a comunicação **cliente-servidor**, manipulando dados entre o front-end e o back-end por meio de **requisições HTTP** e **serviços RESTful**.  

---

### 🛠️ Built with

* ![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
* ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
* ![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)
* ![Fetch API](https://img.shields.io/badge/Fetch%20API-0078D4?style=for-the-badge)
* ![H2 Database](https://img.shields.io/badge/H2%20Database-003B57?style=for-the-badge&logo=h2&logoColor=white)

---

<h2> ✨ Funcionalidades </h2>

- 🔄 Comunicação entre **front-end e back-end**
- 📡 Envio e recebimento de dados em **JSON**
- 🧩 Integração com **H2 Database**
- 📋 Formulários dinâmicos com **Fetch API**
- 🚀 Estrutura organizada em camadas (**Controller**, **DAO**, **Model**)

---

<h2> 🚀 Como Executar o Projeto </h2>

• Clone o repositório:  
```bash
git clone https://github.com/RaphaelPCarmo/Aula5Exerc5ProjectService.git
```
• Abra o projeto na sua IDE Java (IntelliJ, Eclipse ou VS Code).

• Execute a classe principal:
```
Aula5Exerc5ProjetoServiceApplication.java
```

• O servidor iniciará em:
```
http://localhost:8080
```
• Acesse os arquivos HTML localizados em resources/static/ para testar as requisições via Fetch API.

<h2> 📦 Estrutura do Projeto </h2>

```
Aula5Exerc5ProjectService/
│
├── src/
│   └── main/
│       └── java/
│           └── br/com/unifaj/poo/Aula4JDBC/
│               ├── controller/
│               │   ├── PessoaController.java
│               │   ├── FuncionarioController.java
│               │   └── ProjetoController.java
│               ├── dao/
│               │   ├── PessoaDao.java
│               │   ├── FuncionarioDao.java
│               │   └── ProjetoDao.java
│               ├── model/
│               │   ├── FuncionarioItem.java
│               │   ├── Retorno.java
│               │   └── Aula5Exerc5ProjetoServiceApplication.java
│
├── resources/
│   └── static/
│       ├── pessoa-form.html
│       ├── pessoa-listar.html
│       ├── projeto-form.html
│       └── funcionario-form.html
│
├── database.sql
└── README.md
```
<h2> 📜 Código de Exemplo </h2>

```
package br.com.unifaj.poo.Aula4JDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // escaneia todos os subpacotes
public class Aula5Exerc5ProjetoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Aula5Exerc5ProjetoServiceApplication.class, args);
    }
}
```
```
<!-- Exemplo de formulário HTML -->
<form id="pessoaForm">
  <input type="text" id="nome" placeholder="Nome" required />
  <input type="text" id="cpf" placeholder="CPF" required />
  <button type="submit">Salvar</button>
</form>

// Exemplo de integração com Fetch API
document.getElementById("pessoaForm").addEventListener("submit", async (event) => {
  event.preventDefault();
  const nome = document.getElementById("nome").value;
  const cpf = document.getElementById("cpf").value;

  const response = await fetch("/pessoa/salvar", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ nome, cpf }),
  });

  if (response.ok) {
    alert("Pessoa salva com sucesso!");
  }
});
```
<h2> 🎯 Objetivo do Projeto </h2>

Este projeto foi criado para praticar e consolidar:

🧩 Estrutura de serviços REST

🔗 Integração entre back-end Java e front-end HTML

⚙️ Manipulação de dados com Fetch API

🧠 Comunicação cliente-servidor com JSON

💾 Persistência de dados com H2 Database

<h2> 🧠 Conceitos Praticados </h2>

```
CRUD básico com Spring Boot

Requisições HTTP (GET, POST, PUT, DELETE)

Padrão MVC (Controller, DAO, Model)

Configuração de banco H2 em memória

Estrutura de projeto modular e limpa
```

<h2> 🧑‍💻 Autor </h2>

👤 Raphael Perim do Carmo

<img src="https://github.com/RaphaelPCarmo.png" width="120" style="border-radius: 30%">
