package com.github.hugovallada.sagaevent.ports.in;

import com.github.hugovallada.sagaevent.dto.Payload;
import com.github.hugovallada.sagaevent.entity.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@RequiredArgsConstructor
public class Controller {
    
    private final CreateProposalUseCase createProposalUseCase;

    @GetMapping
    ResponseEntity<Payload> startFluxo() {
        var response = createProposalUseCase.execute("ola", Event.DOCUMENT);
        return ResponseEntity.status(response.statusCode()).body(response.message());
    }

}
