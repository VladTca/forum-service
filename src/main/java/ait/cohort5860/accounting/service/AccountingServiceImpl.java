package ait.cohort5860.accounting.service;

import ait.cohort5860.accounting.dto.UserDto;
import ait.cohort5860.accounting.dto.UserUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class AccountingServiceImpl implements AccountingService {

    @Override
    public UserDto registerUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto login(String authorization) {
        return null;
    }

    @Override
    public void deleteUser(String login, String authorization) {

    }

    @Override
    public UserDto updateUser(String login, UserUpdateDto userUpdateDto, String authorization) {
        return null;
    }

    @Override
    public UserDto addRole(String login, String role, String authorization) {
        return null;
    }

    @Override
    public UserDto deleteRole(String login, String role, String authorization) {
        return null;
    }

    @Override
    public UserDto changePassword(String authorization, String newPassword) {
        return null;
    }

    @Override
    public UserDto getUser(String login, String authorization) {
        return null;
    }
}
