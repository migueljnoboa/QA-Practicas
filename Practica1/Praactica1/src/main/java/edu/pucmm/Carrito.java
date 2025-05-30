package edu.pucmm;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private List<ItemCarrito> itemCarritoList;

    public Carrito() {
        this.itemCarritoList = new ArrayList<>();
    }

    public List<ItemCarrito> getItemCarritoList() {
        return itemCarritoList;
    }

    public void setItemCarritoList(List<ItemCarrito> itemCarritoList) {
        this.itemCarritoList = itemCarritoList;
    }

    public void agregarProducto(Producto producto) {

        agregarProducto(producto, 1);
    }

    public void agregarProducto(Producto producto, int cantidad) {

        if (cantidad <= 0) {
            cantidad = 1;
        }

        for (ItemCarrito item : this.itemCarritoList) {
            if (item.getProducto().equals(producto)) {
                item.setCantidad(item.getCantidad() + cantidad);
                return;
            }
        }

        ItemCarrito itemCarrito = new ItemCarrito(producto, cantidad);
        this.itemCarritoList.add(itemCarrito);
    }

    public void eliminarProducto(Producto producto) {

        for (ItemCarrito item : this.itemCarritoList) {
            if (item.getProducto().equals(producto)) {
                this.itemCarritoList.remove(item);
                return;
            }
        }

    }

    public void modificarProducto(Producto producto, int cantidad) {

       if (cantidad < 0){
           cantidad = 0;
       }

        for (ItemCarrito item : this.itemCarritoList) {
            if (item.getProducto().equals(producto)) {
                item.setCantidad(cantidad);
                return;
            }
        }

        ItemCarrito itemCarrito = new ItemCarrito(producto, cantidad);
        this.itemCarritoList.add(itemCarrito);

    }

    public double calcularTotal() {

        double total = 0;

        for (ItemCarrito item : this.itemCarritoList) {
            total += item.getCantidad() * item.getProducto().getPrecio();
        }

        return total;

    }
}
