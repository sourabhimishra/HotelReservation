import java.sql.*;
import java.util.Scanner;

public class HotelReservation {

    static final String URL = "jdbc:mysql://localhost:3306/hotel_db";
    static final String USER = "root";      
    static final String PASS = "ripan"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            Statement stmt = con.createStatement();

            while (true) {
                System.out.println("\nHOTEL RESERVATION SYSTEM");
                System.out.println("1. Reserve Room");
                System.out.println("2. Allocate Rooms");
                System.out.println("3. Check Out");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter customer name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter room number: ");
                        int room = sc.nextInt();

                        String insert =
                                "INSERT INTO reservations(customer_name, room_no) VALUES (?, ?)";
                        PreparedStatement ps = con.prepareStatement(insert);
                        ps.setString(1, name);
                        ps.setInt(2, room);
                        ps.executeUpdate();

                        System.out.println("Room Reserved Successfully ");
                        break;

                    case 2:
                        ResultSet rs = stmt.executeQuery("SELECT * FROM reservations");

                        System.out.println("\nID | Name | Room | Check-in Time");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + " | " +
                                    rs.getString("customer_name") + " | " +
                                    rs.getInt("room_no") + " | " +
                                    rs.getTimestamp("check_in")
                            );
                        }
                        break;

                    case 3:
                        System.out.print("Enter reservation ID: ");
                        int id = sc.nextInt();

                        String delete = "DELETE FROM reservations WHERE id = ?";
                        PreparedStatement ps2 = con.prepareStatement(delete);
                        ps2.setInt(1, id);
                        ps2.executeUpdate();

                        System.out.println("Checked Out Successfully ");
                        break;

                    case 4:
                        con.close();
                        System.out.println("Thank you!");
                        return;

                    default:
                        System.out.println("Incorrect choice ");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
