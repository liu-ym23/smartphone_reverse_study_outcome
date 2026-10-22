package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    @Override // com.airbnb.lottie.parser.ValueParser
    public /* bridge */ /* synthetic */ GradientColor parse(JsonReader r1, float r2) throws IOException {
        return parse(r1, r2);
    }

    public GradientColorParser(int r1) {
        this.colorPoints = r1;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.airbnb.lottie.parser.ValueParser
    public GradientColor parse(JsonReader r13, float r14) throws IOException {
        ArrayList r15 = new ArrayList();
        int r3 = 0;
        if (r13.peek() != JsonReader.Token.BEGIN_ARRAY) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r13.beginArray();
    L9:
        if (r13.hasNext() == false) goto L11;
        r15.add(Float.valueOf((float) r13.nextDouble()));
        goto L9
    L11:
        if (r0 == false) goto L14;
        r13.endArray();
    L14:
        if (this.colorPoints != (-1)) goto L16;
        this.colorPoints = r15.size() / 4;
    L16:
        int r16 = this.colorPoints;
        float[] r1 = new float[r16];
        int[] r17 = new int[r16];
        int r2 = 0;
        int r4 = 0;
    L18:
        if (r3 >= (this.colorPoints * 4)) goto L33;
        int r5 = r3 / 4;
        double r6 = r15.get(r3).floatValue();
        int r8 = r3 % 4;
        if (r8 != 0) goto L22;
        r1[r5] = (float) r6;
    L32:
        r3 = r3 + 1;
        goto L18
    L22:
        if (r8 != 1) goto L24;
        r2 = (int) (r6 * 255.0d);
        goto L32
    L24:
        if (r8 != 2) goto L26;
        r4 = (int) (r6 * 255.0d);
        goto L32
    L26:
        if (r8 != 3) goto L32;
        r17[r5] = Color.argb(255, r2, r4, (int) (r6 * 255.0d));
        goto L32
    L33:
        GradientColor r7 = new GradientColor(r1, r17);
        addOpacityStopsToGradientIfNeeded(r7, r15);
        return r7;
    L5:
        r0 = false;
        goto L6
    }

    private void addOpacityStopsToGradientIfNeeded(GradientColor r8, List<Float> r9) {
        int r0 = this.colorPoints * 4;
        if (r9.size() > r0) goto L5;
        return;
    L5:
        int r1 = (r9.size() - r0) / 2;
        double[] r2 = new double[r1];
        double[] r3 = new double[r1];
        int r4 = 0;
        int r5 = 0;
    L7:
        if (r0 >= r9.size()) goto L14;
        if ((r0 % 2) != 0) goto L11;
        r2[r5] = r9.get(r0).floatValue();
    L12:
        r0 = r0 + 1;
        goto L7
    L11:
        r3[r5] = r9.get(r0).floatValue();
        r5 = r5 + 1;
    L14:
        if (r4 >= r8.getSize()) goto L16;
        int r10 = r8.getColors()[r4];
        r8.getColors()[r4] = Color.argb(getOpacityAtPosition(r8.getPositions()[r4], r2, r3), Color.red(r10), Color.green(r10), Color.blue(r10));
        r4 = r4 + 1;
        goto L14
    }

    private int getOpacityAtPosition(double r20, double[] r22, double[] r23) {
        int r3 = 1;
    L4:
        if (r3 >= r22.length) goto L11;
        int r4 = r3 - 1;
        double r7 = r22[r4];
        double r9 = r22[r3];
        if (r9 >= r20) goto L7;
        r3 = r3 + 1;
        goto L4
    L7:
        double r0 = MiscUtils.lerp(r23[r4], r23[r3], (r20 - r7) / (r9 - r7));
    L9:
        return (int) (r0 * 255.0d);
    L11:
        r0 = r23[r23.length - 1];
        goto L9
    }
}
