package com.rcoem.deveops.Interface;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")

public class DeveopsController {

    @GetMapping
    String Helloworld(){
        return "Hello world";
    }
    @GetMapping("/{id}")
    String Helloworld(@PathVariable String id){
        return "hello"+ id;
    }
    @PostMapping
    String addSomething(){
        return "Add something";
    }

}
