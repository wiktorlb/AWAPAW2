package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the user_has_group database table.
 * 
 */
@Embeddable
public class UserHasGroupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int user_id_user;

	@Column(insertable=false, updatable=false)
	private int group_id_group;

	public UserHasGroupPK() {
	}
	public int getUser_id_user() {
		return this.user_id_user;
	}
	public void setUser_id_user(int user_id_user) {
		this.user_id_user = user_id_user;
	}
	public int getGroup_id_group() {
		return this.group_id_group;
	}
	public void setGroup_id_group(int group_id_group) {
		this.group_id_group = group_id_group;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserHasGroupPK)) {
			return false;
		}
		UserHasGroupPK castOther = (UserHasGroupPK)other;
		return 
			(this.user_id_user == castOther.user_id_user)
			&& (this.group_id_group == castOther.group_id_group);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.user_id_user;
		hash = hash * prime + this.group_id_group;
		
		return hash;
	}
}