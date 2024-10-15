# FiadoSafe-API

## Descrição

FiadoSafe é uma API desenvolvida para gerenciar o sistema de contas "fiado" de forma segura e eficiente. O sistema permite gerenciar clientes, compras, pagamentos e dívidas de maneira fácil, com suporte a autenticação e autorização utilizando JWT. 

### Construído com
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/-MongoDB-13aa52?style=for-the-badge&logo=mongodb&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

### Por que FiadoSafe?
O objetivo é fornecer uma solução de gerenciamento de dívidas e pagamentos que seja simples de usar, mas que também garanta segurança e escalabilidade. Com a API, pequenos comerciantes podem manter o controle de contas pendentes e gerenciar melhor suas finanças.

---

## Instruções de Instalação

### Pré-requisitos

![Java11](https://img.shields.io/badge/Java-11-blue)
![Maven3.9.9](https://img.shields.io/badge/Maven-3.9.9-blue)

- Docker é opcional caso queira rodar em container.

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



MIT License

Copyright (c) 2024 Bruno Andrade

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
