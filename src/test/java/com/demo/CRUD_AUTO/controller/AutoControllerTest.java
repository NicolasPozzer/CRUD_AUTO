package com.demo.CRUD_AUTO.controller;

import com.demo.CRUD_AUTO.contoller.AutoController;
import com.demo.CRUD_AUTO.model.Auto;
import com.demo.CRUD_AUTO.service.AutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AutoControllerTest {
    @InjectMocks
    private AutoController controlTest;

    @Mock
    private AutoService autoServ;

    @Test
    public void getAutos(){
        Auto auto = new Auto();
        /*FALTA TERMINAR*/

        controlTest.getAutos();
    }

}
