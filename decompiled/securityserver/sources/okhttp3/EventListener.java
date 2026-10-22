package okhttp3;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class EventListener {
    public static final Companion Companion = null;

    @JvmField
    @NotNull
    public static final EventListener NONE = null;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata
    public interface Factory {
        @NotNull
        EventListener create(@NotNull Call r1);
    }

    static {
        Companion = new Companion(null);
        NONE = new EventListener$Companion$NONE$1();
    }

    public EventListener() {
    }

    public void cacheConditionalHit(@NotNull Call r1, @NotNull Response r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "cachedResponse");
    }

    public void cacheHit(@NotNull Call r1, @NotNull Response r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void cacheMiss(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void callEnd(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(@NotNull Call r1, @NotNull IOException r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "ioe");
    }

    public void callStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void canceled(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(@NotNull Call r1, @NotNull InetSocketAddress r2, @NotNull Proxy r3, @Nullable Protocol r4) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "inetSocketAddress");
        Intrinsics.f(r3, "proxy");
    }

    public void connectFailed(@NotNull Call r1, @NotNull InetSocketAddress r2, @NotNull Proxy r3, @Nullable Protocol r4, @NotNull IOException r5) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "inetSocketAddress");
        Intrinsics.f(r3, "proxy");
        Intrinsics.f(r5, "ioe");
    }

    public void connectStart(@NotNull Call r1, @NotNull InetSocketAddress r2, @NotNull Proxy r3) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "inetSocketAddress");
        Intrinsics.f(r3, "proxy");
    }

    public void connectionAcquired(@NotNull Call r1, @NotNull Connection r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, WsConstants.KEY_CONNECTION);
    }

    public void connectionReleased(@NotNull Call r1, @NotNull Connection r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, WsConstants.KEY_CONNECTION);
    }

    public void dnsEnd(@NotNull Call r1, @NotNull String r2, @NotNull List<InetAddress> r3) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "domainName");
        Intrinsics.f(r3, "inetAddressList");
    }

    public void dnsStart(@NotNull Call r1, @NotNull String r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "domainName");
    }

    public void proxySelectEnd(@NotNull Call r1, @NotNull HttpUrl r2, @NotNull List<Proxy> r3) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "url");
        Intrinsics.f(r3, "proxies");
    }

    public void proxySelectStart(@NotNull Call r1, @NotNull HttpUrl r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "url");
    }

    public void requestBodyEnd(@NotNull Call r1, long r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(@NotNull Call r1, @NotNull IOException r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "ioe");
    }

    public void requestHeadersEnd(@NotNull Call r1, @NotNull Request r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "request");
    }

    public void requestHeadersStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(@NotNull Call r1, long r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(@NotNull Call r1, @NotNull IOException r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, "ioe");
    }

    public void responseHeadersEnd(@NotNull Call r1, @NotNull Response r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void responseHeadersStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void satisfactionFailure(@NotNull Call r1, @NotNull Response r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.f(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void secureConnectEnd(@NotNull Call r1, @Nullable Handshake r2) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(@NotNull Call r1) {
        Intrinsics.f(r1, NotificationCompat.CATEGORY_CALL);
    }
}
