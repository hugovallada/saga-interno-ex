package com.github.hugovallada.sagaevent.dto;

public record ResponseDTO<T, K, V>(T event, K response, V error) {
}
