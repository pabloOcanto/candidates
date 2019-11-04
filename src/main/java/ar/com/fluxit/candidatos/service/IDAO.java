package ar.com.fluxit.candidatos.service;

/**
 * Created by Pablo on 3/11/2019.
 */
public interface IDAO<T> {
    void  create(final T entity) throws Exception;
    void  update(final T entity) throws Exception;
    void  delete(final T entity) throws Exception;
}
