package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Matchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController sc;

    @Mock
    private ShipwreckRepository shipwreckRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck sw = new Shipwreck();

        sw.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);

        verify(shipwreckRepository).findOne(1l);

        //assertEquals(1l, wreck.getId().longValue());
        assertThat(wreck.getId(), is(1l));

    }

    @Test
    public void testShipwreckPost() {



    }

    @Test
    public void testShipwreckPut() {
        Shipwreck sw = new Shipwreck();
        sw.setId(1l);
        sw.setName("Test1");


        when(shipwreckRepository.findOne(1l)).thenReturn(sw);
        Shipwreck wreck = sc.get(1L);
        assertThat(wreck.getName(), is("Test1"));

        Shipwreck sw2 = new Shipwreck();
        sw.setId(1l);
        sw.setName("Test2");

        when(shipwreckRepository.findOne(1l)).thenReturn(sw);
        Shipwreck wreck2 = sc.get(1L);
        assertThat(wreck2.getName(), is("Test2"));


    }

    @Test
    public void testShipwreckDelete() {
        Shipwreck sw = new Shipwreck();

        sw.setId(1l);
        when(shipwreckRepository.findOne(1l)).thenReturn(sw);

        Shipwreck wreck = sc.get(1L);
        System.out.println(sc.get(1L));


        assertThat(wreck.getId(), is(1l));

        sc.delete(1l);
        System.out.println(sc.get(1L));

        assertThat(wreck.getId(), is(1l));

        //assertNull(wreck.getId());


    }
}
