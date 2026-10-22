package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum Protocol extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES = null;
    public static final Companion Companion = null;
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;

    @Deprecated
    public static final Protocol SPDY_3 = null;
    private final String protocol;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String r2) {
            Intrinsics.f(r2, "protocol");
            Protocol r1 = Protocol.HTTP_1_0;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            r1 = Protocol.HTTP_1_1;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            r1 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            r1 = Protocol.HTTP_2;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            r1 = Protocol.SPDY_3;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            r1 = Protocol.QUIC;
            if (r2.equals(Protocol.access$getProtocol$p(r1)) == true) goto L19;
            throw new IOException("Unexpected protocol: ".concat(r2));
        L19:
            return r1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Protocol r0 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_0 = r0;
        Protocol r1 = new Protocol("HTTP_1_1", 1, "http/1.1");
        HTTP_1_1 = r1;
        Protocol r2 = new Protocol("SPDY_3", 2, "spdy/3.1");
        SPDY_3 = r2;
        Protocol r3 = new Protocol("HTTP_2", 3, "h2");
        HTTP_2 = r3;
        Protocol r4 = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        H2_PRIOR_KNOWLEDGE = r4;
        Protocol r5 = new Protocol("QUIC", 5, "quic");
        QUIC = r5;
        $VALUES = new Protocol[]{r0, r1, r2, r3, r4, r5};
        Companion = new Companion(null);
    }

    private Protocol(String r1, int r2, String r3) {
        super(r1, r2);
        this.protocol = r3;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol r0) {
        return r0.protocol;
    }

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String r1) {
        return Companion.get(r1);
    }

    public static Protocol valueOf(String r1) {
        return (Protocol) Enum.valueOf(Protocol.class, r1);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.protocol;
    }
}
