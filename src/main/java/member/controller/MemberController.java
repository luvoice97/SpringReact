package member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="member")
@CrossOrigin(origins = "http://localhost:3000",allowCredentials="true")
public class MemberController {
		
@Autowired
private UserService userService;

@Autowired
private UserDTO userDTO;

@GetMapping(value = "login")
@ResponseBody
public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd) {

    Map<String, String> map = new HashMap<>();
    map.put("id", id);
    map.put("pwd", pwd);
    

    UserDTO userDTO = userService.login(map);
    
    if (userDTO == null) {
        return "fail";
    }
    return userDTO.getName();
}
}
