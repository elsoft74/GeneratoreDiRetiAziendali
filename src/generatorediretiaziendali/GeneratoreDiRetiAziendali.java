/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import java.util.HashSet;

/**
 *
 * @author elsoft
 */
public class GeneratoreDiRetiAziendali {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] ruoli={"Direttore",
            "Fondatore",
            "Finanziatore",
            "Amministratore"
        };
        HashSet<Persona> persone=new HashSet();
        Azienda az=new Azienda(persone,ruoli);
        System.out.println(az);
    }
    
}
