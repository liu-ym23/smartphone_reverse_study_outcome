package retrofit2.adapter.rxjava2;

import retrofit2.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class Result<T> {
    private final Throwable error;
    private final Response<T> response;

    private Result(Response<T> r5, Throwable r10) {
        this.response = r5;
        this.error = r10;
    }

    public static <T> Result<T> error(Throwable r5) {
        if (r5 == null) goto L6;
        return new Result(null, r5);
    L6:
        throw new NullPointerException("error == null");
    }

    public static <T> Result<T> response(Response<T> r5) {
        if (r5 == null) goto L6;
        return new Result(r5, null);
    L6:
        throw new NullPointerException("response == null");
    }

    public boolean isError() {
        if (this.error == null) goto L5;
        return true;
    L5:
        return false;
    }

    public Throwable error() {
        return this.error;
    }

    public Response<T> response() {
        return this.response;
    }
}
