package com.obric.oui.constraintlayout.core.dsl;

/* JADX INFO: loaded from: classes3.dex */
public class KeyCycle extends KeyAttribute {
    private static final String TAG = "KeyCycle";
    private float mWaveOffset;
    private float mWavePeriod;
    private float mWavePhase;
    private Wave mWaveShape;

    public static final enum Wave extends Enum<Wave> {
        private static final /* synthetic */ Wave[] $VALUES = null;
        public static final Wave COS = null;
        public static final Wave REVERSE_SAW = null;
        public static final Wave SAW = null;
        public static final Wave SIN = null;
        public static final Wave SQUARE = null;
        public static final Wave TRIANGLE = null;

        private Wave(String r1, int r2) {
            super(r1, r2);
        }

        public static Wave valueOf(String r1) {
            return (Wave) Enum.valueOf(Wave.class, r1);
        }

        public static Wave[] values() {
            return (Wave[]) $VALUES.clone();
        }

        static {
            Wave r0 = new Wave("SIN", 0);
            SIN = r0;
            Wave r1 = new Wave("SQUARE", 1);
            SQUARE = r1;
            Wave r3 = new Wave("TRIANGLE", 2);
            TRIANGLE = r3;
            Wave r5 = new Wave("SAW", 3);
            SAW = r5;
            Wave r7 = new Wave("REVERSE_SAW", 4);
            REVERSE_SAW = r7;
            Wave r9 = new Wave("COS", 5);
            COS = r9;
            $VALUES = new Wave[]{r0, r1, r3, r5, r7, r9};
        }
    }

    KeyCycle(int r1, String r2) {
        super(r1, r2);
        this.mWaveShape = null;
        this.mWavePeriod = Float.NaN;
        this.mWaveOffset = Float.NaN;
        this.mWavePhase = Float.NaN;
        this.TYPE = "KeyCycle";
    }

    public Wave getShape() {
        return this.mWaveShape;
    }

    public void setShape(Wave r1) {
        this.mWaveShape = r1;
    }

    public float getPeriod() {
        return this.mWavePeriod;
    }

    public void setPeriod(float r1) {
        this.mWavePeriod = r1;
    }

    public float getOffset() {
        return this.mWaveOffset;
    }

    public void setOffset(float r1) {
        this.mWaveOffset = r1;
    }

    public float getPhase() {
        return this.mWavePhase;
    }

    public void setPhase(float r1) {
        this.mWavePhase = r1;
    }

    @Override // com.obric.oui.constraintlayout.core.dsl.KeyAttribute
    protected void attributesToString(StringBuilder r3) {
        super.attributesToString(r3);
        if (this.mWaveShape == null) goto L5;
        r3.append("shape:'").append(this.mWaveShape).append("',\n");
    L5:
        append(r3, "period", this.mWavePeriod);
        append(r3, "offset", this.mWaveOffset);
        append(r3, "phase", this.mWavePhase);
    }
}
