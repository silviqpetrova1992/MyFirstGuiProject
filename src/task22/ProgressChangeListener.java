package task22;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/29/15.
 */
public interface ProgressChangeListener {

  void onProgressUpdated(int progress);
  void onDownloadStarted();

  void onDownloadCompleted();
}
