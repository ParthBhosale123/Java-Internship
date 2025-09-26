# Library Management System - Task 3

## Objective

Develop a mini system to manage books and users using Object-Oriented Programming (OOP) concepts in Java.

## Features

- Add books to the library
- Borrow (issue) books
- Return books
- Display all books with availability status
- Multi-user support (User & Librarian roles)

## OOP Concepts Covered

- **Encapsulation:** Private fields with getters and setters.
- **Abstraction:** `User` class abstracts general user actions.
- **Inheritance:** `Librarian` extends `User`.
- **Polymorphism:** Overridable methods (like `borrowBook`/`returnBook`).
- **Dynamic binding:** Method calls resolved at runtime.
- **Constructor chaining:** `super()` used in `Librarian`.

## Tools Used

- Java 21
- VS Code
- Terminal / Command Prompt

## How to Run

1. Clone the repo

```bash
git clone <your-repo-link>
cd LibraryManagement/src
```
