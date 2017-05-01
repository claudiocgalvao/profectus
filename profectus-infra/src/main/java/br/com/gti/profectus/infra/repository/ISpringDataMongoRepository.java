package br.com.gti.profectus.infra.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ISpringDataMongoRepository<T, ID extends Serializable> extends MongoRepository<T, ID> {
}
