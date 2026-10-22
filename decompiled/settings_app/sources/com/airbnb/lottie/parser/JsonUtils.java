package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class JsonUtils {
    private static final JsonReader.Options POINT_NAMES = null;

    /* JADX INFO: renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = null;

        static {
            int[] r0 = new int[JsonReader.Token.values().length];
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token = r0;
            r0[JsonReader.Token.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private JsonUtils() {
    }

    static int jsonToColor(JsonReader r6) throws IOException {
        r6.beginArray();
        int r0 = (int) (r6.nextDouble() * 255.0d);
        int r1 = (int) (r6.nextDouble() * 255.0d);
        int r2 = (int) (r6.nextDouble() * 255.0d);
    L4:
        if (r6.hasNext() == false) goto L6;
        r6.skipValue();
        goto L4
    L6:
        r6.endArray();
        return Color.argb(255, r0, r1, r2);
    }

    static List<PointF> jsonToPoints(JsonReader r3, float r4) throws IOException {
        ArrayList r0 = new ArrayList();
        r3.beginArray();
    L4:
        if (r3.peek() != JsonReader.Token.BEGIN_ARRAY) goto L6;
        r3.beginArray();
        r0.add(jsonToPoint(r3, r4));
        r3.endArray();
        goto L4
    L6:
        r3.endArray();
        return r0;
    }

    static PointF jsonToPoint(JsonReader r2, float r3) throws IOException {
        int r0 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[r2.peek().ordinal()];
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L13;
        if (r0 != 3) goto L11;
        return jsonObjectToPoint(r2, r3);
    L11:
        throw new IllegalArgumentException("Unknown point starts with " + r2.peek());
    L13:
        return jsonArrayToPoint(r2, r3);
    L15:
        return jsonNumbersToPoint(r2, r3);
    }

    private static PointF jsonNumbersToPoint(JsonReader r3, float r4) throws IOException {
        float r0 = (float) r3.nextDouble();
        float r1 = (float) r3.nextDouble();
    L4:
        if (r3.hasNext() == false) goto L7;
        r3.skipValue();
        goto L4
    L7:
        return new PointF(r0 * r4, r1 * r4);
    }

    private static PointF jsonArrayToPoint(JsonReader r4, float r5) throws IOException {
        r4.beginArray();
        float r0 = (float) r4.nextDouble();
        float r1 = (float) r4.nextDouble();
    L4:
        if (r4.peek() == JsonReader.Token.END_ARRAY) goto L6;
        r4.skipValue();
        goto L4
    L6:
        r4.endArray();
        return new PointF(r0 * r5, r1 * r5);
    }

    static {
        POINT_NAMES = JsonReader.Options.of(new String[]{MaterialConfigFormatNames.X, "y"});
    }

    private static PointF jsonObjectToPoint(JsonReader r4, float r5) throws IOException {
        r4.beginObject();
        float r0 = 0.0f;
        float r1 = 0.0f;
    L4:
        if (r4.hasNext() == false) goto L12;
        int r2 = r4.selectName(POINT_NAMES);
        if (r2 != 0) goto L8;
        r0 = valueFromObject(r4);
        goto L4
    L8:
        if (r2 != 1) goto L9;
        r1 = valueFromObject(r4);
        goto L4
    L9:
        r4.skipName();
        r4.skipValue();
        goto L4
    L12:
        r4.endObject();
        return new PointF(r0 * r5, r1 * r5);
    }

    static float valueFromObject(JsonReader r3) throws IOException {
        JsonReader.Token r0 = r3.peek();
        int r1 = AnonymousClass1.$SwitchMap$com$airbnb$lottie$parser$moshi$JsonReader$Token[r0.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 != 2) goto L13;
        r3.beginArray();
        float r2 = (float) r3.nextDouble();
    L8:
        if (r3.hasNext() == false) goto L10;
        r3.skipValue();
        goto L8
    L10:
        r3.endArray();
        return r2;
    L13:
        throw new IllegalArgumentException("Unknown value for token of type " + r0);
    L15:
        return (float) r3.nextDouble();
    }
}
