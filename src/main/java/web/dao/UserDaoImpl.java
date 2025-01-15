package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }

    @Override
    public void createUser(User user) {
        em.persist(user);
    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(User user, int id) {
        user.setId(id);
        em.merge(user);
    }

    @Override
    public void deleteUserById(int id) {
        em.remove(em.find(User.class, id));
    }
}
