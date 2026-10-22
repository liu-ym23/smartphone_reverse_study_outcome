package retrofit2;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public HttpException(Response<?> r5) {
        super(getMessage(r5));
        this.code = r5.code();
        this.message = r5.message();
        this.response = r5;
    }

    private static String getMessage(Response<?> r5) {
        Objects.requireNonNull(r5, "response == null");
        return "HTTP " + r5.code() + " " + r5.message();
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response<?> response() {
        return this.response;
    }
}
