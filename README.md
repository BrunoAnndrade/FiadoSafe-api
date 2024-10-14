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

1- Clone o repositório.
2- Certifique-se de que o MongoDB Compass esteja rodando localmente mongodb://localhost:27017/Fiado-Safe.

## Instruções de Uso Localmente

### Acessando a API

1. **Autenticação**
   - Registrar um usuário
     ```json
     {
       "login": "ADMINISTRADO
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
   - **Listar Clientes**: `GET /api/client`
     - Requer a função `ADMIN` ou `USER`.
   - **Adicionar Cliente**: `POST /api/client`
     - Requer a função `ADMIN`.
   - **Atualizar Cliente**: `PUT /api/client`
     - Requer a função `ADMIN`.
   - **Deletar Cliente**: `DELETE /api/client`
     - Requer a função `ADMIN`.

4. **Gerenciamento de Compras**
   - **Listar Compras**: `GET /api/purchase`
     - Requer a função `ADMIN` ou `USER`.
   - **Adicionar Compra**: `POST /api/purchase`
     - Requer a função `ADMIN`.
   - **Atualizar Compra**: `PUT /api/purchase`
     - Requer a função `ADMIN`.
   - **Deletar Compra**: `DELETE /api/purchase`
     - Requer a função `ADMIN`.

5. **Gerenciamento de Pagamentos**
   - **Listar Pagamentos**: `GET /api/payment`
     - Requer a função `ADMIN` ou `USER`.
   - **Adicionar Pagamento**: `POST /api/payment`
     - Requer a função `ADMIN`.
   - **Atualizar Pagamento**: `PUT /api/payment`
     - Requer a função `ADMIN`.
   - **Deletar Pagamento**: `DELETE /api/payment`
     - Requer a função `ADMIN`.

6. **Acessando a Documentação Swagger**
   - Acesse a documentação interativa da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
   - A interface Swagger permite testar os endpoints e visualizar os detalhes das requisições.

---

Essas instruções garantem que os usuários possam configurar e usar a API "FiadoSafe" com facilidade, seguindo o formato organizado do `README.md`.
