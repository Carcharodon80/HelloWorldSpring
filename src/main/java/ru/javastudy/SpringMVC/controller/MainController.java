package ru.javastudy.SpringMVC.controller;

import ru.javastudy.SpringMVC.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    //Первый метод на старте приложения (см. параметры аннотации и настройки пути деплоя)
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userJSP", new User());
        modelAndView.setViewName("index");

        return modelAndView;
    }

    /*как только на index.jsp подтвердится форма
      <spring:form method="post"  modelAttribute="userJSP" action="check-user">,
      то попадем вот сюда
       */
    @RequestMapping(value = "/check-user")
    public ModelAndView checkUser(@ModelAttribute("userJSP") User user) {
        ModelAndView modelAndView = new ModelAndView();

        //имя представления, куда нужно будет перейти
        modelAndView.setViewName("secondPage");

        //записываем в атрибут userJSP(на странице *.jsp используется объект user)
        modelAndView.addObject("userJSP", user);

        return modelAndView;
    }

}
