package com.obric.capabilitykit.common;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JA\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/common/FeedbackResult;", "", "code", "", NotificationCompat.CATEGORY_MESSAGE, "", "data", "uiType", "replyFor", "(ILjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getCode", "()I", "getData", "()Ljava/lang/String;", "getMsg", "getReplyFor", "getUiType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FeedbackResult {
    private final int code;
    private final String data;
    private final String msg;
    private final String replyFor;
    private final int uiType;

    public FeedbackResult() {
        this(0, null, null, 0, null, 31, null);
    }

    public FeedbackResult(int r1, String r2, String r3, int r4, String r5) {
        this.code = r1;
        this.msg = r2;
        this.data = r3;
        this.uiType = r4;
        this.replyFor = r5;
    }

    public /* synthetic */ FeedbackResult(int r3, String r4, String r5, int r6, String r7, int r8, g r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r6 = 0;
    L15:
        if ((r8 & 16) == 0) goto L17;
        r7 = "";
    L17:
        this(r3, r4, r5, r6, r7);
    }

    public static /* synthetic */ FeedbackResult copy$default(FeedbackResult r3, int r4, String r5, String r6, int r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.code;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.msg;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.data;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.uiType;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.replyFor;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final String component3() {
        return this.data;
    }

    public final int component4() {
        return this.uiType;
    }

    public final String component5() {
        return this.replyFor;
    }

    public final FeedbackResult copy(int r7, String r8, String r9, int r10, String r11) {
        return new FeedbackResult(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FeedbackResult) == true) goto L8;
        return false;
    L8:
        FeedbackResult r6 = (FeedbackResult) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (o.a(this.msg, r6.msg) == true) goto L15;
        return false;
    L15:
        if (o.a(this.data, r6.data) == true) goto L18;
        return false;
    L18:
        if (this.uiType == r6.uiType) goto L21;
        return false;
    L21:
        if (o.a(this.replyFor, r6.replyFor) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public int hashCode() {
        int r0 = Integer.hashCode(this.code) * 31;
        String r1 = this.msg;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.data;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Integer.hashCode(this.uiType)) * 31;
        String r8 = this.replyFor;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "FeedbackResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ')';
    }
}
