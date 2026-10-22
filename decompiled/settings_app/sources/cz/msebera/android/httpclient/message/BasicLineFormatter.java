package cz.msebera.android.httpclient.message;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.RequestLine;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class BasicLineFormatter implements LineFormatter {

    @Deprecated
    public static final BasicLineFormatter DEFAULT = null;
    public static final BasicLineFormatter INSTANCE = null;

    static {
        DEFAULT = new BasicLineFormatter();
        INSTANCE = new BasicLineFormatter();
    }

    public BasicLineFormatter() {
    }

    protected CharArrayBuffer initBuffer(CharArrayBuffer r1) {
        if (r1 == null) goto L5;
        r1.clear();
        return r1;
    L5:
        return new CharArrayBuffer(64);
    }

    public static String formatProtocolVersion(ProtocolVersion r1, LineFormatter r2) {
        if (r2 != null) goto L6;
        r2 = INSTANCE;
    L6:
        return r2.appendProtocolVersion(null, r1).toString();
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer appendProtocolVersion(CharArrayBuffer r2, ProtocolVersion r3) {
        Args.notNull(r3, "Protocol version");
        int r1 = estimateProtocolVersionLen(r3);
        if (r2 != null) goto L5;
        r2 = new CharArrayBuffer(r1);
    L6:
        r2.append(r3.getProtocol());
        r2.append(IOUtils.DIR_SEPARATOR_UNIX);
        r2.append(Integer.toString(r3.getMajor()));
        r2.append('.');
        r2.append(Integer.toString(r3.getMinor()));
        return r2;
    L5:
        r2.ensureCapacity(r1);
        goto L6
    }

    protected int estimateProtocolVersionLen(ProtocolVersion r1) {
        return r1.getProtocol().length() + 4;
    }

    public static String formatRequestLine(RequestLine r1, LineFormatter r2) {
        if (r2 != null) goto L6;
        r2 = INSTANCE;
    L6:
        return r2.formatRequestLine(null, r1).toString();
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatRequestLine(CharArrayBuffer r2, RequestLine r3) {
        Args.notNull(r3, "Request line");
        CharArrayBuffer r4 = initBuffer(r2);
        doFormatRequestLine(r4, r3);
        return r4;
    }

    protected void doFormatRequestLine(CharArrayBuffer r5, RequestLine r6) {
        String r0 = r6.getMethod();
        String r1 = r6.getUri();
        r5.ensureCapacity((((r0.length() + 1) + r1.length()) + 1) + estimateProtocolVersionLen(r6.getProtocolVersion()));
        r5.append(r0);
        r5.append(TokenParser.SP);
        r5.append(r1);
        r5.append(TokenParser.SP);
        appendProtocolVersion(r5, r6.getProtocolVersion());
    }

    public static String formatStatusLine(StatusLine r1, LineFormatter r2) {
        if (r2 != null) goto L6;
        r2 = INSTANCE;
    L6:
        return r2.formatStatusLine(null, r1).toString();
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatStatusLine(CharArrayBuffer r2, StatusLine r3) {
        Args.notNull(r3, "Status line");
        CharArrayBuffer r4 = initBuffer(r2);
        doFormatStatusLine(r4, r3);
        return r4;
    }

    protected void doFormatStatusLine(CharArrayBuffer r4, StatusLine r5) {
        int r0 = ((estimateProtocolVersionLen(r5.getProtocolVersion()) + 1) + 3) + 1;
        String r1 = r5.getReasonPhrase();
        if (r1 == null) goto L5;
        r0 = r0 + r1.length();
    L5:
        r4.ensureCapacity(r0);
        appendProtocolVersion(r4, r5.getProtocolVersion());
        r4.append(TokenParser.SP);
        r4.append(Integer.toString(r5.getStatusCode()));
        r4.append(TokenParser.SP);
        if (r1 == null) goto L9;
        r4.append(r1);
        return;
    }

    public static String formatHeader(Header r1, LineFormatter r2) {
        if (r2 != null) goto L6;
        r2 = INSTANCE;
    L6:
        return r2.formatHeader(null, r1).toString();
    }

    @Override // cz.msebera.android.httpclient.message.LineFormatter
    public CharArrayBuffer formatHeader(CharArrayBuffer r2, Header r3) {
        Args.notNull(r3, "Header");
        if ((r3 instanceof FormattedHeader) == true) goto L7;
        CharArrayBuffer r4 = initBuffer(r2);
        doFormatHeader(r4, r3);
        return r4;
    L7:
        return ((FormattedHeader) r3).getBuffer();
    }

    protected void doFormatHeader(CharArrayBuffer r3, Header r4) {
        String r2 = r4.getName();
        String r5 = r4.getValue();
        int r0 = r2.length() + 2;
        if (r5 == null) goto L5;
        r0 = r0 + r5.length();
    L5:
        r3.ensureCapacity(r0);
        r3.append(r2);
        r3.append(": ");
        if (r5 == null) goto L20;
        r3.ensureCapacity(r3.length() + r5.length());
        int r6 = 0;
    L9:
        if (r6 >= r5.length()) goto L24;
        char r1 = r5.charAt(r6);
        if (r1 != '\r') goto L13;
    L18:
        r1 = TokenParser.SP;
    L19:
        r3.append(r1);
        r6 = r6 + 1;
        goto L9
    L13:
        if (r1 == '\n') goto L18;
        if (r1 == '\f') goto L18;
        if (r1 != 11) goto L19;
    L24:
        return;
    }
}
