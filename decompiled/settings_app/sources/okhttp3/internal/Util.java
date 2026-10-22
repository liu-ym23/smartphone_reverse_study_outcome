package okhttp3.internal;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.android.settings.wifi.WifiSettings;
import com.android.settingslib.accessibility.AccessibilityUtils;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000¸\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\bø\u0001\u0000\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007¢\u0006\u0002\u0010+\u001a\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011\u001a1\u0010-\u001a\u0004\u0018\u0001H)\"\u0004\b\u0000\u0010)2\u0006\u0010.\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H)002\u0006\u00101\u001a\u00020\u0011¢\u0006\u0002\u00102\u001a\u0016\u00103\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000f\u001a\"\u00106\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\u0086\bø\u0001\u0000\u001a%\u00107\u001a\u00020\u001b\"\u0004\b\u0000\u00108*\b\u0012\u0004\u0012\u0002H8092\u0006\u0010:\u001a\u0002H8H\u0000¢\u0006\u0002\u0010;\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020=2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0017*\u00020\u00142\u0006\u0010>\u001a\u00020\u0017H\u0086\u0004\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020?2\u0006\u0010>\u001a\u00020\u0014H\u0086\u0004\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\r\u0010C\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\r\u0010D\u001a\u00020\u001b*\u00020\"H\u0080\b\u001a\n\u0010E\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010F\u001a\u00020\u000f*\u00020G2\u0006\u0010H\u001a\u00020G\u001a\n\u0010I\u001a\u00020\u001b*\u00020J\u001a\n\u0010I\u001a\u00020\u001b*\u00020K\u001a\n\u0010I\u001a\u00020\u001b*\u00020L\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u0011¢\u0006\u0002\u0010O\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010U\u001a\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001a\u0010V\u001a\u00020\u000f*\u00020W2\u0006\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a;\u0010Z\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0[2\u0017\u0010\\\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0]¢\u0006\u0002\b^H\u0086\bø\u0001\u0000\u001a5\u0010_\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u000e\u0010`\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110a¢\u0006\u0002\u0010b\u001a\n\u0010c\u001a\u00020\u0017*\u00020d\u001a+\u0010e\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u00112\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110a¢\u0006\u0002\u0010f\u001a\n\u0010g\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010h\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001e\u0010i\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u0014\u0010j\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u0014\u001a9\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010`\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00110a¢\u0006\u0002\u0010l\u001a\u0012\u0010m\u001a\u00020\u000f*\u00020n2\u0006\u0010o\u001a\u00020p\u001a\u0012\u0010q\u001a\u00020\u000f*\u00020L2\u0006\u0010r\u001a\u00020s\u001a\r\u0010t\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\r\u0010u\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a\n\u0010v\u001a\u00020\u0014*\u00020R\u001a\n\u0010w\u001a\u00020\u0011*\u00020L\u001a\u0012\u0010x\u001a\u00020y*\u00020s2\u0006\u0010z\u001a\u00020y\u001a\n\u0010{\u001a\u00020\u0014*\u00020s\u001a\u0012\u0010|\u001a\u00020\u0014*\u00020}2\u0006\u0010~\u001a\u00020=\u001a\u001a\u0010|\u001a\u00020\u000f*\u00020W2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a\u0011\u0010\u007f\u001a\t\u0012\u0005\u0012\u00030\u0080\u00010(*\u00020\u0003\u001a\u0012\u0010\u0081\u0001\u001a\u00020\u0003*\t\u0012\u0005\u0012\u00030\u0080\u00010(\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0011*\u00020\u0014\u001a\u000b\u0010\u0082\u0001\u001a\u00020\u0011*\u00020\u0017\u001a\u0016\u0010\u0083\u0001\u001a\u00020\u0011*\u00020G2\t\b\u0002\u0010\u0084\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b\u0000\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u0086\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0088\u0001\u0012\u0005\u0012\u0003H\u0089\u00010\u0087\u0001\"\u0005\b\u0000\u0010\u0088\u0001\"\u0005\b\u0001\u0010\u0089\u0001*\u0011\u0012\u0005\u0012\u0003H\u0088\u0001\u0012\u0005\u0012\u0003H\u0089\u00010\u0087\u0001\u001a\u0014\u0010\u008a\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0017\u001a\u0016\u0010\u008c\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u008b\u0001\u001a\u00020\u0014\u001a\u001f\u0010\u008d\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u000e\u0010\u008e\u0001\u001a\u00020\u001b*\u00020\"H\u0086\b\u001a'\u0010\u008f\u0001\u001a\u00030\u0090\u0001*\b0\u0091\u0001j\u0003`\u0092\u00012\u0013\u0010\u0093\u0001\u001a\u000e\u0012\n\u0012\b0\u0091\u0001j\u0003`\u0092\u00010(\u001a\u0015\u0010\u0094\u0001\u001a\u00020\u001b*\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u0014\"\u0010\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u00118\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0097\u0001"}, d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "userAgent", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", WifiSettings.ScannerIntentResult_BARCODE_FORMAT, "args", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", ExifInterface.GPS_DIRECTION_TRUE, "elements", "([Ljava/lang/Object;)Ljava/util/List;", "isSensitiveHeader", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", PluralRules.KEYWORD_OTHER, "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", ClientCookie.DISCARD_ATTR, "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", "file", "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final Headers EMPTY_HEADERS = null;
    public static final RequestBody EMPTY_REQUEST = null;
    public static final ResponseBody EMPTY_RESPONSE = null;
    private static final Options UNICODE_BOMS = null;
    public static final TimeZone UTC = null;
    private static final Regex VERIFY_AS_IP_ADDRESS = null;
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName = null;
    public static final String userAgent = "okhttp/4.11.0";

    /* JADX INFO: renamed from: $r8$lambda$TFmLugqSOE7yNjbs-8gncc5DTI4, reason: not valid java name */
    public static /* synthetic */ Thread m3221$r8$lambda$TFmLugqSOE7yNjbs8gncc5DTI4(String r0, boolean r1, Runnable r2) {
        return m3223threadFactory$lambda1(r0, r1, r2);
    }

    public static /* synthetic */ EventListener $r8$lambda$op7DGXdKtbPW5S_UsqHTJ0nOJEU(EventListener r0, Call r1) {
        return m3222asFactory$lambda8(r0, r1);
    }

    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    public static final int and(short r0, int r1) {
        return r0 & r1;
    }

    public static final long and(int r2, long r3) {
        return ((long) r2) & r3;
    }

    /* JADX INFO: renamed from: asFactory$lambda-8, reason: not valid java name */
    private static final EventListener m3222asFactory$lambda8(EventListener r1, Call r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_asFactory");
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1;
    }

    public static final int parseHexDigit(char r4) {
        boolean r0 = true;
        if ('0' <= r4) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L28;
        char r2 = 'a';
        if ('a' <= r4) goto L13;
    L15:
        boolean r5 = false;
    L16:
        if (r5 == true) goto L29;
        r2 = 'A';
        if ('A' <= r4) goto L21;
    L23:
        r0 = false;
    L24:
        if (r0 == true) goto L29;
        return -1;
    L21:
        if (r4 >= 'G') goto L23;
    L29:
        return (r4 - r2) + 10;
    L13:
        if (r4 >= 'g') goto L15;
        r5 = true;
        goto L16
    L28:
        return r4 - '0';
    L5:
        if (r4 >= ':') goto L7;
        r3 = true;
        goto L8
    }

    static {
        byte[] r2 = new byte[0];
        EMPTY_BYTE_ARRAY = r2;
        EMPTY_HEADERS = Headers.Companion.of(new String[0]);
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, r2, null, 1, null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, r2, null, 0, 0, 7, null);
        UNICODE_BOMS = Options.Companion.of(new ByteString[]{ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000")});
        TimeZone r1 = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(r1);
        UTC = r1;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String r0 = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(r0, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(r0, "okhttp3."), "Client");
    }

    public static final void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final ThreadFactory threadFactory(final String r1, final boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "name");
        return new Util$$ExternalSyntheticLambda0(r1, r2);
    }

    /* JADX INFO: renamed from: threadFactory$lambda-1, reason: not valid java name */
    private static final Thread m3223threadFactory$lambda1(String r1, boolean r2, Runnable r3) {
        Intrinsics.checkNotNullParameter(r1, "$name");
        Thread r0 = new Thread(r3, r1);
        r0.setDaemon(r2);
        return r0;
    }

    public static final String[] intersect(String[] r8, String[] r9, Comparator<? super String> r10) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, PluralRules.KEYWORD_OTHER);
        Intrinsics.checkNotNullParameter(r10, "comparator");
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String r4 = r8[r3];
        r3 = r3 + 1;
        int r5 = r9.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L3;
        String r7 = r9[r6];
        r6 = r6 + 1;
        if (r10.compare(r4, r7) != 0) goto L5;
        r0.add(r4);
        goto L3
    L9:
        Object[] r11 = r0.toArray(new String[0]);
        if (r11 == null) goto L14;
        return (String[]) r11;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean hasIntersection(String[] r7, String[] r8, Comparator<? super String> r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "comparator");
        if (r7.length != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L22;
        if (r8 == null) goto L22;
        if (r8.length != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == true) goto L22;
        int r2 = r7.length;
        int r3 = 0;
    L15:
        if (r3 >= r2) goto L22;
        String r4 = r7[r3];
        r3 = r3 + 1;
        Iterator r5 = ArrayIteratorKt.iterator(r8);
    L18:
        if (r5.hasNext() == false) goto L15;
        if (r9.compare(r4, (String) r5.next()) != 0) goto L18;
        return true;
    L11:
        r1 = false;
    L22:
        return false;
    L5:
        r0 = false;
        goto L6
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return toHostHeader(r0, r1);
    }

    public static final String toHostHeader(HttpUrl r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (StringsKt.contains$default(r5.host(), ":", false, 2, null) == false) goto L5;
        String r0 = "[" + r5.host() + ']';
    L6:
        if (r6 == true) goto L10;
        if (r5.port() != HttpUrl.Companion.defaultPort(r5.scheme())) goto L10;
        return r0;
    L10:
        return r0 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r5.port();
    L5:
        r0 = r5.host();
        goto L6
    }

    public static final String[] concat(String[] r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "value");
        Object[] r3 = Arrays.copyOf(r1, r1.length + 1);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(this, newSize)");
        String[] r4 = (String[]) r3;
        r4[ArraysKt.getLastIndex(r4)] = r2;
        return r4;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return indexOfFirstNonAsciiWhitespace(r0, r1, r2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
    L3:
        if (r6 >= r7) goto L31;
        int r0 = r6 + 1;
        char r1 = r5.charAt(r6);
        boolean r3 = false;
        if (r1 != '\t') goto L8;
    L6:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L14;
    L12:
        boolean r4 = true;
    L17:
        if (r4 == false) goto L20;
    L18:
        boolean r8 = true;
    L23:
        if (r8 == false) goto L26;
    L24:
        r3 = true;
    L28:
        if (r3 == false) goto L30;
        r6 = r0;
        goto L3
    L30:
        return r6;
    L26:
        if (r1 != ' ') goto L28;
    L20:
        if (r1 == '\r') goto L18;
        r8 = false;
        goto L23
    L14:
        if (r1 == '\f') goto L12;
        r4 = false;
        goto L17
    L8:
        if (r1 == '\n') goto L6;
        r2 = false;
        goto L11
    L31:
        return r7;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return indexOfLastNonAsciiWhitespace(r0, r1, r2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String r5, int r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r8 = r7 - 1;
        if (r6 > r8) goto L34;
    L4:
        int r1 = r8 - 1;
        char r2 = r5.charAt(r8);
        boolean r4 = false;
        if (r2 != '\t') goto L8;
    L6:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L14;
    L12:
        boolean r9 = true;
    L17:
        if (r9 == false) goto L20;
    L18:
        boolean r10 = true;
    L23:
        if (r10 == false) goto L26;
    L24:
        r4 = true;
    L28:
        if (r4 == false) goto L33;
        if (r8 == r6) goto L34;
        r8 = r1;
        goto L4
    L33:
        return r8 + 1;
    L26:
        if (r2 != ' ') goto L28;
    L20:
        if (r2 == '\r') goto L18;
        r10 = false;
        goto L23
    L14:
        if (r2 == '\f') goto L12;
        r9 = false;
        goto L17
    L8:
        if (r2 == '\n') goto L6;
        r3 = false;
    L34:
        return r6;
    }

    public static /* synthetic */ String trimSubstring$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return trimSubstring(r0, r1, r2);
    }

    public static final String trimSubstring(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        int r4 = indexOfFirstNonAsciiWhitespace(r1, r2, r3);
        String r5 = r1.substring(r4, indexOfLastNonAsciiWhitespace(r1, r4, r3));
        Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
        return r5;
    }

    public static /* synthetic */ int delimiterOffset$default(String r0, String r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length();
    L9:
        return delimiterOffset(r0, r1, r2, r3);
    }

    public static final int delimiterOffset(String r6, String r7, int r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "delimiters");
    L3:
        if (r8 >= r9) goto L8;
        int r0 = r8 + 1;
        if (StringsKt.contains$default(r7, r6.charAt(r8), false, 2, null) == true) goto L6;
        r8 = r0;
        goto L3
    L6:
        return r8;
    L8:
        return r9;
    }

    public static /* synthetic */ int delimiterOffset$default(String r0, char r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = r0.length();
    L9:
        return delimiterOffset(r0, r1, r2, r3);
    }

    public static final int delimiterOffset(String r2, char r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
    L3:
        if (r4 >= r5) goto L8;
        int r0 = r4 + 1;
        if (r2.charAt(r4) == r3) goto L6;
        r4 = r0;
        goto L3
    L6:
        return r4;
    L8:
        return r5;
    }

    public static final int indexOfControlOrNonAscii(String r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        int r0 = r5.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        int r2 = r1 + 1;
        char r3 = r5.charAt(r1);
        if (Intrinsics.compare(r3, 31) <= 0) goto L10;
        if (Intrinsics.compare(r3, 127) >= 0) goto L10;
        r1 = r2;
    L10:
        return r1;
    L11:
        return -1;
    }

    public static final boolean canParseAsIpAddress(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches(r1);
    }

    public static final boolean isSensitiveHeader(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        if (StringsKt.equals(r2, "Authorization", true) == false) goto L5;
        return true;
    L5:
        if (StringsKt.equals(r2, "Cookie", true) == false) goto L7;
        return true;
    L7:
        if (StringsKt.equals(r2, "Proxy-Authorization", true) == false) goto L9;
        return true;
    L9:
        if (StringsKt.equals(r2, "Set-Cookie", true) == true) goto L16;
        return false;
    L16:
        return true;
    }

    public static final String format(String r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r2, WifiSettings.ScannerIntentResult_BARCODE_FORMAT);
        Intrinsics.checkNotNullParameter(r3, "args");
        StringCompanionObject r0 = StringCompanionObject.INSTANCE;
        Locale r1 = Locale.US;
        Object[] r4 = Arrays.copyOf(r3, r3.length);
        String r5 = String.format(r1, r2, Arrays.copyOf(r4, r4.length));
        Intrinsics.checkNotNullExpressionValue(r5, "format(locale, format, *args)");
        return r5;
    }

    public static final Charset readBomAsCharset(BufferedSource r1, Charset r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "default");
        int r3 = r1.select(UNICODE_BOMS);
        if (r3 == (-1)) goto L21;
        if (r3 != 0) goto L6;
        Charset r4 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(r4, "UTF_8");
        return r4;
    L6:
        if (r3 != 1) goto L8;
        Charset r5 = StandardCharsets.UTF_16BE;
        Intrinsics.checkNotNullExpressionValue(r5, "UTF_16BE");
        return r5;
    L8:
        if (r3 != 2) goto L10;
        Charset r6 = StandardCharsets.UTF_16LE;
        Intrinsics.checkNotNullExpressionValue(r6, "UTF_16LE");
        return r6;
    L10:
        if (r3 == 3) goto L23;
        if (r3 != 4) goto L15;
        return Charsets.INSTANCE.UTF32_LE();
    L15:
        throw new AssertionError();
    L23:
        return Charsets.INSTANCE.UTF32_BE();
    L21:
        return r2;
    }

    public static final int checkDuration(String r7, long r8, TimeUnit r10) {
        Intrinsics.checkNotNullParameter(r7, "name");
        boolean r3 = true;
        if (r8 < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L31;
        if (r10 == null) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L29;
        long r9 = r10.toMillis(r8);
        if (r9 > 2147483647L) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == false) goto L27;
        if (r9 != 0) goto L21;
        if (r8 <= 0) goto L21;
        r3 = false;
    L21:
        if (r3 == false) goto L25;
        return (int) r9;
    L25:
        throw new IllegalArgumentException(Intrinsics.stringPlus(r7, " too small.").toString());
    L27:
        throw new IllegalArgumentException(Intrinsics.stringPlus(r7, " too large.").toString());
    L14:
        r11 = false;
        goto L15
    L29:
        throw new IllegalStateException("unit == null".toString());
    L9:
        r6 = false;
        goto L10
    L31:
        throw new IllegalStateException(Intrinsics.stringPlus(r7, " < 0").toString());
    L5:
        r5 = false;
        goto L6
    }

    public static final Headers toHeaders(List<Header> r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Headers.Builder r0 = new Headers.Builder();
        Iterator<Header> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L7;
        Header r1 = r4.next();
        ByteString r2 = r1.component1();
        ByteString r5 = r1.component2();
        r0.addLenient$okhttp(r2.utf8(), r5.utf8());
        goto L4
    L7:
        return r0.build();
    }

    public static final List<Header> toHeaderList(Headers r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        IntRange r0 = RangesKt.until(0, r5.size());
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<Integer> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        int r3 = ((IntIterator) r2).nextInt();
        r1.add(new Header(r5.name(r3), r5.value(r3)));
        goto L4
    L7:
        return r1;
    }

    public static final boolean canReuseConnectionFor(HttpUrl r2, HttpUrl r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, PluralRules.KEYWORD_OTHER);
        if (Intrinsics.areEqual(r2.host(), r3.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.port() != r3.port()) goto L9;
        if (Intrinsics.areEqual(r2.scheme(), r3.scheme()) == false) goto L9;
        return true;
    }

    public static final EventListener.Factory asFactory(final EventListener r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new Util$$ExternalSyntheticLambda1(r1);
    }

    public static final void writeMedium(BufferedSink r1, int r2) throws IOException {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.writeByte((r2 >>> 16) & 255);
        r1.writeByte((r2 >>> 8) & 255);
        r1.writeByte(r2 & 255);
    }

    public static final int readMedium(BufferedSource r3) throws IOException {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = (and(r3.readByte(), 255) << 16) | (and(r3.readByte(), 255) << 8);
        return and(r3.readByte(), 255) | r0;
    }

    public static final boolean skipAll(Source r11, int r12, TimeUnit r13) throws IOException {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r13, "timeUnit");
        long r0 = System.nanoTime();
        if (r11.timeout().hasDeadline() == false) goto L5;
        long r5 = r11.timeout().deadlineNanoTime() - r0;
    L6:
        r11.timeout().deadlineNanoTime(Math.min(r5, r13.toNanos(r12)) + r0);
        Buffer r14 = new Buffer();     // Catch: Throwable -> L17 InterruptedIOException -> L23
    L9:
        if (r11.read(r14, 8192) == (-1)) goto L13;
        r14.clear();     // Catch: Throwable -> L17 InterruptedIOException -> L23
        goto L24
    L13:
        if (r5 != Long.MAX_VALUE) goto L15;
        r11.timeout().clearDeadline();
    L16:
        return true;
    L15:
        r11.timeout().deadlineNanoTime(r0 + r5);
    L17:
        th = move-exception;
        if (r5 != Long.MAX_VALUE) goto L21;
        r11.timeout().clearDeadline();
    L22:
        throw th;
    L21:
        r11.timeout().deadlineNanoTime(r0 + r5);
    L24:
        if (r5 != Long.MAX_VALUE) goto L26;
        r11.timeout().clearDeadline();
    L27:
        return false;
    L26:
        r11.timeout().deadlineNanoTime(r0 + r5);
        goto L27
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    public static final boolean discard(Source r1, int r2, TimeUnit r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "timeUnit");
        return skipAll(r1, r2, r3);
    L5:
        return false;
    }

    public static final String peerName(Socket r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        SocketAddress r2 = r1.getRemoteSocketAddress();
        if ((r2 instanceof InetSocketAddress) == false) goto L6;
        String r3 = ((InetSocketAddress) r2).getHostName();
        Intrinsics.checkNotNullExpressionValue(r3, "address.hostName");
        return r3;
    L6:
        return r2.toString();
    }

    public static final boolean isHealthy(Socket r2, BufferedSource r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "source");
        int r1 = r2.getSoTimeout();     // Catch: IOException -> L10 SocketTimeoutException -> L12
        r2.setSoTimeout(1);     // Catch: Throwable -> L7
        boolean r4 = !r3.exhausted();
        r2.setSoTimeout(r1);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        return r4;
    L7:
        th = move-exception;
        r2.setSoTimeout(r1);     // Catch: IOException -> L10 SocketTimeoutException -> L12
        throw th;     // Catch: IOException -> L10 SocketTimeoutException -> L12
    L10:
        return false;
    L17:
        return true;
    }

    public static final void ignoreIoExceptions(Function0<Unit> r1) {
        Intrinsics.checkNotNullParameter(r1, "block");
        r1.invoke();     // Catch: IOException -> L5
        return;
    }

    public static final void threadName(String r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "block");
        Thread r0 = Thread.currentThread();
        String r1 = r0.getName();
        r0.setName(r2);
        r3.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r0.setName(r1);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.setName(r1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static final int skipAll(Buffer r3, byte r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        int r0 = 0;
    L4:
        if (r3.exhausted() == true) goto L8;
        if (r3.getByte(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.readByte();
    L8:
        return r0;
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return indexOfNonWhitespace(r0, r1);
    }

    public static final int indexOfNonWhitespace(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = r4.length();
    L3:
        if (r5 >= r0) goto L11;
        int r1 = r5 + 1;
        char r2 = r4.charAt(r5);
        if (r2 == ' ') goto L9;
        if (r2 == '\t') goto L9;
        return r5;
    L9:
        r5 = r1;
        goto L3
    L11:
        return r4.length();
    }

    public static final long headersContentLength(Response r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.headers().get("Content-Length");
        if (r3 != null) goto L6;
        return -1;
    L6:
        return toLongOrDefault(r3, -1);
    }

    public static final long toLongOrDefault(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return Long.parseLong(r1);
    L8:
        return r2;
    }

    public static final int toNonNegativeInt(String r2, int r3) {
        if (r2 != null) goto L17;
        Long r4 = null;
    L5:
        if (r4 != null) goto L7;
        return r3;
    L7:
        long r5 = r4.longValue();     // Catch: NumberFormatException -> L16
        if (r5 <= 2147483647L) goto L12;
        return Integer.MAX_VALUE;
    L12:
        if (r5 >= 0) goto L15;
        return 0;
    L15:
        return (int) r5;
    L16:
        return r3;
    L17:
        r4 = Long.valueOf(Long.parseLong(r2));     // Catch: NumberFormatException -> L16
        goto L5
    }

    public static final <T> List<T> toImmutableList(List<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        List<T> r2 = Collections.unmodifiableList(CollectionsKt.toMutableList(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "unmodifiableList(toMutableList())");
        return r2;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... r1) {
        Intrinsics.checkNotNullParameter(r1, "elements");
        Object[] r2 = (Object[]) r1.clone();
        List<T> r3 = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(r2, r2.length)));
        Intrinsics.checkNotNullExpressionValue(r3, "unmodifiableList(listOf(*elements.clone()))");
        return r3;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.isEmpty() == true) goto L7;
        Map<K, V> r2 = Collections.unmodifiableMap(new LinkedHashMap(r1));
        Intrinsics.checkNotNullExpressionValue(r2, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return r2;
    L7:
        return MapsKt.emptyMap();
    }

    public static final void closeQuietly(Closeable r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final void closeQuietly(Socket r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.close();     // Catch: Exception -> L12 RuntimeException -> L5 AssertionError -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (Intrinsics.areEqual(e.getMessage(), "bio == null") == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final void closeQuietly(ServerSocket r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final boolean isCivilized(FileSystem r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "file");
        Sink r0 = r3.sink(r4);
        Sink r1 = r0;     // Catch: Throwable -> L11
        r3.delete(r4);     // Catch: IOException -> L8 Throwable -> L11
        CloseableKt.closeFinally(r0, null);
        return true;
    L8:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r0, null);
        r3.delete(r4);
        return false;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r0, th);
        throw th;
    }

    public static final String toHexString(long r0) {
        String r1 = Long.toHexString(r0);
        Intrinsics.checkNotNullExpressionValue(r1, "toHexString(this)");
        return r1;
    }

    public static final String toHexString(int r1) {
        String r2 = Integer.toHexString(r1);
        Intrinsics.checkNotNullExpressionValue(r2, "toHexString(this)");
        return r2;
    }

    public static final void wait(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.wait();
    }

    public static final void notify(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.notify();
    }

    public static final void notifyAll(Object r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.notifyAll();
    }

    public static final <T> T readFieldOrNull(Object r4, Class<T> r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "instance");
        Intrinsics.checkNotNullParameter(r5, "fieldType");
        Intrinsics.checkNotNullParameter(r6, "fieldName");
        Class<?> r0 = r4.getClass();
    L3:
        T r2 = null;
        if (Intrinsics.areEqual(r0, Object.class) == true) goto L12;
        Field r1 = r0.getDeclaredField(r6);     // Catch: NoSuchFieldException -> L10
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r3 = r1.get(r4);     // Catch: NoSuchFieldException -> L10
        if (r5.isInstance(r3) == false) goto L9;
        r2 = r5.cast(r3);     // Catch: NoSuchFieldException -> L10
    L9:
        return r2;
    L10:
        r0 = r0.getSuperclass();
        Intrinsics.checkNotNullExpressionValue(r0, "c.superclass");
        goto L3
    L12:
        if (Intrinsics.areEqual(r6, "delegate") == true) goto L17;
        Object r7 = readFieldOrNull(r4, Object.class, "delegate");
        if (r7 == null) goto L17;
        return (T) readFieldOrNull(r7, r5, r6);
    L17:
        return null;
    }

    public static final <E> void addIfAbsent(List<E> r1, E r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.contains(r2) == true) goto L6;
        r1.add(r2);
        return;
    }

    public static final void assertThreadHoldsLock(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r3) == false) goto L8;
        return;
    L8:
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + r3);
    }

    public static final void assertThreadDoesntHoldLock(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r3) == true) goto L8;
        return;
    L8:
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + r3);
    }

    public static final Throwable withSuppressed(Exception r2, List<? extends Exception> r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "suppressed");
        if (r3.size() <= 1) goto L5;
        System.out.println(r3);
    L5:
        Iterator<? extends Exception> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L10;
        ExceptionsKt.addSuppressed(r2, r4.next());
        goto L7
    L10:
        return r2;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> r3, Function1<? super T, Boolean> r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "predicate");
        ArrayList r0 = CollectionsKt.emptyList();
        Iterator<? extends T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        T r1 = r5.next();
        if (r4.invoke(r1).booleanValue() == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        TypeIntrinsics.asMutableList(r0).add(r1);
        goto L4
    L11:
        return r0;
    }

    public static final int indexOf(String[] r4, String r5, Comparator<String> r6) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "value");
        Intrinsics.checkNotNullParameter(r6, "comparator");
        int r0 = r4.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        if (r6.compare(r4[r2], r5) != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L15;
        r2 = r2 + 1;
        goto L3
    L15:
        return r2;
    L7:
        r3 = false;
        goto L8
    L11:
        return -1;
    }
}
