package okhttp3.internal.http;

import a.a;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.ss.android.http.legacy.protocol.HTTP;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
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
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = null;
    private static final ByteString TOKEN_DELIMITERS = null;

    static {
        ByteString.Companion r0 = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = r0.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = r0.encodeUtf8("\t ,=");
    }

    @Deprecated
    public static final boolean hasBody(@NotNull Response r1) {
        Intrinsics.f(r1, ApmTrafficStats.TTNET_RESPONSE);
        return promisesBody(r1);
    }

    @NotNull
    public static final List<Challenge> parseChallenges(@NotNull Headers r7, @NotNull String r8) {
        Intrinsics.f(r7, "$this$parseChallenges");
        Intrinsics.f(r8, "headerName");
        ArrayList r0 = new ArrayList();
        int r1 = r7.size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L12;
        if (r8.equalsIgnoreCase(r7.name(r2)) == false) goto L11;
        readChallengeHeader(new Buffer().writeUtf8(r7.value(r2)), r0);     // Catch: EOFException -> L9
    L9:
        e = move-exception;
        Platform.Companion.get().log("Unable to parse challenge", 5, e);
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        return r0;
    }

    public static final boolean promisesBody(@NotNull Response r8) {
        Intrinsics.f(r8, "$this$promisesBody");
        if (Intrinsics.a(r8.request().method(), HttpMethodContrants.HEAD) == false) goto L5;
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
        if (HTTP.CHUNK_CODING.equalsIgnoreCase(Response.header$default(r8, HTTP.TRANSFER_ENCODING, null, 2, null)) == true) goto L20;
        return false;
    L10:
        if (r0 == 204) goto L15;
        if (r0 == 304) goto L15;
        return true;
    }

    private static final void readChallengeHeader(Buffer r7, List<Challenge> r8) {
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
        byte r4 = (byte) 61;
        int r5 = Util.skipAll(r7, r4);
        boolean r6 = skipCommasAndWhitespace(r7);
        if (r2 == true) goto L21;
        if (r6 == true) goto L20;
        if (r7.exhausted() == false) goto L21;
    L20:
        StringBuilder r9 = a.q(r3);
        r9.append(StringsKt.A(r5, "="));
        Map r10 = Collections.singletonMap(null, r9.toString());
        Intrinsics.e(r10, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
        r8.add(new Challenge(r1, r10));
    L21:
        LinkedHashMap r11 = new LinkedHashMap();
        int r12 = Util.skipAll(r7, r4) + r5;
    L22:
        if (r3 != null) goto L27;
        r3 = readToken(r7);
        if (skipCommasAndWhitespace(r7) == true) goto L28;
        r12 = Util.skipAll(r7, r4);
    L28:
        r8.add(new Challenge(r1, r11));
        r1 = r3;
    L27:
        if (r12 == 0) goto L28;
        if (r12 > 1) goto L31;
        if (skipCommasAndWhitespace(r7) == true) goto L34;
        if (startsWith(r7, (byte) 34) == false) goto L38;
        String r13 = readQuotedString(r7);
    L39:
        if (r13 == null) goto L49;
        if (((String) r11.put(r3, r13)) != null) goto L42;
        if (skipCommasAndWhitespace(r7) == true) goto L48;
        if (r7.exhausted() == true) goto L48;
        return;
    L48:
        r3 = null;
        goto L22
    L42:
        return;
    L49:
        return;
    L38:
        r13 = readToken(r7);
        goto L39
    L34:
        return;
    L31:
        return;
    L11:
        if (r7.exhausted() == true) goto L13;
        return;
    L13:
        r8.add(new Challenge(r1, MapsKt.b()));
    }

    private static final String readQuotedString(Buffer r12) {
        byte r1 = (byte) 34;
        if (r12.readByte() != r1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L20;
        Buffer r2 = new Buffer();
    L8:
        long r3 = r12.indexOfElement(QUOTED_STRING_DELIMITERS);
        if (r3 == (-1)) goto L10;
        if (r12.getByte(r3) == r1) goto L13;
        if (r12.size() == (r3 + 1)) goto L17;
        r2.write(r12, r3);
        r12.readByte();
        r2.write(r12, 1);
        goto L8
    L17:
        return null;
    L13:
        r2.write(r12, r3);
        r12.readByte();
        return r2.readUtf8();
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

    public static final void receiveHeaders(@NotNull CookieJar r1, @NotNull HttpUrl r2, @NotNull Headers r3) {
        Intrinsics.f(r1, "$this$receiveHeaders");
        Intrinsics.f(r2, "url");
        Intrinsics.f(r3, "headers");
        if (r1 != CookieJar.NO_COOKIES) goto L5;
        return;
    L5:
        List<Cookie> r4 = Cookie.Companion.parseAll(r2, r3);
        if (r4.isEmpty() == false) goto L8;
        return;
    L8:
        r1.saveFromResponse(r2, r4);
    }

    private static final boolean skipCommasAndWhitespace(Buffer r3) {
        boolean r0 = false;
    L4:
        if (r3.exhausted() == true) goto L14;
        byte r1 = r3.getByte(0);
        if (r1 == 9) goto L13;
        if (r1 == 32) goto L13;
        if (r1 != 44) goto L14;
        r3.readByte();
        r0 = true;
    L13:
        r3.readByte();
    L14:
        return r0;
    }

    private static final boolean startsWith(Buffer r2, byte r3) {
        if (r2.exhausted() == false) goto L5;
    L7:
        return false;
    L5:
        if (r2.getByte(0) != r3) goto L7;
        return true;
    }
}
