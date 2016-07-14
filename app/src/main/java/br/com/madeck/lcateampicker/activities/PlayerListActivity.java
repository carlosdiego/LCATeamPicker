package br.com.madeck.lcateampicker.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.madeck.lcateampicker.adapters.PlayerListAdapter;
import br.com.madeck.lcateampicker.model.Player;
import br.com.madeck.lcateampicker.R;

public class PlayerListActivity extends AppCompatActivity {

    ListView listViewPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        setTitle("Lista de amigos");

        if(getIntent() != null){
            //Busca lista no BD
            List<Player> playerList = Player.listAll(Player.class, "name");
            carregarListViewPlayers(playerList);
        }
    }

    private void carregarListViewPlayers(List<Player> playerList) {
        //Seta adapter para o ListView
        PlayerListAdapter adapter = new PlayerListAdapter(this, playerList);
        listViewPlayer = (ListView)findViewById(R.id.listViewPlayer);
        listViewPlayer.setAdapter(adapter);

        listViewPlayer.setOnLongClickListener(showOptions());
    }

    private View.OnLongClickListener showOptions() {
        final ArrayList<String> options = new ArrayList();
        options.add("Editar");
        options.add("Excluir");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, options);
        final AlertDialog.Builder alertOptions = new AlertDialog.Builder(this);
        alertOptions.setTitle("O que deseja?");
        alertOptions.setSingleChoiceItems(arrayAdapter, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(i == 0){
                    //Editar
                    startActivity(new Intent(getApplicationContext(), EditActivity.class));
                }else{
                    //VERIFICAR GETSELECTEDITEMID
                    //Adicionar confirmação
                    Player selectedPlayer = Player.findById(Player.class, listViewPlayer.getSelectedItemId());
                    selectedPlayer.delete();
                    Toast.makeText(getApplicationContext(), "Jogador deletado!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return null;
    }
}
