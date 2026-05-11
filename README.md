# Rewards System API

## Overview

This project is a RESTful API built using Spring Boot to calculate customer reward points based on transactions.

Customers earn:
- 2 points for every dollar spent above $100
- 1 point for every dollar spent between $50 and $100

Example:
- Transaction amount = $120
- Reward points = 90

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- JUnit 5

---

## Project Structure

src/main/java/com/example/telusDemo
│
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
```

---

## API Endpoint

### Get Reward Points

```http
GET /api/rewards/{customerId}
```

Example:

```http
GET /api/rewards/1
```

---

## Sample Response

```json
{
  "custId": "1",
  "monthlyRewards": {
    "MAY": 90,
    "APRIL": 25,
    "MARCH": 0
  },
  "totalRewards": 115
}
```

---

## Database Tables

### users

| Column | Type |
|---|---|
| id | BIGINT |
| name | VARCHAR |
| phone | INT |
| address | VARCHAR |

### transactions

| Column | Type |
|---|---|
| id | BIGINT |
| customer_id | BIGINT |
| amount | DOUBLE |
| transaction_date | DATE |
| meta_data | VARCHAR |

---

## Reward Calculation Logic

- Amount <= 50 → 0 points
- Amount between 51 and 100 → 1 point per dollar
- Amount above 100 → 2 points per dollar above 100

---

## Exception Handling

Implemented:
- CustomerNotFoundException
- GlobalExceptionHandler

Returns meaningful HTTP responses.

---

## Test Coverage

Unit tests added for:
- reward calculation logic
- boundary conditions

Tested scenarios:
- amount below 50
- amount equal to 50
- amount equal to 100
- amount above 100

---

## How To Run

### Clone Repository

```bash
git clone <your-github-url>
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/<your_db>
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### Run Application

```bash
mvn spring-boot:run
```

---

## Run Tests

```bash
mvn test
```

---

## Assumptions

- Rewards are calculated for the last 3 months from current date
- Customer IDs are numeric
- Transactions with amount <= 50 earn no rewards
