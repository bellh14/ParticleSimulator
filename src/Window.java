import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Window extends Canvas {



    public Window(int width, int height, Engine engine) {
        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(engine);
        frame.setVisible(true);
        engine.start();
    }


}
