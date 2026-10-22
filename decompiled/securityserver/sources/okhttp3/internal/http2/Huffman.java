package okhttp3.internal.http2;

import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm.battery.dao.DBHelper;
import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import com.ss.android.common.ApiConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Huffman {
    private static final int[] CODES = null;
    private static final byte[] CODE_BIT_COUNTS = null;
    public static final Huffman INSTANCE = null;
    private static final Node root = null;

    @Metadata
    public static final class Node {

        @Nullable
        private final Node[] children;
        private final int symbol;
        private final int terminalBitCount;

        public Node() {
            this.children = new Node[256];
            this.symbol = 0;
            this.terminalBitCount = 0;
        }

        @Nullable
        public final Node[] getChildren() {
            return this.children;
        }

        public final int getSymbol() {
            return this.symbol;
        }

        public final int getTerminalBitCount() {
            return this.terminalBitCount;
        }

        public Node(int r2, int r3) {
            this.children = null;
            this.symbol = r2;
            int r4 = r3 & 7;
            if (r4 != 0) goto L5;
            r4 = 8;
        L5:
            this.terminalBitCount = r4;
        }
    }

    static {
        Huffman r0 = new Huffman();
        INSTANCE = r0;
        int r1 = 0;
        CODES = new int[]{8184, 8388568, 268435426, 268435427, 268435428, 268435429, 268435430, 268435431, 268435432, 16777194, 1073741820, 268435433, 268435434, 1073741821, 268435435, 268435436, 268435437, 268435438, 268435439, 268435440, 268435441, 268435442, 1073741822, 268435443, 268435444, 268435445, 268435446, 268435447, 268435448, 268435449, 268435450, 268435451, 20, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, 4090, 8185, 21, 248, 2042, PointerIconCompat.TYPE_ZOOM_IN, PointerIconCompat.TYPE_ZOOM_OUT, 249, 2043, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 22, 23, 24, 0, 1, 2, 25, 26, 27, 28, 29, 30, 31, 92, 251, 32764, 32, 4091, PointerIconCompat.TYPE_GRAB, 8186, 33, 93, 94, 95, 96, 97, 98, 99, 100, 101, HttpStatus.SC_PROCESSING, 103, 104, ApiConstants.OP_ERROR_SESSION_EXPIRE, ApiConstants.OP_ERROR_NAME_EXISTED, ApiConstants.OP_ERROR_INVALID_NAME, 108, 109, ApiConstants.OP_ERROR_ANTISPAM, ApiConstants.OP_ERROR_CONNECT_SWITCH, ApiConstants.OP_ERROR_UGC_POST_TOO_FAST, 113, 114, 252, 115, 253, 8187, 524272, 8188, 16380, 34, 32765, 3, 35, 4, 36, 5, 37, 38, 39, 6, 116, 117, 40, 41, 42, 7, 43, 118, 44, 8, 9, 45, 119, 120, 121, 122, 123, 32766, 2044, 16381, 8189, 268435452, 1048550, 4194258, 1048551, 1048552, 4194259, 4194260, 4194261, 8388569, 4194262, 8388570, 8388571, 8388572, 8388573, 8388574, 16777195, 8388575, 16777196, 16777197, 4194263, 8388576, 16777198, 8388577, 8388578, 8388579, 8388580, 2097116, 4194264, 8388581, 4194265, 8388582, 8388583, 16777199, 4194266, 2097117, 1048553, 4194267, 4194268, 8388584, 8388585, 2097118, 8388586, 4194269, 4194270, 16777200, 2097119, 4194271, 8388587, 8388588, 2097120, 2097121, 4194272, 2097122, 8388589, 4194273, 8388590, 8388591, 1048554, 4194274, 4194275, 4194276, 8388592, 4194277, 4194278, 8388593, 67108832, 67108833, 1048555, 524273, 4194279, 8388594, 4194280, 33554412, 67108834, 67108835, 67108836, 134217694, 134217695, 67108837, 16777201, 33554413, 524274, 2097123, 67108838, 134217696, 134217697, 67108839, 134217698, 16777202, 2097124, 2097125, 67108840, 67108841, 268435453, 134217699, 134217700, 134217701, 1048556, 16777203, 1048557, 2097126, 4194281, 2097127, 2097128, 8388595, 4194282, 4194283, 33554414, 33554415, 16777204, 16777205, 67108842, 8388596, 67108843, 134217702, 67108844, 67108845, 134217703, 134217704, 134217705, 134217706, 134217707, 268435454, 134217708, 134217709, 134217710, 134217711, 134217712, 67108846};
        byte[] r2 = {13, 23, 28, 28, 28, 28, 28, 28, 28, 24, 30, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 30, 28, 28, 28, 28, 28, 28, 28, 28, 28, 6, 10, 10, 12, 13, 6, 8, 11, 10, 10, 8, 11, 8, 6, 6, 6, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 7, 8, 15, 6, 12, 10, 13, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 7, 8, 13, 19, 13, 14, 6, 15, 5, 6, 5, 6, 5, 6, 6, 6, 5, 7, 7, 6, 6, 6, 5, 6, 7, 6, 5, 5, 6, 7, 7, 7, 7, 7, 15, 11, 14, 13, 28, 20, 22, 20, 20, 22, 22, 22, 23, 22, 23, 23, 23, 23, 23, 24, 23, 24, 24, 22, 23, 24, 23, 23, 23, 23, 21, 22, 23, 22, 23, 23, 24, 22, 21, 20, 22, 22, 23, 23, 21, 23, 22, 22, 24, 21, 22, 23, 23, 21, 21, 22, 21, 23, 22, 23, 23, 20, 22, 22, 22, 23, 22, 22, 23, 26, 26, 20, 19, 22, 23, 22, 25, 26, 26, 26, 27, 27, 26, 24, 25, 19, 21, 26, 27, 27, 26, 27, 24, 21, 21, 26, 26, 28, 27, 27, 27, 20, 24, 20, 21, 22, 21, 21, 23, 22, 22, 25, 25, 24, 24, 26, 23, 26, 27, 26, 26, 27, 27, 27, 27, 27, 28, 27, 27, 27, 27, 27, 26};
        CODE_BIT_COUNTS = r2;
        root = new Node();
        int r3 = r2.length;
    L3:
        if (r1 >= r3) goto L5;
        r0.addCode(r1, CODES[r1], CODE_BIT_COUNTS[r1]);
        r1 = r1 + 1;
        goto L3
    }

    private Huffman() {
    }

    private final void addCode(int r3, int r4, int r5) {
        Node r2 = new Node(r3, r5);
        Node r6 = root;
    L4:
        if (r5 <= 8) goto L9;
        r5 = r5 - 8;
        int r0 = (r4 >>> r5) & 255;
        Node[] r7 = r6.getChildren();
        Intrinsics.c(r7);
        Node r1 = r7[r0];
        if (r1 != null) goto L8;
        r1 = new Node();
        r7[r0] = r1;
    L8:
        r6 = r1;
        goto L4
    L9:
        int r8 = 8 - r5;
        int r9 = (r4 << r8) & 255;
        Node[] r10 = r6.getChildren();
        Intrinsics.c(r10);
        Arrays.fill(r10, r9, (1 << r8) + r9, r2);
    }

    public final void decode(@NotNull BufferedSource r8, long r9, @NotNull BufferedSink r11) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r11, "sink");
        Node r7 = root;
        int r0 = 0;
        long r2 = 0;
        int r1 = 0;
    L4:
        if (r2 >= r9) goto L13;
        r0 = (r0 << 8) | Util.and(r8.readByte(), 255);
        r1 = r1 + 8;
    L7:
        if (r1 < 8) goto L12;
        int r4 = r1 - 8;
        Node[] r10 = r7.getChildren();
        Intrinsics.c(r10);
        r7 = r10[(r0 >>> r4) & 255];
        Intrinsics.c(r7);
        if (r7.getChildren() == null) goto L10;
        r1 = r4;
        goto L7
    L10:
        r11.writeByte(r7.getSymbol());
        r1 = r1 - r7.getTerminalBitCount();
        r7 = root;
        goto L7
    L12:
        r2 = r2 + 1;
    L13:
        if (r1 <= 0) goto L31;
        Node[] r12 = r7.getChildren();
        Intrinsics.c(r12);
        Node r13 = r12[(r0 << (8 - r1)) & 255];
        Intrinsics.c(r13);
        if (r13.getChildren() != null) goto L32;
        if (r13.getTerminalBitCount() > r1) goto L20;
        r11.writeByte(r13.getSymbol());
        r1 = r1 - r13.getTerminalBitCount();
        r7 = root;
        goto L13
    L20:
        return;
    L32:
        return;
    }

    public final void encode(@NotNull ByteString r8, @NotNull BufferedSink r9) {
        Intrinsics.f(r8, DBHelper.BATTERY_COL_SOURCE);
        Intrinsics.f(r9, "sink");
        int r7 = r8.size();
        long r0 = 0;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r7) goto L9;
        int r4 = Util.and(r8.getByte(r2), 255);
        int r5 = CODES[r4];
        byte r6 = CODE_BIT_COUNTS[r4];
        r0 = (r0 << r6) | ((long) r5);
        r3 = r3 + r6;
    L6:
        if (r3 < 8) goto L8;
        r3 = r3 - 8;
        r9.writeByte((int) (r0 >> r3));
        goto L6
    L8:
        r2 = r2 + 1;
        goto L3
    L9:
        if (r3 <= 0) goto L14;
        r9.writeByte((int) ((r0 << (8 - r3)) | (255 >>> r3)));
        return;
    }

    public final int encodedLength(@NotNull ByteString r6) {
        Intrinsics.f(r6, "bytes");
        int r5 = r6.size();
        long r0 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r5) goto L6;
        int r3 = Util.and(r6.getByte(r2), 255);
        r0 = r0 + ((long) CODE_BIT_COUNTS[r3]);
        r2 = r2 + 1;
        goto L3
    L6:
        return (int) ((r0 + ((long) 7)) >> 3);
    }
}
