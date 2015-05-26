package task2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/22/15.
 */
public class Task extends SwingWorker<Void, Void> {
  private final DownloadAgentForm form;
  private DownloadAgentThread thread;

  public Task(DownloadAgentForm form, DownloadAgentThread agent) {
    this.thread = agent;
    this.form = form;
  }

  @Override
  protected Void doInBackground() throws Exception {
    Random random = new Random();
    int progress = 0;
    System.out.println("Start");
    //Initialize progress property.
    setProgress(0);
    while (progress < 100) {
      if(thread.length()==-1){
        form.errorLabel.setText(thread.getURLString());
        break;
      }
     //Sleep for up to one second.
     try {
        Thread.sleep(random.nextInt(10));
      } catch (InterruptedException ignore) {
      }
      System.out.println(thread.numberOfBytes() +"----"+ (thread.length()/ 100)+"----"+progress );
      //Make random progress.
      if (thread.length()!=0&&(thread.numberOfBytes() / (thread.length() / 100)>progress)) {

        System.out.println("uvelichavame!"+progress);
        progress++;
        //progress =(int)(thread.numberBytes % (thread.length / 100));
        setProgress(Math.min(progress, 100));
      }
    }
    return null;
  }

  @Override
  public void done() {
    System.out.println("done");
    Toolkit.getDefaultToolkit().beep();
    form.submit.setEnabled(true);
    form.panel.setCursor(null);
    // s.setEnabled(true);
    //setCursor(null); //turn off the wait cursor
  }
}
