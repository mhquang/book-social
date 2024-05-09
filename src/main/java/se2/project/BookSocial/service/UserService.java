package se2.project.BookSocial.service;

import se2.project.BookSocial.dto.UserDto;
import se2.project.BookSocial.model.User;

public interface UserService {
    User save(UserDto userDto);
}
