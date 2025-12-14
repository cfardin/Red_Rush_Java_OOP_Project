import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Game implements KeyListener {

    int x = 125, y = 300;
    JLabel car;
    JLabel enemy1, enemy2, enemy3, enemy4;
    JLabel ambulence;

    // other car positions
    int e1x = 40, e1y = 500; 
    int e2x = 190, e2y = -120;
    int e3x = 100, e3y = -200;
     // emergency car positions
    int ex = 20, ey = 500;

    // other car positions
    int[] lanes = {20, 80, 140, 200};
    int[] safeSpawnY = {-80, -220, -360, -500};

    Random ran = new Random();

    // int e1x, e1y; 
    // int e2x, e2y;
    // int e3x, e3y;
    //  // emergency car positions
    // int ex, ey;


    // Score system varable : 
    int score = 0;
    // int highScore = 0;

    JLabel scorLabel, highScoreLabel;
    JLabel scoreBoard;

    RoadPanel road;
   // RoadPanel emargencyRoad;
    Timer timer;

    Game() {

        // UI design 
        JFrame frame = new JFrame("Red Light Rush");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);


        ImageIcon leftIcon = new ImageIcon("images/l.png");
        JLabel leftLabel = new JLabel(leftIcon);
        leftLabel.setBounds(0, 0, 180, 500);
        leftLabel.setLayout(null);
        
        ImageIcon rightIcon = new ImageIcon("images/r.png");
        JLabel rightLabel = new JLabel(rightIcon);
        rightLabel.setBounds(465, 0, 170, 500);
        rightLabel.setLayout(null);
      

        // Score board; 
        JPanel boardPanel = new JPanel();
        boardPanel.setBounds(4, 10, 155, 60);
        boardPanel.setLayout(null);
        boardPanel.setOpaque(false);

        JPanel scoreBoard = new JPanel();
        scoreBoard.setBounds(0, 0, 155, 60);
        scoreBoard.setBackground(Color.DARK_GRAY);
        scoreBoard.setLayout(null);

        // Score systme : 
        scorLabel = new JLabel("Score : 0");
        scorLabel.setBounds(10, 10, 200, 25);
        scorLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scorLabel.setForeground(Color.white);
    
        int highScore = ScoreSystem.loadHighscore();
        highScoreLabel = new JLabel("Highest Score : " + highScore);
        highScoreLabel.setBounds(10, 35, 200, 25);
        highScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        highScoreLabel.setForeground(Color.white);
        // frame.add(highScoreLabel);

        scoreBoard.add(scorLabel);
        scoreBoard.add(highScoreLabel);
        boardPanel.add(scoreBoard);
        // frame.add(boardPanel);
        leftLabel.add(boardPanel);

        frame.add(leftLabel);
        frame.add(rightLabel);


     
        // Road
        road = new RoadPanel();
        road.setBounds(165, 0, 300, 500);
        road.setBackground(Color.DARK_GRAY);
        road.setLayout(null);
        frame.add(road);

     
        // My Car
        car = new JLabel();
        // car.setBackground(Color.DARK_GRAY);
        car.setBackground(Color.white);
        // car.setOpaque(true);
        // car.setBounds(150, 300, 40, 80); //// Original Code 
         car.setBounds(150, 300, 40, 80); //// code for update and checking

        ImageIcon image = new ImageIcon("images/redcar.png");
        Image img = image.getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        car.setIcon(new ImageIcon(img));
        road.add(car);




///////////////////////////////////////////////////////////////////////

        // Ambulance 
        ambulence = new JLabel();
        ambulence.setBackground(Color.DARK_GRAY);
        // ambulence.setOpaque(true);
        ambulence.setBounds(20, 500, 40, 80);
        ImageIcon ambulanceImage = new ImageIcon("images/ambulance.png");
        Image ambulanceImg = ambulanceImage.getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        ambulence.setIcon(new ImageIcon(ambulanceImg));
        road.add(ambulence);

        // Enemy car 1
        enemy1 = new JLabel();
        enemy1.setBackground(Color.DARK_GRAY);
        // enemy1.setOpaque(true);
        enemy1.setBounds(e1x, e1y, 40, 80);
        
        ImageIcon e1img = new ImageIcon("images/police car.png");
        Image e1i = e1img.getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        enemy1.setIcon(new ImageIcon(e1i));
        road.add(enemy1);

        // Enemy car 2
        enemy2 = new JLabel();
        enemy2.setBackground(Color.DARK_GRAY);
        enemy2.setBounds(e2x, e2y, 40, 80);
        ImageIcon e2img = new ImageIcon("images/black car.png");
        Image e2i = e2img.getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        enemy2.setIcon(new ImageIcon(e2i));

        road.add(enemy2);

        // Enemy car 3
        enemy3 = new JLabel();
        enemy3.setBackground(Color.DARK_GRAY);
        enemy3.setBounds(e3x, e3y, 40, 80);
        ImageIcon e3img = new ImageIcon("images/mustang.png");
        Image e3i = e3img.getImage().getScaledInstance(40, 80, Image.SCALE_SMOOTH);
        enemy3.setIcon(new ImageIcon(e3i));
        road.add(enemy3);


        // Timer
        timer = new Timer(50, e -> {
            road.moveLine(5);


            // Enemy 1 moves down
            e1y += 4;
            // if (e1y > 600) e1y = -50;
            if(e1y > 600){
                e1y = randomLaneY(); //-50;
                e1x = randomLaneX();
                updateScore(1);
            }
            enemy1.setBounds(e1x, e1y, 40, 80);

            // Enemy 2 moves down
            e2y += 5;
            // if (e2y > 600) e2y = -150;
            if(e2y > 600){
                e2y = randomLaneY(); //-150;
                e2x = randomLaneX();
                updateScore(0);
            }
            enemy2.setBounds(e2x, e2y, 40, 80);

            // Enemy 3 moves down
            e3y += 6;
            // if (e3y > 600) e3y = -100;
            if(e3y > 600){
                e3y = randomLaneY(); //-100;
                e3x = randomLaneX();
                updateScore(0);
            }
            enemy3.setBounds(e3x, e3y, 40, 80);

            // Ambulance 
            ey += 4;
            if (ey > 600){
                ey = -110;
                ex = randomLaneX();
            }
            ambulence.setBounds(ex, ey, 40, 80);

            // COLLISION CHECK !!!!
            if (hit(car, enemy1) || hit(car, enemy2) || hit(car, enemy3) || hit(car, ambulence)) {
            gameOver();
            }

        });

        timer.start();

        road.setFocusable(true);
        road.addKeyListener(this);
        road.requestFocusInWindow();

        frame.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) x -= 10;
        else if (key == KeyEvent.VK_RIGHT) x += 10;
        else if (key == KeyEvent.VK_UP) y -= 10;
        else if (key == KeyEvent.VK_DOWN) y += 10;

        // Keep inside road
        if (x < 0) x = 0;
        if (x > road.getWidth() - car.getWidth()) x = road.getWidth() - car.getWidth();
        if (y < 0) y = 0;
        if (y > road.getHeight() - car.getHeight()) y = road.getHeight() - car.getHeight();

        car.setBounds(x, y, car.getWidth(), car.getHeight());
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

     private boolean hit(JLabel a, JLabel b){
        return a.getBounds().intersects(b.getBounds());
    }



    private void gameOver(){
        timer.stop();
        if(score > ScoreSystem.highScore){
            ScoreSystem.highScore = score;
            ScoreSystem.saveHighScore();
        }
        highScoreLabel.setText("Highest Score : " + ScoreSystem.highScore);
        int choice = JOptionPane.showConfirmDialog(null, "Game Over! Restart ?","Crash!", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION){
            SwingUtilities.getWindowAncestor(road).dispose();
            score = 0;
            new Game();
        }
        else{
            score = 0;
            new GameStart();
        }
    }

    private void updateScore(int p){
        if(p == 1){
            score+=5;
            scorLabel.setText("Score : " + score);
        }
        else{
            score++;
            scorLabel.setText("Score : " + score);
        }
       
    }

    private int randomLaneX(){
        return lanes[ran.nextInt(lanes.length)];
    }

    private int randomLaneY(){
        return safeSpawnY[ran.nextInt(safeSpawnY.length)];
    }

  
}