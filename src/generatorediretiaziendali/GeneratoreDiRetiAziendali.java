/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author elsoft
 */
public class GeneratoreDiRetiAziendali {
    HashMap struttura;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        struttura=new HashMap();
        String[] ruoli={"Direttore",
            "Fondatore",
            "Finanziatore",
            "Amministratore"
        };
        
        HashSet<Persona> persone=new HashSet();
        int quante=(int) Math.round(8*Math.random());
        Azienda az[]=new Azienda[quante];
        System.out.println(">"+quante+"<");
        for (int i=0;i<quante;i++){
            az[i]=new Azienda(persone,ruoli);
    //        espandiRete(az.getId());
            az[i].espandiRete(persone, ruoli);
            for(Azienda tmp:az[i].getAziende()){
                tmp.espandiRete(persone, ruoli);
            }
            System.out.println(">>"+i+"<<");
            //System.out.println(az[i]);
        }
    }
    
//    static void espandiRete(int id){
//        int aziende=(int) Math.round(8*Math.random());// Ogni azienda ha a "aziende" sotto-aziende
//        for (int i=0;i<aziende;i++){
//            struttura.add(id,new Azienda(persone,ruoli));
//        }
//    }
    
}
