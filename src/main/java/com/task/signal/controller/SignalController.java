package com.task.signal.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.library.SignalHandler;
import com.task.signal.controller.dto.SignalDto;

import lombok.RequiredArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/signals", consumes = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SignalController {

  private final SignalHandler signalHandler;

  @PostMapping
  public ResponseEntity<Void> executeSignal(@RequestBody @NotNull @Valid SignalDto signal) {
    signalHandler.handleSignal(signal.getValue());
    return ResponseEntity.ok().build();
  }
}
