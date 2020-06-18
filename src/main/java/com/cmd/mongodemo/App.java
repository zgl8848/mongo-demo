package com.cmd.mongodemo;

import io.minio.MinioClient;
import io.minio.ObjectStat;
import io.minio.errors.MinioException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

public class App {
    public static void main (String [] arug){
//        Scanner sc=new Scanner(System.in);
//        System.out.print("请输入第一个数字:");
//        Integer num1 = sc.nextInt();
//        System.out.print("请输入第二个数字:");
//        Integer num2 = sc.nextInt();
//        System.out.print("请输入符号序号(+-×÷):");
//        String symbol = sc.next();
//        if(symbol.equals("＋")){
//            System.out.println(num1+"＋"+num2+"="+(num1+num2));
//        }else if(symbol.equals("－")){
//            System.out.println(num1+"－"+num2+"="+(num1-num2));
//        }else if(symbol.equals("×")){
//            System.out.println(num1+"×"+num2+"="+(num1*num2));
//        }else if(symbol.equals("÷")){
//            System.out.println(num1+"÷"+num2+"="+(num1/num2));
//        }
        //将formate型转化成Date数据类型
       // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      // String date = sdf.format(new Date());
//       try{
//           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//定义一个formate
//           Date date = simpleDateFormat.parse("2020-03-27 12:12:12");
//           System.out.println(date);
//       }catch (Exception e){
//        e.printStackTrace();
//    }
       /* for(int i = 0;i<12;i++){\
            System.out.println(i);
        }*/

       // String filePath = "D:"+ File.separator+"Oracle"+File.separator+"message-demo"+File.separator+"mylog"+File.separator+"wgsd1.txt";
        //String filePath = "D:"+ File.separator+"Oracle"+File.separator+"abc.txt";
        //readTxtFile(filePath);

//        System.out.println("hello java");2020-05-20 10:45:41
//        try {
//            test1();
//        }catch (Exception e){
//            System.out.println("test1错误: " + e);
//        }

        /*Random ran = new Random();
        for(int i=0 ;i<100 ;i++){
            System.out.println(ran.nextInt(100));
        }*/
       /* double a = 42;
        double b = 25;

       double c = b/a;
       String str = c+"";
       String hh =str.substring( str.indexOf(".")+3,str.indexOf(".")+4);
       str = str.substring( str.indexOf(".")+1,str.indexOf(".")+3);

       int as =  Integer.parseInt(str);
       int qq = Integer.valueOf(hh);
       if(qq>4){
           as = as+1;
       }

       System.out.println(as);*/
/*
        Integer [] list = new Integer[]{33,2,34,9,88,8};

        System.out.println("排序前: "+JSON.toJSONString(list));
        for(int j = 0;j<list.length;j++) {
            for (int i = 1; i < list.length; i++) {
                if (list[i - 1] > list[i]) {
                    Integer num = list[i - 1];
                    list[i - 1] = list[i];
                    list[i] = num;
                    //i = 1;
                }
            }
        }
        System.out.println("排序后: "+JSON.toJSONString(list));*/
      /*  Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String date = sdf.format(d);
        Integer i = d.getMonth()+1;
        String str = date + "-";
        if(i<10){
             str = str + "0" + i;
            System.out.println(str);
        }else{
            str = date + i;
            System.out.println(str);
        }*/

      /*String str = "我";
        System.out.println(str.getBytes().length);*/


       /* double dou = (Double.valueOf(25)/Double.valueOf(50))*100;
        String difference = "";
        String str = dou + "";
        if(str.substring(str.indexOf(".")+1).getBytes().length>2){
            String judge = str.substring(str.indexOf(".")+3,str.indexOf(".")+4);
            double rate = Double.valueOf(str.substring(str.indexOf(".")-2,str.indexOf(".")+3));
            if(Integer.valueOf(judge)>4){
                rate = rate + 0.01;
            }
             difference = rate + "%";
        }else{
            if(str.substring(str.indexOf(".")+1).getBytes().length==1 && str.substring(str.indexOf(".")+1).equals("0")){
                difference = str.substring(0,str.indexOf(".")) + "%";  //没有小数的情况
            }else{
                difference = str + "%";
            }
        }*/

      //  System.out.println("difference: "+difference);

       /* String str = "桂城街道、里水镇、九江镇、丹灶镇、大沥镇、狮山镇、西樵镇";

        String[] split =str.split("、");
        System.out.println("split: "+JSON.toJSONString(split));*/
        new Producer().start();
        new Consumer().start();
    }
    //产品
    static class ProductObject{
        //线程操作变量可见
        public volatile static String value;
    }

    //生产者线程
    static class Producer extends Thread{

        @Override
        public void run() {
            //不断生产产品
            while(true){
                if(ProductObject.value == null){
                    ProductObject.value = "NO:"+System.currentTimeMillis();
                    System.out.println("生产产品："+ProductObject.value);
                }
            }
        }
    }

    //消费者线程
    static class Consumer extends Thread{

        @Override
        public void run() {
            while(true){
                if(ProductObject.value != null){
                    System.out.println("消费产品："+ProductObject.value);
                    ProductObject.value = null;
                }
            }
        }
    }

    public static void readTxtFile(String filePath){
        try {
            String encoding="UTF-8";
            //String encoding="ISO-8859-1";
            //String encoding="GBK";
            File file=new File(filePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    lineTxt=lineTxt.replaceAll("。","。\n");
                    lineTxt=lineTxt.replaceAll(" ","");
                    //lineTxt=lineTxt.replaceAll("\"id\": ","\"_id\": ");
                   /*
                    try{
                        Thread.sleep(1000);
                        System.out.println(lineTxt);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    */
                    System.out.println(lineTxt);
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

    }

    public static void test1()throws NoSuchAlgorithmException, IOException, InvalidKeyException, XmlPullParserException {

        try {
            // 参数为：图床，账号，密码
            MinioClient minioClient = new MinioClient("http://127.0.0.1:9000", "minioadmin", "minioadmin");

            //boolean v=minioClient.bucketExists("test1");
            // 检查文件夹是否已经存在
            boolean isExist = minioClient.bucketExists("zgl");
            if(isExist) {
                System.out.println("zgl文件夹已经存在了");
            }
            else {
                // 创建一个名为managertest的文件夹
                System.out.println("zgl文件夹还没存在");
                minioClient.makeBucket("zgl");
            }

            // 使用putObject上传一个文件到文件夹中。
            //参数为：文件夹，要存成的名字，要存的文件 （如果文件名相同将会复盖原来的文件）
            //minioClient.putObject("zgl","qqq.jpg", "D:\\360downloads\\wpcache\\300368.jpg");
            //System.out.println("上传成功了");


            //使用getObject获取一个文件
            // 调用statObject()来判断对象是否存在。
            //ObjectStat file=minioClient.statObject("zgl", "zgl123.jpg");
            //System.out.println("文件名："+file.name()+",文件大小:"+file.length());

            // 获取1.png的流并保存到photo.png文件中。
            //参数为：文件夹，要获得的文件，要写入的文件
            minioClient.putObject("zgl","qqq.jpg", "D:\\zglkafka\\123.jpg");
            System.out.println("下载成功了");

        } catch(MinioException e) {
            System.out.println("错误: " + e);
        }
    }
}
