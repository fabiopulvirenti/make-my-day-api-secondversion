package com.northcoders.makemydayapi.mapper.activity;

import com.northcoders.makemydayapi.dto.activity.oneoff.OneOffActivityResponse;
import com.northcoders.makemydayapi.dto.activity.oneoff.OneOffActivityResponseLocation;
import com.northcoders.makemydayapi.dto.activity.oneoff.OneOffActivityResponseVenue;
import com.northcoders.makemydayapi.dto.oneoffactivity.skiddle.SkiddleEvent;
import com.northcoders.makemydayapi.dto.oneoffactivity.skiddle.SkiddleVenue;
import com.northcoders.makemydayapi.model.activity.oneoff.OneOffActivityType;
import com.northcoders.makemydayapi.model.activity.oneoff.ResourceType;
import com.northcoders.makemydayapi.dto.activity.oneoff.OneOffActivityResponse;
import com.northcoders.makemydayapi.dto.activity.oneoff.OneOffActivityResponseLocation;

public class SkiddleResponseMapper {
    public final static OneOffActivityResponse toResponseDTO(SkiddleEvent skiddleEvent) {
        SkiddleVenue skiddleEventVenue = skiddleEvent.getVenue();

        OneOffActivityResponseLocation responseLocation = OneOffActivityResponseLocation.builder()
                .latitude(skiddleEventVenue.getLatitude())
                .longitude(skiddleEventVenue.getLongitude())
                .build();

        OneOffActivityResponseVenue responseVenue = OneOffActivityResponseVenue.builder()
                .name(skiddleEventVenue.getName())
                .address(skiddleEventVenue.getAddress())
                .postalCode(skiddleEventVenue.getPostcode())
                .build();

        OneOffActivityResponse oneOffActivityResponse = OneOffActivityResponse.builder()
//                .id()
//                .apiId(skiddleEvent.getId())
                .resourceType(ResourceType.SKIDDLE)
                .activityType(getActivityType(skiddleEvent.getEventCode()))
                .name(skiddleEvent.getEventname())
                .description(skiddleEvent.getDescription())
//                .createdDate()
//                .updatedDate()
                .isOutdoor(false)
                .venue(responseVenue)
                .oneOffActivityResponseLocation(responseLocation)
                .price(null) // nullable
                .date(skiddleEvent.getDate())
                .startTime(skiddleEvent.getStartdate().toLocalTime())
                .endTime(skiddleEvent.getEnddate().toLocalTime())
//                .imageUrl(skiddleEvent.getImageurl())
                .build();

        return oneOffActivityResponse;
    }

    private static OneOffActivityType getActivityType(String eventCode) {
        OneOffActivityType activityType = null;

        if (eventCode == null) {
            return OneOffActivityType.EVENT;
        }

        switch (eventCode) {
            case "FEST" -> activityType = OneOffActivityType.FEST;
            case "LIVE" -> activityType = OneOffActivityType.LIVE;
            case "CLUB" -> activityType = OneOffActivityType.CLUB;
            case "DATE" -> activityType = OneOffActivityType.DATE;
            case "THEATRE" -> activityType = OneOffActivityType.THEATRE;
            case "COMEDY" -> activityType = OneOffActivityType.COMEDY;
            case "EXHIB" -> activityType = OneOffActivityType.EXHIB;
            case "KIDS" -> activityType = OneOffActivityType.KIDS;
            case "BARPUB" -> activityType = OneOffActivityType.BARPUB;
            case "LGB" -> activityType = OneOffActivityType.LGB;
            case "SPORT" -> activityType = OneOffActivityType.SPORT;
            case "ARTS" -> activityType = OneOffActivityType.ARTS;
            default -> activityType = OneOffActivityType.EVENT;

        }

        return activityType;
    }
}
