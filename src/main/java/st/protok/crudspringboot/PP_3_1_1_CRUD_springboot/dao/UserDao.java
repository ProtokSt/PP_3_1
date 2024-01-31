package st.protok.crudspringboot.PP_3_1_1_CRUD_springboot.dao;


import st.protok.crudspringboot.PP_3_1_1_CRUD_springboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);
}
