package UDPHomeWork_Practice;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramB_practice {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(1146);
        System.out.print("输入你的问题:");
        Scanner scanner = new Scanner(System.in);
        //发送toA
        byte[] bytes = scanner.nextLine().getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),1145);
        datagramSocket.send(datagramPacket);
        byte[] bytes2 = new byte[1024*10];
        //接收B的数据
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes2,bytes2.length);
        datagramSocket.receive(datagramPacket2);//获取包
        bytes2 = datagramPacket2.getData();//获取数据数据
        int Len = datagramPacket2.getLength();//获取数据实际长度
        System.out.println(new String(bytes2,0,Len));
        datagramSocket.close();
        System.out.println("发送端退出");
    }
}
