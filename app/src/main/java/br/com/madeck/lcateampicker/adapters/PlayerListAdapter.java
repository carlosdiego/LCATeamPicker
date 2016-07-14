package br.com.madeck.lcateampicker.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.madeck.lcateampicker.model.Player;
import br.com.madeck.lcateampicker.R;

/**
 * Created by Anderson on 07/07/2016.
 */
public class PlayerListAdapter extends BaseAdapter{
    private LayoutInflater playerListInflater;
    private List<Player> playerList;

    public PlayerListAdapter(Context context, List<Player> _playerList){
        playerListInflater = LayoutInflater.from(context);
        playerList = _playerList;
    }

    @Override
    public int getCount() {
        return playerList.size();
    }

    @Override
    public Player getItem(int position) {
        return playerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return playerList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewElementos elementos;

        //Verifica se existe view
        if(view == null){
            view = playerListInflater.inflate(R.layout.playerlist_layout, viewGroup, false);

            elementos = new ViewElementos();
            elementos.name = (TextView) view.findViewById(R.id.textViewNome);
            elementos.grade = (TextView) view.findViewById(R.id.textViewGrade);
            elementos.primaryRole = (TextView) view.findViewById(R.id.textViewPrimaryRole);
            elementos.secundaryRole = (TextView) view.findViewById(R.id.textViewSecundaryRole);

            view.setTag(elementos);
        }else{
            //Obtém view existente
            elementos = (ViewElementos) view.getTag();
        }

        Player player = getItem(position);

        elementos.name.setText(player.getName());
        elementos.grade.setText(Integer.toString(player.getGrade()));
        elementos.primaryRole.setText(player.getPrimaryRole());
        elementos.secundaryRole.setText(player.getSecundaryRole());

        return view;
    }

    private class ViewElementos{
        public TextView name;
        public TextView grade;
        public TextView primaryRole;
        public TextView secundaryRole;
    }
}
