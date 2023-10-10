import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsRunner
{

    public static void main(String[] args)
    {

        JFrame frame = new RockPaperScissorsFrame();

        // get screen dimensions
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        // center frame in screen
        frame.setSize(screenWidth / 2, screenHeight / 2);
        frame.setLocation(screenWidth / 4, screenHeight / 4);
        // set frame icon and title
        Image img = kit.getImage("icon.gif");
        frame.setIconImage(img);
        frame.setTitle("CenteredFrame");
    }

}
