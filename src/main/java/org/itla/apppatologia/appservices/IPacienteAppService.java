/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.FragmentoDTO;
import org.itla.apppatologia.DTO.PacienteDTO;

/**
 *
 * @author Giame
 */
public interface IPacienteAppService {
    
    public PacienteDTO InsertarPaciente(PacienteDTO _paciente);

    public PacienteDTO ActualizarPaciente(PacienteDTO _paciente);

    public int GuardarPaciente(PacienteDTO _paciente);

    public boolean BorrarPaciente(PacienteDTO _paciente);

    public boolean BorrarPaciente(int id);

    public boolean EliminarPaciente(PacienteDTO _paciente);

    public boolean EliminarPaciente(int id);

    public boolean DesactivarPaciente(PacienteDTO _paciente);

    public boolean DesactivarPaciente(int _id);

    public PacienteDTO GetPacientePorId(int _id);

    public List<PacienteDTO> GetTodosPacientes();
    
    List<PacienteDTO> GetTodasPacientesPorNombre(String _nombre);
}
