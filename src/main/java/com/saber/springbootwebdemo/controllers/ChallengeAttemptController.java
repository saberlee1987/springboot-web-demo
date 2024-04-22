package com.saber.springbootwebdemo.controllers;

import com.saber.springbootwebdemo.domains.challenge.query.ChallengeAttempt;
import com.saber.springbootwebdemo.dto.*;
import com.saber.springbootwebdemo.services.ChallengeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.camel.spi.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attempts", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "challenge attempt", description = "challenge attempt controller")
@Validated
@RequiredArgsConstructor
public class ChallengeAttemptController {
    private final ChallengeService challengeService;

    @PostMapping()
    public ResponseEntity<ChallengeAttempt> challengeAttempt(@RequestBody @Valid ChallengeAttemptDto attempt) {
        return ResponseEntity.ok(challengeService.verifyAttempt(attempt));
    }

    @GetMapping(value = "/lastAttempts/{alias}")
    @Operation(summary = "sayBye", description = "sayBye",
            parameters = {
                    @Parameter(name = Headers.alias, in = ParameterIn.PATH, required = true, example = "saber66")

            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ChallengeAttemptDashboard.class))}),
                    @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "401", description = "UNAUTHORIZED",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "403", description = "FORBIDDEN",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "404", description = "NOT_FOUND",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "503", description = "SERVICE_UNAVAILABLE",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
                    @ApiResponse(responseCode = "504", description = "GATEWAY_TIMEOUT",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponseDto.class))}),
            })
    public ResponseEntity<ChallengeAttemptDashboard> get10ChallengeAttemptByUserAlias(@PathVariable  String alias) {
        return ResponseEntity.ok(challengeService.get10ChallengeAttemptByUserAlias(alias));
    }
}
