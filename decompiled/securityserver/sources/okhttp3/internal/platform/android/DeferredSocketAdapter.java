package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class DeferredSocketAdapter implements SocketAdapter {
    private SocketAdapter delegate;
    private final Factory socketAdapterFactory;

    @Metadata
    public interface Factory {
        @NotNull
        SocketAdapter create(@NotNull SSLSocket r1);

        boolean matchesSocket(@NotNull SSLSocket r1);
    }

    public DeferredSocketAdapter(@NotNull Factory r2) {
        Intrinsics.f(r2, "socketAdapterFactory");
        this.socketAdapterFactory = r2;
    }

    private final synchronized SocketAdapter getDelegate(SSLSocket r2) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.delegate == null) goto L6;
    L10:
        SocketAdapter r3 = this.delegate;     // Catch: Throwable -> L8
        monitor-exit(this);
        return r3;
    L6:
        if (this.socketAdapterFactory.matchesSocket(r2) == false) goto L10;
        this.delegate = this.socketAdapterFactory.create(r2);     // Catch: Throwable -> L8
        goto L10
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public void configureTlsExtensions(@NotNull SSLSocket r2, @Nullable String r3, @NotNull List<? extends Protocol> r4) {
        Intrinsics.f(r2, "sslSocket");
        Intrinsics.f(r4, "protocols");
        SocketAdapter r1 = getDelegate(r2);
        if (r1 == null) goto L6;
        r1.configureTlsExtensions(r2, r3, r4);
        return;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public String getSelectedProtocol(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        SocketAdapter r1 = getDelegate(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getSelectedProtocol(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return true;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(@NotNull SSLSocket r2) {
        Intrinsics.f(r2, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, r2);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    @Nullable
    public X509TrustManager trustManager(@NotNull SSLSocketFactory r2) {
        Intrinsics.f(r2, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, r2);
    }
}
