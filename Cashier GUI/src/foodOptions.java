import javax.swing.*;
import java.awt.*;

public class foodOptions {

    private final JPanel foodOptions = new JPanel();
    public foodOptions(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        foodOptions.setBounds(panelsWidth,topAndBotPanelsHeight,panelsWidth,middlePanelsHeight);
        foodOptions.setBackground(Color.DARK_GRAY);
        frame.add(foodOptions);
    }
}
