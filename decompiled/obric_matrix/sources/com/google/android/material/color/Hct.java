package com.google.android.material.color;

/* JADX INFO: loaded from: classes2.dex */
final class Hct {
    private static final float CHROMA_SEARCH_ENDPOINT = 0.4f;
    private static final float DE_MAX = 1.0f;
    private static final float DE_MAX_ERROR = 1.0E-9f;
    private static final float DL_MAX = 0.2f;
    private static final float LIGHTNESS_SEARCH_ENDPOINT = 0.01f;
    private float chroma;
    private float hue;
    private float tone;

    private Hct(float r1, float r2, float r3) {
        setInternalState(gamutMap(r1, r2, r3));
    }

    private static Cam16 findCamByJ(float r12, float r13, float r14) {
        float r0 = 1000.0f;
        float r5 = 0.0f;
        Cam16 r4 = null;
        float r3 = 100.0f;
        float r2 = 1000.0f;
    L4:
        if (Math.abs(r5 - r3) <= LIGHTNESS_SEARCH_ENDPOINT) goto L21;
        float r6 = ((r3 - r5) / 2.0f) + r5;
        int r7 = Cam16.fromJch(r6, r13, r12).getInt();
        float r8 = ColorUtils.lstarFromInt(r7);
        float r9 = Math.abs(r14 - r8);
        if (r9 >= 0.2f) goto L13;
        Cam16 r10 = Cam16.fromInt(r7);
        float r11 = r10.distance(Cam16.fromJch(r10.getJ(), r10.getChroma(), r12));
        if (r11 > 1.0f) goto L13;
        if (r11 > r0) goto L13;
        r4 = r10;
        r2 = r9;
        r0 = r11;
    L13:
        if (r2 != 0.0f) goto L18;
        if (r0 < DE_MAX_ERROR) goto L21;
    L18:
        if (r8 < r14) goto L19;
        r3 = r6;
        goto L4
    L19:
        r5 = r6;
    L21:
        return r4;
    }

    public static Hct from(float r1, float r2, float r3) {
        return new Hct(r1, r2, r3);
    }

    public static Hct fromInt(int r3) {
        Cam16 r0 = Cam16.fromInt(r3);
        return new Hct(r0.getHue(), r0.getChroma(), ColorUtils.lstarFromInt(r3));
    }

    private static int gamutMap(float r1, float r2, float r3) {
        return gamutMapInViewingConditions(r1, r2, r3, ViewingConditions.DEFAULT);
    }

    static int gamutMapInViewingConditions(float r6, float r7, float r8, ViewingConditions r9) {
        if (r7 < 1.0d) goto L28;
        if (Math.round(r8) <= 0.0d) goto L28;
        if (Math.round(r8) >= 100.0d) goto L28;
        float r10 = MathUtils.sanitizeDegrees(r6);
        Cam16 r3 = null;
        boolean r2 = true;
        float r1 = 0.0f;
        float r0 = r7;
    L11:
        if (Math.abs(r1 - r7) < CHROMA_SEARCH_ENDPOINT) goto L22;
        Cam16 r4 = findCamByJ(r10, r0, r8);
        if (r2 == false) goto L19;
        if (r4 != null) goto L16;
        r2 = false;
    L18:
        r0 = ((r7 - r1) / 2.0f) + r1;
        goto L11
    L16:
        return r4.viewed(r9);
    L19:
        if (r4 != null) goto L21;
        r7 = r0;
        goto L18
    L21:
        r1 = r0;
        r3 = r4;
        goto L18
    L22:
        if (r3 != null) goto L26;
        return ColorUtils.intFromLstar(r8);
    L26:
        return r3.viewed(r9);
    L28:
        return ColorUtils.intFromLstar(r8);
    }

    private void setInternalState(int r3) {
        Cam16 r0 = Cam16.fromInt(r3);
        float r4 = ColorUtils.lstarFromInt(r3);
        this.hue = r0.getHue();
        this.chroma = r0.getChroma();
        this.tone = r4;
    }

    public float getChroma() {
        return this.chroma;
    }

    public float getHue() {
        return this.hue;
    }

    public float getTone() {
        return this.tone;
    }

    public void setChroma(float r3) {
        setInternalState(gamutMap(this.hue, r3, this.tone));
    }

    public void setHue(float r3) {
        setInternalState(gamutMap(MathUtils.sanitizeDegrees(r3), this.chroma, this.tone));
    }

    public void setTone(float r3) {
        setInternalState(gamutMap(this.hue, this.chroma, r3));
    }

    public int toInt() {
        return gamutMap(this.hue, this.chroma, this.tone);
    }
}
