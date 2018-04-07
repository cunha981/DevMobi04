package br.usjt.desmob.atlas;

import android.provider.BaseColumns;

/**
 * @author RA 81617543 Igor Almeida
 * DEVMOBI
 * CCP3AN-MCA
 */
public class PaisesContract {

    public static abstract class PaisEntry implements BaseColumns {
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_REGIAO = "regiao";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_BANDEIRA = "bandeira";
        public static final String COLUMN_NAME_CODIGO3 = "codigo3";
    }
}
