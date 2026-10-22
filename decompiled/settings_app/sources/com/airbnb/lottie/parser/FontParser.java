package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class FontParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"fFamily", "fName", "fStyle", "ascent"});
    }

    private FontParser() {
    }

    static Font parse(JsonReader r6) throws IOException {
        r6.beginObject();
        String r0 = null;
        String r2 = null;
        float r3 = 0.0f;
        String r1 = null;
    L4:
        if (r6.hasNext() == false) goto L18;
        int r4 = r6.selectName(NAMES);
        if (r4 != 0) goto L8;
        r0 = r6.nextString();
        goto L4
    L8:
        if (r4 != 1) goto L10;
        r1 = r6.nextString();
        goto L4
    L10:
        if (r4 != 2) goto L12;
        r2 = r6.nextString();
        goto L4
    L12:
        if (r4 != 3) goto L13;
        r3 = (float) r6.nextDouble();
        goto L4
    L13:
        r6.skipName();
        r6.skipValue();
        goto L4
    L18:
        r6.endObject();
        return new Font(r0, r1, r2, r3);
    }
}
