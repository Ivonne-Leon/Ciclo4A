package com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.model.Cliente;
import com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.repository.ClienteRepository;

@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public ResponseEntity<List<Cliente>> getAllCliente(@RequestParam(required = false) String cedulaCliente){
		try {
			List<Cliente> cliente = new ArrayList<Cliente>(); 

			if (cedulaCliente == null) {
				clienteRepository.findAll().forEach(cliente::add);
			} else {
				clienteRepository.findBycedulaCliente(cedulaCliente).forEach(cliente::add);
			}
			if (cliente.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(cliente, HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/clientes/{Id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable("Id") String Id) {
		Optional<Cliente> clienteData = clienteRepository.findById(Id);

		if (clienteData.isPresent()) {
			return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/clientes")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente client) {
		try {
			Cliente _client = clienteRepository.save(
					new Cliente(client.getCedulaCliente(),
							client.getNombreCliente(),
							client.getDireccionCliente(),
							client.getTelefonoCliente(),
							client.getCorreoElectronico()));
			return new ResponseEntity<>(_cliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> updateProducto(@PathVariable("id") String Id, @RequestBody Cliente client) {
		Optional<Cliente> clienteData = clienteRepository.findById(Id);

		if (clienteData.isPresent()) {
			Cliente _cliente = clienteData.get();
			
			_cliente.setNombreCliente(client.getNombreCliente());
			_producto.setNitProveedor(produc.getNitProveedor());
			_producto.setPrecioCompra(produc.getPrecioCompra());
			_producto.setIvaCompra(produc.getIvaCompra());
			_producto.setPrecioVenta(produc.getPrecioVenta());
			productoRepository.save(_producto);
			return new ResponseEntity<>(_producto, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/productos/{codigo}")
	public ResponseEntity<HttpStatus> deleteProducto(@PathVariable("codigo") String codigo) {
		try {
			productoRepository.deleteBycodigoProducto(codigo);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/productos")
	public ResponseEntity<HttpStatus> deleteAllProductos() {
		try {
			productoRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private void add(Producto producto1) {
	}




}

