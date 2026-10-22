package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Property;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes2.dex */
public interface CircularRevealWidget extends CircularRevealHelper.Delegate {

    /* JADX INFO: renamed from: com.google.android.material.circularreveal.CircularRevealWidget$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class CircularRevealEvaluator implements TypeEvaluator<RevealInfo> {
        public static final TypeEvaluator<RevealInfo> CIRCULAR_REVEAL = null;
        private final RevealInfo revealInfo;

        public CircularRevealEvaluator() {
            this.revealInfo = new RevealInfo(null);
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ RevealInfo evaluate(float r1, RevealInfo r2, RevealInfo r3) {
            return evaluate2(r1, r2, r3);
        }

        static {
            CIRCULAR_REVEAL = new CircularRevealEvaluator();
        }

        /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
        public RevealInfo evaluate2(float r5, RevealInfo r6, RevealInfo r7) {
            this.revealInfo.set(MathUtils.lerp(r6.centerX, r7.centerX, r5), MathUtils.lerp(r6.centerY, r7.centerY, r5), MathUtils.lerp(r6.radius, r7.radius, r5));
            return this.revealInfo;
        }
    }

    public static class CircularRevealProperty extends Property<CircularRevealWidget, RevealInfo> {
        public static final Property<CircularRevealWidget, RevealInfo> CIRCULAR_REVEAL = null;

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ RevealInfo get(CircularRevealWidget r1) {
            return get2(r1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget r1, RevealInfo r2) {
            set2(r1, r2);
        }

        static {
            CIRCULAR_REVEAL = new CircularRevealProperty("circularReveal");
        }

        private CircularRevealProperty(String r2) {
            super(RevealInfo.class, r2);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public RevealInfo get2(CircularRevealWidget r1) {
            return r1.getRevealInfo();
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r1, RevealInfo r2) {
            r1.setRevealInfo(r2);
        }
    }

    public static class CircularRevealScrimColorProperty extends Property<CircularRevealWidget, Integer> {
        public static final Property<CircularRevealWidget, Integer> CIRCULAR_REVEAL_SCRIM_COLOR = null;

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Integer get(CircularRevealWidget r1) {
            return get2(r1);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularRevealWidget r1, Integer r2) {
            set2(r1, r2);
        }

        static {
            CIRCULAR_REVEAL_SCRIM_COLOR = new CircularRevealScrimColorProperty("circularRevealScrimColor");
        }

        private CircularRevealScrimColorProperty(String r2) {
            super(Integer.class, r2);
        }

        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public Integer get2(CircularRevealWidget r1) {
            return Integer.valueOf(r1.getCircularRevealScrimColor());
        }

        /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularRevealWidget r1, Integer r2) {
            r1.setCircularRevealScrimColor(r2.intValue());
        }
    }

    public static class RevealInfo {
        public static final float INVALID_RADIUS = Float.MAX_VALUE;
        public float centerX;
        public float centerY;
        public float radius;

        /* synthetic */ RevealInfo(AnonymousClass1 r1) {
            this();
        }

        private RevealInfo() {
        }

        public RevealInfo(float r1, float r2, float r3) {
            this.centerX = r1;
            this.centerY = r2;
            this.radius = r3;
        }

        public RevealInfo(RevealInfo r3) {
            this(r3.centerX, r3.centerY, r3.radius);
        }

        public void set(float r1, float r2, float r3) {
            this.centerX = r1;
            this.centerY = r2;
            this.radius = r3;
        }

        public void set(RevealInfo r3) {
            set(r3.centerX, r3.centerY, r3.radius);
        }

        public boolean isInvalid() {
            if (this.radius != Float.MAX_VALUE) goto L5;
            return true;
        L5:
            return false;
        }
    }

    void buildCircularRevealCache();

    void destroyCircularRevealCache();

    void draw(Canvas r1);

    Drawable getCircularRevealOverlayDrawable();

    int getCircularRevealScrimColor();

    RevealInfo getRevealInfo();

    boolean isOpaque();

    void setCircularRevealOverlayDrawable(Drawable r1);

    void setCircularRevealScrimColor(int r1);

    void setRevealInfo(RevealInfo r1);
}
