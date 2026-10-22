package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.model.animatable.AnimatableTextProperties;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class LayerParser {
    private static final JsonReader.Options EFFECTS_NAMES = null;
    private static final JsonReader.Options NAMES = null;
    private static final JsonReader.Options TEXT_NAMES = null;

    private LayerParser() {
    }

    static {
        NAMES = JsonReader.Options.of(new String[]{"nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd"});
        TEXT_NAMES = JsonReader.Options.of(new String[]{"d", "a"});
        EFFECTS_NAMES = JsonReader.Options.of(new String[]{"nm"});
    }

    public static Layer parse(LottieComposition r26) {
        Rect r18 = r26.getBounds();
        return new Layer(Collections.emptyList(), r26, "__container", -1, Layer.LayerType.PRE_COMP, -1, null, Collections.emptyList(), new AnimatableTransform(), 0, 0, 0, 0.0f, 0.0f, r18.width(), r18.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer parse(JsonReader r38, LottieComposition r39) throws IOException {
        Layer.MatteType r1 = Layer.MatteType.NONE;
        ArrayList r10 = new ArrayList();
        ArrayList r8 = new ArrayList();
        r38.beginObject();
        Float r13 = Float.valueOf(1.0f);
        Float r15 = Float.valueOf(0.0f);
        Layer.MatteType r31 = r1;
        String r20 = null;
        AnimatableTransform r21 = null;
        AnimatableTextFrame r29 = null;
        AnimatableTextProperties r30 = null;
        AnimatableFloatValue r32 = null;
        long r16 = 0;
        int r22 = 0;
        int r23 = 0;
        int r24 = 0;
        int r27 = 0;
        int r28 = 0;
        boolean r33 = false;
        float r25 = 1.0f;
        long r18 = -1;
        float r2 = 0.0f;
        float r26 = 0.0f;
        String r9 = "UNSET";
        String r11 = null;
        Layer.LayerType r12 = null;
        float r3 = 0.0f;
    L4:
        if (r38.hasNext() == false) goto L70;
        switch(r38.selectName(NAMES)) {
            case 0: goto L69;
            case 1: goto L68;
            case 2: goto L67;
            case 3: goto L63;
            case 4: goto L62;
            case 5: goto L61;
            case 6: goto L60;
            case 7: goto L59;
            case 8: goto L58;
            case 9: goto L57;
            case 10: goto L52;
            case 11: goto L45;
            case 12: goto L29;
            case 13: goto L17;
            case 14: goto L16;
            case 15: goto L15;
            case 16: goto L14;
            case 17: goto L13;
            case 18: goto L12;
            case 19: goto L11;
            case 20: goto L10;
            case 21: goto L9;
            case 22: goto L8;
            default: goto L7;
        };
    L8:
        r33 = r38.nextBoolean();
        goto L4
    L9:
        r11 = r38.nextString();
        goto L4
    L10:
        r32 = AnimatableValueParser.parseFloat(r38, r39, false);
        goto L4
    L11:
        r3 = (float) r38.nextDouble();
        goto L4
    L12:
        r2 = (float) r38.nextDouble();
        goto L4
    L13:
        r28 = (int) (r38.nextInt() * Utils.dpScale());
        goto L4
    L14:
        r27 = (int) (r38.nextInt() * Utils.dpScale());
        goto L4
    L15:
        r26 = (float) r38.nextDouble();
        goto L4
    L16:
        r25 = (float) r38.nextDouble();
        goto L4
    L17:
        r38.beginArray();
        ArrayList r4 = new ArrayList();
    L19:
        if (r38.hasNext() == false) goto L28;
        r38.beginObject();
    L22:
        if (r38.hasNext() == false) goto L27;
        if (r38.selectName(EFFECTS_NAMES) != 0) goto L25;
        r4.add(r38.nextString());
        goto L22
    L25:
        r38.skipName();
        r38.skipValue();
        goto L22
    L27:
        r38.endObject();
        goto L19
    L28:
        r38.endArray();
        r39.addWarning("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + r4);
        goto L4
    L29:
        r38.beginObject();
    L31:
        if (r38.hasNext() == false) goto L44;
        int r5 = r38.selectName(TEXT_NAMES);
        if (r5 != 0) goto L34;
        r29 = AnimatableValueParser.parseDocumentData(r38, r39);
        goto L31
    L34:
        if (r5 != 1) goto L35;
        r38.beginArray();
        if (r38.hasNext() == false) goto L40;
        r30 = AnimatableTextPropertiesParser.parse(r38, r39);
    L40:
        if (r38.hasNext() == false) goto L42;
        r38.skipValue();
        goto L40
    L42:
        r38.endArray();
        goto L31
    L35:
        r38.skipName();
        r38.skipValue();
        goto L31
    L44:
        r38.endObject();
        goto L4
    L45:
        r38.beginArray();
    L47:
        if (r38.hasNext() == false) goto L51;
        ContentModel r6 = ContentModelParser.parse(r38, r39);
        if (r6 == null) goto L47;
        r8.add(r6);
        goto L47
    L51:
        r38.endArray();
        goto L4
    L52:
        r38.beginArray();
    L54:
        if (r38.hasNext() == false) goto L56;
        r10.add(MaskParser.parse(r38, r39));
        goto L54
    L56:
        r39.incrementMatteOrMaskCount(r10.size());
        r38.endArray();
        goto L4
    L57:
        r31 = Layer.MatteType.values()[r38.nextInt()];
        r39.incrementMatteOrMaskCount(1);
        goto L4
    L58:
        r21 = AnimatableTransformParser.parse(r38, r39);
        goto L4
    L59:
        r24 = Color.parseColor(r38.nextString());
        goto L4
    L60:
        r23 = (int) (r38.nextInt() * Utils.dpScale());
        goto L4
    L61:
        r22 = (int) (r38.nextInt() * Utils.dpScale());
        goto L4
    L62:
        r18 = r38.nextInt();
        goto L4
    L63:
        int r7 = r38.nextInt();
        if (r7 < Layer.LayerType.UNKNOWN.ordinal()) goto L65;
        r12 = Layer.LayerType.UNKNOWN;
        goto L4
    L65:
        r12 = Layer.LayerType.values()[r7];
        goto L4
    L67:
        r20 = r38.nextString();
        goto L4
    L68:
        r16 = r38.nextInt();
        goto L4
    L69:
        r9 = r38.nextString();
        goto L4
    L7:
        r38.skipName();
        r38.skipValue();
        goto L4
    L70:
        r38.endObject();
        float r34 = r2 / r25;
        float r35 = r3 / r25;
        ArrayList r14 = new ArrayList();
        if (r34 <= 0.0f) goto L73;
        ArrayList r17 = r14;
        r17.add(new Keyframe(r39, r15, r15, null, 0.0f, Float.valueOf(r34)));
        float r0 = 0.0f;
    L75:
        if (r35 > r0) goto L78;
        r35 = r39.getEndFrame();
    L78:
        r17.add(new Keyframe(r39, r13, r13, null, r34, Float.valueOf(r35)));
        r17.add(new Keyframe(r39, r15, r15, null, r35, Float.valueOf(Float.MAX_VALUE)));
        if (r9.endsWith(".ai") == false) goto L81;
    L82:
        r39.addWarning("Convert your Illustrator layers to shape layers.");
    L84:
        return new Layer(r8, r39, r9, r16, r12, r18, r20, r10, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r17, r31, r32, r33);
    L81:
        if ("ai".equals(r11) == false) goto L84;
    L73:
        r17 = r14;
        r0 = 0.0f;
        goto L75
    }
}
