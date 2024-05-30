package com.colfexxiones.web.app.service;

import com.colfexxiones.web.app.DTO.DetalleFacturaDTO;
import com.colfexxiones.web.app.DTO.FacturaResponseDTO;
import com.colfexxiones.web.app.DTO.ProductoDTO;
import com.colfexxiones.web.app.DTO.ProductoFacturaDTO;
import com.colfexxiones.web.app.entity.DetalleFactura;
import com.colfexxiones.web.app.entity.Factura;
import com.colfexxiones.web.app.entity.Producto;
import com.colfexxiones.web.app.entity.Usuario;
import com.colfexxiones.web.app.repository.DetalleFacturaRepository;
import com.colfexxiones.web.app.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DetalleFacturaService {

    @Autowired
    DetalleFacturaRepository detalleFacturaRepository;

    @Autowired
    FacturaRepository facturaRepository;

    @Autowired
    ImagenService imagenService;

    public void saveOrUpdate(DetalleFacturaDTO detalleFactura) {
        Factura factura = new Factura();
        factura.setFecha(new Date());
        Usuario usuarioEntity = new Usuario();
        usuarioEntity.setIdUsuario(detalleFactura.getIdUsuario());
        factura.setUsuario(usuarioEntity);
        factura = facturaRepository.save(factura);
        Factura finalFactura = factura;
        detalleFactura.getProductos().forEach(producto -> {
            DetalleFactura detalleFacturaEntity = new DetalleFactura();
            detalleFacturaEntity.setFactura(finalFactura);
            detalleFacturaEntity.setCantidadComprado(producto.getCantidad());
            detalleFacturaEntity.setValorUnidadCompra(producto.getPrecio());
            Producto productoEntity = new Producto();
            productoEntity.setIdProducto(producto.getId());
            detalleFacturaEntity.setProducto(productoEntity);
            detalleFacturaRepository.save(detalleFacturaEntity);
        });

    }

    public Optional<DetalleFactura> getDetalle(Integer idDetalle){
        return detalleFacturaRepository.findById(idDetalle);
    }

    public List<Factura> getFacturasUsuario(Long idUsuario){
        return facturaRepository.findByUsuario(idUsuario);
    }

    public List<Factura> getFacturasFecha(Date fechaInicio, Date fechaFin){
        return facturaRepository.buscarPorFecha(fechaInicio, fechaFin);
    }

    public List<FacturaResponseDTO> getDetalleFacturaIdFactura(Long idUsuario){
        List<FacturaResponseDTO> productoFacturaDTO = new ArrayList<>();
        List<Factura> facturas = facturaRepository.findByUsuario(idUsuario);
        facturas.forEach(factura -> {
            FacturaResponseDTO facturaResponseDTO = new FacturaResponseDTO();
            facturaResponseDTO.setId(factura.getId());
            facturaResponseDTO.setFecha(factura.getFecha());
            List<DetalleFactura> detalleFacturas = detalleFacturaRepository.findDetalleIdFactura(factura.getId());
            List<ProductoDTO> productos = new ArrayList<>();
            detalleFacturas.forEach(detalleFactura -> {
                ProductoDTO productoDTO = new ProductoDTO();
                productoDTO.setIdProducto(detalleFactura.getProducto().getIdProducto());
                productoDTO.setProducto_nombre(detalleFactura.getProducto().getProducto_nombre());
                productoDTO.setProducto_descripcion(detalleFactura.getProducto().getProducto_descripcion());
                productoDTO.setImagenes(imagenService.getImagenByIdProducto(detalleFactura.getProducto().getIdProducto()));
                productos.add(productoDTO);
            });
            facturaResponseDTO.setProductos(productos);
            productoFacturaDTO.add(facturaResponseDTO);
        });
        return productoFacturaDTO;

    }
}
