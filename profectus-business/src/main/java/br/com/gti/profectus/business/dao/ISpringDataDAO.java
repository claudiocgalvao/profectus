package br.com.gti.profectus.business.dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import br.com.gti.profectus.infra.repository.ISpringDataMongoRepository;

/**
 * ISpringDataDAO.
 * @author Claudio
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ISpringDataDAO<T, ID extends Serializable> extends ISpringDataMongoRepository<T, ID> {
}
