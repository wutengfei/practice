package com.company.others;

import java.io.File;
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.SequenceInputStream;  
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Enumeration;  
import java.util.List;  
/** 
 * 文件的切割和合并 
 * 1.要切割和合并文件：主要考虑的就是文件的源地址，目标地址，暂存文件地址和文件名称 
 * 2.切割文件：判断给的暂存地址是否存在，不存在，则创建；从源地址中读出文件，按照给定的大小进行文件的切割操作放入暂存地址中 
 * 3.合并文件：判断给定的目标地址是否存在，不存在，则创建；定义List集合将暂存地址中的文件全部读取出来，放到list集合中 
 *          然后使用Enumeration列举出所有文件，合并流合并文件 
 *          最后写入到目标的地址中 
 * 注:本例子中所有的异常都采用抛出的方式处理 
 * @author aflyun 
 * 
 */  
public class TestFileCutUnion {  
  
    public static void main(String[] args) throws IOException {  
          
        String fSrc = "D:/12.png";//源文件的目录
        String fDir = "D:/1";//目标文件的目录  
        String fTemp = "E:/111";//暂存文件的目录
        File srcFile = new File(fSrc);  
        File dirFile = new File(fDir);  
        File tempFile = new File(fTemp);  
        String fileName = srcFile.getName();//获取文件的名称  
       // cutFile(srcFile,tempFile);//调用分割方法
        unionFile(dirFile,tempFile,fileName);//调用合并方法  
          
          
    }  
      
    /** 
     * 切割文件 
     * @param srcFile 
     * @param tempFile 
     * @throws IOException 
     */  
      
    public static void cutFile(File srcFile, File tempFile) throws IOException {  
        //读取源地址文件  
        FileInputStream fis = new FileInputStream(srcFile);  
        FileOutputStream fos = null;  
        //是否为文件，不是就创建  
        if(!tempFile.isFile()){  
            tempFile.mkdirs();  
        }  
      
        byte[] b = new byte[100];  
        int len =0;  
        int count = 0;  
        while((len=fis.read(b)) != -1){  
            int num = count++;  
            //写入暂存地址目录中  
            fos = new FileOutputStream(new File(tempFile, num+".part"));  
            fos.write(b, 0, len);  
              
        }  
        fos.flush();  
        fos.close();  
        fis.close();  
          
        System.out.println("分割完成！");  
    }  
    /** 
     * 合并文件 
     * @param dirFile  
     * @param tempFile 
     * @param fileName 
     * @throws IOException 
     */  
    public static void unionFile(File dirFile, File tempFile, String fileName) throws IOException {  
        //判断目标地址是否存在，不存在则创建  
        if(!dirFile.isFile()){  
            dirFile.mkdirs();  
        }  
        List<FileInputStream> list = new ArrayList<FileInputStream>();  
        //获取暂存地址中的文件  
        File[] files = tempFile.listFiles();  
          
        for (int i = 0; i < files.length; i++) {  
            //用FileInputStream读取放入list集合  
            list.add(new FileInputStream(new File(tempFile, i+"")));
        }  
        //使用 Enumeration（列举） 将文件全部列举出来  
        Enumeration<FileInputStream> eum = Collections.enumeration(list);  
        //SequenceInputStream合并流 合并文件  
        SequenceInputStream sis = new SequenceInputStream(eum);  
        FileOutputStream fos = new FileOutputStream(new File(dirFile, fileName));  
        byte[] by = new byte[100];  
        int len;  
        while((len=sis.read(by)) != -1){  
            fos.write(by, 0, len);  
        }  
        fos.flush();  
        fos.close();  
        sis.close();  
        System.out.println("合并完成！");  
    }  
}  