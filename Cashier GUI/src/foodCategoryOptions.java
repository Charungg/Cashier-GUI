import javax.swing.*;
import java.awt.*;

public class foodCategoryOptions {
    private final JPanel foodCategoryOptions = new JPanel();

    public foodCategoryOptions(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        foodCategoryOptions.setBounds(panelsWidth,topAndBotPanelsHeight+middlePanelsHeight,panelsWidth,topAndBotPanelsHeight);
        foodCategoryOptions.setBackground(Color.lightGray);
        frame.add(foodCategoryOptions);
    }
}
