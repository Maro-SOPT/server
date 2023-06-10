package com.sopt.wokat.infra.kakao.CoordToLocation;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
    * "meta": {
            "total_count": 2
        },
        "documents": [
            {
            "address_name": "서울특별시 강남구 신사동",
            ...
            }, ...
        ]
    } 
    에서 주소값 담긴 documents 가져오기 
 */
@Data
@AllArgsConstructor @NoArgsConstructor
public class APIResponseBody {
    
    @JsonProperty("documents")
    private APIDocument[] documents;

}
