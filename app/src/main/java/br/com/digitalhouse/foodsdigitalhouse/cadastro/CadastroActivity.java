package br.com.digitalhouse.foodsdigitalhouse.cadastro;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.digitalhouse.foodsdigitalhouse.R;
import br.com.digitalhouse.foodsdigitalhouse.model.Place;

public class CadastroActivity extends AppCompatActivity {

    private EditText textInputLayoutName;
    private EditText loginTextInputLayoutEmail;
    private EditText loginTextInputLayoutPassword;
    private EditText loginTextInputLayoutRepeat;
    private Button btnRegister;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializaViews();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validadaCadastro()) {

                    Intent intent = new Intent(CadastroActivity.this, Place.class);

                    startActivity(intent);
                }
            }
        });

    }

    public void inicializaViews() {

        textInputLayoutName = findViewById(R.id.textInputLayoutName);
        loginTextInputLayoutEmail = findViewById(R.id.loginTextInputLayoutEmail);
        loginTextInputLayoutPassword = findViewById(R.id.loginTextInputLayoutPassword);
        loginTextInputLayoutRepeat = findViewById(R.id.loginTextInputLayoutRepeat);
        btnRegister = findViewById(R.id.btnRegister);

    }

    public boolean validadaCadastro() {

        String textNome = textInputLayoutName.getText().toString();
        String textEmail = loginTextInputLayoutEmail.getText().toString();
        String textPassword =  loginTextInputLayoutPassword.getText().toString();
        String textRepeat = loginTextInputLayoutRepeat.getText().toString();

        if (textNome.isEmpty()) {
            textInputLayoutName.setError("Name can't be blank!");
            return false;
        }

        if (textEmail.isEmpty()) {
            textInputLayoutName.setError("You need an email address to proceed!");
            return false;
        }

        if (textPassword.isEmpty()) {
            loginTextInputLayoutPassword.setError("Secure your login! Chodse a password!");
            return false;
        }

        if (textRepeat.isEmpty()) {
            loginTextInputLayoutRepeat.setError("Confirm your password!");
            return false;
        }

        return true;
    }

}