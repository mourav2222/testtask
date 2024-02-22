package mkm.example.testtask.security;

import lombok.AllArgsConstructor;
import mkm.example.testtask.entity.UserEntity;
import mkm.example.testtask.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    UserRepo userRepo;

    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepo.findByEmail(username)
                    .orElseThrow(() -> new UsernameNotFoundException(String.format("User with email '%s' not found", username)));
        return UserDetailsImpl.build(userEntity);
    }
}
