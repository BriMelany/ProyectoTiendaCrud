package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Producto;

public interface ProductoService {
	
	public List<Producto> listaProducto();
	
	public Producto guardarProducto(Producto producto);
	
	public Producto buscarProducto(Long id);
	
	public Producto actualizarProducto(Producto producto);
	
	public void eliminarProducto(Long id);

}
