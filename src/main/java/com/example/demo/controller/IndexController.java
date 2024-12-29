package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Producto;
import com.example.demo.service.ProductoService;



@Controller
public class IndexController {
	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping("/")
	public String Inicio(Model model) {
		model.addAttribute("titulo1", "inicio");
		return "inicio";	
	}
	
	@GetMapping("/about")
	public String About(Model model) {
		model.addAttribute("titulo2", "About");
		return "about";	
	}
	
	@GetMapping("/catalogo")
	public String Productos(Model model) {
		model.addAttribute("titulo3", "Productos");
		return "catalogo";	
	}
	
	@GetMapping("/chatBot")
	public String ChatBot(Model model) {
		model.addAttribute("titulo4", "chatBot");
		return "chatBot";	
	}
		
	@GetMapping("/productos")
	public String listarProductos(Model model) {
		model.addAttribute("productos", productoService.listaProducto());		
		return "productoMa";	
	}
	
	@GetMapping("/productos/nuevo")
	public String mostrarProducto(Model model) {
		Producto producto= new Producto();
		model.addAttribute("producto",producto);
		return "crearProducto";	
	}
	
	@PostMapping("/productos")
	public String guardarProducto(@ModelAttribute("producto") Producto producto) {
		productoService.guardarProducto(producto);
		return "redirect:/productos";	
	}
	
	@GetMapping("/producto/editar/{id}")
	public String buscarProducto(@PathVariable Long id,Model model ) {
		model.addAttribute("producto", productoService.buscarProducto(id));
		return "editarProducto";
	}
	
	@PostMapping("/producto/{id}")
	public String actualizarproducto(@PathVariable Long id,@ModelAttribute("producto") Producto producto,Model model ) {
		Producto productoNuevo = productoService.buscarProducto(id);
		productoNuevo.setId(id);
		productoNuevo.setNombre(producto.getNombre());
		productoNuevo.setDescripcion(producto.getDescripcion());
		productoNuevo.setPrecio(producto.getPrecio());
		productoNuevo.setCantidad(producto.getCantidad());
		
		productoService.actualizarProducto(productoNuevo);		
		return "redirect:/productos";
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public String eliminarProducto(@PathVariable Long id ) {
		productoService.eliminarProducto(id);
		return "redirect:/productos";
	}
	
}