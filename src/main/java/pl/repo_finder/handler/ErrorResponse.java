package pl.repo_finder.handler;

public record ErrorResponse (
        int status,
        String message
) {}
