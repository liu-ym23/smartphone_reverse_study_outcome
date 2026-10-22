package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.cookie.SetCookie2;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultCookieSpec implements CookieSpec {
    private final NetscapeDraftSpec netscapeDraft;
    private final RFC2109Spec obsoleteStrict;
    private final RFC2965Spec strict;

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "default";
    }

    DefaultCookieSpec(RFC2965Spec r1, RFC2109Spec r2, NetscapeDraftSpec r3) {
        this.strict = r1;
        this.obsoleteStrict = r2;
        this.netscapeDraft = r3;
    }

    public DefaultCookieSpec(String[] r12, boolean r13) {
        this.strict = new RFC2965Spec(r13, new CommonCookieAttributeHandler[]{new RFC2965VersionAttributeHandler(), new BasicPathHandler(), new RFC2965DomainAttributeHandler(), new RFC2965PortAttributeHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler(), new RFC2965CommentUrlAttributeHandler(), new RFC2965DiscardAttributeHandler()});
        this.obsoleteStrict = new RFC2109Spec(r13, new CommonCookieAttributeHandler[]{new RFC2109VersionHandler(), new BasicPathHandler(), new RFC2109DomainHandler(), new BasicMaxAgeHandler(), new BasicSecureHandler(), new BasicCommentHandler()});
        CommonCookieAttributeHandler[] r0 = new CommonCookieAttributeHandler[5];
        r0[0] = new BasicDomainHandler();
        r0[1] = new BasicPathHandler();
        r0[2] = new BasicSecureHandler();
        r0[3] = new BasicCommentHandler();
        if (r12 == null) goto L5;
        String[] r14 = (String[]) r12.clone();
    L6:
        r0[4] = new BasicExpiresHandler(r14);
        this.netscapeDraft = new NetscapeDraftSpec(r0);
        return;
    L5:
        r14 = new String[]{"EEE, dd-MMM-yy HH:mm:ss z"};
        goto L6
    }

    public DefaultCookieSpec() {
        this(null, false);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Cookie> parse(Header r10, CookieOrigin r11) throws MalformedCookieException {
        Args.notNull(r10, "Header");
        Args.notNull(r11, "Cookie origin");
        HeaderElement[] r0 = r10.getElements();
        int r1 = r0.length;
        int r3 = 0;
        boolean r4 = false;
        boolean r5 = false;
    L4:
        if (r3 >= r1) goto L12;
        HeaderElement r7 = r0[r3];
        if (r7.getParameterByName("version") == null) goto L9;
        r5 = true;
    L9:
        if (r7.getParameterByName(ClientCookie.EXPIRES_ATTR) == null) goto L11;
        r4 = true;
    L11:
        r3 = r3 + 1;
        goto L4
    L12:
        if (r4 == true) goto L20;
        if (r5 == false) goto L20;
        if ("Set-Cookie2".equals(r10.getName()) == false) goto L19;
        return this.strict.parse(r0, r11);
    L19:
        return this.obsoleteStrict.parse(r0, r11);
    L20:
        NetscapeDraftHeaderParser r2 = NetscapeDraftHeaderParser.DEFAULT;
        if ((r10 instanceof FormattedHeader) == false) goto L23;
        FormattedHeader r12 = (FormattedHeader) r10;
        CharArrayBuffer r6 = r12.getBuffer();
        ParserCursor r8 = new ParserCursor(r12.getValuePos(), r6.length());
    L27:
        return this.netscapeDraft.parse(new HeaderElement[]{r2.parseHeader(r6, r8)}, r11);
    L23:
        String r13 = r10.getValue();
        if (r13 == null) goto L29;
        r6 = new CharArrayBuffer(r13.length());
        r6.append(r13);
        r8 = new ParserCursor(0, r6.length());
        goto L27
    L29:
        throw new MalformedCookieException("Header value is null");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public void validate(Cookie r2, CookieOrigin r3) throws MalformedCookieException {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        if (r2.getVersion() > 0) goto L5;
        this.netscapeDraft.validate(r2, r3);
        return;
    L5:
        if ((r2 instanceof SetCookie2) == false) goto L7;
        this.strict.validate(r2, r3);
        return;
    L7:
        this.obsoleteStrict.validate(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public boolean match(Cookie r2, CookieOrigin r3) {
        Args.notNull(r2, "Cookie");
        Args.notNull(r3, "Cookie origin");
        if (r2.getVersion() <= 0) goto L10;
        if ((r2 instanceof SetCookie2) == false) goto L8;
        return this.strict.match(r2, r3);
    L8:
        return this.obsoleteStrict.match(r2, r3);
    L10:
        return this.netscapeDraft.match(r2, r3);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> r6) {
        Args.notNull(r6, "List of cookies");
        Iterator<Cookie> r0 = r6.iterator();
        int r1 = Integer.MAX_VALUE;
        boolean r2 = true;
    L4:
        if (r0.hasNext() == false) goto L11;
        Cookie r3 = r0.next();
        if ((r3 instanceof SetCookie2) == true) goto L9;
        r2 = false;
    L9:
        if (r3.getVersion() >= r1) goto L4;
        r1 = r3.getVersion();
        goto L4
    L11:
        if (r1 <= 0) goto L17;
        if (r2 == false) goto L15;
        return this.strict.formatCookies(r6);
    L15:
        return this.obsoleteStrict.formatCookies(r6);
    L17:
        return this.netscapeDraft.formatCookies(r6);
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public int getVersion() {
        return this.strict.getVersion();
    }
}
