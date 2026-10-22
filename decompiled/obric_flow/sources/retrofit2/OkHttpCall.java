package retrofit2;

import f4.b;
import java.io.IOException;
import java.util.Objects;
import nu.f0;
import nu.l;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.h0;
import okhttp3.i;
import okhttp3.r0;
import okhttp3.s0;
import okhttp3.w0;

/* JADX INFO: loaded from: classes3.dex */
final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final i callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private okhttp3.Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<w0, T> responseConverter;

    public static final class ExceptionCatchingResponseBody extends w0 {
        private final w0 delegate;
        private final l delegateSource;
        IOException thrownException;

        public ExceptionCatchingResponseBody(w0 r5) {
            this.delegate = r5;
            final l r10 = r5.source();
            this.delegateSource = b.e(new AnonymousClass1(this, r10));
        }

        @Override // okhttp3.w0, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.w0
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.w0
        public h0 contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.w0
        public l source() {
            return this.delegateSource;
        }

        public void throwIfCaught() throws IOException {
            IOException r5 = this.thrownException;
            if (r5 != null) goto L5;
            return;
        L5:
            throw r5;
        }
    }

    public static final class NoContentResponseBody extends w0 {
        private final long contentLength;
        private final h0 contentType;

        public NoContentResponseBody(h0 r5, long r10) {
            this.contentType = r5;
            this.contentLength = r10;
        }

        @Override // okhttp3.w0
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.w0
        public h0 contentType() {
            return this.contentType;
        }

        @Override // okhttp3.w0
        public l source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory r5, Object[] r10, i r11, Converter<w0, T> r12) {
        this.requestFactory = r5;
        this.args = r10;
        this.callFactory = r11;
        this.responseConverter = r12;
    }

    private okhttp3.Call createRawCall() throws IOException {
        i r5 = this.callFactory;
        OkHttpClient r10 = (OkHttpClient) r5;
        return r10.a(this.requestFactory.create(this.args));
    }

    private okhttp3.Call getRawCall() throws IOException {
        okhttp3.Call r5 = this.rawCall;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Throwable r10 = this.creationFailure;
        if (r10 != null) goto L8;
        okhttp3.Call r11 = createRawCall();     // Catch: Throwable -> L19
        this.rawCall = r11;     // Catch: Throwable -> L19
        return r11;
    L19:
        e = move-exception;
        Utils.throwIfFatal(e);
        this.creationFailure = e;
        throw e;
    L8:
        if ((r10 instanceof IOException) == true) goto L16;
        if ((r10 instanceof RuntimeException) == false) goto L14;
        throw ((RuntimeException) r10);
    L14:
        throw ((Error) r10);
    L16:
        throw ((IOException) r10);
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.canceled = true;
        monitor-enter(this);
        okhttp3.Call r5 = this.rawCall;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        if (r5 == null) goto L14;
        r5.cancel();
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        return mo1704clone();
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> r5) {
        Objects.requireNonNull(r5, "callback == null");
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.executed == true) goto L25;
        this.executed = true;     // Catch: Throwable -> L13
        okhttp3.Call r10 = this.rawCall;     // Catch: Throwable -> L13
        Throwable th2 = this.creationFailure;     // Catch: Throwable -> L13
        if (r10 != null) goto L15;
        if (th2 != null) goto L15;
        okhttp3.Call r11 = createRawCall();     // Catch: Throwable -> L11
        this.rawCall = r11;     // Catch: Throwable -> L11
        r10 = r11;
        goto L15
    L11:
        th2 = th;
        Utils.throwIfFatal(th2);     // Catch: Throwable -> L13
        this.creationFailure = th2;     // Catch: Throwable -> L13
    L15:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (th2 == null) goto L20;
        r5.onFailure(this, th2);
        return;
    L20:
        if (this.canceled == false) goto L22;
        r10.cancel();
    L22:
        r10.enqueue(new AnonymousClass1(this, r5));
        return;
    L25:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L13
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.executed == true) goto L15;
        this.executed = true;     // Catch: Throwable -> L12
        okhttp3.Call r5 = getRawCall();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (this.canceled == false) goto L11;
        r5.cancel();
    L11:
        return parseResponse(r5.execute());
    L15:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L12
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean r5 = true;
        if (this.canceled == false) goto L5;
        return true;
    L5:
        monitor-enter(this);
        okhttp3.Call r10 = this.rawCall;     // Catch: Throwable -> L11
        if (r10 != null) goto L9;
    L13:
        r5 = false;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r5;
    L9:
        if (r10.isCanceled() == false) goto L13;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r5 = this.executed;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public Response<T> parseResponse(s0 r10) throws IOException {
        w0 r5 = r10.f20748h;
        r0 r11 = r10.f();
        r11.g = new NoContentResponseBody(r5.contentType(), r5.contentLength());
        s0 r12 = r11.a();
        int r13 = r12.e;
        if (r13 >= 200) goto L5;
    L26:
        Response<T> r14 = Response.error(Utils.buffer(r5), r12);     // Catch: Throwable -> L23
        r5.close();
        return r14;
    L23:
        th = move-exception;
        r5.close();
        throw th;
    L5:
        if (r13 >= 300) goto L26;
        if (r13 != 204) goto L10;
    L18:
        r5.close();
        return Response.success(null, r12);
    L10:
        if (r13 == 205) goto L18;
        ExceptionCatchingResponseBody r15 = new ExceptionCatchingResponseBody(r5);
        return Response.success(this.responseConverter.convert(r15), r12);
    L15:
        e = move-exception;
        r15.throwIfCaught();
        throw e;
    }

    @Override // retrofit2.Call
    public synchronized Request request() {
        monitor-enter(this);
        Request r5 = getRawCall().request();     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);     // Catch: Throwable -> L6
    }

    @Override // retrofit2.Call
    public synchronized f0 timeout() {
        monitor-enter(this);
        f0 r5 = getRawCall().timeout();     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    L8:
        e = move-exception;
        throw new RuntimeException("Unable to create call.", e);     // Catch: Throwable -> L6
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Call mo1704clone() {
        return mo1704clone();
    }

    @Override // retrofit2.Call
    /* JADX INFO: renamed from: clone */
    public OkHttpCall<T> mo1704clone() {
        return new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
