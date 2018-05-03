package br.usjt.desmob.atlas.model.dao;


import br.usjt.desmob.atlas.Contexto;

/**
 * Created by Igor Almeida | RA 81617543 | CCP3AN-MCA
 */

public class PaisDAOFactory {

    public static PaisDAO getPaisDAO(boolean onLine){
        if (onLine) {
            return new PaisDAORest();
        } else {
            return new PaisDAODb(Contexto.getValue());
        }
    }
}
