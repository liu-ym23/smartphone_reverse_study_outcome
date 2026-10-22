package okhttp3.internal.http;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class StatusLine {
    public static final Companion Companion = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;

    @JvmField
    public final int code;

    @JvmField
    @NotNull
    public final String message;

    @JvmField
    @NotNull
    public final Protocol protocol;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final StatusLine get(@NotNull Response r3) {
            Intrinsics.f(r3, ApmTrafficStats.TTNET_RESPONSE);
            return new StatusLine(r3.protocol(), r3.code(), r3.message());
        }

        @NotNull
        public final StatusLine parse(@NotNull String r8) {
            Intrinsics.f(r8, "statusLine");
            if (StringsKt.F(r8, "HTTP/1.", false) == false) goto L19;
            int r0 = 9;
            if (r8.length() < 9) goto L17;
            if (r8.charAt(8) != ' ') goto L17;
            int r7 = r8.charAt(7) - '0';
            if (r7 != 0) goto L12;
            Protocol r9 = Protocol.HTTP_1_0;
        L21:
            int r5 = r0 + 3;
            if (r8.length() < r5) goto L37;
            String r4 = r8.substring(r0, r5);     // Catch: NumberFormatException -> L34
            Intrinsics.e(r4, "(this as java.lang.Strin…ing(startIndex, endIndex)");     // Catch: NumberFormatException -> L34
            int r6 = Integer.parseInt(r4);     // Catch: NumberFormatException -> L34
            if (r8.length() > r5) goto L27;
            String r10 = "";
        L33:
            return new StatusLine(r9, r6, r10);
        L27:
            if (r8.charAt(r5) != ' ') goto L30;
            r10 = r8.substring(r0 + 4);
            Intrinsics.e(r10, "(this as java.lang.String).substring(startIndex)");
            goto L33
        L30:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        L35:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        L37:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        L12:
            if (r7 != 1) goto L15;
            r9 = Protocol.HTTP_1_1;
            goto L21
        L15:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        L17:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        L19:
            if (StringsKt.F(r8, "ICY ", false) == false) goto L39;
            r9 = Protocol.HTTP_1_0;
            r0 = 4;
            goto L21
        L39:
            throw new ProtocolException("Unexpected status line: ".concat(r8));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StatusLine(@NotNull Protocol r2, int r3, @NotNull String r4) {
        Intrinsics.f(r2, "protocol");
        Intrinsics.f(r4, "message");
        this.protocol = r2;
        this.code = r3;
        this.message = r4;
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        r0.append("HTTP/1.0");
    L6:
        r0.append(' ');
        r0.append(this.code);
        r0.append(' ');
        r0.append(this.message);
        String r3 = r0.toString();
        Intrinsics.e(r3, "StringBuilder().apply(builderAction).toString()");
        return r3;
    L5:
        r0.append("HTTP/1.1");
        goto L6
    }
}
