package badminton_project.module.users.repository;

import badminton_project.module.users.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
    int countAdminUsers();
    void insertUser(User user);
} 