package com.malbano.ecommerce.service;

import com.malbano.ecommerce.dto.request.ClienteRequest;
import com.malbano.ecommerce.dto.request.PedidoRequest;
import com.malbano.ecommerce.exception.NotFoundException;
import com.malbano.ecommerce.model.Cliente;
import com.malbano.ecommerce.model.Pedido;
import com.malbano.ecommerce.repository.PedidoRepositoy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PedidoServiceTests {

    @InjectMocks
    private PedidoService pedidoService;

    @Mock
    private PedidoRepositoy pedidoRepository;

    @Test
    public void testGetPedidoByAll() {

        when(pedidoRepository.findAll()).thenReturn(List.of());

        List<Pedido> result = pedidoService.getAllPedidos();

        Assert.assertEquals(0, result.size());
    }

    @Test
    public void testGetPedidoById() {
        int pedidoId = 1;
        Pedido pedido = new Pedido();
        pedido.setId(pedidoId);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedido));

        Pedido result = pedidoService.getPedidoById(pedidoId);

        Assert.assertEquals(pedidoId, result.getId().intValue());
    }

    @Test
    public void testGetPedidoByIdNotFound() {
        int pedidoId = 1;

        // Configura o comportamento simulado do pedidoRepository
        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.empty());

        // Verifica se a exceção NotFoundException é lançada
        assertThrows(NotFoundException.class, () -> {
            pedidoService.getPedidoById(pedidoId);
        });

        // Verifica se o método findById foi chamado apenas uma vez
        verify(pedidoRepository, times(1)).findById(pedidoId);
    }


    @Test
    public void testCadastrar() {
        PedidoRequest pedidoRequest = new PedidoRequest();
        ClienteRequest cliente = new ClienteRequest();
        cliente.setId(Long.valueOf(1123));
        cliente.setEmail("asda@asd");
        cliente.setNome("sim");
        pedidoRequest.setDataPedido(LocalDate.now());
        pedidoRequest.setCliente(cliente);
        // Preencher o pedidoRequest conforme necessário

        pedidoService.cadastrar(pedidoRequest);

        // Verifique se os métodos corretos foram chamados no repositório
        verify(pedidoRepository, times(1)).salvarPedido(Mockito.anyLong());
    }

    @Test
    public void testAtualizar() {
        int pedidoId = 1;

        PedidoRequest pedidoRequest = new PedidoRequest();
        ClienteRequest cliente = new ClienteRequest();
        cliente.setId(Long.valueOf(1123));
        cliente.setEmail("asda@asd");
        cliente.setNome("sim");
        pedidoRequest.setDataPedido(LocalDate.now());
        pedidoRequest.setCliente(cliente);
        // Preencher o pedidoRequest conforme necessário

        Pedido pedido = new Pedido();
        pedido.setId(pedidoId);

        when(pedidoRepository.findById(pedidoId)).thenReturn(Optional.of(pedido));

        pedidoService.atualizar(pedidoId, pedidoRequest);

        // Verifique se os métodos corretos foram chamados no repositório
        verify(pedidoRepository, times(1))
                .updatePedidoById(Mockito.eq(pedidoId), Mockito.any(LocalDate.class), Mockito.anyLong());
    }
}
