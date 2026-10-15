package ir.maktabsharif.repository.user;

import ir.maktabsharif.dao.UserDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class UserRepositoryImpl extends BaseRepositoryImpl<UserDao,Integer> implements UserRepository {

    public UserRepositoryImpl() {
        super(UserDao.class);
    }
}
