package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LottieCompositionMoshiParser {
    static JsonReader.Options ASSETS_NAMES;
    private static final JsonReader.Options FONT_NAMES = null;
    private static final JsonReader.Options MARKER_NAMES = null;
    private static final JsonReader.Options NAMES = null;

    public LottieCompositionMoshiParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers"});
        ASSETS_NAMES = JsonReader.Options.of(new String[]{"id", "layers", "w", "h", "p", "u"});
        FONT_NAMES = JsonReader.Options.of(new String[]{"list"});
        MARKER_NAMES = JsonReader.Options.of(new String[]{"cm", "tm", "dr"});
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
        if (r24.hasNext() == false) goto L24;
        switch(r24.selectName(NAMES)) {
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            default: goto L7;
        };
    L7:
        r24.skipName();
        r24.skipValue();
    L19:
        r12 = r12;
        r13 = r13;
        goto L4
    L8:
        parseMarkers(r24, r14, r13);
        goto L19
    L9:
        parseChars(r24, r14, r11);
        goto L19
    L10:
        parseFonts(r24, r12);
        goto L19
    L11:
        parseAssets(r24, r14, r9, r10);
        goto L19
    L12:
        parseLayers(r24, r14, r7, r8);
        goto L19
    L13:
        String[] r0 = r24.nextString().split("\\.");
        if (Utils.isAtLeastVersion(Integer.parseInt(r0[0]), Integer.parseInt(r0[1]), Integer.parseInt(r0[2]), 4, 4, 0) == true) goto L19;
        r14.addWarning("Lottie only supports bodymovin >= 4.4.0");
        goto L19
    L17:
        r6 = (float) r24.nextDouble();
        goto L19
    L18:
        r5 = ((float) r24.nextDouble()) - 0.01f;
        goto L19
    L20:
        r4 = (float) r24.nextDouble();
        goto L4
    L21:
        r15 = r24.nextInt();
        goto L4
    L22:
        r2 = r24.nextInt();
        goto L4
    L24:
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

    private static void parseAssets(JsonReader r10, LottieComposition r11, Map<String, List<Layer>> r12, Map<String, LottieImageAsset> r13) throws IOException {
        r10.beginArray();
    L4:
        if (r10.hasNext() == false) goto L35;
        ArrayList r0 = new ArrayList();
        LongSparseArray r1 = new LongSparseArray();
        r10.beginObject();
        int r5 = 0;
        int r6 = 0;
        String r7 = null;
        String r8 = null;
        String r9 = null;
    L7:
        if (r10.hasNext() == false) goto L31;
        int r2 = r10.selectName(ASSETS_NAMES);
        if (r2 != 0) goto L11;
        r7 = r10.nextString();
        goto L7
    L11:
        if (r2 != 1) goto L13;
        r10.beginArray();
    L27:
        if (r10.hasNext() == false) goto L29;
        Layer r3 = LayerParser.parse(r10, r11);
        r1.put(r3.getId(), r3);
        r0.add(r3);
        goto L27
    L29:
        r10.endArray();
        goto L7
    L13:
        if (r2 != 2) goto L15;
        r5 = r10.nextInt();
        goto L7
    L15:
        if (r2 != 3) goto L17;
        r6 = r10.nextInt();
        goto L7
    L17:
        if (r2 != 4) goto L19;
        r8 = r10.nextString();
        goto L7
    L19:
        if (r2 != 5) goto L20;
        r9 = r10.nextString();
        goto L7
    L20:
        r10.skipName();
        r10.skipValue();
        goto L7
    L31:
        r10.endObject();
        if (r8 != null) goto L33;
        r12.put(r7, r0);
        goto L4
    L33:
        LottieImageAsset r4 = new LottieImageAsset(r5, r6, r7, r8, r9);
        r13.put(r4.getId(), r4);
        goto L4
    L35:
        r10.endArray();
    }

    private static void parseFonts(JsonReader r2, Map<String, Font> r3) throws IOException {
        r2.beginObject();
    L4:
        if (r2.hasNext() == false) goto L13;
        if (r2.selectName(FONT_NAMES) != 0) goto L7;
        r2.beginArray();
    L10:
        if (r2.hasNext() == false) goto L12;
        Font r0 = FontParser.parse(r2);
        r3.put(r0.getName(), r0);
        goto L10
    L12:
        r2.endArray();
        goto L4
    L7:
        r2.skipName();
        r2.skipValue();
        goto L4
    L13:
        r2.endObject();
    }

    private static void parseChars(JsonReader r2, LottieComposition r3, SparseArrayCompat<FontCharacter> r4) throws IOException {
        r2.beginArray();
    L4:
        if (r2.hasNext() == false) goto L6;
        FontCharacter r0 = FontCharacterParser.parse(r2, r3);
        r4.put(r0.hashCode(), r0);
        goto L4
    L6:
        r2.endArray();
    }

    private static void parseMarkers(JsonReader r4, LottieComposition r5, List<Marker> r6) throws IOException {
        r4.beginArray();
    L4:
        if (r4.hasNext() == false) goto L19;
        r4.beginObject();
        float r7 = 0.0f;
        String r1 = null;
        float r0 = 0.0f;
    L7:
        if (r4.hasNext() == false) goto L18;
        int r2 = r4.selectName(MARKER_NAMES);
        if (r2 != 0) goto L11;
        r1 = r4.nextString();
        goto L7
    L11:
        if (r2 != 1) goto L13;
        r7 = (float) r4.nextDouble();
        goto L7
    L13:
        if (r2 != 2) goto L14;
        r0 = (float) r4.nextDouble();
        goto L7
    L14:
        r4.skipName();
        r4.skipValue();
        goto L7
    L18:
        r4.endObject();
        r6.add(new Marker(r1, r7, r0));
        goto L4
    L19:
        r4.endArray();
    }
}
