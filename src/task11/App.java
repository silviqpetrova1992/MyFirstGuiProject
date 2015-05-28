package task11;


import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class App {
  public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
       task11.CalculatorFrame calculatorFrame=new task11.CalculatorFrame();
          calculatorFrame.createAndShowGUI();
        }
      });

    }
  }
