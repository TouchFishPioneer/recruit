package cn.herculas.recruit.service.implement;

import cn.herculas.recruit.service.JsonWebTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JsonWebTokenServiceImplTest {

    @Autowired
    private JsonWebTokenService jsonWebTokenService;

    @Test
    public void createJsonWebToken() {
        System.out.println(jsonWebTokenService.createJsonWebToken("wurahara"));
    }


    @Test
    public void parseJsonWebToken() {
        String test = jsonWebTokenService.createJsonWebToken("wurahara");
        System.out.println(test);
        System.out.println(jsonWebTokenService.parseJsonWebToken(test));
    }
}