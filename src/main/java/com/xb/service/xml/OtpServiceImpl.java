package com.xb.service.xml;

import com.xb.service.OtpService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OtpServiceImpl implements OtpService {
    private final Random random;

    private final Map<String, String> registeredUsers = new HashMap<>();

    public OtpServiceImpl(Random random) {
        this.random = random;
    }


    @Override
    public String registerForOtp(String mobileNumber) {
        String otp = generateOtp();
        registeredUsers.put(mobileNumber, otp);
        return otp;
    }

    private String generateOtp() {
        int otp = 100_000 + random.nextInt(900_000);
        return String.valueOf(otp);
    }

    @Override
    public String getOtp(String mobileNumber) {
        String otp = registeredUsers.get(mobileNumber);
        if (otp == null) {
            throw new IllegalArgumentException("Mobile number not found or OTP expired");
        }
        return otp;
    }
}
