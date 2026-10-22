package okhttp3.internal.http;

import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import cz.msebera.android.httpclient.message.TokenParser;
import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: compiled from: StatusLine.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/http/StatusLine;", "", "protocol", "Lokhttp3/Protocol;", AlogMonitor.ALOG_RESULT_CODE, "", "message", "", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StatusLine {
    public static final Companion Companion = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    /* JADX INFO: compiled from: StatusLine.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "()V", "HTTP_CONTINUE", "", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "get", "Lokhttp3/internal/http/StatusLine;", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "parse", "statusLine", "", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final StatusLine get(Response r3) {
            Intrinsics.checkNotNullParameter(r3, ApmTrafficStats.TTNET_RESPONSE);
            return new StatusLine(r3.protocol(), r3.code(), r3.message());
        }

        public final StatusLine parse(String r8) throws IOException {
            Intrinsics.checkNotNullParameter(r8, "statusLine");
            if (StringsKt.startsWith$default(r8, "HTTP/1.", false, 2, null) == false) goto L19;
            int r0 = 9;
            if (r8.length() < 9) goto L17;
            if (r8.charAt(8) != ' ') goto L17;
            int r7 = r8.charAt(7) - '0';
            if (r7 != 0) goto L11;
            Protocol r9 = Protocol.HTTP_1_0;
        L21:
            int r2 = r0 + 3;
            if (r8.length() < r2) goto L37;
            String r1 = r8.substring(r0, r2);     // Catch: NumberFormatException -> L34
            Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");     // Catch: NumberFormatException -> L34
            int r3 = Integer.parseInt(r1);     // Catch: NumberFormatException -> L34
            if (r8.length() > r2) goto L27;
            String r10 = "";
        L33:
            return new StatusLine(r9, r3, r10);
        L27:
            if (r8.charAt(r2) != ' ') goto L30;
            r10 = r8.substring(r0 + 4);
            Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).substring(startIndex)");
            goto L33
        L30:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        L35:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        L37:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        L11:
            if (r7 != 1) goto L14;
            r9 = Protocol.HTTP_1_1;
            goto L21
        L14:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        L17:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        L19:
            if (StringsKt.startsWith$default(r8, "ICY ", false, 2, null) == false) goto L39;
            r9 = Protocol.HTTP_1_0;
            r0 = 4;
            goto L21
        L39:
            throw new ProtocolException(Intrinsics.stringPlus("Unexpected status line: ", r8));
        }
    }

    static {
        Companion = new Companion(null);
    }

    public StatusLine(Protocol r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "protocol");
        Intrinsics.checkNotNullParameter(r4, "message");
        this.protocol = r2;
        this.code = r3;
        this.message = r4;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        r0.append("HTTP/1.0");
    L6:
        r0.append(TokenParser.SP).append(this.code);
        r0.append(TokenParser.SP).append(this.message);
        String r4 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r4, "StringBuilder().apply(builderAction).toString()");
        return r4;
    L5:
        r0.append("HTTP/1.1");
        goto L6
    }
}
