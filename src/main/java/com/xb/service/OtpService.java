package com.xb.service;

import com.xb.dto.GetRegisterRequestDTO;
import com.xb.dto.OtpResponseDto;

public interface OtpService {

    String registerForOtp(String mobileNumber);

    String getOtp(String mobileNumber);

}
