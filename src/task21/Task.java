package task21;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/22/15.
 */
public class Task extends SwingWorker<Void, Void> {
  private task21.DownloadAgentForm form;
  private task21.DownloadAgentThread thread;

  public Task(task21.DownloadAgentForm form, task21.DownloadAgentThread thread) {
    this.form = form;
    this.thread = thread;

  }

  @Override
  protected Void doInBackground() throws Exception {
    int progress = 0;
    System.out.println("Start");
    setProgress(0);
    while (progress < 100) {
      if(thread.length()==-1){
        form.errorLabel.setText(thread.getURLString());
        break;
      }
      //Sleep for up to one second.
     try {
        Thread.sleep((4));
      } catch (InterruptedException ignore) {
      }
      System.out.println(thread.numberOfBytes() + "----" + (thread.length() / 100) + "----" + progress);
      //Make random progress.
      if (thread.length() != 0 && (thread.getPercents() > progress)) {

        System.out.println("uvelichavame!" + thread.getPercents());
        progress = thread.getPercents();
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
