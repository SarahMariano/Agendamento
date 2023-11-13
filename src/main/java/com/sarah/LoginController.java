package com.sarah;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private String email = "sarah@email.com";
    private String senha = "123"; 
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label lblErro;
    @FXML
    private void initialize() {
        txtEmail.setText(email);
        txtSenha.setText(senha);
    }
    @FXML
    private void entrar() {
        lblErro.setVisible(false);
        lblErro.setText("");

        lblErro.setVisible(false);
        lblErro.setText("");

        // Realizar login 
        String email = txtEmail.getText();
        String senha = txtSenha.getText();

        if (!email.equals(this.email))
        {
            lblErro.setVisible(true);
            lblErro.setText("O email informado não é válido");
            return;
        }

        if (!senha.equals(this.senha))
        {
            lblErro.setVisible(true);
            lblErro.setText("A senha informada não é valida");
            return;
        }

        try {
            App.setRoot("principal");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
