package com.saber.springbootwebdemo.domains.challenge.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Challenge implements Serializable {
    private Integer factorA;
    private Integer factorB;
}