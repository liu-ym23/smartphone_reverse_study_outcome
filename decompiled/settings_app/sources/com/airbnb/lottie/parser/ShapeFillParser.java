package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ShapeFillParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "c", "o", "fillEnabled", "r", "hd"});
    }

    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader r10, LottieComposition r11) throws IOException {
        String r4 = null;
        AnimatableColorValue r7 = null;
        AnimatableIntegerValue r8 = null;
        boolean r5 = false;
        boolean r9 = false;
        int r0 = 1;
    L4:
        if (r10.hasNext() == false) goto L23;
        int r1 = r10.selectName(NAMES);
        if (r1 != 0) goto L7;
        r4 = r10.nextString();
        goto L4
    L7:
        if (r1 != 1) goto L9;
        r7 = AnimatableValueParser.parseColor(r10, r11);
        goto L4
    L9:
        if (r1 != 2) goto L11;
        r8 = AnimatableValueParser.parseInteger(r10, r11);
        goto L4
    L11:
        if (r1 != 3) goto L13;
        r5 = r10.nextBoolean();
        goto L4
    L13:
        if (r1 != 4) goto L15;
        r0 = r10.nextInt();
        goto L4
    L15:
        if (r1 != 5) goto L16;
        r9 = r10.nextBoolean();
        goto L4
    L16:
        r10.skipName();
        r10.skipValue();
        goto L4
    L23:
        if (r0 != 1) goto L25;
        Path.FillType r12 = Path.FillType.WINDING;
    L27:
        return new ShapeFill(r4, r5, r12, r7, r8, r9);
    L25:
        r12 = Path.FillType.EVEN_ODD;
        goto L27
    }
}
