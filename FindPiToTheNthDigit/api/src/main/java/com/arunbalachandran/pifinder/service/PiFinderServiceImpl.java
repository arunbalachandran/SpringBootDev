package com.arunbalachandran.pifinder.service;

import com.arunbalachandran.pifinder.dto.PiDTO;
import org.springframework.stereotype.Service;

@Service
public class PiFinderServiceImpl implements PiFinderService {
    
    @Override
    public boolean isValid(PiDTO piDTO) {
        // this check needs to improve as getPrecision cannot take null value (java behavior)
        return piDTO != null && piDTO.getPrecision() != 0;
    }
}
