import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame
{
    static Random rnd = new Random();
    static JTextArea displayTA = new JTextArea(25,50);
    static int playerWins = 0;
    static int computerWins = 0;
    static int ties = 0;

    public static JTextArea tiesTA = new JTextArea("Ties: " + ties);
    public static JTextArea computerWinsTA = new JTextArea("Computer Wins: " + computerWins);
    public static JTextArea playerWinsTA = new JTextArea("Player Wins: " + playerWins);

    public static void main(String[] args)
    {
        JFrame RPS = new JFrame();




        JPanel mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        RPS.add(mainPnl);
        RPS.setVisible(true);
        RPS.setTitle("Rock Paper Scissors Game");
        RPS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RPS.setSize(400, 400);


        JPanel controlPnl = new JPanel();
        controlPnl.setLayout(new GridLayout(1, 4));


        ImageIcon rockImg = new ImageIcon("src/rock.png");

        JButton rockBtn = new JButton("Rock", rockImg);
        rockBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        rockBtn.setVerticalTextPosition(JLabel.BOTTOM);
        rockBtn.setHorizontalTextPosition(JLabel.CENTER);
        rockBtn.addActionListener((ActionEvent ae) ->
                {

                    calcWinner(1);


                }
        );
        controlPnl.add(rockBtn);

        ImageIcon paperImg = new ImageIcon("src/paper.png");

        JButton paperBtn = new JButton("paper", paperImg);
        paperBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        paperBtn.setVerticalTextPosition(JLabel.BOTTOM);
        paperBtn.setHorizontalTextPosition(JLabel.CENTER);
        paperBtn.addActionListener((ActionEvent ae) ->
                {

                    calcWinner(2);

                }
        );
        controlPnl.add(paperBtn);

        ImageIcon scissorsImg = new ImageIcon("src/scissors.png");

        JButton scissorsBtn = new JButton("scissors", scissorsImg);
        scissorsBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        scissorsBtn.setVerticalTextPosition(JLabel.BOTTOM);
        scissorsBtn.setHorizontalTextPosition(JLabel.CENTER);
        scissorsBtn.addActionListener((ActionEvent ae) ->
                {

                    calcWinner(3);

                }
        );
        controlPnl.setBorder(BorderFactory.createLineBorder(Color.black,5));
        controlPnl.add(scissorsBtn);

        JButton quitBtn = new JButton("Quit");
        quitBtn.setFont(new Font("Roboto", Font.PLAIN, 24));
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        controlPnl.add(quitBtn);
        mainPnl.add(controlPnl, BorderLayout.SOUTH);

        JPanel statsPnl = new JPanel();
        statsPnl.setLayout(new GridLayout(1, 3));
        
        playerWinsTA.setFont(new Font("Arial", Font.BOLD, 18));
        statsPnl.add(playerWinsTA);


        computerWinsTA.setFont(new Font("Arial", Font.BOLD, 18));
        statsPnl.add(computerWinsTA);


        tiesTA.setFont(new Font("Arial", Font.BOLD, 18));
        statsPnl.add(tiesTA);
        mainPnl.add(statsPnl, BorderLayout.CENTER);


        JPanel displayPnl = new JPanel();
        displayTA.setFont(new Font("Arial", Font.PLAIN, 16));
        displayTA.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayTA);
        displayPnl.add(scrollPane);
        mainPnl.add(displayPnl, BorderLayout.NORTH);

    }

    public static void calcWinner(int x)
    {

        int computerAction = rnd.nextInt(3);
        if(x == 1)
        {

            if (computerAction == 0)
            {
                displayTA.append("Both players chose the same gesture, it is a tie\n");
                ties++;
                tiesTA.validate();
            }
            else if (computerAction == 1)
            {
                displayTA.append("Paper covers rock, the computer wins\n");
                computerWins++;
                computerWinsTA.validate();
            }
            else
            {
                displayTA.append("Rock breaks scissors, the player wins\n");
                playerWins++;
                playerWinsTA.validate();
            }

        }
        else if (x == 2)
        {

            if (computerAction == 1)
            {
                displayTA.append("Both players chose the same gesture, it is a tie\n");
                ties++;
                tiesTA.validate();
            }
            else if (computerAction == 0)
            {
                displayTA.append("Paper covers rock, the player wins\n");
                playerWins++;
                playerWinsTA.validate();
            }
            else
            {
                displayTA.append("Scissors cuts paper, the computer wins\n");
                computerWins++;
                computerWinsTA.validate();
            }

        }
        else if (x == 3)
        {

            if (computerAction == 2)
            {
                displayTA.append("Both players chose the same gesture, it is a tie\n");
                ties++;
                tiesTA.validate();

            }
            else if (computerAction == 1)
            {
                displayTA.append("Scissors cuts paper, the player wins\n");
                playerWins++;
                playerWinsTA.validate();
            }
            else
            {
                displayTA.append("Rock crushes scissors, the computer wins\n");
                computerWins++;
                computerWinsTA.validate();
            }

        }

    }

}
