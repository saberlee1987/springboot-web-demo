package com.saber.springbootwebdemo.controllers;

import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.ChallengeAttemptDto;
import com.saber.springbootwebdemo.services.ChallengeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/attempts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "challenge attempt",description = "challenge attempt controller")
@Validated
@RequiredArgsConstructor
public class ChallengeAttemptController {
    private final ChallengeService challengeService;

    @PostMapping()
    public ResponseEntity<ChallengeAttempt> challengeAttempt(@RequestBody @Valid ChallengeAttemptDto attempt){
        return ResponseEntity.ok(challengeService.verifyAttempt(attempt));
    }
}
