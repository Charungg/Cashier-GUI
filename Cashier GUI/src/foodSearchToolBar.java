import javax.swing.*;
import java.awt.*;

public class foodSearchToolBar {

    private final JPanel foodSearchToolBar = new JPanel();
    public foodSearchToolBar(CashierGUI frame, int panelsWidth, int topAndBotPanelsHeight, int middlePanelsHeight){
        foodSearchToolBar.setBounds(panelsWidth,0,panelsWidth,topAndBotPanelsHeight) ;
        foodSearchToolBar.setBackground(Color.GRAY);

    }
}
