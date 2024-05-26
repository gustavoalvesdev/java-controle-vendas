package br.com.projeto.model;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.JTextComponent;

public class Utilitarios {
    
    
    public void limpaTela(JPanel container) throws NullPointerException {
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
    
    public static void converteEmMaiusculo(JTextComponent component) throws NullPointerException {
        ((AbstractDocument) component.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                super.insertString(fb, offset, string.toUpperCase(), attr);
            };
            
            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
              
                    super.replace(fb, offset, length, text.toUpperCase(), attrs);
                
                
            }
        });
    }
    
    
}
