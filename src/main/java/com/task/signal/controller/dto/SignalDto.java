package com.task.signal.controller.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class SignalDto {
  @NotNull Integer value;
}
