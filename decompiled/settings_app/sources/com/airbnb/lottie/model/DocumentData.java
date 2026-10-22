package com.airbnb.lottie.model;

/* JADX INFO: loaded from: classes.dex */
public class DocumentData {
    public final float baselineShift;
    public final int color;
    public final String fontName;
    public final Justification justification;
    public final float lineHeight;
    public final float size;
    public final int strokeColor;
    public final boolean strokeOverFill;
    public final float strokeWidth;
    public final String text;
    public final int tracking;

    public static final enum Justification extends Enum<Justification> {
        private static final /* synthetic */ Justification[] $VALUES = null;
        public static final Justification CENTER = null;
        public static final Justification LEFT_ALIGN = null;
        public static final Justification RIGHT_ALIGN = null;

        private Justification(String r1, int r2) {
            super(r1, r2);
        }

        public static Justification valueOf(String r1) {
            return (Justification) Enum.valueOf(Justification.class, r1);
        }

        public static Justification[] values() {
            return (Justification[]) $VALUES.clone();
        }

        static {
            Justification r0 = new Justification("LEFT_ALIGN", 0);
            LEFT_ALIGN = r0;
            Justification r1 = new Justification("RIGHT_ALIGN", 1);
            RIGHT_ALIGN = r1;
            Justification r3 = new Justification("CENTER", 2);
            CENTER = r3;
            $VALUES = new Justification[]{r0, r1, r3};
        }
    }

    public DocumentData(String r1, String r2, float r3, Justification r4, int r5, float r6, float r7, int r8, int r9, float r10, boolean r11) {
        this.text = r1;
        this.fontName = r2;
        this.size = r3;
        this.justification = r4;
        this.tracking = r5;
        this.lineHeight = r6;
        this.baselineShift = r7;
        this.color = r8;
        this.strokeColor = r9;
        this.strokeWidth = r10;
        this.strokeOverFill = r11;
    }

    public int hashCode() {
        int r0 = (((((int) ((((this.text.hashCode() * 31) + this.fontName.hashCode()) * 31) + this.size)) * 31) + this.justification.ordinal()) * 31) + this.tracking;
        long r1 = Float.floatToRawIntBits(this.lineHeight);
        return (((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.color;
    }
}
