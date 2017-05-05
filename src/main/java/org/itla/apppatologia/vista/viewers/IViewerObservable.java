/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.vista.viewers;

import org.itla.apppatologia.vista.mantenimientos.IMantenimiento;

/**
 *
 * @author Giame
 */
public interface IViewerObservable {
    public void bind(IMantenimiento m);
    public void mandar(String txt);
    public void Buscar();
    public void PasarACampos();
}
