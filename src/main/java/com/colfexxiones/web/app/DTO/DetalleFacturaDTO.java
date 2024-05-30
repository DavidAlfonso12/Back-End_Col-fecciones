package com.colfexxiones.web.app.DTO;

import com.colfexxiones.web.app.entity.Factura;
import com.colfexxiones.web.app.entity.Producto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalleFacturaDTO {

    private Long idUsuario;
    private List<ProductoFacturaDTO> productos;
}
