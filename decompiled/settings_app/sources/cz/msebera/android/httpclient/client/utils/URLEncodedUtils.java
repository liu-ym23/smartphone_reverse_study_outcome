package cz.msebera.android.httpclient.client.utils;

import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.message.TokenParser;
import cz.msebera.android.httpclient.protocol.HTTP;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/* JADX INFO: loaded from: classes5.dex */
public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final BitSet PATHSAFE = null;
    private static final char PATH_SEPARATOR = '/';
    private static final BitSet PATH_SEPARATORS = null;
    private static final BitSet PATH_SPECIAL = null;
    private static final BitSet PUNCT = null;
    private static final char QP_SEP_A = '&';
    private static final char QP_SEP_S = ';';
    private static final int RADIX = 16;
    private static final BitSet RESERVED = null;
    private static final BitSet UNRESERVED = null;
    private static final BitSet URIC = null;
    private static final BitSet URLENCODER = null;
    private static final BitSet USERINFO = null;

    public URLEncodedUtils() {
    }

    static {
        BitSet r0 = new BitSet(256);
        PATH_SEPARATORS = r0;
        r0.set(47);
        UNRESERVED = new BitSet(256);
        PUNCT = new BitSet(256);
        USERINFO = new BitSet(256);
        PATHSAFE = new BitSet(256);
        URIC = new BitSet(256);
        RESERVED = new BitSet(256);
        URLENCODER = new BitSet(256);
        PATH_SPECIAL = new BitSet(256);
        int r1 = 97;
    L4:
        if (r1 > 122) goto L6;
        UNRESERVED.set(r1);
        r1 = r1 + 1;
        goto L4
    L6:
        int r2 = 65;
    L8:
        if (r2 > 90) goto L10;
        UNRESERVED.set(r2);
        r2 = r2 + 1;
        goto L8
    L10:
        int r3 = 48;
    L12:
        if (r3 > 57) goto L14;
        UNRESERVED.set(r3);
        r3 = r3 + 1;
        goto L12
    L14:
        BitSet r4 = UNRESERVED;
        r4.set(95);
        r4.set(45);
        r4.set(46);
        r4.set(42);
        URLENCODER.or(r4);
        r4.set(33);
        r4.set(126);
        r4.set(39);
        r4.set(40);
        r4.set(41);
        BitSet r5 = PUNCT;
        r5.set(44);
        r5.set(59);
        r5.set(58);
        r5.set(36);
        r5.set(38);
        r5.set(43);
        r5.set(61);
        BitSet r10 = USERINFO;
        r10.or(r4);
        r10.or(r5);
        BitSet r6 = PATHSAFE;
        r6.or(r4);
        r6.set(59);
        r6.set(58);
        r6.set(64);
        r6.set(38);
        r6.set(61);
        r6.set(43);
        r6.set(36);
        r6.set(44);
        BitSet r11 = PATH_SPECIAL;
        r11.or(r6);
        r11.set(47);
        BitSet r7 = RESERVED;
        r7.set(59);
        r7.set(47);
        r7.set(63);
        r7.set(58);
        r7.set(64);
        r7.set(38);
        r7.set(61);
        r7.set(43);
        r7.set(36);
        r7.set(44);
        r7.set(91);
        r7.set(93);
        BitSet r8 = URIC;
        r8.or(r7);
        r8.or(r4);
    }

    @Deprecated
    public static List<NameValuePair> parse(URI r0, String r1) {
        if (r1 == null) goto L4;
        Charset r2 = Charset.forName(r1);
    L6:
        return parse(r0, r2);
    L4:
        r2 = null;
        goto L6
    }

    public static List<NameValuePair> parse(URI r1, Charset r2) {
        Args.notNull(r1, "URI");
        String r3 = r1.getRawQuery();
        if (r3 == null) goto L9;
        if (r3.isEmpty() == true) goto L9;
        return parse(r3, r2);
    L9:
        return createEmptyList();
    }

    public static List<NameValuePair> parse(HttpEntity r8) throws IOException {
        Args.notNull(r8, "HTTP entity");
        ContentType r0 = ContentType.get(r8);
        if (r0 == null) goto L38;
        if (r0.getMimeType().equalsIgnoreCase("application/x-www-form-urlencoded") == false) goto L38;
        long r1 = r8.getContentLength();
        if (r1 > 2147483647L) goto L10;
        boolean r3 = true;
    L11:
        Args.check(r3, "HTTP entity is too large");
        if (r0.getCharset() == null) goto L14;
        Charset r2 = r0.getCharset();
    L15:
        InputStream r9 = r8.getContent();
        if (r9 == null) goto L18;
    L34:
        th = move-exception;
        r9.close();
        throw th;
    L20:
        if (r1 <= 0) goto L22;
        int r4 = (int) r1;     // Catch: Throwable -> L34
    L23:
        CharArrayBuffer r5 = new CharArrayBuffer(r4);     // Catch: Throwable -> L34
        InputStreamReader r6 = new InputStreamReader(r9, r2);     // Catch: Throwable -> L34
        char[] r7 = new char[1024];     // Catch: Throwable -> L34
    L24:
        int r10 = r6.read(r7);     // Catch: Throwable -> L34
        if (r10 == (-1)) goto L28;
        r5.append(r7, 0, r10);     // Catch: Throwable -> L34
        goto L24
    L28:
        r9.close();
        if (r5.isEmpty() == false) goto L33;
        return createEmptyList();
    L33:
        return parse(r5, r2, new char[]{'&'});
    L22:
        r4 = 1024;
        goto L23
    L18:
        return createEmptyList();
    L14:
        r2 = HTTP.DEF_CONTENT_CHARSET;
        goto L15
    L10:
        r3 = false;
    L38:
        return createEmptyList();
    }

    public static boolean isEncoded(HttpEntity r2) {
        Args.notNull(r2, "HTTP entity");
        Header r3 = r2.getContentType();
        if (r3 == null) goto L8;
        HeaderElement[] r4 = r3.getElements();
        if (r4.length <= 0) goto L8;
        return r4[0].getName().equalsIgnoreCase("application/x-www-form-urlencoded");
    L8:
        return false;
    }

    @Deprecated
    public static void parse(List<NameValuePair> r1, Scanner r2, String r3) {
        parse(r1, r2, "[&;]", r3);
    }

    @Deprecated
    public static void parse(List<NameValuePair> r2, Scanner r3, String r4, String r5) {
        r3.useDelimiter(r4);
    L4:
        if (r3.hasNext() == false) goto L10;
        String r6 = r3.next();
        int r0 = r6.indexOf(NAME_VALUE_SEPARATOR);
        if (r0 == (-1)) goto L8;
        String r1 = decodeFormFields(r6.substring(0, r0).trim(), r5);
        String r7 = decodeFormFields(r6.substring(r0 + 1).trim(), r5);
    L9:
        r2.add(new BasicNameValuePair(r1, r7));
        goto L4
    L8:
        r1 = decodeFormFields(r6.trim(), r5);
        r7 = null;
        goto L9
    }

    public static List<NameValuePair> parse(String r2, Charset r3) {
        if (r2 == null) goto L4;
        CharArrayBuffer r0 = new CharArrayBuffer(r2.length());
        r0.append(r2);
        return parse(r0, r3, new char[]{'&', QP_SEP_S});
    L4:
        return createEmptyList();
    }

    public static List<NameValuePair> parse(String r2, Charset r3, char... r4) {
        if (r2 == null) goto L4;
        CharArrayBuffer r0 = new CharArrayBuffer(r2.length());
        r0.append(r2);
        return parse(r0, r3, r4);
    L4:
        return createEmptyList();
    }

    public static List<NameValuePair> parse(CharArrayBuffer r7, Charset r8, char... r9) {
        Args.notNull(r7, "Char array buffer");
        TokenParser r0 = TokenParser.INSTANCE;
        BitSet r1 = new BitSet();
        int r2 = r9.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        r1.set(r9[r4]);
        r4 = r4 + 1;
        goto L3
    L5:
        ParserCursor r10 = new ParserCursor(0, r7.length());
        ArrayList r3 = new ArrayList();
    L7:
        if (r10.atEnd() == true) goto L19;
        r1.set(61);
        String r5 = r0.parseToken(r7, r10, r1);
        if (r10.atEnd() == true) goto L15;
        char r6 = r7.charAt(r10.getPos());
        r10.updatePos(r10.getPos() + 1);
        if (r6 != '=') goto L15;
        r1.clear(61);
        String r11 = r0.parseToken(r7, r10, r1);
        if (r10.atEnd() == true) goto L17;
        r10.updatePos(r10.getPos() + 1);
    L17:
        if (r5.isEmpty() == true) goto L7;
        r3.add(new BasicNameValuePair(decodeFormFields(r5, r8), decodeFormFields(r11, r8)));
    L15:
        r11 = null;
        goto L17
    L19:
        return r3;
    }

    static List<String> splitSegments(CharSequence r6, BitSet r7) {
        ParserCursor r0 = new ParserCursor(0, r6.length());
        if (r0.atEnd() == false) goto L7;
        return Collections.emptyList();
    L7:
        if (r7.get(r6.charAt(r0.getPos())) == false) goto L9;
        r0.updatePos(r0.getPos() + 1);
    L9:
        ArrayList r1 = new ArrayList();
        StringBuilder r3 = new StringBuilder();
    L11:
        if (r0.atEnd() == true) goto L12;
        char r4 = r6.charAt(r0.getPos());
        if (r7.get(r4) == false) goto L17;
        r1.add(r3.toString());
        r3.setLength(0);
    L18:
        r0.updatePos(r0.getPos() + 1);
        goto L11
    L17:
        r3.append(r4);
        goto L18
    L12:
        r1.add(r3.toString());
        return r1;
    }

    static List<String> splitPathSegments(CharSequence r1) {
        return splitSegments(r1, PATH_SEPARATORS);
    }

    public static List<String> parsePathSegments(CharSequence r4, Charset r5) {
        Args.notNull(r4, "Char sequence");
        List<String> r6 = splitPathSegments(r4);
        int r1 = 0;
    L4:
        if (r1 >= r6.size()) goto L10;
        String r2 = r6.get(r1);
        if (r5 == null) goto L8;
        Charset r3 = r5;
    L9:
        r6.set(r1, urlDecode(r2, r3, false));
        r1 = r1 + 1;
        goto L4
    L8:
        r3 = Consts.UTF_8;
        goto L9
    L10:
        return r6;
    }

    public static List<String> parsePathSegments(CharSequence r1) {
        return parsePathSegments(r1, Consts.UTF_8);
    }

    public static String formatSegments(Iterable<String> r5, Charset r6) {
        Args.notNull(r5, "Segments");
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L7;
        String r1 = r7.next();
        r0.append('/').append(urlEncode(r1, r6, PATHSAFE, false));
        goto L4
    L7:
        return r0.toString();
    }

    public static String formatSegments(String... r1) {
        return formatSegments(Arrays.asList(r1), Consts.UTF_8);
    }

    public static String format(List<? extends NameValuePair> r1, String r2) {
        return format(r1, '&', r2);
    }

    public static String format(List<? extends NameValuePair> r4, char r5, String r6) {
        StringBuilder r0 = new StringBuilder();
        Iterator<? extends NameValuePair> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        NameValuePair r1 = r7.next();
        String r2 = encodeFormFields(r1.getName(), r6);
        String r3 = encodeFormFields(r1.getValue(), r6);
        if (r0.length() <= 0) goto L8;
        r0.append(r5);
    L8:
        r0.append(r2);
        if (r3 == null) goto L4;
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r3);
        goto L4
    L12:
        return r0.toString();
    }

    public static String format(Iterable<? extends NameValuePair> r1, Charset r2) {
        return format(r1, '&', r2);
    }

    public static String format(Iterable<? extends NameValuePair> r4, char r5, Charset r6) {
        Args.notNull(r4, "Parameters");
        StringBuilder r0 = new StringBuilder();
        Iterator<? extends NameValuePair> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        NameValuePair r1 = r7.next();
        String r2 = encodeFormFields(r1.getName(), r6);
        String r3 = encodeFormFields(r1.getValue(), r6);
        if (r0.length() <= 0) goto L8;
        r0.append(r5);
    L8:
        r0.append(r2);
        if (r3 == null) goto L4;
        r0.append(NAME_VALUE_SEPARATOR);
        r0.append(r3);
        goto L4
    L12:
        return r0.toString();
    }

    private static List<NameValuePair> createEmptyList() {
        return new ArrayList(0);
    }

    private static String urlEncode(String r3, Charset r4, BitSet r5, boolean r6) {
        if (r3 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        ByteBuffer r7 = r4.encode(r3);
    L7:
        if (r7.hasRemaining() == false) goto L17;
        int r8 = r7.get() & 255;
        if (r5.get(r8) == true) goto L10;
        if (r6 == false) goto L15;
        if (r8 != 32) goto L15;
        r0.append('+');
    L15:
        r0.append("%");
        char r1 = Character.toUpperCase(Character.forDigit((r8 >> 4) & 15, 16));
        char r9 = Character.toUpperCase(Character.forDigit(r8 & 15, 16));
        r0.append(r1);
        r0.append(r9);
        goto L7
    L10:
        r0.append((char) r8);
        goto L7
    L17:
        return r0.toString();
    }

    private static String urlDecode(String r7, Charset r8, boolean r9) {
        if (r7 != null) goto L5;
        return null;
    L5:
        ByteBuffer r0 = ByteBuffer.allocate(r7.length());
        CharBuffer r10 = CharBuffer.wrap(r7);
    L7:
        if (r10.hasRemaining() == false) goto L22;
        char r1 = r10.get();
        if (r1 != '%') goto L17;
        if (r10.remaining() < 2) goto L17;
        char r2 = r10.get();
        char r3 = r10.get();
        int r5 = Character.digit(r2, 16);
        int r4 = Character.digit(r3, 16);
        if (r5 == (-1)) goto L16;
        if (r4 == (-1)) goto L16;
        r0.put((byte) ((r5 << 4) + r4));
    L16:
        r0.put((byte) 37);
        r0.put((byte) r2);
        r0.put((byte) r3);
    L17:
        if (r9 == false) goto L21;
        if (r1 != '+') goto L21;
        r0.put((byte) 32);
    L21:
        r0.put((byte) r1);
        goto L7
    L22:
        r0.flip();
        return r8.decode(r0).toString();
    }

    private static String decodeFormFields(String r1, String r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 == null) goto L7;
        Charset r3 = Charset.forName(r2);
    L9:
        return urlDecode(r1, r3, true);
    L7:
        r3 = Consts.UTF_8;
        goto L9
    }

    private static String decodeFormFields(String r1, Charset r2) {
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r2 != null) goto L9;
        r2 = Consts.UTF_8;
    L9:
        return urlDecode(r1, r2, true);
    }

    private static String encodeFormFields(String r2, String r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 == null) goto L7;
        Charset r4 = Charset.forName(r3);
    L9:
        return urlEncode(r2, r4, URLENCODER, true);
    L7:
        r4 = Consts.UTF_8;
        goto L9
    }

    private static String encodeFormFields(String r2, Charset r3) {
        if (r2 != null) goto L5;
        return null;
    L5:
        if (r3 != null) goto L9;
        r3 = Consts.UTF_8;
    L9:
        return urlEncode(r2, r3, URLENCODER, true);
    }

    static String encUserInfo(String r2, Charset r3) {
        return urlEncode(r2, r3, USERINFO, false);
    }

    static String encUric(String r2, Charset r3) {
        return urlEncode(r2, r3, URIC, false);
    }

    static String encPath(String r2, Charset r3) {
        return urlEncode(r2, r3, PATH_SPECIAL, false);
    }
}
