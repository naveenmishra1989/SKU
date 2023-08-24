package com.example.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SKU {
  private String unit;
  private Integer price;
  private Integer qnt;
}
