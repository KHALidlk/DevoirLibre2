package com.application.controle2.model;
import lombok.*;

import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Membre {
    private String identifiant;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
private List<Incident> incidentList;

    public Membre(String identifiant, String nom, String prenom, String email, String phone) {
    }

    public boolean equals(Object obj)
   {
       if(this==obj)return true;
       if(obj == null) return false;
       Membre membre=(Membre) obj;
       return this.getIdentifiant().equals(membre.getIdentifiant());
   }
   public int hashcode()
   {
       return Objects.hash(identifiant);
   }
}
