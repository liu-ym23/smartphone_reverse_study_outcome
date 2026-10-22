package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.icu.text.DateFormat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class KeyframeParser {
    private static final Interpolator LINEAR_INTERPOLATOR = null;
    private static final float MAX_CP_VALUE = 100.0f;
    static JsonReader.Options NAMES;
    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache;

    KeyframeParser() {
    }

    static {
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        NAMES = JsonReader.Options.of(new String[]{"t", DateFormat.SECOND, "e", "o", "i", "h", "to", "ti"});
    }

    private static SparseArrayCompat<WeakReference<Interpolator>> pathInterpolatorCache() {
        if (pathInterpolatorCache != null) goto L6;
        pathInterpolatorCache = new SparseArrayCompat();
    L6:
        return pathInterpolatorCache;
    }

    private static WeakReference<Interpolator> getInterpolator(int r2) {
        monitor-enter(KeyframeParser.class);
        WeakReference<Interpolator> r3 = pathInterpolatorCache().get(r2);     // Catch: Throwable -> L7
        monitor-exit(KeyframeParser.class);     // Catch: Throwable -> L7
        return r3;
    L7:
        th = move-exception;
        throw th;
    }

    private static void putInterpolator(int r2, WeakReference<Interpolator> r3) {
        monitor-enter(KeyframeParser.class);
        pathInterpolatorCache.put(r2, r3);     // Catch: Throwable -> L7
        monitor-exit(KeyframeParser.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static <T> Keyframe<T> parse(JsonReader r0, LottieComposition r1, float r2, ValueParser<T> r3, boolean r4) throws IOException {
        if (r4 == false) goto L6;
        return parseKeyframe(r1, r0, r2, r3);
    L6:
        return parseStaticValue(r0, r2, r3);
    }

    private static <T> Keyframe<T> parseKeyframe(LottieComposition r12, JsonReader r13, float r14, ValueParser<T> r15) throws IOException {
        r13.beginObject();
        Interpolator r0 = null;
        PointF r3 = null;
        PointF r4 = null;
        T r5 = null;
        T r6 = null;
        PointF r10 = null;
        PointF r11 = null;
        float r8 = 0.0f;
    L3:
        boolean r1 = false;
    L5:
        if (r13.hasNext() == false) goto L19;
        switch(r13.selectName(NAMES)) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        r11 = JsonUtils.jsonToPoint(r13, r14);
        goto L5
    L10:
        r10 = JsonUtils.jsonToPoint(r13, r14);
        goto L5
    L12:
        if (r13.nextInt() != 1) goto L3;
        r1 = true;
        goto L5
    L14:
        r4 = JsonUtils.jsonToPoint(r13, r14);
        goto L5
    L15:
        r3 = JsonUtils.jsonToPoint(r13, r14);
        goto L5
    L16:
        r6 = r15.parse(r13, r14);
        goto L5
    L17:
        r5 = r15.parse(r13, r14);
        goto L5
    L18:
        r8 = (float) r13.nextDouble();
        goto L5
    L8:
        r13.skipValue();
        goto L5
    L19:
        r13.endObject();
        if (r1 == false) goto L22;
        Interpolator r7 = LINEAR_INTERPOLATOR;
        r6 = r5;
    L33:
        Keyframe<T> r16 = new Keyframe(r12, r5, r6, r7, r8, null);
        r16.pathCp1 = r10;
        r16.pathCp2 = r11;
        return r16;
    L22:
        if (r3 == null) goto L32;
        if (r4 == null) goto L32;
        float r17 = -r14;
        r3.x = MiscUtils.clamp(r3.x, r17, r14);
        r3.y = MiscUtils.clamp(r3.y, -100.0f, MAX_CP_VALUE);
        r4.x = MiscUtils.clamp(r4.x, r17, r14);
        r4.y = MiscUtils.clamp(r4.y, -100.0f, MAX_CP_VALUE);
        int r18 = Utils.hashFor(r3.x, r3.y, r4.x, r4.y);
        WeakReference<Interpolator> r19 = getInterpolator(r18);
        if (r19 == null) goto L27;
        r0 = r19.get();
    L27:
        if (r19 == null) goto L29;
        if (r0 == null) goto L29;
    L31:
        r7 = r0;
    L29:
        r0 = PathInterpolatorCompat.create(r3.x / r14, r3.y / r14, r4.x / r14, r4.y / r14);
        putInterpolator(r18, new WeakReference(r0));     // Catch: ArrayIndexOutOfBoundsException -> L35
    L32:
        r7 = LINEAR_INTERPOLATOR;
        goto L33
    }

    private static <T> Keyframe<T> parseStaticValue(JsonReader r0, float r1, ValueParser<T> r2) throws IOException {
        return new Keyframe(r2.parse(r0, r1));
    }
}
