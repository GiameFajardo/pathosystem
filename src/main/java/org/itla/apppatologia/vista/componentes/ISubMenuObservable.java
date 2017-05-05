/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.componentes;

import javax.swing.JPanel;

/**
 *
 * @author Chu
 */
public interface ISubMenuObservable {
    public void Notificar();
    public void GetPanel(JPanel pnfrm, JPanel pnvwr, boolean sobreponer);
    public void UnSelectAllButton();
    
}
    