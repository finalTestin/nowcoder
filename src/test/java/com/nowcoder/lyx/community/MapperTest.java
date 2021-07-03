package com.nowcoder.lyx.community;

import com.nowcoder.lyx.community.dao.DiscussPostMapper;
import com.nowcoder.lyx.community.dao.LoginTicketMapper;
import com.nowcoder.lyx.community.dao.MessageMapper;
import com.nowcoder.lyx.community.dao.UserMapper;
import com.nowcoder.lyx.community.entity.DiscussPost;
import com.nowcoder.lyx.community.entity.LoginTicket;
import com.nowcoder.lyx.community.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for (DiscussPost post : list){
            System.out.println(post);
        }
        System.out.println(discussPostMapper.selectDiscussPostRows(0));
    }
    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("test");
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));

        loginTicketMapper.insertLoginTicket(loginTicket);
    }
}
