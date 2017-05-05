/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.mantenimientos;

import javax.swing.JPanel;
import org.itla.apppatologia.DTO.ArsDTO;
import org.itla.apppatologia.vista.componentes.IPanelCentralObservador;
import org.itla.apppatologia.vista.viewers.IViewerObservable;

/**
 *
 * @author Giame
 */
public interface IMantenimiento {
    public void bind(IViewerObservable v,IPanelCentralObservador p);
    public Object Save();//devuelve la entidad guardada
    public boolean Clean();//borra los campos de form
    public boolean Borrar();//borra la entidad seleccionada
    public boolean CanModify(boolean b);
    public void Show(Object o);
    public boolean IsPinned();//metodo para saber si el formulario está anclado
    public void CargarMantenimiento(JPanel pnvwr, JPanel pnfrm, boolean sobreponer);//metodo 
    public void MandarSizePadre(Integer size);
}
