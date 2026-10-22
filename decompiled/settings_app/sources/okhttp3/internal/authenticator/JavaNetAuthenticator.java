package okhttp3.internal.authenticator;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: JavaNetAuthenticator.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "defaultDns", "Lokhttp3/Dns;", "(Lokhttp3/Dns;)V", "authenticate", "Lokhttp3/Request;", CloudControlInf.ROUTE, "Lokhttp3/Route;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "connectToInetAddress", "Ljava/net/InetAddress;", "Ljava/net/Proxy;", "url", "Lokhttp3/HttpUrl;", MultiProcessFileUtils.KEY_DNS, "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    /* JADX INFO: compiled from: JavaNetAuthenticator.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public JavaNetAuthenticator(Dns r2) {
        Intrinsics.checkNotNullParameter(r2, "defaultDns");
        this.defaultDns = r2;
    }

    public /* synthetic */ JavaNetAuthenticator(Dns r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Dns.SYSTEM;
    L5:
        this(r1);
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route r21, Response r22) throws IOException {
        Intrinsics.checkNotNullParameter(r22, ApmTrafficStats.TTNET_RESPONSE);
        List<Challenge> r1 = r22.challenges();
        Request r3 = r22.request();
        HttpUrl r4 = r3.url();
        if (r22.code() != 407) goto L5;
        boolean r2 = true;
    L7:
        if (r21 != null) goto L9;
        Proxy r7 = null;
    L10:
        if (r7 != null) goto L12;
        r7 = Proxy.NO_PROXY;
    L12:
        Iterator<Challenge> r5 = r1.iterator();
    L14:
        if (r5.hasNext() == false) goto L40;
        Challenge r8 = r5.next();
        if (StringsKt.equals("Basic", r8.scheme(), true) == false) goto L14;
        if (r21 != null) goto L20;
    L19:
        Dns r9 = null;
    L24:
        if (r9 != null) goto L27;
        r9 = this.defaultDns;
    L27:
        if (r2 == false) goto L33;
        SocketAddress r11 = r7.address();
        if (r11 == null) goto L32;
        InetSocketAddress r12 = (InetSocketAddress) r11;
        String r13 = r12.getHostName();
        Intrinsics.checkNotNullExpressionValue(r7, "proxy");
        PasswordAuthentication r10 = java.net.Authenticator.requestPasswordAuthentication(r13, connectToInetAddress(r7, r4, r9), r12.getPort(), r4.scheme(), r8.realm(), r8.scheme(), r4.url(), java.net.Authenticator.RequestorType.PROXY);
    L34:
        if (r10 == null) goto L14;
        if (r2 == false) goto L37;
        String r0 = "Proxy-Authorization";
    L38:
        String r6 = r10.getUserName();
        Intrinsics.checkNotNullExpressionValue(r6, "auth.userName");
        char[] r14 = r10.getPassword();
        Intrinsics.checkNotNullExpressionValue(r14, "auth.password");
        return r3.newBuilder().header(r0, Credentials.basic(r6, new String(r14), r8.charset())).build();
    L37:
        r0 = "Authorization";
        goto L38
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L33:
        String r15 = r4.host();
        Intrinsics.checkNotNullExpressionValue(r7, "proxy");
        r10 = java.net.Authenticator.requestPasswordAuthentication(r15, connectToInetAddress(r7, r4, r9), r4.port(), r4.scheme(), r8.realm(), r8.scheme(), r4.url(), java.net.Authenticator.RequestorType.SERVER);
        goto L34
    L20:
        Address r16 = r21.address();
        if (r16 == null) goto L19;
        r9 = r16.dns();
        goto L24
    L40:
        return null;
    L9:
        r7 = r21.proxy();
        goto L10
    L5:
        r2 = false;
        goto L7
    }

    private final InetAddress connectToInetAddress(Proxy r2, HttpUrl r3, Dns r4) throws IOException {
        Proxy.Type r1 = r2.type();
        if (r1 != null) goto L5;
        int r5 = -1;
    L7:
        if (r5 == 1) goto L15;
        SocketAddress r6 = r2.address();
        if (r6 == null) goto L14;
        InetAddress r7 = ((InetSocketAddress) r6).getAddress();
        Intrinsics.checkNotNullExpressionValue(r7, "address() as InetSocketAddress).address");
        return r7;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L15:
        return (InetAddress) CollectionsKt.first(r4.lookup(r3.host()));
    L5:
        r5 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        goto L7
    }
}
