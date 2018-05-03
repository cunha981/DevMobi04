package br.usjt.desmob.atlas.model.dao;

import java.io.IOException;

import br.usjt.desmob.atlas.model.entity.Pais;
import br.usjt.desmob.atlas.model.entity.Regiao;

/**
 * Created by Igor Almeida | RA 81617543 | CCP3AN-MCA
 */

public interface PaisDAO {
    Pais[] buscarPaises(Regiao regiao) throws IOException;
}
