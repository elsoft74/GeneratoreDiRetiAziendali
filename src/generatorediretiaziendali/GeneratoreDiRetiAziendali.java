/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
        HashMap<Integer,Azienda> struttura = new HashMap();
        LinkedList daRealizzare=new LinkedList();

        HashSet<Persona> persone=new HashSet();
        int quante=3+(int) Math.round(8*Math.random());// di base generiamo un numero variabile tra 3 ed 11 aziende collegate alla prima
        for (int i=0;i<quante;i++){
            daRealizzare.push(Azienda.count);
        }
        while (daRealizzare.size()>0) {
            
            Azienda az=new Azienda(persone, (int) daRealizzare.pop()); // creo una nuova azienda in relazione con la prima nello stack
            quante=(Azienda.count<100)?(int) Math.round(8*Math.random()):0; // le aziende collegate alla nuova azienda a meno di aver già generato 100000 aziende, nel qual caso ci limitiamo a svuotare la coda
            for (int i=0;i<quante;i++){
                daRealizzare.push(az.id);
            }
            struttura.put(az.getId(),az);
        }
        System.out.println("Entity A Type,Entity A,Entity B Type,Entity B,Connection");
        
        for (Integer k:struttura.keySet()){
            Azienda az1=struttura.get(k);
            int rel=az1.getRel();
            if (k!=rel){
                Azienda az2=struttura.get(az1.getRel());
                System.out.println("Organization,"+az1.getNome()+", Organization,"+az2.getNome()+", Owns");
            }
        }
        for (Integer k:struttura.keySet()){
            Azienda az1=struttura.get(k);
            HashMap<String,String> personeAzienda=az1.getPersone();
            for (String k1:personeAzienda.keySet()){
                String p=personeAzienda.get(k1);
                System.out.println("Person,"+p+",Organization,"+az1.getNome()+","+k1);
            } 
        }
        
        Iterator iter=persone.iterator();
        while (iter.hasNext()){
            Persona p=(Persona) iter.next();
            int quanti=(int) Math.round(4*Math.random()); // persone con cui la persona è in relazione
            for (int j=0;j<quanti;j++){
                int k=1+(int)Math.round((persone.size()-1)*Math.random());
                Iterator iter1=persone.iterator();
                Persona p2=(Persona) iter1.next();
                while (--k>0){
                    p2=(Persona) iter1.next();
                }
                if (p.getNome().compareTo(p2.getNome())!=0){ // Se sono omonimi li scarto
                    int l=(int)Math.round((Utilities.ruoliInterpersonali.length-1)*Math.random());
                    System.out.println("Person,"+p.getNome()+",Person,"+p2.getNome()+","+Utilities.ruoliInterpersonali[l]);
                }
            }
        }
    }
}
