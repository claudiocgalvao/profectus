package br.com.gti.profectus.business.services;

import java.util.List;

/**
 * IService.
 * @param <T> Entity
 * @param <U> DTO
 */
public interface IService<T, U> {

    /**
     * save.
     * @param dto
     * @return
     * @throws Exception
     */
    Long save(U dto) throws Exception;

    /**
     * delete.
     * @param id
     * @throws Exception
     */
    void delete(U dto) throws Exception;

    /**
     * findObject.
     * @param id
     * @return
     * @throws Exception
     */
    U findObject(Long id) throws Exception;

    /**
     * findAll.
     * @return
     * @throws Exception
     */
    List<U> findAll() throws Exception;
}
