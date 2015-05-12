package ch09.ex09_12;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreditSearcher extends JApplet implements ActionListener {
  JTextField pathForm = new JTextField();
  JButton startButton = new JButton("Start");
  JTextArea output = new JTextArea();

  /**
   * Search credit card number recursively
   * @param targetPath Credit card number is searched under this directory
   * @return LinkedList including found numbers
   */
  public LinkedList<String> searchCredit(String targetPath) {
    LinkedList<String> result = new LinkedList<String>();
    try {
      ProcessBuilder builder = new ProcessBuilder("grep", "-roh", "'[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}-[0-9]\\{4\\}'", targetPath);
      Process process = builder.start();
      process.waitFor();
      BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = null;
      while((line = br.readLine()) != null) {
        result.add(line);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void init() {
    getContentPane().setLayout(new GridLayout(5, 1));
    getContentPane().add(new JLabel("Path: "));
    getContentPane().add(pathForm);
    getContentPane().add(startButton);
    getContentPane().add(new JLabel("Output: "));
    getContentPane().add(output);
    output.setEnabled(false);
    startButton.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("Start")) {
      if (pathForm.getText().length() == 0) {
        output.setText("Please input path!!");
      } else {
        LinkedList<String> result = searchCredit(pathForm.getText());
        StringBuilder printResult = new StringBuilder("");
        for(String s: result) {
          printResult.append(s);
          printResult.append("\r\n");
        }
        output.setText(printResult.toString());
      }
    }
  }

}
