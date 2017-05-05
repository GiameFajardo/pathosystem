/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.ArsDTO;

/**
 *
 * @author Giame
 */
public interface IAseguradoraAppService {
    
    public ArsDTO InsertarAseguradora(ArsDTO _ars);

    public ArsDTO ActualizarAseguradora(ArsDTO _ars);

    public int GuardarAseguradora(ArsDTO _ars);

    public boolean BorrarAseguradora(ArsDTO _ars);

    public boolean BorrarAseguradora(int id);

    public boolean EliminarAseguradora(ArsDTO _ars);

    public boolean EliminarAseguradora(int id);

    public boolean DesactivarAseguradora(ArsDTO _ars);

    public boolean DesactivarAseguradora(int _id);

    public ArsDTO GetPorId(int _id);

    public List<ArsDTO> GetTodasAseguradoras();
    
    List<ArsDTO> GetTodasAseguradorasPorNombre(String _nombre);
}
