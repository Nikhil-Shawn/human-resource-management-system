package com.humanresourcemanagementsystem.Controller.AuthController;

import com.humanresourcemanagementsystem.Dto.LoginDTO;
import com.humanresourcemanagementsystem.Service.LoginService;
import com.humanresourcemanagementsystem.response.ResponseData;
import com.humanresourcemanagementsystem.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO, HttpServletResponse response) {

        return loginEmployee(loginDTO, response);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {

        loginService.logoutEmployee(response);
        return ResponseEntity.ok("Logout successful");
    }

    private ResponseEntity<?> loginEmployee(LoginDTO loginDTO, HttpServletResponse response) {

        ResponseData ResponseData = loginService.loginEmployee(loginDTO);
        if (ResponseData != null && ResponseData.getsuccess()) {
            jwtUtil.setTokenCookie(response, (String) ResponseData.getData().get("token"));
        }
        return ResponseEntity.ok(ResponseData);
    }
}