package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.client.params.CookiePolicy;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookiePathComparator;
import cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public class RFC2109Spec extends CookieSpecBase {
    static final String[] DATE_PATTERNS = null;
    private final boolean oneHeader;

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public int getVersion() {
        return 1;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return CookiePolicy.RFC_2109;
    }

    static {
        DATE_PATTERNS = new String[]{"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
    }

    public RFC2109Spec(String[] r4, boolean r5) {
        CommonCookieAttributeHandler[] r0 = new CommonCookieAttributeHandler[7];
        r0[0] = new RFC2109VersionHandler();
        r0[1] = new AnonymousClass1();
        r0[2] = new RFC2109DomainHandler();
        r0[3] = new BasicMaxAgeHandler();
        r0[4] = new BasicSecureHandler();
        r0[5] = new BasicCommentHandler();
        if (r4 == null) goto L5;
        String[] r6 = (String[]) r4.clone();
    L6:
        r0[6] = new BasicExpiresHandler(r6);
        super(r0);
        this.oneHeader = r5;
        return;
    L5:
        r6 = DATE_PATTERNS;
        goto L6
    }

    public RFC2109Spec() {
        this(null, false);
    }

    protected RFC2109Spec(boolean r1, CommonCookieAttributeHandler... r2) {
        super(r2);
        this.oneHeader = r1;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Cookie> parse(Header r3, CookieOrigin r4) throws MalformedCookieException {
        Args.notNull(r3, "Header");
        Args.notNull(r4, "Cookie origin");
        if (r3.getName().equalsIgnoreCase("Set-Cookie") == false) goto L7;
        return parse(r3.getElements(), r4);
    L7:
        throw new MalformedCookieException("Unrecognized cookie header '" + r3.toString() + "'");
    }

    @Override // cz.msebera.android.httpclient.impl.cookie.CookieSpecBase, cz.msebera.android.httpclient.cookie.CookieSpec
    public void validate(Cookie r4, CookieOrigin r5) throws MalformedCookieException {
        Args.notNull(r4, "Cookie");
        String r0 = r4.getName();
        if (r0.indexOf(32) != (-1)) goto L11;
        if (r0.startsWith("$") == true) goto L9;
        super.validate(r4, r5);
        return;
    L9:
        throw new CookieRestrictionViolationException("Cookie name may not start with $");
    L11:
        throw new CookieRestrictionViolationException("Cookie name may not contain blanks");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> r3) {
        Args.notEmpty(r3, "List of cookies");
        if (r3.size() <= 1) goto L6;
        ArrayList r0 = new ArrayList(r3);
        Collections.sort(r0, CookiePathComparator.INSTANCE);
        r3 = r0;
    L6:
        if (this.oneHeader == false) goto L9;
        return doFormatOneHeader(r3);
    L9:
        return doFormatManyHeaders(r3);
    }

    private List<Header> doFormatOneHeader(List<Cookie> r5) {
        Iterator<Cookie> r0 = r5.iterator();
        int r1 = Integer.MAX_VALUE;
    L4:
        if (r0.hasNext() == false) goto L8;
        Cookie r2 = r0.next();
        if (r2.getVersion() >= r1) goto L4;
        r1 = r2.getVersion();
        goto L4
    L8:
        CharArrayBuffer r3 = new CharArrayBuffer(r5.size() * 40);
        r3.append("Cookie");
        r3.append(": ");
        r3.append("$Version=");
        r3.append(Integer.toString(r1));
        Iterator<Cookie> r6 = r5.iterator();
    L10:
        if (r6.hasNext() == false) goto L12;
        Cookie r4 = r6.next();
        r3.append(VectorFormat.DEFAULT_SEPARATOR);
        formatCookieAsVer(r3, r4, r1);
        goto L10
    L12:
        ArrayList r7 = new ArrayList(1);
        r7.add(new BufferedHeader(r3));
        return r7;
    }

    private List<Header> doFormatManyHeaders(List<Cookie> r6) {
        ArrayList r0 = new ArrayList(r6.size());
        Iterator<Cookie> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        Cookie r1 = r7.next();
        int r2 = r1.getVersion();
        CharArrayBuffer r3 = new CharArrayBuffer(40);
        r3.append("Cookie: ");
        r3.append("$Version=");
        r3.append(Integer.toString(r2));
        r3.append(VectorFormat.DEFAULT_SEPARATOR);
        formatCookieAsVer(r3, r1, r2);
        r0.add(new BufferedHeader(r3));
        goto L4
    L6:
        return r0;
    }

    protected void formatParamAsVer(CharArrayBuffer r1, String r2, String r3, int r4) {
        r1.append(r2);
        r1.append("=");
        if (r3 == null) goto L8;
        if (r4 <= 0) goto L6;
        r1.append('\"');
        r1.append(r3);
        r1.append('\"');
        return;
    L6:
        r1.append(r3);
        return;
    }

    protected void formatCookieAsVer(CharArrayBuffer r4, Cookie r5, int r6) {
        formatParamAsVer(r4, r5.getName(), r5.getValue(), r6);
        if (r5.getPath() == null) goto L10;
        if ((r5 instanceof ClientCookie) == false) goto L10;
        if (((ClientCookie) r5).containsAttribute("path") == false) goto L10;
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
        formatParamAsVer(r4, "$Path", r5.getPath(), r6);
    L10:
        if (r5.getDomain() != null) goto L12;
        return;
    L12:
        if ((r5 instanceof ClientCookie) == true) goto L14;
        return;
    L14:
        if (((ClientCookie) r5).containsAttribute(ClientCookie.DOMAIN_ATTR) == false) goto L19;
        r4.append(VectorFormat.DEFAULT_SEPARATOR);
        formatParamAsVer(r4, "$Domain", r5.getDomain(), r6);
        return;
    }
}
