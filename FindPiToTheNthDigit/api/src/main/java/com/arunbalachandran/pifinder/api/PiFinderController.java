package com.arunbalachandran.pifinder.api;
import com.arunbalachandran.pifinder.dto.PiDTO;
import com.arunbalachandran.pifinder.service.PiFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiFinderController {

    @Autowired private PiFinderService pifinderservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Enter the number of digits you want Pi to be precise for";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PiDTO piobj) {
        if (pifinderservice.isValid(piobj)) {
            return ResponseEntity.ok("3.14");
        }
        // otherwise
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

}