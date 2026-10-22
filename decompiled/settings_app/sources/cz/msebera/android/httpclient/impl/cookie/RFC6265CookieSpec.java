package cz.msebera.android.httpclient.impl.cookie;

import cz.msebera.android.httpclient.FormattedHeader;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import cz.msebera.android.httpclient.cookie.CommonCookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.Cookie;
import cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import cz.msebera.android.httpclient.cookie.CookieOrigin;
import cz.msebera.android.httpclient.cookie.CookiePriorityComparator;
import cz.msebera.android.httpclient.cookie.CookieSpec;
import cz.msebera.android.httpclient.cookie.MalformedCookieException;
import cz.msebera.android.httpclient.message.BufferedHeader;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public class RFC6265CookieSpec implements CookieSpec {
    private static final char COMMA_CHAR = ',';
    private static final char DQUOTE_CHAR = '\"';
    private static final char EQUAL_CHAR = '=';
    private static final char ESCAPE_CHAR = '\\';
    private static final char PARAM_DELIMITER = ';';
    private static final BitSet SPECIAL_CHARS = null;
    private static final BitSet TOKEN_DELIMS = null;
    private static final BitSet VALUE_DELIMS = null;
    private final Map<String, CookieAttributeHandler> attribHandlerMap;
    private final CookieAttributeHandler[] attribHandlers;
    private final TokenParser tokenParser;

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public final int getVersion() {
        return 0;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public final Header getVersionHeader() {
        return null;
    }

    static {
        TOKEN_DELIMS = TokenParser.INIT_BITSET(new int[]{61, 59});
        VALUE_DELIMS = TokenParser.INIT_BITSET(new int[]{59});
        SPECIAL_CHARS = TokenParser.INIT_BITSET(new int[]{32, 34, 44, 59, 92});
    }

    protected RFC6265CookieSpec(CommonCookieAttributeHandler... r7) {
        this.attribHandlers = (CookieAttributeHandler[]) r7.clone();
        this.attribHandlerMap = new ConcurrentHashMap(r7.length);
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        CommonCookieAttributeHandler r2 = r7[r1];
        this.attribHandlerMap.put(r2.getAttributeName().toLowerCase(Locale.ROOT), r2);
        r1 = r1 + 1;
        goto L3
    L5:
        this.tokenParser = TokenParser.INSTANCE;
    }

    static String getDefaultPath(CookieOrigin r2) {
        String r3 = r2.getPath();
        int r0 = r3.lastIndexOf(47);
        if (r0 < 0) goto L8;
        if (r0 != 0) goto L7;
        r0 = 1;
    L7:
        return r3.substring(0, r0);
    L8:
        return r3;
    }

    static String getDefaultDomain(CookieOrigin r0) {
        return r0.getHost();
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public final List<Cookie> parse(Header r7, CookieOrigin r8) throws MalformedCookieException {
        Args.notNull(r7, "Header");
        Args.notNull(r8, "Cookie origin");
        if (r7.getName().equalsIgnoreCase("Set-Cookie") == false) goto L51;
        if ((r7 instanceof FormattedHeader) == false) goto L7;
        FormattedHeader r0 = (FormattedHeader) r7;
        CharArrayBuffer r2 = r0.getBuffer();
        ParserCursor r3 = new ParserCursor(r0.getValuePos(), r2.length());
    L10:
        String r1 = this.tokenParser.parseToken(r2, r3, TOKEN_DELIMS);
        if (r1.isEmpty() == false) goto L15;
        return Collections.emptyList();
    L15:
        if (r3.atEnd() == true) goto L17;
        char r4 = r2.charAt(r3.getPos());
        r3.updatePos(r3.getPos() + 1);
        if (r4 != '=') goto L47;
        String r9 = this.tokenParser.parseValue(r2, r3, VALUE_DELIMS);
        if (r3.atEnd() == true) goto L23;
        r3.updatePos(r3.getPos() + 1);
    L23:
        BasicClientCookie r5 = new BasicClientCookie(r1, r9);
        r5.setPath(getDefaultPath(r8));
        r5.setDomain(getDefaultDomain(r8));
        r5.setCreationDate(new Date());
        LinkedHashMap r10 = new LinkedHashMap();
    L25:
        if (r3.atEnd() == true) goto L36;
        String r11 = this.tokenParser.parseToken(r2, r3, TOKEN_DELIMS).toLowerCase(Locale.ROOT);
        if (r3.atEnd() == true) goto L33;
        char r6 = r2.charAt(r3.getPos());
        r3.updatePos(r3.getPos() + 1);
        if (r6 != '=') goto L33;
        String r12 = this.tokenParser.parseToken(r2, r3, VALUE_DELIMS);
        if (r3.atEnd() == true) goto L34;
        r3.updatePos(r3.getPos() + 1);
    L34:
        r5.setAttribute(r11, r12);
        r10.put(r11, r12);
    L33:
        r12 = null;
        goto L34
    L36:
        if (r10.containsKey("max-age") == false) goto L38;
        r10.remove(ClientCookie.EXPIRES_ATTR);
    L38:
        Iterator r13 = r10.entrySet().iterator();
    L40:
        if (r13.hasNext() == false) goto L45;
        Map.Entry r14 = (Map.Entry) r13.next();
        String r15 = (String) r14.getKey();
        String r16 = (String) r14.getValue();
        CookieAttributeHandler r17 = this.attribHandlerMap.get(r15);
        if (r17 == null) goto L40;
        r17.parse(r5, r16);
        goto L40
    L45:
        return Collections.singletonList(r5);
    L47:
        throw new MalformedCookieException("Cookie value is invalid: '" + r7.toString() + "'");
    L17:
        return Collections.emptyList();
    L7:
        String r18 = r7.getValue();
        if (r18 == null) goto L49;
        r2 = new CharArrayBuffer(r18.length());
        r2.append(r18);
        r3 = new ParserCursor(0, r2.length());
        goto L10
    L49:
        throw new MalformedCookieException("Header value is null");
    L51:
        throw new MalformedCookieException("Unrecognized cookie header: '" + r7.toString() + "'");
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public final void validate(Cookie r4, CookieOrigin r5) throws MalformedCookieException {
        Args.notNull(r4, "Cookie");
        Args.notNull(r5, "Cookie origin");
        CookieAttributeHandler[] r3 = this.attribHandlers;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].validate(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public final boolean match(Cookie r5, CookieOrigin r6) {
        Args.notNull(r5, "Cookie");
        Args.notNull(r6, "Cookie origin");
        CookieAttributeHandler[] r4 = this.attribHandlers;
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        if (r4[r2].match(r5, r6) == false) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // cz.msebera.android.httpclient.cookie.CookieSpec
    public List<Header> formatCookies(List<Cookie> r10) {
        Args.notEmpty(r10, "List of cookies");
        if (r10.size() <= 1) goto L5;
        ArrayList r0 = new ArrayList(r10);
        Collections.sort(r0, CookiePriorityComparator.INSTANCE);
        r10 = r0;
    L5:
        CharArrayBuffer r1 = new CharArrayBuffer(r10.size() * 20);
        r1.append("Cookie");
        r1.append(": ");
        int r3 = 0;
    L7:
        if (r3 >= r10.size()) goto L26;
        Cookie r4 = r10.get(r3);
        if (r3 <= 0) goto L11;
        r1.append(PARAM_DELIMITER);
        r1.append(TokenParser.SP);
    L11:
        r1.append(r4.getName());
        String r5 = r4.getValue();
        if (r5 == null) goto L25;
        r1.append(EQUAL_CHAR);
        if (containsSpecialChar(r5) == false) goto L24;
        r1.append('\"');
        int r6 = 0;
    L17:
        if (r6 >= r5.length()) goto L23;
        char r7 = r5.charAt(r6);
        if (r7 == '\"') goto L21;
        if (r7 == '\\') goto L21;
    L22:
        r1.append(r7);
        r6 = r6 + 1;
    L21:
        r1.append('\\');
        goto L22
    L23:
        r1.append('\"');
        goto L25
    L24:
        r1.append(r5);
    L25:
        r3 = r3 + 1;
        goto L7
    L26:
        ArrayList r9 = new ArrayList(1);
        r9.add(new BufferedHeader(r1));
        return r9;
    }

    boolean containsSpecialChar(CharSequence r2) {
        return containsChars(r2, SPECIAL_CHARS);
    }

    boolean containsChars(CharSequence r3, BitSet r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.length()) goto L10;
        if (r4.get(r3.charAt(r0)) == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
