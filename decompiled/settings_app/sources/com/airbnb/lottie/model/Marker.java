package com.airbnb.lottie.model;

/* JADX INFO: loaded from: classes.dex */
public class Marker {
    private static String CARRIAGE_RETURN = "\r";
    public final float durationFrames;
    private final String name;
    public final float startFrame;

    static {
    }

    public Marker(String r1, float r2, float r3) {
        this.name = r1;
        this.durationFrames = r3;
        this.startFrame = r2;
    }

    public boolean matchesName(String r4) {
        if (this.name.equalsIgnoreCase(r4) == false) goto L6;
        return true;
    L6:
        if (this.name.endsWith(CARRIAGE_RETURN) == false) goto L10;
        String r3 = this.name;
        if (r3.substring(0, r3.length() - 1).equalsIgnoreCase(r4) == false) goto L10;
        return true;
    L10:
        return false;
    }
}
