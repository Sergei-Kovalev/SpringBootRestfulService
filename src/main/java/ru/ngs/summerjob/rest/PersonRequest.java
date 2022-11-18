package ru.ngs.summerjob.rest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record PersonRequest(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        @Min(1)
        Integer age
) {
}
