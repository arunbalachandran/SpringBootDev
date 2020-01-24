package com.arunbalachandran.pifinder.api;
import com.arunbalachandran.pifinder.dto.PiDTO;
import com.arunbalachandran.pifinder.service.PiFinderService;
import java.text.*;
import java.util.*;
import java.math.BigDecimal;
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

    // TODO: simplify this - without using the DTO
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity < String > persistPerson(@RequestBody PiDTO piobj) {
        if (pifinderservice.isValid(piobj)) {
            // well under the limit of a double (~10^300)
            // looks like this doesn't work - may need to rework the precision
            BigDecimal piUpto100Places = new BigDecimal(3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679); 
            DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
            df.setMaximumFractionDigits(piobj.getPrecision());
            return ResponseEntity.ok(df.format(piUpto100Places));
        }
        // otherwise
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

}