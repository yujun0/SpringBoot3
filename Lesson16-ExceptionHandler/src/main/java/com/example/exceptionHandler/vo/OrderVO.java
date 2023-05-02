package com.example.exceptionHandler.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class OrderVO {
    @NotBlank(message = "訂單名稱不能為空")
    private String name;

    @NotNull(message = "商品必須有數量")
    @Range(min= 1, max =  99 ,message = "一個訂單的商品數量在{min}-{max}")
    private Integer amount;

    @NotNull(message = "用戶不能為空")
    @Min(value = 1,message = "從1開始")
    private Integer userId;
}

