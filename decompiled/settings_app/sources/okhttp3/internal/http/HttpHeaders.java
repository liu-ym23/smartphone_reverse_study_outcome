package okhttp3.internal.http;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.io.encoding.Base64;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

/* JADX INFO: compiled from: HttpHeaders.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\n\u0010\r\u001a\u00020\u0004*\u00020\u0006\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\f*\u00020\u0010H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u000f*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u0004*\u00020\u0010H\u0002\u001a\u0014\u0010\u001b\u001a\u00020\u0004*\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", ApmTrafficStats.TTNET_RESPONSE, "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", "prefix", "", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = null;
    private static final ByteString TOKEN_DELIMITERS = null;

    static {
        QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8(BasicHeaderValueFormatter.UNSAFE_CHARS);
        TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");
    }

    public static final List<Challenge> parseChallenges(Headers r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "headerName");
        ArrayList r0 = new ArrayList();
        int r1 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        int r3 = r2 + 1;
        if (StringsKt.equals(r8, r7.name(r2), true) == false) goto L11;
        readChallengeHeader(new Buffer().writeUtf8(r7.value(r2)), r0);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        Platform.Companion.get().log("Unable to parse challenge", 5, e);
    L11:
        r2 = r3;
        goto L3
    L12:
        return r0;
    }

    private static final void readChallengeHeader(Buffer r7, List<Challenge> r8) throws EOFException {
    L3:
        String r1 = null;
    L4:
        if (r1 != null) goto L8;
        skipCommasAndWhitespace(r7);
        r1 = readToken(r7);
        if (r1 != null) goto L8;
        return;
    L8:
        boolean r2 = skipCommasAndWhitespace(r7);
        String r3 = readToken(r7);
        if (r3 == null) goto L11;
        int r5 = Util.skipAll(r7, Base64.padSymbol);
        boolean r6 = skipCommasAndWhitespace(r7);
        if (r2 == true) goto L21;
        if (r6 == true) goto L20;
        if (r7.exhausted() == false) goto L21;
    L20:
        Map r4 = Collections.singletonMap(null, Intrinsics.stringPlus(r3, StringsKt.repeat("=", r5)));
        Intrinsics.checkNotNullExpressionValue(r4, "singletonMap<String, Str…ek + \"=\".repeat(eqCount))");
        r8.add(new Challenge(r1, r4));
    L21:
        LinkedHashMap r9 = new LinkedHashMap();
        int r10 = r5 + Util.skipAll(r7, Base64.padSymbol);
    L22:
        if (r3 != null) goto L27;
        r3 = readToken(r7);
        if (skipCommasAndWhitespace(r7) == true) goto L28;
        r10 = Util.skipAll(r7, Base64.padSymbol);
    L28:
        r8.add(new Challenge(r1, r9));
        r1 = r3;
    L27:
        if (r10 == 0) goto L28;
        if (r10 > 1) goto L31;
        if (skipCommasAndWhitespace(r7) == true) goto L34;
        if (startsWith(r7, (byte) 34) == false) goto L38;
        String r11 = readQuotedString(r7);
    L39:
        if (r11 == null) goto L40;
        if (((String) r9.put(r3, r11)) != null) goto L43;
        if (skipCommasAndWhitespace(r7) == true) goto L49;
        if (r7.exhausted() == true) goto L49;
        return;
    L49:
        r3 = null;
        goto L22
    L43:
        return;
    L40:
        return;
    L38:
        r11 = readToken(r7);
        goto L39
    L34:
        return;
    L31:
        return;
    L11:
        if (r7.exhausted() == true) goto L13;
        return;
    L13:
        r8.add(new Challenge(r1, MapsKt.emptyMap()));
    }

    private static final boolean skipCommasAndWhitespace(Buffer r5) {
        boolean r1 = false;
    L4:
        if (r5.exhausted() == true) goto L17;
        byte r2 = r5.getByte(0);
        boolean r4 = true;
        if (r2 == 44) goto L7;
        if (r2 != 32) goto L12;
    L15:
        if (r4 == false) goto L17;
        r5.readByte();
        goto L4
    L12:
        if (r2 == 9) goto L15;
        r4 = false;
        goto L15
    L7:
        r5.readByte();
        r1 = true;
    L17:
        return r1;
    }

    private static final boolean startsWith(Buffer r2, byte r3) {
        if (r2.exhausted() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.getByte(0) != r3) goto L7;
        return true;
    }

    private static final String readQuotedString(Buffer r12) throws EOFException {
        if (r12.readByte() != 34) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        Buffer r1 = new Buffer();
    L8:
        long r2 = r12.indexOfElement(QUOTED_STRING_DELIMITERS);
        if (r2 == (-1)) goto L10;
        if (r12.getByte(r2) == 34) goto L13;
        if (r12.size() == (r2 + 1)) goto L17;
        r1.write(r12, r2);
        r12.readByte();
        r1.write(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r1.write(r12, r2);
        r12.readByte();
        return r1.readUtf8();
    L10:
        return null;
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final String readToken(Buffer r4) {
        long r0 = r4.indexOfElement(TOKEN_DELIMITERS);
        if (r0 != (-1)) goto L6;
        r0 = r4.size();
    L6:
        if (r0 != 0) goto L10;
        return null;
    L10:
        return r4.readUtf8(r0);
    }

    public static final void receiveHeaders(CookieJar r1, HttpUrl r2, Headers r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "headers");
        if (r1 != CookieJar.NO_COOKIES) goto L5;
        return;
    L5:
        List<Cookie> r4 = Cookie.Companion.parseAll(r2, r3);
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        r1.saveFromResponse(r2, r4);
    }

    public static final boolean promisesBody(Response r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        if (Intrinsics.areEqual(r8.request().method(), "HEAD") == false) goto L5;
        return false;
    L5:
        int r0 = r8.code();
        if (r0 < 100) goto L10;
        if (r0 >= 200) goto L10;
    L15:
        if (Util.headersContentLength(r8) == (-1)) goto L17;
    L20:
        return true;
    L17:
        if (StringsKt.equals("chunked", Response.header$default(r8, "Transfer-Encoding", null, 2, null), true) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(Response r1) {
        Intrinsics.checkNotNullParameter(r1, ApmTrafficStats.TTNET_RESPONSE);
        return promisesBody(r1);
    }
}
