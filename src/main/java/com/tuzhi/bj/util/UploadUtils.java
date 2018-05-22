package com.tuzhi.bj.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UploadUtils {
	 /**
     * 	多文件上传，方式三：利用MultipartHttpServletRequest来解析Request中的文件，用流的方式将文件存到磁盘
     *  使用流来存图片，保存到本地磁盘。
     *  jsp页面的input标签可以有不同的name属性值
     *  20180410添加了List<MultipartFile> files = multiRequest.getFiles(fileNames.next());//集成了多种情况
     * @author chunlynn
     */
    public static String upload(HttpServletRequest request) {

    	String urls = "";
        // 先实例化一个文件解析器
        CommonsMultipartResolver coMultiResolver = new CommonsMultipartResolver(request.getSession()
                .getServletContext());

        // 判断request请求中是否有文件上传
        if (coMultiResolver.isMultipart(request)) {

            //List<String> fileUrlList = new ArrayList<String>(); //用来保存文件路径
        	// 转换Request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            // 获得文件，方式二
            // Return an java.util.Iterator of String objects containing the parameter names of the multipart files contained in this request.
            // jsp页面的input标签可以有不同的name属性值
            Iterator<String> fileNames = multiRequest.getFileNames();
            while (fileNames.hasNext()) { //循环遍历
                List<MultipartFile> files = multiRequest.getFiles(fileNames.next()); //取出多个同名文件
                if (!files.isEmpty()) { //这个判断必须要加，下面的操作和单个文件就一样了
                   for (MultipartFile file : files) {//讲上面的getFile改写成geiFiles之后获取list就需要这里的遍历
                	   // 获得原始文件名
                       String originalName = file.getOriginalFilename();
                       String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
                       String fileName = uuid+originalName.substring(originalName.lastIndexOf("."));
                       //获得物理路径webapp所在路径
                       System.out.println("request.getSession().getServletContext().getRealPath(\"\") : "+request.getServletContext().getRealPath(""));
                       String pathRoot = request.getSession().getServletContext().getRealPath("");
                       // 项目下相对路径
                       String path = FILE_PATH + fileName;

                       try {
                           //创建输出流，用流将文件保存到指定目录
                           FileOutputStream fos = new FileOutputStream(pathRoot + path);
                           // 获得输入流
                           InputStream in = file.getInputStream();
                           int len = 0;
                           byte[] buffer = new byte[1024]; //创建缓冲区 1kB，byte表示一个字节B，1KB=1024B
                           // Reads some number of bytes from the inputstream and stores them into the buffer array b. 
                           while ((len = in.read(buffer)) != -1) { // 如果不用缓存，会一个字节一个字节的写，这样影响效率，效率低下
                               fos.write(buffer, 0, len); //每次1KB的方式写入
                           }
                           fos.flush();
                           fos.close();
                           in.close();

                       } catch (FileNotFoundException e) {
                           e.printStackTrace();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                       urls += ","+fileName;
				}
                }
            }
        }
        return urls.replaceFirst(",", "");
    }
    public static final String FILE_PATH = PropertiesUtil.getValue("UPLOAD_PATH"); //相对路径
}
