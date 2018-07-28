/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author elsoft
 */
public class Azienda implements Comparable{
    int idRel;
    HashMap<String,String> ruoliAziendali;
    String nome;
    static int count=0;
    int id;
    
    
    @Override
     public int compareTo(Object o) {
        Azienda az=(Azienda)o;
        int val=nome.compareTo(az.getNome());
        return val;
    }
     
    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getNome());
        return builder.hashCode();
    }
       
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Azienda))
                return false;
        Azienda az  = (Azienda) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(nome, az.getNome());
        return builder.isEquals();
       } 
    
    public Azienda(HashSet<Persona> persone,int idRel) {
        this.id=count;
        count++;
        this.idRel=idRel;
        this.ruoliAziendali = new HashMap();
        int npers;
        npers=2+(int) Math.round(3*Math.random());// Ogni azienda ha fino a "aziende" sotto-aziende
        nome=Utilities.nomeCasuale("a");
        for (int i=0;i<npers;i++){
            int j=(int) Math.round(100*Math.random());
            int size,k;
            Persona daInserire=null;
            if (j<=15&&!persone.isEmpty()) { //Al 15% la persona già esiste 
                size=persone.size()-1;
                k=1+(int) Math.round(size*Math.random());
                Iterator iter=persone.iterator();
                while (k>0) {
                    daInserire=(Persona)iter.next();
                    k--;
                }
                size=Utilities.ruoli.length-1;
                k=(int) Math.round(size*Math.random());
//                System.out.print("k="+k+"\t");
//                System.out.print("nome="+daInserire.getNome()+"\t");
//                System.out.print("ruolo="+Utilities.ruoli[k]+"\n");
                ruoliAziendali.put(Utilities.ruoli[k], daInserire.getNome());
            } else {
                daInserire=new Persona();
                persone.add(daInserire);
            }
            size=Utilities.ruoli.length-1;
            k=(int) Math.round(size*Math.random());
            ruoliAziendali.put(Utilities.ruoli[k], daInserire.getNome());
        }
    }

    
    @Override
    public String toString(){
        String out;
        out="ID:\t"+id+" nome:\t"+nome+"\t in relazione con:"+idRel/* " con "+totaleSottoAziende()+" sotto-aziende.\n"*/;
        out+="\nPersone :";
        for (String k : ruoliAziendali.keySet()) {
            out+="{"+k+":"+ruoliAziendali.get(k)+"}\t";
        }
        return out;
    }

    public String getNome() {
        return nome;
    }

    int getId() {
        return id;
    }
    
    public HashMap<String,String> getPersone(){
        return ruoliAziendali;
    }

    public int getRel() {
        return idRel;
    }
}
