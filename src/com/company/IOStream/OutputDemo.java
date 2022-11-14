package com.company.IOStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

// 输出流，写入到磁盘中，字符流=字节流+编码表
public class OutputDemo {
    public static void main(String[] args) throws IOException {
        // 编码
        String  s = "中文测试编码";
        // 获取编码值
        byte b[] = s.getBytes("UTF-8");
        System.out.println(Arrays.toString(b));

        //1.创建字节输出流的对象，如果文件不存在就会创建，存在则会清空,但是父路径一定要存在   如果是append为true的话就不会清空而会续写
        FileOutputStream fos=new FileOutputStream("D:\\fos.txt");
        // 字节缓冲流，字节缓冲流只提供缓冲区，真正的读写数据还得依靠字节流对象来实现
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\bos.txt",true));

        // 字符流输入流
        FileWriter fw = new FileWriter("D:\\fw.txt",true);
        //2.写数据，写到硬盘中就是能看懂的字符，可以传单个字节，也可以传字节数组
            fos.write(96);
            byte[] bytes1={97,98,99,100,101,102,103};
            // 这里传的就是字节数组
            fos.write(bytes1);
            bos.write(b);
            // 字符流，传的字符
            fw.write(s);
        //3。释放资源，流使用完之后都需要释放，一般放在finally中

        fos.close();
        fw.close();
        bos.close();

    }
}

