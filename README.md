# FiadoSafe-API

## Descrição

FiadoSafe é uma API desenvolvida para gerenciar o sistema de contas "fiado" de forma segura e eficiente. O sistema permite gerenciar clientes, compras, pagamentos e dívidas de maneira fácil, com suporte a autenticação e autorização utilizando JWT. 

### Construído com
- **Java 11** 
- **Spring Boot** 
- **MongoDB**
- **JWT (JSON Web Tokens)** 
- **Swagger** 
- **Docker** 

### Por que FiadoSafe?
O objetivo é fornecer uma solução de gerenciamento de dívidas e pagamentos que seja simples de usar, mas que também garanta segurança e escalabilidade. Com a API, pequenos comerciantes podem manter o controle de contas pendentes e gerenciar melhor suas finanças.

---

## Instruções de Instalação

### Pré-requisitos

Antes de iniciar a instalação, certifique-se de ter os seguintes componentes instalados no seu sistema:
- **Java 11** ou superior
- **Maven 3.6+** (para gerenciamento de dependências)
- **Docker** (opcional, mas recomendado para rodar a aplicação em container)
- **Git** (para clonar o repositório)

### Passo a Passo

- Clone o repositório.
- Certifique-se de que o MongoDB Compass esteja rodando localmente em mongodb://localhost:27017/Fiado-Safe.

## Instruções de Uso Localmente

### Acessando a API

1. **Autenticação**
   - Utilize o endpoint `/auth/register` para registrar o usuário.
   - Envie uma requisição `POST` para `/auth/register` com o seguinte corpo JSON
     ```json
     {
       "login": "ADMINISTRADOR"
       "password": "123456789",
       "role": "ADMIN"
     }
     ```
   - Para acessar os endpoints protegidos, você deve primeiro obter um token JWT.
   - Utilize o endpoint `/auth/login` para autenticar e obter o token.
   - Envie uma requisição `POST` para `/auth/login` com o seguinte corpo JSON:
     ```json
     {
       "login": "seu_usuario",
       "password": "sua_senha"
     }
     ```
   - O token JWT será retornado na resposta. Guarde-o e adicione-o aos cabeçalhos das suas requisições para autenticar as próximas chamadas:
     ```
     Authorization: Bearer <seu_token>
     ```

3. **Gerenciamento de Clientes**
   
- OBS: Requisicoes POST, PUT e DELETE requer que o usuário seja ADMIN
  
   - **Listar Clientes**: `GET /api/client` .
   - **Adicionar Cliente**: `POST /api/client` .
   - **Atualizar Cliente**: `PUT /api/client` .
   - **Deletar Cliente**: `DELETE /api/client` .

5. **Gerenciamento de Compras**

- OBS: Requisicoes POST, PUT e DELETE requer que o usuário seja ADMIN
  
   - **Listar Compras**: `GET /api/purchase` .
   - **Adicionar Compra**: `POST /api/purchase` 
   - **Atualizar Compra**: `PUT /api/purchase`
   - **Deletar Compra**: `DELETE /api/purchase`

7. **Gerenciamento de Pagamentos**

- OBS: Requisicoes POST, PUT e DELETE requer que o usuário seja ADMIN

   - **Listar Pagamentos**: `GET /api/payment`
   - **Adicionar Pagamento**: `POST /api/payment`
   - **Atualizar Pagamento**: `PUT /api/payment`
   - **Deletar Pagamento**: `DELETE /api/payment`

9. **Acessando a Documentação Swagger**
   - Acesse a documentação interativa da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
   - A interface Swagger permite testar os endpoints e visualizar os detalhes das requisições.

---

Essas instruções garantem que os usuários possam configurar e usar a API "FiadoSafe" com facilidade, seguindo o formato organizado do `README.md`.
