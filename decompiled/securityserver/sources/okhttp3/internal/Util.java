package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.appcompat.widget.ActivityChooserView;
import com.bytedance.apm.battery.dao.DBHelper;
import com.ss.android.http.legacy.protocol.HTTP;
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
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
public final class Util {

    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = null;

    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = null;

    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = null;

    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = null;
    private static final Options UNICODE_BOMS = null;

    @JvmField
    @NotNull
    public static final TimeZone UTC = null;
    private static final Regex VERIFY_AS_IP_ADDRESS = null;

    @JvmField
    public static final boolean assertionsEnabled = false;

    @JvmField
    @NotNull
    public static final String okHttpName = null;

    @NotNull
    public static final String userAgent = "okhttp/4.9.3";

    static {
        byte[] r2 = new byte[0];
        EMPTY_BYTE_ARRAY = r2;
        EMPTY_HEADERS = Headers.Companion.of(new String[0]);
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, r2, null, 1, null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, r2, null, 0, 0, 7, null);
        Options.Companion r1 = Options.Companion;
        ByteString.Companion r3 = ByteString.Companion;
        UNICODE_BOMS = r1.of(new ByteString[]{r3.decodeHex("efbbbf"), r3.decodeHex("feff"), r3.decodeHex("fffe"), r3.decodeHex("0000ffff"), r3.decodeHex("ffff0000")});
        TimeZone r4 = TimeZone.getTimeZone("GMT");
        Intrinsics.c(r4);
        UTC = r4;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        okHttpName = StringsKt.y(StringsKt.x(OkHttpClient.class.getName(), "okhttp3."));
    }

    public static final <E> void addIfAbsent(@NotNull List<E> r1, E r2) {
        Intrinsics.f(r1, "$this$addIfAbsent");
        if (r1.contains(r2) == true) goto L6;
        r1.add(r2);
        return;
    }

    public static final int and(byte r0, int r1) {
        return r0 & r1;
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull final EventListener r1) {
        Intrinsics.f(r1, "$this$asFactory");
        return new AnonymousClass1(r1);
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object r4) {
        Intrinsics.f(r4, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r4) == false) goto L10;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST NOT hold lock on ");
        r1.append(r4);
        throw new AssertionError(r1.toString());
    }

    public static final void assertThreadHoldsLock(@NotNull Object r4) {
        Intrinsics.f(r4, "$this$assertThreadHoldsLock");
        if (assertionsEnabled == true) goto L5;
        return;
    L5:
        if (Thread.holdsLock(r4) == true) goto L10;
        StringBuilder r1 = new StringBuilder("Thread ");
        Thread r2 = Thread.currentThread();
        Intrinsics.e(r2, "Thread.currentThread()");
        r1.append(r2.getName());
        r1.append(" MUST hold lock on ");
        r1.append(r4);
        throw new AssertionError(r1.toString());
    }

    public static final boolean canParseAsIpAddress(@NotNull String r1) {
        Intrinsics.f(r1, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.b(r1);
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl r2, @NotNull HttpUrl r3) {
        Intrinsics.f(r2, "$this$canReuseConnectionFor");
        Intrinsics.f(r3, "other");
        if (Intrinsics.a(r2.host(), r3.host()) == true) goto L5;
    L9:
        return false;
    L5:
        if (r2.port() != r3.port()) goto L9;
        if (Intrinsics.a(r2.scheme(), r3.scheme()) == false) goto L9;
        return true;
    }

    public static final int checkDuration(@NotNull String r7, long r8, @Nullable TimeUnit r10) {
        Intrinsics.f(r7, "name");
        boolean r3 = false;
        if (r8 < 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L30;
        if (r10 == null) goto L9;
        boolean r6 = true;
    L10:
        if (r6 == false) goto L28;
        long r9 = r10.toMillis(r8);
        if (r9 > ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L14;
        boolean r11 = true;
    L15:
        if (r11 == false) goto L26;
        if (r9 != 0) goto L19;
        if (r8 <= 0) goto L19;
    L20:
        if (r3 == false) goto L24;
        return (int) r9;
    L24:
        throw new IllegalArgumentException(r7.concat(" too small.").toString());
    L19:
        r3 = true;
        goto L20
    L26:
        throw new IllegalArgumentException(r7.concat(" too large.").toString());
    L14:
        r11 = false;
        goto L15
    L28:
        throw new IllegalStateException("unit == null".toString());
    L9:
        r6 = false;
        goto L10
    L30:
        throw new IllegalStateException(r7.concat(" < 0").toString());
    L5:
        r5 = false;
        goto L6
    }

    public static final void checkOffsetAndCount(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException();
    }

    public static final void closeQuietly(@NotNull Closeable r1) {
        Intrinsics.f(r1, "$this$closeQuietly");
        r1.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    @NotNull
    public static final String[] concat(@NotNull String[] r1, @NotNull String r2) {
        Intrinsics.f(r1, "$this$concat");
        Intrinsics.f(r2, "value");
        Object[] r3 = Arrays.copyOf(r1, r1.length + 1);
        Intrinsics.e(r3, "java.util.Arrays.copyOf(this, newSize)");
        String[] r4 = (String[]) r3;
        r4[r4.length - 1] = r2;
        return r4;
    }

    public static final int delimiterOffset(@NotNull String r1, @NotNull String r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$delimiterOffset");
        Intrinsics.f(r2, "delimiters");
    L3:
        if (r3 >= r4) goto L8;
        if (StringsKt.n(r2, r1.charAt(r3)) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return r4;
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

    public static final boolean discard(@NotNull Source r1, int r2, @NotNull TimeUnit r3) {
        Intrinsics.f(r1, "$this$discard");
        Intrinsics.f(r3, "timeUnit");
        return skipAll(r1, r2, r3);
    L5:
        return false;
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> r3, @NotNull Function1<? super T, Boolean> r4) {
        Intrinsics.f(r3, "$this$filterList");
        Intrinsics.f(r4, "predicate");
        ArrayList r0 = EmptyList.b;
        Iterator<? extends T> r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L11;
        T r1 = r5.next();
        if (((Boolean) r4.invoke(r1)).booleanValue() == false) goto L4;
        if (r0.isEmpty() == false) goto L10;
        r0 = new ArrayList();
    L10:
        TypeIntrinsics.a(r0).add(r1);
        goto L4
    L11:
        return r0;
    }

    @NotNull
    public static final String format(@NotNull String r2, @NotNull Object... r3) {
        Intrinsics.f(r2, "format");
        Intrinsics.f(r3, "args");
        Locale r0 = Locale.US;
        Object[] r4 = Arrays.copyOf(r3, r3.length);
        return String.format(r0, r2, Arrays.copyOf(r4, r4.length));
    }

    public static final boolean hasIntersection(@NotNull String[] r7, @Nullable String[] r8, @NotNull Comparator<? super String> r9) {
        Intrinsics.f(r7, "$this$hasIntersection");
        Intrinsics.f(r9, "comparator");
        if (r7.length == 0) goto L19;
        if (r8 == null) goto L19;
        if (r8.length == 0) goto L19;
        int r0 = r7.length;
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L19;
        String r3 = r7[r2];
        int r4 = r8.length;
        int r5 = 0;
    L12:
        if (r5 >= r4) goto L18;
        if (r9.compare(r3, r8[r5]) == 0) goto L15;
        r5 = r5 + 1;
        goto L12
    L15:
        return true;
    L18:
        r2 = r2 + 1;
    L19:
        return false;
    }

    public static final long headersContentLength(@NotNull Response r2) {
        Intrinsics.f(r2, "$this$headersContentLength");
        String r3 = r2.headers().get(HTTP.CONTENT_LEN);
        if (r3 != null) goto L5;
        return -1;
    L5:
        return toLongOrDefault(r3, -1);
    }

    public static final void ignoreIoExceptions(@NotNull Function0<Unit> r1) {
        Intrinsics.f(r1, "block");
        r1.invoke();     // Catch: IOException -> L5
        return;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... r1) {
        Intrinsics.f(r1, "elements");
        Object[] r2 = (Object[]) r1.clone();
        List<T> r3 = Collections.unmodifiableList(CollectionsKt.k(Arrays.copyOf(r2, r2.length)));
        Intrinsics.e(r3, "Collections.unmodifiable…istOf(*elements.clone()))");
        return r3;
    }

    public static final int indexOf(@NotNull String[] r3, @NotNull String r4, @NotNull Comparator<String> r5) {
        Intrinsics.f(r3, "$this$indexOf");
        Intrinsics.f(r4, "value");
        Intrinsics.f(r5, "comparator");
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (r5.compare(r3[r1], r4) == 0) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }

    public static final int indexOfControlOrNonAscii(@NotNull String r4) {
        Intrinsics.f(r4, "$this$indexOfControlOrNonAscii");
        int r0 = r4.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        char r2 = r4.charAt(r1);
        if (Intrinsics.h(r2, 31) <= 0) goto L10;
        if (Intrinsics.h(r2, 127) >= 0) goto L10;
        r1 = r1 + 1;
    L10:
        return r1;
    L11:
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String r2, int r3, int r4) {
        Intrinsics.f(r2, "$this$indexOfFirstNonAsciiWhitespace");
    L3:
        if (r3 >= r4) goto L16;
        char r0 = r2.charAt(r3);
        if (r0 == '\t') goto L15;
        if (r0 == '\n') goto L15;
        if (r0 == '\f') goto L15;
        if (r0 == '\r') goto L15;
        if (r0 == ' ') goto L15;
        return r3;
    L15:
        r3 = r3 + 1;
        goto L3
    L16:
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

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String r2, int r3, int r4) {
        Intrinsics.f(r2, "$this$indexOfLastNonAsciiWhitespace");
        int r5 = r4 - 1;
        if (r5 < r3) goto L18;
    L4:
        char r0 = r2.charAt(r5);
        if (r0 != '\t') goto L7;
    L16:
        if (r5 == r3) goto L18;
        r5 = r5 - 1;
        goto L4
    L7:
        if (r0 == '\n') goto L16;
        if (r0 == '\f') goto L16;
        if (r0 == '\r') goto L16;
        if (r0 == ' ') goto L16;
        return r5 + 1;
    L18:
        return r3;
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

    public static final int indexOfNonWhitespace(@NotNull String r3, int r4) {
        Intrinsics.f(r3, "$this$indexOfNonWhitespace");
        int r0 = r3.length();
    L3:
        if (r4 >= r0) goto L11;
        char r1 = r3.charAt(r4);
        if (r1 == ' ') goto L9;
        if (r1 == '\t') goto L9;
        return r4;
    L9:
        r4 = r4 + 1;
        goto L3
    L11:
        return r3.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return indexOfNonWhitespace(r0, r1);
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] r8, @NotNull String[] r9, @NotNull Comparator<? super String> r10) {
        Intrinsics.f(r8, "$this$intersect");
        Intrinsics.f(r9, "other");
        Intrinsics.f(r10, "comparator");
        ArrayList r0 = new ArrayList();
        int r1 = r8.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        String r4 = r8[r3];
        int r5 = r9.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L10;
        if (r10.compare(r4, r9[r6]) == 0) goto L8;
        r6 = r6 + 1;
        goto L5
    L8:
        r0.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        Object[] r11 = r0.toArray(new String[0]);
        if (r11 == null) goto L16;
        return (String[]) r11;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(@NotNull FileSystem r2, @NotNull File r3) {
        Intrinsics.f(r2, "$this$isCivilized");
        Intrinsics.f(r3, "file");
        Sink r0 = r2.sink(r3);
        r2.delete(r3);     // Catch: Throwable -> L6 IOException -> L11
        CloseableKt.a(r0, null);
        return true;
    L11:
        CloseableKt.a(r0, null);
        r2.delete(r3);
        return false;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.a(r0, th);
        throw th;
    }

    public static final boolean isHealthy(@NotNull Socket r2, @NotNull BufferedSource r3) {
        Intrinsics.f(r2, "$this$isHealthy");
        Intrinsics.f(r3, DBHelper.BATTERY_COL_SOURCE);
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

    public static final boolean isSensitiveHeader(@NotNull String r1) {
        Intrinsics.f(r1, "name");
        if (r1.equalsIgnoreCase("Authorization") == false) goto L5;
    L12:
        return true;
    L5:
        if (r1.equalsIgnoreCase("Cookie") == true) goto L12;
        if (r1.equalsIgnoreCase("Proxy-Authorization") == true) goto L12;
        if (r1.equalsIgnoreCase("Set-Cookie") == true) goto L12;
        return false;
    }

    public static final void notify(@NotNull Object r1) {
        Intrinsics.f(r1, "$this$notify");
        r1.notify();
    }

    public static final void notifyAll(@NotNull Object r1) {
        Intrinsics.f(r1, "$this$notifyAll");
        r1.notifyAll();
    }

    public static final int parseHexDigit(char r2) {
        if ('0' > r2) goto L9;
        if ('9' < r2) goto L9;
        return r2 - '0';
    L9:
        if ('a' > r2) goto L15;
        if ('f' < r2) goto L15;
        return r2 - 'W';
    L15:
        if ('A' <= r2) goto L18;
    L20:
        return -1;
    L18:
        if ('F' < r2) goto L20;
        return r2 - '7';
    }

    @NotNull
    public static final String peerName(@NotNull Socket r1) {
        Intrinsics.f(r1, "$this$peerName");
        SocketAddress r2 = r1.getRemoteSocketAddress();
        if ((r2 instanceof InetSocketAddress) == false) goto L6;
        String r3 = ((InetSocketAddress) r2).getHostName();
        Intrinsics.e(r3, "address.hostName");
        return r3;
    L6:
        return r2.toString();
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource r1, @NotNull Charset r2) {
        Intrinsics.f(r1, "$this$readBomAsCharset");
        Intrinsics.f(r2, "default");
        int r3 = r1.select(UNICODE_BOMS);
        if (r3 == (-1)) goto L26;
        if (r3 != 0) goto L6;
        Charset r4 = StandardCharsets.UTF_8;
        Intrinsics.e(r4, "UTF_8");
        return r4;
    L6:
        if (r3 != 1) goto L8;
        Charset r5 = StandardCharsets.UTF_16BE;
        Intrinsics.e(r5, "UTF_16BE");
        return r5;
    L8:
        if (r3 != 2) goto L10;
        Charset r6 = StandardCharsets.UTF_16LE;
        Intrinsics.e(r6, "UTF_16LE");
        return r6;
    L10:
        if (r3 != 3) goto L12;
        Charset r7 = Charsets.f354a;
        Charset r8 = Charsets.c;
        if (r8 != null) goto L27;
        r8 = Charset.forName("UTF-32BE");
        Intrinsics.e(r8, "forName(\"UTF-32BE\")");
        Charsets.c = r8;
    L27:
        return r8;
    L12:
        if (r3 != 4) goto L18;
        Charset r9 = Charsets.f354a;
        r8 = Charsets.b;
        if (r8 != null) goto L27;
        r8 = Charset.forName("UTF-32LE");
        Intrinsics.e(r8, "forName(\"UTF-32LE\")");
        Charsets.b = r8;
        goto L27
    L18:
        throw new AssertionError();
    L26:
        return r2;
    }

    @Nullable
    public static final <T> T readFieldOrNull(@NotNull Object r5, @NotNull Class<T> r6, @NotNull String r7) {
        Intrinsics.f(r5, "instance");
        Intrinsics.f(r6, "fieldType");
        Intrinsics.f(r7, "fieldName");
        Class<?> r0 = r5.getClass();
    L3:
        T r4 = null;
        if ((!r0.equals(Object.class)) == false) goto L12;
        Field r1 = r0.getDeclaredField(r7);     // Catch: NoSuchFieldException -> L10
        Intrinsics.e(r1, "field");     // Catch: NoSuchFieldException -> L10
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L10
        Object r2 = r1.get(r5);     // Catch: NoSuchFieldException -> L10
        if (r6.isInstance(r2) == false) goto L9;
        r4 = r6.cast(r2);     // Catch: NoSuchFieldException -> L10
    L9:
        return r4;
    L10:
        r0 = r0.getSuperclass();
        Intrinsics.e(r0, "c.superclass");
        goto L3
    L12:
        if ((!r7.equals("delegate")) == false) goto L17;
        Object r8 = readFieldOrNull(r5, Object.class, "delegate");
        if (r8 == null) goto L17;
        return (T) readFieldOrNull(r8, r6, r7);
    L17:
        return null;
    }

    public static final int readMedium(@NotNull BufferedSource r3) {
        Intrinsics.f(r3, "$this$readMedium");
        int r0 = (and(r3.readByte(), 255) << 16) | (and(r3.readByte(), 255) << 8);
        return and(r3.readByte(), 255) | r0;
    }

    public static final boolean skipAll(@NotNull Source r11, int r12, @NotNull TimeUnit r13) {
        Intrinsics.f(r11, "$this$skipAll");
        Intrinsics.f(r13, "timeUnit");
        long r0 = System.nanoTime();
        if (r11.timeout().hasDeadline() == false) goto L5;
        long r5 = r11.timeout().deadlineNanoTime() - r0;
    L6:
        r11.timeout().deadlineNanoTime(Math.min(r5, r13.toNanos(r12)) + r0);
        Buffer r14 = new Buffer();     // Catch: Throwable -> L12 InterruptedIOException -> L24
    L9:
        if (r11.read(r14, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == (-1)) goto L15;
        r14.clear();     // Catch: Throwable -> L12 InterruptedIOException -> L24
        goto L25
    L15:
        if (r5 != Long.MAX_VALUE) goto L17;
        r11.timeout().clearDeadline();
    L18:
        return true;
    L17:
        r11.timeout().deadlineNanoTime(r0 + r5);
    L12:
        th = move-exception;
        if (r5 != Long.MAX_VALUE) goto L22;
        r11.timeout().clearDeadline();
    L23:
        throw th;
    L22:
        r11.timeout().deadlineNanoTime(r0 + r5);
    L25:
        if (r5 != Long.MAX_VALUE) goto L27;
        r11.timeout().clearDeadline();
    L28:
        return false;
    L27:
        r11.timeout().deadlineNanoTime(r0 + r5);
        goto L28
    L5:
        r5 = Long.MAX_VALUE;
        goto L6
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull final String r1, final boolean r2) {
        Intrinsics.f(r1, "name");
        return new ThreadFactoryC00451(r1, r2);
    }

    public static final void threadName(@NotNull String r2, @NotNull Function0<Unit> r3) {
        Intrinsics.f(r2, "name");
        Intrinsics.f(r3, "block");
        Thread r0 = Thread.currentThread();
        Intrinsics.e(r0, "currentThread");
        String r1 = r0.getName();
        r0.setName(r2);
        r3.invoke();     // Catch: Throwable -> L6
        r0.setName(r1);
        return;
    L6:
        th = move-exception;
        r0.setName(r1);
        throw th;
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers r5) {
        Intrinsics.f(r5, "$this$toHeaderList");
        IntRange r0 = RangesKt.e(0, r5.size());
        ArrayList r1 = new ArrayList(CollectionsKt.e(r0, 10));
        Iterator<Integer> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        int r3 = ((IntIterator) r2).nextInt();
        r1.add(new Header(r5.name(r3), r5.value(r3)));
        goto L4
    L6:
        return r1;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> r3) {
        Intrinsics.f(r3, "$this$toHeaders");
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

    @NotNull
    public static final String toHexString(long r0) {
        String r1 = Long.toHexString(r0);
        Intrinsics.e(r1, "java.lang.Long.toHexString(this)");
        return r1;
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl r3, boolean r4) {
        Intrinsics.f(r3, "$this$toHostHeader");
        if (StringsKt.m(":", false, r3.host()) == false) goto L5;
        String r0 = "[" + r3.host() + ']';
    L6:
        if (r4 == true) goto L10;
        if (r3.port() != HttpUrl.Companion.defaultPort(r3.scheme())) goto L10;
        return r0;
    L10:
        return r0 + ':' + r3.port();
    L5:
        r0 = r3.host();
        goto L6
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = false;
    L6:
        return toHostHeader(r0, r1);
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> r1) {
        Intrinsics.f(r1, "$this$toImmutableList");
        List<T> r2 = Collections.unmodifiableList(CollectionsKt.r(r1));
        Intrinsics.e(r2, "Collections.unmodifiableList(toMutableList())");
        return r2;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> r1) {
        Intrinsics.f(r1, "$this$toImmutableMap");
        if (r1.isEmpty() == true) goto L7;
        Map<K, V> r2 = Collections.unmodifiableMap(new LinkedHashMap(r1));
        Intrinsics.e(r2, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return r2;
    L7:
        return MapsKt.b();
    }

    public static final long toLongOrDefault(@NotNull String r1, long r2) {
        Intrinsics.f(r1, "$this$toLongOrDefault");
        return Long.parseLong(r1);
    L8:
        return r2;
    }

    public static final int toNonNegativeInt(@Nullable String r3, int r4) {
        if (r3 != null) goto L14;
    L12:
        return r4;
    L14:
        long r5 = Long.parseLong(r3);     // Catch: NumberFormatException -> L13
        if (r5 <= ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) goto L8;
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    L8:
        if (r5 >= 0) goto L11;
        return 0;
    L11:
        return (int) r5;
    }

    @NotNull
    public static final String trimSubstring(@NotNull String r1, int r2, int r3) {
        Intrinsics.f(r1, "$this$trimSubstring");
        int r4 = indexOfFirstNonAsciiWhitespace(r1, r2, r3);
        String r5 = r1.substring(r4, indexOfLastNonAsciiWhitespace(r1, r4, r3));
        Intrinsics.e(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r5;
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

    public static final void wait(@NotNull Object r1) {
        Intrinsics.f(r1, "$this$wait");
        r1.wait();
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception r2, @NotNull List<? extends Exception> r3) {
        Intrinsics.f(r2, "$this$withSuppressed");
        Intrinsics.f(r3, "suppressed");
        if (r3.size() <= 1) goto L5;
        System.out.println(r3);
    L5:
        Iterator<? extends Exception> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L9;
        ExceptionsKt.a(r2, r4.next());
        goto L7
    L9:
        return r2;
    }

    public static final void writeMedium(@NotNull BufferedSink r1, int r2) {
        Intrinsics.f(r1, "$this$writeMedium");
        r1.writeByte((r2 >>> 16) & 255);
        r1.writeByte((r2 >>> 8) & 255);
        r1.writeByte(r2 & 255);
    }

    public static final int and(short r0, int r1) {
        return r0 & r1;
    }

    public static final int delimiterOffset(@NotNull String r1, char r2, int r3, int r4) {
        Intrinsics.f(r1, "$this$delimiterOffset");
    L3:
        if (r3 >= r4) goto L8;
        if (r1.charAt(r3) == r2) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r3;
    L8:
        return r4;
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

    @NotNull
    public static final String toHexString(int r1) {
        String r2 = Integer.toHexString(r1);
        Intrinsics.e(r2, "Integer.toHexString(this)");
        return r2;
    }

    public static final long and(int r2, long r3) {
        return ((long) r2) & r3;
    }

    public static final void closeQuietly(@NotNull Socket r2) {
        Intrinsics.f(r2, "$this$closeQuietly");
        r2.close();     // Catch: Exception -> L12 RuntimeException -> L5 AssertionError -> L10
        return;
    L10:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (Intrinsics.a(e.getMessage(), "bio == null") == false) goto L9;
        return;
    L9:
        throw e;
    }

    public static final void closeQuietly(@NotNull ServerSocket r1) {
        Intrinsics.f(r1, "$this$closeQuietly");
        r1.close();     // Catch: Exception -> L7 RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        throw e;
    }

    public static final int skipAll(@NotNull Buffer r3, byte r4) {
        Intrinsics.f(r3, "$this$skipAll");
        int r0 = 0;
    L4:
        if (r3.exhausted() == true) goto L8;
        if (r3.getByte(0) != r4) goto L8;
        r0 = r0 + 1;
        r3.readByte();
    L8:
        return r0;
    }
}
