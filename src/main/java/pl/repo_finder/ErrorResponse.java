package pl.repo_finder;

public record ErrorResponse (
        int status,
        String message
) {}
