package com.company.IOStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Arrays;
/*
* 字符流是由Java虚拟机将字节转换得到的，这个过程是非常耗时的，
* 而且如果我们不知道编码类型很容易出现乱码问题。
* 所以，I/O刘就干脆提供了一个直接操作字符的接口，方便我们平时对字符进行流操作。
* */


/*
* 为什么字节流会乱码？
* 因为字节流一次只读一个字节，但是一个中文是多个字节
* 字符流中，中文的字节码一定是负数
* */
public class InputDemo {
    static int t;
    public static void main(String[] args) {
        // 字节流
        FileInputStream fis = null;
        FileOutputStream fos = null;
        // 字符流
        FileReader fr = null;
        try {
            //1.创建字节输出流的对象,如果不存在则直接报错
            fis = new FileInputStream("D:\\fos.txt");
            fos = new FileOutputStream("D:\\wangzhuo1.txt",true);

            fr = new FileReader("D:\\fw.txt");
            //2.读数据
            byte [] bytes = new byte[30];
            int len = 16;
            while (fis.read(bytes) != -1){
                fos.write(bytes,0,len);
            }
            char [] chars = new char[1024];
            while (fr.read(chars) != -1){
                System.out.println(new String(chars));
            }
        }catch (Exception e){
//            e.printStackTrace();
        }finally {
            try {
                //3。释放资源
                fis.close();
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
