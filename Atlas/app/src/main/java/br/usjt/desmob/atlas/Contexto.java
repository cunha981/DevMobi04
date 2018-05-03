package br.usjt.desmob.atlas;

import android.content.Context;

/**
 * Created by Igor Almeida | RA 81617543 | CCP3AN-MCA
 */

public class Contexto {
    private static Context contexto;

    public static Context getValue(){
        return contexto;
    }

    public static void setValue(Context c){
        contexto = c;
    }
}
