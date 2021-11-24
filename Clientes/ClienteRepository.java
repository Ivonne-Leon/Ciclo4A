package com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.misiontic2022.grupo51.tiendagenerica.tiendagenerica51.model.Producto;
import java.util.List;

public interface ClienteRepository extends MongoRepository<Producto, String>{
	
	
	List<Producto> findBycedulaCliente(String cedulaCliente);
	List<Producto> findBynombreCliente(String nombreCliente);
	void deleteBycedulaCliente(String cedulaCliente);
	

}
