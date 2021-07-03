package com.nowcoder.lyx.community;

import com.nowcoder.lyx.community.util.SensitiveFilter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {
    @Autowired
    private SensitiveFilter filter;

    @Test
    public void testSensitiveFilter(){
        String text = "可以赌博，可以*吸*毒";
        text = filter.filter(text);
        System.out.println(text);
    }
}
