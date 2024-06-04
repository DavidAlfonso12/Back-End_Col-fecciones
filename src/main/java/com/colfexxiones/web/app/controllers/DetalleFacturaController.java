package com.colfexxiones.web.app.controllers;

import com.colfexxiones.web.app.DTO.DetalleFacturaDTO;
import com.colfexxiones.web.app.DTO.FacturaResponseDTO;
import com.colfexxiones.web.app.entity.DetalleFactura;
import com.colfexxiones.web.app.entity.Factura;
import com.colfexxiones.web.app.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping(path = "api/v1/detalleFactura")
public class DetalleFacturaController {

    @Autowired
    DetalleFacturaService detalleFacturaService;

    @PostMapping
    public void saveDF(@RequestBody DetalleFacturaDTO detalleFactura){
        detalleFacturaService.saveOrUpdate(detalleFactura);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<FacturaResponseDTO> getFacturasUsuario(@PathVariable("idUsuario") Long idUsuario){
        return detalleFacturaService.getDetalleFacturaIdFactura(idUsuario);
    }

    @GetMapping("/FacturasFecha/{fechaInicio}/{fechaFin}")
    public List<Factura> getFacturasFechas(@PathVariable("fechaInicio")
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
                                           @PathVariable("fechaFin")
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin){
        return detalleFacturaService.getFacturasFecha(fechaInicio, fechaFin);
    }

    @GetMapping("/FacturasVendedor/{idUsuario}")
    public List<DetalleFactura> getFacturasByVendedor(@PathVariable("idUsuario") Long idUsuario){
        return detalleFacturaService.getFacturasVendedor(idUsuario);
    }
}
