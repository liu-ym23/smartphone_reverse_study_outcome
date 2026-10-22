package cz.msebera.android.httpclient.entity;

import coil.util.Utils;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import cz.msebera.android.httpclient.message.BasicHeaderValueParser;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.message.ParserCursor;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.CharArrayBuffer;
import cz.msebera.android.httpclient.util.TextUtils;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes5.dex */
public final class ContentType implements Serializable {
    public static final ContentType APPLICATION_ATOM_XML = null;
    public static final ContentType APPLICATION_FORM_URLENCODED = null;
    public static final ContentType APPLICATION_JSON = null;
    public static final ContentType APPLICATION_OCTET_STREAM = null;
    public static final ContentType APPLICATION_SVG_XML = null;
    public static final ContentType APPLICATION_XHTML_XML = null;
    public static final ContentType APPLICATION_XML = null;
    private static final Map<String, ContentType> CONTENT_TYPE_MAP = null;
    public static final ContentType DEFAULT_BINARY = null;
    public static final ContentType DEFAULT_TEXT = null;
    public static final ContentType IMAGE_BMP = null;
    public static final ContentType IMAGE_GIF = null;
    public static final ContentType IMAGE_JPEG = null;
    public static final ContentType IMAGE_PNG = null;
    public static final ContentType IMAGE_SVG = null;
    public static final ContentType IMAGE_TIFF = null;
    public static final ContentType IMAGE_WEBP = null;
    public static final ContentType MULTIPART_FORM_DATA = null;
    public static final ContentType TEXT_HTML = null;
    public static final ContentType TEXT_PLAIN = null;
    public static final ContentType TEXT_XML = null;
    public static final ContentType WILDCARD = null;
    private static final long serialVersionUID = -7768694718232371896L;
    private final Charset charset;
    private final String mimeType;
    private final NameValuePair[] params;

    static {
        ContentType r0 = create("application/atom+xml", Consts.ISO_8859_1);
        APPLICATION_ATOM_XML = r0;
        ContentType r1 = create("application/x-www-form-urlencoded", Consts.ISO_8859_1);
        APPLICATION_FORM_URLENCODED = r1;
        ContentType r2 = create(RequestParams.APPLICATION_JSON, Consts.UTF_8);
        APPLICATION_JSON = r2;
        Charset r4 = (Charset) null;
        APPLICATION_OCTET_STREAM = create("application/octet-stream", null);
        ContentType r5 = create("application/svg+xml", Consts.ISO_8859_1);
        APPLICATION_SVG_XML = r5;
        ContentType r6 = create("application/xhtml+xml", Consts.ISO_8859_1);
        APPLICATION_XHTML_XML = r6;
        ContentType r7 = create("application/xml", Consts.ISO_8859_1);
        APPLICATION_XML = r7;
        ContentType r8 = create("image/bmp");
        IMAGE_BMP = r8;
        ContentType r9 = create("image/gif");
        IMAGE_GIF = r9;
        ContentType r10 = create(Utils.MIME_TYPE_JPEG);
        IMAGE_JPEG = r10;
        ContentType r11 = create("image/png");
        IMAGE_PNG = r11;
        ContentType r12 = create("image/svg+xml");
        IMAGE_SVG = r12;
        ContentType r13 = create("image/tiff");
        IMAGE_TIFF = r13;
        ContentType r14 = create(Utils.MIME_TYPE_WEBP);
        IMAGE_WEBP = r14;
        ContentType r15 = create("multipart/form-data", Consts.ISO_8859_1);
        MULTIPART_FORM_DATA = r15;
        ContentType r3 = create("text/html", Consts.ISO_8859_1);
        TEXT_HTML = r3;
        ContentType r16 = create("text/plain", Consts.ISO_8859_1);
        TEXT_PLAIN = r16;
        ContentType r17 = create("text/xml", Consts.ISO_8859_1);
        TEXT_XML = r17;
        WILDCARD = create("*/*", null);
        ContentType[] r18 = {r0, r1, r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r3, r16, r17};
        HashMap r19 = new HashMap();
        int r20 = 0;
    L3:
        if (r20 >= 17) goto L5;
        ContentType r21 = r18[r20];
        r19.put(r21.getMimeType(), r21);
        r20 = r20 + 1;
        goto L3
    L5:
        CONTENT_TYPE_MAP = Collections.unmodifiableMap(r19);
        DEFAULT_TEXT = TEXT_PLAIN;
        DEFAULT_BINARY = APPLICATION_OCTET_STREAM;
    }

    ContentType(String r1, Charset r2) {
        this.mimeType = r1;
        this.charset = r2;
        this.params = null;
    }

