package task2;

/**
 * Created by Silvia Petrova(silviqpetrova1992@gmail.com)on 5/25/15.
 */
public class DownloadAgentThread extends Thread{

  private  String urlString;
  private  String out;
  private DownloadAgent agent;

  public DownloadAgentThread(String urlString, String out) {
    this.urlString = urlString;
    this.out = out;
  }
public long length(){
  return agent.length;
}
  public long numberOfBytes(){
    return agent.numberBytes;
  }
  public String getURLString(){
    return urlString;
  }
  @Override
  public void run() {
    try{
    agent=new DownloadAgent();
    agent.download(urlString,out);
    }catch (Exception e){
      agent.length=-1;
      urlString=e.getMessage();
    }
  }
}
