package br.usjt.desmob.atlas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author RA 81617543 Igor Almeida
 * DEVMOBI
 * CCP3AN-MCA
 */
public class DetalhePaisActivity extends FragmentActivity {

    /**
     * @author RA 81617543 Igor Almeida
     * apresentar detalhes do pais selecionado
     * @param savedInstanceState dados recebidos de outra activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);
        Intent intent = getIntent();
        Pais pais = (Pais)intent.getSerializableExtra(ListaPaisesActivity.PAIS);

        ImageView bandeira = findViewById(R.id.img_bandeira_pais);
        bandeira.setImageDrawable(Util.getDrawable(this, pais.getCodigo3().toLowerCase()));

        TextView nome = findViewById(R.id.txt_nome_pais);
        nome.setText(pais.getNome());

        TextView capital = findViewById(R.id.txt_capital);
        capital.setText(pais.getCapital());

        TextView regiao = findViewById(R.id.txt_regiao);
        regiao.setText(pais.getRegiao());

        TextView subregiao = findViewById(R.id.txt_subregiao);
        subregiao.setText(pais.getSubRegiao());

        TextView demonimo = findViewById(R.id.txt_demonimo);
        demonimo.setText(pais.getDemonimo());

        TextView area = findViewById(R.id.txt_area);
        area.setText(String.format("%1$,d km\u00B2", pais.getArea()));

        TextView populacao = findViewById(R.id.txt_populacao);
        populacao.setText(String.format("%1$,d", pais.getPopulacao()));

        TextView gini = findViewById(R.id.txt_gini);
        gini.setText(String.format("%.2f", pais.getGini()));

        TextView latitude = findViewById(R.id.txt_latitude);
        latitude.setText(String.format("%.2f", pais.getLatitude()));

        TextView longitude = findViewById(R.id.txt_longitude);
        longitude.setText(String.format("%.2f", pais.getLongitude()));

        if(savedInstanceState == null){
            FragmentManager fm = getSupportFragmentManager();
             DetalhePaisFragment hwf = new DetalhePaisFragment();

            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.detalhe_pais_fragment, hwf, "detalhePaisFragment");
            ft.commit();
        }
    }
}
