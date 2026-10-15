package ir.maktabsharif.repository.task;

import ir.maktabsharif.dao.TaskDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class TaskRepositoryImpl extends BaseRepositoryImpl<TaskDao,Integer> implements TaskRepository {

    public TaskRepositoryImpl() {
        super(TaskDao.class);
    }
}
