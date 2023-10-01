package com.demo.CRUD_AUTO.contoller;

import com.demo.CRUD_AUTO.model.Auto;
import com.demo.CRUD_AUTO.service.IAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AutoController {

    /*Inyectamos la dependencia
    * para que el Controller
    * Se pueda comunicar con
    * la logica osea los Servicios*/
    @Autowired
    private IAutoService autoServ;

    /*=======================
    ==Creamos los EndPoints==
    =======================*/

    @GetMapping  ("/autos/traer")
    public List<Auto> getAutos(){
        //devolvemos con return
        return autoServ.getAutos();
    }


    @PostMapping  ("/autos/crear")
    public String saveAuto(@RequestBody Auto auto){
        autoServ.saveAuto(auto);

        return "El auto fue creado correctamente";
    }


    @DeleteMapping  ("/autos/borrar/{id}")
    public String deleteAuto(@PathVariable Long id){
        autoServ.deleteAuto(id);

        return "El auto fue Eliminado!";
    }



    @PutMapping  ("/autos/editar/{id_original}")
    public Auto editAuto (@PathVariable Long id_original,
                          @RequestParam(required = false, name = "id")Long idNueva,
                          @RequestParam(required = false, name = "marca")String nuevaMarca,
                          @RequestParam(required = false, name = "modelo")String nuevoModelo,
                          @RequestParam(required = false, name = "color")String nuevoColor){
        //required = false -> Significa que no es necesario si no recibe el parametro
        //osea que es opcional no importa si no se modifica!

        /*Llamamos al metodo que cambia los parametros de mi objeto*/
        autoServ.editAuto(id_original, idNueva, nuevaMarca, nuevoModelo, nuevoColor);

        //Busca el objeto ya modificado y retornamos
        Auto auto = autoServ.findAuto(idNueva);

        return auto;

    }

}
