package br.com.gti.profectus.business.entity.security;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * The persistent class for the USER_ROLES database table.
 */
@Data
@Document(collection = "user_roles")
public class UserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private long userRoleId;

    private String authority;

    private String role;

    private String username;

//    //bi-directional many-to-one association to User
//    @ManyToOne(cascade = { CascadeType.ALL })
//    @JoinColumn(name = "USER_ID")
    private User user;
  
}
