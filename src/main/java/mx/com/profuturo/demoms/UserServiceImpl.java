package mx.com.profuturo.demoms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
     @Autowired
     private UserRepository userRepository;
     @Override
     public Boolean saveUser(User user) {
          try {
               userRepository.save(user);
               return true;
          } catch (Exception e) {
               return false;
          }
     }
}
