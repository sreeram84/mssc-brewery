package guru.springframewrok.msscbrewery.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframewrok.msscbrewery.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    public BeerDto validBeer(){
        return BeerDto.builder().id(UUID.randomUUID()).beerName("Mock beer").beerStyle("PALE").build();
    }


    @Test
    void getBeer() {
    }

    @Test
    void handlePost() {
    }

    @Test
    void handleUpdate() throws  Exception{
        BeerDto beerDto = validBeer();
        beerDto.setId(null);
        String beerDtoToJson = mapper.writeValueAsString(beerDto);
        mockMvc.perform(put("/api/v1/beer/" + UUID.randomUUID().toString())
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoToJson)).andExpect(status().isNoContent());

    }

    @Test
    void deleteBeer() {
    }
}