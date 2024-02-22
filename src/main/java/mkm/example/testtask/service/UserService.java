package mkm.example.testtask.service;

import lombok.AllArgsConstructor;
import mkm.example.testtask.entity.UserEntity;
import mkm.example.testtask.repo.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    UserRepo userRepo;
    private BCryptPasswordEncoder encoder() { return new BCryptPasswordEncoder();}
    public void saveUSer(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }

}
