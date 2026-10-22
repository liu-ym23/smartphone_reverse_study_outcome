package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class PolystarShapeParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd"});
    }

    private PolystarShapeParser() {
    }

    static PolystarShape parse(JsonReader r13, LottieComposition r14) throws IOException {
        String r3 = null;
        PolystarShape.Type r4 = null;
        AnimatableFloatValue r5 = null;
        AnimatableValue<PointF, PointF> r6 = null;
        AnimatableFloatValue r7 = null;
        AnimatableFloatValue r8 = null;
        AnimatableFloatValue r9 = null;
        AnimatableFloatValue r10 = null;
        AnimatableFloatValue r11 = null;
        boolean r12 = false;
    L4:
        if (r13.hasNext() == false) goto L19;
        switch(r13.selectName(NAMES)) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        r12 = r13.nextBoolean();
        goto L4
    L9:
        r10 = AnimatableValueParser.parseFloat(r13, r14, false);
        goto L4
    L10:
        r8 = AnimatableValueParser.parseFloat(r13, r14);
        goto L4
    L11:
        r11 = AnimatableValueParser.parseFloat(r13, r14, false);
        goto L4
    L12:
        r9 = AnimatableValueParser.parseFloat(r13, r14);
        goto L4
    L13:
        r7 = AnimatableValueParser.parseFloat(r13, r14, false);
        goto L4
    L14:
        r6 = AnimatablePathValueParser.parseSplitPath(r13, r14);
        goto L4
    L15:
        r5 = AnimatableValueParser.parseFloat(r13, r14, false);
        goto L4
    L16:
        r4 = PolystarShape.Type.forValue(r13.nextInt());
        goto L4
    L17:
        r3 = r13.nextString();
        goto L4
    L7:
        r13.skipName();
        r13.skipValue();
        goto L4
    L19:
        return new PolystarShape(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    }
}
