package com.robihidayat.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class AcquirerItems {
    private String terminalId;
    private String cardId;
    private String acquirerId;
}