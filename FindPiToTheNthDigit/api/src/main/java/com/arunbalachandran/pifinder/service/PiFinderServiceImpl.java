package com.arunbalachandran.pifinder.service;

import com.arunbalachandran.pifinder.dto.PiDTO;
import org.springframework.stereotype.Service;

@Service
public class PiFinderServiceImpl implements PiFinderService {
    
    @Override
    public boolean isValid(PiDTO piDTO) {
        return piDTO != null && piDTO.getPrecision() != null;
    }
}
