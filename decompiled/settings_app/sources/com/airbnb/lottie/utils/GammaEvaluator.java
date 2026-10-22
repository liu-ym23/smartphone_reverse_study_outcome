package com.airbnb.lottie.utils;

/* JADX INFO: loaded from: classes.dex */
public class GammaEvaluator {
    public GammaEvaluator() {
    }

    private static float OECF_sRGB(float r4) {
        if (r4 > 0.0031308f) goto L6;
        return r4 * 12.92f;
    L6:
        return (float) ((Math.pow(r4, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float EOCF_sRGB(float r4) {
        if (r4 > 0.04045f) goto L6;
        return r4 / 12.92f;
    L6:
        return (float) Math.pow((r4 + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int evaluate(float r7, int r8, int r9) {
        if (r8 != r9) goto L4;
        return r8;
    L4:
        float r0 = ((r8 >> 24) & 255) / 255.0f;
        float r2 = EOCF_sRGB(((r8 >> 16) & 255) / 255.0f);
        float r3 = EOCF_sRGB(((r8 >> 8) & 255) / 255.0f);
        float r10 = EOCF_sRGB((r8 & 255) / 255.0f);
        float r5 = EOCF_sRGB(((r9 >> 16) & 255) / 255.0f);
        float r1 = r0 + (((((r9 >> 24) & 255) / 255.0f) - r0) * r7);
        float r4 = r3 + ((EOCF_sRGB(((r9 >> 8) & 255) / 255.0f) - r3) * r7);
        float r11 = r10 + (r7 * (EOCF_sRGB((r9 & 255) / 255.0f) - r10));
        float r12 = OECF_sRGB(r2 + ((r5 - r2) * r7)) * 255.0f;
        float r13 = OECF_sRGB(r4) * 255.0f;
        float r14 = OECF_sRGB(r11) * 255.0f;
        return (((Math.round(r12) << 16) | (Math.round(r1 * 255.0f) << 24)) | (Math.round(r13) << 8)) | Math.round(r14);
    }
}
