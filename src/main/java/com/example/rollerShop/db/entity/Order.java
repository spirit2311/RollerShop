package com.example.rollerShop.db.entity;

import java.time.LocalDateTime;
import java.util.Map;

public class Order extends BaseEntity{

    private Long orderNumber;

    private User user;

    private Map<Product, Integer> productIntegerMap;

    private LocalDateTime createdDate;

}
