package com.example.jeux_6_qui_prend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class MainTest {
    //Field hostServices of type HostServices - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    com.example.jeux_6_qui_prend.Main main= new com.example.jeux_6_qui_prend.Main();

    @Test
    void testStart(){
        main.start(null);
    }

    @Test
    void testMain(){
        Main.main(new java.lang.String[]{"args"});
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme