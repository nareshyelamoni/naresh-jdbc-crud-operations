# Java JDBC CRUD Operations 🚀

This project demonstrates basic JDBC operations using Java and MySQL.

---

# 📚 Topics Covered

## ✅ First Day Work

### 🔹 JDBC Driver Loading
- Used `Class.forName()`
- Practiced class loading and object creation
- Understood static block and instance block execution

### Example
```java
Class.forName("jdbcdemo.Demo").newInstance();
```

---

### 🔹 Insert Operation
- Inserted records into MySQL database using JDBC.

#### Java Code
```java
String sql="INSERT INTO studentInfo (id,sname,sage,scity) VALUES (6,'Meghana',12,'Hyderabad')";
int rowAffect=stmt.executeUpdate(sql);
```

#### SQL Query
```sql
INSERT INTO studentInfo (id,sname,sage,scity)
VALUES (6,'Meghana',12,'Hyderabad');
```

---

### 🔹 Update Operation
- Updated existing records in database.

#### Java Code
```java
String sql="UPDATE studentInfo SET sage=26 WHERE id=2";
int rowAffect=stmt.executeUpdate(sql);
```

#### SQL Query
```sql
UPDATE studentInfo
SET sage=26
WHERE id=2;
```

---

### 🔹 Delete Operation
- Deleted records from database.

#### Java Code
```java
String sql="DELETE FROM studentInfo WHERE id=5";
int rowAffect=stmt.executeUpdate(sql);
```

#### SQL Query
```sql
DELETE FROM studentInfo
WHERE id=5;
```

---

### 🔹 Retrieve Operation
- Retrieved records from database using `ResultSet`.

#### Java Code
```java
String sql="SELECT * FROM studentInfo";
ResultSet rs=stmt.executeQuery(sql);

while (rs.next()){
    System.out.println(
        rs.getInt("id")+" "+
        rs.getString("sname")+" "+
        rs.getInt("sage")+" "+
        rs.getString("scity")
    );
}
```

#### SQL Query
```sql
SELECT * FROM studentInfo;
```

---

# ✅ Second Day Work

## 🔹 CRUD Operations Using execute() Method

### ➕ Insert Operation using execute()

```java
String sql="INSERT INTO studentInfo(id,sname,sage,scity)VALUES(7,'Mahesh',27,'Hyderabad')";
boolean status=stmt.execute(sql);
```

---

### 📖 Retrieve Operation using execute()

```java
String sql="SELECT * FROM studentInfo Where sage>18";
boolean status=stmt.execute(sql);
```

---

# ✅ PreparedStatement Operations

## ➕ Insert Data using PreparedStatement

```java
String sql="INSERT INTO studentInfo(id,sname,sage,scity)VALUES(?,?,?,?)";
pstmt=connect.prepareStatement(sql);
```

---

## ✏️ Update Data using PreparedStatement

```java
String sql="UPDATE studentInfo SET scity=? WHERE id=?";
```

---

## ❌ Delete Data using PreparedStatement

```java
String sql="DELETE FROM studentInfo WHERE id=?";
```

---

## 📖 Retrieve Data using PreparedStatement

```java
String sql="SELECT * FROM studentInfo WHERE id=?";
```

---

# ✅ Batch Update

- Learned batch processing using JDBC.

### Example
```java
pstmt.addBatch();
int[] arr=pstmt.executeBatch();
```

---

# ✅ Utility Class

## JdbcUtil.java
- Centralized database connection logic
- Reusable connection method
- Reusable resource closing method

### Methods
```java
getConnection()
closeConnection()
```

---

# 🛠 Technologies Used
- Java
- JDBC
- MySQL
- IntelliJ IDEA

---

# 📂 Project Structure

```text
jdbcdemo

crud_operations

crud_operation_by_prepare_statement
```

---

# 💻 Database Configuration

## Database Name
```sql
jdbclearning
```

## Table Name
```sql
studentInfo
```

---

# 🎯 Concepts Practiced
- JDBC Driver Loading
- Database Connectivity
- Statement Interface
- PreparedStatement
- execute()
- executeUpdate()
- executeQuery()
- Batch Processing
- ResultSet Handling
- CRUD Operations
- Utility Class
- Exception Handling
- finally Block
- Resource Closing

---

# 🚀 Learning Outcome
Learned how Java applications communicate with MySQL database using JDBC and performed CRUD operations using Statement, PreparedStatement, execute methods, and Batch Updates successfully.
