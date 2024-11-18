package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;


/**
 * The persistent class for the user_has_group database table.
 * 
 */
@Entity
@Table(name="user_has_group")
@NamedQuery(name="UserHasGroup.findAll", query="SELECT u FROM UserHasGroup u")
public class UserHasGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserHasGroupPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="added_at")
	private Date addedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="removed_at")
	private Date removedAt;

	//bi-directional many-to-one association to Group
	@ManyToOne
	private Group group;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_id_user")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="User_id_user")
	private User user2;

	public UserHasGroup() {
	}

	public UserHasGroupPK getId() {
		return this.id;
	}

	public void setId(UserHasGroupPK id) {
		this.id = id;
	}

	public Date getAddedAt() {
		return this.addedAt;
	}

	public void setAddedAt(Date addedAt) {
		this.addedAt = addedAt;
	}

	public Date getRemovedAt() {
		return this.removedAt;
	}

	public void setRemovedAt(Date removedAt) {
		this.removedAt = removedAt;
	}

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

}