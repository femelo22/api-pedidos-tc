package com.br.tc.adapters.dtos.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageResponseDTO {
    private String keyImage;
    private String urlImage;
}
