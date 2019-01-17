package com.controller;

import com.entity.Seller;
import com.entity.SellerBcImg;
import com.entity.User;
import com.service.SellerBcImgService;
import com.service.SellerService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired(required = false)
    private SellerService sellerService;
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private SellerBcImgService sellerBcImgService;

    //商户注册
    @RequestMapping(value = "/sellerRegister")
    public Map sellerRegister(Seller seller, SellerBcImg sellerBcImg, Integer userid) {
        Map<String, Object> map = new HashMap<>();
        //查询User信息并修改is_seller字段
        User user = userService.selectByPrimaryKey(userid);
        if (user.getIsSeller() == 0) {
            user.setIsSeller(1);
            int isOk = userService.updateByPrimaryKeySelective(user);
            if (isOk > 0) {
                //插入Seller数据
                seller.setUserId(userid);
                int isOk2 = sellerService.insertSelective(seller);
                if (isOk2 > 0) {
                    sellerBcImg.setSellerId(userid);
                    int isOk3 = sellerBcImgService.insertSelective(sellerBcImg);
                    if (isOk3 > 0) {
                        map.put("status", "ok");
                        map.put("info", 1);
                    } else {
                        map.put("status", "no");
                        map.put("info", -1);
                    }
                } else {
                    map.put("status", "no");
                    map.put("info", -1);
                }
            } else {
                map.put("status", "no");
                map.put("info", -1);
            }
        } else if (user.getIsSeller() == 1) {
            map.put("status", "no");
            map.put("info", -9);//-9为已是商家，不予重新注册
        }
        return map;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(Integer userid, HttpServletRequest request, @RequestParam(value = "image", required = false) MultipartFile image) throws IOException {
        System.out.println("执行upload");
        System.out.println(image);

        request.setCharacterEncoding("UTF-8");
        if (!image.isEmpty()) {
            System.out.println("成功获取照片");
            String fileName = image.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = "D:\\JavaOperation\\IDEA\\TotalShop\\src\\main\\resources\\static\\SellerPhoto\\";
                    // 自定义的文件名称
                    String uuid = UUID.randomUUID().toString();
                    String trueFileName = uuid + "."+type;
                    // 设置存放图片文件的路径
                    path = realPath +  trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    image.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                    SellerBcImg sellerBcImg = new SellerBcImg();
                    //新增数据库
                    sellerBcImg.setSellerId(userid);
                    sellerBcImg.setImg(path);
                    int isOk = sellerBcImgService.insertSelective(sellerBcImg);
                    if(isOk>0){
                        return "success";
                    }else{
                        return "error";
                    }
                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            } else {
                System.out.println("文件类型为空");
                return "error";
            }
        } else {
            System.out.println("没有找到相对应的文件");
            return "error";
        }
    }
}

