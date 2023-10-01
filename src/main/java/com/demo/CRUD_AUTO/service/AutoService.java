package com.demo.CRUD_AUTO.service;

import com.demo.CRUD_AUTO.model.Auto;
import com.demo.CRUD_AUTO.repository.IAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService implements IAutoService{

    /*INYECCION DE LA DEPENDENCIA
    * DE HIBERNATE PARA CRUD*/
    @Autowired
    private IAutoRepository autoRepo;

    @Override
    public List<Auto> getAutos() {
        List<Auto> listaAutos = autoRepo.findAll();
        return listaAutos;
    }

    @Override
    public void saveAuto(Auto auto) {
        autoRepo.save(auto);
    }

    @Override
    public void deleteAuto(Long id) {
        autoRepo.deleteById(id);
    }

    @Override
    public Auto findAuto(Long id) {
        Auto auto = autoRepo.findById(id).orElse(null);
        return auto;
    }

    @Override
    public void editAuto(Long idOriginal, Long idNueva,
                         String nuevaMarca, String nuevoModelo,
                         String nuevoColor) {
        /*Proceso de como editar
        * Primero tenemos la id original con esa id original
        * tenemos que buscar en la base de datos si efectivamente
        * existe ese auto una vez que existe asignarle a un objeto
        * auto y a partir de eso modificar cada uno de los valores
        * que tengamos a ese objeto*/

        //buscamos el objeto:
        Auto auto = this.findAuto(idOriginal);

        //auto -> viene con los valores originales desde la db
        //entonces nosotros modificamos con los nuevos valores:
        auto.setId(idNueva);
        auto.setMarca(nuevaMarca);
        auto.setModelo(nuevoModelo);
        auto.setColor(nuevoColor);

        //Luego pasamos a la db estos nuevos parametros
        //facilmente llamamos al metodo que ya tenemos para guardar
        this.saveAuto(auto);
        //saveAuto lo que hace es recibirlo y mandarlo -> a la db
    }
}
