package se2.project.BookSocial.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se2.project.BookSocial.dto.UserDto;
import se2.project.BookSocial.model.User;
import se2.project.BookSocial.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getFullname(), userDto.getRole());
        return userRepository.save(user);
    }
}
