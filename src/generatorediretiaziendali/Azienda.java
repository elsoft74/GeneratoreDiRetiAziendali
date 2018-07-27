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
    HashSet<Azienda> aziendeCollegate; // Le aziende che dipendono
    HashMap<String,String> ruoliAziendali;
    String nome;
    static int count=0;
    
    
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
    
    public Azienda(HashSet<Persona> persone,String[] ruoli) {
        count++;
        System.out.println("Creo:"+count);
        this.ruoliAziendali = new HashMap();
        aziendeCollegate=new HashSet();
        int npers;
        npers=2+(int) Math.round(3*Math.random());// Ogni azienda ha fino a "aziende" sotto-aziende
        nome=Utilities.nomeCasuale();
        for (int i=0;i<npers;i++){
            //Al 15% la persona già esiste
            int j=(int) Math.round(100*Math.random());
            int size,k;
            Persona daInserire=null;
            if (j<=15&&!persone.isEmpty()) {
                size=persone.size();
                k=(int) Math.round(size*Math.random());
                Iterator iter=persone.iterator();
                while (k>0) {
                    daInserire=(Persona)iter.next();
                    k--;
                }
                size=ruoli.length-1;
                k=(int) Math.round(size*Math.random());
                ruoliAziendali.put(ruoli[k], daInserire.getNome());
            } else {
                daInserire=new Persona();
            }
            size=ruoli.length-1;
            k=(int) Math.round(size*Math.random());
            ruoliAziendali.put(ruoli[k], daInserire.getNome());
        }
    }

    public void espandiRete(HashSet<Persona> persone,String[] ruoli){
        //if (Math.random()>0.2){ // per limitare la ricorsione
            int aziende=(int) Math.round(3*Math.random());// Ogni azienda ha fino a "aziende" sotto-aziende
            for (int i=0;i<aziende;i++){
                Azienda tmp=new Azienda(persone,ruoli);
                tmp.espandiRete(persone, ruoli);
                aziendeCollegate.add(tmp);
            }
        //}
    }
    
    @Override
    public String toString(){
        String out;
        out=nome+ " con "+totaleSottoAziende()+" sotto-aziende.\n";
        out+="Persone :";
        for (String k : ruoliAziendali.keySet()) {
            out+="{"+k+":"+ruoliAziendali.get(k)+"}\t";
        }
        if (totaleSottoAziende()>0) {
            out+="\tComposta da:{";
            Iterator<Azienda> iter=aziendeCollegate.iterator();
            while (iter.hasNext()){
                Azienda tmp=iter.next();
                out+=tmp;
            }
            out+="} ";
        }
        return out;
    }

    private String getNome() {
        return nome;
    }

    private int totaleSottoAziende() {
        return aziendeCollegate.size();
    }

    Azienda[] getAziende() {
        return (Azienda[]) aziendeCollegate.toArray(new Azienda[aziendeCollegate.size()]);
    }

    int getId() {
        return count;
    }
}
