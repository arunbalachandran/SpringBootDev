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

    @RequestMapping(value = "/", method = RequestMethod.POST)
    String processPi() {
        // TODO: add boiler plate code that reads the input parameter
        return 3.141519;
    }
    public ResponseEntity < String > persistPerson(@RequestBody PersonDTO person) {
        if (personService.isValid(person)) {
            personRepository.persist(person);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(FindPi.class, args);
    }
}