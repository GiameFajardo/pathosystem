/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.Repository.Resultado;

/**
 *
 * @author Giame
 */
public interface IResultadoAppService {
    
    public Resultado InsertarResultado(Resultado _resultado);

    public Resultado ActualizarResultado(Resultado _resultado);

    public int GuardarResultado(Resultado _resultado);

    public boolean BorrarResultado(Resultado _resultado);

    public boolean BorrarResultado(int id);

    public boolean EliminarResultado(Resultado _resultado);

    public boolean EliminarResultado(int id);

    public boolean DesactivarResultado(Resultado _resultado);

    public boolean DesactivarResultado(int _id);

    public Resultado GetResultadoPorId(int _id);

    public List<Resultado> GetTodosResultados();
    
    List<Resultado> GetTodasResultadosPorNombre(String _nombre);
}
