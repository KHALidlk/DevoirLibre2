package com.application.controle2.DAO;

import com.application.controle2.model.Connecter;
import com.application.controle2.model.Incident;
import com.application.controle2.model.Membre;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class MembreDaoImpl implements MembreDao{
Connecter conn=new Connecter();
    public void insere (Membre m)
    {
        String SQL="INSERT INTO membre (identifiant,nom,prenom,email,phone) values(?,?,?,?,?)";
        try(Connection connection=conn.connx();
        PreparedStatement stm=connection.prepareStatement(SQL))
        {
            stm.setString(1,m.getIdentifiant());
            stm.setString(2,m.getNom());
            stm.setString(3,m.getPrenom());
            stm.setString(4,m.getEmail());
            stm.setString(5,m.getPhone());
            stm.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    String id;
    List<Incident> incidentList;
    public List<Incident> chargerListIncidents()
    {
        String SQL="Select id from incident where id_membr=?";
        try(Connection connection=conn.connx();
            PreparedStatement stm=connection.prepareStatement(SQL);
            ResultSet resultSet=stm.getResultSet())
        {
            stm.setString(1,id);
            stm.executeQuery();
            while(resultSet.next())
            {
                incidentList.add((Incident) resultSet);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return incidentList;
    }
    public Set<Membre> chargerListeMembre(String nomFichier) {
        Set<Membre> membresSet = new HashSet<>(); // Utilisation d'un Set pour garantir l'unicité
        try (BufferedReader br = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            // Ignorer la première ligne (en-têtes du CSV)
            br.readLine();
            // Utiliser un flux pour lire et traiter chaque ligne du fichier
            Stream<String> lignes = br.lines();

           lignes.forEach(l -> {
                String[] données = l.split(",");

                // Vérifier si la ligne contient les 5 éléments attendus
                if (données.length == 5) {
                    String identifiant = données[0];
                    String nom = données[1];
                    String prenom = données[2];
                    String email = données[3];
                    String phone = données[4];

                    // Créer l'objet Membre
                    Membre membre = new Membre(identifiant, nom, prenom, email, phone);

                    // Filtrer les doublons en ajoutant seulement si le membre n'existe pas déjà
                    if (!membresSet.contains(membre)) {
                        membresSet.add(membre);
                    }
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return membresSet;
    }
}
