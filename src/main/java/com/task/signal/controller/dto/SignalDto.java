package com.task.signal.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;

@Value
@AllArgsConstructor
public class SignalDto {
    @NotNull
    Integer value;
}
