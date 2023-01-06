package com.helloacm.apis.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {

    @JsonProperty("data")
    private String data;
}
