import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Client extends Socket {
    Socket s;
    PrintWriter out=null;
    BufferedReader in=null;

    public Client(String host, int port ){
        try{
            s = new Socket(host, port);
            out = new PrintWriter(s.getOutputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));

        }
        catch (Exception e){

        }
    }

    public Socket getSocket(){
        return s;
    }

    public String request(String str){
        try{
            int a = Integer.parseInt(str);
            int count = 0;
            for (int i = 1; i < a+1; i++){
                if (a % i == 0)
                    count++; 
            }
            return("The number " + a + " has " + count + " factors");
        }
        catch (Exception e) {
            return "There was an exception on the server";
        }
        
    }


    public void disconnect(){
        try{
            //close the connections
            out.close();
            in.close();
            s.close();
        }
        catch (Exception e){}
    }
    public void handshake(){

        try{
            out.write("12345\n");
            out.flush();
        }
        catch (Exception e){
            System.out.println("yikes?");
            out.write("couldn't handshake");
        }

    }
    public String toString(){
        return s.getLocalSocketAddress() + "";
    }
}