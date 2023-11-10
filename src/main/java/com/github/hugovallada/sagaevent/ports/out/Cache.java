package com.github.hugovallada.sagaevent.ports.out;

import com.github.hugovallada.sagaevent.entity.Event;

public interface Cache {
    void execute(String message, Event event);
}
