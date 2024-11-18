package jsfcourse.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_group")
	private int idGroup;

	private String name;

	@Column(name="student_quantity")
	private int studentQuantity;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="id_teacher")
	private User user;

	//bi-directional many-to-one association to UserHasGroup
	@OneToMany(mappedBy="group")
	private List<UserHasGroup> userHasGroups;

	public Group() {
	}

	public int getIdGroup() {
		return this.idGroup;
	}

	public void setIdGroup(int idGroup) {
		this.idGroup = idGroup;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentQuantity() {
		return this.studentQuantity;
	}

	public void setStudentQuantity(int studentQuantity) {
		this.studentQuantity = studentQuantity;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<UserHasGroup> getUserHasGroups() {
		return this.userHasGroups;
	}

	public void setUserHasGroups(List<UserHasGroup> userHasGroups) {
		this.userHasGroups = userHasGroups;
	}

	public UserHasGroup addUserHasGroup(UserHasGroup userHasGroup) {
		getUserHasGroups().add(userHasGroup);
		userHasGroup.setGroup(this);

		return userHasGroup;
	}

	public UserHasGroup removeUserHasGroup(UserHasGroup userHasGroup) {
		getUserHasGroups().remove(userHasGroup);
		userHasGroup.setGroup(null);

		return userHasGroup;
	}

}