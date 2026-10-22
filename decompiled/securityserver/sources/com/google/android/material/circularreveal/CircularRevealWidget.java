package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = null;
        private final RevealInfo revealInfo;

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        public CircularRevealEvaluator() {
            this.revealInfo = new RevealInfo(null);
        }

        @Override // android.animation.TypeEvaluator
        @NonNull
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float r1, @NonNull RevealInfo r2, @NonNull RevealInfo r3) {
            return evaluate2(r1, r2, r3);
        }

        @NonNull
        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float r5, @NonNull RevealInfo r6, @NonNull RevealInfo r7) {
            this.revealInfo.set(MathUtils.lerp(r6.centerX, r7.centerX, r5), MathUtils.lerp(r6.centerY, r7.centerY, r5), MathUtils.lerp(r6.radius, r7.radius, r5));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = null;

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r2) {
            super(RevealInfo.class, r2);
        }

        @Override // android.util.Property
        @Nullable
        public /* bridge */ /* synthetic */ RevealInfo get(@NonNull CircularRevealWidget r1) {
            return get2(r1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r1, @Nullable RevealInfo r2) {
            set2(r1, r2);
        }

        @Nullable
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(@NonNull CircularRevealWidget r1) {
            return r1.getRevealInfo();
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r1, @Nullable RevealInfo r2) {
            r1.setRevealInfo(r2);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r2) {
            super(Integer.class, r2);
        }

        @Override // android.util.Property
        @NonNull
        public /* bridge */ /* synthetic */ Integer get(@NonNull CircularRevealWidget r1) {
            return get2(r1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(@NonNull CircularRevealWidget r1, @NonNull Integer r2) {
            set2(r1, r2);
        }

        @NonNull
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(@NonNull CircularRevealWidget r1) {
            return Integer.valueOf(r1.getCircularRevealScrimColor());
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(@NonNull CircularRevealWidget r1, @NonNull Integer r2) {
            r1.setCircularRevealScrimColor(r2.intValue());
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        private RevealInfo() {
        }

        public boolean isInvalid() {
            if (this.radius != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }

        public void set(float r1, float r2, float r3) {
            this.centerX = r1;
            this.centerY = r2;
            this.radius = r3;
        }

        public /* synthetic */ RevealInfo(AnonymousClass1 r1) {
            this();
        }

        public RevealInfo(float r1, float r2, float r3) {
            this.centerX = r1;
            this.centerY = r2;
            this.radius = r3;
        }

        public void set(@NonNull RevealInfo r3) {
            set(r3.centerX, r3.centerY, r3.radius);
        }

        public RevealInfo(@NonNull RevealInfo r3) {
            this(r3.centerX, r3.centerY, r3.radius);
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas r1);

    @Nullable
    Drawable getCircularRevealOverlayDrawable();

    @ColorInt
    int getCircularRevealScrimColor();

    @Nullable
    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(@Nullable Drawable r1);

    void setCircularRevealScrimColor(@ColorInt int r1);

    void setRevealInfo(@Nullable RevealInfo r1);
}
