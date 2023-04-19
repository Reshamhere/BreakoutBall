package Final;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Scorebox extends JFrame{

    private Button pastScoresBtn;
    private TextArea scoreDisplay;
    private static String pastScores="";
    private static String gameStatus="";

    public Scorebox() {
        // Set up UI components
        pastScoresBtn = new Button("Past Scores");
        pastScoresBtn.setBounds(150, 20, 100, 30);
        pastScoresBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pastScoresBtn.setVisible(false);
                showPastScores();
            }
        });
        add(pastScoresBtn);

        scoreDisplay = new TextArea();
        scoreDisplay.setBounds(10, 200, 480, 240);
        add(scoreDisplay);
    }

    private void showPastScores() {
        // Update past scores and game status
        pastScores = readPastScores();
        gameStatus = readGameStatus();

        // Display past scores and game status in score display textarea
        scoreDisplay.setBackground(new Color(222, 255, 219));
        scoreDisplay.setText("Score: " + pastScores + "Status: " + gameStatus);

    }

    // Method to read past scores from file
    private String readPastScores() {
        try {
            FileReader fileReader = new FileReader("past_scores.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            String scores = "";
            String line;
            while ((line = bf.readLine()) != null) {
                scores +=  line + "\n";
            }
            bf.close();
            return scores;
        } catch (IOException e) {
            e.printStackTrace();
            return "No games played";
        }
    }
    // Method to read game status from file
    private String readGameStatus() {
        try {
            FileReader fileReader = new FileReader("game_status.txt");
            BufferedReader bf = new BufferedReader(fileReader);
            String stat = "";
            String line;
            while ((line = bf.readLine()) != null) {
                stat += line + "\n";
            }
            bf.close();
            return stat;
        } catch (IOException e) {
            e.printStackTrace();
            return "Lost";
        }
    }
    // Method to write past scores to file
    private static void writePastScores(String scores) {
        try {
            FileWriter fileWriter = new FileWriter("past_scores.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(scores);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to write game status to file
    private static void writeGameStatus(String status) {
        try {
            FileWriter fileWriter = new FileWriter("game_status.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(status);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update and write past scores to file
    public static void updatePastScores(int newScore) {
        pastScores += newScore + "\n";
        writePastScores(pastScores);
    }

    // Method to update and write game status to file
    public static void updateGameStatus(String newStatus) {
        gameStatus += newStatus+"\n";
        writeGameStatus(gameStatus);
    }
}