package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {

        BeerDto dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void getCustomerById(){
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerDto = CustomerDto.builder().name("New Cust").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void testUpdateBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }
}