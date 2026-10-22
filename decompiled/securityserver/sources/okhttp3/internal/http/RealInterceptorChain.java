package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class RealInterceptorChain implements Interceptor.Chain {

    @NotNull
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;

    @Nullable
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;

    @NotNull
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(@NotNull RealCall r2, @NotNull List<? extends Interceptor> r3, int r4, @Nullable Exchange r5, @NotNull Request r6, int r7, int r8, int r9) {
        Intrinsics.f(r2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r3, "interceptors");
        Intrinsics.f(r6, "request");
        this.call = r2;
        this.interceptors = r3;
        this.index = r4;
        this.exchange = r5;
        this.request = r6;
        this.connectTimeoutMillis = r7;
        this.readTimeoutMillis = r8;
        this.writeTimeoutMillis = r9;
    }

    public static /* synthetic */ RealInterceptorChain copy$okhttp$default(RealInterceptorChain r4, int r5, Exchange r6, Request r7, int r8, int r9, int r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.index;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.exchange;
    L8:
        Exchange r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.request;
    L11:
        Request r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.connectTimeoutMillis;
    L14:
        int r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.readTimeoutMillis;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.writeTimeoutMillis;
    L20:
        int r14 = r5;
        return r4.copy$okhttp(r14, r13, r0, r1, r2, r10);
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @Nullable
    public Connection connection() {
        Exchange r0 = this.exchange;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getConnection$okhttp();
    }

    @NotNull
    public final RealInterceptorChain copy$okhttp(int r12, @Nullable Exchange r13, @NotNull Request r14, int r15, int r16, int r17) {
        Intrinsics.f(r14, "request");
        return new RealInterceptorChain(this.call, this.interceptors, r12, r13, r14, r15, r16, r17);
    }

    @NotNull
    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    @Nullable
    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    @NotNull
    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Response proceed(@NotNull Request r15) {
        Intrinsics.f(r15, "request");
        boolean r2 = false;
        if (this.index >= this.interceptors.size()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L46;
        this.calls++;
        Exchange r1 = this.exchange;
        if (r1 != null) goto L10;
    L21:
        RealInterceptorChain r16 = copy$okhttp$default(this, this.index + 1, null, r15, 0, 0, 0, 58, null);
        Interceptor r3 = this.interceptors.get(this.index);
        Response r5 = r3.intercept(r16);
        if (r5 == null) goto L44;
        if (this.exchange == null) goto L37;
        if ((this.index + 1) < this.interceptors.size()) goto L28;
    L31:
        boolean r14 = true;
    L32:
        if (r14 == true) goto L37;
        throw new IllegalStateException(("network interceptor " + r3 + " must call proceed() exactly once").toString());
    L28:
        if (r16.calls == 1) goto L31;
        r14 = false;
    L37:
        if (r5.body() == null) goto L39;
        r2 = true;
    L39:
        if (r2 == false) goto L42;
        return r5;
    L42:
        throw new IllegalStateException(("interceptor " + r3 + " returned a response with no body").toString());
    L44:
        throw new NullPointerException("interceptor " + r3 + " returned null");
    L10:
        if (r1.getFinder$okhttp().sameHostAndPort(r15.url()) == false) goto L20;
        if (this.calls != 1) goto L14;
        boolean r4 = true;
    L15:
        if (r4 == true) goto L21;
        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must call proceed() exactly once").toString());
    L14:
        r4 = false;
        goto L15
    L20:
        throw new IllegalStateException(("network interceptor " + this.interceptors.get(this.index - 1) + " must retain the same host and port").toString());
    L46:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withConnectTimeout(int r13, @NotNull TimeUnit r14) {
        Intrinsics.f(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", r13, r14), 0, 0, 55, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withReadTimeout(int r13, @NotNull TimeUnit r14) {
        Intrinsics.f(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", r13, r14), 0, 47, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    @NotNull
    public Interceptor.Chain withWriteTimeout(int r13, @NotNull TimeUnit r14) {
        Intrinsics.f(r14, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", r13, r14), 31, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    public int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }
}
