package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BasicHeaderElement;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class BrowserCompatSpec extends CookieSpecBase {
    private static final String[] DEFAULT_DATE_PATTERNS = null;

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public int getVersion() {
        return 0;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "compatibility";
    }

    static {
        DEFAULT_DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    }

    public BrowserCompatSpec(String[] r4, BrowserCompatSpecFactory.SecurityLevel r5) {
        CommonCookieAttributeHandler[] r0 = new CommonCookieAttributeHandler[7];
        r0[0] = new BrowserCompatVersionAttributeHandler();
        r0[1] = new BasicDomainHandler();
        if (r5 != BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_IE_MEDIUM) goto L5;
        BasicPathHandler r6 = new AnonymousClass1();
    L6:
        r0[2] = r6;
        r0[3] = new BasicMaxAgeHandler();
        r0[4] = new BasicSecureHandler();
        r0[5] = new BasicCommentHandler();
        if (r4 == null) goto L9;
        String[] r7 = (String[]) r4.clone();
    L10:
        r0[6] = new BasicExpiresHandler(r7);
        super(r0);
        return;
    L9:
        r7 = DEFAULT_DATE_PATTERNS;
        goto L10
    L5:
        r6 = new BasicPathHandler();
        goto L6
    }

    public BrowserCompatSpec(String[] r2) {
        this(r2, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec() {
        this(null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Cookie> parse(Header r10, CookieOrigin r11) throws MalformedCookieException {
        Args.notNull(r10, "Header");
        Args.notNull(r11, "Cookie origin");
        if (r10.getName().equalsIgnoreCase("Set-Cookie") == false) goto L44;
        HeaderElement[] r0 = r10.getElements();
        int r1 = r0.length;
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
    L6:
        if (r3 >= r1) goto L14;
        HeaderElement r7 = r0[r3];
        if (r7.getParameterByName("version") == null) goto L11;
        r5 = true;
    L11:
        if (r7.getParameterByName(ClientCookie.EXPIRES_ATTR) == null) goto L13;
        r4 = true;
    L13:
        r3 = r3 + 1;
        goto L6
    L14:
        if (r4 == true) goto L19;
        if (r5 == false) goto L19;
        return parse(r0, r11);
    L19:
        NetscapeDraftHeaderParser r2 = NetscapeDraftHeaderParser.DEFAULT;
        if ((r10 instanceof FormattedHeader) == false) goto L22;
        FormattedHeader r12 = (FormattedHeader) r10;
        CharArrayBuffer r6 = r12.getBuffer();
        ParserCursor r8 = new ParserCursor(r12.getValuePos(), r6.length());
    L25:
        HeaderElement r13 = r2.parseHeader(r6, r8);
        String r9 = r13.getName();
        String r14 = r13.getValue();
        if (r9 == null) goto L40;
        if (r9.isEmpty() == true) goto L40;
        BasicClientCookie r15 = new BasicClientCookie(r9, r14);
        r15.setPath(getDefaultPath(r11));
        r15.setDomain(getDefaultDomain(r11));
        NameValuePair[] r16 = r13.getParameters();
        int r17 = r16.length - 1;
    L30:
        if (r17 < 0) goto L35;
        NameValuePair r18 = r16[r17];
        String r19 = r18.getName().toLowerCase(Locale.ROOT);
        r15.setAttribute(r19, r18.getValue());
        CookieAttributeHandler r20 = findAttribHandler(r19);
        if (r20 == null) goto L34;
        r20.parse(r15, r18.getValue());
    L34:
        r17 = r17 - 1;
        goto L30
    L35:
        if (r4 == false) goto L38;
        r15.setVersion(0);
    L38:
        return Collections.singletonList(r15);
    L40:
        throw new MalformedCookieException("Cookie name may not be empty");
    L22:
        String r110 = r10.getValue();
        if (r110 == null) goto L42;
        r6 = new CharArrayBuffer(r110.length());
        r6.append(r110);
        r8 = new ParserCursor(0, r6.length());
        goto L25
    L42:
        throw new MalformedCookieException("Header value is null");
    L44:
        throw new MalformedCookieException("Unrecognized cookie header '" + r10.toString() + "'");
    }

    private static boolean isQuoteEnclosed(String r2) {
        if (r2 != null) goto L4;
    L8:
        return false;
    L4:
        if (r2.startsWith("\"") == false) goto L8;
        if (r2.endsWith("\"") == false) goto L8;
        return true;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> r7) {
        Args.notEmpty(r7, "List of cookies");
        CharArrayBuffer r6 = new CharArrayBuffer(r7.size() * 20);
        r6.append("Cookie");
        r6.append(": ");
        int r1 = 0;
    L4:
        if (r1 >= r7.size()) goto L17;
        Cookie r2 = r7.get(r1);
        if (r1 <= 0) goto L8;
        r6.append(VectorFormat.DEFAULT_SEPARATOR);
    L8:
        String r3 = r2.getName();
        String r4 = r2.getValue();
        if (r2.getVersion() > 0) goto L11;
    L13:
        r6.append(r3);
        r6.append("=");
        if (r4 == null) goto L16;
        r6.append(r4);
    L16:
        r1 = r1 + 1;
        goto L4
    L11:
        if (isQuoteEnclosed(r4) == true) goto L13;
        BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(r6, new BasicHeaderElement(r3, r4), false);
        goto L16
    L17:
        ArrayList r8 = new ArrayList(1);
        r8.add(new BufferedHeader(r6));
        return r8;
    }
}
