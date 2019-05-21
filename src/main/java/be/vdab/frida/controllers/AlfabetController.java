package be.vdab.frida.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;

@Controller
@RequestMapping("alfabet")
class AlfabetController {
    char alfabet[] = "abcdefghijklmnop".toCharArray();

    @GetMapping
    public ModelAndView toonPagina(@CookieValue(name = "id", required = false) String id) {

        ModelAndView mav = new ModelAndView("alfabet", "letter", alfabet);

        if (id == null) {
            Cookie koekje = new Cookie("letter", id);
            return mav;
        }
        return mav;
    }
}
