package br.com.gti.profectus.business.entity.security;

import java.io.Serializable;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

/**
 * User.
 * @author eduardo.fsantos
 * @since 03/12/2014
 */
@Data
@Document(collection = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Object _id;

    private String despartment;

    private String email;

    private Boolean enabled;

    private String name;

    private String password;

    private String username;
    
    

    //bi-directional many-to-one association to UserRole
    //@OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
    //private List<UserRole> userRoles;

    /**
     * addUserRol.
     * @param userRole
     * @return UserRole
     */
    public UserRole addUserRole(UserRole userRole) {
        //this.getUserRoles().add(userRole);
        userRole.setUser(this);

        return userRole;
    }

    /**
     * removeUserRole.
     * @param userRole
     * @return UserRole
     */
    public UserRole removeUserRole(UserRole userRole) {
        //this.getUserRoles().remove(userRole);
        userRole.setUser(null);
        return userRole;
    }

	public User(Object _id, String despartment, String email, Boolean enabled, String name, String password,
			String username) {
		super();
		this._id = _id;
		this.despartment = despartment;
		this.email = email;
		this.enabled = enabled;
		this.name = name;
		this.password = password;
		this.username = username;
	}

}
