import java.net.*;
import java.io.*;

class ClientSide
{
	public static void main(String[] args) throws IOException
	{
		//ServerSocket serverSocket = new ServerSocket(49153);
		Socket mSocket = new Socket("192.168.29.149",49153);
		
		DataInputStream dIN = new DataInputStream(mSocket.getInputStream());
		DataOutputStream dOUT = new DataOutputStream(mSocket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String clntMessage,srvrMessage;
		clntMessage = "";
		srvrMessage = "";
		
		while(!clntMessage.equalsIgnoreCase("bye"))
		{
			System.out.print("Client : ");
			clntMessage = br.readLine();
			System.out.println();
			dOUT.writeUTF(clntMessage);
			dOUT.flush();
			srvrMessage = dIN.readUTF();
			System.out.println ("Server : "+srvrMessage);
		}
		dOUT.close();
		mSocket.close();
		//serverSocket.close();
	}
}