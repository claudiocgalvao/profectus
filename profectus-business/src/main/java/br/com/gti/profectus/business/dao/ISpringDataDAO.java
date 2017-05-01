package br.com.gti.profectus.business.dao;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;

import br.com.gti.profectus.infra.repository.ISpringDataRepository;

/**
 * ISpringDataDAO.
 * @author claudio.cesar
 * @since 13/11/2014
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ISpringDataDAO<T, ID extends Serializable> extends ISpringDataRepository<T, ID> {
}
