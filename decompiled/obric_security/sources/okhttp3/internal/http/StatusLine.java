package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Protocol;
import okhttp3.Response;

/* JADX INFO: loaded from: classes5.dex */
public final class StatusLine {
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol r1, int r2, String r3) {
        this.protocol = r1;
        this.code = r2;
        this.message = r3;
    }

    public static StatusLine get(Response r3) {
        return new StatusLine(r3.protocol(), r3.code(), r3.message());
    }

    public static StatusLine parse(String r8) throws IOException {
        if (r8.startsWith("HTTP/1.") == false) goto L19;
        int r4 = 9;
        if (r8.length() < 9) goto L17;
        if (r8.charAt(8) != ' ') goto L17;
        int r0 = r8.charAt(7) - '0';
        if (r0 != 0) goto L12;
        Protocol r1 = Protocol.HTTP_1_0;
    L21:
        int r6 = r4 + 3;
        if (r8.length() < r6) goto L37;
        int r5 = Integer.parseInt(r8.substring(r4, r6));     // Catch: NumberFormatException -> L34
        if (r8.length() > r6) goto L27;
        String r9 = "";
    L33:
        return new StatusLine(r1, r5, r9);
    L27:
        if (r8.charAt(r6) != ' ') goto L30;
        r9 = r8.substring(r4 + 4);
        goto L33
    L30:
        throw new ProtocolException("Unexpected status line: " + r8);
    L35:
        throw new ProtocolException("Unexpected status line: " + r8);
    L37:
        throw new ProtocolException("Unexpected status line: " + r8);
    L12:
        if (r0 != 1) goto L15;
        r1 = Protocol.HTTP_1_1;
        goto L21
    L15:
        throw new ProtocolException("Unexpected status line: " + r8);
    L17:
        throw new ProtocolException("Unexpected status line: " + r8);
    L19:
        if (r8.startsWith("ICY ") == false) goto L39;
        r1 = Protocol.HTTP_1_0;
        r4 = 4;
        goto L21
    L39:
        throw new ProtocolException("Unexpected status line: " + r8);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.protocol != Protocol.HTTP_1_0) goto L5;
        String r1 = "HTTP/1.0";
    L6:
        r0.append(r1);
        r0.append(' ').append(this.code);
        if (this.message == null) goto L10;
        r0.append(' ').append(this.message);
    L10:
        return r0.toString();
    L5:
        r1 = "HTTP/1.1";
        goto L6
    }
}
