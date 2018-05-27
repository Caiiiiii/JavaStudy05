package com.Controller;

import com.VO.User;
import com.VO.UserVO;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
//    @RequestMapping("/selectUser")
//    public String selectUser(HttpServletRequest request){
//        String id = request.getParameter("id");
//        System.out.print("id ="+id);
//        return "success";
//    }
//
//    @RequestMapping("/toUser")
//    public String selectUsers(){
//        return "user";
//    }
//
//    @RequestMapping("/deleteUsers")
//    public String deleteUsers(Integer[] ids){
//        if (ids != null){
//            for (Integer id : ids
//                 ) {
//                System.out.println("删除了id为"+id+"的用户！");
//            }
//        }else {
//            System.out.println("ids=null");
//        }
//        return "success";
//    }
//
//    @RequestMapping("/toUserEdit")
//    public String toUserEdit(){
//        return "user_edit";
//    }
//
//    @RequestMapping("/editUsers")
//    public String editUsers(UserVO userList){
//        List<User> users = userList.getUsers();
//        for (User user: users
//             ) {
//            if(user.getId() != null){
//                System.out.println("修改了id为" +user.getId()+"的用户名为："+user.getUsername());
//            }
//        }
//        return "success";
//    }

    @RequestMapping("/textJson")
    @ResponseBody
    public User testJson(@RequestBody User user){
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();

        if (username != null && username.equals("xiaoxue") &&password !=null && password.equals("123456")){
            session.setAttribute("USER_SESSION",user);
            return "redirect:main";
        }

        model.addAttribute("msg","用户名或密码错误！");
        return "login";
    }

    @RequestMapping(value = "/main")
    public String toMain(){
        return "main";
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }
}
