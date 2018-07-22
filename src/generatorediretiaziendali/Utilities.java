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
        public static String nomeCasuale() {
        char[] buf = new char[10];
        for (int i=0;i<10;i++){
            buf[i]= (char) ('A'+Math.round(Math.random()*26));
        }
        return new String(buf);
    }
}
