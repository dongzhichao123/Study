package com.springcloud.controller;


import com.springcloud.Serice.PaymentService;
import com.springcloud.entity.CommonResult;
import com.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PayMentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private int serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("插入成功" + i);
        if (i > 0) {
            return new CommonResult(200, "数据插入成功" + serverPort, i);
        } else {
            return new CommonResult(444, "插入数据库失败" + serverPort, i);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        log.info("***************查询成功*********" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功"+serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败"+serverPort, null);
        }
    }

}