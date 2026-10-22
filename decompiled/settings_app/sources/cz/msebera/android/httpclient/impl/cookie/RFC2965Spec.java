package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.client.params.CookiePolicy;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2965Spec extends RFC2109Spec {
    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec, cz.msebera.android.httpclient.cookie.CookieSpec
    public int getVersion() {
        return 1;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec
    public String toString() {
        return CookiePolicy.RFC_2965;
    }

    public RFC2965Spec() {
        this(null, false);
    }

    public RFC2965Spec(String[] r4, boolean r5) {
        CommonCookieAttributeHandler[] r0 = new CommonCookieAttributeHandler[10];
        r0[0] = new RFC2965VersionAttributeHandler();
        r0[1] = new AnonymousClass1();
        r0[2] = new RFC2965DomainAttributeHandler();
        r0[3] = new RFC2965PortAttributeHandler();
        r0[4] = new BasicMaxAgeHandler();
        r0[5] = new BasicSecureHandler();
        r0[6] = new BasicCommentHandler();
        if (r4 == null) goto L5;
        String[] r6 = (String[]) r4.clone();
    L6:
        r0[7] = new BasicExpiresHandler(r6);
        r0[8] = new RFC2965CommentUrlAttributeHandler();
        r0[9] = new RFC2965DiscardAttributeHandler();
        super(r5, r0);
        return;
    L5:
        r6 = DATE_PATTERNS;
        goto L6
    }

    RFC2965Spec(boolean r1, CommonCookieAttributeHandler... r2) {
        super(r1, r2);
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec, cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Cookie> parse(Header r3, CookieOrigin r4) throws MalformedCookieException {
        Args.notNull(r3, "Header");
        Args.notNull(r4, "Cookie origin");
        if (r3.getName().equalsIgnoreCase("Set-Cookie2") == false) goto L7;
        return createCookies(r3.getElements(), adjustEffectiveHost(r4));
    L7:
        throw new MalformedCookieException("Unrecognized cookie header '" + r3.toString() + "'");
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.CookieSpecBase
    protected List<Cookie> parse(HeaderElement[] r1, CookieOrigin r2) throws MalformedCookieException {
        return createCookies(r1, adjustEffectiveHost(r2));
    }

    private List<Cookie> createCookies(HeaderElement[] r12, CookieOrigin r13) throws MalformedCookieException {
        ArrayList r0 = new ArrayList(r12.length);
        int r1 = r12.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L20;
        HeaderElement r4 = r12[r3];
        String r5 = r4.getName();
        String r6 = r4.getValue();
        if (r5 == null) goto L19;
        if (r5.isEmpty() == true) goto L19;
        BasicClientCookie2 r7 = new BasicClientCookie2(r5, r6);
        r7.setPath(getDefaultPath(r13));
        r7.setDomain(getDefaultDomain(r13));
        r7.setPorts(new int[]{r13.getPort()});
        NameValuePair[] r8 = r4.getParameters();
        HashMap r9 = new HashMap(r8.length);
        int r10 = r8.length - 1;
    L9:
        if (r10 < 0) goto L11;
        NameValuePair r11 = r8[r10];
        r9.put(r11.getName().toLowerCase(Locale.ROOT), r11);
        r10 = r10 - 1;
        goto L9
    L11:
        Iterator r14 = r9.entrySet().iterator();
    L13:
        if (r14.hasNext() == false) goto L17;
        NameValuePair r15 = (NameValuePair) ((Map.Entry) r14.next()).getValue();
        String r16 = r15.getName().toLowerCase(Locale.ROOT);
        r7.setAttribute(r16, r15.getValue());
        CookieAttributeHandler r17 = findAttribHandler(r16);
        if (r17 == null) goto L13;
        r17.parse(r7, r15.getValue());
        goto L13
    L17:
        r0.add(r7);
        r3 = r3 + 1;
    L19:
        throw new MalformedCookieException("Cookie name may not be empty");
    L20:
        return r0;
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec, cz.msebera.android.httpclient.impl.cookie.CookieSpecBase, cz.msebera.android.httpclient.cookie.CookieSpec
    public void validate(Cookie r2, CookieOrigin r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        super.validate(r2, adjustEffectiveHost(r3));
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.CookieSpecBase, cz.msebera.android.httpclient.cookie.CookieSpec
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        return super.match(r2, adjustEffectiveHost(r3));
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec
    protected void formatCookieAsVer(CharArrayBuffer r2, Cookie r3, int r4) {
        super.formatCookieAsVer(r2, r3, r4);
        if ((r3 instanceof ClientCookie) == false) goto L20;
        String r1 = ((ClientCookie) r3).getAttribute(ClientCookie.PORT_ATTR);
        if (r1 == null) goto L21;
        r2.append("; $Port");
        r2.append("=\"");
        if (r1.trim().isEmpty() == true) goto L15;
        int[] r5 = r3.getPorts();
        if (r5 == null) goto L15;
        int r6 = r5.length;
        int r7 = 0;
    L11:
        if (r7 >= r6) goto L15;
        if (r7 <= 0) goto L14;
        r2.append(",");
    L14:
        r2.append(Integer.toString(r5[r7]));
        r7 = r7 + 1;
    L15:
        r2.append("\"");
        return;
    L21:
        return;
    }

    private static CookieOrigin adjustEffectiveHost(CookieOrigin r5) {
        String r0 = r5.getHost();
        boolean r1 = false;
        int r2 = 0;
    L4:
        if (r2 >= r0.length()) goto L11;
        char r3 = r0.charAt(r2);
        if (r3 == '.') goto L12;
        if (r3 == ':') goto L12;
        r2 = r2 + 1;
    L12:
        if (r1 == true) goto L14;
        return r5;
    L14:
        return new CookieOrigin(r0 + ".local", r5.getPort(), r5.getPath(), r5.isSecure());
    L11:
        r1 = true;
        goto L12
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.RFC2109Spec, cz.msebera.android.httpclient.cookie.CookieSpec
    public Header getVersionHeader() {
        CharArrayBuffer r0 = new CharArrayBuffer(40);
        r0.append("Cookie2");
        r0.append(": ");
        r0.append("$Version=");
        r0.append(Integer.toString(getVersion()));
        return new BufferedHeader(r0);
    }
}
