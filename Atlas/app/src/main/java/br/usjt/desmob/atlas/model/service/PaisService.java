package br.usjt.desmob.atlas.model.service;

import java.io.IOException;

import br.usjt.desmob.atlas.model.dao.PaisDAO;
import br.usjt.desmob.atlas.model.dao.PaisDAOFactory;
import br.usjt.desmob.atlas.model.entity.Pais;
import br.usjt.desmob.atlas.model.entity.Regiao;


/**
 * Created by Igor Almeida | RA 81617543 | CCP3AN-MCA
 */

public class PaisService {
    PaisDAO dao;

    public PaisService(boolean onLine){
        dao = PaisDAOFactory.getPaisDAO(onLine);
    }
    public Pais[] buscarPaises(Regiao regiao) throws IOException{
        return dao.buscarPaises(regiao);
    }
}
