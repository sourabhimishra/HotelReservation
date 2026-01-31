# HotelReservation
Simple Hotel Room Reservation System Using JAVA JDBC
use hotel_db
Database changed
mysql> desc reservations;
+---------------+-------------+------+-----+-------------------+-------------------+
| Field         | Type        | Null | Key | Default           | Extra             |
+---------------+-------------+------+-----+-------------------+-------------------+
| id            | int         | NO   | PRI | NULL              | auto_increment    |
| customer_name | varchar(50) | YES  |     | NULL              |                   |
| room_no       | int         | YES  |     | NULL              |                   |
| check_in      | timestamp   | YES  |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
+---------------+-------------+------+-----+-------------------+-------------------+
4 rows in set (0.09 sec)

mysql> select*from reservations;
+----+---------------+---------+---------------------+
| id | customer_name | room_no | check_in            |
+----+---------------+---------+---------------------+
|  1 | somu          |      12 | 2026-01-31 14:01:23 |
|  2 | roni          |       1 | 2026-01-31 15:42:35 |
+----+---------------+---------+---------------------+
2 rows in set (0.02 sec)
