// Using postgresSQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    public Connection connectToDatabase(String dbName, String userName, String password) {
        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbName, userName, password);

            if (conn != null) {
                System.out.println("Connected to PostgreSQL database");
            }

            else {
                System.out.println("Failed to connect to PostgreSQL database");
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

        return conn;
    }


    public boolean executeUpdate(Connection conn, String query) {
        Statement stmt = null;

        try{
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            return true;
        }

        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    public boolean executeQuery(Connection conn, String query) {
        Statement stmt = null;

        try{
            stmt = conn.createStatement();
            stmt.executeQuery(query);
            return true;
        }

        catch(Exception e){
            System.out.println(e);
            return false;
        }
    }


    // Food Table Functions

    public void createFoodTable(Connection conn){
        String query = "CREATE TABLE foodTable (foodID INTEGER, foodName VARCHAR(100), foodPrice INTEGER, UNIQUE(foodName))";
        if (executeUpdate(conn, query)){
            System.out.println("foodTable created");
        }
    }



    public void insertFoodTable(Connection conn, String foodName, int foodPrice){
        String query = String.format("insert into foodTable(foodName, foodPrice) values('%s','%s')", foodName, foodPrice);
        if (executeUpdate(conn, query)){
            System.out.println(String.format("foodTable inserted with ('%s','%s')", foodName, foodPrice));
        }
    }


    // Customer Table Functions

    public void createCustomerTable(Connection conn){
        String query = "CREATE TABLE customerTable (customerID INTEGER, customerFullNameID INTEGER references customerFullNameTable(customerFullNameID), customerAddressID INTEGER, UNIQUE(customerFullNameID, customerAddressID), PRIMARY KEY(customerID))";
        if (executeUpdate(conn, query)){
            System.out.println("customerTable created");
        }
    }


    // Customer Full Name Table Functions

    public void createCustomerFullNameTable(Connection conn){
        String query = "CREATE TABLE customerFullNameTable (customerFullNameID INTEGER, customerFirstName VARCHAR(100), customerSurname VARCHAR(100), UNIQUE(customerFirstName, customerSurname), PRIMARY KEY (customerFullNameID))";
        if (executeUpdate(conn, query)){
            System.out.println("customerFullNameTable created");
        }
    }


    // Address Table Functions

    public void createAddressTable(Connection conn){
        String query = "CREATE TABLE addressTable (addressID INTEGER, houseNumber INTEGER, addressName VARCHAR(100), postCode VARCHAR(8), UNIQUE(houseNumber, addressName), PRIMARY KEY (addressID))";
        if (executeUpdate(conn, query)){
            System.out.println("addressTable created");
        }
    }


    // Drop Table Functions

    public void dropALL(Connection conn){
        String query = "DROP TABLE foodTable;";
        executeUpdate(conn, query);

        query = "DROP TABLE customerTable;";
        executeUpdate(conn, query);

        query = "DROP TABLE customerFullNameTable;";
        executeUpdate(conn, query);

        query = "DROP TABLE addressTable;";
        executeUpdate(conn, query);
    }
}
