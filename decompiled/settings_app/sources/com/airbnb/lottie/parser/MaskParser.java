package com.airbnb.lottie.parser;

import android.icu.text.DateFormat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class MaskParser {
    private MaskParser() {
    }

    static Mask parse(JsonReader r11, LottieComposition r12) throws IOException {
        r11.beginObject();
        Mask.MaskMode r0 = null;
        AnimatableShapeValue r2 = null;
        AnimatableIntegerValue r3 = null;
        boolean r4 = false;
    L4:
        if (r11.hasNext() == false) goto L53;
        String r5 = r11.nextName();
        r5.hashCode();
        byte r7 = 3;
        switch(r5.hashCode()) {
            case 111: goto L21;
            case 3588: goto L17;
            case 104433: goto L13;
            case 3357091: goto L9;
            default: goto L7;
        };
    L7:
        byte r6 = -1;
    L24:
        switch(r6) {
            case 0: goto L52;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L26;
            default: goto L25;
        };
    L26:
        String r1 = r11.nextString();
        r1.hashCode();
        switch(r1.hashCode()) {
            case 97: goto L41;
            case 105: goto L37;
            case 110: goto L33;
            case 115: goto L30;
            default: goto L28;
        };
    L28:
        r7 = -1;
    L44:
        switch(r7) {
            case 0: goto L49;
            case 1: goto L48;
            case 2: goto L47;
            case 3: goto L46;
            default: goto L45;
        };
    L46:
        r0 = Mask.MaskMode.MASK_MODE_SUBTRACT;
        goto L4
    L47:
        r0 = Mask.MaskMode.MASK_MODE_NONE;
        goto L4
    L48:
        r12.addWarning("Animation contains intersect masks. They are not supported but will be treated like add masks.");
        r0 = Mask.MaskMode.MASK_MODE_INTERSECT;
        goto L4
    L49:
        r0 = Mask.MaskMode.MASK_MODE_ADD;
        goto L4
    L45:
        Logger.warning("Unknown mask mode " + r5 + ". Defaulting to Add.");
        r0 = Mask.MaskMode.MASK_MODE_ADD;
        goto L4
    L30:
        if (r1.equals(DateFormat.SECOND) == true) goto L44;
        r7 = -1;
        goto L44
    L33:
        if (r1.equals("n") == false) goto L81;
        r7 = 2;
        goto L44
    L81:
        r7 = -1;
        goto L44
    L37:
        if (r1.equals("i") == false) goto L82;
        r7 = 1;
        goto L44
    L82:
        r7 = -1;
        goto L44
    L41:
        if (r1.equals("a") == false) goto L83;
        r7 = 0;
        goto L44
    L83:
        r7 = -1;
        goto L44
    L50:
        r4 = r11.nextBoolean();
        goto L4
    L51:
        r2 = AnimatableValueParser.parseShapeData(r11, r12);
        goto L4
    L52:
        r3 = AnimatableValueParser.parseInteger(r11, r12);
        goto L4
    L25:
        r11.skipValue();
        goto L4
    L9:
        if (r5.equals("mode") == false) goto L76;
        r6 = 3;
        goto L24
    L76:
        r6 = -1;
        goto L24
    L13:
        if (r5.equals("inv") == false) goto L77;
        r6 = 2;
        goto L24
    L77:
        r6 = -1;
        goto L24
    L17:
        if (r5.equals("pt") == false) goto L78;
        r6 = 1;
        goto L24
    L78:
        r6 = -1;
        goto L24
    L21:
        if (r5.equals("o") == false) goto L79;
        r6 = 0;
        goto L24
    L79:
        r6 = -1;
        goto L24
    L53:
        r11.endObject();
        return new Mask(r0, r2, r3, r4);
    }
}
