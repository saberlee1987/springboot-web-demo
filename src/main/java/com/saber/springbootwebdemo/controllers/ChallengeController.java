package com.saber.springbootwebdemo.controllers;

import com.saber.springbootwebdemo.domains.challenge.query.Challenge;
import com.saber.springbootwebdemo.services.ChallengeGeneratorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/challenges", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "challenge",description = "challenge controller")
@Validated
@RequiredArgsConstructor
public class ChallengeController {
    private final ChallengeGeneratorService challengeGeneratorService;
    @GetMapping(value = "/random")
    public ResponseEntity<Challenge> generateChallenge(){
        return ResponseEntity.ok(challengeGeneratorService.randomChallenge());
    }
}