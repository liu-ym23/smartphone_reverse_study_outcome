package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes2.dex */
public class ShapeAppearanceModel {
    public static final CornerSize PILL = null;
    EdgeTreatment bottomEdge;
    CornerTreatment bottomLeftCorner;
    CornerSize bottomLeftCornerSize;
    CornerTreatment bottomRightCorner;
    CornerSize bottomRightCornerSize;
    EdgeTreatment leftEdge;
    EdgeTreatment rightEdge;
    EdgeTreatment topEdge;
    CornerTreatment topLeftCorner;
    CornerSize topLeftCornerSize;
    CornerTreatment topRightCorner;
    CornerSize topRightCornerSize;

    /* JADX INFO: renamed from: com.google.android.material.shape.ShapeAppearanceModel$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private EdgeTreatment bottomEdge;
        private CornerTreatment bottomLeftCorner;
        private CornerSize bottomLeftCornerSize;
        private CornerTreatment bottomRightCorner;
        private CornerSize bottomRightCornerSize;
        private EdgeTreatment leftEdge;
        private EdgeTreatment rightEdge;
        private EdgeTreatment topEdge;
        private CornerTreatment topLeftCorner;
        private CornerSize topLeftCornerSize;
        private CornerTreatment topRightCorner;
        private CornerSize topRightCornerSize;

        static /* synthetic */ CornerTreatment access$100(Builder r0) {
            return r0.topLeftCorner;
        }

        static /* synthetic */ EdgeTreatment access$1000(Builder r0) {
            return r0.rightEdge;
        }

        static /* synthetic */ EdgeTreatment access$1100(Builder r0) {
            return r0.bottomEdge;
        }

        static /* synthetic */ EdgeTreatment access$1200(Builder r0) {
            return r0.leftEdge;
        }

        static /* synthetic */ CornerTreatment access$200(Builder r0) {
            return r0.topRightCorner;
        }

        static /* synthetic */ CornerTreatment access$300(Builder r0) {
            return r0.bottomRightCorner;
        }

        static /* synthetic */ CornerTreatment access$400(Builder r0) {
            return r0.bottomLeftCorner;
        }

        static /* synthetic */ CornerSize access$500(Builder r0) {
            return r0.topLeftCornerSize;
        }

        static /* synthetic */ CornerSize access$600(Builder r0) {
            return r0.topRightCornerSize;
        }

        static /* synthetic */ CornerSize access$700(Builder r0) {
            return r0.bottomRightCornerSize;
        }

        static /* synthetic */ CornerSize access$800(Builder r0) {
            return r0.bottomLeftCornerSize;
        }

        static /* synthetic */ EdgeTreatment access$900(Builder r0) {
            return r0.topEdge;
        }

