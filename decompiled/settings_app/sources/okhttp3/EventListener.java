package okhttp3;

import androidx.core.app.NotificationCompat;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.capabilitykit.common.Ext;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EventListener.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J*\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J2\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J+\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!2\u0011\u0010\"\u001a\r\u0012\t\u0012\u00070$¢\u0006\u0002\b%0#H\u0016J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!H\u0016J+\u0010'\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0011\u0010*\u001a\r\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b%0#H\u0016J\u0018\u0010+\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010,\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00100\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00101\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u00102\u001a\u000203H\u0016J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u00106\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u00107\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u00108\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010:\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010;\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006A"}, d2 = {"Lokhttp3/EventListener;", "", "()V", "cacheConditionalHit", "", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "cachedResponse", "Lokhttp3/Response;", "cacheHit", ApmTrafficStats.TTNET_RESPONSE, "cacheMiss", "callEnd", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", WsConstants.KEY_CONNECTION, "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "Lkotlin/jvm/JvmSuppressWildcards;", "dnsStart", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestFailed", "requestHeadersEnd", Ext.KEY_REQUEST, "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "responseHeadersStart", "satisfactionFailure", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class EventListener {
    public static final Companion Companion = null;
    public static final EventListener NONE = null;

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lokhttp3/EventListener$Companion;", "", "()V", "NONE", "Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: EventListener.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lokhttp3/EventListener$Factory;", "", "create", "Lokhttp3/EventListener;", NotificationCompat.CATEGORY_CALL, "Lokhttp3/Call;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Factory {
        EventListener create(Call r1);
    }

    public void cacheConditionalHit(Call r1, Response r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "cachedResponse");
    }

    public void cacheHit(Call r1, Response r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void cacheMiss(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void callEnd(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void callFailed(Call r1, IOException r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "ioe");
    }

    public void callStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void canceled(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void connectEnd(Call r1, InetSocketAddress r2, Proxy r3, Protocol r4) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r3, "proxy");
    }

    public void connectFailed(Call r1, InetSocketAddress r2, Proxy r3, Protocol r4, IOException r5) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r3, "proxy");
        Intrinsics.checkNotNullParameter(r5, "ioe");
    }

    public void connectStart(Call r1, InetSocketAddress r2, Proxy r3) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "inetSocketAddress");
        Intrinsics.checkNotNullParameter(r3, "proxy");
    }

    public void connectionAcquired(Call r1, Connection r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, WsConstants.KEY_CONNECTION);
    }

    public void connectionReleased(Call r1, Connection r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, WsConstants.KEY_CONNECTION);
    }

    public void dnsEnd(Call r1, String r2, List<InetAddress> r3) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "domainName");
        Intrinsics.checkNotNullParameter(r3, "inetAddressList");
    }

    public void dnsStart(Call r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "domainName");
    }

    public void proxySelectEnd(Call r1, HttpUrl r2, List<Proxy> r3) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "proxies");
    }

    public void proxySelectStart(Call r1, HttpUrl r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "url");
    }

    public void requestBodyEnd(Call r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void requestBodyStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void requestFailed(Call r1, IOException r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "ioe");
    }

    public void requestHeadersEnd(Call r1, Request r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, Ext.KEY_REQUEST);
    }

    public void requestHeadersStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyEnd(Call r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseBodyStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void responseFailed(Call r1, IOException r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, "ioe");
    }

    public void responseHeadersEnd(Call r1, Response r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void responseHeadersStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void satisfactionFailure(Call r1, Response r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(r2, ApmTrafficStats.TTNET_RESPONSE);
    }

    public void secureConnectEnd(Call r1, Handshake r2) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public void secureConnectStart(Call r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_CALL);
    }

    public EventListener() {
    }

    static {
        Companion = new Companion(null);
        NONE = new EventListener$Companion$NONE$1();
    }
}
