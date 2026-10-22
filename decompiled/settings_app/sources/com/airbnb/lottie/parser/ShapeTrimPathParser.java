package com.airbnb.lottie.parser;

import android.icu.text.DateFormat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ShapeTrimPathParser {
    private static JsonReader.Options NAMES;

    private ShapeTrimPathParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{DateFormat.SECOND, "e", "o", "nm", DateFormat.MINUTE, "hd"});
    }

    static ShapeTrimPath parse(JsonReader r9, LottieComposition r10) throws IOException {
        String r3 = null;
        ShapeTrimPath.Type r4 = null;
        AnimatableFloatValue r5 = null;
        AnimatableFloatValue r6 = null;
        AnimatableFloatValue r7 = null;
        boolean r8 = false;
    L4:
        if (r9.hasNext() == false) goto L25;
        int r0 = r9.selectName(NAMES);
        if (r0 != 0) goto L8;
        r5 = AnimatableValueParser.parseFloat(r9, r10, false);
        goto L4
    L8:
        if (r0 != 1) goto L10;
        r6 = AnimatableValueParser.parseFloat(r9, r10, false);
        goto L4
    L10:
        if (r0 != 2) goto L12;
        r7 = AnimatableValueParser.parseFloat(r9, r10, false);
        goto L4
    L12:
        if (r0 != 3) goto L14;
        r3 = r9.nextString();
        goto L4
    L14:
        if (r0 != 4) goto L16;
        r4 = ShapeTrimPath.Type.forId(r9.nextInt());
        goto L4
    L16:
        if (r0 != 5) goto L17;
        r8 = r9.nextBoolean();
        goto L4
    L17:
        r9.skipValue();
        goto L4
    L25:
        return new ShapeTrimPath(r3, r4, r5, r6, r7, r8);
    }
}
