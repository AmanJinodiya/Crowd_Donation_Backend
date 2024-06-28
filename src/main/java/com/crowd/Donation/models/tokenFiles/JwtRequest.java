package com.crowd.Donation.models.tokenFiles;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class JwtRequest {
    private String username;
    private String password;


}

