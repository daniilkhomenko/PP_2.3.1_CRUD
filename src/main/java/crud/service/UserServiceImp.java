package crud.service;

import crud.dao.UserDao;
import crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class UserServiceImp implements UserService {

   private UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   public List<User> getAllUsers() {
      return userDao.getAllUsers();
   }

   @Override
   public User getUser(long id) {
      return userDao.getUser(id);
   }

   @Override
   public void createUser(User user) {
      userDao.createUser(user);
   }

   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }


   @Override
   public void deleteUser(long id) {
      userDao.deleteUser(id);
   }
}
