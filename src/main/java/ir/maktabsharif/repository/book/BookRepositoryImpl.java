package ir.maktabsharif.repository.book;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.repository.BaseRepository.BaseRepositoryImpl;

public class BookRepositoryImpl extends BaseRepositoryImpl<BookDao,Integer> implements BookRepository {

    public BookRepositoryImpl() {
        super(BookDao.class);
    }
}
