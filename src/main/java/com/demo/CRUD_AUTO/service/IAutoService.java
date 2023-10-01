package com.demo.CRUD_AUTO.service;

import com.demo.CRUD_AUTO.model.Auto;

import java.util.List;

/*DECLARACION DE TODOS LOS METODOS ABSTRACTOS*/
public interface IAutoService {
    //Metodo para traer todos los autos
    public List<Auto> getAutos();

    //alta:
    public void saveAuto(Auto auto);

    //baja:
    public void deleteAuto(Long id);

    //lectura de un solo objeto:
    public Auto findAuto(Long id);

    //Edicion modificacion:
    public void editAuto(Long idOriginal, Long idNueva,
                         String nuevaMarca, String nuevoModelo,
                         String nuevoColor);

}
