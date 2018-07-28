/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author elsoft
 */
public class GeneratoreDiRetiAziendali {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap struttura = new HashMap();
        LinkedList daRealizzare=new LinkedList();
        String[] ruoli={"Direttore",
            "Fondatore",
            "Finanziatore",
            "Amministratore"
        };
        HashSet<Persona> persone=new HashSet();
        int quante=3+(int) Math.round(8*Math.random());// di base generiamo un numero variabile tra 3 ed 11 aziende collegate alla prima
        for (int i=0;i<quante;i++){
            daRealizzare.push(Azienda.count);
        }
        while (daRealizzare.size()>0) {
            
            Azienda az=new Azienda(persone,ruoli, (int) daRealizzare.pop()); // creo una nuova azienda in relazione con la prima nello stack
            quante=(Azienda.count<10000)?(int) Math.round(8*Math.random()):0; // le aziende collegate alla nuova azienda a meno di aver già generato 100000 aziende, nel qual caso ci limitiamo a svuotare la coda
            for (int i=0;i<quante;i++){
                daRealizzare.push(az.id);
            }
            struttura.put(az.getId(),az);
            System.out.println(az);
        }
        
////        System.out.println(">"+quante+"<");
//        for (int i=0;i<quante;i++){
//            
//    //        espandiRete(az.getId());
//            az[i].espandiRete(persone, ruoli);
//            for(Azienda tmp:az[i].getAziende()){
//                tmp.espandiRete(persone, ruoli);
//            }
//            System.out.println(">>"+i+"<<");
//            //System.out.println(az[i]);
//        }
    }
    
//    static void espandiRete(int id){
//        int aziende=(int) Math.round(8*Math.random());// Ogni azienda ha a "aziende" sotto-aziende
//        for (int i=0;i<aziende;i++){
//            struttura.add(id,new Azienda(persone,ruoli));
//        }
//    }
    
}
