import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerFoodOrder implements ActionListener {

    private final JPanel customerFoodOrder = new JPanel();
    public customerFoodOrder(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        customerFoodOrder.setBounds(0,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        customerFoodOrder.setBackground(Color.lightGray);

        JLabel text = new JLabel("customerFoodOrder");

        customerFoodOrder.add(text);
        frame.add(customerFoodOrder);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
