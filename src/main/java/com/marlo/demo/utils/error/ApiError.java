package com.marlo.demo.utils.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonPropertyOrder(value = {"error_type", "code", "error_message"})
@Data
@AllArgsConstructor
public class ApiError {

    @JsonProperty("code")
    String code;

    @JsonProperty("error_type")
    String type;

}