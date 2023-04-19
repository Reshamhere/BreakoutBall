import javax.swing.JFrame;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame obj=new JFrame();
        Gameplay gamePlay = new Gameplay();

        obj.setBounds(400, 150, 700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);
        obj.setVisible(true);

    }

}
