package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import android.icu.text.PluralRules;
import androidx.core.util.Pools;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FpsBean.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b:\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 I2\u00020\u0001:\u0001IB\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\u008b\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u0007HÆ\u0001J\u0013\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\u0006\u0010E\u001a\u00020FJ\b\u0010G\u001a\u00020HH\u0016R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0014\"\u0004\b.\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0014\"\u0004\b0\u0010\u0016R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016¨\u0006J"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "", "fps", "", "duration", "", "startX", "", "startY", "endX", "endY", "distantX", "distantY", "dropRate", "frameCount", "drop3", "drop7", "drop25", "(DJIIIIIIDIIII)V", "getDistantX", "()I", "setDistantX", "(I)V", "getDistantY", "setDistantY", "getDrop25", "setDrop25", "getDrop3", "setDrop3", "getDrop7", "setDrop7", "getDropRate", "()D", "setDropRate", "(D)V", "getDuration", "()J", "setDuration", "(J)V", "getEndX", "setEndX", "getEndY", "setEndY", "getFps", "setFps", "getFrameCount", "setFrameCount", "getStartX", "setStartX", "getStartY", "setStartY", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "recycle", "", "toString", "", "Companion", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FpsBean {
    public static final Companion Companion = null;
    private static final Pools.SynchronizedPool<FpsBean> FPS_BEAN_POOL = null;
    private int distantX;
    private int distantY;
    private int drop25;
    private int drop3;
    private int drop7;
    private double dropRate;
    private long duration;
    private int endX;
    private int endY;
    private double fps;
    private int frameCount;
    private int startX;
    private int startY;

    /* JADX INFO: compiled from: FpsBean.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean$Companion;", "", "()V", "FPS_BEAN_POOL", "Landroidx/core/util/Pools$SynchronizedPool;", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FpsBean;", "obtain", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final FpsBean obtain() {
            FpsBean r0 = (FpsBean) FpsBean.access$getFPS_BEAN_POOL$cp().acquire();
            if (r0 == null) goto L5;
            return r0;
        L5:
            return new FpsBean(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
        }
    }

    public FpsBean() {
        this(0.0d, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0, 0, 0, 8191, null);
    }

    public static /* synthetic */ FpsBean copy$default(FpsBean r16, double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        double r2 = r16.fps;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = r16.duration;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r6 = r16.startX;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r7 = r16.startY;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r8 = r16.endX;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r9 = r16.endY;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r10 = r16.distantX;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r11 = r16.distantY;
    L35:
        if ((r33 & 256) == 0) goto L37;
        double r12 = r16.dropRate;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r14 = r16.frameCount;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r15 = r16.drop3;
    L46:
        int r35 = r15;
        if ((r33 & 2048) == 0) goto L49;
        int r18 = r16.drop7;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r1 = r16.drop25;
    L55:
        return r16.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r14, r35, r18, r1);
    L53:
        r1 = r32;
        goto L55
    L49:
        r18 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L46
    L41:
        r14 = r29;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final double component1() {
        return this.fps;
    }

    public final int component10() {
        return this.frameCount;
    }

    public final int component11() {
        return this.drop3;
    }

    public final int component12() {
        return this.drop7;
    }

    public final int component13() {
        return this.drop25;
    }

    public final long component2() {
        return this.duration;
    }

    public final int component3() {
        return this.startX;
    }

    public final int component4() {
        return this.startY;
    }

    public final int component5() {
        return this.endX;
    }

    public final int component6() {
        return this.endY;
    }

    public final int component7() {
        return this.distantX;
    }

    public final int component8() {
        return this.distantY;
    }

    public final double component9() {
        return this.dropRate;
    }

    public final FpsBean copy(double r19, long r21, int r23, int r24, int r25, int r26, int r27, int r28, double r29, int r31, int r32, int r33, int r34) {
        return new FpsBean(r19, r21, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof FpsBean) == true) goto L8;
        return false;
    L8:
        FpsBean r9 = (FpsBean) r8;
        if (Intrinsics.areEqual(Double.valueOf(this.fps), Double.valueOf(r9.fps)) == true) goto L12;
        return false;
    L12:
        if (this.duration == r9.duration) goto L15;
        return false;
    L15:
        if (this.startX == r9.startX) goto L18;
        return false;
    L18:
        if (this.startY == r9.startY) goto L21;
        return false;
    L21:
        if (this.endX == r9.endX) goto L24;
        return false;
    L24:
        if (this.endY == r9.endY) goto L27;
        return false;
    L27:
        if (this.distantX == r9.distantX) goto L30;
        return false;
    L30:
        if (this.distantY == r9.distantY) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(Double.valueOf(this.dropRate), Double.valueOf(r9.dropRate)) == true) goto L36;
        return false;
    L36:
        if (this.frameCount == r9.frameCount) goto L39;
        return false;
    L39:
        if (this.drop3 == r9.drop3) goto L42;
        return false;
    L42:
        if (this.drop7 == r9.drop7) goto L45;
        return false;
    L45:
        if (this.drop25 == r9.drop25) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        return (((((((((((((((((((((((Double.hashCode(this.fps) * 31) + Long.hashCode(this.duration)) * 31) + Integer.hashCode(this.startX)) * 31) + Integer.hashCode(this.startY)) * 31) + Integer.hashCode(this.endX)) * 31) + Integer.hashCode(this.endY)) * 31) + Integer.hashCode(this.distantX)) * 31) + Integer.hashCode(this.distantY)) * 31) + Double.hashCode(this.dropRate)) * 31) + Integer.hashCode(this.frameCount)) * 31) + Integer.hashCode(this.drop3)) * 31) + Integer.hashCode(this.drop7)) * 31) + Integer.hashCode(this.drop25);
    }

    public FpsBean(double r4, long r6, int r8, int r9, int r10, int r11, int r12, int r13, double r14, int r16, int r17, int r18, int r19) {
        this.fps = r4;
        this.duration = r6;
        this.startX = r8;
        this.startY = r9;
        this.endX = r10;
        this.endY = r11;
        this.distantX = r12;
        this.distantY = r13;
        this.dropRate = r14;
        this.frameCount = r16;
        this.drop3 = r17;
        this.drop7 = r18;
        this.drop25 = r19;
    }

    public /* synthetic */ FpsBean(double r17, long r19, int r21, int r22, int r23, int r24, int r25, int r26, double r27, int r29, int r30, int r31, int r32, int r33, DefaultConstructorMarker r34) {
        double r2 = 0.0d;
        if ((r33 & 1) == 0) goto L5;
        double r4 = 0.0d;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r6 = 0;
    L11:
        if ((r33 & 4) == 0) goto L13;
        int r1 = 0;
    L15:
        if ((r33 & 8) == 0) goto L17;
        int r9 = 0;
    L19:
        if ((r33 & 16) == 0) goto L21;
        int r10 = 0;
    L23:
        if ((r33 & 32) == 0) goto L25;
        int r11 = 0;
    L27:
        if ((r33 & 64) == 0) goto L29;
        int r12 = 0;
    L31:
        if ((r33 & 128) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r33 & 256) != 0) goto L39;
        r2 = r27;
    L39:
        if ((r33 & 512) == 0) goto L41;
        int r14 = 0;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        int r15 = 0;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r8 = 0;
    L51:
        if ((r33 & 4096) == 0) goto L53;
        int r0 = 0;
    L54:
        this(r4, r6, r1, r9, r10, r11, r12, r13, r2, r14, r15, r8, r0);
        return;
    L53:
        r0 = r32;
        goto L54
    L49:
        r8 = r31;
        goto L51
    L45:
        r15 = r30;
        goto L47
    L41:
        r14 = r29;
        goto L43
    L33:
        r13 = r26;
        goto L35
    L29:
        r12 = r25;
        goto L31
    L25:
        r11 = r24;
        goto L27
    L21:
        r10 = r23;
        goto L23
    L17:
        r9 = r22;
        goto L19
    L13:
        r1 = r21;
        goto L15
    L9:
        r6 = r19;
        goto L11
    L5:
        r4 = r17;
        goto L7
    }

    public static final /* synthetic */ Pools.SynchronizedPool access$getFPS_BEAN_POOL$cp() {
        return FPS_BEAN_POOL;
    }

    public final double getFps() {
        return this.fps;
    }

    public final void setFps(double r1) {
        this.fps = r1;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final int getStartX() {
        return this.startX;
    }

    public final void setStartX(int r1) {
        this.startX = r1;
    }

    public final int getStartY() {
        return this.startY;
    }

    public final void setStartY(int r1) {
        this.startY = r1;
    }

    public final int getEndX() {
        return this.endX;
    }

    public final void setEndX(int r1) {
        this.endX = r1;
    }

    public final int getEndY() {
        return this.endY;
    }

    public final void setEndY(int r1) {
        this.endY = r1;
    }

    public final int getDistantX() {
        return this.distantX;
    }

    public final void setDistantX(int r1) {
        this.distantX = r1;
    }

    public final int getDistantY() {
        return this.distantY;
    }

    public final void setDistantY(int r1) {
        this.distantY = r1;
    }

    public final double getDropRate() {
        return this.dropRate;
    }

    public final void setDropRate(double r1) {
        this.dropRate = r1;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final void setFrameCount(int r1) {
        this.frameCount = r1;
    }

    public final int getDrop3() {
        return this.drop3;
    }

    public final void setDrop3(int r1) {
        this.drop3 = r1;
    }

    public final int getDrop7() {
        return this.drop7;
    }

    public final void setDrop7(int r1) {
        this.drop7 = r1;
    }

    public final int getDrop25() {
        return this.drop25;
    }

    public final void setDrop25(int r1) {
        this.drop25 = r1;
    }

    public final void recycle() {
        this.fps = 0.0d;
        this.dropRate = 0.0d;
        this.drop3 = 0;
        this.drop7 = 0;
        this.drop25 = 0;
        this.frameCount = 0;
        this.duration = 0;
        this.startX = 0;
        this.startY = 0;
        this.endX = 0;
        this.endY = 0;
        this.distantX = 0;
        this.distantY = 0;
        FPS_BEAN_POOL.release(this);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("FpsBean(fps=");
        r0.append(this.fps).append(", duration=").append(this.duration).append(", startX=").append(this.startX).append(", startY=").append(this.startY).append(", endX=").append(this.endX).append(", endY=").append(this.endY).append(", distantX=").append(this.distantX).append(", distantY=").append(this.distantY).append(", dropRate=").append(this.dropRate).append(", frameCount=").append(this.frameCount).append(", drop3=").append(this.drop3).append(", drop7=");
        r0.append(this.drop7).append(", drop25=").append(this.drop25).append(')');
        return r0.toString();
    }

    static {
        Companion = new Companion(null);
        FPS_BEAN_POOL = new Pools.SynchronizedPool(5);
    }
}
