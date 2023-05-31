package services.Users;

import models.Users;
import repositories.Users.UserRepository;
import repositories.Users.UserRepositoryImpl;
import services.Base.BaseServiceImpl;

import java.util.List;

public class UserServiceImpl extends BaseServiceImpl implements UsersService
{
    private final UserRepository userRepository=new UserRepositoryImpl();
    @Override
    public List<Users> GetAllData() {
      return userRepository.FindAllData();
    }

    @Override
    public void Insert(Users users) {
        if (users.getEmail() == null || users.getEmail().equals("")) {
            System.out.println("User Email is required");
        } else {

            userRepository.insert(users);
        }
    }

    @Override
    public Users getById(Integer id) {
       return userRepository.findById(id);
    }

    @Override
    public void update(Users users, Integer id) {userRepository.update(users,id);}

    @Override
    public void delete(Integer id) {userRepository.delete(id);}
}
