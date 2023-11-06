package Services;

import Models.User;
import Repositories.UserRepository;
import RequestDTOs.AddUserRequest;
import Transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public String addUser(AddUserRequest addUserRequest) {

        User userObj = UserTransformer.convertAddUserReqToUserEntity(addUserRequest);
        userRepository.save(userObj);


        return "User added successfully";
    }
}
