package com.example.jeux_6_qui_prend;

import org.junit.jupiter.api.Test;

class MainTest {
    //Field hostServices of type HostServices - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    Main main = new Main();


    @Test
    void testMain() {
        Main.main(new String[]{"args"});
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme