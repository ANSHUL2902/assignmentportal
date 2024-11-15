package controller;

import model.User;
import service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.findByUsername(user.getUsername()).orElseThrow();
        // Implement JWT token generation logic here.
        return "Login successful";
    }
}
