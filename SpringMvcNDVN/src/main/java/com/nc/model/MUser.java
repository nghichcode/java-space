package com.nc.model;
// Generated Jun 4, 2019 11:25:13 AM by Hibernate Tools 5.2.10.Final

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * MUser generated by hbm2java
 */
@Entity
@Table(name = "m_user", schema = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "user_name"),
		@UniqueConstraint(columnNames = "nid") })
public class MUser implements java.io.Serializable {

	private long userId;
	private Long version;
	private long createdBy;
	private Date createdDate;
	private long updatedBy;
	private Date updatedDate;
	private Serializable nid;
	private String fullName;
	private String language;
	private Date lastLogin;
	private Long loginCount;
	private String status;
	private long type;
	private String userName;
	private String userPassword;
	private Date expiredDate;
	private String phoneNumber;
	private String email;
	private String tenantCode;
	private Set<MUserRoles> MUserRoleses = new HashSet<MUserRoles>(0);

	public MUser() {
	}

	public MUser(long userId, long createdBy, Date createdDate, long updatedBy, Date updatedDate, Serializable nid,
			String status, long type, String userName) {
		this.userId = userId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.nid = nid;
		this.status = status;
		this.type = type;
		this.userName = userName;
	}

	public MUser(long userId, long createdBy, Date createdDate, long updatedBy, Date updatedDate, Serializable nid,
			String fullName, String language, Date lastLogin, Long loginCount, String status, long type,
			String userName, String userPassword, Date expiredDate, String phoneNumber, String email, String tenantCode,
			Set<MUserRoles> MUserRoleses) {
		this.userId = userId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.nid = nid;
		this.fullName = fullName;
		this.language = language;
		this.lastLogin = lastLogin;
		this.loginCount = loginCount;
		this.status = status;
		this.type = type;
		this.userName = userName;
		this.userPassword = userPassword;
		this.expiredDate = expiredDate;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.tenantCode = tenantCode;
		this.MUserRoleses = MUserRoleses;
	}

	@Id

	@Column(name = "user_id", unique = true, nullable = false)
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Version
	@Column(name = "version")
	public Long getVersion() {
		return this.version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Column(name = "created_by", nullable = false)
	public long getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 29)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "updated_by", nullable = false)
	public long getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_date", nullable = false, length = 29)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "nid", unique = true, nullable = false)
	public Serializable getNid() {
		return this.nid;
	}

	public void setNid(Serializable nid) {
		this.nid = nid;
	}

	@Column(name = "full_name", length = 100)
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "language", length = 30)
	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_login", length = 29)
	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	@Column(name = "login_count")
	public Long getLoginCount() {
		return this.loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	@Column(name = "status", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "type", nullable = false)
	public long getType() {
		return this.type;
	}

	public void setType(long type) {
		this.type = type;
	}

	@Column(name = "user_name", unique = true, nullable = false, length = 30)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "user_password", length = 200)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expired_date", length = 29)
	public Date getExpiredDate() {
		return this.expiredDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	@Column(name = "phone_number", length = 100)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tenant_code", length = 50)
	public String getTenantCode() {
		return this.tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "MUser")
	public Set<MUserRoles> getMUserRoleses() {
		return this.MUserRoleses;
	}

	public void setMUserRoleses(Set<MUserRoles> MUserRoleses) {
		this.MUserRoleses = MUserRoleses;
	}

}
