package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class PathKeyframeParser {
    private PathKeyframeParser() {
    }

    static PathKeyframe parse(JsonReader r3, LottieComposition r4) throws IOException {
        if (r3.peek() != JsonReader.Token.BEGIN_OBJECT) goto L5;
        boolean r0 = true;
    L7:
        return new PathKeyframe(r4, KeyframeParser.parse(r3, r4, Utils.dpScale(), PathParser.INSTANCE, r0));
    L5:
        r0 = false;
        goto L7
    }
}
