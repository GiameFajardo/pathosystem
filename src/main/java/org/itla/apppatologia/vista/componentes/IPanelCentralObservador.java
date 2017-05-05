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
public interface IPanelCentralObservador {
    public void Update(ISubMenuObservable pn, String pnName);
    public void SetPanel(JPanel pnfrm, JPanel pnvwr, boolean sobreponer);
    public boolean IsPinned(boolean b);
    public void OcultarSubMenu();
    public void SetDividerSize(Integer size);
}
