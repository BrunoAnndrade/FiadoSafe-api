# FiadoSafe-API

## Description

FiadoSafe is an API developed to securely and efficiently manage the "fiado" credit account system. The system allows for easy management of customers, purchases, payments, and debts, with support for authentication and authorization using JWT.

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/-MongoDB-13aa52?style=for-the-badge&logo=mongodb&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=JSON%20web%20tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2CA5E0?style=for-the-badge&logo=docker&logoColor=white)

### Why FiadoSafe?

The goal is to provide a debt and payment management solution that is easy to use while also ensuring security and scalability. With the API, small business owners can keep track of outstanding accounts and better manage their finances.

---

## Installation

### Prerequisites 

![Java11](https://img.shields.io/badge/Java-11-blue)
![Maven3.9.9](https://img.shields.io/badge/Maven-3.9.9-blue)

- Docker é opcional caso queira rodar em container.

1. Clone the repository:
   
```bash
git clone https://github.com/your-username/project-name.git
```

2. Install dependencies with Maven
3. Install [MongoCompass](https://www.mongodb.com/try/download/compass)
   
### Accessing the API

- Start the application with Maven
- Make sure that MongoDB Compass is running locally at mongodb://localhost:27017/Fiado-Safe.

1. **Authentication**
The API uses Spring Security for authentication control. The following roles are available:

```
ROLE_USER - Standard user role for logged-in users.
ROLE_ADMIN - Admin role for managing partners (registering new partners).
```
To access protected endpoints as an ADMIN user, provide the appropriate authentication credentials in the request header.

```json
     {
       "login": "ADMINISTRADOR"
       "password": "123456789",
       "role": "ADMIN"
     }
```
- To access the protected endpoints, you must first obtain a JWT token.
- Use the /auth/login endpoint to authenticate and obtain the token.
- Send a POST request to /auth/login with the following JSON body: 
 ```json
     {
       "login": "user",
       "password": "password"
     }
```
- The JWT token will be returned in the response. Store it and add it to the headers of your requests to authenticate subsequent calls:
 ```
     Authorization: Bearer <token>
```
- NOTE: POST, PUT, and DELETE requests require the user to be ADMIN

3. **Clients Management**
   
   - **List Clients**: `GET /api/client` .
   - **Add Client**: `POST /api/client` .
   - **Update Client**: `PUT /api/client` .
   - **Delete Client**: `DELETE /api/client` .

5. **Purchases Management**
  
   - **List Purchases**: `GET /api/purchase` .
   - **Add Purchase**: `POST /api/purchase` 
   - **Update Purchase**: `PUT /api/purchase`
   - **Delete Purchase**: `DELETE /api/purchase`

7. **Payments Management**

   - **List Payments**: `GET /api/payment`
   - **Add Payment**: `POST /api/payment`
   - **Update Payment**: `PUT /api/payment`
   - **Delete Payment**: `DELETE /api/payment`

9. **Accessing the Swagger Documentation**
   - Access the interactive API documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).
   - The Swagger interface allows you to test the endpoints and view the details of the requests

---

![MT LICENCE](https://img.shields.io/badge/license-MIT-blue)

## Contact: Bruno Andrade (follow me on [Linkedin](https://www.linkedin.com/in/brunoanndrad/))
