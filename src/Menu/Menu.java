/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import javax.swing.JPanel;


/**
 *
 * @author Vinh
 */
public class Menu {
    private String kind;
    private JPanel jpn;
    private JPanel jlb;

    public Menu() {
    }

    public Menu(String kind, JPanel jpn, JPanel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JPanel getJlb() {
        return jlb;
    }

    public void setJlb(JPanel jlb) {
        this.jlb = jlb;
    }
    

    
    
    
}