    ContentType(String r1, Charset r2, NameValuePair[] r3) {
        this.mimeType = r1;
        this.charset = r2;
        this.params = r3;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getParameter(String r6) {
        Args.notEmpty(r6, "Parameter name");
        NameValuePair[] r5 = this.params;
        if (r5 != null) goto L5;
        return null;
    L5:
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        NameValuePair r3 = r5[r2];
        if (r3.getName().equalsIgnoreCase(r6) == true) goto L10;
        r2 = r2 + 1;
        goto L6
    L10:
        return r3.getValue();
    L12:
        return null;
    }

    public String toString() {
        CharArrayBuffer r0 = new CharArrayBuffer(64);
        r0.append(this.mimeType);
        if (this.params == null) goto L6;
        r0.append(VectorFormat.DEFAULT_SEPARATOR);
        BasicHeaderValueFormatter.INSTANCE.formatParameters(r0, this.params, false);
    L9:
        return r0.toString();
    L6:
        if (this.charset == null) goto L9;
        r0.append("; charset=");
        r0.append(this.charset.name());
        goto L9
    }

    private static boolean valid(String r4) {
        int r1 = 0;
    L4:
        if (r1 >= r4.length()) goto L14;
        char r2 = r4.charAt(r1);
        if (r2 == '\"') goto L13;
        if (r2 == ',') goto L13;
        if (r2 == ';') goto L13;
        r1 = r1 + 1;
    L13:
        return false;
    L14:
        return true;
    }

    public static ContentType create(String r2, Charset r3) {
        String r4 = ((String) Args.notBlank(r2, "MIME type")).toLowerCase(Locale.ROOT);
        Args.check(valid(r4), "MIME type may not contain reserved characters");
        return new ContentType(r4, r3);
    }

    public static ContentType create(String r2) {
        Charset r1 = (Charset) null;
        return create(r2, null);
    }

    public static ContentType create(String r1, String r2) throws UnsupportedCharsetException {
        if (TextUtils.isBlank(r2) == true) goto L5;
        Charset r3 = Charset.forName(r2);
    L7:
        return create(r1, r3);
    L5:
        r3 = null;
        goto L7
    }

    private static ContentType create(HeaderElement r1, boolean r2) {
        return create(r1.getName(), r1.getParameters(), r2);
    }

    private static ContentType create(String r6, NameValuePair[] r7, boolean r8) {
        int r0 = r7.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L16;
        NameValuePair r3 = r7[r1];
        if (r3.getName().equalsIgnoreCase("charset") == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        String r2 = r3.getValue();
        if (TextUtils.isBlank(r2) == true) goto L16;
        Charset r9 = Charset.forName(r2);     // Catch: UnsupportedCharsetException -> L11
    L18:
        if (r7 != null) goto L20;
    L22:
        r7 = null;
    L24:
        return new ContentType(r6, r9, r7);
    L20:
        if (r7.length <= 0) goto L22;
    L11:
        e = move-exception;
        if (r8 == false) goto L16;
        throw e;
    L16:
        r9 = null;
        goto L18
    }

    public static ContentType create(String r2, NameValuePair... r3) throws UnsupportedCharsetException {
        Args.check(valid(((String) Args.notBlank(r2, "MIME type")).toLowerCase(Locale.ROOT)), "MIME type may not contain reserved characters");
        return create(r2, r3, true);
    }

    public static ContentType parse(String r4) throws ParseException, UnsupportedCharsetException {
        Args.notNull(r4, "Content type");
        CharArrayBuffer r0 = new CharArrayBuffer(r4.length());
        r0.append(r4);
        HeaderElement[] r1 = BasicHeaderValueParser.INSTANCE.parseElements(r0, new ParserCursor(0, r4.length()));
        if (r1.length <= 0) goto L7;
        return create(r1[0], true);
    L7:
        throw new ParseException("Invalid content type: " + r4);
    }

    public static ContentType get(HttpEntity r2) throws ParseException, UnsupportedCharsetException {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = r2.getContentType();
        if (r3 == null) goto L11;
        HeaderElement[] r4 = r3.getElements();
        if (r4.length <= 0) goto L11;
        return create(r4[0], true);
    L11:
        return null;
    }

    public static ContentType getLenient(HttpEntity r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        Header r3 = r2.getContentType();
        if (r3 != null) goto L13;
    L11:
        return null;
    L13:
        HeaderElement[] r4 = r3.getElements();     // Catch: ParseException -> L12
        if (r4.length <= 0) goto L11;
        return create(r4[0], false);
    }

    public static ContentType getOrDefault(HttpEntity r0) throws ParseException, UnsupportedCharsetException {
        ContentType r1 = get(r0);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return DEFAULT_TEXT;
    }

    public static ContentType getLenientOrDefault(HttpEntity r0) throws ParseException, UnsupportedCharsetException {
        ContentType r1 = get(r0);
        if (r1 == null) goto L6;
        return r1;
    L6:
        return DEFAULT_TEXT;
    }

    public static ContentType getByMimeType(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return CONTENT_TYPE_MAP.get(r1);
    }

    public ContentType withCharset(Charset r1) {
        return create(getMimeType(), r1);
    }

    public ContentType withCharset(String r1) {
        return create(getMimeType(), r1);
    }

    public ContentType withParameters(NameValuePair... r8) throws UnsupportedCharsetException {
        if (r8.length != 0) goto L5;
        return this;
    L5:
        LinkedHashMap r0 = new LinkedHashMap();
        NameValuePair[] r1 = this.params;
        int r2 = 0;
        if (r1 == null) goto L10;
        int r3 = r1.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L10;
        NameValuePair r5 = r1[r4];
        r0.put(r5.getName(), r5.getValue());
        r4 = r4 + 1;
    L10:
        int r6 = r8.length;
    L11:
        if (r2 >= r6) goto L13;
        NameValuePair r7 = r8[r2];
        r0.put(r7.getName(), r7.getValue());
        r2 = r2 + 1;
        goto L11
    L13:
        ArrayList r9 = new ArrayList(r0.size() + 1);
        if (this.charset != null) goto L16;
    L18:
        Iterator r10 = r0.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L23;
        Map.Entry r11 = (Map.Entry) r10.next();
        r9.add(new BasicNameValuePair((String) r11.getKey(), (String) r11.getValue()));
        goto L20
    L23:
        return create(getMimeType(), (NameValuePair[]) r9.toArray(new NameValuePair[r9.size()]), true);
    L16:
        if (r0.containsKey("charset") == true) goto L18;
        r9.add(new BasicNameValuePair("charset", this.charset.name()));
        goto L18
    }
}
