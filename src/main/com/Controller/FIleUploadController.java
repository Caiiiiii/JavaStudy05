package com.Controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
public class FIleUploadController {
    @RequestMapping("/fileUpload")
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("uploadfile")
    List<MultipartFile> uploadfile, HttpServletRequest request){
        if (!uploadfile.isEmpty() && uploadfile.size() > 0){
            for (MultipartFile file:uploadfile
                 ) {
                String orignalFilename = file.getOriginalFilename();
                String dirPath =request.getServletContext().getRealPath("/upload/");
                File filePath = new File(dirPath);
                if(!filePath.exists()){
                    filePath.mkdirs();
                    System.out.println("文件已创建，地址为："+dirPath);
                }
                String newFilename = name +"_"+ UUID.randomUUID() + "_"+orignalFilename;
                try {
                    file.transferTo(new File(dirPath + newFilename));
                } catch (IOException e) {
                    e.printStackTrace();
                    return "error";
                }
            }
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request,String filename) throws Exception{
        String path = request.getServletContext().getRealPath("/upload/");
        File file = new File(path+File.separator+filename);
        filename = this.getFilename(request,filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.OK);
    }

    public String getFilename(HttpServletRequest request,String filename) throws UnsupportedEncodingException {
        String[] IEBrowerKeyWords = {"MSIE","Trident","Edge"};
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowerKeyWords){
            if (userAgent.contains(keyWord)){
                return URLEncoder.encode(filename,"UTF-8");
            }
        }
        return new String(filename.getBytes("UTF-8"),"ISO-8859-1");
    }
}
