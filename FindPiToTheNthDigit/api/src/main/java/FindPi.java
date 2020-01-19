import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class FindPi {

    @RequestMapping("/")
    String home() {
        return "Enter the number of digits you want Pi to be precise for";
    }

    public static void main(String[] args) {
        SpringApplication.run(FindPi.class, args);
    }
}