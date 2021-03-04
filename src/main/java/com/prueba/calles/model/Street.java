package com.prueba.calles.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Street {
    private int id;
    private int semaphoreId;
    private int nextStreet;
    private Street interception;
}
