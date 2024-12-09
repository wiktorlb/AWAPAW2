package com.jsf.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name = "user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	private byte active;

	@Temporal(TemporalType.DATE)
	@Column(name="created_at")
	private Date createdAt;

	private String email;

	@Column(name="lastName")
	private String lastName;

	@Column(name="name")
	private String name;

	private String password;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_at")
	private Date updatedAt;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_by")
	private Date updatedBy;

	/*
	 * //bi-directional many-to-one association to Group
	 * 
	 * @OneToMany(mappedBy="user") private List<Group> groups;
	 */

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="user")
	private List<User> users;

	/*
	 * //bi-directional many-to-one association to UserHasGroup
	 * 
	 * @OneToMany(mappedBy="user1") private List<UserHasGroup> userHasGroups1;
	 */

	/*
	 * //bi-directional many-to-one association to UserHasGroup
	 * 
	 * @OneToMany(mappedBy="user2") private List<UserHasGroup> userHasGroups2;
	 */

	/*
	 * //bi-directional many-to-many association to Role
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable( name="user_has_role" , joinColumns={
	 * 
	 * @JoinColumn(name="User_id_user") } , inverseJoinColumns={
	 * 
	 * @JoinColumn(name="Role_id_role") } )
	 */
	/* private List<Role> roles; */

	public User() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public byte getActive() {
		return this.active;
	}

	public void setActive(byte active) {
		this.active = active;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Date updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	 * public List<Group> getGroups() { return this.groups; }
	 * 
	 * public void setGroups(List<Group> groups) { this.groups = groups; }
	 * 
	 * public Group addGroup(Group group) { getGroups().add(group);
	 * group.setUser(this);
	 * 
	 * return group; }
	 * 
	 * public Group removeGroup(Group group) { getGroups().remove(group);
	 * group.setUser(null);
	 * 
	 * return group; }
	 */

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setUser(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setUser(null);

		return user;
	}

	/*
	 * public List<UserHasGroup> getUserHasGroups1() { return this.userHasGroups1; }
	 * 
	 * public void setUserHasGroups1(List<UserHasGroup> userHasGroups1) {
	 * this.userHasGroups1 = userHasGroups1; }
	 * 
	 * public UserHasGroup addUserHasGroups1(UserHasGroup userHasGroups1) {
	 * getUserHasGroups1().add(userHasGroups1); userHasGroups1.setUser1(this);
	 * 
	 * return userHasGroups1; }
	 */

	/*
	 * public UserHasGroup removeUserHasGroups1(UserHasGroup userHasGroups1) {
	 * getUserHasGroups1().remove(userHasGroups1); userHasGroups1.setUser1(null);
	 * 
	 * return userHasGroups1; }
	 * 
	 * public List<UserHasGroup> getUserHasGroups2() { return this.userHasGroups2; }
	 * 
	 * public void setUserHasGroups2(List<UserHasGroup> userHasGroups2) {
	 * this.userHasGroups2 = userHasGroups2; }
	 * 
	 * public UserHasGroup addUserHasGroups2(UserHasGroup userHasGroups2) {
	 * getUserHasGroups2().add(userHasGroups2); userHasGroups2.setUser2(this);
	 * 
	 * return userHasGroups2; }
	 * 
	 * public UserHasGroup removeUserHasGroups2(UserHasGroup userHasGroups2) {
	 * getUserHasGroups2().remove(userHasGroups2); userHasGroups2.setUser2(null);
	 * 
	 * return userHasGroups2; }
	 * 
	 * public List<Role> getRoles() { return this.roles; }
	 * 
	 * public void setRoles(List<Role> roles) { this.roles = roles; }
	 */

}