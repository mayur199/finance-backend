# Finance Backend

A backend application for managing financial records, user roles, and dashboard summaries. Built with **Spring Boot** and **MySQL**, this project demonstrates proper **API design**, **role-based access control**, **data validation**, and **CRUD operations** for financial data.

## Features

- **User and Role Management**
  - Create and manage users
  - Assign roles: Viewer, Analyst, Admin
  - Role-based access control for actions

- **Financial Records Management**
  - Create, read, update, and delete financial records
  - Fields: amount, type (income/expense), category, date, notes
  - Filter records by date, category, and type

- **Dashboard Summary APIs**
  - Total income, total expenses, net balance
  - Category-wise totals
  - Recent activity, monthly/weekly trends

- **Validation and Error Handling**
  - Input validation with DTOs
  - Proper HTTP status codes and error messages

- **Data Persistence**
  - MySQL database

## Technology Stack

- **Backend:** Java, Spring Boot  
- **Database:** MySQL  
- **Tools:** Eclipse/STS, Postman  

## Setup Instructions

1. Clone the repository:
```bash
git clone https://github.com/mayur199/finance-backend.git
