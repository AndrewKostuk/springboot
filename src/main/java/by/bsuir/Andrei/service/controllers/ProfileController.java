package by.bsuir.Andrei.service.controllers;

import by.bsuir.Andrei.service.security.details.UserDetailsImpl;
import by.bsuir.Andrei.service.transfer.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import static by.bsuir.Andrei.service.transfer.UserDto.from;

@Controller
public class ProfileController {
    @GetMapping("/")
    public String getProfilePage(Authentication authentication, ModelMap model) {
        if (authentication == null) {
            return "redirect:/login";
        }
        UserDetailsImpl details = (UserDetailsImpl) authentication.getPrincipal();
        UserDto user = from(details.getUser());
        model.addAttribute("user", user);
        return "profile";
    }
}
