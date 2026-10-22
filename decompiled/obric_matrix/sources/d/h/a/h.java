package d.h.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class h {
    static int a(Throwable r2, boolean r3) {
        if (r2 != null) goto L5;
        return TypedValues.TransitionType.TYPE_DURATION;
    L5:
        String r1 = r2.getMessage();
        if (r3 == false) goto L9;
        return 100;
    L9:
        if ((r2 instanceof IOException) == false) goto L12;
        return 201;
    L12:
        if ((r2 instanceof InterruptedException) == false) goto L15;
        return TypedValues.PositionType.TYPE_TRANSITION_EASING;
    L15:
        if ((r2 instanceof d.c.i.f.h) == false) goto L18;
        return 601;
    L18:
        if ((r2 instanceof IllegalArgumentException) == false) goto L32;
        if (r1.contains("ByteBuffer must be direct") == false) goto L23;
        return 301;
    L23:
        if (r1.contains("Failed to create demuxer") == false) goto L26;
        return 302;
    L26:
        if (r1.contains("Width or height is negative") == false) goto L29;
        return 303;
    L29:
        if (r1.contains("Problem decoding into existing bitmap") == false) goto L94;
        return 304;
    L94:
        return TypedValues.TransitionType.TYPE_DURATION;
    L32:
        if ((r2 instanceof IllegalStateException) == false) goto L70;
        if (r1.contains("Invalid dimensions") == false) goto L37;
        return 305;
    L37:
        if (r1.contains("Failed to slurp image") == false) goto L40;
        return 306;
    L40:
        if (r1.contains("No fames in image") == false) goto L43;
        return 307;
    L43:
        if (r1.contains("Already disposed") == false) goto L46;
        return 308;
    L46:
        if (r1.contains("unable to get frame") == false) goto L49;
        return 309;
    L49:
        if (r1.contains("Bad bitmap") == false) goto L52;
        return 310;
    L52:
        if (r1.contains("Width or height is too small") == false) goto L55;
        return 311;
    L55:
        if (r1.contains("Wrong color format") == false) goto L58;
        return 312;
    L58:
        if (r1.contains("WebPInitDecoderConfig failed") == false) goto L61;
        return 313;
    L61:
        if (r1.contains("WebPGetFeatures failed") == false) goto L64;
        return 314;
    L64:
        if (r1.contains("Failed to decode frame. VP8StatusCode:") == false) goto L67;
        return 315;
    L67:
        if (r1.contains("WebpBitmapFactory is null") == false) goto L107;
        return TypedValues.AttributesType.TYPE_PATH_ROTATE;
    L107:
        return TypedValues.TransitionType.TYPE_DURATION;
    L70:
        if ((r2 instanceof RuntimeException) == true) goto L72;
        return TypedValues.TransitionType.TYPE_DURATION;
    L72:
        if (r1.contains("Could not create WebPDemux from image. This webp might be malformed") == false) goto L75;
        return TypedValues.AttributesType.TYPE_EASING;
    L75:
        if (r1.contains("unrecognized pixel format") == false) goto L78;
        return TypedValues.AttributesType.TYPE_PIVOT_TARGET;
    L78:
        if (r1.contains("Wrong pixel format for jpeg encoding") == false) goto L81;
        return TypedValues.CycleType.TYPE_CURVE_FIT;
    L81:
        if (r1.contains("Could not write scanline") == false) goto L84;
        return TypedValues.CycleType.TYPE_VISIBILITY;
    L84:
        if (r1.contains("could not allocate memory") == false) goto L114;
        return TypedValues.MotionType.TYPE_QUANTIZE_MOTION_PHASE;
    L114:
        return TypedValues.TransitionType.TYPE_DURATION;
    }

    static int b(Throwable r1) {
        if (r1 == null) goto L18;
        String r2 = r1.getMessage();
        if (r2 != null) goto L6;
        return 1;
    L6:
        if (r2.length() != 0) goto L8;
        return 1;
    L8:
        if (r2.contains("canceled") == false) goto L10;
        return 2;
    L10:
        if (r2.contains("Canceled") == false) goto L13;
        return 2;
    L13:
        if (r2.contains("network not available") == false) goto L23;
        return 3;
    L23:
        return 1;
    L18:
        return 1;
    }

    static int c(d.c.i.q.b.a r1) {
        if (r1.equals(d.c.i.q.b.a.f16505h) == false) goto L6;
        return 0;
    L6:
        return 1;
    }

    static int d(String r8) {
        r8.hashCode();
        byte r7 = -1;
        switch(r8.hashCode()) {
            case -1914072202: goto L30;
            case -1307634203: goto L26;
            case -1224383234: goto L22;
            case 656304759: goto L18;
            case 957714404: goto L14;
            case 1023071510: goto L10;
            case 2109593398: goto L6;
            default: goto L33;
        };
    L33:
        switch(r7) {
            case 0: goto L40;
            case 1: goto L46;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L40;
            case 5: goto L41;
            case 6: goto L43;
            default: goto L34;
        };
    L34:
        return 7;
    L41:
        return 6;
    L43:
        return 2;
    L44:
        return 3;
    L45:
        return 1;
    L46:
        return 4;
    L40:
        return 5;
    L6:
        if (r8.equals("PartialDiskCacheProducer") == false) goto L33;
        r7 = 6;
        goto L33
    L10:
        if (r8.equals("PostprocessedBitmapMemoryCacheProducer") == false) goto L33;
        r7 = 5;
        goto L33
    L14:
        if (r8.equals("BitmapMemoryCacheProducer") == false) goto L33;
        r7 = 4;
        goto L33
    L18:
        if (r8.equals("DiskCacheProducer") == false) goto L33;
        r7 = 3;
        goto L33
    L22:
        if (r8.equals("NetworkFetchProducer") == false) goto L33;
        r7 = 2;
        goto L33
    L26:
        if (r8.equals("EncodedMemoryCacheProducer") == false) goto L33;
        r7 = 1;
        goto L33
    L30:
        if (r8.equals("BitmapMemoryCacheGetProducer") == false) goto L33;
        r7 = 0;
        goto L33
    }
}
