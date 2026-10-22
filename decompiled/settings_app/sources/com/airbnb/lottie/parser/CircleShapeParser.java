package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.icu.text.DateFormat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class CircleShapeParser {
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "p", DateFormat.SECOND, "hd", "d"});
    }

    private CircleShapeParser() {
    }

    static CircleShape parse(JsonReader r10, LottieComposition r11, int r12) throws IOException {
        if (r12 != 3) goto L5;
        boolean r13 = true;
    L6:
        boolean r8 = r13;
        boolean r9 = false;
        String r5 = null;
        AnimatableValue<PointF, PointF> r6 = null;
        AnimatablePointValue r7 = null;
    L8:
        if (r10.hasNext() == false) goto L27;
        int r14 = r10.selectName(NAMES);
        if (r14 != 0) goto L11;
        r5 = r10.nextString();
        goto L8
    L11:
        if (r14 != 1) goto L13;
        r6 = AnimatablePathValueParser.parseSplitPath(r10, r11);
        goto L8
    L13:
        if (r14 != 2) goto L14;
        r7 = AnimatableValueParser.parsePoint(r10, r11);
        goto L8
    L14:
        if (r14 != 3) goto L16;
        r9 = r10.nextBoolean();
        goto L8
    L16:
        if (r14 != 4) goto L17;
        if (r10.nextInt() == 3) goto L20;
        r8 = false;
        goto L8
    L20:
        r8 = true;
        goto L8
    L17:
        r10.skipName();
        r10.skipValue();
        goto L8
    L27:
        return new CircleShape(r5, r6, r7, r8, r9);
    L5:
        r13 = false;
        goto L6
    }
}
