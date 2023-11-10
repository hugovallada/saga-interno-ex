package com.github.hugovallada.sagaevent.ports.in;

import com.github.hugovallada.sagaevent.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class Controller {

    @Autowired
    private CreateProposalUseCase createProposalUseCase;

    @GetMapping
    void startFluxo() {
        createProposalUseCase.execute("ola", Event.DOCUMENT);
    }

}
