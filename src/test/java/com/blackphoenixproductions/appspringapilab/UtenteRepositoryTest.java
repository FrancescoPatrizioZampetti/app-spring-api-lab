package com.blackphoenixproductions.appspringapilab;

import com.blackphoenixproductions.appspringapilab.utente.entity.Utente;
import com.blackphoenixproductions.appspringapilab.utente.repository.IUtenteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UtenteRepositoryTest {

    @Autowired
    private IUtenteRepository utenteRepository;

    @Test
    public void testFindByUsername() {
        Utente utente =  utenteRepository.findByUsername("testuser");
        System.out.println(utente);
    }
}
