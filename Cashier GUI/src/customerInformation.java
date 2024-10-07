import javax.swing.*;
import java.awt.*;

public class customerInformation {

    private final JPanel customerInformation = new JPanel();
    public customerInformation(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        customerInformation.setBounds(0,topAndBotPanelsHeight+middlePanelsHeight,panelsWidth,topAndBotPanelsHeight);
        customerInformation.setBackground(Color.DARK_GRAY);
        frame.add(customerInformation);
    }
}
