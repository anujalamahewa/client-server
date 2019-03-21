/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

// At the top of the file, you will always need
using System.Net.Sockets;
using RedCorona.Net;

class SimpleClient{
  ClientInfo client;
  void Start(){
    Socket sock = Sockets.CreateTCPSocket("www.myserver.com", 2345);
    client = new ClientInfo(sock, false); // Don't start receiving yet
    client.OnReadBytes += new ConnectionReadBytes(ReadData);
    client.BeginReceive();
  }

  void ReadData(ClientInfo ci, byte[] data, int len){
    Console.WriteLine("Received "+len+" bytes: "+
       System.Text.Encoding.UTF8.GetString(data, 0, len));
  }
}