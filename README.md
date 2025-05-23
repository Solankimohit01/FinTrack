# 💰 FinTrack - Personal Expense Tracker (CLI - Java)

**FinTrack** is a Java-based command-line application for tracking personal income and expenses. It's built using standard Java, with JDBC for MySQL database operations. Developed in IntelliJ IDEA.

---

## 🚀 Features

- Add and view income entries
- Add and view expense entries
- Categorize expenses
- Monthly report generation
- Persistent storage using MySQL
- Clean modular codebase (MVC structure)

---

## 📂 Project Structure

```

FinTrack/
├── .idea/                   # IntelliJ IDEA config files
├── out/                     # Compiled output directory
│   ├── artifacts/           # Generated JAR/EXE
│   └── production/          # Compiled class files
├── src/
│   ├── com.tracker/
│   │   ├── model/           # Data classes (Income, Expense)
│   │   ├── service/         # Business logic (ExpenseService, IncomeService)
│   │   ├── util/            # Utility (DBUtil, InputValidator)
│   │   └── Main.java        # Entry point
│   └── META-INF/
├── FinTrack.iml             # IntelliJ module file
├── FinTrack.xml             # IntelliJ artifact settings
└── .gitignore

````

---

## 🛠️ Technologies Used

- Java 17+
- MySQL (JDBC)
- IntelliJ IDEA
- Maven (optional for future)
- Console-based CLI UI

---

## 🧑‍💻 How to Run

### 💻 Run via IntelliJ IDEA

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Configure the MySQL JDBC connector if not already:
   - File → Project Structure → Libraries → Add mysql-connector-j-x.x.x.jar
4. Create a MySQL database:
   ```sql
   CREATE DATABASE fintrack_db;
````

5. Update your DB credentials in `DBUtil.java`.
6. Run `Main.java` via right-click → Run 'Main.main()'.

### ☕ Run via Command Line

1. Navigate to the `out/artifacts/FinTrack_jar` folder.
2. Run:

   ```bash
   java -jar FinTrack.jar
   ```

---

## 📝 Database Schema (MySQL)

```sql
CREATE TABLE income (
  id INT AUTO_INCREMENT PRIMARY KEY,
  source VARCHAR(100),
  amount DECIMAL(10,2),
  date DATE
);

CREATE TABLE expense (
  id INT AUTO_INCREMENT PRIMARY KEY,
  category VARCHAR(100),
  amount DECIMAL(10,2),
  date DATE,
  description TEXT
);
```

---

## ✅ To Do

* [ ] Export reports as CSV
* [ ] Add user authentication
* [ ] Monthly chart visualization (future GUI version)

---

## 📌 Author

* **Mohit** – *Developer*

---

## 📃 License

This project is open source and available under the [MIT License](LICENSE).

```

---
