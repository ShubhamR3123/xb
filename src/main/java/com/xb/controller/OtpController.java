package com.xb.controller;

import com.xb.dto.GetRegisterRequestDTO;
import com.xb.dto.OtpResponseDto;
import com.xb.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OtpController {
    private final OtpService otpService;

    @Autowired
    public OtpController(OtpService otpService) {
        this.otpService = otpService;
    }

    @PostMapping("/register-otp")
    public ResponseEntity<OtpResponseDto> registerForOtp(@RequestBody GetRegisterRequestDTO requestDTO) {
        String generatedOtp = otpService.registerForOtp(requestDTO.getMobileNo());
        OtpResponseDto responseDTO = new OtpResponseDto();
        responseDTO.setOtp(generatedOtp);
        return ResponseEntity.ok(responseDTO);
    }
   // http://localhost:7877/api/register-otp
  //  payload={mobileNo:""} both get and register
//http://localhost:7877 /api/get-otp?mobileNumber=9139773752
    @GetMapping("/get-otp")
    public ResponseEntity<OtpResponseDto> getOtp(@RequestParam String mobileNumber) {
        String otp = otpService.getOtp(mobileNumber);
        if (otp == null) {
            return ResponseEntity.notFound().build();
        }
        OtpResponseDto responseDTO = new OtpResponseDto();
        responseDTO.setOtp(otp);
        return ResponseEntity.ok(responseDTO);
    }
}


