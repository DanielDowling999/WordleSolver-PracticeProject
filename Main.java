import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main implements ActionListener{
  private String wrngLetters;
  private String corrLetters;
  private JFrame frame;
  private JPanel panel;
  private JLabel correctLabel;
  private JLabel wrongLabel;
  private JTextField correctLetters;
  private JTextField wrongLetters;
  private JLabel answersLabel;
  private Set<String> answers;
  public Main() {
    frame = new JFrame();
    panel = new JPanel();
    correctLabel = new JLabel("Correct Letters: ");
    wrongLabel = new JLabel("Wrong Letters: ");
    correctLetters = new JTextField();
    wrongLetters = new JTextField(); 
    GridLayout appLayout = new GridLayout(0,2);
    JButton solverButton = new JButton("Solve!"); 
    answersLabel = new JLabel(" Possible Answers: Null");
    panel.setBorder(BorderFactory.createEmptyBorder(10,30,10,30));
    panel.setLayout(appLayout);
    panel.add(correctLabel);
    panel.add(correctLetters);
    panel.add(wrongLabel);
    panel.add(wrongLetters);
    
    panel.add(solverButton);
    panel.add(answersLabel);
    solverButton.addActionListener(this);
    frame.add(panel, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Wordle Solver");
    frame.pack();
    frame.setVisible(true);

  }
    public static void main(String[] args) {
      new Main();
		//wordleSolver obj = new wordleSolver();
      //  obj.solveWordle();
	}
    @Override //Finds any valid 5 letter words from a pre-set dictionary that match the correct letters and incorrect letters entered.
    //Returns an error message if the response returns no valid characters.
    //Updates the Answer Label to contain the valid words. Requires the user to extend their window size if they want to see them all.
    public void actionPerformed(ActionEvent e) {
      int count = 0;
      corrLetters = correctLetters.getText();
      wrngLetters = wrongLetters.getText();
      wordleSolver obj = new wordleSolver();
      answers = obj.solveWordle(corrLetters, wrngLetters);
      String outString = "<html> Possible Answers:<br> ";
      for(String answer:answers){
        outString = outString + answer + ", ";
        count++;
        if (count>5){
          count = 0;
          outString = outString + "<br> ";
        }
      }
      answersLabel.setText(outString);
    }
}
