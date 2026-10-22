package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* JADX INFO: loaded from: classes3.dex */
public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public Builder(int r1) {
            this.durationMillis = r1;
        }

        public Builder setCrossFadeEnabled(boolean r1) {
            this.isCrossFadeEnabled = r1;
            return this;
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }
    }

    protected DrawableCrossFadeFactory(int r1, boolean r2) {
        this.duration = r1;
        this.isCrossFadeEnabled = r2;
    }

    @Override // com.bumptech.glide.request.transition.TransitionFactory
    public Transition<Drawable> build(DataSource r1, boolean r2) {
        if (r1 != DataSource.MEMORY_CACHE) goto L6;
        return NoTransition.get();
    L6:
        return getResourceTransition();
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition != null) goto L6;
        this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
    L6:
        return this.resourceTransition;
    }
}
