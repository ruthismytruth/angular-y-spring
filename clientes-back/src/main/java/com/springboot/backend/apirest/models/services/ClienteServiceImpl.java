package com.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.apirest.models.dao.IClienteDAO;
import com.springboot.backend.apirest.models.dao.IFacturaDao;
import com.springboot.backend.apirest.models.dao.IProductoDao;
import com.springboot.backend.apirest.models.entity.Cliente;
import com.springboot.backend.apirest.models.entity.Factura;
import com.springboot.backend.apirest.models.entity.Producto;
import com.springboot.backend.apirest.models.entity.Region;

@Service
public class ClienteServiceImpl implements IClientesService {
	
	@Autowired
	private IClienteDAO clienteDao;
	
	@Autowired
	private IFacturaDao facturaDao;
	
	@Autowired
	private IProductoDao productoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = false)
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Transactional(readOnly = true)
	public List<Region> findAllRegiones(){
		return clienteDao.findAllRegiones();
	}

	@Override
	@Transactional(readOnly = true)
	public Factura findFacturaById(Long id) {
		return facturaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly = false)
	public Factura save(Factura factura) {
		return facturaDao.save(factura);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteFacturaById(Long id) {
		facturaDao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public List<Producto> findProductoByNombre(String termino){
		return productoDao.findByNombre(termino);
	}

}
