// Using postgresSQL
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Queue;

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


    public ResultSet executeQuery(Connection conn, String query) {
        Statement stmt = null;

        try{
            stmt = conn.createStatement();
            stmt.executeQuery(query);
            return stmt.getResultSet();
        }

        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }


    // Food Table Functions

    public void createFoodTable(Connection conn){
        String query = "CREATE TABLE foodTable (foodID SERIAL, foodName VARCHAR(100), foodPrice INTEGER, UNIQUE(foodName))";
        if (executeUpdate(conn, query)){
            System.out.println("foodTable created");
        }
    }



    public void insertFoodTable(Connection conn, String foodName, int foodPrice){
        String query = String.format("INSERT INTO foodTable(foodName, foodPrice) values('%s','%s')", foodName, foodPrice);
        if (executeUpdate(conn, query)){
            System.out.println(String.format("foodTable inserted with ('%s','%s')", foodName, foodPrice));
        }
    }


    // Customer Table Functions

    public void createCustomerTable(Connection conn){
        String query = "CREATE TABLE customerTable (customerID SERIAL, customerFullNameID INTEGER references customerFullNameTable(customerFullNameID), customerAddressID INTEGER, UNIQUE(customerFullNameID, customerAddressID), PRIMARY KEY(customerID))";
        if (executeUpdate(conn, query)){
            System.out.println("customerTable created");
        }
    }


    // Customer Full Name Table Functions

    public void createCustomerFullNameTable(Connection conn){
        String query = "CREATE TABLE customerFullNameTable (customerFullNameID SERIAL, customerFirstName VARCHAR(100), customerSurname VARCHAR(100), UNIQUE(customerFirstName, customerSurname), PRIMARY KEY (customerFullNameID))";
        if (executeUpdate(conn, query)){
            System.out.println("customerFullNameTable created");
        }
    }


    // Address Table Functions

    public void createAddressTable(Connection conn){
        String query = "CREATE TABLE addressTable (addressID SERIAL, houseNumber INTEGER, addressPostCodeID INTEGER REFERENCES addressPostCodeTable(addressPostCodeID), UNIQUE(houseNumber,addressPostCodeID), PRIMARY KEY (addressID))";
        if (executeUpdate(conn, query)){
            System.out.println("addressTable created");
        }
    }


    public void insertAddressTable(Connection conn, int houseNumber, String addressName, String postCode){
        int addressPostCodeID;
        ResultSet addressPostCodeIDResult;
        String getAddressPostCodeIDQuery = String.format("SELECT addressPostCodeID FROM addressPostCodeTable WHERE addressName = '%s' AND postCode = '%s'", addressName, postCode);


        if (!isAddressPostCodeExist(conn, addressName, postCode)){
            insertAddressPostCodeTable(conn, addressName, postCode);
        }

        addressPostCodeIDResult = executeQuery(conn, getAddressPostCodeIDQuery);

        try{
            addressPostCodeIDResult.next();
            addressPostCodeID = addressPostCodeIDResult.getInt(1);
            String insertAddressQuery = String.format("INSERT INTO addressTable(houseNumber, addressPostCodeID) VALUES ('%s','%d')", houseNumber, addressPostCodeID);
            executeUpdate(conn, insertAddressQuery);
            System.out.println(String.format("addressTable inserted with (%d, %d)", houseNumber, addressPostCodeID));
        }

        catch (Exception e){
            System.out.println(e);
        }


    }


    // AddressPostCodeTable

    public void createAddressPostCodeTable(Connection conn){
        String query = "CREATE TABLE addressPostCodeTable (addressPostCodeID SERIAL, addressName VARCHAR(100), postCode VARCHAR(8), UNIQUE(addressName, postCode), PRIMARY KEY (addressPostCodeID))";
        if (executeUpdate(conn, query)){
            System.out.println("addressPostCodeTable created");
        }
    }


    public void insertAddressPostCodeTable(Connection conn, String addressName, String postCode){
        String query = String.format("INSERT INTO addressPostCodeTable(addressName, postCode) values('%s', '%s')", addressName, postCode);
        if (executeUpdate(conn, query)){
            System.out.println(String.format("addressPostCodeTable inserted with (%s, %s)", addressName, postCode));
        }
    }


    public boolean isAddressPostCodeExist(Connection conn, String addressName, String postCode){
        String queryResult;
        ResultSet isAddressAndPostCodeExistResult;
        boolean isDataInDatabase = false;
        String query = String.format("SELECT EXISTS(SELECT 1 FROM addressPostCodeTable WHERE addressName = '%s' AND postCode = '%s')", addressName, postCode);

        try{
            isAddressAndPostCodeExistResult = executeQuery(conn, query);
            isAddressAndPostCodeExistResult.next();
            queryResult = isAddressAndPostCodeExistResult.getString(1);

            if (queryResult.equals("t")){
                System.out.println(String.format("addressPostCodeTable exist with (%s, %s)", addressName, postCode));
                isDataInDatabase = true;
            }

            else {
                System.out.println(String.format("addressPostCodeTable does not exist with (%s, %s)", addressName, postCode));
            }
        }

        catch(Exception e){
            System.out.println(e);
        }

        return isDataInDatabase;
    }


    // Drop Table Functions

    public void dropALL(Connection conn){
        String query = "DROP TABLE foodTable";
        executeUpdate(conn, query);

        query = "DROP TABLE customerTable";
        executeUpdate(conn, query);

        query = "DROP TABLE customerFullNameTable";
        executeUpdate(conn, query);

        query = "DROP TABLE addressTable";
        executeUpdate(conn, query);

        query = "DROP TABLE addressPostCodeTable";
        executeUpdate(conn, query);
    }


    // Testing Database Functions

    public void testDatabase() {
        Connection conn = null;
        conn = connectToDatabase("Lok", "postgres", "Saraba");

        dropALL(conn);

        createFoodTable(conn);
        createCustomerFullNameTable(conn);
        createAddressPostCodeTable(conn);

        createAddressTable(conn);
        createCustomerTable(conn);

        insertAddressPostCodeTable(conn, "Redwood Way", "LS19 7JU");
        isAddressPostCodeExist(conn, "Redwood Way", "LS19 7JU");

        insertAddressPostCodeTable(conn, "Penglais", "SY23 3LH");
        isAddressPostCodeExist(conn, "Penglais", "SY23 3LH");

        System.out.println();

        insertAddressTable(conn, 59, "Redwood Way", "LS19 7JU");
        insertAddressTable(conn, 21, "Penglais", "SY23 3LH");
        insertAddressTable(conn, 23, "Redwood Way", "LS19 7JU");
        insertAddressTable(conn, 24, "Redwood Way", "LS19 7JU");
        insertAddressTable(conn, 33, "Penglais", "SY23 3LH");
        insertAddressTable(conn, 5, "Penglais", "SY23 3LH");
    }
}
