package br.com.digitalhouse.foodsdigitalhouse.cadastro;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.digitalhouse.foodsdigitalhouse.R;
import br.com.digitalhouse.foodsdigitalhouse.model.Place;
import br.com.digitalhouse.foodsdigitalhouse.place.view.PlaceActivity;

public class CadastroActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutName;
    private TextInputLayout loginTextInputLayoutEmail;
    private TextInputLayout loginTextInputLayoutPassword;
    private TextInputEditText loginTextInputLayoutRepeat;
    private Button btnRegisterSave;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializaViews();

        btnRegisterSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaCadastro()) {

                    Intent intent = new Intent(CadastroActivity.this, PlaceActivity.class);

                    startActivity(intent);
                }
            }
        });

    }

    public void inicializaViews() {

        textInputLayoutName = findViewById(R.id.textInputLayoutNameCadastro);
        loginTextInputLayoutEmail = findViewById(R.id.loginTextInputLayoutEmailCadastro);
        loginTextInputLayoutPassword = findViewById(R.id.loginTextInputLayoutPasswordCadastro);
        loginTextInputLayoutRepeat = findViewById(R.id.loginTextInputLayoutRepeat);
        btnRegisterSave = findViewById(R.id.btnRegisterSave);

    }

    public boolean validaCadastro() {

        String textNome = textInputLayoutName.getEditText().getText().toString();
        String textEmail = loginTextInputLayoutEmail.getEditText().getText().toString();
        String textPassword =  loginTextInputLayoutPassword.getEditText().getText().toString();
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