package com.github.hugovallada.sagaevent.ports.in;

import com.github.hugovallada.sagaevent.dto.EventStatus;
import com.github.hugovallada.sagaevent.entity.Event;

public interface CreateProposalUseCase {
    EventStatus execute(String message, Event event);
}
