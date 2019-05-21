package be.vdab.frida.controllers;

import be.vdab.frida.be.vdab.frida.domain.Adres;
import be.vdab.frida.be.vdab.frida.domain.Gemeente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Controller
    @RequestMapping("/")
    class IndexController {
    public String boodschap() {
        DayOfWeek weekdag = LocalDate.now().getDayOfWeek();
        if (weekdag == DayOfWeek.MONDAY || weekdag == DayOfWeek.THURSDAY) {
            return "GESLOTEN";
        } else {
            return "OPEN";
        }
    }

    @GetMapping
    public ModelAndView index(@CookieValue(name = "reedsBezocht", required = false)
                                      String reedsBezocht, HttpServletResponse response)
    {
        ModelAndView mv = new ModelAndView("index", "boodschap", boodschap());
        mv.addObject(new Adres("Victor Jacobslei", "68", new Gemeente("Berchem", 2600)));
        Cookie cookie = new Cookie("reedsBezocht", "ja");
        cookie.setMaxAge(31_536_000);
        cookie.setPath("/");
        response.addCookie(cookie);
        if (reedsBezocht != null)
        {
            mv.addObject("reedsBezocht", true);
        }
        return mv;
    }
}
