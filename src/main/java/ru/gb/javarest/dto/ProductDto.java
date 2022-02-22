package ru.gb.javarest.dto;

import lombok.*;
import ru.gb.javarest.entity.enums.Status;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    @NotBlank(message = "title is required")
    private String title;
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 5, fraction = 2)
    private BigDecimal cost;
    @PastOrPresent
    private LocalDate date;
    @NotNull
    private Status status;
}
