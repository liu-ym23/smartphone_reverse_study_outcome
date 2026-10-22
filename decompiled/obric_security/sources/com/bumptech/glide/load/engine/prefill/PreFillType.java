package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class PreFillType {
    static final Bitmap.Config DEFAULT_CONFIG = null;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int r1) {
            this(r1, r1);
        }

        public Builder(int r2, int r3) {
            this.weight = 1;
            if (r2 <= 0) goto L10;
            if (r3 <= 0) goto L8;
            this.width = r2;
            this.height = r3;
            return;
        L8:
            throw new IllegalArgumentException("Height must be > 0");
        L10:
            throw new IllegalArgumentException("Width must be > 0");
        }

        public Builder setConfig(Bitmap.Config r1) {
            this.config = r1;
            return this;
        }

        Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setWeight(int r1) {
            if (r1 <= 0) goto L6;
            this.weight = r1;
            return this;
        L6:
            throw new IllegalArgumentException("Weight must be > 0");
        }

        PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }
    }

    static {
        DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    }

    PreFillType(int r2, int r3, Bitmap.Config r4, int r5) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(r4, "Config must not be null");
        this.width = r2;
        this.height = r3;
        this.weight = r5;
    }

    int getWidth() {
        return this.width;
    }

    int getHeight() {
        return this.height;
    }

    Bitmap.Config getConfig() {
        return this.config;
    }

    int getWeight() {
        return this.weight;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof PreFillType) == false) goto L14;
        PreFillType r5 = (PreFillType) r4;
        if (this.height == r5.height) goto L7;
        return false;
    L7:
        if (this.width == r5.width) goto L9;
        return false;
    L9:
        if (this.weight == r5.weight) goto L11;
        return false;
    L11:
        if (this.config != r5.config) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + '}';
    }
}
