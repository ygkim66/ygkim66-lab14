import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Server {
    private ServerSocket s;
    private PrintWriter pw;
    private Socket clientSock;
    private ArrayList<LocalDateTime> ldt;
    public Server(int port){
        try{
            s = new ServerSocket(port);
            ldt = new ArrayList<LocalDateTime>();

        }
        catch (Exception e){
            
        }
    }
    public void serve(int n){
        try{
            for (int i = 0; i < n; i++){
                ldt.add(LocalDateTime.now());
                clientSock = s.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
                pw = new PrintWriter(clientSock.getOutputStream());
              
                if (!in.readLine().equals("12345\n"))
                    throw new Exception();
            }
        }
        catch(Exception e){
            pw.write("couldn't handshake");
            disconnect();
        }
           
    }
    public ArrayList<LocalDateTime> getConnectedTimes(){
        return ldt;
    }
    
    public void disconnect(){
        try{
            //close the connections
            pw.close(); //close the stream
            clientSock.close();//close the socket
            s.close();
        }
        catch (Exception e){}
    }


}
