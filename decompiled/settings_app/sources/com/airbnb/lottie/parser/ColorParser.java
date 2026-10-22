package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ColorParser implements ValueParser<Integer> {
    public static final ColorParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ Integer parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new ColorParser();
    }

    private ColorParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public Integer parse(JsonReader r9, float r10) throws IOException {
        if (r9.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == false) goto L8;
        r9.beginArray();
    L8:
        double r0 = r9.nextDouble();
        double r2 = r9.nextDouble();
        double r4 = r9.nextDouble();
        double r6 = r9.nextDouble();
        if (r8 == false) goto L12;
        r9.endArray();
    L12:
        if (r0 > 1.0d) goto L21;
        if (r2 > 1.0d) goto L21;
        if (r4 > 1.0d) goto L21;
        if (r6 > 1.0d) goto L21;
        r0 = r0 * 255.0d;
        r2 = r2 * 255.0d;
        r4 = r4 * 255.0d;
        r6 = r6 * 255.0d;
    L21:
        return Integer.valueOf(Color.argb((int) r6, (int) r0, (int) r2, (int) r4));
    L5:
        r8 = false;
        goto L6
    }
}
