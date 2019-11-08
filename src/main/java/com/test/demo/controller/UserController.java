package com.test.demo.controller;

import com.test.demo.entity.Result;
import com.test.demo.entity.User;
import com.test.demo.service.UserService;
import com.test.demo.util.ResultUtil;
import com.test.demo.util.SendSmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zzh
 * @create 2019-08-18 22:38
 * @desc 用户controller
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    private String vcode;

    @GetMapping("/getVerifyCode")
    public Result getVerifyCode(@RequestParam(value = "phoneNum", required = true) String phoneNum){
        String smsResult = null;
        Result result = null;
        vcode = service.vcode();
        System.out.println("--vcode--" + vcode);
        smsResult = SendSmsUtil.SendSms(vcode, phoneNum);
        result = ResultUtil.getSearchResult(smsResult);
        return result;
    }

    @GetMapping("/getUserList")
    public Result getUserList(){
        Result result = null;
        result = service.getUserList();
        return result;
    }

    /**
     * 功能描述: 登录
     * @param:
     * @return:
     * @auther: zzh
     * @date: 2019-08-18 22:42
     */
//    @PostMapping("/login")
//    public Result login(@RequestParam(value = "password", required = true) String password,
//                        @RequestParam(value = "phone", required = true) String phone,
//                        @RequestParam(value = "type", required = true) String type){
//        User user = new User();
//        user.setUserId(phone);
//        user.setUserName(phone);
//        user.setArea("");
//        user.setBirthday(null);
//        user.setBriefIntroduction("");
//        user.setHeadPortrait("");
//        user.setSex("");
//        user.setUserType(1);
//        user.setVipLevel(1);
//
//        Result result = null;
//        result = service.insertUser(user);
//        return result;
//    }



    @PostMapping("/login")
    public Result login(@RequestParam(value = "phoneNum", required = true) String phoneNum,
                        @RequestParam(value = "code", required = true) String code){
        Result result = null;
        System.out.println("--login--");
        System.out.println("--vcode--" + vcode+ "--code--" + code);
        User userGet = service.getUserById(phoneNum);
        if (code.equals(vcode) && userGet == null) {
            User user = new User();
            user.setUserId(phoneNum);
            user.setUserName(phoneNum);
//        user.setArea("");
//        user.setBirthday(null);
//        user.setBriefIntroduction("");
//        user.setHeadPortrait("");
//        user.setSex("");
//        user.setUserType(1);
//        user.setVipLevel(1);
            result = service.insertUser(user);
        } else if (code.equals(vcode) && userGet != null) {
            result = ResultUtil.getInsertResult(userGet);
        } else {
            result = ResultUtil.getInsertResult(null);
        }

        return result;
    }

}
