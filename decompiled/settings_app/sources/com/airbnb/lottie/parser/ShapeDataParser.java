package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {
    public static final ShapeDataParser INSTANCE = null;
    private static final JsonReader.Options NAMES = null;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ ShapeData parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    static {
        INSTANCE = new ShapeDataParser();
        NAMES = JsonReader.Options.of(new String[]{"c", "v", "i", "o"});
    }

    private ShapeDataParser() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public ShapeData parse(JsonReader r12, float r13) throws IOException {
        if (r12.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        r12.beginArray();
    L5:
        r12.beginObject();
        List<PointF> r11 = null;
        List<PointF> r1 = null;
        List<PointF> r2 = null;
        boolean r3 = false;
    L7:
        if (r12.hasNext() == false) goto L20;
        int r4 = r12.selectName(NAMES);
        if (r4 != 0) goto L10;
        r3 = r12.nextBoolean();
        goto L7
    L10:
        if (r4 != 1) goto L12;
        r11 = JsonUtils.jsonToPoints(r12, r13);
        goto L7
    L12:
        if (r4 != 2) goto L14;
        r1 = JsonUtils.jsonToPoints(r12, r13);
        goto L7
    L14:
        if (r4 != 3) goto L15;
        r2 = JsonUtils.jsonToPoints(r12, r13);
        goto L7
    L15:
        r12.skipName();
        r12.skipValue();
        goto L7
    L20:
        r12.endObject();
        if (r12.peek() != JsonReader.Token.END_ARRAY) goto L23;
        r12.endArray();
    L23:
        if (r11 == null) goto L38;
        if (r1 == null) goto L38;
        if (r2 == null) goto L38;
        if (r11.isEmpty() == true) goto L29;
        int r14 = r11.size();
        PointF r15 = r11.get(0);
        ArrayList r5 = new ArrayList(r14);
        int r6 = 1;
    L31:
        if (r6 >= r14) goto L33;
        PointF r7 = r11.get(r6);
        int r8 = r6 - 1;
        r5.add(new CubicCurveData(MiscUtils.addPoints(r11.get(r8), r2.get(r8)), MiscUtils.addPoints(r7, r1.get(r6)), r7));
        r6 = r6 + 1;
        goto L31
    L33:
        if (r3 == false) goto L36;
        PointF r9 = r11.get(0);
        int r16 = r14 - 1;
        r5.add(new CubicCurveData(MiscUtils.addPoints(r11.get(r16), r2.get(r16)), MiscUtils.addPoints(r9, r1.get(0)), r9));
    L36:
        return new ShapeData(r15, r3, r5);
    L29:
        return new ShapeData(new PointF(), false, Collections.emptyList());
    L38:
        throw new IllegalArgumentException("Shape data was missing information.");
    }
}
