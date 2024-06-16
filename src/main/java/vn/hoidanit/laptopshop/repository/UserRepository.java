package vn.hoidanit.laptopshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User chihieu);

    List<User> findByAddressAndPhone(String address, String phone);

    List<User> findAll();

    Optional<User> findById(Long id);

    void deleteById(Long id);

    boolean existsByEmail(String email);
}
