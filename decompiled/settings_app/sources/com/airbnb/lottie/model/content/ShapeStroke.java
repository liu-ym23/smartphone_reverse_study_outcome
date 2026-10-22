package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.StrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.bytedance.networkstackapplib.NetworkStackConstant;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeStroke implements ContentModel {
    private final LineCapType capType;
    private final AnimatableColorValue color;
    private final boolean hidden;
    private final LineJoinType joinType;
    private final List<AnimatableFloatValue> lineDashPattern;
    private final float miterLimit;
    private final String name;
    private final AnimatableFloatValue offset;
    private final AnimatableIntegerValue opacity;
    private final AnimatableFloatValue width;

    /* JADX INFO: renamed from: com.airbnb.lottie.model.content.ShapeStroke$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType = null;
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType = null;

        static {
            int[] r0 = new int[LineJoinType.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType = r0;
            r0[LineJoinType.BEVEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L21:
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.MITER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L23:
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[LineJoinType.ROUND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L8:
            int[] r3 = new int[LineCapType.values().length];
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType = r3;
            r3[LineCapType.BUTT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L29:
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[LineCapType.ROUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L19:
            $SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[LineCapType.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
            return;
        }
    }

    public static final enum LineCapType extends Enum<LineCapType> {
        private static final /* synthetic */ LineCapType[] $VALUES = null;
        public static final LineCapType BUTT = null;
        public static final LineCapType ROUND = null;
        public static final LineCapType UNKNOWN = null;

        private LineCapType(String r1, int r2) {
            super(r1, r2);
        }

        public static LineCapType valueOf(String r1) {
            return (LineCapType) Enum.valueOf(LineCapType.class, r1);
        }

        public static LineCapType[] values() {
            return (LineCapType[]) $VALUES.clone();
        }

        static {
            LineCapType r0 = new LineCapType("BUTT", 0);
            BUTT = r0;
            LineCapType r1 = new LineCapType("ROUND", 1);
            ROUND = r1;
            LineCapType r3 = new LineCapType(NetworkStackConstant.UNKNOWN_TYPE, 2);
            UNKNOWN = r3;
            $VALUES = new LineCapType[]{r0, r1, r3};
        }

        public Paint.Cap toPaintCap() {
            int r1 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineCapType[ordinal()];
            if (r1 == 1) goto L11;
            if (r1 == 2) goto L9;
            return Paint.Cap.SQUARE;
        L9:
            return Paint.Cap.ROUND;
        L11:
            return Paint.Cap.BUTT;
        }
    }

    public static final enum LineJoinType extends Enum<LineJoinType> {
        private static final /* synthetic */ LineJoinType[] $VALUES = null;
        public static final LineJoinType BEVEL = null;
        public static final LineJoinType MITER = null;
        public static final LineJoinType ROUND = null;

        private LineJoinType(String r1, int r2) {
            super(r1, r2);
        }

        public static LineJoinType valueOf(String r1) {
            return (LineJoinType) Enum.valueOf(LineJoinType.class, r1);
        }

        public static LineJoinType[] values() {
            return (LineJoinType[]) $VALUES.clone();
        }

        static {
            LineJoinType r0 = new LineJoinType("MITER", 0);
            MITER = r0;
            LineJoinType r1 = new LineJoinType("ROUND", 1);
            ROUND = r1;
            LineJoinType r3 = new LineJoinType("BEVEL", 2);
            BEVEL = r3;
            $VALUES = new LineJoinType[]{r0, r1, r3};
        }

        public Paint.Join toPaintJoin() {
            int r1 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$model$content$ShapeStroke$LineJoinType[ordinal()];
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return null;
        L11:
            return Paint.Join.ROUND;
        L13:
            return Paint.Join.MITER;
        L15:
            return Paint.Join.BEVEL;
        }
    }

    public ShapeStroke(String r1, AnimatableFloatValue r2, List<AnimatableFloatValue> r3, AnimatableColorValue r4, AnimatableIntegerValue r5, AnimatableFloatValue r6, LineCapType r7, LineJoinType r8, float r9, boolean r10) {
        this.name = r1;
        this.offset = r2;
        this.lineDashPattern = r3;
        this.color = r4;
        this.opacity = r5;
        this.width = r6;
        this.capType = r7;
        this.joinType = r8;
        this.miterLimit = r9;
        this.hidden = r10;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public Content toContent(LottieDrawable r2, BaseLayer r3) {
        return new StrokeContent(r2, r3, this);
    }

    public String getName() {
        return this.name;
    }

    public AnimatableColorValue getColor() {
        return this.color;
    }

    public AnimatableIntegerValue getOpacity() {
        return this.opacity;
    }

    public AnimatableFloatValue getWidth() {
        return this.width;
    }

    public List<AnimatableFloatValue> getLineDashPattern() {
        return this.lineDashPattern;
    }

    public AnimatableFloatValue getDashOffset() {
        return this.offset;
    }

    public LineCapType getCapType() {
        return this.capType;
    }

    public LineJoinType getJoinType() {
        return this.joinType;
    }

    public float getMiterLimit() {
        return this.miterLimit;
    }

    public boolean isHidden() {
        return this.hidden;
    }
}
