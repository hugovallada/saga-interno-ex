package com.github.hugovallada.sagaevent.ports.out;

import com.github.hugovallada.sagaevent.dto.ResponseDTO;

public interface Document {
    ResponseDTO<String, String, String> execute(String number);
}
