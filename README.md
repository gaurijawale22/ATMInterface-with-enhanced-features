# Advanced ATM Interface

An advanced ATM interface implemented in Java with internationalization support. This project demonstrates a simple console-based ATM system with enhanced security features and multiple language support.

## Features

- User authentication with PIN hashing
- Account lockout after multiple failed login attempts
- Balance inquiry
- Withdraw funds
- Deposit funds
- Transfer funds between accounts
- Transaction history
- Internationalization support (English and Spanish)

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Git (optional, for cloning the repository)

### Installation

1. **Clone the repository:**

    ```bash
    git clone https://github.com/yourusername/advanced-atm-interface.git
    cd advanced-atm-interface
    ```

2. **Compile the Java files:**

    ```bash
    javac src/*.java
    ```

3. **Run the application:**

    ```bash
    java -cp src ATMInterface
    ```

## Usage

### Main Menu

1. **Login**
2. **Exit**

### Account Menu (after successful login)

1. **Check Balance**
2. **Withdraw**
3. **Deposit**
4. **Transfer**
5. **Logout**

### Internationalization

To run the application in Spanish, modify the `Locale` parameter in the `main` method:

```java
public static void main(String[] args) {
    ATM atm = new ATM(); // Assume ATM is initialized and loaded with user data
    ATMInterface atmInterface = new ATMInterface(atm, Locale.forLanguageTag("es"));
    atmInterface.showMainMenu();
}
