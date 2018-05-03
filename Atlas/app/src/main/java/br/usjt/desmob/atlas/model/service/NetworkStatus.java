package br.usjt.desmob.atlas.model.service;

import android.content.Context;
import android.net.ConnectivityManager;

import br.usjt.desmob.atlas.Contexto;

/**
 * Created by Igor Almeida | RA 81617543 | CCP3AN-MCA
 */

public class NetworkStatus {

    public static boolean isConnected(){
        Context context = Contexto.getValue();
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
