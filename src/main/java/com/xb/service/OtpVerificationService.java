package com.xb.service;

import com.xb.dto.OtpVerificationResponseDto;

public interface OtpVerificationService {
    OtpVerificationResponseDto verifyOtp(String otpValue, String mobileNumber);

}
