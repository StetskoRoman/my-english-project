package com.rv.english.controllers;


import com.rv.english.models.workModels.Account;
import com.rv.english.services.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final AccountService accountService;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addAccount(@Valid Account account,
                             BindingResult bindingResult,
                             Model model,
                             @RequestParam("password2") String passwordConfirm
                             ) {
//BindingResult bindingResult between account and model necessary to work
        if (account.getEmail().isEmpty()) {
            model.addAttribute("emptyMail", "you forgot to fill your email");
            return "registration";
        }
        if (account.getAccountName().isEmpty()) {
            model.addAttribute("accountNameError", "account name must not be empty");
            return "registration";
        }
        if (account.getPassword().isEmpty()) {
            model.addAttribute("passwordError", "password must not be empty");
            return "registration";
        }

        if (account.getPassword() != null && !account.getPassword().equals(passwordConfirm)) {
            model.addAttribute("password2Error", "passwords are not equals");
            return "registration";
        }
        if (!accountService.createAccount(account)) {
            model.addAttribute("newUserError", "User already exist on this email! ");
            return "registration";
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("bindingError", "something went wrong");
            return "registration";
        }


        return "login";
    }
}
