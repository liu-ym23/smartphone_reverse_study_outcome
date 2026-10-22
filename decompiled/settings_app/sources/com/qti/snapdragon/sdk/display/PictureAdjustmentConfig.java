package com.qti.snapdragon.sdk.display;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes5.dex */
public class PictureAdjustmentConfig {
    private int contrast;
    private int hue;
    private int intensity;
    protected boolean isDesaturation;
    protected boolean isGlobalPADisabled;
    private EnumSet<PICTURE_ADJUSTMENT_PARAMS> paValues;
    private int sat_threshold;
    private int saturation;

    public static final enum PICTURE_ADJUSTMENT_PARAMS extends Enum<PICTURE_ADJUSTMENT_PARAMS> {
        private static final /* synthetic */ PICTURE_ADJUSTMENT_PARAMS[] $VALUES = null;
        public static final PICTURE_ADJUSTMENT_PARAMS CONTRAST = null;
        public static final PICTURE_ADJUSTMENT_PARAMS HUE = null;
        public static final PICTURE_ADJUSTMENT_PARAMS INTENSITY = null;
        public static final PICTURE_ADJUSTMENT_PARAMS SATURATION = null;
        public static final PICTURE_ADJUSTMENT_PARAMS SATURATION_THRESHOLD = null;
        private int value;

        public static PICTURE_ADJUSTMENT_PARAMS valueOf(String r1) {
            return (PICTURE_ADJUSTMENT_PARAMS) Enum.valueOf(PICTURE_ADJUSTMENT_PARAMS.class, r1);
        }

        public static PICTURE_ADJUSTMENT_PARAMS[] values() {
            return (PICTURE_ADJUSTMENT_PARAMS[]) $VALUES.clone();
        }

        static {
            PICTURE_ADJUSTMENT_PARAMS r0 = new PICTURE_ADJUSTMENT_PARAMS("HUE", 0, 0);
            HUE = r0;
            PICTURE_ADJUSTMENT_PARAMS r1 = new PICTURE_ADJUSTMENT_PARAMS("SATURATION", 1, 1);
            SATURATION = r1;
            PICTURE_ADJUSTMENT_PARAMS r3 = new PICTURE_ADJUSTMENT_PARAMS("INTENSITY", 2, 2);
            INTENSITY = r3;
            PICTURE_ADJUSTMENT_PARAMS r5 = new PICTURE_ADJUSTMENT_PARAMS("CONTRAST", 3, 3);
            CONTRAST = r5;
            PICTURE_ADJUSTMENT_PARAMS r7 = new PICTURE_ADJUSTMENT_PARAMS("SATURATION_THRESHOLD", 4, 4);
            SATURATION_THRESHOLD = r7;
            $VALUES = new PICTURE_ADJUSTMENT_PARAMS[]{r0, r1, r3, r5, r7};
        }

        private PICTURE_ADJUSTMENT_PARAMS(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public PictureAdjustmentConfig(EnumSet<PICTURE_ADJUSTMENT_PARAMS> r2, int r3, int r4, int r5, int r6, int r7) {
        this.isDesaturation = false;
        this.isGlobalPADisabled = false;
        this.paValues = r2;
        this.hue = r3;
        this.saturation = r4;
        this.intensity = r5;
        this.contrast = r6;
        this.sat_threshold = r7;
    }

    public EnumSet<PICTURE_ADJUSTMENT_PARAMS> getParamFlags() {
        return this.paValues;
    }

    public int getHue() {
        return this.hue;
    }

    public int getSaturation() {
        return this.saturation;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public int getContrast() {
        return this.contrast;
    }

    public int getSaturationThreshold() {
        return this.sat_threshold;
    }

    public boolean isDesaturationEnabled() {
        return this.isDesaturation;
    }

    public boolean isGlobalPictureAdjustmentDisabled() {
        return this.isGlobalPADisabled;
    }
}
