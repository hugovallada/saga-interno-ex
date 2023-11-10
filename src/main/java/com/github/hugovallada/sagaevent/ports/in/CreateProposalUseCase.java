package com.github.hugovallada.sagaevent.ports.in;

import com.github.hugovallada.sagaevent.entity.Event;

public interface CreateProposalUseCase {
    void execute(String message, Event event);
}
