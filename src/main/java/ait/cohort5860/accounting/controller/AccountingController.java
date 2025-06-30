package ait.cohort5860.accounting.controller;

import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import ait.cohort5860.accounting.service.AccountingService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountingController {

    private final AccountingService accountingService;

    @PostMapping("/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return accountingService.registerUser(userDto);
    }

    @PostMapping("/login")
    public UserDto login(@RequestHeader("Authorization") String authorization) {
        return accountingService.login(authorization);
    }

    @DeleteMapping("/user/{login}")
    public void deleteUser(@PathVariable String login, @RequestHeader("Authorization") String authorization) {
        accountingService.deleteUser(login, authorization);
    }

    @PatchMapping("/user/{login}")
    public UserDto updateUser(@PathVariable String login, @RequestBody UserUpdateDto userUpdateDto, 
                              @RequestHeader("Authorization") String authorization) {
        return accountingService.updateUser(login, userUpdateDto, authorization);
    }

    @PatchMapping("/user/{login}/role/{role}")
    public UserDto addRole(@PathVariable String login, @PathVariable String role, 
                           @RequestHeader("Authorization") String authorization) {
        return accountingService.addRole(login, role, authorization);
    }

    @DeleteMapping("/user/{login}/role/{role}")
    public UserDto deleteRole(@PathVariable String login, @PathVariable String role, 
                              @RequestHeader("Authorization") String authorization) {
        return accountingService.deleteRole(login, role, authorization);
    }

    @PatchMapping("/password")
    public UserDto changePassword(@RequestHeader("Authorization") String authorization, 
                                  @RequestHeader("X-Password") String newPassword) {
        return accountingService.changePassword(authorization, newPassword);
    }

    @GetMapping("/user/{login}")
    public UserDto getUser(@PathVariable String login, @RequestHeader("Authorization") String authorization) {
        return accountingService.getUser(login, authorization);
    }
}
