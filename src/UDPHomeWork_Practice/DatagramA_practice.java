package UDPHomeWork_Practice;

import java.io.IOException;
import java.net.*;

public class DatagramA_practice {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(1145);
        //接收B消息
        byte[] bytes = new byte[1024 *10];
        //获取包
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        //拆包,获取实际数据
        datagramSocket.receive(datagramPacket);
        bytes = datagramPacket.getData();
        int Len = datagramPacket.getLength();
        String s = new String(bytes,0,Len);
        byte[] bytes2;
        //发回消息
        if (s.equals("四大名著有哪些?")){
            bytes2 = "《homo梦》、《仙贝传》、《西游记》、《会员制餐厅演绎》".getBytes();
        }
        else {
            bytes2 = "What Happen?".getBytes();
        }
        DatagramPacket datagramPacket2 = new DatagramPacket(bytes2,bytes2.length, InetAddress.getByName("127.0.0.1"),1146);
        datagramSocket.send(datagramPacket2);
        datagramSocket.close();
        System.out.println("接收端退出");
    }
}
