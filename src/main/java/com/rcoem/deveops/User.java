package com.rcoem.deveops;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;


@AllArgsConstructor
@Getter
@Setter

public class User {
    String userId;
    String name ;
    String department;



}
