# Spring-Boot-Assignment-Library
Assignment for the course Java Spring and Säker Mjukvara ("Secure Software"). 

# Library System – API Endpoints (Compact Postman Guide)
**Base URL:** http://localhost:8080

## Books (/books)
- **GET /books** → Retrieve all books  
- **GET /books/search?title=Pride** → Search books by title or author  
- **POST /books** → Create a new book  
{
  "title": "Test adding book",
  "publicationYear": 2025,
  "availableCopies": 5,
  "totalCopies": 5,
  "author": { "id": 1 }
}

## Authors (/authors)
- **GET /authors** → Retrieve all authors
- **GET /authors/name/Austen** → Search author by last name
- **POST /authors** → Create a new author
{
  "firstName": "Test",
  "lastName": "Person",
  "birthYear": 1995,
  "nationality": "Swedish"
}

## Users (/users)
- **GET /users/email/klockrehn@example.com** → Get user by email
- **POST /users** → Create a new user
{
  "firstName": "Janne",
  "lastName": "Banan",
  "email": "klockrehn@example.com",
  "password": "password123"
}

## Loans (/loans)
- **GET /users/14/loans** → Get all loans for a user
- **POST /loans?userId=14&bookId=53** → Borrow a book
- **PUT /loans/1/return** → Return a book (change 1 for loanId)
- **PUT /loans/1/extend** → Extend a loan (change 1 for loanId)

## Endpoint Tests for security (Säker Mjukvara) 

### 1. Protected Pages
- **/hello** → Requires login, shows the logged-in user’s role.  
- **/admin-page** → Only accessible for ADMIN.  
- **/user-page** → Accessible for USER and ADMIN.  
- **/public** → Open to everyone.  

### 2. Security Tests
- Try accessing a protected page without login → Redirect to login page.  
- Log in as USER → Access `/admin-page` → Should return **403 Forbidden**.  
- Log in as ADMIN → Access `/admin-page` → Should succeed.  

### 3. Users
- **POST /api/register** → Create a new user.
{
  "firstName": "Anna",
  "lastName": "Andersson",
  "email": "anna@example.com",
  "password": "Test1234"
}
