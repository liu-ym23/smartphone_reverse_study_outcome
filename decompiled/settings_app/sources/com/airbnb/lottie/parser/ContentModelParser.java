package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class ContentModelParser {
    private static JsonReader.Options NAMES;

    static {
        NAMES = JsonReader.Options.of(new String[]{"ty", "d"});
    }

    private ContentModelParser() {
    }

    static ContentModel parse(JsonReader r7, LottieComposition r8) throws IOException {
        r7.beginObject();
        byte r0 = 2;
        int r1 = 2;
    L3:
        ContentModel r4 = null;
        if (r7.hasNext() == false) goto L11;
        int r2 = r7.selectName(NAMES);
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L8;
        r1 = r7.nextInt();
        goto L3
    L8:
        r7.skipName();
        r7.skipValue();
        goto L3
    L10:
        String r3 = r7.nextString();
    L12:
        if (r3 != null) goto L14;
        return null;
    L14:
        r3.hashCode();
        switch(r3.hashCode()) {
            case 3239: goto L65;
            case 3270: goto L61;
            case 3295: goto L58;
            case 3307: goto L54;
            case 3308: goto L50;
            case 3488: goto L46;
            case 3633: goto L42;
            case 3646: goto L38;
            case 3669: goto L34;
            case 3679: goto L30;
            case 3681: goto L26;
            case 3705: goto L22;
            case 3710: goto L18;
            default: goto L16;
        };
    L16:
        r0 = -1;
    L68:
        switch(r0) {
            case 0: goto L82;
            case 1: goto L81;
            case 2: goto L80;
            case 3: goto L79;
            case 4: goto L78;
            case 5: goto L77;
            case 6: goto L76;
            case 7: goto L75;
            case 8: goto L74;
            case 9: goto L73;
            case 10: goto L72;
            case 11: goto L71;
            case 12: goto L70;
            default: goto L69;
        };
    L69:
        Logger.warning("Unknown shape type " + r3);
    L84:
        if (r7.hasNext() == false) goto L86;
        r7.skipValue();
        goto L84
    L86:
        r7.endObject();
        return r4;
    L70:
        r4 = AnimatableTransformParser.parse(r7, r8);
        goto L84
    L71:
        r4 = ShapeTrimPathParser.parse(r7, r8);
        goto L84
    L72:
        r4 = ShapeStrokeParser.parse(r7, r8);
        goto L84
    L73:
        r4 = PolystarShapeParser.parse(r7, r8);
        goto L84
    L74:
        r4 = ShapePathParser.parse(r7, r8);
        goto L84
    L75:
        r4 = RepeaterParser.parse(r7, r8);
        goto L84
    L76:
        r4 = RectangleShapeParser.parse(r7, r8);
        goto L84
    L77:
        r4 = MergePathsParser.parse(r7);
        r8.addWarning("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
        goto L84
    L78:
        r4 = GradientStrokeParser.parse(r7, r8);
        goto L84
    L79:
        r4 = ShapeGroupParser.parse(r7, r8);
        goto L84
    L80:
        r4 = GradientFillParser.parse(r7, r8);
        goto L84
    L81:
        r4 = ShapeFillParser.parse(r7, r8);
        goto L84
    L82:
        r4 = CircleShapeParser.parse(r7, r8, r1);
        goto L84
    L18:
        if (r3.equals("tr") == false) goto L97;
        r0 = 12;
        goto L68
    L97:
        r0 = -1;
        goto L68
    L22:
        if (r3.equals("tm") == false) goto L98;
        r0 = 11;
        goto L68
    L98:
        r0 = -1;
        goto L68
    L26:
        if (r3.equals("st") == false) goto L99;
        r0 = 10;
        goto L68
    L99:
        r0 = -1;
        goto L68
    L30:
        if (r3.equals("sr") == false) goto L100;
        r0 = 9;
        goto L68
    L100:
        r0 = -1;
        goto L68
    L34:
        if (r3.equals("sh") == false) goto L101;
        r0 = 8;
        goto L68
    L101:
        r0 = -1;
        goto L68
    L38:
        if (r3.equals("rp") == false) goto L102;
        r0 = 7;
        goto L68
    L102:
        r0 = -1;
        goto L68
    L42:
        if (r3.equals("rc") == false) goto L103;
        r0 = 6;
        goto L68
    L103:
        r0 = -1;
        goto L68
    L46:
        if (r3.equals("mm") == false) goto L104;
        r0 = 5;
        goto L68
    L104:
        r0 = -1;
        goto L68
    L50:
        if (r3.equals("gs") == false) goto L105;
        r0 = 4;
        goto L68
    L105:
        r0 = -1;
        goto L68
    L54:
        if (r3.equals("gr") == false) goto L106;
        r0 = 3;
        goto L68
    L106:
        r0 = -1;
        goto L68
    L58:
        if (r3.equals("gf") == true) goto L68;
        r0 = -1;
        goto L68
    L61:
        if (r3.equals("fl") == false) goto L108;
        r0 = 1;
        goto L68
    L108:
        r0 = -1;
        goto L68
    L65:
        if (r3.equals("el") == false) goto L109;
        r0 = 0;
        goto L68
    L109:
        r0 = -1;
        goto L68
    L11:
        r3 = null;
        goto L12
    }
}
