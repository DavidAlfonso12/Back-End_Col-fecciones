package com.colfexxiones.web.app.repository;

import com.colfexxiones.web.app.entity.Producto;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileRepository {
    String handleFileUpload(MultipartFile file, Long producto) throws Exception;
}
