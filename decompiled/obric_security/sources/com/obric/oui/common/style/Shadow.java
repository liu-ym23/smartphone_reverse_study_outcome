package com.obric.oui.common.style;

import android.graphics.BlurMaskFilter;
import android.graphics.Paint;
import com.obric.oui.common.util.OUnitExtensionKt;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.shadow.ShadowConfig;
import com.obric.oui.utils.AnimUtils;
import com.obric.security.health.score.HealthModuleIds;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: Shadow.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 62\u00020\u0001:\u00016BC\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\u0006\u0010(\u001a\u00020\u0000JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0006\u0010-\u001a\u00020.J\t\u0010/\u001a\u000200HÖ\u0001J\u0010\u00101\u001a\u00020.2\b\u00102\u001a\u0004\u0018\u00010\u0000J\u000e\u00103\u001a\u00020.2\u0006\u00102\u001a\u000204J\u0006\u00105\u001a\u00020*R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00067"}, d2 = {"Lcom/obric/oui/common/style/Shadow;", "", "color", "", "radius", "", "offsetX", "offsetY", MaterialConfigFormatNames.SPREAD, "paint", "Landroid/graphics/Paint;", "cornerRadius", "(IFFFFLandroid/graphics/Paint;F)V", "getColor", "()I", "setColor", "(I)V", "getCornerRadius", "()F", "setCornerRadius", "(F)V", "getOffsetX", "setOffsetX", "getOffsetY", "setOffsetY", "getPaint", "()Landroid/graphics/Paint;", "setPaint", "(Landroid/graphics/Paint;)V", "getRadius", "setRadius", "getSpread", "setSpread", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "reset", "", "toString", "", HealthModuleIds.UPDATE, "config", "updateFromConfig", "Lcom/obric/oui/shadow/ShadowConfig;", "valid", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Shadow {
    public static final Companion Companion = null;
    public static final Shadow NONE = null;
    private int color;
    private float cornerRadius;
    private float offsetX;
    private float offsetY;
    private Paint paint;
    private float radius;
    private float spread;

    /* JADX INFO: compiled from: Shadow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007JH\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0007J8\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\fH\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/common/style/Shadow$Companion;", "", "()V", "NONE", "Lcom/obric/oui/common/style/Shadow;", "fromConfig", "config", "Lcom/obric/oui/shadow/ShadowConfig;", "fromConfigWithDensity", "density", "", "getShadowForTransition", "", "currentScale", "startScale", "endScale", "fromShadows", "toShadows", "fraction", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Shadow fromConfig(ShadowConfig r11) {
            Intrinsics.checkNotNullParameter(r11, "config");
            Shadow r10 = new Shadow(r11.getColor(), r11.getBlurRadius(), r11.getX(), r11.getY(), r11.getSpread(), null, 0.0f, 96, null);
            if (r10.getRadius() <= 0.0f) goto L5;
            r10.getPaint().setMaskFilter(new BlurMaskFilter(r10.getRadius(), BlurMaskFilter.Blur.NORMAL));
        L6:
            return r10;
        L5:
            r10.getPaint().setMaskFilter(null);
            goto L6
        }

        @JvmStatic
        public final Shadow fromConfigWithDensity(ShadowConfig r11, float r12) {
            Intrinsics.checkNotNullParameter(r11, "config");
            Shadow r10 = new Shadow(r11.getColor(), OUnitExtensionKt.dp2pxFloat(r11.getBlurRadius(), r12), OUnitExtensionKt.dp2pxFloat(r11.getX(), r12), OUnitExtensionKt.dp2pxFloat(r11.getY(), r12), OUnitExtensionKt.dp2pxFloat(r11.getSpread(), r12), null, 0.0f, 96, null);
            if (r10.getRadius() <= 0.0f) goto L5;
            r10.getPaint().setMaskFilter(new BlurMaskFilter(r10.getRadius(), BlurMaskFilter.Blur.NORMAL));
        L6:
            return r10;
        L5:
            r10.getPaint().setMaskFilter(null);
            goto L6
        }

        @JvmStatic
        public final List<Shadow> getShadowForTransition(float r2, float r3, float r4, List<Shadow> r5, List<Shadow> r6) {
            if (r4 != r3) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L9;
            return r5;
        L9:
            return getShadowForTransition((r2 - r3) / (r4 - r3), r5, r6);
        L5:
            r0 = false;
            goto L6
        }

        @JvmStatic
        public final List<Shadow> getShadowForTransition(float r17, List<Shadow> r18, List<Shadow> r19) {
            if (Float.isInfinite(r17) == false) goto L5;
        L7:
            boolean r0 = false;
        L9:
            if (r0 == false) goto L11;
            float r1 = r17;
        L12:
            float r2 = RangesKt.coerceIn(r1, 0.0f, 1.0f);
            if (r18 == null) goto L25;
            if (r19 == null) goto L25;
            if (r18.size() != r19.size()) goto L25;
            List<Shadow> r3 = r18;
            Iterator<T> r4 = r3.iterator();
            List<Shadow> r5 = r19;
            Iterator<T> r6 = r5.iterator();
            ArrayList r7 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(r3, 10), CollectionsKt.collectionSizeOrDefault(r5, 10)));
        L19:
            if (r4.hasNext() == false) goto L28;
            if (r6.hasNext() == false) goto L28;
            Object r8 = r4.next();
            Shadow r9 = (Shadow) r6.next();
            Shadow r10 = (Shadow) r8;
            r7.add(new Shadow(AnimUtils.evaluateColor(r2, r10.getColor(), r9.getColor()), AnimUtils.lerp(r10.getRadius(), r9.getRadius(), r2), AnimUtils.lerp(r10.getOffsetX(), r9.getOffsetX(), r2), AnimUtils.lerp(r10.getOffsetY(), r9.getOffsetY(), r2), AnimUtils.lerp(r10.getSpread(), r9.getSpread(), r2), null, 0.0f, 96, null));
        L28:
            return r7;
        L25:
            return r18;
        L11:
            r1 = 0.0f;
            goto L12
        L5:
            if (Float.isNaN(r17) == true) goto L7;
            r0 = true;
            goto L9
        }
    }

    public Shadow(int r11, float r12, float r13, float r14, float r15) {
        this(r11, r12, r13, r14, r15, null, 0.0f, 96, null);
    }

    public Shadow(int r12, float r13, float r14, float r15, float r16, Paint r17) {
        Intrinsics.checkNotNullParameter(r17, "paint");
        this(r12, r13, r14, r15, r16, r17, 0.0f, 64, null);
    }

    public static /* synthetic */ Shadow copy$default(Shadow r5, int r6, float r7, float r8, float r9, float r10, Paint r11, float r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.color;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.radius;
    L8:
        float r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.offsetX;
    L11:
        float r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.offsetY;
    L14:
        float r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.spread;
    L17:
        float r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.paint;
    L20:
        Paint r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.cornerRadius;
    L23:
        int r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    @JvmStatic
    public static final Shadow fromConfig(ShadowConfig r1) {
        return Companion.fromConfig(r1);
    }

    @JvmStatic
    public static final Shadow fromConfigWithDensity(ShadowConfig r1, float r2) {
        return Companion.fromConfigWithDensity(r1, r2);
    }

    @JvmStatic
    public static final List<Shadow> getShadowForTransition(float r6, float r7, float r8, List<Shadow> r9, List<Shadow> r10) {
        return Companion.getShadowForTransition(r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final List<Shadow> getShadowForTransition(float r1, List<Shadow> r2, List<Shadow> r3) {
        return Companion.getShadowForTransition(r1, r2, r3);
    }

    public final int component1() {
        return this.color;
    }

    public final float component2() {
        return this.radius;
    }

    public final float component3() {
        return this.offsetX;
    }

    public final float component4() {
        return this.offsetY;
    }

    public final float component5() {
        return this.spread;
    }

    public final Paint component6() {
        return this.paint;
    }

    public final float component7() {
        return this.cornerRadius;
    }

    public final Shadow copy(int r9, float r10, float r11, float r12, float r13, Paint r14, float r15) {
        Intrinsics.checkNotNullParameter(r14, "paint");
        return new Shadow(r9, r10, r11, r12, r13, r14, r15);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.color) * 31) + Float.hashCode(this.radius)) * 31) + Float.hashCode(this.offsetX)) * 31) + Float.hashCode(this.offsetY)) * 31) + Float.hashCode(this.spread)) * 31) + this.paint.hashCode()) * 31) + Float.hashCode(this.cornerRadius);
    }

    public String toString() {
        return "Shadow(color=" + this.color + ", radius=" + this.radius + ", offsetX=" + this.offsetX + ", offsetY=" + this.offsetY + ", spread=" + this.spread + ", paint=" + this.paint + ", cornerRadius=" + this.cornerRadius + ')';
    }

    public Shadow(int r2, float r3, float r4, float r5, float r6, Paint r7, float r8) {
        Intrinsics.checkNotNullParameter(r7, "paint");
        this.color = r2;
        this.radius = r3;
        this.offsetX = r4;
        this.offsetY = r5;
        this.spread = r6;
        this.paint = r7;
        this.cornerRadius = r8;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int r1) {
        this.color = r1;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final void setRadius(float r1) {
        this.radius = r1;
    }

    public final float getOffsetX() {
        return this.offsetX;
    }

    public final void setOffsetX(float r1) {
        this.offsetX = r1;
    }

    public final float getOffsetY() {
        return this.offsetY;
    }

    public final void setOffsetY(float r1) {
        this.offsetY = r1;
    }

    public final float getSpread() {
        return this.spread;
    }

    public final void setSpread(float r1) {
        this.spread = r1;
    }

    public /* synthetic */ Shadow(int r11, float r12, float r13, float r14, float r15, Paint r16, float r17, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 32) == 0) goto L5;
        Paint r8 = new Paint(1);
    L7:
        if ((r18 & 64) == 0) goto L9;
        float r9 = 0.0f;
    L10:
        this(r11, r12, r13, r14, r15, r8, r9);
        return;
    L9:
        r9 = r17;
        goto L10
    L5:
        r8 = r16;
        goto L7
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final void setPaint(Paint r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.paint = r2;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(float r1) {
        this.cornerRadius = r1;
    }

    public final boolean valid() {
        if (this.offsetX != 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return true;
    L8:
        if (this.offsetY != 0.0f) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        return true;
    L13:
        if (this.radius != 0.0f) goto L15;
        boolean r2 = true;
    L16:
        if (r2 == true) goto L18;
        return true;
    L18:
        if (this.spread != 0.0f) goto L20;
        boolean r4 = true;
    L21:
        if (r4 == true) goto L24;
        return true;
    L24:
        return false;
    L20:
        r4 = false;
        goto L21
    L15:
        r2 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final void updateFromConfig(ShadowConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "config");
        this.color = r3.getColor();
        this.offsetX = r3.getX();
        this.offsetY = r3.getY();
        this.spread = r3.getSpread();
        if (this.radius != r3.getBlurRadius()) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L12;
        float r4 = r3.getBlurRadius();
        this.radius = r4;
        if (r4 <= 0.0f) goto L10;
        this.paint.setMaskFilter(new BlurMaskFilter(this.radius, BlurMaskFilter.Blur.NORMAL));
        return;
    L10:
        this.paint.setMaskFilter(null);
        return;
    L12:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final void update(Shadow r3) {
        if (r3 == null) goto L12;
        this.color = r3.color;
        this.offsetX = r3.offsetX;
        this.offsetY = r3.offsetY;
        this.spread = r3.spread;
        float r0 = this.radius;
        float r4 = r3.radius;
        if (r0 != r4) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L14;
        this.radius = r4;
        if (r4 <= 0.0f) goto L11;
        this.paint.setMaskFilter(new BlurMaskFilter(this.radius, BlurMaskFilter.Blur.NORMAL));
        return;
    L11:
        this.paint.setMaskFilter(null);
        return;
    L14:
        return;
    L6:
        r1 = false;
        goto L7
    L12:
        reset();
    }

    public final void reset() {
        this.color = 0;
        this.radius = 0.0f;
        this.offsetX = 0.0f;
        this.offsetY = 0.0f;
        this.spread = 0.0f;
        this.cornerRadius = 0.0f;
        this.paint.setMaskFilter(null);
    }

    static {
        Companion = new Companion(null);
        NONE = new Shadow(0, 0.0f, 0.0f, 0.0f, 0.0f, null, 0.0f, 96, null);
    }

    public final Shadow copy() {
        int r1 = this.color;
        float r2 = this.radius;
        float r3 = this.offsetX;
        float r4 = this.offsetY;
        float r5 = this.spread;
        Paint r6 = new Paint(this.paint);
        r6.set(getPaint());
        Unit r0 = Unit.INSTANCE;
        return new Shadow(r1, r2, r3, r4, r5, r6, this.cornerRadius);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L5;
        return true;
    L5:
        Class<?> r1 = getClass();
        if (r5 != null) goto L8;
        Class<?> r2 = null;
    L10:
        if (Intrinsics.areEqual(r1, r2) == true) goto L12;
        return false;
    L12:
        if (r5 == null) goto L51;
        Shadow r6 = (Shadow) r5;
        if (this.color == r6.color) goto L17;
        return false;
    L17:
        if (this.radius != r6.radius) goto L19;
        boolean r3 = true;
    L20:
        if (r3 == true) goto L23;
        return false;
    L23:
        if (this.offsetX != r6.offsetX) goto L25;
        boolean r4 = true;
    L26:
        if (r4 == true) goto L29;
        return false;
    L29:
        if (this.offsetY != r6.offsetY) goto L31;
        boolean r7 = true;
    L32:
        if (r7 == true) goto L35;
        return false;
    L35:
        if (this.spread != r6.spread) goto L37;
        boolean r8 = true;
    L38:
        if (r8 == true) goto L41;
        return false;
    L41:
        if (Intrinsics.areEqual(this.paint, r6.paint) == true) goto L44;
        return false;
    L44:
        if (this.cornerRadius != r6.cornerRadius) goto L46;
        boolean r9 = true;
    L47:
        if (r9 == true) goto L49;
        return false;
    L49:
        return true;
    L46:
        r9 = false;
        goto L47
    L37:
        r8 = false;
        goto L38
    L31:
        r7 = false;
        goto L32
    L25:
        r4 = false;
        goto L26
    L19:
        r3 = false;
        goto L20
    L51:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.common.style.Shadow");
    L8:
        r2 = r5.getClass();
        goto L10
    }
}
