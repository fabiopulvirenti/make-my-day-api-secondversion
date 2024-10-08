package com.northcoders.makemydayapi.dto.oneoffactivity.ticketmaster;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Getter
@NoArgsConstructor
public class Event {

    private String name;
    private List<Image> images;
    private Dates dates;
    private List<PriceRange> priceRanges;
    private String type;
    private List<Classification> classifications;

    @JsonProperty(value = "_embedded")
    private EmbeddedVenues embeddedVenues;
}
