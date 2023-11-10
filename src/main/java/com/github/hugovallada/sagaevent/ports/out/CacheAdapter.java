package com.github.hugovallada.sagaevent.ports.out;

import com.github.hugovallada.sagaevent.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class CacheAdapter implements Cache {
    @Override
    public void execute(String message, Event event) {
        System.out.println("Chamando cache");
    }
}
