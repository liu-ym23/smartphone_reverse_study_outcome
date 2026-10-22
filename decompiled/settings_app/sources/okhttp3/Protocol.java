package okhttp3;

import java.io.IOException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Protocol.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lokhttp3/Protocol;", "", "protocol", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final enum Protocol extends Enum<Protocol> {
    private static final /* synthetic */ Protocol[] $VALUES = null;
    public static final Companion Companion = null;
    public static final Protocol H2_PRIOR_KNOWLEDGE = null;
    public static final Protocol HTTP_1_0 = null;
    public static final Protocol HTTP_1_1 = null;
    public static final Protocol HTTP_2 = null;
    public static final Protocol QUIC = null;

    @Deprecated(message = "OkHttp has dropped support for SPDY. Prefer {@link #HTTP_2}.")
    public static final Protocol SPDY_3 = null;
    private final String protocol;

    /* JADX INFO: compiled from: Protocol.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", "protocol", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Protocol get(String r2) throws IOException {
            Intrinsics.checkNotNullParameter(r2, "protocol");
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.HTTP_1_0)) == false) goto L6;
            return Protocol.HTTP_1_0;
        L6:
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.HTTP_1_1)) == false) goto L9;
            return Protocol.HTTP_1_1;
        L9:
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.H2_PRIOR_KNOWLEDGE)) == false) goto L12;
            return Protocol.H2_PRIOR_KNOWLEDGE;
        L12:
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.HTTP_2)) == false) goto L15;
            return Protocol.HTTP_2;
        L15:
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.SPDY_3)) == false) goto L18;
            return Protocol.SPDY_3;
        L18:
            if (Intrinsics.areEqual(r2, Protocol.access$getProtocol$p(Protocol.QUIC)) == false) goto L22;
            return Protocol.QUIC;
        L22:
            throw new IOException(Intrinsics.stringPlus("Unexpected protocol: ", r2));
        }
    }

    private static final /* synthetic */ Protocol[] $values() {
        return new Protocol[]{HTTP_1_0, HTTP_1_1, SPDY_3, HTTP_2, H2_PRIOR_KNOWLEDGE, QUIC};
    }

    @JvmStatic
    public static final Protocol get(String r1) throws IOException {
        return Companion.get(r1);
    }

    public static Protocol valueOf(String r1) {
        return (Protocol) Enum.valueOf(Protocol.class, r1);
    }

    public static Protocol[] values() {
        return (Protocol[]) $VALUES.clone();
    }

    private Protocol(String r1, int r2, String r3) {
        super(r1, r2);
        this.protocol = r3;
    }

    public static final /* synthetic */ String access$getProtocol$p(Protocol r0) {
        return r0.protocol;
    }

    static {
        HTTP_1_0 = new Protocol("HTTP_1_0", 0, "http/1.0");
        HTTP_1_1 = new Protocol("HTTP_1_1", 1, "http/1.1");
        SPDY_3 = new Protocol("SPDY_3", 2, "spdy/3.1");
        HTTP_2 = new Protocol("HTTP_2", 3, "h2");
        H2_PRIOR_KNOWLEDGE = new Protocol("H2_PRIOR_KNOWLEDGE", 4, "h2_prior_knowledge");
        QUIC = new Protocol("QUIC", 5, "quic");
        $VALUES = $values();
        Companion = new Companion(null);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
