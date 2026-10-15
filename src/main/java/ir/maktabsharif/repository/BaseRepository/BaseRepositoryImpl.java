package ir.maktabsharif.repository.BaseRepository;

import ir.maktabsharif.exception.HibernateException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.model.BaseModel;
import ir.maktabsharif.util.HibernateUtil;

import java.util.List;

public abstract class BaseRepositoryImpl<T extends BaseModel<ID>, ID extends Number> implements BaseRepository<T, ID> {

    private Class<T> entity;

    public BaseRepositoryImpl(Class<T> entity) {
        this.entity = entity;
    }

    @Override
    public T create(T t) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.persist(t);
                return t;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("create operation is failed => " + e.getMessage());
        }
    }

    @Override
    public T update(T t) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.merge(t);
                return t;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("updater operation is failed => " + e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return HibernateUtil.InTxReturn(em -> {
                em.remove(em.find(entity, id));
                return id;
            });
        } catch (HibernateException e) {
            throw new RepositoryException("delete operation is failed => " + e.getMessage());
        }
    }

    @Override
    public T read(ID id) {
        try {
            return HibernateUtil.read(em -> {
                return em.find(entity, id);
            });
        } catch (HibernateException e) {
            throw new RepositoryException("read operation is failed => " + e.getMessage());
        }
    }

    @Override
    public List<T> findAll() {
        try {
            return HibernateUtil.read(em -> {
                return em.createQuery("FROM " + entity.getSimpleName()).getResultList();
            });
        } catch (HibernateException e) {
            throw new RepositoryException("find all operation is failed => " + e.getMessage());
        }
    }
}
