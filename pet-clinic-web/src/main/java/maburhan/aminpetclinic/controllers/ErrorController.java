package maburhan.aminpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

    @RequestMapping("oups")
    public String handleError(){
        return "error";
    }
}
