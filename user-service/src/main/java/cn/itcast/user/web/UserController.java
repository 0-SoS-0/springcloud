package cn.itcast.user.web;

import cn.itcast.user.config.prop.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private PatternProperties patternProperties;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "Truth", required = false) String truth   //验证gateway的过滤器配置
    ) {
        logger.info("请求头参数： {}", truth);
        return userService.queryById(id);
    }

    @GetMapping("now")
    public String getTimeNow() {
        String nowTimeString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));

        logger.info("当前日期 {}——{}", nowTimeString, patternProperties.getCommon());
        return nowTimeString;
    }
}
