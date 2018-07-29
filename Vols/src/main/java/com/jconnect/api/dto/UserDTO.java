package com.jconnect.api.dto;

public class UserDTO {

		private Long id;
		private String firstName;
		private String lastName;
		private String email;
		private String password;
		private Long tel;
		private String fonction;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Long getTel() {
			return tel;
		}
		public void setTel(Long tel) {
			this.tel = tel;
		}
		public String getFonction() {
			return fonction;
		}
		public void setFonction(String fonction) {
			this.fonction = fonction;
		}
		
		
}
