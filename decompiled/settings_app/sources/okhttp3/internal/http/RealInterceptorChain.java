package okhttp3.internal.http;

import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import java.io.IOException;
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
import okhttp3.internal.connection.RealConnection;

/* JADX INFO: compiled from: RealInterceptorChain.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b¢\u0006\u0002\u0010\u0010J\b\u0010\u0002\u001a\u00020\u001cH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010(\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0014\u0010\u000b\u001a\u00020\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u000f\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006)"}, d2 = {"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/internal/connection/RealCall;", "interceptors", "", "Lokhttp3/Interceptor;", "index", "", "exchange", "Lokhttp3/internal/connection/Exchange;", Ext.KEY_REQUEST, "Lokhttp3/Request;", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "calls", "getConnectTimeoutMillis$okhttp", "()I", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getReadTimeoutMillis$okhttp", "getRequest$okhttp", "()Lokhttp3/Request;", "getWriteTimeoutMillis$okhttp", "Lokhttp3/Call;", WsConstants.KEY_CONNECTION, "Lokhttp3/Connection;", "copy", "copy$okhttp", "proceed", "Lokhttp3/Response;", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RealInterceptorChain implements Interceptor.Chain {
    private final RealCall call;
    private int calls;
    private final int connectTimeoutMillis;
    private final Exchange exchange;
    private final int index;
    private final List<Interceptor> interceptors;
    private final int readTimeoutMillis;
    private final Request request;
    private final int writeTimeoutMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public RealInterceptorChain(RealCall r2, List<? extends Interceptor> r3, int r4, Exchange r5, Request r6, int r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r3, "interceptors");
        Intrinsics.checkNotNullParameter(r6, Ext.KEY_REQUEST);
        this.call = r2;
        this.interceptors = r3;
        this.index = r4;
        this.exchange = r5;
        this.request = r6;
        this.connectTimeoutMillis = r7;
        this.readTimeoutMillis = r8;
        this.writeTimeoutMillis = r9;
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final Exchange getExchange$okhttp() {
        return this.exchange;
    }

    public final Request getRequest$okhttp() {
        return this.request;
    }

    public final int getConnectTimeoutMillis$okhttp() {
        return this.connectTimeoutMillis;
    }

    public final int getReadTimeoutMillis$okhttp() {
        return this.readTimeoutMillis;
    }

    public final int getWriteTimeoutMillis$okhttp() {
        return this.writeTimeoutMillis;
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

    public final RealInterceptorChain copy$okhttp(int r12, Exchange r13, Request r14, int r15, int r16, int r17) {
        Intrinsics.checkNotNullParameter(r14, Ext.KEY_REQUEST);
        return new RealInterceptorChain(this.call, this.interceptors, r12, r13, r14, r15, r16, r17);
    }

    @Override // okhttp3.Interceptor.Chain
    public Connection connection() {
        Exchange r0 = this.exchange;
        if (r0 != null) goto L5;
        RealConnection r1 = null;
    L7:
        return r1;
    L5:
        r1 = r0.getConnection$okhttp();
        goto L7
    }

    @Override // okhttp3.Interceptor.Chain
    public int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withConnectTimeout(int r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", r11, r12), 0, 0, 55, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    public int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withReadTimeout(int r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", r11, r12), 0, 47, null);
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

    @Override // okhttp3.Interceptor.Chain
    public Interceptor.Chain withWriteTimeout(int r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "unit");
        if (this.exchange != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", r11, r12), 31, null);
    L10:
        throw new IllegalStateException("Timeouts can't be adjusted in a network interceptor".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // okhttp3.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // okhttp3.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // okhttp3.Interceptor.Chain
    public Response proceed(Request r15) throws IOException {
        Intrinsics.checkNotNullParameter(r15, Ext.KEY_REQUEST);
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
}
