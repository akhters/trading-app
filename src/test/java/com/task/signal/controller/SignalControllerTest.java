package com.task.signal.controller;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.task.library.SignalHandler;
import com.task.signal.config.MessageConverterConfig;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = SignalController.class)
@Import(MessageConverterConfig.class)
public class SignalControllerTest {

  @MockBean private SignalHandler signalHandler;

  @Autowired MockMvc mockMvc;

  @Test
  void shouldExecuteSignal() throws Exception {
    doNothing().when(signalHandler).handleSignal(1);

    mockMvc
        .perform(post("/signals").content("{\"value\": 1}").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());

    verify(signalHandler).handleSignal(1);
  }

  @ParameterizedTest
  @MethodSource("signalDtoProvider")
  void shouldReturnBadRequest_whenSignalTypeIsInvalid(String body) throws Exception {
    mockMvc
        .perform(
            post("/signals")
                .content(body) // sends string
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());

    verifyNoInteractions(signalHandler);
  }

  public static Stream<Arguments> signalDtoProvider() {
    return Stream.of(
        Arguments.of("{\"value\": \"a-value\"}"),       // value is string
        Arguments.of("{\"value\": 1.5}"),               // value is float
        Arguments.of("{}")                              // value is null
        );
  }
}
