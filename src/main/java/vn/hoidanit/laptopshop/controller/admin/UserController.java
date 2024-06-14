package vn.hoidanit.laptopshop.controller.admin;

import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.serivce.UploadService;
import vn.hoidanit.laptopshop.serivce.UserService;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService,UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")
    public String getHomePage() {
//        List<User> arrUser = this.userService.getAllUsers();
        List<User> address = this.userService.getAllUsersByAddressAndPhone("2344", "0334225101");
        System.out.println(address);
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUser(Model model,
                             @ModelAttribute("newUser") @Valid User user,
                             BindingResult bindingResult,
                             @RequestParam("chihieuFile") MultipartFile file
                             ) {
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors ) {
            System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
        }

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());

        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));

        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/{id}/edit") // GET
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update") // POST
    public String getUpdateUser(Model model, @ModelAttribute("newUser") User user) {
        User currentUser = this.userService.getUserById(user.getId());
        if (currentUser != null) {
            currentUser.setFullName(user.getFullName());
            currentUser.setAddress(user.getAddress());
            currentUser.setPhone(user.getPhone());
            this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{id}/delete")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);

        model.addAttribute("newUser", this.userService.getUserById(id));
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String getDeleteUser(Model model, @ModelAttribute("newUser") User user) {
        this.userService.deleteUserById(user.getId());
        return "redirect:/admin/user";
    }
}
