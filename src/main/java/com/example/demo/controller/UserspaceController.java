package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;

@Controller
@RequestMapping("/u")
public class UserspaceController {
    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username){
        System.out.println("username"+username);
        return "/userspace/u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value="order",required = false,defaultValue = "new") String order,
                                   @RequestParam(value="category",required=false) Long category,
                                   @RequestParam(value="keyword",required=false) String keyword){
        if(category!=null){
            System.out.print("category: "+category);
            System.out.print("selflink: redirect:/u/"+username+"/blogs?category="+category);
            return "/userspace/u";
        }else if(keyword!=null&& !keyword.isEmpty()){
            System.out.print("keyword"+keyword);
            System.out.print("selflink: redirect:/u/"+username+"/blogs?keyword="+keyword);
            return "/userspace/u";
        }
        return "error";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id){
        System.out.print("blogId: "+id);
        return "/userspace/blog";
    }

    @GetMapping("/{username}/blogs/edit")
    public String editBlog(){
        return "/userspace/blogedit";
    }

}
