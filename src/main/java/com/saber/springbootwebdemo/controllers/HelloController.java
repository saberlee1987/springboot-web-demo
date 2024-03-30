package com.saber.springbootwebdemo.controllers;

import com.saber.springbootwebdemo.dto.ErrorResponseDto;
import com.saber.springbootwebdemo.dto.Headers;
import com.saber.springbootwebdemo.dto.MessageDto;
import com.saber.springbootwebdemo.services.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping(value = "${service.baseUrl}/hello",
        produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "hello", description = "hello rest api")
public class HelloController {
    private final HelloService helloService;

    @GetMapping(value = "/sayHello")
    @Operation(summary = "sayHello", description = "say Hello",
            parameters = {
                    @Parameter(name = Headers.firstName, in = ParameterIn.QUERY, required = true, example = "saber"),
                    @Parameter(name = Headers.lastName, in = ParameterIn.QUERY, required = true, example = "Azizi")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))}),
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
    public ResponseEntity<MessageDto> sayHello(@RequestParam(name = "firstName", required = false)
                                               @NotBlank(message = "{firstName.required}")
                                               String firstName
            , @RequestParam(name = "lastName", required = false)
                                               @NotBlank(message = "{lastName.required}")
                                               String lastName) {
        return ResponseEntity.ok(helloService.sayHello(firstName, lastName));
    }

    @GetMapping(value = "/sayBye")
    @Operation(summary = "sayBye", description = "sayBye",
            parameters = {
                    @Parameter(name = Headers.firstName, in = ParameterIn.QUERY, required = true, example = "saber"),
                    @Parameter(name = Headers.lastName, in = ParameterIn.QUERY, required = true, example = "Azizi")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageDto.class))}),
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
    public ResponseEntity<MessageDto> sayBye(@RequestParam(name = "firstName", required = false)
                                               @NotBlank(message = "{firstName.required}")
                                               String firstName
            , @RequestParam(name = "lastName", required = false)
                                               @NotBlank(message = "{lastName.required}")
                                               String lastName) {
        return ResponseEntity.ok(helloService.sayBye(firstName, lastName));
    }
}