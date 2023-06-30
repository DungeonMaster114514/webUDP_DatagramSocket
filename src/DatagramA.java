
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP最大只能传输64KB的数据
 * UDP没有服务器,两端都能有自己的端口接收消息
 */
public class DatagramA {
    public static void main(String[] args) throws IOException {
        //创建一个DatagramSocket对象准备接收9999端口的数据
        DatagramSocket datagramSocket = new DatagramSocket(9999);

        //创建一个DatagramPacket对象接收数据
        byte[] b = new byte[1024 * 64];
        DatagramPacket datagramPacket = new DatagramPacket(b,b.length);
        System.out.println("等待接收数据...");
        datagramSocket.receive(datagramPacket);

        //获取数据实际长度
        int Length = datagramPacket.getLength();

        //获取数据
        b = datagramPacket.getData();
        System.out.println(new String(b,0,Length));

        //发送数据toB
        byte[] b2 = "我是阿莱克斯塔萨,你想尝尝我的下面?".getBytes();

        //创建一个DatagramPacket对象接发送数据
        DatagramPacket datagramPacket2 = new DatagramPacket(b2,b2.length, InetAddress.getByName("127.0.0.1"),9998);
        datagramSocket.send(datagramPacket2);
        datagramSocket.close();
    }

}