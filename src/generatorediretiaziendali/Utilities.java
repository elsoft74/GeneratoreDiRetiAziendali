/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

/**
 *
 * @author elsoft
 */
public class Utilities {
    
    static String nomiPersone[]={"Antonio",
        "Antonia",
        "Alessandro",
        "Alessandra"
    };
    static String cognomiPersone[]={"Bianchi",
        "Rossi",
        "Verdi"
    };
    static String nomiAziendali[]={"Costruzioni",
        "Elettronica",
        "Trasporti",
        ""
    };
    static String tipologieAziendali[]={"srl",
        "sas",
        "spa",
        ""
    };
    public static String nomeCasuale(String par) {
        String out="";
        switch (par){
            case "p":
                int i=(int) Math.round(Math.random()*(cognomiPersone.length-1));
                out+=cognomiPersone[i]+" ";
                i=(int) Math.round(Math.random()*(nomiPersone.length-1));
                out+=nomiPersone[i];
                break;
            case "a":
                if (Math.random()>0.05) { // c'è il 5% di probabilità che ci sia un cognome nel nome ditta come prima parte
                    i=(int) Math.round(Math.random()*(cognomiPersone.length-1));
                    out+=cognomiPersone[i]+" ";
                    } else {
                        i=(int) Math.round(Math.random()*(nomiAziendali.length-1));
                        out+=nomiAziendali[i]+" ";
                    }
                if (Math.random()>0.03) { // c'è il 3% di probabilità che ci sia un cognome nel nome ditta come seconda parte
                    i=(int) Math.round(Math.random()*(cognomiPersone.length-1));
                    out+=cognomiPersone[i]+" ";
                    } else {
                        i=(int) Math.round(Math.random()*(nomiAziendali.length-1));
                        out+=nomiAziendali[i]+" ";
                    }
                i=(int) Math.round(Math.random()*(nomiAziendali.length-1));
                out+=nomiAziendali[i]+" ";
                i=(int) Math.round(Math.random()*(tipologieAziendali.length-1));
                out+=tipologieAziendali[i];
                break;
            default: // di default restituiamo una stringa alfanumerica casuale
                char[] buf = new char[10];
                for (i=0;i<10;i++){
                    buf[i]= (char) ('A'+Math.round(Math.random()*26));
                }
                out = new String(buf);
                break;
        }
        return out;
    }
}
