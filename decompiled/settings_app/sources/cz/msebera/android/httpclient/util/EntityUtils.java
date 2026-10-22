package cz.msebera.android.httpclient.util;

import cz.msebera.android.httpclient.HeaderElement;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.ParseException;
import cz.msebera.android.httpclient.entity.ContentType;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: loaded from: classes5.dex */
public final class EntityUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    private EntityUtils() {
    }

    public static void consumeQuietly(HttpEntity r0) {
        consume(r0);     // Catch: IOException -> L4
        return;
    }

    public static void consume(HttpEntity r1) throws IOException {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.isStreaming() == false) goto L10;
        InputStream r2 = r1.getContent();
        if (r2 == null) goto L11;
        r2.close();
        return;
    L11:
        return;
    }

    public static void updateEntity(HttpResponse r1, HttpEntity r2) throws IOException {
        Args.notNull(r1, "Response");
        consume(r1.getEntity());
        r1.setEntity(r2);
    }

    public static byte[] toByteArray(HttpEntity r5) throws IOException {
        Args.notNull(r5, "Entity");
        InputStream r0 = r5.getContent();
        if (r0 != null) goto L23;
        return null;
    L23:
    L20:
        th = move-exception;
        r0.close();
        throw th;
    L7:
        if (r5.getContentLength() > 2147483647L) goto L9;
        boolean r1 = true;
    L10:
        Args.check(r1, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L20
        int r6 = (int) r5.getContentLength();     // Catch: Throwable -> L20
        if (r6 >= 0) goto L13;
        r6 = 4096;
    L13:
        ByteArrayBuffer r3 = new ByteArrayBuffer(r6);     // Catch: Throwable -> L20
        byte[] r7 = new byte[4096];     // Catch: Throwable -> L20
    L14:
        int r2 = r0.read(r7);     // Catch: Throwable -> L20
        if (r2 == (-1)) goto L17;
        r3.append(r7, 0, r2);     // Catch: Throwable -> L20
        goto L14
    L17:
        byte[] r8 = r3.toByteArray();     // Catch: Throwable -> L20
        r0.close();
        return r8;
    L9:
        r1 = false;
        goto L10
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity r1) throws ParseException {
        Args.notNull(r1, "Entity");
        if (r1.getContentType() == null) goto L9;
        HeaderElement[] r2 = r1.getContentType().getElements();
        if (r2.length <= 0) goto L9;
        NameValuePair r3 = r2[0].getParameterByName("charset");
        if (r3 == null) goto L9;
        return r3.getValue();
    L9:
        return null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity r1) throws ParseException {
        Args.notNull(r1, "Entity");
        if (r1.getContentType() == null) goto L7;
        HeaderElement[] r2 = r1.getContentType().getElements();
        if (r2.length <= 0) goto L7;
        return r2[0].getName();
    L7:
        return null;
    }

    private static String toString(HttpEntity r6, ContentType r7) throws IOException {
        InputStream r0 = r6.getContent();
        Charset r1 = null;
        if (r0 != null) goto L31;
        return null;
    L31:
    L28:
        th = move-exception;
        r0.close();
        throw th;
    L6:
        if (r6.getContentLength() > 2147483647L) goto L8;
        boolean r2 = true;
    L9:
        Args.check(r2, "HTTP entity too large to be buffered in memory");     // Catch: Throwable -> L28
        int r8 = (int) r6.getContentLength();     // Catch: Throwable -> L28
        if (r8 >= 0) goto L12;
        r8 = 4096;
    L12:
        if (r7 == null) goto L19;
        Charset r3 = r7.getCharset();     // Catch: Throwable -> L28
        if (r3 != null) goto L18;
        ContentType r9 = ContentType.getByMimeType(r7.getMimeType());     // Catch: Throwable -> L28
        if (r9 == null) goto L19;
        r1 = r9.getCharset();     // Catch: Throwable -> L28
        goto L19
    L18:
        r1 = r3;
    L19:
        if (r1 != null) goto L21;
        r1 = HTTP.DEF_CONTENT_CHARSET;     // Catch: Throwable -> L28
    L21:
        InputStreamReader r10 = new InputStreamReader(r0, r1);     // Catch: Throwable -> L28
        CharArrayBuffer r4 = new CharArrayBuffer(r8);     // Catch: Throwable -> L28
        char[] r11 = new char[1024];     // Catch: Throwable -> L28
    L22:
        int r5 = r10.read(r11);     // Catch: Throwable -> L28
        if (r5 == (-1)) goto L25;
        r4.append(r11, 0, r5);     // Catch: Throwable -> L28
        goto L22
    L25:
        String r12 = r4.toString();     // Catch: Throwable -> L28
        r0.close();
        return r12;
    L8:
        r2 = false;
        goto L9
    }

    public static String toString(HttpEntity r2, Charset r3) throws IOException, ParseException {
        Args.notNull(r2, "Entity");
        ContentType r0 = ContentType.get(r2);     // Catch: UnsupportedCharsetException -> L5
    L8:
        if (r0 != null) goto L10;
        r0 = ContentType.DEFAULT_TEXT.withCharset(r3);
    L14:
        return toString(r2, r0);
    L10:
        if (r0.getCharset() != null) goto L14;
        r0 = r0.withCharset(r3);
    L5:
        e = move-exception;
        if (r3 == null) goto L16;
        r0 = null;
        goto L8
    L16:
        throw new UnsupportedEncodingException(e.getMessage());
    }

    public static String toString(HttpEntity r0, String r1) throws IOException, ParseException {
        if (r1 == null) goto L4;
        Charset r2 = Charset.forName(r1);
    L6:
        return toString(r0, r2);
    L4:
        r2 = null;
        goto L6
    }

    public static String toString(HttpEntity r1) throws IOException, ParseException {
        Args.notNull(r1, "Entity");
        return toString(r1, ContentType.get(r1));
    }
}
