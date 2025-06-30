package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;

public interface AccountingService {
    UserDto registerUser(UserDto userDto);

    UserDto login(String authorization);

    void deleteUser(String login, String authorization);

    UserDto updateUser(String login, UserUpdateDto userUpdateDto, String authorization);

    UserDto addRole(String login, String role, String authorization);

    UserDto deleteRole(String login, String role, String authorization);

    UserDto changePassword(String authorization, String newPassword);

    UserDto getUser(String login, String authorization);
}
