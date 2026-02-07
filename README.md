# HotelReservation
Simple Hotel Room Reservation System Using JAVA JDBC
Database Structure – hotel_db
This project uses a MySQL database named hotel_db.
The main table used is reservations, which stores hotel room booking details.
 Table: reservations
Column Name
Data Type
Description
id
INT (PK)
Unique reservation ID (auto-incremented)
customer_name
VARCHAR(50)
Name of the customer
room_no
INT
Room number assigned to the customer
check_in
TIMESTAMP
Check-in date and time (defaults to current timestamp)
 Key Information
Primary Key: id
The check_in field is automatically set to the current date and time when a reservation is created.
This table supports basic hotel room reservation operations such as add, view, and delete bookings.
SQL Table Definition
Copy code
Sql
CREATE TABLE reservations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(50),
    room_no INT,
    check_in TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
