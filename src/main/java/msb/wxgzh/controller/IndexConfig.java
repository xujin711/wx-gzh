package msb.wxgzh.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;

@Controller
public class IndexConfig {

    @RequestMapping("/")
    public String index(Model model, HttpServletResponse response) {
//        model.addAttribute("name", "simonsfan");
//        return "/index";
//        return "forward:/index.html";
//        return "forward:/index.html";
        return "forward:/index.html";
    }

}

//@Configuration
//@RestController
//public class IndexConfig extends WebMvcConfigurerAdapter {
//
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        super.addViewControllers(registry);
//    }
//
//    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        ModelAndView view = new ModelAndView();
//        view.setViewName("index");
//        return view;
//    }
//}