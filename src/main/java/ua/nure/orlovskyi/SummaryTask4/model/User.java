package ua.nure.orlovskyi.SummaryTask4.model;


public abstract class User {
		private Integer id;
		private String login;
		private String password;
		private Role role;
		private String name;
		private String email;
		private Gender gender;
		private String mobile;
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Gender getGender() {
			return gender;
		}
		public void setGender(Gender gender) {
			this.gender = gender;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		@Override
		public String toString() {
			return "User [id=" + id + ", login=" + login + ", password=" + password + ", role=" + role + ", name=" + name
					+ ", email=" + email + ", gender=" + gender + ", mobile=" + mobile + "]";
		}
		
		
}
