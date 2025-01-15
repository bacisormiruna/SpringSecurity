package com.example.demoM.dto;

import com.example.demoM.model.Event;
import com.example.demoM.model.Tag;
import jakarta.validation.constraints.NotNull;

public class EventTagDto {
    @NotNull
    private Event event;
    @NotNull
    private Tag tag;

    public EventTagDto() {
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}

