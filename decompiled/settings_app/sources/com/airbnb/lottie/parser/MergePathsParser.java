package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class MergePathsParser {
    private static final JsonReader.Options NAMES = null;

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "mm", "hd"});
    }

    private MergePathsParser() {
    }

    static MergePaths parse(JsonReader r5) throws IOException {
        String r0 = null;
        boolean r2 = false;
        MergePaths.MergePathsMode r1 = null;
    L4:
        if (r5.hasNext() == false) goto L16;
        int r3 = r5.selectName(NAMES);
        if (r3 != 0) goto L8;
        r0 = r5.nextString();
        goto L4
    L8:
        if (r3 != 1) goto L10;
        r1 = MergePaths.MergePathsMode.forId(r5.nextInt());
        goto L4
    L10:
        if (r3 != 2) goto L11;
        r2 = r5.nextBoolean();
        goto L4
    L11:
        r5.skipName();
        r5.skipValue();
        goto L4
    L16:
        return new MergePaths(r0, r1, r2);
    }
}
