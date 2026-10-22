package okhttp3.internal.authenticator;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class JavaNetAuthenticator implements Authenticator {
    private final Dns defaultDns;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Proxy.Type.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Proxy.Type.DIRECT.ordinal()] = 1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JavaNetAuthenticator() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final InetAddress connectToInetAddress(Proxy r2, HttpUrl r3, Dns r4) {
        Proxy.Type r1 = r2.type();
        if (r1 != null) goto L6;
    L7:
        SocketAddress r5 = r2.address();
        if (r5 == null) goto L11;
        InetAddress r6 = ((InetSocketAddress) r5).getAddress();
        Intrinsics.e(r6, "(address() as InetSocketAddress).address");
        return r6;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L6:
        if (WhenMappings.$EnumSwitchMapping$0[r1.ordinal()] != 1) goto L7;
        List<InetAddress> r7 = r4.lookup(r3.host());
        Intrinsics.f(r7, "<this>");
        if (r7.isEmpty() == true) goto L17;
        return r7.get(0);
    L17:
        throw new NoSuchElementException("List is empty.");
    }

    @Override // okhttp3.Authenticator
    @Nullable
    public Request authenticate(@Nullable Route r18, @NotNull Response r19) {
        Intrinsics.f(r19, ApmTrafficStats.TTNET_RESPONSE);
        List<Challenge> r1 = r19.challenges();
        Request r3 = r19.request();
        HttpUrl r4 = r3.url();
        if (r19.code() != 407) goto L5;
        boolean r2 = true;
    L6:
        if (r18 == null) goto L10;
        Proxy r5 = r18.proxy();
        if (r5 == null) goto L10;
    L11:
        Iterator<Challenge> r6 = r1.iterator();
    L13:
        if (r6.hasNext() == false) goto L37;
        Challenge r7 = r6.next();
        if ("Basic".equalsIgnoreCase(r7.scheme()) == false) goto L13;
        if (r18 == null) goto L23;
        Address r8 = r18.address();
        if (r8 == null) goto L23;
        Dns r9 = r8.dns();
        if (r9 == null) goto L23;
    L24:
        if (r2 == false) goto L30;
        SocketAddress r10 = r5.address();
        if (r10 == null) goto L29;
        InetSocketAddress r11 = (InetSocketAddress) r10;
        PasswordAuthentication r12 = java.net.Authenticator.requestPasswordAuthentication(r11.getHostName(), connectToInetAddress(r5, r4, r9), r11.getPort(), r4.scheme(), r7.realm(), r7.scheme(), r4.url(), java.net.Authenticator.RequestorType.PROXY);
    L31:
        if (r12 == null) goto L13;
        if (r2 == false) goto L34;
        String r0 = "Proxy-Authorization";
    L35:
        String r13 = r12.getUserName();
        Intrinsics.e(r13, "auth.userName");
        char[] r14 = r12.getPassword();
        Intrinsics.e(r14, "auth.password");
        String r15 = Credentials.basic(r13, new String(r14), r7.charset());
        return r3.newBuilder().header(r0, r15).build();
    L34:
        r0 = "Authorization";
        goto L35
    L29:
        throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
    L30:
        String r16 = r4.host();
        Intrinsics.e(r5, "proxy");
        r12 = java.net.Authenticator.requestPasswordAuthentication(r16, connectToInetAddress(r5, r4, r9), r4.port(), r4.scheme(), r7.realm(), r7.scheme(), r4.url(), java.net.Authenticator.RequestorType.SERVER);
    L23:
        r9 = this.defaultDns;
        goto L24
    L37:
        return null;
    L10:
        r5 = Proxy.NO_PROXY;
        goto L11
    L5:
        r2 = false;
        goto L6
    }

    public JavaNetAuthenticator(@NotNull Dns r2) {
        Intrinsics.f(r2, "defaultDns");
        this.defaultDns = r2;
    }

    public /* synthetic */ JavaNetAuthenticator(Dns r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Dns.SYSTEM;
    L5:
        this(r1);
    }
}
