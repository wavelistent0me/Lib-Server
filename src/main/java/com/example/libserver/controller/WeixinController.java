package com.example.libserver.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.libserver.common.AjaxResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libserver/wx")
public class WeixinController {

/*
    @PostMapping("login")
    public AjaxResult login(@RequestParam String code) {
        //请求微信API
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={APPID}&secret={SECRET}&js_code={JSCODE}&grant_type=authorization_code";
        String replaceUrl = url.replace("{APPID}", appid).replace("{SECRET}", secret).replace("{JSCODE}", code);
        String res = HttpUtil.get(replaceUrl);

        System.out.println(res);

        String openid = (String) JSONUtil.parseObj(res).get("openid");
        sessionKey = (String) JSONUtil.parseObj(res).get("session_key");

        //查询数据库
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("open_id", openid);
        User user = userService.getOne(wrapper);

        if (user == null) {
            //注册
            user = new User();
            user.setOpenId(openid);

            return this.register(user);
        }
        else {
            //登录成功
            return this.login(user);
        }

        return AjaxResult.Success();
    }
*/
}

