/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.EstudioDTO;

/**
 *
 * @author Giame
 */
public interface IEstudioAppService {
    public EstudioDTO InsertarEstudio(EstudioDTO _estudio);

    public EstudioDTO ActualizarEstudio(EstudioDTO _estudio);

    public int GuardarEstudio(EstudioDTO _estudio);

    public boolean BorrarEstudio(EstudioDTO _estudio);

    public boolean BorrarEstudio(int id);

    public boolean EliminarEstudio(EstudioDTO _estudio);

    public boolean EliminarEstudio(int id);

    public boolean DesactivarEstudio(EstudioDTO _estudio);

    public boolean DesactivarEstudio(int _id);

    public EstudioDTO GetPorId(int _id);

    public List<EstudioDTO> GetTodosEstudios();
    
    List<EstudioDTO> GetTodasEstudioPorNombre(String _nombre);
}
