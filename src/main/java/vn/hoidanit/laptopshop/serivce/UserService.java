package vn.hoidanit.laptopshop.serivce;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User handleSaveUser(User user) {
        User hieu = this.userRepository.save(user);
        System.out.println(hieu);
        return hieu;
    }
}
