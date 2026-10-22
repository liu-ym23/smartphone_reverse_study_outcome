package androidx.slice.builders.impl;

import androidx.slice.Clock;
import androidx.slice.Slice;
import androidx.slice.SliceSpec;
import androidx.slice.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class TemplateBuilderImpl {
    private Clock mClock;
    private Slice.Builder mSliceBuilder;
    private final SliceSpec mSpec;

    public abstract void apply(Slice.Builder r1);

    protected TemplateBuilderImpl(Slice.Builder r2, SliceSpec r3) {
        this(r2, r3, new SystemClock());
    }

    protected TemplateBuilderImpl(Slice.Builder r1, SliceSpec r2, Clock r3) {
        this.mSliceBuilder = r1;
        this.mSpec = r2;
        this.mClock = r3;
    }

    protected void setBuilder(Slice.Builder r1) {
        this.mSliceBuilder = r1;
    }

    public Slice build() {
        this.mSliceBuilder.setSpec(this.mSpec);
        apply(this.mSliceBuilder);
        return this.mSliceBuilder.build();
    }

    public Slice.Builder getBuilder() {
        return this.mSliceBuilder;
    }

    public Slice.Builder createChildBuilder() {
        return new Slice.Builder(this.mSliceBuilder);
    }

    public Clock getClock() {
        return this.mClock;
    }
}
