package com.github.hugovallada.sagaevent;

import com.github.hugovallada.sagaevent.entity.Event;
import com.github.hugovallada.sagaevent.handler.CreateProposalEventHandler;
import com.github.hugovallada.sagaevent.ports.in.CreateProposalUseCase;
import com.github.hugovallada.sagaevent.ports.out.Document;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
class CreateProposal implements CreateProposalUseCase {

    private final Document document;

    private final CreateProposalEventHandler handler;

    public CreateProposal(Document document, CreateProposalEventHandler handler) {
        this.document = document;
        this.handler = handler;
    }

    public void execute(String message, Event initialEvent) {
        if (Objects.isNull(initialEvent)) {
            initialEvent = Event.INITIAL;
        }
        handler.execute(message, initialEvent);
    }
}
