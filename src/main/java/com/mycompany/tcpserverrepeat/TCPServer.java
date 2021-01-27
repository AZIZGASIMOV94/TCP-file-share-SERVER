package com.mycompany.tcpserverrepeat;

import fileUtil.fileUtil;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author azizg
 */
public class TCPServer {
    public static void main(String[] args) throws IOException, Exception {
	// write your code here
        ServerSocket serverSocket = new ServerSocket(9876);
        while(true){
            System.out.println("server is running...");
            Socket socket = serverSocket.accept();
            DataInputStream din = new DataInputStream(socket.getInputStream());
            byte[] msg = readMsg(din);
            fileUtil.writeBytes(msg, "C:\\Users\\azizg\\Desktop\\qeydler_from_client.txt");
            System.out.println("file written! ");
        }
    }
       
    public static byte[] readMsg(DataInputStream din) throws IOException{
        int msgLen = din.readInt();
        byte[] msg = new byte[msgLen];
        din.readFully(msg);
        return msg;
    }
}
