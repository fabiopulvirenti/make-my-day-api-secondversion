package com.northcoders.makemydayapi.dto.ticketmaster;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class Dates {

    @SerializedName("start")
    private Start start;

    @Data
    @Getter
    @NoArgsConstructor
    public static class Start {

        private String localDate;

        private String localTime;

    }


//    "dates": {
//        "start": {
//            "localDate": "2024-10-01",
//                    "localTime": "19:00:00",
//                    "dateTime": "2024-10-01T18:00:00Z",
//                    "dateTBD": false,
//                    "dateTBA": false,
//                    "timeTBA": false,
//                    "noSpecificTime": false
//        },
//        "timezone": "Europe/London",
//                "status": {
//            "code": "onsale"
//        },
//        "spanMultipleDays": false
//    },

}
