package com.ws.springcloud.util;

import org.jodconverter.LocalConverter;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.jodconverter.office.OfficeUtils;

import java.io.File;
import java.io.IOException;

/**
 * USER: wang_s
 * DATE：2020/3/23
 * DESC：
 **/
public class Pdf {
    // 将word格式的文件转换为pdf格式
    public static void WordToPDF(String inputDoc, String outputPdf) throws IOException {
        String APP_PATH = "/usr/lib/libreoffice";

        File inputFile = new File(inputDoc);
        File outputFile = new File(outputPdf);
        //从本地建立连接
        OfficeManager officeManager = LocalOfficeManager.builder().officeHome(APP_PATH).build();
        try{
            officeManager.start();
            //转换
            LocalConverter.builder()
                    .officeManager(officeManager)
                    .build()
                    .convert(inputFile)
                    .to(outputFile)
                    .execute();
        }catch(OfficeException e){
            //捕捉异常自定义操作
        }finally{
            //关闭office连接
            OfficeUtils.stopQuietly(officeManager);
        }
    }

    public static void main(String[] args) throws Exception{
        String source = "/home/ws/下载/王淞java求职简历-1.docx";
        String target = "/home/ws/下载/zh.pdf";
        Pdf.WordToPDF(source,target);

    }
}
