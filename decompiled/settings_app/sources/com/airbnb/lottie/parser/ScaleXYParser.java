package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {
    public static final ScaleXYParser INSTANCE = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ ScaleXY parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new ScaleXYParser();
    }

    private ScaleXYParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ScaleXY parse(JsonReader r4, float r5) throws IOException {
        if (r4.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L8;
        r4.beginArray();
    L8:
        float r0 = (float) r4.nextDouble();
        float r1 = (float) r4.nextDouble();
    L10:
        if (r4.hasNext() == false) goto L12;
        r4.skipValue();
        goto L10
    L12:
        if (r3 == false) goto L15;
        r4.endArray();
    L15:
        return new ScaleXY((r0 / 100.0f) * r5, (r1 / 100.0f) * r5);
    L5:
        r3 = false;
        goto L6
    }
}
