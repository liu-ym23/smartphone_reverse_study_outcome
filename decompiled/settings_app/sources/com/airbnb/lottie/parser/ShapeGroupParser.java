package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class ShapeGroupParser {
    private static JsonReader.Options NAMES;

    private ShapeGroupParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "hd", "it"});
    }

    static ShapeGroup parse(JsonReader r5, LottieComposition r6) throws IOException {
        ArrayList r0 = new ArrayList();
        String r1 = null;
        boolean r2 = false;
    L4:
        if (r5.hasNext() == false) goto L22;
        int r3 = r5.selectName(NAMES);
        if (r3 != 0) goto L8;
        r1 = r5.nextString();
        goto L4
    L8:
        if (r3 != 1) goto L10;
        r2 = r5.nextBoolean();
        goto L4
    L10:
        if (r3 != 2) goto L11;
        r5.beginArray();
    L14:
        if (r5.hasNext() == false) goto L18;
        ContentModel r4 = ContentModelParser.parse(r5, r6);
        if (r4 == null) goto L14;
        r0.add(r4);
        goto L14
    L18:
        r5.endArray();
        goto L4
    L11:
        r5.skipValue();
        goto L4
    L22:
        return new ShapeGroup(r1, r0, r2);
    }
}
