package br.com.digitalhouse.foodsdigitalhouse.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import br.com.digitalhouse.foodsdigitalhouse.R;
import br.com.digitalhouse.foodsdigitalhouse.cadastro.CadastroActivity;
import br.com.digitalhouse.foodsdigitalhouse.model.Place;

public class LoginActivity extends AppCompatActivity {

    private EditText loginEmail;
    private EditText loginPassword;
    private Button loginButtonLogin;
    private CheckBox checkBoxLembrar;
    private Button loginButtonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

        validateLogin();

        callRegisterActivity();
    }

    private void initViews() {
        loginEmail = findViewById(R.id.email);
        loginPassword = findViewById(R.id.password);
        loginButtonLogin = findViewById(R.id.btnEntrar);
        checkBoxLembrar = findViewById(R.id.checkboxLembrar);
        loginButtonRegister = findViewById(R.id.btnRegister);
    }

    private void validateLogin() {
        loginButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailLog = loginEmail.getText().toString();
                String senhaLog = loginPassword.getText().toString();

                loginEmail.setError("");
                loginPassword.setError("");

                if (emailLog.isEmpty()) {
                    loginEmail.setError("Email can't be blank.");
                    return;
                }

                if (senhaLog.isEmpty()) {
                    loginPassword.setError("You need a password to login.");
                    return;
                }

                if (!(emailLog.isEmpty()) && !(senhaLog.isEmpty())){
                    Intent intent = new Intent(LoginActivity.this, Place.class);
                    startActivity(intent);
                    return;
                }
            }
        });
    }

    private void callRegisterActivity() {
        loginButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(intent);
            }
        });
    }
}

