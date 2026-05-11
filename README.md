# Java JDBC CRUD Operations 🚀

This project demonstrates basic JDBC operations using Java and MySQL.

---

# 📚 Topics Covered

## ✅ JDBC Driver Loading
- Used `Class.forName()`
- Practiced class loading and object creation
- Understood static block and instance block execution

### Example
```java
Class.forName("jdbcdemo.Demo").newInstance();
```

---

# ✅ Insert Operation
- Inserted records into MySQL database using JDBC.

### Java Code
```java
String sql="INSERT INTO studentInfo (id,sname,sage,scity) VALUES (6,'Meghana',12,'Hyderabad')";
int rowAffect=stmt.executeUpdate(sql);
```

### SQL Query
```sql
INSERT INTO studentInfo (id,sname,sage,scity)
VALUES (6,'Meghana',12,'Hyderabad');
```

---

# ✅ Update Operation
- Updated existing records in database.

### Java Code
```java
String sql="UPDATE studentInfo SET sage=26 WHERE id=2";
int rowAffect=stmt.executeUpdate(sql);
```

### SQL Query
```sql
UPDATE studentInfo
SET sage=26
WHERE id=2;
```

---

# ✅ Delete Operation
- Deleted records from database.

### Java Code
```java
String sql="DELETE FROM studentInfo WHERE id=5";
int rowAffect=stmt.executeUpdate(sql);
```

### SQL Query
```sql
DELETE FROM studentInfo
WHERE id=5;
```

---

# ✅ Retrieve Operation
- Retrieved records from database using `ResultSet`.

### Java Code
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

### SQL Query
```sql
SELECT * FROM studentInfo;
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
src/
│
├── jdbcdemo/
│   └── ClassForNameEx.java
│
├── curd_operations/
│   ├── InsertionOfData.java
│   ├── UpdateDataInDataBase.java
│   ├── DeletionOfRecordInDataBase.java
│   └── RetrivalOfDataFromDatabase.java
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
- executeUpdate()
- executeQuery()
- ResultSet Handling
- CRUD Operations
- Exception Handling
- finally Block
- Resource Closing

---

# 🚀 Learning Outcome
Learned how Java applications communicate with MySQL database using JDBC and performed complete CRUD operations successfully.
