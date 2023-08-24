package com.example.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.service.SkuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SkuServiceImplTest {

  private SkuService skuService = new SkuServiceImpl();

  @Test
  void scenarioA() {
    final int scenarioA = skuService.scenarioA();
    assertEquals(100,scenarioA);
  }

  @Test
  void scenarioB() {
    final int scenarioB = skuService.scenarioB();
    assertEquals(370,scenarioB);
  }
  @Test
  void scenarioC() {
    final int scenarioC = skuService.scenarioC();
    assertEquals(280,scenarioC);
  }
}