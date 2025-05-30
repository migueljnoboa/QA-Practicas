package edu.pucmm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarritoTest {

    private Carrito carrito = new Carrito();
    private Producto producto = new Producto();
    private int cantidad;

    @BeforeEach
    public void setUp() {
        carrito = new Carrito();
        producto = new Producto("producto1", 200.00);
        cantidad = 5;
    }

    @Test
    public void agregarAlCarritoTest() {

        carrito.agregarProducto(producto);

        boolean testProducto = false;
        for (ItemCarrito itemCarrito : carrito.getItemCarritoList()){
            if (itemCarrito.getProducto().equals(producto)){
                testProducto = true;
            }
        }

        assertTrue(testProducto);

    }

    @Test
    public void eliminarAlCarritoTest() {

        carrito.agregarProducto(producto);
        carrito.eliminarProducto(producto);

        boolean testProducto = false;
        for (ItemCarrito itemCarrito : carrito.getItemCarritoList()){
            if (itemCarrito.getProducto().equals(producto)){
                testProducto = true;
            }
        }
        assertFalse(testProducto);
    }

    @Test
    public void modificarAlCarritoTest() {

        carrito.modificarProducto(producto, cantidad);

        boolean testProducto = false;
        for (ItemCarrito itemCarrito : carrito.getItemCarritoList()){
            if (itemCarrito.getProducto().equals(producto) && itemCarrito.getCantidad() == cantidad){
                testProducto = true;
            }
        }
        assertTrue(testProducto);
    }

    @Test
    public void calcularTotalCarritoTest() {

        carrito.agregarProducto(producto, cantidad);

        assertEquals(1000.00, carrito.calcularTotal());
    }

}
