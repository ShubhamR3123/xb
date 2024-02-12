package com.xb.service.xml;

import com.xb.dto.OtpVerificationResponseDto;
import com.xb.service.OtpService;
import com.xb.service.OtpVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpVerificationServiceImpl implements OtpVerificationService {
    private final OtpService otpService;

    @Autowired
    private OtpVerificationResponseDto responseDto;

    public OtpVerificationServiceImpl(OtpService otpService) {
        this.otpService = otpService;
    }

    @Override
    public OtpVerificationResponseDto verifyOtp(String otpValue, String mobileNumber) {
        try {    // Retrieve the mobile number associated with the OTP
            String storedOtp = otpService.getOtpForMobileNumber(otpValue);

            if (storedOtp != null && storedOtp.equals(otpValue)) {
                responseDto.setStatusMsg("OTP Verified");
                responseDto.setFlag(true);
                responseDto.setExistingUser(false);
                // Generate and set the token
                String token = generateToken(); // You need to implement this method
                responseDto.setToken(token);
            } else {
                // Invalid OTP
                responseDto.setStatusMsg("Invalid OTP");
                responseDto.setFlag(false);
                responseDto.setExistingUser(false);
                responseDto.setToken(null);
            }
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Set error response
            responseDto.setStatusMsg("Error verifying OTP");
            responseDto.setFlag(false);
            responseDto.setExistingUser(false);
            responseDto.setToken(null);
        }

        return responseDto;
    }


    private String generateToken() {
        // Implementation to generate token
        return "generated-token";
    }
}

