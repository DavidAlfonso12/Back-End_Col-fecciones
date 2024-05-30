package com.colfexxiones.web.app.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoFacturaDTO {
    private Long id;
    private Integer cantidad;
    private Integer precio;
}
