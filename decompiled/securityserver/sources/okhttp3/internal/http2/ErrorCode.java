package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum ErrorCode extends Enum<ErrorCode> {
    private static final /* synthetic */ ErrorCode[] $VALUES = null;
    public static final ErrorCode CANCEL = null;
    public static final ErrorCode COMPRESSION_ERROR = null;
    public static final ErrorCode CONNECT_ERROR = null;
    public static final Companion Companion = null;
    public static final ErrorCode ENHANCE_YOUR_CALM = null;
    public static final ErrorCode FLOW_CONTROL_ERROR = null;
    public static final ErrorCode FRAME_SIZE_ERROR = null;
    public static final ErrorCode HTTP_1_1_REQUIRED = null;
    public static final ErrorCode INADEQUATE_SECURITY = null;
    public static final ErrorCode INTERNAL_ERROR = null;
    public static final ErrorCode NO_ERROR = null;
    public static final ErrorCode PROTOCOL_ERROR = null;
    public static final ErrorCode REFUSED_STREAM = null;
    public static final ErrorCode SETTINGS_TIMEOUT = null;
    public static final ErrorCode STREAM_CLOSED = null;
    private final int httpCode;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @Nullable
        public final ErrorCode fromHttp2(int r5) {
            ErrorCode[] r4 = ErrorCode.values();
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            ErrorCode r2 = r4[r1];
            if (r2.getHttpCode() == r5) goto L12;
            r1 = r1 + 1;
            goto L3
        L12:
            return r2;
        L8:
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        ErrorCode r0 = new ErrorCode("NO_ERROR", 0, 0);
        NO_ERROR = r0;
        ErrorCode r1 = new ErrorCode("PROTOCOL_ERROR", 1, 1);
        PROTOCOL_ERROR = r1;
        ErrorCode r2 = new ErrorCode("INTERNAL_ERROR", 2, 2);
        INTERNAL_ERROR = r2;
        ErrorCode r3 = new ErrorCode("FLOW_CONTROL_ERROR", 3, 3);
        FLOW_CONTROL_ERROR = r3;
        ErrorCode r4 = new ErrorCode("SETTINGS_TIMEOUT", 4, 4);
        SETTINGS_TIMEOUT = r4;
        ErrorCode r5 = new ErrorCode("STREAM_CLOSED", 5, 5);
        STREAM_CLOSED = r5;
        ErrorCode r6 = new ErrorCode("FRAME_SIZE_ERROR", 6, 6);
        FRAME_SIZE_ERROR = r6;
        ErrorCode r7 = new ErrorCode("REFUSED_STREAM", 7, 7);
        REFUSED_STREAM = r7;
        ErrorCode r8 = new ErrorCode("CANCEL", 8, 8);
        CANCEL = r8;
        ErrorCode r9 = new ErrorCode("COMPRESSION_ERROR", 9, 9);
        COMPRESSION_ERROR = r9;
        ErrorCode r10 = new ErrorCode("CONNECT_ERROR", 10, 10);
        CONNECT_ERROR = r10;
        ErrorCode r11 = new ErrorCode("ENHANCE_YOUR_CALM", 11, 11);
        ENHANCE_YOUR_CALM = r11;
        ErrorCode r12 = new ErrorCode("INADEQUATE_SECURITY", 12, 12);
        INADEQUATE_SECURITY = r12;
        ErrorCode r13 = new ErrorCode("HTTP_1_1_REQUIRED", 13, 13);
        HTTP_1_1_REQUIRED = r13;
        $VALUES = new ErrorCode[]{r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13};
        Companion = new Companion(null);
    }

    private ErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.httpCode = r3;
    }

    public static ErrorCode valueOf(String r1) {
        return (ErrorCode) Enum.valueOf(ErrorCode.class, r1);
    }

    public static ErrorCode[] values() {
        return (ErrorCode[]) $VALUES.clone();
    }

    public final int getHttpCode() {
        return this.httpCode;
    }
}
