package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class AnimatablePathValueParser {
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"k", MaterialConfigFormatNames.X, "y"});
    }

    private AnimatablePathValueParser() {
    }

    public static AnimatablePathValue parse(JsonReader r3, LottieComposition r4) throws IOException {
        ArrayList r0 = new ArrayList();
        if (r3.peek() != JsonReader.Token.BEGIN_ARRAY) goto L9;
        r3.beginArray();
    L6:
        if (r3.hasNext() == false) goto L8;
        r0.add(PathKeyframeParser.parse(r3, r4));
        goto L6
    L8:
        r3.endArray();
        KeyframesParser.setEndFrames(r0);
    L11:
        return new AnimatablePathValue(r0);
    L9:
        r0.add(new Keyframe(JsonUtils.jsonToPoint(r3, Utils.dpScale())));
        goto L11
    }

    static AnimatableValue<PointF, PointF> parseSplitPath(JsonReader r7, LottieComposition r8) throws IOException {
        r7.beginObject();
        AnimatablePathValue r0 = null;
        AnimatableFloatValue r2 = null;
        boolean r3 = false;
        AnimatableFloatValue r1 = null;
    L4:
        if (r7.peek() == JsonReader.Token.END_OBJECT) goto L22;
        int r4 = r7.selectName(NAMES);
        if (r4 != 0) goto L8;
        r0 = parse(r7, r8);
        goto L4
    L8:
        if (r4 != 1) goto L10;
        if (r7.peek() == JsonReader.Token.STRING) goto L18;
        r1 = AnimatableValueParser.parseFloat(r7, r8);
        goto L4
    L18:
        r7.skipValue();
    L19:
        r3 = true;
        goto L4
    L10:
        if (r4 != 2) goto L11;
        if (r7.peek() == JsonReader.Token.STRING) goto L14;
        r2 = AnimatableValueParser.parseFloat(r7, r8);
        goto L4
    L14:
        r7.skipValue();
        goto L19
    L11:
        r7.skipName();
        r7.skipValue();
        goto L4
    L22:
        r7.endObject();
        if (r3 == false) goto L25;
        r8.addWarning("Lottie doesn't support expressions.");
    L25:
        if (r0 == null) goto L28;
        return r0;
    L28:
        return new AnimatableSplitDimensionPathValue(r1, r2);
    }
}
