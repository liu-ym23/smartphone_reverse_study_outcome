package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class RepeaterParser {
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "c", "o", "tr", "hd"});
    }

    private RepeaterParser() {
    }

    static Repeater parse(JsonReader r8, LottieComposition r9) throws IOException {
        String r3 = null;
        AnimatableFloatValue r4 = null;
        AnimatableFloatValue r5 = null;
        AnimatableTransform r6 = null;
        boolean r7 = false;
    L4:
        if (r8.hasNext() == false) goto L22;
        int r0 = r8.selectName(NAMES);
        if (r0 != 0) goto L8;
        r3 = r8.nextString();
        goto L4
    L8:
        if (r0 != 1) goto L10;
        r4 = AnimatableValueParser.parseFloat(r8, r9, false);
        goto L4
    L10:
        if (r0 != 2) goto L12;
        r5 = AnimatableValueParser.parseFloat(r8, r9, false);
        goto L4
    L12:
        if (r0 != 3) goto L14;
        r6 = AnimatableTransformParser.parse(r8, r9);
        goto L4
    L14:
        if (r0 != 4) goto L15;
        r7 = r8.nextBoolean();
        goto L4
    L15:
        r8.skipValue();
        goto L4
    L22:
        return new Repeater(r3, r4, r5, r6, r7);
    }
}
