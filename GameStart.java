import javax.swing.*;
import java.awt.*;

public class GameStart {
    GameStart(){
        JFrame startFrame = new JFrame("Red Light Rush");
        startFrame.setSize(650, 500);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setLayout(null);
        startFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        startFrame.setResizable(false);
        startFrame.setLocationRelativeTo(null);

        ImageIcon bg = new ImageIcon("images/red_rush_ui.png");
        JLabel background = new JLabel(bg);
        background.setBounds(0, 0, 650, 500);
        background.setLayout(null);

        // start button 
        ImageIcon buttonImg = new ImageIcon("images/start_game.png");
        Image b = buttonImg.getImage().getScaledInstance(200, 60, Image.SCALE_SMOOTH);
        JButton start = new JButton();
        start.setIcon(new ImageIcon(b));
        start.setBounds(225, 350, 200, 60);
        start.setFont(new Font("Arial", Font.BOLD, 24));
        start.setFocusPainted(false);

        start.addActionListener(e -> {
            new Game();
            startFrame.dispose();
        });

        background.add(start);
        // startFrame.add(start);
        startFrame.add(background);
        startFrame.setVisible(true);

    }

}
