package com.logistics.delivery_optimizer.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourResponseDto {
    private Long id;
    private LocalDate tourDate;
}
