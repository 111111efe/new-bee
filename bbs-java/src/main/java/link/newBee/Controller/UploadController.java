package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.annocation.Log;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.QiniuUtil;
import link.newBee.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController{


    /**
     * 上传文件到七牛云存储
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping( path = {"/qiniu", "/qiniu/**"},consumes = {"multipart/form-data"}, method = {RequestMethod.POST, RequestMethod.PUT})
    public Result<String> uploadImgQiniu(@RequestParam("file") MultipartFile multipartFile)  {
        FileInputStream inputStream = null;
        String path = null;
        try {
            inputStream = (FileInputStream) multipartFile.getInputStream();
            path = QiniuUtil.uploadImg(inputStream);
            if(StringUtils.isNoneEmpty(path)){
                 return Result.ok(path);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return Result.error(path,"上传失败");


    }


}
