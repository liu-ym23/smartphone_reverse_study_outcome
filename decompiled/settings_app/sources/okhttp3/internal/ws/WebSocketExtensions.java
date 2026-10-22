package okhttp3.internal.ws;

import android.icu.text.PluralRules;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: WebSocketExtensions.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JN\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "perMessageDeflate", "", "clientMaxWindowBits", "", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "noContextTakeover", "clientOriginated", "toString", "", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebSocketExtensions {
    public static final Companion Companion = null;
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    /* JADX INFO: compiled from: WebSocketExtensions.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "()V", "HEADER_WEB_SOCKET_EXTENSION", "", "parse", "Lokhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lokhttp3/Headers;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final WebSocketExtensions parse(Headers r22) throws IOException {
            Intrinsics.checkNotNullParameter(r22, "responseHeaders");
            int r1 = r22.size();
            int r4 = 0;
            boolean r6 = false;
            Integer r7 = null;
            boolean r8 = false;
            Integer r9 = null;
            boolean r10 = false;
            boolean r11 = false;
        L3:
            if (r4 >= r1) goto L56;
            int r5 = r4 + 1;
            if (StringsKt.equals(r22.name(r4), "Sec-WebSocket-Extensions", true) == false) goto L6;
            String r12 = r22.value(r4);
            int r13 = 0;
        L9:
            if (r13 >= r12.length()) goto L6;
            int r14 = Util.delimiterOffset$default(r12, ',', r13, 0, 4, null);
            int r2 = Util.delimiterOffset(r12, ';', r13, r14);
            String r15 = Util.trimSubstring(r12, r13, r2);
            r13 = r2 + 1;
            if (StringsKt.equals(r15, "permessage-deflate", true) == true) goto L12;
            r13 = r13;
            r11 = true;
            goto L9
        L12:
            if (r6 == false) goto L14;
            r11 = true;
        L14:
            r13 = r13;
        L15:
            if (r13 >= r14) goto L53;
            int r3 = Util.delimiterOffset(r12, ';', r13, r14);
            int r16 = Util.delimiterOffset(r12, '=', r13, r3);
            String r17 = Util.trimSubstring(r12, r13, r16);
            if (r16 >= r3) goto L19;
            String r18 = StringsKt.removeSurrounding(Util.trimSubstring(r12, r16 + 1, r3), "\"");
        L20:
            r13 = r3 + 1;
            if (StringsKt.equals(r17, "client_max_window_bits", true) == true) goto L22;
            if (StringsKt.equals(r17, "client_no_context_takeover", true) == false) goto L37;
            if (r8 == false) goto L33;
            r11 = true;
        L33:
            if (r18 == null) goto L35;
            r11 = true;
        L35:
            r8 = true;
            goto L15
        L37:
            if (StringsKt.equals(r17, "server_max_window_bits", true) == true) goto L38;
            if (StringsKt.equals(r17, "server_no_context_takeover", true) == false) goto L52;
            if (r10 == false) goto L49;
            r11 = true;
        L49:
            if (r18 == null) goto L51;
            r11 = true;
        L51:
            r10 = true;
        L52:
            r11 = true;
            goto L15
        L38:
            if (r9 == null) goto L40;
            r11 = true;
        L40:
            if (r18 != null) goto L42;
            r9 = null;
        L43:
            if (r9 != null) goto L14;
        L42:
            r9 = StringsKt.toIntOrNull(r18);
            goto L43
        L22:
            if (r7 == null) goto L24;
            r11 = true;
        L24:
            if (r18 != null) goto L26;
            r7 = null;
        L27:
            if (r7 != null) goto L14;
        L26:
            r7 = StringsKt.toIntOrNull(r18);
            goto L27
        L19:
            String r19 = (String) null;
            r18 = null;
            goto L20
        L53:
            r6 = true;
        L6:
            r4 = r5;
            goto L3
        L56:
            return new WebSocketExtensions(r6, r7, r8, r9, r10, r11);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
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

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean r8, Integer r9, boolean r10, Integer r11, boolean r12, boolean r13) {
        return new WebSocketExtensions(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WebSocketExtensions) == true) goto L8;
        return false;
    L8:
        WebSocketExtensions r6 = (WebSocketExtensions) r5;
        if (this.perMessageDeflate == r6.perMessageDeflate) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.clientMaxWindowBits, r6.clientMaxWindowBits) == true) goto L15;
        return false;
    L15:
        if (this.clientNoContextTakeover == r6.clientNoContextTakeover) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.serverMaxWindowBits, r6.serverMaxWindowBits) == true) goto L21;
        return false;
    L21:
        if (this.serverNoContextTakeover == r6.serverNoContextTakeover) goto L24;
        return false;
    L24:
        if (this.unknownValues == r6.unknownValues) goto L26;
        return false;
    L26:
        return true;
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
        if (r4 != null) goto L8;
        int r6 = 0;
    L9:
        int r7 = (r3 + r6) * 31;
        boolean r8 = this.clientNoContextTakeover;
        ?? r9 = r8;
        if (r8 == false) goto L12;
        r9 = 1;
    L12:
        int r10 = (r7 + r9) * 31;
        Integer r11 = this.serverMaxWindowBits;
        if (r11 == null) goto L16;
        r5 = r11.hashCode();
    L16:
        int r12 = (r10 + r5) * 31;
        boolean r13 = this.serverNoContextTakeover;
        ?? r14 = r13;
        if (r13 == false) goto L19;
        r14 = 1;
    L19:
        int r15 = (r12 + r14) * 31;
        boolean r16 = this.unknownValues;
        if (r16 == true) goto L24;
        r1 = r16;
    L24:
        return r15 + r1;
    L8:
        r6 = r4.hashCode();
        goto L9
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean r1, Integer r2, boolean r3, Integer r4, boolean r5, boolean r6) {
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

    public final boolean noContextTakeover(boolean r1) {
        if (r1 == false) goto L5;
        return this.clientNoContextTakeover;
    L5:
        return this.serverNoContextTakeover;
    }
}
