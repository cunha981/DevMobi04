package br.usjt.deswebmob.servicedesk;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by arqdsis on 21/03/2018.
 */

public class ChamadoAdapter <T> extends BaseAdapter{

    private List<T> chamados;
    private Context context;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
    public ChamadoAdapter(Context context, List <T> chamados){
        this.context = context;
        this.chamados = chamados;
    }

    @Override
    public int getCount() {
        return chamados.size();
    }

    @Override
    public T getItem(int i) {
        return chamados.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageView iconeImageView = null;
        TextView descricaoTextView = null;
        TextView dataAberturaTextView = null;
        TextView dataFechamentoTextView = null;
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.linha_chamado, viewGroup, false);

            iconeImageView = convertView.findViewById(R.id.iconeImageView);
            descricaoTextView = convertView.findViewById(R.id.descricaoTextView);
            dataAberturaTextView = convertView.findViewById(R.id.dataAberturaTextView);
            dataFechamentoTextView = convertView.findViewById(R.id.dataFechamentoTextView);

            vh = new ViewHolder(iconeImageView, descricaoTextView,
                    dataAberturaTextView, dataFechamentoTextView);

            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
            iconeImageView = vh.iconeImageView;
            descricaoTextView = vh.descricaoTextView;
            dataAberturaTextView = vh.dataAberturaTextView;
            dataFechamentoTextView = vh.dataFechamentoTextView;
        }
        Chamado chamado = (Chamado) getItem(i);
        iconeImageView.setImageDrawable(Util.getDrawable((Activity) context,
                chamado.getFila().getIcone()));
        descricaoTextView.setText(chamado.getDescricao());
        dataAberturaTextView.setText(sdf.format(chamado.getDataAbertura()));
        dataFechamentoTextView.setText(chamado.getDataFechamento() != null ?
                sdf.format(chamado.getDataFechamento()) : "N/A");

        return convertView;
    }
    private class ViewHolder{
        ImageView iconeImageView;
        TextView descricaoTextView, dataAberturaTextView, dataFechamentoTextView;

        public ViewHolder(ImageView iconeImageView, TextView... textViews){
            this.iconeImageView = iconeImageView;
            this.descricaoTextView = textViews[0];
            this.dataAberturaTextView = textViews[1];
            this.dataFechamentoTextView = textViews[2];
        }
    }
}
