package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Option;

/* JADX INFO: loaded from: classes.dex */
public abstract class DownsampleStrategy {
    public static final DownsampleStrategy AT_LEAST = null;
    public static final DownsampleStrategy AT_MOST = null;
    public static final DownsampleStrategy CENTER_INSIDE = null;
    public static final DownsampleStrategy CENTER_OUTSIDE = null;
    public static final DownsampleStrategy DEFAULT = null;
    public static final DownsampleStrategy FIT_CENTER = null;
    static final boolean IS_BITMAP_FACTORY_SCALING_SUPPORTED = false;
    public static final DownsampleStrategy NONE = null;
    public static final Option<DownsampleStrategy> OPTION = null;

    private static class AtLeast extends DownsampleStrategy {
        AtLeast() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            int r0 = Math.min(r2 / r4, r1 / r3);
            if (r0 != 0) goto L6;
            return 1.0f;
        L6:
            return 1.0f / Integer.highestOneBit(r0);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class AtMost extends DownsampleStrategy {
        AtMost() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            int r0 = (int) Math.ceil(Math.max(r2 / r4, r1 / r3));
            int r5 = 1;
            int r6 = Math.max(1, Integer.highestOneBit(r0));
            if (r6 < r0) goto L7;
            r5 = 0;
        L7:
            return 1.0f / (r6 << r5);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class CenterInside extends DownsampleStrategy {
        CenterInside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            return Math.min(1.0f, FIT_CENTER.getScaleFactor(r1, r2, r3, r4));
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r2, int r3, int r4, int r5) {
            if (getScaleFactor(r2, r3, r4, r5) != 1.0f) goto L6;
            return SampleSizeRounding.QUALITY;
        L6:
            return FIT_CENTER.getSampleSizeRounding(r2, r3, r4, r5);
        }
    }

    private static class CenterOutside extends DownsampleStrategy {
        CenterOutside() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            return Math.max(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    private static class FitCenter extends DownsampleStrategy {
        FitCenter() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            if (IS_BITMAP_FACTORY_SCALING_SUPPORTED == true) goto L5;
            int r0 = Math.max(r2 / r4, r1 / r3);
            if (r0 != 0) goto L10;
            return 1.0f;
        L10:
            return 1.0f / Integer.highestOneBit(r0);
        L5:
            return Math.min(r3 / r1, r4 / r2);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4) {
            if (IS_BITMAP_FACTORY_SCALING_SUPPORTED == false) goto L7;
            return SampleSizeRounding.QUALITY;
        L7:
            return SampleSizeRounding.MEMORY;
        }
    }

    private static class None extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float getScaleFactor(int r1, int r2, int r3, int r4) {
            return 1.0f;
        }

        None() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4) {
            return SampleSizeRounding.QUALITY;
        }
    }

    public static final enum SampleSizeRounding extends Enum<SampleSizeRounding> {
        private static final /* synthetic */ SampleSizeRounding[] $VALUES = null;
        public static final SampleSizeRounding MEMORY = null;
        public static final SampleSizeRounding QUALITY = null;

        private static /* synthetic */ SampleSizeRounding[] $values() {
            return new SampleSizeRounding[]{MEMORY, QUALITY};
        }

        private SampleSizeRounding(String r1, int r2) {
            super(r1, r2);
        }

        public static SampleSizeRounding valueOf(String r1) {
            return (SampleSizeRounding) Enum.valueOf(SampleSizeRounding.class, r1);
        }

        public static SampleSizeRounding[] values() {
            return (SampleSizeRounding[]) $VALUES.clone();
        }

        static {
            MEMORY = new SampleSizeRounding("MEMORY", 0);
            QUALITY = new SampleSizeRounding("QUALITY", 1);
            $VALUES = $values();
        }
    }

    public abstract SampleSizeRounding getSampleSizeRounding(int r1, int r2, int r3, int r4);

    public abstract float getScaleFactor(int r1, int r2, int r3, int r4);

    public DownsampleStrategy() {
    }

    static {
        AT_LEAST = new AtLeast();
        AT_MOST = new AtMost();
        FIT_CENTER = new FitCenter();
        CENTER_INSIDE = new CenterInside();
        CenterOutside r0 = new CenterOutside();
        CENTER_OUTSIDE = r0;
        NONE = new None();
        DEFAULT = r0;
        OPTION = Option.memory("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", r0);
        IS_BITMAP_FACTORY_SCALING_SUPPORTED = true;
    }
}
