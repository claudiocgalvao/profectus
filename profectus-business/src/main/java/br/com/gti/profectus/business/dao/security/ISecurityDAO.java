package br.com.gti.profectus.business.dao.security;

import org.springframework.data.jpa.repository.Query;

import br.com.gti.profectus.business.dao.ISpringDataDAO;
import br.com.gti.profectus.business.entity.security.User;

/**
 * ISecurityDAO.
 * @author eduardo.fsantos
 * @since 02/12/2014
 */

public interface ISecurityDAO extends ISpringDataDAO<User, Long> {

    /**
     * findByUserName.
     * @author eduardo.fsantos
     * @since 25/11/2014
     * @param code
     * @return List<Tax>
     */
    @Query("from User As A where UPPER(TRIM(A.username)) = UPPER(TRIM(?1))")
    User findByUserName(String username);

}
