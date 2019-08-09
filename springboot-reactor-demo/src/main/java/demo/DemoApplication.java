package demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    /*@GetMapping("/main/{pathVariable}")
    public void temp(@PathVariable String pathVariable, HttpServletRequest request) {
        String attr = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        logger.info("Request /main page. pathVariable : {}, attr : {} / uri : {} / url : {}"
            , pathVariable, attr, request.getRequestURI(), request.getRequestURL());
    }*/
}
