package com.bytedance.android.sdk.bdticketguard;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: classes.dex */
public final class n extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f863k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f864l;

    public n(String r18, String r19, String r20, String r21, String r22, boolean r23, boolean r24, boolean r25, boolean r26, long r27, boolean r29) {
        this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r29, false, null, 6144, null);
    }

    public n(String r17, String r18, String r19, String r20, String r21, boolean r22, boolean r23, boolean r24, boolean r25, long r26, boolean r28, boolean r29, String r30) {
        kotlin.n0.d.o.g(r17, "tsSign");
        kotlin.n0.d.o.g(r18, TypedValues.AttributesType.S_TARGET);
        kotlin.n0.d.o.g(r19, "host");
        kotlin.n0.d.o.g(r20, "path");
        kotlin.n0.d.o.g(r21, "ticketName");
        kotlin.n0.d.o.g(r30, "attestTsSign");
        super(r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29);
        this.f863k = r17;
        this.f864l = r30;
    }

    public /* synthetic */ n(String r19, String r20, String r21, String r22, String r23, boolean r24, boolean r25, boolean r26, boolean r27, long r28, boolean r30, boolean r31, String r32, int r33, kotlin.n0.d.g r34) {
        if ((r33 & 32) == 0) goto L5;
        boolean r9 = false;
    L7:
        if ((r33 & 64) == 0) goto L9;
        boolean r10 = false;
    L11:
        if ((r33 & 128) == 0) goto L13;
        boolean r11 = !r9;
    L15:
        if ((r33 & 256) == 0) goto L17;
        boolean r12 = true;
    L19:
        if ((r33 & 512) == 0) goto L21;
        long r13 = 0;
    L23:
        if ((r33 & 1024) == 0) goto L25;
        boolean r15 = false;
    L27:
        if ((r33 & 2048) == 0) goto L29;
        boolean r16 = false;
    L31:
        if ((r33 & 4096) == 0) goto L33;
        String r17 = "";
    L34:
        this(r19, r20, r21, r22, r23, r9, r10, r11, r12, r13, r15, r16, r17);
        return;
    L33:
        r17 = r32;
        goto L34
    L29:
        r16 = r31;
        goto L31
    L25:
        r15 = r30;
        goto L27
    L21:
        r13 = r28;
        goto L23
    L17:
        r12 = r27;
        goto L19
    L13:
        r11 = r26;
        goto L15
    L9:
        r10 = r25;
        goto L11
    L5:
        r9 = r24;
        goto L7
    }

    public final String k() {
        return this.f864l;
    }

    public final String l() {
        return this.f863k;
    }
}
