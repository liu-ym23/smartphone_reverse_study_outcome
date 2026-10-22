package okhttp3.logging;

import com.ss.android.http.legacy.protocol.HTTP;
import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = null;
    private volatile Level level;
    private final Logger logger;

    public static final enum Level extends Enum<Level> {
        private static final /* synthetic */ Level[] $VALUES = null;
        public static final Level BASIC = null;
        public static final Level BODY = null;
        public static final Level HEADERS = null;
        public static final Level NONE = null;

        private Level(String r1, int r2) {
            super(r1, r2);
        }

        public static Level valueOf(String r1) {
            return (Level) Enum.valueOf(Level.class, r1);
        }

        public static Level[] values() {
            return (Level[]) $VALUES.clone();
        }

        static {
            Level r0 = new Level("NONE", 0);
            NONE = r0;
            Level r1 = new Level("BASIC", 1);
            BASIC = r1;
            Level r3 = new Level("HEADERS", 2);
            HEADERS = r3;
            Level r5 = new Level("BODY", 3);
            BODY = r5;
            $VALUES = new Level[]{r0, r1, r3, r5};
        }
    }

    public interface Logger {
        public static final Logger DEFAULT = null;

        void log(String r1);

        static {
            DEFAULT = new AnonymousClass1();
        }
    }

    static {
        UTF8 = Charset.forName("UTF-8");
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger r2) {
        this.level = Level.NONE;
        this.logger = r2;
    }

    public HttpLoggingInterceptor setLevel(Level r1) {
        if (r1 == null) goto L6;
        this.level = r1;
        return this;
    L6:
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.level;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r23) throws IOException {
        Level r2 = this.level;
        Request r3 = r23.request();
        if (r2 == Level.NONE) goto L5;
        boolean r5 = true;
        if (r2 != Level.BODY) goto L9;
        boolean r4 = true;
    L10:
        if (r4 == false) goto L12;
    L15:
        boolean r6 = true;
    L16:
        RequestBody r7 = r3.body();
        if (r7 != null) goto L20;
        r5 = false;
    L20:
        Connection r8 = r23.connection();
        StringBuilder r9 = new StringBuilder("--> ").append(r3.method()).append(' ').append(r3.url());
        if (r8 == null) goto L23;
        String r10 = " " + r8.protocol();
    L24:
        String r11 = r9.append(r10).toString();
        String r12 = "-byte body)";
        if (r6 == true) goto L28;
        if (r5 == false) goto L28;
        r11 = r11 + " (" + r7.contentLength() + "-byte body)";
    L28:
        this.logger.log(r11);
        if (r6 == false) goto L62;
        if (r5 == false) goto L38;
        if (r7.contentType() == null) goto L35;
        this.logger.log("Content-Type: " + r7.contentType());
    L35:
        if (r7.contentLength() == (-1)) goto L38;
        this.logger.log("Content-Length: " + r7.contentLength());
    L38:
        Headers r13 = r3.headers();
        int r14 = r13.size();
        int r15 = 0;
    L39:
        if (r15 >= r14) goto L47;
        String r16 = r13.name(r15);
        int r20 = r14;
        if ("Content-Type".equalsIgnoreCase(r16) == true) goto L46;
        if (HTTP.CONTENT_LEN.equalsIgnoreCase(r16) == true) goto L46;
        this.logger.log(r16 + ": " + r13.value(r15));
    L46:
        r15 = r15 + 1;
        r14 = r20;
        r12 = r12;
        goto L39
    L47:
        String r21 = r12;
        if (r4 == false) goto L61;
        if (r5 == false) goto L61;
        if (bodyHasUnknownEncoding(r3.headers()) == false) goto L54;
        this.logger.log("--> END " + r3.method() + " (encoded body omitted)");
        String r17 = "-byte body omitted)";
        String r18 = r21;
    L63:
        long r19 = System.nanoTime();
        Response r0 = r23.proceed(r3);     // Catch: Exception -> L117
        long r22 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r19);
        ResponseBody r24 = r0.body();
        long r25 = r24.contentLength();
        if (r25 == (-1)) goto L68;
        String r26 = r25 + "-byte";
    L69:
        Logger r110 = this.logger;
        StringBuilder r27 = new StringBuilder("<-- ").append(r0.code());
        if (r0.message().isEmpty() == false) goto L72;
        String r111 = "";
    L73:
        StringBuilder r28 = r27.append(r111).append(' ').append(r0.request().url()).append(" (").append(r22).append("ms");
        if (r6 == true) goto L76;
        String r29 = ", " + r26 + " body";
    L77:
        r110.log(r28.append(r29).append(')').toString());
        if (r6 == false) goto L116;
        Headers r30 = r0.headers();
        int r31 = r30.size();
        int r32 = 0;
    L80:
        if (r32 >= r31) goto L82;
        this.logger.log(r30.name(r32) + ": " + r30.value(r32));
        r32 = r32 + 1;
        goto L80
    L82:
        if (r4 == true) goto L84;
    L115:
        this.logger.log("<-- END HTTP");
        goto L116
    L84:
        if (HttpHeaders.hasBody(r0) == false) goto L115;
        if (bodyHasUnknownEncoding(r0.headers()) == false) goto L89;
        this.logger.log("<-- END HTTP (encoded body omitted)");
        goto L116
    L89:
        BufferedSource r33 = r24.source();
        r33.request(Long.MAX_VALUE);
        Buffer r34 = r33.buffer();
        Long r35 = null;
        GzipSource r36 = null;
        if ("gzip".equalsIgnoreCase(r30.get("Content-Encoding")) == false) goto L101;
        Long r37 = Long.valueOf(r34.size());
        GzipSource r38 = new GzipSource(r34.m2340clone());     // Catch: Throwable -> L97
        r34 = new Buffer();     // Catch: Throwable -> L95
        r34.writeAll(r38);     // Catch: Throwable -> L95
        r38.close();
        r35 = r37;
    L95:
        th = th;
        r36 = r38;
    L98:
        if (r36 == null) goto L100;
        r36.close();
    L100:
        throw th;
    L97:
        th = th;
    L101:
        Charset r39 = UTF8;
        MediaType r40 = r24.contentType();
        if (r40 == null) goto L105;
        r39 = r40.charset(r39);
    L105:
        if (isPlaintext(r34) == true) goto L109;
        this.logger.log("");
        this.logger.log("<-- END HTTP (binary " + r34.size() + r17);
        return r0;
    L109:
        if (r25 == 0) goto L112;
        this.logger.log("");
        this.logger.log(r34.m2340clone().readString(r39));
    L112:
        if (r35 == null) goto L114;
        this.logger.log("<-- END HTTP (" + r34.size() + "-byte, " + r35 + "-gzipped-byte body)");
        goto L116
    L114:
        this.logger.log("<-- END HTTP (" + r34.size() + r18);
    L116:
        return r0;
    L76:
        r29 = "";
        goto L77
    L72:
        r111 = " " + r0.message();
        goto L73
    L68:
        r26 = "unknown-length";
    L117:
        e = move-exception;
        this.logger.log("<-- HTTP FAILED: " + e);
        throw e;
    L54:
        Buffer r41 = new Buffer();
        r7.writeTo(r41);
        Charset r42 = UTF8;
        MediaType r43 = r7.contentType();
        if (r43 == null) goto L57;
        r42 = r43.charset(r42);
    L57:
        this.logger.log("");
        if (isPlaintext(r41) == false) goto L60;
        this.logger.log(r41.readString(r42));
        r18 = r21;
        this.logger.log(new StringBuilder("--> END ").append(r3.method()).append(" (").append(r7.contentLength()).append(r18).toString());
        r17 = r8;
        goto L63
    L60:
        r18 = r21;
        Logger r44 = this.logger;
        StringBuilder r45 = new StringBuilder("--> END ").append(r3.method()).append(" (binary ").append(r7.contentLength());
        r17 = r8;
        r44.log(r45.append(r17).toString());
    L61:
        r17 = r8;
        r18 = r21;
        this.logger.log("--> END " + r3.method());
        goto L63
    L62:
        r17 = "-byte body omitted)";
        r18 = "-byte body)";
        goto L63
    L23:
        r10 = "";
        goto L24
    L12:
        if (r2 == Level.HEADERS) goto L15;
        r6 = false;
        goto L16
    L9:
        r4 = false;
        goto L10
    L5:
        return r23.proceed(r3);
    }

    static boolean isPlaintext(Buffer r8) {
        Buffer r7 = new Buffer();     // Catch: EOFException -> L21
        if (r8.size() >= 64) goto L6;
        long r5 = r8.size();     // Catch: EOFException -> L21
    L7:
        r8.copyTo(r7, 0, r5);     // Catch: EOFException -> L21
        int r9 = 0;
    L9:
        if (r9 >= 16) goto L29;
        if (r7.exhausted() == true) goto L19;
        int r1 = r7.readUtf8CodePoint();     // Catch: EOFException -> L21
        if (Character.isISOControl(r1) == false) goto L18;
        if (Character.isWhitespace(r1) == true) goto L18;
        return false;
    L18:
        r9 = r9 + 1;
        goto L9
    L19:
        return true;
    L29:
        return true;
    L6:
        r5 = 64;
    L21:
        return false;
    }

    private boolean bodyHasUnknownEncoding(Headers r1) {
        String r0 = r1.get("Content-Encoding");
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.equalsIgnoreCase(HTTP.IDENTITY_CODING) == true) goto L9;
        if (r0.equalsIgnoreCase("gzip") == true) goto L9;
        return true;
    }
}
