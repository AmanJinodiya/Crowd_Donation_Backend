package com.crowd.Donation.models.tokenFiles;



import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {
    private String jwtToken;
    private String username;


}
