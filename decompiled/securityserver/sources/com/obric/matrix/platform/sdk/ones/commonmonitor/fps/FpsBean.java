package com.obric.matrix.platform.sdk.ones.commonmonitor.fps;

import a.a;
import androidx.core.util.Pools;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class FpsBean {

    @NotNull
    public static final Companion Companion = null;

    @NotNull
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

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final FpsBean obtain() {
            FpsBean r0 = (FpsBean) FpsBean.access$getFPS_BEAN_POOL$cp().acquire();
            if (r0 != null) goto L6;
            double r2 = 0.0d;
            long r4 = 0;
            int r6 = 0;
            int r7 = 0;
            int r8 = 0;
            int r9 = 0;
            int r10 = 0;
            int r11 = 0;
            double r12 = 0.0d;
            int r14 = 0;
            int r15 = 0;
            int r16 = 0;
            int r17 = 0;
            return new FpsBean(r2, r4, r6, r7, r8, r9, r10, r11, r12, r14, r15, r16, r17, 8191, null);
        L6:
            return r0;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        FPS_BEAN_POOL = new Pools.SynchronizedPool(5);
    }

    public FpsBean() {
        double r1 = 0.0d;
        long r3 = 0;
        int r5 = 0;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
        int r10 = 0;
        double r11 = 0.0d;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
        int r16 = 0;
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r13, r14, r15, r16, 8191, null);
    }

    public static final /* synthetic */ Pools.SynchronizedPool access$getFPS_BEAN_POOL$cp() {
        return FPS_BEAN_POOL;
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

    @NotNull
    public final FpsBean copy(double r19, long r21, int r23, int r24, int r25, int r26, int r27, int r28, double r29, int r31, int r32, int r33, int r34) {
        return new FpsBean(r19, r21, r23, r24, r25, r26, r27, r28, r29, r31, r32, r33, r34);
    }

    public boolean equals(@Nullable Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof FpsBean) == true) goto L8;
        return false;
    L8:
        FpsBean r9 = (FpsBean) r8;
        if (Double.valueOf(this.fps).equals(Double.valueOf(r9.fps)) == true) goto L12;
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
        if (Double.valueOf(this.dropRate).equals(Double.valueOf(r9.dropRate)) == true) goto L36;
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

    public final int getDistantX() {
        return this.distantX;
    }

    public final int getDistantY() {
        return this.distantY;
    }

    public final int getDrop25() {
        return this.drop25;
    }

    public final int getDrop3() {
        return this.drop3;
    }

    public final int getDrop7() {
        return this.drop7;
    }

    public final double getDropRate() {
        return this.dropRate;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getEndX() {
        return this.endX;
    }

    public final int getEndY() {
        return this.endY;
    }

    public final double getFps() {
        return this.fps;
    }

    public final int getFrameCount() {
        return this.frameCount;
    }

    public final int getStartX() {
        return this.startX;
    }

    public final int getStartY() {
        return this.startY;
    }

    public int hashCode() {
        int r0 = Double.hashCode(this.fps) * 31;
        int r2 = (Long.hashCode(this.duration) + r0) * 31;
        int r1 = a.c(this.startX, r2, 31);
        int r3 = a.c(this.startY, r1, 31);
        int r4 = a.c(this.endX, r3, 31);
        int r5 = a.c(this.endY, r4, 31);
        int r6 = a.c(this.distantX, r5, 31);
        int r7 = a.c(this.distantY, r6, 31);
        int r8 = (Double.hashCode(this.dropRate) + r7) * 31;
        int r9 = a.c(this.frameCount, r8, 31);
        int r10 = a.c(this.drop3, r9, 31);
        int r11 = a.c(this.drop7, r10, 31);
        return Integer.hashCode(this.drop25) + r11;
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

    public final void setDistantX(int r1) {
        this.distantX = r1;
    }

    public final void setDistantY(int r1) {
        this.distantY = r1;
    }

    public final void setDrop25(int r1) {
        this.drop25 = r1;
    }

    public final void setDrop3(int r1) {
        this.drop3 = r1;
    }

    public final void setDrop7(int r1) {
        this.drop7 = r1;
    }

    public final void setDropRate(double r1) {
        this.dropRate = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setEndX(int r1) {
        this.endX = r1;
    }

    public final void setEndY(int r1) {
        this.endY = r1;
    }

    public final void setFps(double r1) {
        this.fps = r1;
    }

    public final void setFrameCount(int r1) {
        this.frameCount = r1;
    }

    public final void setStartX(int r1) {
        this.startX = r1;
    }

    public final void setStartY(int r1) {
        this.startY = r1;
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder("FpsBean(fps=");
        r0.append(this.fps);
        r0.append(", duration=");
        r0.append(this.duration);
        r0.append(", startX=");
        r0.append(this.startX);
        r0.append(", startY=");
        r0.append(this.startY);
        r0.append(", endX=");
        r0.append(this.endX);
        r0.append(", endY=");
        r0.append(this.endY);
        r0.append(", distantX=");
        r0.append(this.distantX);
        r0.append(", distantY=");
        r0.append(this.distantY);
        r0.append(", dropRate=");
        r0.append(this.dropRate);
        r0.append(", frameCount=");
        r0.append(this.frameCount);
        r0.append(", drop3=");
        r0.append(this.drop3);
        r0.append(", drop7=");
        r0.append(this.drop7);
        r0.append(", drop25=");
        return a.l(r0, this.drop25, ')');
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
}
