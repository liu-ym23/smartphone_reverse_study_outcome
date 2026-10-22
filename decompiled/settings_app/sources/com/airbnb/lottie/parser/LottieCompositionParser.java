package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionParser {
    static JsonReader.Options NAMES;

    public LottieCompositionParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers"});
    }

    public static LottieComposition parse(JsonReader r24) throws IOException {
        float r1 = Utils.dpScale();
        LongSparseArray<Layer> r8 = new LongSparseArray();
        ArrayList r7 = new ArrayList();
        HashMap r9 = new HashMap();
        HashMap r10 = new HashMap();
        HashMap r12 = new HashMap();
        ArrayList r13 = new ArrayList();
        SparseArrayCompat<FontCharacter> r11 = new SparseArrayCompat();
        LottieComposition r14 = new LottieComposition();
        r24.beginObject();
        float r4 = 0.0f;
        float r5 = 0.0f;
        float r6 = 0.0f;
        int r2 = 0;
        int r15 = 0;
    L4:
        if (r24.hasNext() == false) goto L21;
        switch(r24.selectName(NAMES)) {
            case 0: goto L17;
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L9;
            case 6: goto L8;
            default: goto L18;
        };
    L8:
        parseLayers(r24, r14, r7, r8);
        goto L18
    L9:
        String[] r0 = r24.nextString().split("\\.");
        if (Utils.isAtLeastVersion(Integer.parseInt(r0[0]), Integer.parseInt(r0[1]), Integer.parseInt(r0[2]), 4, 4, 0) == true) goto L19;
        r14.addWarning("Lottie only supports bodymovin >= 4.4.0");
    L19:
        r12 = r12;
        r13 = r13;
        goto L4
    L13:
        r6 = (float) r24.nextDouble();
        goto L19
    L14:
        r5 = ((float) r24.nextDouble()) - 0.01f;
        goto L19
    L15:
        r4 = (float) r24.nextDouble();
        goto L4
    L16:
        r15 = r24.nextInt();
        goto L4
    L17:
        r2 = r24.nextInt();
    L18:
        r24.skipValue();
        goto L19
    L21:
        r14.init(new Rect(0, 0, (int) (r2 * r1), (int) (r15 * r1)), r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        return r14;
    }

    private static void parseLayers(JsonReader r4, LottieComposition r5, List<Layer> r6, LongSparseArray<Layer> r7) throws IOException {
        r4.beginArray();
        int r0 = 0;
    L4:
        if (r4.hasNext() == false) goto L11;
        Layer r1 = LayerParser.parse(r4, r5);
        if (r1.getLayerType() != Layer.LayerType.IMAGE) goto L8;
        r0 = r0 + 1;
    L8:
        r6.add(r1);
        r7.put(r1.getId(), r1);
        if (r0 <= 4) goto L4;
        Logger.warning("You have " + r0 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
        goto L4
    L11:
        r4.endArray();
    }
}
