package com.malbano.ecommerce.controller;

import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.model.Pedido;
import com.malbano.ecommerce.service.PedidoService;
import com.malbano.ecommerce.utils.TestUtils;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PedidoControllerTests {

    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private PedidoService pedidoService;

    @Test
    public void testGetAllPedidos() throws Exception {

        Mockito.when(pedidoService.getAllPedidos()).thenReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/ecommerce/pedidos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testGetPedidoById() throws Exception {
        int pedidoId = 1;
        Pedido pedido = new Pedido();
        pedido.setId(pedidoId);

        Mockito.when(pedidoService.getPedidoById(pedidoId)).thenReturn(pedido);

        mockMvc.perform(MockMvcRequestBuilders.get("/ecommerce/pedidos/{id}", pedidoId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(pedidoId)));
    }

    @Test
    public void testCadastrarPedido() throws Exception {
        PedidoRequest pedidoRequest = new PedidoRequest();
        // Preencher o pedidoRequest conforme necessário

        mockMvc.perform(MockMvcRequestBuilders.post("/ecommerce/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJson(pedidoRequest)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    @Test
    public void testAtualizarPedido() throws Exception {
        int pedidoId = 1;
        PedidoRequest pedidoRequest = new PedidoRequest();
        // Preencher o pedidoRequest conforme necessário

        mockMvc.perform(MockMvcRequestBuilders.put("/ecommerce/pedidos/{id}", pedidoId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(TestUtils.convertObjectToJson(pedidoRequest)))
                .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}