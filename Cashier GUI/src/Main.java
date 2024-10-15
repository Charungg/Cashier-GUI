// Features to implement:
//   * Map delivery feature to calculate distance and cost (With dijkstra)
//   * Database of orders and customers history


public class Main {

    public static void main(String[] args) {
        Database db = new Database();
        db.connectToDatabase("Cashier Database","postgres","DIU2024");
        db.setUpAllTables();
        new CashierGUI();
    }
}