# Spring-Boot-Assignment-Library
Assignment for the course Java Spring. 

Here is a compact version of my Postman calls, please test for yourself!
Base URL for all requests: http://localhost:8080

Postman API Requests – Library System
Books (/books):

GET /books
Retrieve all books

GET /books/search?title=Pride
Search books by title or author

POST /books
Create a new book
{
  "title": "Test adding book",
  "publicationYear": 2025,
  "availableCopies": 5,
  "totalCopies": 5,
  "author": {
    "id": 1
  }
}

Authors (/authors):

GET /authors
Retrieve all authors

GET /authors/name/Austen
Search author by last name

POST /authors
Create a new author
{
  "firstName": "Test",
  "lastName": "Person",
  "birthYear": 1995,
  "nationality": "Swedish"
}

Users (/users):

GET /users/email/klockrehn@example.com
Get user by email

POST /users
Create a new user
{
  "firstName": "Janne",
  "lastName": "Banan",
  "email": "klockrehn@example.com",
  "password": "password123"
}

Loans (/loans)

GET /users/14/loans
Get all loans for a user

POST /loans?userId=14&bookId=53
Borrow a book

PUT /loans/1/return (Change 1 for the loanId!)
Return a book

PUT /loans/1/extend (Change 1 for the loanId!)
Extend a loan