        public Builder() {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public Builder(ShapeAppearanceModel r3) {
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = r3.topLeftCorner;
            this.topRightCorner = r3.topRightCorner;
            this.bottomRightCorner = r3.bottomRightCorner;
            this.bottomLeftCorner = r3.bottomLeftCorner;
            this.topLeftCornerSize = r3.topLeftCornerSize;
            this.topRightCornerSize = r3.topRightCornerSize;
            this.bottomRightCornerSize = r3.bottomRightCornerSize;
            this.bottomLeftCornerSize = r3.bottomLeftCornerSize;
            this.topEdge = r3.topEdge;
            this.rightEdge = r3.rightEdge;
            this.bottomEdge = r3.bottomEdge;
            this.leftEdge = r3.leftEdge;
        }

        public Builder setAllCorners(int r1, float r2) {
            return setAllCorners(MaterialShapeUtils.createCornerTreatment(r1)).setAllCornerSizes(r2);
        }

        public Builder setAllCorners(CornerTreatment r1) {
            return setTopLeftCorner(r1).setTopRightCorner(r1).setBottomRightCorner(r1).setBottomLeftCorner(r1);
        }

        public Builder setAllCornerSizes(CornerSize r1) {
            return setTopLeftCornerSize(r1).setTopRightCornerSize(r1).setBottomRightCornerSize(r1).setBottomLeftCornerSize(r1);
        }

        public Builder setAllCornerSizes(float r1) {
            return setTopLeftCornerSize(r1).setTopRightCornerSize(r1).setBottomRightCornerSize(r1).setBottomLeftCornerSize(r1);
        }

        public Builder setTopLeftCornerSize(float r2) {
            this.topLeftCornerSize = new AbsoluteCornerSize(r2);
            return this;
        }

        public Builder setTopLeftCornerSize(CornerSize r1) {
            this.topLeftCornerSize = r1;
            return this;
        }

        public Builder setTopRightCornerSize(float r2) {
            this.topRightCornerSize = new AbsoluteCornerSize(r2);
            return this;
        }

        public Builder setTopRightCornerSize(CornerSize r1) {
            this.topRightCornerSize = r1;
            return this;
        }

        public Builder setBottomRightCornerSize(float r2) {
            this.bottomRightCornerSize = new AbsoluteCornerSize(r2);
            return this;
        }

        public Builder setBottomRightCornerSize(CornerSize r1) {
            this.bottomRightCornerSize = r1;
            return this;
        }

        public Builder setBottomLeftCornerSize(float r2) {
            this.bottomLeftCornerSize = new AbsoluteCornerSize(r2);
            return this;
        }

        public Builder setBottomLeftCornerSize(CornerSize r1) {
            this.bottomLeftCornerSize = r1;
            return this;
        }

        public Builder setTopLeftCorner(int r1, float r2) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r1)).setTopLeftCornerSize(r2);
        }

        public Builder setTopLeftCorner(int r1, CornerSize r2) {
            return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(r1)).setTopLeftCornerSize(r2);
        }

        public Builder setTopLeftCorner(CornerTreatment r2) {
            this.topLeftCorner = r2;
            float r3 = compatCornerTreatmentSize(r2);
            if (r3 == (-1.0f)) goto L5;
            setTopLeftCornerSize(r3);
        L5:
            return this;
        }

        public Builder setTopRightCorner(int r1, float r2) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r1)).setTopRightCornerSize(r2);
        }

        public Builder setTopRightCorner(int r1, CornerSize r2) {
            return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(r1)).setTopRightCornerSize(r2);
        }

        public Builder setTopRightCorner(CornerTreatment r2) {
            this.topRightCorner = r2;
            float r3 = compatCornerTreatmentSize(r2);
            if (r3 == (-1.0f)) goto L5;
            setTopRightCornerSize(r3);
        L5:
            return this;
        }

        public Builder setBottomRightCorner(int r1, float r2) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r1)).setBottomRightCornerSize(r2);
        }

        public Builder setBottomRightCorner(int r1, CornerSize r2) {
            return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(r1)).setBottomRightCornerSize(r2);
        }

        public Builder setBottomRightCorner(CornerTreatment r2) {
            this.bottomRightCorner = r2;
            float r3 = compatCornerTreatmentSize(r2);
            if (r3 == (-1.0f)) goto L5;
            setBottomRightCornerSize(r3);
        L5:
            return this;
        }

        public Builder setBottomLeftCorner(int r1, float r2) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r1)).setBottomLeftCornerSize(r2);
        }

        public Builder setBottomLeftCorner(int r1, CornerSize r2) {
            return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(r1)).setBottomLeftCornerSize(r2);
        }

        public Builder setBottomLeftCorner(CornerTreatment r2) {
            this.bottomLeftCorner = r2;
            float r3 = compatCornerTreatmentSize(r2);
            if (r3 == (-1.0f)) goto L5;
            setBottomLeftCornerSize(r3);
        L5:
            return this;
        }

        public Builder setAllEdges(EdgeTreatment r1) {
            return setLeftEdge(r1).setTopEdge(r1).setRightEdge(r1).setBottomEdge(r1);
        }

        public Builder setLeftEdge(EdgeTreatment r1) {
            this.leftEdge = r1;
            return this;
        }

        public Builder setTopEdge(EdgeTreatment r1) {
            this.topEdge = r1;
            return this;
        }

        public Builder setRightEdge(EdgeTreatment r1) {
            this.rightEdge = r1;
            return this;
        }

        public Builder setBottomEdge(EdgeTreatment r1) {
            this.bottomEdge = r1;
            return this;
        }

        private static float compatCornerTreatmentSize(CornerTreatment r1) {
            if ((r1 instanceof RoundedCornerTreatment) == false) goto L7;
            return ((RoundedCornerTreatment) r1).radius;
        L7:
            if ((r1 instanceof CutCornerTreatment) == true) goto L9;
            return -1.0f;
        L9:
            return ((CutCornerTreatment) r1).size;
        }

        public ShapeAppearanceModel build() {
            return new ShapeAppearanceModel(this, null);
        }
    }

    public interface CornerSizeUnaryOperator {
        CornerSize apply(CornerSize r1);
    }

    /* synthetic */ ShapeAppearanceModel(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(Context r1, AttributeSet r2, int r3, int r4) {
        return builder(r1, r2, r3, r4, 0);
    }

    public static Builder builder(Context r1, AttributeSet r2, int r3, int r4, int r5) {
        return builder(r1, r2, r3, r4, new AbsoluteCornerSize(r5));
    }

    public static Builder builder(Context r1, AttributeSet r2, int r3, int r4, CornerSize r5) {
        TypedArray r6 = r1.obtainStyledAttributes(r2, R.styleable.MaterialShape, r3, r4);
        int r7 = r6.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int r8 = r6.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        r6.recycle();
        return builder(r1, r7, r8, r5);
    }

    public static Builder builder(Context r1, int r2, int r3) {
        return builder(r1, r2, r3, 0);
    }

    private static Builder builder(Context r1, int r2, int r3, int r4) {
        return builder(r1, r2, r3, new AbsoluteCornerSize(r4));
    }

    private static Builder builder(Context r6, int r7, int r8, CornerSize r9) {
        if (r8 == 0) goto L4;
        ContextThemeWrapper r0 = new ContextThemeWrapper(r6, r7);
        r7 = r8;
        r6 = r0;
    L4:
        TypedArray r10 = r6.obtainStyledAttributes(r7, R.styleable.ShapeAppearance);
        int r11 = r10.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);     // Catch: Throwable -> L8
        int r12 = r10.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, r11);     // Catch: Throwable -> L8
        int r1 = r10.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, r11);     // Catch: Throwable -> L8
        int r2 = r10.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, r11);     // Catch: Throwable -> L8
        int r13 = r10.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, r11);     // Catch: Throwable -> L8
        CornerSize r14 = getCornerSize(r10, R.styleable.ShapeAppearance_cornerSize, r9);     // Catch: Throwable -> L8
        CornerSize r3 = getCornerSize(r10, R.styleable.ShapeAppearance_cornerSizeTopLeft, r14);     // Catch: Throwable -> L8
        CornerSize r4 = getCornerSize(r10, R.styleable.ShapeAppearance_cornerSizeTopRight, r14);     // Catch: Throwable -> L8
        CornerSize r5 = getCornerSize(r10, R.styleable.ShapeAppearance_cornerSizeBottomRight, r14);     // Catch: Throwable -> L8
        CornerSize r15 = getCornerSize(r10, R.styleable.ShapeAppearance_cornerSizeBottomLeft, r14);     // Catch: Throwable -> L8
        Builder r16 = new Builder().setTopLeftCorner(r12, r3).setTopRightCorner(r1, r4).setBottomRightCorner(r2, r5).setBottomLeftCorner(r13, r15);     // Catch: Throwable -> L8
        r10.recycle();
        return r16;
    L8:
        th = move-exception;
        r10.recycle();
        throw th;
    }

    private static CornerSize getCornerSize(TypedArray r2, int r3, CornerSize r4) {
        TypedValue r5 = r2.peekValue(r3);
        if (r5 != null) goto L6;
        return r4;
    L6:
        if (r5.type != 5) goto L10;
        return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(r5.data, r2.getResources().getDisplayMetrics()));
    L10:
        if (r5.type == 6) goto L12;
        return r4;
    L12:
        return new RelativeCornerSize(r5.getFraction(1.0f, 1.0f));
    }

    static {
        PILL = new RelativeCornerSize(0.5f);
    }

    private ShapeAppearanceModel(Builder r2) {
        this.topLeftCorner = Builder.access$100(r2);
        this.topRightCorner = Builder.access$200(r2);
        this.bottomRightCorner = Builder.access$300(r2);
        this.bottomLeftCorner = Builder.access$400(r2);
        this.topLeftCornerSize = Builder.access$500(r2);
        this.topRightCornerSize = Builder.access$600(r2);
        this.bottomRightCornerSize = Builder.access$700(r2);
        this.bottomLeftCornerSize = Builder.access$800(r2);
        this.topEdge = Builder.access$900(r2);
        this.rightEdge = Builder.access$1000(r2);
        this.bottomEdge = Builder.access$1100(r2);
        this.leftEdge = Builder.access$1200(r2);
    }

    public ShapeAppearanceModel() {
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public CornerSize getTopLeftCornerSize() {
        return this.topLeftCornerSize;
    }

    public CornerSize getTopRightCornerSize() {
        return this.topRightCornerSize;
    }

    public CornerSize getBottomRightCornerSize() {
        return this.bottomRightCornerSize;
    }

    public CornerSize getBottomLeftCornerSize() {
        return this.bottomLeftCornerSize;
    }

    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    public ShapeAppearanceModel withCornerSize(float r1) {
        return toBuilder().setAllCornerSizes(r1).build();
    }

    public ShapeAppearanceModel withCornerSize(CornerSize r1) {
        return toBuilder().setAllCornerSizes(r1).build();
    }

    public ShapeAppearanceModel withTransformedCornerSizes(CornerSizeUnaryOperator r3) {
        return toBuilder().setTopLeftCornerSize(r3.apply(getTopLeftCornerSize())).setTopRightCornerSize(r3.apply(getTopRightCornerSize())).setBottomLeftCornerSize(r3.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(r3.apply(getBottomRightCornerSize())).build();
    }

    public boolean isRoundRect(RectF r6) {
        if (this.leftEdge.getClass().equals(EdgeTreatment.class) == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        float r3 = this.topLeftCornerSize.getCornerSize(r6);
        if (this.topRightCornerSize.getCornerSize(r6) == r3) goto L15;
    L19:
        boolean r7 = false;
    L21:
        if ((this.topRightCorner instanceof RoundedCornerTreatment) == true) goto L23;
    L29:
        boolean r5 = false;
    L30:
        if (r0 == false) goto L35;
        if (r7 == false) goto L35;
        if (r5 == false) goto L35;
        return true;
    L35:
        return false;
    L23:
        if ((this.topLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomRightCorner instanceof RoundedCornerTreatment) == false) goto L29;
        if ((this.bottomLeftCorner instanceof RoundedCornerTreatment) == false) goto L29;
        r5 = true;
        goto L30
    L15:
        if (this.bottomLeftCornerSize.getCornerSize(r6) != r3) goto L19;
        if (this.bottomRightCornerSize.getCornerSize(r6) != r3) goto L19;
        r7 = true;
        goto L21
    L5:
        if (this.rightEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.topEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        if (this.bottomEdge.getClass().equals(EdgeTreatment.class) == false) goto L11;
        r0 = true;
        goto L12
    }
}
