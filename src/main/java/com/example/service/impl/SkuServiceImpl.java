package com.example.service.impl;

import com.example.entity.SKU;
import com.example.service.SkuService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SkuServiceImpl implements SkuService {

  private static final List<SKU> SKUS = new ArrayList<>();

  static {
    SKUS.add(SKU.builder().unit("A").price(50).qnt(1).build());
    SKUS.add(SKU.builder().unit("B").price(30).qnt(1).build());
    SKUS.add(SKU.builder().unit("C").price(20).qnt(1).build());
    SKUS.add(SKU.builder().unit("D").price(15).qnt(1).build());
  }

  @Override
  public int scenarioA() {
    final Optional<Integer> reduce = SKUS.stream().filter(qnt -> qnt.getQnt() == 1).limit(3)
        .map(SKU::getPrice).reduce(Integer::sum);
    return reduce.orElse(0);
  }

  @Override
  public int scenarioB() {
    final List<SKU> SKUS = new ArrayList<>();
    SKUS.add(SKU.builder().unit("A").price(50).qnt(5).build());
    SKUS.add(SKU.builder().unit("B").price(30).qnt(5).build());
    SKUS.add(SKU.builder().unit("C").price(20).qnt(1).build());
    int sum = 0;
    for (SKU sku : SKUS) {
      if (sku.getQnt() > 2) {
        if (sku.getUnit().equals("A")) {
          final int i = sku.getQnt() % 3;
          sum = sum+sku.getPrice() * i + 130;
        } else if (sku.getUnit().equals("B")) {
          final int i = sku.getQnt() % 2;
          sum =sum +45 * 2 + 30 * i;
        }

      } else if (sku.getUnit().equals("C")) {
        sum = sum + 20;
      }
    }

    return sum;
  }

  @Override
  public int scenarioC() {
    final List<SKU> SKUS = new ArrayList<>();
    SKUS.add(SKU.builder().unit("A").price(50).qnt(3).build());
    SKUS.add(SKU.builder().unit("B").price(30).qnt(5).build());
    SKUS.add(SKU.builder().unit("C").price(20).qnt(1).build());
    SKUS.add(SKU.builder().unit("D").price(15).qnt(1).build());
    int sum = 0;
    for (SKU sku : SKUS) {
      if (sku.getQnt() > 2) {
        if (sku.getUnit().equals("A")) {
          final int i = sku.getQnt() % 3;
          sum = sum+sku.getPrice() * i + 130;
        } else if (sku.getUnit().equals("B")) {
          final int i = sku.getQnt() % 2;
          sum =sum +45 * 2 + 30 * i;
        }

      } else if (sku.getUnit().equals("D")) {
        sum = sum + 30;
      }
    }
    return sum;
  }
}
