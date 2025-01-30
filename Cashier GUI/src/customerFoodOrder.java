import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

public class customerFoodOrder implements ActionListener {

    private final JPanel customerFoodOrder = new JPanel();

    private HashMap<String,Float> foodOptions = new HashMap<>();

    public customerFoodOrder(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight, Connection conn){
        customerFoodOrder.setBounds(0,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        customerFoodOrder.setBackground(Color.lightGray);

        JLabel text = new JLabel("customerFoodOrder");
        customerFoodOrder.add(text);
        frame.add(customerFoodOrder);

        foodOptions = getFoodOptionsFromDatabase(conn);
    }


    public void getFoodOptionsFromDatabase(Connection conn){

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
