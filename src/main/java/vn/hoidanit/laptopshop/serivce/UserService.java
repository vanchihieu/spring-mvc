package vn.hoidanit.laptopshop.serivce;

import org.springframework.stereotype.Service;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByAddressAndPhone(String address, String phone){
        return this.userRepository.findByAddressAndPhone(address, phone);
    }

    public User handleSaveUser(User user) {
        User hieu = this.userRepository.save(user);
        System.out.println(hieu);
        return hieu;
    }

    public User getUserById(Long id) {
        return this.userRepository.findById(id).orElse(null);
    }
}
