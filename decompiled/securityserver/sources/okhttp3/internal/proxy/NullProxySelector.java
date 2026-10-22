package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class NullProxySelector extends ProxySelector {
    public static final NullProxySelector INSTANCE = null;

    static {
        INSTANCE = new NullProxySelector();
    }

    private NullProxySelector() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(@Nullable URI r1, @Nullable SocketAddress r2, @Nullable IOException r3) {
    }

    @Override // java.net.ProxySelector
    @NotNull
    public List<Proxy> select(@Nullable URI r1) {
        if (r1 == null) goto L6;
        return CollectionsKt.j(Proxy.NO_PROXY);
    L6:
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
