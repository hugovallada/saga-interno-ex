package com.github.hugovallada.sagaevent.entity;

public enum Event {
    INITIAL,
    DOCUMENT,
    SYMBOL,
    PROPOSE,
    END;

    public Event next() {
        return Event.values()[this.ordinal() + 1];
    }
}
