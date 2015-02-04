package com.thymeweb.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
@RequestMapping(value = "/notifications")
public class NotificationController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public DeferredResult<Integer> getNotifications(@RequestParam(value = "counter") int counter) {
        final DeferredResult<Integer> deferredResult = new DeferredResult<>();
//        deferredResult.setResult(new Random().nextInt(10000 - 1 + 1) + 1);
        deferredResult.setResult(counter + 1);
        return deferredResult;
    }
}
