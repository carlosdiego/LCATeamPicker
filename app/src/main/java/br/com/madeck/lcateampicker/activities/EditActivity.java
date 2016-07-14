package br.com.madeck.lcateampicker.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.madeck.lcateampicker.model.Player;
import br.com.madeck.lcateampicker.R;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Editar jogador");

        if(getIntent() != null) {
            Button salvar = (Button) findViewById(R.id.buttonSave);
            Button cancelar = (Button) findViewById(R.id.buttonCancelar);

            salvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //FALTA EDITAR JOGADOR
                    Player player = new Player();
//                    player.setName(((EditText) findViewById(R.id.editTextNome)).getText().toString());
//                    player.setPrimaryRole(((EditText) findViewById(R.id.editTextPrimaryRole)).getText().toString());
//                    player.setSecundaryRole(((EditText) findViewById(R.id.editTextSecundaryRole)).getText().toString());
//                    String value = ((EditText) findViewById(R.id.editTextGrade)).getText().toString();
//                    player.setGrade(Integer.parseInt(value));

                    Player.save(player);
                    Toast.makeText(getApplicationContext(), "Jogador editado!", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });

            cancelar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Operação cancelada", Toast.LENGTH_SHORT).show();
                    finish();
                }
            });
        }
    }
}
