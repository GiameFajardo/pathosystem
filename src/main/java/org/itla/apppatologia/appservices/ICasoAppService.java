/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.CasoDTO;

/**
 *
 * @author Giame
 */
public interface ICasoAppService {
    public CasoDTO InsertarCaso(CasoDTO _caso);

    public CasoDTO ActualizarCaso(CasoDTO _caso);

    public int GuardarCaso(CasoDTO _caso);

    public boolean BorrarCaso(CasoDTO _caso);

    public boolean BorrarCaso(int id);

    public boolean EliminarCaso(CasoDTO _caso);

    public boolean EliminarCaso(int id);

    public boolean DesactivarCaso(CasoDTO _caso);

    public boolean DesactivarCaso(int _id);

    public CasoDTO GetCasoPorId(int _id);

    public List<CasoDTO> GetTodosCasos();
    
    List<CasoDTO> GetTodosCasosPorNombre(String _nombre);
}
