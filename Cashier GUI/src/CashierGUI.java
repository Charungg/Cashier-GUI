import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Note maybe make the top bar and bottom bar different size.
// So the top bar can be smaller than the bottom bar because food category will take a lot of space

public class CashierGUI extends JFrame implements ActionListener {

    private int screenWidth;
    private int screenHeight;

    CashierGUI(){
        acquireScreenSize();
        setUpGUIPanelSizes();
        GUISetVisible();
    }

    public void acquireScreenSize(){
        // Laptop screen size = 1440 x 900 (But upscale by 2x to 2880x1800)

//        // Limitation:
//        // Doesn't work on multi-monitor setup.
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        screenWidth = (int) screenSize.getWidth();
//        screenHeight = (int) screenSize.getHeight();

        // Turns out the window bar takes some space from the resolution, so I have to take it into consideration
        Rectangle trueWindowSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        screenWidth = trueWindowSize.width;
        screenHeight = trueWindowSize.height;


        System.out.println("Screen size = " + screenWidth + " x " + screenHeight);
    }

    public void setUpGUIPanelSizes(){
        this.setSize(screenWidth,screenHeight);

        final int panelsWidth = screenWidth/2;
        final int topAndBotPanelsHeight = (int)(Math.round(screenHeight * 0.2));
        final int middlePanelsHeight = (int)(Math.round(screenHeight * 0.6));
        System.out.println("PanelsWidth | topAndBotPanelsHeight | middlePanelsHeight \n " +
                            panelsWidth + " | " + topAndBotPanelsHeight + " | " + middlePanelsHeight);

        new customerOrderToolBar(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        new foodSearchToolBar(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        new customerFoodOrder(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        new foodCategoryOptions(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        new foodOptions(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

        new customerInformation(this, panelsWidth, topAndBotPanelsHeight, middlePanelsHeight);

    }
    public void GUISetVisible(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
