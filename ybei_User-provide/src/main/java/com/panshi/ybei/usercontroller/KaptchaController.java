package com.panshi.ybei.usercontroller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Api(tags = {"Google-kaptcha验证码"})
@RestController

public class KaptchaController {
    @Autowired
    DefaultKaptcha defaultKaptcha;
@Autowired
    private RedisTemplate<String,String> redisTemplate;

    @ApiOperation(value = "生成验证码")
    @GetMapping("/defaultKaptcha")
    public Boolean defaultKaptcha(HttpServletResponse httpServletResponse)
            throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String createText = defaultKaptcha.createText();
            //将图形验证码存入redis中设置过期时间
            redisTemplate.opsForValue().set("code",createText,90, TimeUnit.SECONDS);
            System.out.println(createText);
          /*  httpServletRequest.getSession().setAttribute("verificationCode", createText);*/
            // 使用生成的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);

        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
        return null;
    }

//    @ApiOperation(value = "校对验证码")
//    @PostMapping("/checkVerificationCode")
//    public void checkVerificationCode(@RequestParam(value = "verificationCode") String verificationCode, HttpServletRequest httpServletRequest) {
//        String verificationCodeIn = (String) httpServletRequest.getSession().getAttribute("0");
//        httpServletRequest.getSession().removeAttribute("verificationCode");
//        if (StringUtils.isEmpty(verificationCodeIn) || !verificationCodeIn.equals(verificationCode)) {
//            return Result.failureMsg("验证码错误，或已失效");
//        }
//        return Result.success();
//    }
}
