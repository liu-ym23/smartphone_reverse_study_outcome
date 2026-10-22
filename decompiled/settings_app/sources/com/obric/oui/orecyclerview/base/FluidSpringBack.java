package com.obric.oui.orecyclerview.base;

import android.icu.text.PluralRules;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FluidSpringBack.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidSpringBack;", "", "()V", "c1", "", "c2", "lambda", "valueThreshold", "velocityThreshold", "absorb", "", RealFpsTracer.SCROLL_VELOCITY, "initialValue", "value", "Lcom/obric/oui/orecyclerview/base/FluidSpringBack$SpringBackValue;", "time", "velocityAt", "SpringBackValue", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FluidSpringBack {
    private float c1;
    private float c2;
    private float lambda;
    private final float valueThreshold;
    private final float velocityThreshold;

    /* JADX INFO: compiled from: FluidSpringBack.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/orecyclerview/base/FluidSpringBack$SpringBackValue;", "", "value", "", "isFinished", "", "(FZ)V", "()Z", "getValue", "()F", "component1", "component2", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SpringBackValue {
        private final boolean isFinished;
        private final float value;

        public static /* synthetic */ SpringBackValue copy$default(SpringBackValue r0, float r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.value;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.isFinished;
        L9:
            return r0.copy(r1, r2);
        }

        public final float component1() {
            return this.value;
        }

        public final boolean component2() {
            return this.isFinished;
        }

        public final SpringBackValue copy(float r1, boolean r2) {
            return new SpringBackValue(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SpringBackValue) == true) goto L8;
            return false;
        L8:
            SpringBackValue r6 = (SpringBackValue) r5;
            if (Intrinsics.areEqual(Float.valueOf(this.value), Float.valueOf(r6.value)) == true) goto L12;
            return false;
        L12:
            if (this.isFinished == r6.isFinished) goto L14;
            return false;
        L14:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        public int hashCode() {
            int r0 = Float.hashCode(this.value) * 31;
            boolean r1 = this.isFinished;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return r0 + r2;
        }

        public String toString() {
            return "SpringBackValue(value=" + this.value + ", isFinished=" + this.isFinished + ')';
        }

        public SpringBackValue(float r1, boolean r2) {
            this.value = r1;
            this.isFinished = r2;
        }

        public final float getValue() {
            return this.value;
        }

        public final boolean isFinished() {
            return this.isFinished;
        }
    }

    public FluidSpringBack() {
        this.valueThreshold = 0.1f;
        this.velocityThreshold = 0.01f;
    }

    public final void absorb(float r3, float r4) {
        this.lambda = 10.927279f;
        this.c1 = r4;
        this.c2 = (r3 * 1000.0f) + (10.927279f * r4);
    }

    public final SpringBackValue value(float r5) {
        float r6 = r5 / 1000.0f;
        float r1 = (this.c1 + (this.c2 * r6)) * ((float) Math.exp((-this.lambda) * r6));
        float r7 = velocityAt(r6);
        if (Math.abs(r1) >= this.valueThreshold) goto L8;
        if ((Math.abs(r7) / 1000.0f) >= this.velocityThreshold) goto L8;
        return new SpringBackValue(0.0f, true);
    L8:
        return new SpringBackValue(r1, false);
    }

    private final float velocityAt(float r4) {
        float r0 = this.c2;
        float r1 = this.lambda;
        return (r0 - ((this.c1 + (r0 * r4)) * r1)) * ((float) Math.exp((-r1) * r4));
    }
}
