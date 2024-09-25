package com.brunoandrade.fiadosafe.infra.dto;

import com.brunoandrade.fiadosafe.infra.domain.UserRole;

public record RegisterDTO (String login, String password, UserRole role){
}
