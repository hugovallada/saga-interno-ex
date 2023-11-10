package com.github.hugovallada.sagaevent.ports.out;

import com.github.hugovallada.sagaevent.dto.ResponseDTO;
import com.github.hugovallada.sagaevent.entity.Event;
import org.springframework.stereotype.Component;

@Component
public class DocumentAdapter implements Document {
    @Override
    public ResponseDTO<String, String, String> execute(String number) {
        return new ResponseDTO<>(Event.DOCUMENT.name(), "aa", "error");
    }
}
