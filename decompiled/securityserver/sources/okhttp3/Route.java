package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Route {

    @NotNull
    private final Address address;

    @NotNull
    private final Proxy proxy;

    @NotNull
    private final InetSocketAddress socketAddress;

    public Route(@NotNull Address r2, @NotNull Proxy r3, @NotNull InetSocketAddress r4) {
        Intrinsics.f(r2, "address");
        Intrinsics.f(r3, "proxy");
        Intrinsics.f(r4, "socketAddress");
        this.address = r2;
        this.proxy = r3;
        this.socketAddress = r4;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_address, reason: not valid java name */
    public final Address m175deprecated_address() {
        return this.address;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_proxy, reason: not valid java name */
    public final Proxy m176deprecated_proxy() {
        return this.proxy;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_socketAddress, reason: not valid java name */
    public final InetSocketAddress m177deprecated_socketAddress() {
        return this.socketAddress;
    }

    @JvmName
    @NotNull
    public final Address address() {
        return this.address;
    }

    public boolean equals(@Nullable Object r3) {
        if ((r3 instanceof Route) == false) goto L11;
        Route r4 = (Route) r3;
        if (Intrinsics.a(r4.address, this.address) == false) goto L11;
        if (Intrinsics.a(r4.proxy, this.proxy) == false) goto L11;
        if (Intrinsics.a(r4.socketAddress, this.socketAddress) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public int hashCode() {
        int r0 = (this.address.hashCode() + 527) * 31;
        int r1 = (this.proxy.hashCode() + r0) * 31;
        return this.socketAddress.hashCode() + r1;
    }

    @JvmName
    @NotNull
    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        if (this.address.sslSocketFactory() != null) goto L5;
    L7:
        return false;
    L5:
        if (this.proxy.type() != Proxy.Type.HTTP) goto L7;
        return true;
    }

    @JvmName
    @NotNull
    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    @NotNull
    public String toString() {
        return "Route{" + this.socketAddress + '}';
    }
}
