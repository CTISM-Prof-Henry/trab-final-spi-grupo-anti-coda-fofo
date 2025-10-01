package com.ufsm.politecnico.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    @NonNull private String email;
    @NonNull private UUID uuid;
    private String senha;
}
