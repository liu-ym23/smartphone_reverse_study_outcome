package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.icu.text.DateFormat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class AnimatableTransformParser {
    private static JsonReader.Options ANIMATABLE_NAMES;
    private static JsonReader.Options NAMES;

    private AnimatableTransformParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"a", "p", DateFormat.SECOND, "rz", "r", "o", "so", "eo", "sk", "sa"});
        ANIMATABLE_NAMES = JsonReader.Options.of(new String[]{"k"});
    }

    public static AnimatableTransform parse(JsonReader r27, LottieComposition r28) throws IOException {
        boolean r9 = false;
        if (r27.peek() != JsonReader.Token.BEGIN_OBJECT) goto L5;
        boolean r10 = true;
    L6:
        if (r10 == false) goto L8;
        r27.beginObject();
    L8:
        AnimatableFloatValue r1 = null;
        AnimatablePathValue r12 = null;
        AnimatableValue<PointF, PointF> r13 = null;
        AnimatableScaleValue r14 = null;
        AnimatableFloatValue r15 = null;
        AnimatableFloatValue r16 = null;
        AnimatableIntegerValue r22 = null;
        AnimatableFloatValue r23 = null;
        AnimatableFloatValue r24 = null;
    L10:
        if (r27.hasNext() == false) goto L38;
        switch(r27.selectName(NAMES)) {
            case 0: goto L30;
            case 1: goto L29;
            case 2: goto L28;
            case 3: goto L19;
            case 4: goto L20;
            case 5: goto L18;
            case 6: goto L17;
            case 7: goto L16;
            case 8: goto L15;
            case 9: goto L14;
            default: goto L13;
        };
    L14:
        r16 = AnimatableValueParser.parseFloat(r27, r28, r9);
        goto L10
    L15:
        r15 = AnimatableValueParser.parseFloat(r27, r28, r9);
        goto L10
    L16:
        r24 = AnimatableValueParser.parseFloat(r27, r28, r9);
        goto L10
    L17:
        r23 = AnimatableValueParser.parseFloat(r27, r28, r9);
        goto L10
    L18:
        r22 = AnimatableValueParser.parseInteger(r27, r28);
        goto L10
    L19:
        r28.addWarning("Lottie doesn't support 3D layers.");
    L20:
        AnimatableFloatValue r17 = AnimatableValueParser.parseFloat(r27, r28, r9);
        if (r17.getKeyframes().isEmpty() == false) goto L24;
        r17.getKeyframes().add(new Keyframe(r28, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r28.getEndFrame())));
    L26:
        boolean r2 = false;
    L27:
        r9 = r2;
        r1 = r17;
        goto L10
    L24:
        if (((Keyframe) r17.getKeyframes().get(0)).startValue != 0) goto L26;
        r2 = false;
        r17.getKeyframes().set(0, new Keyframe(r28, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(r28.getEndFrame())));
        goto L27
    L28:
        r14 = AnimatableValueParser.parseScale(r27, r28);
        goto L10
    L29:
        r13 = AnimatablePathValueParser.parseSplitPath(r27, r28);
        goto L10
    L30:
        boolean r3 = r9;
        r27.beginObject();
    L32:
        if (r27.hasNext() == false) goto L37;
        if (r27.selectName(ANIMATABLE_NAMES) != 0) goto L35;
        r12 = AnimatablePathValueParser.parse(r27, r28);
        goto L32
    L35:
        r27.skipName();
        r27.skipValue();
        goto L32
    L37:
        r27.endObject();
        r9 = r3;
        goto L10
    L13:
        r27.skipName();
        r27.skipValue();
        goto L10
    L38:
        if (r10 == false) goto L41;
        r27.endObject();
    L41:
        if (isAnchorPointIdentity(r12) == false) goto L43;
        AnimatablePathValue r18 = null;
    L45:
        if (isPositionIdentity(r13) == false) goto L47;
        AnimatableValue<PointF, PointF> r19 = null;
    L49:
        if (isRotationIdentity(r1) == false) goto L51;
        AnimatableFloatValue r21 = null;
    L53:
        if (isScaleIdentity(r14) == false) goto L56;
        r14 = null;
    L56:
        if (isSkewIdentity(r15) == false) goto L58;
        AnimatableFloatValue r25 = null;
    L60:
        if (isSkewAngleIdentity(r16) == false) goto L62;
        AnimatableFloatValue r26 = null;
    L64:
        return new AnimatableTransform(r18, r19, r14, r21, r22, r23, r24, r25, r26);
    L62:
        r26 = r16;
        goto L64
    L58:
        r25 = r15;
        goto L60
    L51:
        r21 = r1;
        goto L53
    L47:
        r19 = r13;
        goto L49
    L43:
        r18 = r12;
        goto L45
    L5:
        r10 = false;
        goto L6
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.isStatic() == true) goto L6;
        return false;
    L6:
        if (r2.getKeyframes().get(0).startValue.equals(0.0f, 0.0f) == true) goto L7;
        return false;
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> r2) {
        if (r2 != null) goto L4;
    L9:
        return true;
    L4:
        if ((r2 instanceof AnimatableSplitDimensionPathValue) == false) goto L6;
        return false;
    L6:
        if (r2.isStatic() == true) goto L8;
        return false;
    L8:
        if (r2.getKeyframes().get(0).startValue.equals(0.0f, 0.0f) == true) goto L9;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isRotationIdentity(AnimatableFloatValue r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.isStatic() == true) goto L6;
        return false;
    L6:
        if (((Float) ((Keyframe) r2.getKeyframes().get(0)).startValue).floatValue() == 0.0f) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isScaleIdentity(AnimatableScaleValue r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.isStatic() == true) goto L6;
        return false;
    L6:
        if (((ScaleXY) ((Keyframe) r2.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f) == true) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewIdentity(AnimatableFloatValue r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.isStatic() == true) goto L6;
        return false;
    L6:
        if (((Float) ((Keyframe) r2.getKeyframes().get(0)).startValue).floatValue() == 0.0f) goto L7;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isSkewAngleIdentity(AnimatableFloatValue r2) {
        if (r2 != null) goto L4;
    L7:
        return true;
    L4:
        if (r2.isStatic() == true) goto L6;
        return false;
    L6:
        if (((Float) ((Keyframe) r2.getKeyframes().get(0)).startValue).floatValue() == 0.0f) goto L7;
        return false;
    }
}
