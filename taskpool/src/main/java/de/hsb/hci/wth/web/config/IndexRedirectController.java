package de.hsb.hci.wth.web.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexRedirectController {

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse httpServletResponse) {
        return "redirect:" + request.getRequestURL().append("pages/home.xhtml").toString();
    }
}
