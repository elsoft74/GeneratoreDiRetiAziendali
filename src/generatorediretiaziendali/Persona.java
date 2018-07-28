/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorediretiaziendali;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author elsoft
 */
class Persona implements Comparable {
    
    String nome;
    
    public Persona(){
        nome=Utilities.nomeCasuale("p");
    }
    
    @Override
     public int compareTo(Object o) {
        Persona az=(Persona)o;
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
        Persona az  = (Persona) o;
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(nome, az.getNome());
        return builder.isEquals();
       }
    
    public String getNome(){
        return nome;
    }
}
