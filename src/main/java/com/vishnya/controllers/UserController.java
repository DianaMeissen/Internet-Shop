package com.vishnya.controllers;

import com.vishnya.model.User;
import com.vishnya.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ConnectionRepository connectionRepository;

    @Autowired
    private Facebook facebook;


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView vm) {
        vm.setViewName("login");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute User user, ModelAndView vm) {
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.GET)
    public ModelAndView register(ModelAndView vm) {
        vm.setViewName("signup");
        vm.addObject("user", new User());
        return vm;
    }

    @RequestMapping(path = "/signup", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute User user, ModelAndView vm) {
        vm.setViewName("welcome");
        vm.addObject("user", userService.addUser(user));
        return vm;
    }

    @RequestMapping(path = "/activate-user/{token}", method = RequestMethod.GET)
    public ModelAndView activate(@PathVariable String token, ModelAndView vm) {
        User user = userService.findByToken(token);
        userService.activate(user);
        vm.setViewName("activation");
        return vm;
    }

    @RequestMapping("/social")
    public String helloFacebook(Model vm) {
        /*if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }*/

        //vm.addAttribute("facebookProfile", facebook.userOperations().getUserProfile());
        return "social";
    }

}
