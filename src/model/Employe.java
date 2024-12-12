package model;

import model.Employe.Poste;
import model.Employe.Role;

public class Employe {
	//attribut

		private int id;
		private String nom;
		private String prenom;
		private String email;
		private String telephone;
		private double salaire;
		private Role role;
		private Poste poste;
		
		public enum Role{
			Admin,
			Employee;
		}
		public enum Poste{
			Ingenieur,
			Team_Leader,
			Pilote;
		}
		
		public Employe(int id,String nom,String prenom,String email,String telephone,double salaire,Role role,Poste poste) {
			this.id=id;
			this.nom=nom;
			this.prenom=prenom;
			this.email=email;
			this.telephone=telephone;
			this.salaire=salaire;
			this.role=role;
			this.poste=poste;
		}
		
		public int getId() {
			return this.id;
		}
		public String getNom() {
			return nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public String getEmail() {
			return email;
		}
		public String getPhone() {
			return telephone;
		}
		public double getSalaire() {
			return salaire;
		}
		public Role getRole() {
			return role;
		}
		public Poste getPoste() {
			return poste;
		}

	}

