package retrofit2;

import ai.j0;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.c0;
import okhttp3.n0;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
public final class Response<T> {
    private final T body;
    private final w0 errorBody;
    private final s0 rawResponse;

    private Response(s0 r5, T r10, w0 r11) {
        this.rawResponse = r5;
        this.body = r10;
        this.errorBody = r11;
    }

    public static <T> Response<T> error(int r5, w0 r10) {
        Objects.requireNonNull(r10, "body == null");
        if (r5 < 400) goto L7;
        r0 r11 = new r0();
        r11.g = new OkHttpCall.NoContentResponseBody(r10.contentType(), r10.contentLength());
        r11.f20737c = r5;
        Intrinsics.checkNotNullParameter("Response.error()", "message");
        r11.d = "Response.error()";
        r11.d(Protocol.HTTP_1_1);
        n0 r12 = new n0();
        r12.g("http://localhost/");
        Request r13 = r12.b();
        Intrinsics.checkNotNullParameter(r13, "request");
        r11.f20735a = r13;
        return error(r10, r11.a());
    L7:
        throw new IllegalArgumentException(j0.g(r5, "code < 400: "));
    }

    public static <T> Response<T> success(T r5) {
        r0 r10 = new r0();
        r10.f20737c = 200;
        Intrinsics.checkNotNullParameter("OK", "message");
        r10.d = "OK";
        r10.d(Protocol.HTTP_1_1);
        n0 r11 = new n0();
        r11.g("http://localhost/");
        Request r12 = r11.b();
        Intrinsics.checkNotNullParameter(r12, "request");
        r10.f20735a = r12;
        return success(r5, r10.a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.e;
    }

    public w0 errorBody() {
        return this.errorBody;
    }

    public c0 headers() {
        return this.rawResponse.g;
    }

    public boolean isSuccessful() {
        return this.rawResponse.e();
    }

    public String message() {
        return this.rawResponse.d;
    }

    public s0 raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }

    public static <T> Response<T> success(int r5, T r10) {
        if (r5 < 200) goto L9;
        if (r5 >= 300) goto L9;
        r0 r11 = new r0();
        r11.f20737c = r5;
        Intrinsics.checkNotNullParameter("Response.success()", "message");
        r11.d = "Response.success()";
        r11.d(Protocol.HTTP_1_1);
        n0 r12 = new n0();
        r12.g("http://localhost/");
        Request r13 = r12.b();
        Intrinsics.checkNotNullParameter(r13, "request");
        r11.f20735a = r13;
        return success(r10, r11.a());
    L9:
        throw new IllegalArgumentException(j0.g(r5, "code < 200 or >= 300: "));
    }

    public static <T> Response<T> error(w0 r5, s0 r10) {
        Objects.requireNonNull(r5, "body == null");
        Objects.requireNonNull(r10, "rawResponse == null");
        if (r10.e() == true) goto L7;
        return new Response(r10, null, r5);
    L7:
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(T r5, c0 r10) {
        Objects.requireNonNull(r10, "headers == null");
        r0 r11 = new r0();
        r11.f20737c = 200;
        Intrinsics.checkNotNullParameter("OK", "message");
        r11.d = "OK";
        r11.d(Protocol.HTTP_1_1);
        r11.c(r10);
        n0 r12 = new n0();
        r12.g("http://localhost/");
        Request r13 = r12.b();
        Intrinsics.checkNotNullParameter(r13, "request");
        r11.f20735a = r13;
        return success(r5, r11.a());
    }

    public static <T> Response<T> success(T r5, s0 r10) {
        Objects.requireNonNull(r10, "rawResponse == null");
        if (r10.e() == false) goto L7;
        return new Response(r10, r5, null);
    L7:
        throw new IllegalArgumentException("rawResponse must be successful response");
    }
}
