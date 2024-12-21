# Overview
This application allows users to manage vendor data, including creating, editing, and deleting vendors. It provides a simple web interface to interact with the vendor list and a backend that handles data manipulation through HTTP requests.

## Setup Instructions

### Prerequisites
To run this application locally, you need:
1. Java Development Kit (JDK) installed (preferably JDK 17).
2. A database system for storing vendor data (PostgreSQL).

### Running the Application:
1. Clone the repository to your local machine
2. Run the application via the IDE (Eclipse or Visual Studio Code).
3. Access the application through a browser at http://localhost:8080.

## Database Setup

This application uses a PostgreSQL database. Below are the instructions to set up the database with the required user credentials.

### Steps to Set Up the Database:
1. **Install PostgreSQL**: If PostgreSQL is not installed, download and install it from [PostgreSQL Official Site](https://www.postgresql.org/download/).
   
2. **Create the Database and User**:
   - Open the PostgreSQL Command Line or use a tool like pgAdmin.
   - Login as the `postgres` superuser:

     ```bash
     psql -U postgres
     ```

   - Create the `vendor` database:

     ```sql
     CREATE DATABASE vendor;
     ```

   - Create the user `postgre` with the password `123`:

     ```sql
     CREATE USER postgre WITH PASSWORD '123';
     ```

3. **Create the Account Table**:
   - To store user accounts, execute the following SQL query to create the `account` table:

     ```sql
     CREATE TABLE account (
         id int8 NOT NULL,
         "password" varchar(255) NULL,
         username varchar(255) NULL,
         CONSTRAINT account_pkey PRIMARY KEY (id),
         CONSTRAINT account_username_key UNIQUE (username)
     );

4. **Create the Vendor Table**:
   - To store vendor, execute the following SQL query to create the vendor table:
     
     ```sql
     CREATE TABLE vendor (
    	  id int8 NOT NULL,
    	  vendorname varchar(255) NULL,
    	  CONSTRAINT vendor_pkey PRIMARY KEY (id)
     );

## Web Page View - Login
![image](https://github.com/user-attachments/assets/bdd91bab-cf72-4760-8c56-8f7e62bfedf8)
