package ir.maktabsharif.repository.auth;

import ir.maktabsharif.dao.BaseModel;
import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepository;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public class AuthRepository {
    public UserDao getUser(String username) {
        return HibernateUtil.read(entityManager -> entityManager.createQuery("SELECT u FROM UserDao u WHERE u.username = ?1", UserDao.class).setParameter(1, username).getSingleResult());
    }
}
