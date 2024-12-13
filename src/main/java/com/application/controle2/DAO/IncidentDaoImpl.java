package com.application.controle2.DAO;

import com.application.controle2.model.Connecter;
import com.application.controle2.model.Incident;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

public class IncidentDaoImpl implements  IncidentDao{
    Connecter conn=new Connecter();
    public void insere(Incident i){
    String SQL="INSERT INTO incident (reference, time, status, identifiant) VALUES (?, ?, ?, ?)";
        try(Connection connection=conn.connx();
            PreparedStatement stm=connection.prepareStatement(SQL))
        {
            stm.setString(1,i.getReference());
            stm.setString(2, String.valueOf(i.getTime()));
            stm.setString(3,i.getStatus());
            stm.setString(4, i.getMembre().getIdentifiant());

            stm.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void insere(Set <Incident> is)
    {
        for(Incident incident: is)
        {
            String SQL="INSERT INTO incident (reference, time, status, identifiant) VALUES (?, ?, ?, ?)";
            try(Connection connection=conn.connx();
                PreparedStatement stm=connection.prepareStatement(SQL))
            {
                stm.setString(1,incident.getReference());
                stm.setString(2, String.valueOf(incident.getTime()));
                stm.setString(3,incident.getStatus());
                stm.setString(4, incident.getMembre().getIdentifiant());
                stm.executeUpdate();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

}
