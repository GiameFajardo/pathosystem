/*
 * Interfase 
 */
package org.itla.apppatologia.appservices;

import java.util.List;
import org.itla.apppatologia.DTO.PatologoDTO;

/**
 *<p>Interfase para las diferentes clase dedicadas a la distribucion de servicios de la entidad Patologo</p>
 * @author Giame Fajardo
 * @since 24/03/2016
 */
public interface IPatologoAppService {

    /**
     *
     * @param _patologo PatologoDTO
     * @return PatologoDTO ya con id asignado
     */
    public PatologoDTO InsertarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param _patologo
     * @return
     */
    public PatologoDTO ActualizarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param _patologo
     * @return
     */
    public int GuardarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param _patologo
     * @return
     */
    public boolean BorrarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param id
     * @return
     */
    public boolean BorrarPatologo(int id);

    /**
     *
     * @param _patologo
     * @return
     */
    public boolean EliminarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param id
     * @return
     */
    public boolean EliminarPatologo(int id);

    /**
     *
     * @param _patologo
     * @return
     */
    public boolean DesactivarPatologo(PatologoDTO _patologo);

    /**
     *
     * @param _id
     * @return
     */
    public boolean DesactivarPatologo(int _id);

    /**
     *
     * @param _id
     * @return
     */
    public PatologoDTO GetPorId(int _id);

    /**
     *
     * @return
     */
    public List<PatologoDTO> GetTodosPatologos();

    /**
     *
     * @param _nombre
     * @return
     */
    public List<PatologoDTO> GetTodosPatologosPorNombre(String _nombre);

    /**
     *
     * @param nombre
     * @param Apellido
     * @return
     */
    public List<PatologoDTO> GetPatologosPorNombreOAperllido(String _nombre, String _apellido);
    
}
