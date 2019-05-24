/**
 * 111
 */

package com.mmall.concurrency.example.threadLocal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/threadLocal")
public class ThreadLocalController {

    @RequestMapping(value = "test")
    @ResponseBody
    public Long test(){
        return RequstHolder.getId();
    }

}
