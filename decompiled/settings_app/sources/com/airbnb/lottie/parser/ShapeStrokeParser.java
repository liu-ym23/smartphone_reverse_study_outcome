package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ShapeStrokeParser {
    private static final JsonReader.Options DASH_PATTERN_NAMES = null;
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "c", "w", "o", "lc", "lj", "ml", "hd", "d"});
        DASH_PATTERN_NAMES = JsonReader.Options.of(new String[]{"n", "v"});
    }

    private ShapeStrokeParser() {
    }

    static ShapeStroke parse(JsonReader r18, LottieComposition r19) throws IOException {
        ArrayList r3 = new ArrayList();
        float r11 = 0.0f;
        boolean r12 = false;
        String r2 = null;
        AnimatableFloatValue r5 = null;
        AnimatableColorValue r6 = null;
        AnimatableIntegerValue r7 = null;
        AnimatableFloatValue r8 = null;
        ShapeStroke.LineCapType r9 = null;
        ShapeStroke.LineJoinType r10 = null;
    L4:
        if (r18.hasNext() == false) goto L51;
        switch(r18.selectName(NAMES)) {
            case 0: goto L49;
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L46;
            case 4: goto L45;
            case 5: goto L44;
            case 6: goto L43;
            case 7: goto L42;
            case 8: goto L8;
            default: goto L7;
        };
    L8:
        r18.beginArray();
    L10:
        if (r18.hasNext() == false) goto L39;
        r18.beginObject();
        String r13 = null;
        AnimatableFloatValue r15 = null;
    L13:
        if (r18.hasNext() == false) goto L20;
        int r1 = r18.selectName(DASH_PATTERN_NAMES);
        if (r1 != 0) goto L16;
        r13 = r18.nextString();
        goto L13
    L16:
        if (r1 != 1) goto L17;
        r15 = AnimatableValueParser.parseFloat(r18, r19);
        goto L13
    L17:
        r18.skipName();
        r18.skipValue();
        goto L13
    L20:
        r18.endObject();
        r13.hashCode();
        byte r17 = -1;
        switch(r13.hashCode()) {
            case 100: goto L32;
            case 103: goto L28;
            case 111: goto L24;
            default: goto L35;
        };
    L35:
        switch(r17) {
            case 0: goto L38;
            case 1: goto L38;
            case 2: goto L37;
            default: goto L10;
        };
    L37:
        r5 = r15;
        goto L10
    L38:
        r19.setHasDashPattern(true);
        r3.add(r15);
        goto L10
    L24:
        if (r13.equals("o") == false) goto L35;
        r17 = 2;
        goto L35
    L28:
        if (r13.equals("g") == false) goto L35;
        r17 = 1;
        goto L35
    L32:
        if (r13.equals("d") == false) goto L35;
        r17 = 0;
        goto L35
    L39:
        r18.endArray();
        if (r3.size() != 1) goto L4;
        r3.add(r3.get(0));
        goto L4
    L42:
        r12 = r18.nextBoolean();
        goto L4
    L43:
        r11 = (float) r18.nextDouble();
        goto L4
    L44:
        r10 = ShapeStroke.LineJoinType.values()[r18.nextInt() - 1];
        goto L4
    L45:
        r9 = ShapeStroke.LineCapType.values()[r18.nextInt() - 1];
        goto L4
    L46:
        r7 = AnimatableValueParser.parseInteger(r18, r19);
        goto L4
    L47:
        r8 = AnimatableValueParser.parseFloat(r18, r19);
        goto L4
    L48:
        r6 = AnimatableValueParser.parseColor(r18, r19);
        goto L4
    L49:
        r2 = r18.nextString();
        goto L4
    L7:
        r18.skipValue();
        goto L4
    L51:
        return new ShapeStroke(r2, r5, r3, r6, r7, r8, r9, r10, r11, r12);
    }
}
