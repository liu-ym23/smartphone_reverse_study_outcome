package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WebSocketExtensions {
    public static final Companion Companion = null;
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";

    @JvmField
    @Nullable
    public final Integer clientMaxWindowBits;

    @JvmField
    public final boolean clientNoContextTakeover;

    @JvmField
    public final boolean perMessageDeflate;

    @JvmField
    @Nullable
    public final Integer serverMaxWindowBits;

    @JvmField
    public final boolean serverNoContextTakeover;

    @JvmField
    public final boolean unknownValues;

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final WebSocketExtensions parse(@NotNull Headers r21) {
            Intrinsics.f(r21, "responseHeaders");
            int r1 = r21.size();
            int r4 = 0;
            boolean r6 = false;
            Integer r7 = null;
            boolean r8 = false;
            Integer r9 = null;
            boolean r10 = false;
            boolean r11 = false;
        L3:
            if (r4 >= r1) goto L58;
            if (StringsKt.p(r21.name(r4), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true) == false) goto L56;
            String r5 = r21.value(r4);
            int r12 = 0;
        L9:
            if (r12 >= r5.length()) goto L56;
            int r14 = Util.delimiterOffset$default(r5, ',', r12, 0, 4, null);
            int r2 = Util.delimiterOffset(r5, ';', r12, r14);
            String r13 = Util.trimSubstring(r5, r12, r2);
            int r3 = r2 + 1;
            if (StringsKt.p(r13, "permessage-deflate", true) == true) goto L12;
            r12 = r3;
            r11 = true;
            goto L9
        L12:
            if (r6 == false) goto L14;
            r11 = true;
        L14:
            if (r3 >= r14) goto L54;
            int r15 = Util.delimiterOffset(r5, ';', r3, r14);
            int r16 = Util.delimiterOffset(r5, '=', r3, r15);
            String r17 = Util.trimSubstring(r5, r3, r16);
            if (r16 >= r15) goto L18;
            String r18 = StringsKt.z(Util.trimSubstring(r5, r16 + 1, r15));
        L19:
            int r19 = r15 + 1;
            if (StringsKt.p(r17, "client_max_window_bits", true) == false) goto L30;
            if (r7 == null) goto L23;
            r11 = true;
        L23:
            if (r18 == null) goto L25;
            Integer r20 = StringsKt.I(r18);
        L26:
            r7 = r20;
            if (r20 != null) goto L53;
        L28:
            r11 = true;
        L53:
            r3 = r19;
            goto L14
        L25:
            r20 = null;
            goto L26
        L30:
            if (StringsKt.p(r17, "client_no_context_takeover", true) == false) goto L37;
            if (r8 == false) goto L33;
            r11 = true;
        L33:
            if (r18 == null) goto L35;
            r11 = true;
        L35:
            r8 = true;
            goto L53
        L37:
            if (StringsKt.p(r17, "server_max_window_bits", true) == false) goto L47;
            if (r9 == null) goto L40;
            r11 = true;
        L40:
            if (r18 == null) goto L42;
            Integer r22 = StringsKt.I(r18);
        L43:
            r9 = r22;
            if (r22 != null) goto L53;
        L42:
            r22 = null;
            goto L43
        L47:
            if (StringsKt.p(r17, "server_no_context_takeover", true) == false) goto L28;
            if (r10 == false) goto L50;
            r11 = true;
        L50:
            if (r18 == null) goto L52;
            r11 = true;
        L52:
            r10 = true;
            goto L53
        L18:
            r18 = null;
            goto L19
        L54:
            r12 = r3;
            r6 = true;
        L56:
            r4 = r4 + 1;
            goto L3
        L58:
            return new WebSocketExtensions(r6, r7, r8, r9, r10, r11);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WebSocketExtensions() {
        boolean r1 = false;
        Integer r2 = null;
        boolean r3 = false;
        Integer r4 = null;
        boolean r5 = false;
        boolean r6 = false;
        this(r1, r2, r3, r4, r5, r6, 63, null);
    }

    public static /* synthetic */ WebSocketExtensions copy$default(WebSocketExtensions r4, boolean r5, Integer r6, boolean r7, Integer r8, boolean r9, boolean r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.perMessageDeflate;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.clientMaxWindowBits;
    L8:
        Integer r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.clientNoContextTakeover;
    L11:
        boolean r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.serverMaxWindowBits;
    L14:
        Integer r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.serverNoContextTakeover;
    L17:
        boolean r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.unknownValues;
    L20:
        boolean r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    @Nullable
    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    @Nullable
    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    @NotNull
    public final WebSocketExtensions copy(boolean r8, @Nullable Integer r9, boolean r10, @Nullable Integer r11, boolean r12, boolean r13) {
        return new WebSocketExtensions(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(@Nullable Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WebSocketExtensions) == false) goto L18;
        WebSocketExtensions r4 = (WebSocketExtensions) r3;
        if (this.perMessageDeflate == r4.perMessageDeflate) goto L8;
        return false;
    L8:
        if (Intrinsics.a(this.clientMaxWindowBits, r4.clientMaxWindowBits) == true) goto L10;
        return false;
    L10:
        if (this.clientNoContextTakeover == r4.clientNoContextTakeover) goto L12;
        return false;
    L12:
        if (Intrinsics.a(this.serverMaxWindowBits, r4.serverMaxWindowBits) == true) goto L14;
        return false;
    L14:
        if (this.serverNoContextTakeover == r4.serverNoContextTakeover) goto L16;
        return false;
    L16:
        if (this.unknownValues == r4.unknownValues) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean r0 = this.perMessageDeflate;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        Integer r4 = this.clientMaxWindowBits;
        int r5 = 0;
        if (r4 == null) goto L8;
        int r6 = r4.hashCode();
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.clientNoContextTakeover;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.serverMaxWindowBits;
        if (r11 == null) goto L15;
        r5 = r11.hashCode();
    L15:
        int r12 = (r10 + r5) * 31;
        boolean r13 = this.serverNoContextTakeover;
        ?? r14 = r13;
        if (r13 == false) goto L18;
        r14 = 1;
    L18:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.unknownValues;
        if (r16 == true) goto L23;
        r1 = r16;
    L23:
        return r15 + r1;
    L8:
        r6 = 0;
        goto L9
    }

    public final boolean noContextTakeover(boolean r1) {
        if (r1 == false) goto L5;
        return this.clientNoContextTakeover;
    L5:
        return this.serverNoContextTakeover;
    }

    @NotNull
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ")";
    }

    public WebSocketExtensions(boolean r1, @Nullable Integer r2, boolean r3, @Nullable Integer r4, boolean r5, boolean r6) {
        this.perMessageDeflate = r1;
        this.clientMaxWindowBits = r2;
        this.clientNoContextTakeover = r3;
        this.serverMaxWindowBits = r4;
        this.serverNoContextTakeover = r5;
        this.unknownValues = r6;
    }

    public /* synthetic */ WebSocketExtensions(boolean r3, Integer r4, boolean r5, Integer r6, boolean r7, boolean r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r3 = false;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r5 = false;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r7 = false;
    L18:
        if ((r9 & 32) == 0) goto L20;
        r8 = false;
    L20:
        this(r3, r4, r5, r6, r7, r8);
    }
}
