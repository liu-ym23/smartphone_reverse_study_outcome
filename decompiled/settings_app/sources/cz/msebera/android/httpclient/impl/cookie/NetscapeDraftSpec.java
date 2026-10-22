package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public class NetscapeDraftSpec extends CookieSpecBase {
    protected static final String EXPIRES_PATTERN = "EEE, dd-MMM-yy HH:mm:ss z";

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "netscape";
    }

    public NetscapeDraftSpec(String[] r4) {
        CommonCookieAttributeHandler[] r0 = new CommonCookieAttributeHandler[5];
        r0[0] = new BasicPathHandler();
        r0[1] = new NetscapeDomainHandler();
        r0[2] = new BasicSecureHandler();
        r0[3] = new BasicCommentHandler();
        if (r4 == null) goto L5;
        String[] r5 = (String[]) r4.clone();
    L6:
        r0[4] = new BasicExpiresHandler(r5);
        super(r0);
        return;
    L5:
        r5 = new String[]{EXPIRES_PATTERN};
        goto L6
    }

    NetscapeDraftSpec(CommonCookieAttributeHandler... r1) {
        super(r1);
    }

    public NetscapeDraftSpec() {
        String[] r1 = (String[]) null;
        this(null);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Cookie> parse(Header r6, CookieOrigin r7) throws MalformedCookieException {
        Args.notNull(r6, "Header");
        Args.notNull(r7, "Cookie origin");
        if (r6.getName().equalsIgnoreCase("Set-Cookie") == false) goto L15;
        NetscapeDraftHeaderParser r0 = NetscapeDraftHeaderParser.DEFAULT;
        if ((r6 instanceof FormattedHeader) == false) goto L7;
        FormattedHeader r8 = (FormattedHeader) r6;
        CharArrayBuffer r1 = r8.getBuffer();
        ParserCursor r3 = new ParserCursor(r8.getValuePos(), r1.length());
    L11:
        return parse(new HeaderElement[]{r0.parseHeader(r1, r3)}, r7);
    L7:
        String r9 = r6.getValue();
        if (r9 == null) goto L13;
        r1 = new CharArrayBuffer(r9.length());
        r1.append(r9);
        r3 = new ParserCursor(0, r1.length());
        goto L11
    L13:
        throw new MalformedCookieException("Header value is null");
    L15:
        throw new MalformedCookieException("Unrecognized cookie header '" + r6.toString() + "'");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> r4) {
        Args.notEmpty(r4, "List of cookies");
        CharArrayBuffer r3 = new CharArrayBuffer(r4.size() * 20);
        r3.append("Cookie");
        r3.append(": ");
        int r0 = 0;
    L4:
        if (r0 >= r4.size()) goto L12;
        Cookie r1 = r4.get(r0);
        if (r0 <= 0) goto L8;
        r3.append(VectorFormat.DEFAULT_SEPARATOR);
    L8:
        r3.append(r1.getName());
        String r2 = r1.getValue();
        if (r2 == null) goto L11;
        r3.append("=");
        r3.append(r2);
    L11:
        r0 = r0 + 1;
        goto L4
    L12:
        ArrayList r5 = new ArrayList(1);
        r5.add(new BufferedHeader(r3));
        return r5;
    }
}
