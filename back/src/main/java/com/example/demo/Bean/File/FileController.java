package com.example.demo.Bean.File;

import com.example.demo.Bean.Result;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin
public class FileController {
    private String uploadPath="D:/GitDepository/gitee/JShop/productImage";
    FileController(){
//        uploadPath="";
//        File directory = new File("");//参数为空
//        String courseFile = null;
//        try {
//            courseFile = directory.getCanonicalPath();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for(int i=0;i<courseFile.length();++i){
//            if(courseFile.charAt(i)=='\\'){
//                uploadPath+="/";
//            }else{
//                uploadPath+=courseFile.charAt(i);
//            }
//        }
//        uploadPath+="/src/main/resources/static/goodsImages/";
//        System.out.println(uploadPath);
    }

    @RequestMapping("/fileupload")
    public Result fileupload(MultipartFile file, HttpServletRequest request) throws Exception, IOException {
        System.out.println("上传");
        File folder = new File(uploadPath );
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        // 对上传的文件重命名，避免文件重名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
//        System.out.println("http://localhost:8080/shop/goodsImages/"+newName);
        try {
            // 文件保存
            file.transferTo(new File(folder, newName));
            // 返回上传文件的访问路径
//            String filePath = request.getScheme() + "://" + request.getServerName()
//                    + ":" + request.getServerPort() + "" + request.getContextPath() + "/"  + newName;
            //返回文件名
            return Result.ok().put("data",newName);
        } catch (IOException e) {
            Result.error(e.getMessage());
        }
        return Result.error();
    }
}
