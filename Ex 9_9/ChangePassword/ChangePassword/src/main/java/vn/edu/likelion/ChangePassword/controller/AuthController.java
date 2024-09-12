package vn.edu.likelion.ChangePassword.controller;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import vn.edu.likelion.ChangePassword.entity.AuthEntity;
import vn.edu.likelion.ChangePassword.model.requestDto.LoginUserDto;
import vn.edu.likelion.ChangePassword.model.requestDto.PasswordDto;
import vn.edu.likelion.ChangePassword.model.requestDto.RegisterUserDto;
import vn.edu.likelion.ChangePassword.model.responseDto.GenericResponse;
import vn.edu.likelion.ChangePassword.model.responseDto.LoginResponse;
import vn.edu.likelion.ChangePassword.service.AuthService;
import vn.edu.likelion.ChangePassword.service.tmp.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    //    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private AuthService userService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    // Change user password
    @PostMapping("/user/updatePassword")
    public GenericResponse changeUserPassword(@RequestBody PasswordDto passwordDto) {

//        UserDetails user = userService.findUserByUsername(((AuthEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User object = (User) authentication.getPrincipal();
        String username = object.getUsername();
        AuthEntity user = userService.findUserByUsername(username);

//        AuthEntity user = userService.findUserByUsername("admin");

//        if (!userService.checkIfValidOldPassword(user, passwordDto.getOldPassword())) {
//            throw new InvalidOldPasswordException();
//        }
//        AuthEntity userAuth = AuthEntity.builder().username(user.getUsername())
//                .email(user.)
//                .build();
        userService.changeUserPassword(user, passwordDto.getNewPassword());
        return new GenericResponse(messages.getMessage("message.updatePasswordSuc", null, locel));
//        return "change success";
    }

    @PostMapping("/register")
    public ResponseEntity<AuthEntity> register(@RequestBody RegisterUserDto registerUserDto) {
        AuthEntity registeredUser = userService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        AuthEntity authenticatedUser = userService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/reset-password")
    @Transactional
    public ResponseEntity<?> requestPasswordReset(@RequestParam String username) {
        AuthEntity user = userService.findUserByUsername(username);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        // 2. Tạo token đặt lại mật khẩu
//        String token = userService.generateResetPasswordToken();

        // 3. Lưu token vào cơ sở dữ liệu
//        userService.saveResetPasswordToken(user, token);

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setTo("xmenhvt@gmail.com");
            helper.setSubject("Xác nhận thay đổi mật khẩu");

            Context context = new Context();
            context.setVariable("subject", "Doi mat khau");
            context.setVariable("message", "Doi mat khau");

            String htmlContent = templateEngine.process("forgotPassword", context);
            helper.setText(htmlContent, true);

            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi gửi email xác nhận");
        }

        return ResponseEntity.ok("Reset password request sent. Please check your email.");
    }


}
