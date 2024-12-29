package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductoDao;
import com.example.demo.entity.Producto;


@Service
public class ProductoServiceImpl  implements ProductoService{
	
	
	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Producto> listaProducto() {
	    return productoDao.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public Producto buscarProducto(Long id) {
		return productoDao.findById(id).get();
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return productoDao.save(producto);
	}

	@Override
	public void eliminarProducto(Long id) {
		 productoDao.deleteById(id);	
	}

	

	

}
