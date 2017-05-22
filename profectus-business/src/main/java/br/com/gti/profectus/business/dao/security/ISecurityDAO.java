package br.com.gti.profectus.business.dao.security;

import org.springframework.security.core.userdetails.User;

/**
 * ISecurityDAO.
 */

public interface ISecurityDAO{

    /**
     * findByUserName.
     * @param code
     * @return List<Tax>
     */
    //@Query("from User As A where UPPER(TRIM(A.username)) = UPPER(TRIM(?1))")
    User findByUserName(String username);

}
