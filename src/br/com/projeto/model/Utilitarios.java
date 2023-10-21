/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Gustavo
 */
public class Utilitarios {
    
    
    public void limpaTela(JPanel container) {
        Component components[] = container.getComponents();
        
        for (Component component : components) {
            
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }
            
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);
            }
            
        }
    }
    
    
}
