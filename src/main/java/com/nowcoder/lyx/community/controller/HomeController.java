package com.nowcoder.lyx.community.controller;

import com.nowcoder.lyx.community.entity.DiscussPost;
import com.nowcoder.lyx.community.entity.Page;
import com.nowcoder.lyx.community.entity.User;
import com.nowcoder.lyx.community.service.DiscussPostService;
import com.nowcoder.lyx.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    DiscussPostService discussPostService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getIndexPage(Model model, Page page){
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");
        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(),page.getLimit());
        List<Map<String, Object>> discussPosts = new ArrayList<>();
        for (DiscussPost post : list){
            Map<String, Object> map = new HashMap<>();
            map.put("post", post);
            User user = userService.findUserById(post.getUserId());
            map.put("user", user);
            discussPosts.add(map);
        }
        model.addAttribute("discussPosts", discussPosts);
        return "/index";
    }

    @RequestMapping(path = "/error", method = RequestMethod.GET)
    public String getErrorPage() {
        System.out.println("++++++++++++/error");
        return "/error/500";
    }

}
