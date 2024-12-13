package com.application.controle2.Controller;

import com.application.controle2.DAO.MembreDaoImpl;
import com.application.controle2.model.Membre;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.lang.reflect.Member;

public class MemberController {
    @FXML
    private TextField nomField, prenomField, emailField, phoneField;

    @FXML
    private Button insertBtn;

    private final MembreDaoImpl memberDao = new MembreDaoImpl();

    @FXML
    public void initialize() {
        // Check if the fields are properly loaded
        if (nomField == null || prenomField == null || emailField == null || phoneField == null || insertBtn == null) {
            System.out.println("One or more FXML components are null! Check your fx:id bindings in the FXML file.");
        } else {
            System.out.println("All FXML components loaded successfully!");
        }
    }

    @FXML
    public void HandleInsertMember() {
        if (nomField.getText().isEmpty() || prenomField.getText().isEmpty() || emailField.getText().isEmpty() || phoneField.getText().isEmpty()) {
            System.out.println("All fields must be filled in!");
        } else {
            // Create a new Member object and populate it with data from the fields
            Membre member = new Membre();
            member.setNom(nomField.getText());
            member.setPrenom(prenomField.getText());
            member.setEmail(emailField.getText());
            member.setPhone(phoneField.getText());

            // Use the DAO to insert the member into the JSON file
            memberDao.insere(member);

            // Clear the fields after insertion
            nomField.clear();
            prenomField.clear();
            emailField.clear();
            phoneField.clear();


        }
    }
}
