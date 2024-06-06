package com.colfexxiones.web.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaResponseDTO {
    private Integer id;
    private Date fecha;
    private String direccion;
    private List<ProductoDTO> productos;
}
