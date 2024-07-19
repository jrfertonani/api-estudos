package api.services;

import api.domain.User;
import api.domain.dto.userDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(userDTO obj);
    User update(userDTO obj);
    void delete(Integer id);

}
