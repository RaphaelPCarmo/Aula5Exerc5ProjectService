![Banner do Projeto](https://github.com/RaphaelPCarmo/Aula5Exerc5ProjectService/blob/main/banner.png)

# Aula5Exerc5ProjetoService

Projeto desenvolvido para praticar a integração entre **Java**, **Spring Boot**, **HTML** e **Fetch API**, aplicando conceitos de **serviços REST**, **requisições HTTP** e **manipulação de dados no front-end**.

---

<h2>🧠 Objetivo</h2>

O projeto tem como foco compreender e aplicar o fluxo completo entre **cliente e servidor**, permitindo enviar e receber dados entre o front-end e o back-end de forma dinâmica, utilizando boas práticas de desenvolvimento e estrutura organizada com o Spring Boot.

**Principais metas:**
- Reforçar o uso da **Fetch API** no front-end.  
- Manipular dados em formato **JSON**.  
- Criar e consumir **serviços REST** em **Java**.  
- Consolidar o entendimento da arquitetura **Spring Boot + HTML + JS**.  

---

<h2>⚙️ Tecnologias Utilizadas</h2>

- **Java 17+**
- **Spring Boot**
- **HTML5**
- **Fetch API**
- **JSON**
- **H2 Database**
- **IntelliJ IDEA / Eclipse / VS Code**

---

<h2>📁 Estrutura do Projeto</h2>

Aula5Exerc5ProjectService/
│
├── src/
│ └── main/
│ └── java/
│ └── br/com/unifaj/poo/Aula4JDBC/
│ ├── controller/
│ │ ├── PessoaController.java
│ │ ├── FuncionarioController.java
│ │ └── ProjetoController.java
│ ├── dao/
│ │ ├── PessoaDao.java
│ │ ├── FuncionarioDao.java
│ │ └── ProjetoDao.java
│ ├── model/
│ │ ├── FuncionarioItem.java
│ │ ├── Retorno.java
│ │ └── Aula5Exerc5ProjetoServiceApplication.java
│
├── resources/
│ └── static/
│ ├── pessoa-form.html
│ ├── pessoa-listar.html
│ ├── projeto-form.html
│ └── funcionario-form.html
│
├── database.sql
└── README.md

yaml
Copiar código

---

<h2>🚀 Como Executar</h2>

1. Clone este repositório:
   ```bash
   git clone https://github.com/RaphaelPCarmo/Aula5Exerc5ProjectService.git
Abra o projeto em sua IDE (IntelliJ, Eclipse ou VS Code).

Execute a classe principal:

bash
Copiar código
Aula5Exerc5ProjetoServiceApplication.java
O servidor iniciará em:

arduino
Copiar código
http://localhost:8080
Abra os arquivos HTML em resources/static/ para testar as requisições com Fetch API.

<h2>💡 Conceitos Praticados</h2>
Estrutura de serviços REST com Spring Boot

Comunicação entre front-end e back-end

Requisições HTTP (GET, POST, PUT, DELETE)

Manipulação de dados JSON

Integração Java + HTML + JavaScript

Uso do H2 Database para testes locais

<h2>📸 Demonstração</h2>
Adicione aqui uma captura de tela (como a que você enviou, mostrando o IntelliJ em execução):

bash
Copiar código
![Execução do Projeto no IntelliJ](https://github.com/RaphaelPCarmo/Aula5Exerc5ProjectService/blob/main/demo.png)
<h2>📜 Código de Exemplo</h2>
java
Copiar código
package br.com.unifaj.poo.Aula4JDBC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Escaneia todos os subpacotes
public class Aula5Exerc5ProjetoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(Aula5Exerc5ProjetoServiceApplication.class, args);
    }
}
html
Copiar código
<!-- Exemplo de formulário HTML -->
<form id="pessoaForm">
  <input type="text" id="nome" placeholder="Nome" required />
  <input type="text" id="cpf" placeholder="CPF" required />
  <button type="submit">Salvar</button>
</form>
javascript
Copiar código
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
<h2>👨‍💻 Autor</h2>
Raphael Perim do Carmo
