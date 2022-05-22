package crud.dao;


import crud.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<User> getAllUsers() {
        return manager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return manager.find(User.class, id);
    }

    @Override
    public void createUser(User user) {
        manager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        manager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        manager.remove(manager.find(User.class, id));
    }
}
