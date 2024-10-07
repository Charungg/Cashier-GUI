import javax.swing.*;
import java.awt.*;

public class customerFoodOrder {

    private final JPanel customerFoodOrder = new JPanel();
    public customerFoodOrder(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        customerFoodOrder.setBounds(0,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        customerFoodOrder.setBackground(Color.lightGray);
        frame.add(customerFoodOrder);
    }
}
