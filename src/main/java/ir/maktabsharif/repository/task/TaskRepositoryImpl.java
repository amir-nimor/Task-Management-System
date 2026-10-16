package ir.maktabsharif.repository.task;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class TaskRepositoryImpl extends BaseRepositoryImpl<BookDao,Integer> implements TaskRepository {

    public TaskRepositoryImpl() {
        super(BookDao.class);
    }
}
