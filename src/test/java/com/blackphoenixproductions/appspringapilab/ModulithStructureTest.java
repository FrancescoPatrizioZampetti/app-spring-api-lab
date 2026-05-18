package com.blackphoenixproductions.appspringapilab;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModulithStructureTest {

    @Test
    void verificaStrutturaModulith() {
        ApplicationModules.of(AppSpringApiLabApplication.class).verify();
    }

}
