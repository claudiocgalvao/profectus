package br.com.gti.profectus.infra.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * ISpringDataRepository.
 * @since 17/11/2014
 * @param <T>
 * @param <ID>
 */
@NoRepositoryBean
public interface ISpringDataRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
