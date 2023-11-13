package com.github.hugovallada.sagaevent;

import com.github.hugovallada.sagaevent.dto.EventStatus;
import com.github.hugovallada.sagaevent.dto.Payload;
import com.github.hugovallada.sagaevent.entity.Event;
import com.github.hugovallada.sagaevent.errors.GetDocumentException;
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

    public EventStatus execute(String message, Event initialEvent) {
        if (Objects.isNull(initialEvent)) {
            initialEvent = Event.INITIAL;
        }
        try {
            handler.execute(message, initialEvent);
            return new EventStatus(201, Payload.builder()
                    .data("Sucesso")
                    .desc("Request com sucesso")
                    .build());
        } catch (GetDocumentException ex) {
            return new EventStatus(400, Payload.builder()
                    .data("Falha")
                    .desc("Chamada com falha")
                    .build());
        } catch (Exception ex) {
            return new EventStatus(500, Payload.builder()
                    .data("Falha interna")
                    .build()
            );
        }
    }
}
