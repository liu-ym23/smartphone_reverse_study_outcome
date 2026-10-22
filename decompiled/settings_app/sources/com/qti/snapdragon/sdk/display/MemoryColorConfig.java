package com.qti.snapdragon.sdk.display;

/* JADX INFO: loaded from: classes5.dex */
public class MemoryColorConfig {
    private int hue;
    private int intensity;
    protected boolean isEnabled;
    private MEMORY_COLOR_TYPE memColorType;
    private int saturation;

    public static final enum MEMORY_COLOR_PARAMS extends Enum<MEMORY_COLOR_PARAMS> {
        private static final /* synthetic */ MEMORY_COLOR_PARAMS[] $VALUES = null;
        public static final MEMORY_COLOR_PARAMS HUE = null;
        public static final MEMORY_COLOR_PARAMS INTENSITY = null;
        public static final MEMORY_COLOR_PARAMS SATURATION = null;
        private int value;

        public static MEMORY_COLOR_PARAMS valueOf(String r1) {
            return (MEMORY_COLOR_PARAMS) Enum.valueOf(MEMORY_COLOR_PARAMS.class, r1);
        }

        public static MEMORY_COLOR_PARAMS[] values() {
            return (MEMORY_COLOR_PARAMS[]) $VALUES.clone();
        }

        static {
            MEMORY_COLOR_PARAMS r0 = new MEMORY_COLOR_PARAMS("HUE", 0, 0);
            HUE = r0;
            MEMORY_COLOR_PARAMS r1 = new MEMORY_COLOR_PARAMS("SATURATION", 1, 1);
            SATURATION = r1;
            MEMORY_COLOR_PARAMS r3 = new MEMORY_COLOR_PARAMS("INTENSITY", 2, 2);
            INTENSITY = r3;
            $VALUES = new MEMORY_COLOR_PARAMS[]{r0, r1, r3};
        }

        private MEMORY_COLOR_PARAMS(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public static final enum MEMORY_COLOR_TYPE extends Enum<MEMORY_COLOR_TYPE> {
        private static final /* synthetic */ MEMORY_COLOR_TYPE[] $VALUES = null;
        public static final MEMORY_COLOR_TYPE FOLIAGE = null;
        public static final MEMORY_COLOR_TYPE SKIN = null;
        public static final MEMORY_COLOR_TYPE SKY = null;
        private int value;

        public static MEMORY_COLOR_TYPE valueOf(String r1) {
            return (MEMORY_COLOR_TYPE) Enum.valueOf(MEMORY_COLOR_TYPE.class, r1);
        }

        public static MEMORY_COLOR_TYPE[] values() {
            return (MEMORY_COLOR_TYPE[]) $VALUES.clone();
        }

        static {
            MEMORY_COLOR_TYPE r0 = new MEMORY_COLOR_TYPE("SKIN", 0, 0);
            SKIN = r0;
            MEMORY_COLOR_TYPE r1 = new MEMORY_COLOR_TYPE("SKY", 1, 1);
            SKY = r1;
            MEMORY_COLOR_TYPE r3 = new MEMORY_COLOR_TYPE("FOLIAGE", 2, 2);
            FOLIAGE = r3;
            $VALUES = new MEMORY_COLOR_TYPE[]{r0, r1, r3};
        }

        private MEMORY_COLOR_TYPE(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        protected int getValue() {
            return this.value;
        }
    }

    public MemoryColorConfig(MEMORY_COLOR_TYPE r2, int r3, int r4, int r5) {
        this.isEnabled = true;
        this.memColorType = r2;
        this.hue = r3;
        this.saturation = r4;
        this.intensity = r5;
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

    public MEMORY_COLOR_TYPE getMemoryColorType() {
        return this.memColorType;
    }

    public boolean isMemoryColorEnabled() {
        return this.isEnabled;
    }
}
