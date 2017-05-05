/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.FragmentoDTO;

/**
 *
 * @author Giame
 */
public interface IFragmentoAppService {
    
    public FragmentoDTO InsertarFragmento(FragmentoDTO _fragmento);

    public FragmentoDTO ActualizarFragmento(FragmentoDTO _fragmento);

    public int GuardarFragmento(FragmentoDTO _fragmento);

    public boolean BorrarFragmento(FragmentoDTO _fragmento);

    public boolean BorrarFragmento(int id);

    public boolean EliminarFragmento(FragmentoDTO _fragmento);

    public boolean EliminarFragmento(int id);

    public boolean DesactivarFragmento(FragmentoDTO _fragmento);

    public boolean DesactivarFragmento(int _id);

    public FragmentoDTO GetPorId(int _id);

    public List<FragmentoDTO> GetTodosFragmentos();
    
    List<FragmentoDTO> GetTodasFragmentosPorNombre(String _nombre);
}
