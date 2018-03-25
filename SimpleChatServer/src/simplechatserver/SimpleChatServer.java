/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplechatserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Iterator;

public class SimpleChatServer {

    ArrayList clientOutputStreams;
    
    public static void main(String[] args) {
        new SimpleChatServer().go();
    }
    
    public void go() {
        //create a ServerSocket and accept all client connections
        //save each connection as an output stream to the clientOutputStreams arraylist
        //start a new Client Handler thread
        clientOutputStreams = new ArrayList();
        
        try {
            ServerSocket serverSock = new ServerSocket(5000);
            while(true){
                Socket clientSocket = serverSock.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutputStreams.add(writer);
                
                Thread t = new Thread(new ClientHandler(clientSocket));
                t.start();
                System.out.println("Got a connection");
            }
        } catch (Exception ex) {ex.printStackTrace();}
        
    }
    
    public void publishToAll(String message){
        //publish a message to every output stream in clientOutputStreams arraylist
        Iterator it = clientOutputStreams.iterator();
        while (it.hasNext()) {
            try {
                PrintWriter writer = (PrintWriter) it.next();
                writer.println(message);
                writer.flush();
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
    
    public class ClientHandler implements Runnable{
        //inner class that handles input streams from clients and publishes their messages
        BufferedReader reader;
        Socket sock;
        
        public ClientHandler(Socket clientSocket){
            //constructor that takes a client socket connection and listens to it for messages
            try {
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
        @Override
        public void run(){
            //if there's a message, publish it to everyone immediately
            String message;
            
            try {
                while ((message = reader.readLine()) != null) {
                    System.out.println("Read \"" + message + "\"");
                    publishToAll(message);
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }
    
}
