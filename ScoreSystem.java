import java.io.*;

public class ScoreSystem {
    public static int highScore = 0;
    public static int loadHighscore(){
        try{
            File file = new File("highscore.txt");

            if(!file.exists()){
                FileWriter wirte = new FileWriter(file);
                wirte.write("0");
                wirte.close();
            }

            BufferedReader read = new BufferedReader(new FileReader(file));
            highScore = Integer.parseInt(read.readLine());
            read.close();

        } catch(Exception e){
            System.out.println("High Score not found");
        }
        return highScore;
    }


    public static void saveHighScore(){
        try{
            FileWriter writer = new FileWriter("highscore.txt");
            writer.write(String.valueOf(highScore));
            writer.close();
        } catch(Exception e){
            System.out.println("Error saving high score");
        }
    }

}
