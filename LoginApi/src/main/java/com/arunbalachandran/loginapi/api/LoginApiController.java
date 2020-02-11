package com.arunbalachandran.loginapi.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.arunbalachandran.loginapi.UserProtos;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class LoginApiController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "Post proto data to this endpoint";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String userPost(InputStream dataStream) throws IOException {
        UserProtos.User inputUser = UserProtos.User.parseFrom(dataStream);
        return "The data posted was test " + inputUser.getEmail();
    }
}
