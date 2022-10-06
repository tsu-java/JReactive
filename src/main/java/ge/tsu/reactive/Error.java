package ge.tsu.reactive;

import java.util.Objects;

public final class Error {

    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Error error = (Error) o;
        return Objects.equals(message, error.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message);
    }

    @Override
    public String toString() {
        return "Error{" +
                "message='" + message + '\'' +
                '}';
    }
}
