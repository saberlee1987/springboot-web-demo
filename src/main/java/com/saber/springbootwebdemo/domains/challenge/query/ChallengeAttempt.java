package com.saber.springbootwebdemo.domains.challenge.query;

import com.saber.springbootwebdemo.domains.user.query.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "challengeAttempt")
public class ChallengeAttempt implements Serializable {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    private Integer factorA;
    private Integer factorB;
    private Integer resultAttempt;
    private Boolean isCorrect;
}