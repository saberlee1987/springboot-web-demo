package com.saber.springbootwebdemo.domains.challenge;

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