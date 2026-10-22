package okhttp3.internal.http2;

import com.android.launcher3.icons.cache.BaseIconCache;
import cz.msebera.android.httpclient.message.TokenParser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;

/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH\u0000¢\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", BaseIconCache.IconDB.COLUMN_FLAGS, "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Http2 {
    private static final String[] BINARY = null;
    public static final ByteString CONNECTION_PREFACE = null;
    private static final String[] FLAGS = null;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final Http2 INSTANCE = null;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;

    private Http2() {
    }

    static {
        INSTANCE = new Http2();
        CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        FRAME_NAMES = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        FLAGS = new String[64];
        String[] r1 = new String[256];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 256) goto L6;
        String r5 = Integer.toBinaryString(r3);
        Intrinsics.checkNotNullExpressionValue(r5, "toBinaryString(it)");
        r1[r3] = StringsKt.replace$default(Util.format("%8s", new Object[]{r5}), TokenParser.SP, '0', false, 4, null);
        r3 = r3 + 1;
        goto L4
    L6:
        BINARY = r1;
        String[] r0 = FLAGS;
        r0[0] = "";
        r0[1] = "END_STREAM";
        int[] r4 = {1};
        r0[8] = "PADDED";
        r0[1 | 8] = Intrinsics.stringPlus("END_STREAM", "|PADDED");
        r0[4] = "END_HEADERS";
        r0[32] = "PRIORITY";
        r0[36] = "END_HEADERS|PRIORITY";
        int[] r6 = {4, 32, 36};
        int r7 = 0;
    L7:
        if (r7 >= 3) goto L9;
        int r8 = r6[r7];
        r7 = r7 + 1;
        int r9 = r4[0];
        String[] r10 = FLAGS;
        int r11 = r9 | r8;
        r10[r11] = r10[r9] + '|' + r10[r8];
        r10[r11 | 8] = r10[r9] + '|' + r10[r8] + "|PADDED";
        goto L7
    L9:
        int r12 = FLAGS.length;
    L10:
        if (r2 >= r12) goto L15;
        int r13 = r2 + 1;
        String[] r14 = FLAGS;
        if (r14[r2] != null) goto L14;
        r14[r2] = BINARY[r2];
    L14:
        r2 = r13;
        goto L10
    }

    public final String frameLog(boolean r2, int r3, int r4, int r5, int r6) {
        String r0 = formattedType$okhttp(r5);
        String r1 = formatFlags(r5, r6);
        if (r2 == false) goto L5;
        String r7 = "<<";
    L7:
        return Util.format("%s 0x%08x %5d %-13s %s", new Object[]{r7, Integer.valueOf(r3), Integer.valueOf(r4), r0, r1});
    L5:
        r7 = ">>";
        goto L7
    }

    public final String formattedType$okhttp(int r2) {
        String[] r1 = FRAME_NAMES;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return Util.format("0x%02x", new Object[]{Integer.valueOf(r2)});
    }

    public final String formatFlags(int r7, int r8) {
        if (r8 != 0) goto L6;
        return "";
    L6:
        if (r7 == 2) goto L37;
        if (r7 == 3) goto L37;
        if (r7 == 4) goto L32;
        if (r7 == 6) goto L32;
        if (r7 == 7) goto L37;
        if (r7 == 8) goto L37;
        String[] r6 = FLAGS;
        if (r8 >= r6.length) goto L20;
        String r9 = r6[r8];
        Intrinsics.checkNotNull(r9);
    L21:
        String r0 = r9;
        if (r7 == 5) goto L24;
    L26:
        if (r7 == 0) goto L28;
        return r0;
    L28:
        if ((r8 & 32) != 0) goto L30;
        return r0;
    L30:
        return StringsKt.replace$default(r0, "PRIORITY", "COMPRESSED", false, 4, null);
    L24:
        if ((r8 & 4) == 0) goto L26;
        return StringsKt.replace$default(r0, "HEADERS", "PUSH_PROMISE", false, 4, null);
    L20:
        r9 = BINARY[r8];
    L32:
        if (r8 != 1) goto L35;
        return "ACK";
    L35:
        return BINARY[r8];
    L37:
        return BINARY[r8];
    }
}
