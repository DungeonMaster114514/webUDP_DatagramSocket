import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class DatagramB {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //UDP一次传输数据的大小不能超过64KB
        byte[] bytes = "你是哪位?".getBytes();

        //创建一个DataPacket用于发送数据          new DatagramPacket(bytes,bytes.length,InetAddress,目标端口);
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,InetAddress.getByName("192.168.175.1"),9999);

        //发送数据toA
        datagramSocket.send(datagramPacket);
        System.out.println("发送完毕");
        byte[] bytes2 = new byte[1024 * 10];

        //创建一个DataPacket用于接收数据
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes2,bytes2.length);
        //接收数据
        datagramSocket.receive(datagramPacket2);
        int Len = datagramPacket2.getLength();
        bytes2 = datagramPacket2.getData();
        System.out.println(new String(bytes2,0,Len));

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        datagramSocket.close();
    }
}
