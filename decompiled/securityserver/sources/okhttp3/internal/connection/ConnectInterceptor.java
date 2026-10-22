package okhttp3.internal.connection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.http.RealInterceptorChain;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = null;

    static {
        INSTANCE = new ConnectInterceptor();
    }

    private ConnectInterceptor() {
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain r10) {
        Intrinsics.f(r10, "chain");
        RealInterceptorChain r11 = (RealInterceptorChain) r10;
        return RealInterceptorChain.copy$okhttp$default(r11, 0, r11.getCall$okhttp().initExchange$okhttp(r11), null, 0, 0, 0, 61, null).proceed(r11.getRequest$okhttp());
    }
}
