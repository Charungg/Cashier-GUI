import javax.swing.*;
import java.awt.*;

public class customerOrderToolBar {

    private final JPanel customerOrderToolBar = new JPanel();
    public customerOrderToolBar(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        customerOrderToolBar.setBounds(0,topAndBotPanelsHeight+middlePanelsHeight,panelsWidth,topAndBotPanelsHeight);
        customerOrderToolBar.setBackground(Color.DARK_GRAY);
        frame.add(customerOrderToolBar);

    }

}
