import java.sql.*;
import java.util.Scanner;

class MyClass {
    public static void main(String args[]) {

        Statement statement;
        Connection connection = null;
while(true){
        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://10.0.10.3:3306/firstdb", "SBolba", "pass123"
            );

            String createTable = "CREATE TABLE if not exists mecze (druzynaA VARCHAR(30), druzynaB VARCHAR(30), zwyciezca VARCHAR(30));";

            statement = connection.createStatement();

            statement.executeUpdate(createTable);

            Scanner in = new Scanner(System.in);
            while(true) {
                System.out.println("'d' dodaj mecze, 'w' wyswietl wszystkie mecze");
		String wybor = in.nextLine();
                if ("w".equals(wybor)) {
                    statement = connection.createStatement();
                    String zapytanie = "select * from mecze;";
                    ResultSet rs = statement.executeQuery(zapytanie);
                    System.out.println("Mecze:");
                    while (rs.next()) {
                        String druzynaA = rs.getString("druzynaA");
                        String druzynaB = rs.getString("druzynaB");
                        String zwyciezca = rs.getString("zwyciezca");

                        System.out.print(druzynaA);
                        System.out.print("\t");
                        System.out.print(druzynaB);
                        System.out.print("\t");
                        System.out.println(zwyciezca);
                    }
                }
                if ("d".equals(wybor)) {
                    System.out.print("DruzynaA: ");
                    String druzynaA = in.nextLine();
                    System.out.print("DruzynaB: ");
                    String druzynaB = in.nextLine();
                    System.out.print("Zwyciezca: ");
                    String zwyciezca = in.nextLine();

                    statement = connection.createStatement();

                    String zapytanie = "INSERT INTO mecze VALUES('"+druzynaA+"', '"+druzynaB+"', '"+zwyciezca+"');";

                    statement.executeUpdate(zapytanie);
                }
            }
        } catch(Exception e) {
		System.out.println(e);
        }
}
    }
}
