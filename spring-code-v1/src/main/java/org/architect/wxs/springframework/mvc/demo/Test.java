package org.architect.wxs.springframework.mvc.demo;

import org.architect.wxs.springframework.mvc.annotation.Controller;
import org.architect.wxs.springframework.mvc.annotation.RequestMapping;
import org.architect.wxs.springframework.mvc.annotation.RequestParam;

/**
 * {@link}
 *
 * @author wangxiaoshuai on 2020/3/30
 * @javadoc ：
 */
@Controller
public class Test {

    @RequestMapping("/test")
    public String test(@RequestParam("test")String test){
        return test;
    }


}
