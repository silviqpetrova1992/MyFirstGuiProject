package task1;

import examples.app1.MainFrame;

import javax.swing.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/18/15.
 */
public class App {
  public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
       CalculatorFrame calculatorFrame=new CalculatorFrame();
          calculatorFrame.createAndShowGUI();
        }
      });

    }
  }
