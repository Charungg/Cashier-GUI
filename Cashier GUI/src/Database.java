import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

// Using postgresSQL
public class Database {

    Connection conn;
    public Connection connectToDatabase(String dbname,String user, String pass){
        // Allows for this program to query the database.
        conn=null;

        // Programed to connect to the database if it exists and
        // providing the correct username and password.
        try{
            Class.forName("org.postgresql.Driver");
            // Given the connection if the database exist and validated access
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbname,user,pass);
            if (conn!=null){
                System.out.println("Established Link");
            }

            // Indicates either that the database does not exist or failed validation.
            else{
                System.out.println("Connection Failed");
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }

        return conn;
    }

    public void setUpAllTables(){
        createFoodTable();
    }

    public void createFoodTable(){
        String query;
        Statement statement;
        String tableName = "foodItems";

        try{
            if (isTableExist(tableName) == 1){
                query="CREATE TABLE "+tableName+"(food VARCHAR(50), food INT);";
                statement=conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Created a new table, foodItems");
            }

            else{
                System.out.println("Table foodItems already exist");
            }
        }

        catch(Exception e){
            System.out.println("Cannot create table");
        }

    }

    public int isTableExist(String tableName){
        String query;
        Statement statement;

        try{
            query = "SELECT EXISTS(" +
                    " SELECT 1" +
                    " FROM information_schema.tables" +
                    " WHERE table_name ="+tableName +
                    ") AS table_existence;;";

            statement = conn.createStatement();
            return statement.executeUpdate(query);
        }
        catch(Exception e){
            System.out.println("Cannot isTableExist");
        }

        return 0;
    }





}
