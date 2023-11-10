package com.github.hugovallada.sagaevent.handler;

import com.github.hugovallada.sagaevent.dto.ResponseDTO;
import com.github.hugovallada.sagaevent.entity.Event;
import com.github.hugovallada.sagaevent.errors.GetDocumentException;
import com.github.hugovallada.sagaevent.ports.out.Cache;
import com.github.hugovallada.sagaevent.ports.out.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CreateProposalEventHandler {

    @Autowired
    private Document doc;

    @Autowired
    private Cache cache;

    public void execute(String message, Event event) {
        execHandler(message, event);
    }

    private void execHandler(String message, Event event) {
        if (event == Event.END) {
            System.out.println("Fluxo FINALIZADO");
            return;
        }


        ResponseDTO<Event, String, GetDocumentException> messages = switch (event) {
            case INITIAL -> {
                System.out.println("Caso inicial");
                yield new ResponseDTO(event.next(), "Initial1", null);
            }
            case DOCUMENT -> {
                System.out.println("Caso document");
                final var documentRespsonse = doc.execute(message);
                if (!Objects.isNull(documentRespsonse.error())) {
                    cache.execute(message, event);
                    yield new ResponseDTO(Event.END, "", new GetDocumentException("error"));
                }
                yield new ResponseDTO<>(event.next(), "", null);
            }
            case SYMBOL -> {
                System.out.println("Caso Symbol");
                yield new ResponseDTO(event.next(), "Initial", null);
            }
            case PROPOSE -> {
                System.out.println("Caso Proposta");
                yield new ResponseDTO(event.next(), "Initial", null);
            }
            default -> {
                System.out.println("Sei la");
                yield new ResponseDTO(event.next(), "Initial", null);
            }
        };

        System.out.println(messages);

        execHandler(messages.response(), messages.event());
    }
}
