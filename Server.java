import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket s;
    PrintWriter pw;
    Socket clientSock;
    public Server(int port){
        try{
            s = new ServerSocket(port);

        }
        catch (Exception e){}
    }
    public void serve(int n){
        try{
            for (int i = 0; i < n; i++){
                clientSock = s.accept();

                System.out.println("Connection from: "+clientSock.getRemoteSocketAddress());
                
                pw = new PrintWriter(clientSock.getOutputStream());
               // pw.println("Hello World");
    
                

                //loop and get the new connection

            }
        }
        catch(Exception e){
            System.err.print("IOException");
            System.exit(1);
        }
           
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
