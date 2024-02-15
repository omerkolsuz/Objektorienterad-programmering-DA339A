package model;

import controller.Controller;

import javax.sound.midi.MidiFileFormat;
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class TopScoreManager {
    private ArrayList<Player> highScore;
    private ArrayList<Player> topPlayersScore;
    private Controller controller;

    private Player player;

    private String[] stringArray;

    private int nbr;

    /**
     *
     * Konstruktorn som används för att skapa en ArrayList (highScore) använder sig av objekt av
     * typen Player, som innehåller information om den nuvarande spelaren. En annan ArrayList
     * (topPlayersScore) lagrar all information från en .dat-fil och lägger till den nuvarande
     * spelaren om dennes poäng är bättre än spelaren på plats 9 i listan. För att kunna hämta
     * den nuvarande spelarens poäng behöver konstruktorn också ta emot en parameter för att ha
     * tillgång till controllern som håller reda på den nuvarande spelarens poäng.
     * @param controller: vald produkt som läggs till i en order.
     * @throws IOException
     * @throws FileNotFoundException
     */
    public TopScoreManager(Controller controller) throws FileNotFoundException, IOException {
        highScore = new ArrayList<>();
        topPlayersScore = new ArrayList<>(10);
        this.controller = controller;

    }

    // public void startUpFile() {

    // // nbr = 0;
    // readFromFile();
    // writeToFile();
    // }

    public void addScore(Player playerInfo) {

        highScore.add(playerInfo);

    }

    public ArrayList<Player> getTopScoreList() {
        return topPlayersScore;
    }

    /**
     * här vi jämförar scoren med nickmamsen som är angivna av spelarna
     * @return
     */
    public boolean compareScore() {

        // if (topPlayersScore.isEmpty() || (topPlayersScore.contains(player.getScore())
        // && (player.getTotalHits() > topPlayersScore.get(i).getScore()))) {
        if (topPlayersScore.size() == 0) {
            String playersName = JOptionPane.showInputDialog(null, "Enter your Nickname");
            this.player = controller.getPlayer();
            player.setPlayersName(playersName);
            topPlayersScore.add(player);
            return true;
        }
        if ((topPlayersScore.get(0) != null && topPlayersScore.get(0) instanceof Player) || topPlayersScore.isEmpty()
                || (player.getPlayersScore() < topPlayersScore.get(9).getPlayersScore())) {
            String playersName = JOptionPane.showInputDialog(null, "Enter your Nickname");
            this.player = controller.getPlayer();
            player.setPlayersName(playersName);
            topPlayersScore.add(player);
            Collections.sort(topPlayersScore);
            return true;

        } else {
            System.out.println("Better luck next time");
            return false;
        }

    }

    /**
     * här vi lagrar information av score
     * @return
     */
    public String[] AllScoreInfo() {
        String[] stringArrayAllScores = new String[topPlayersScore.size()];
        for (int i = 0; i < stringArrayAllScores.length; i++) {
            stringArrayAllScores[i] = topPlayersScore.get(i).toString();
        }
        return stringArrayAllScores;
    }

    /*
     * public String[] infoStrings () {
     * stringArray = new String[highScore.size()];
     * for (int i = 0; i < stringArray.length; i++) {
     * stringArray[i] = highScore.get(i).toString();
     * }
     * return stringArray;
     * }
     */

    /**
     * här vi lägger vår information av spelaer till list filen
     */

    public void writeToFile() {
        try (FileOutputStream fis = new FileOutputStream("list.dat", true)) {
            // dat fil med objekt så vi slipper splitta innehållet i txtfil.
            ObjectOutputStream oos = new ObjectOutputStream(fis);
            for (int i = 0; i < topPlayersScore.size(); i++) {
                oos.writeObject(topPlayersScore.get(i));
                oos.flush();
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * här vi kan läsa filen som vi skapade
     */
    public void readFromFile() {
        String path = "list.dat";
        try {
            FileInputStream fis = new FileInputStream("list.dat");

            ObjectInputStream ois = new ObjectInputStream(fis);

            while (true) {
                Player p = (Player) ois.readObject();
                topPlayersScore.add(p);
            }

        } catch (Exception ex) {
            System.out.println(topPlayersScore.toString());
            Collections.sort(topPlayersScore);

        }
    }
}
