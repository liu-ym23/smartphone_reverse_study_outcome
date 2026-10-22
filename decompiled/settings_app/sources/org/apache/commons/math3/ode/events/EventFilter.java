package org.apache.commons.math3.ode.events;

import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class EventFilter implements EventHandler {
    private static final int HISTORY_SIZE = 100;
    private double extremeT;
    private final FilterType filter;
    private boolean forward;
    private final EventHandler rawHandler;
    private final Transformer[] transformers;
    private final double[] updates;

    public EventFilter(EventHandler r1, FilterType r2) {
        this.rawHandler = r1;
        this.filter = r2;
        this.transformers = new Transformer[100];
        this.updates = new double[100];
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public void init(double r7, double[] r9, double r10) {
        this.rawHandler.init(r7, r9, r10);
        if (r10 < r7) goto L5;
        boolean r8 = true;
    L6:
        this.forward = r8;
        if (r8 == false) goto L9;
        double r11 = Double.NEGATIVE_INFINITY;
    L10:
        this.extremeT = r11;
        Arrays.fill(this.transformers, Transformer.UNINITIALIZED);
        Arrays.fill(this.updates, this.extremeT);
        return;
    L9:
        r11 = Double.POSITIVE_INFINITY;
        goto L10
    L5:
        r8 = false;
        goto L6
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public double g(double r9, double[] r11) {
        double r0 = this.rawHandler.g(r9, r11);
        boolean r12 = this.forward;
        int r2 = 0;
        if (r12 == false) goto L20;
        Transformer[] r4 = this.transformers;
        int r5 = r4.length - 1;
        if (this.extremeT >= r9) goto L11;
        Transformer r6 = r4[r5];
        Transformer r13 = this.filter.selectTransformer(r6, r0, r12);
        if (r13 == r6) goto L9;
        double[] r7 = this.updates;
        System.arraycopy(r7, 1, r7, 0, r5);
        Transformer[] r8 = this.transformers;
        System.arraycopy(r8, 1, r8, 0, r5);
        this.updates[r5] = this.extremeT;
        this.transformers[r5] = r13;
    L9:
        this.extremeT = r9;
        return r13.transformed(r0);
    L11:
        if (r5 <= 0) goto L18;
        if (this.updates[r5] <= r9) goto L15;
        r5 = r5 - 1;
        goto L11
    L15:
        return this.transformers[r5].transformed(r0);
    L18:
        return this.transformers[0].transformed(r0);
    L20:
        if (r9 >= this.extremeT) goto L26;
        Transformer r10 = this.transformers[0];
        Transformer r14 = this.filter.selectTransformer(r10, r0, r12);
        if (r14 == r10) goto L24;
        double[] r15 = this.updates;
        System.arraycopy(r15, 0, r15, 1, r15.length - 1);
        Transformer[] r16 = this.transformers;
        System.arraycopy(r16, 0, r16, 1, r16.length - 1);
        this.updates[0] = this.extremeT;
        this.transformers[0] = r14;
    L24:
        this.extremeT = r9;
        return r14.transformed(r0);
    L26:
        double[] r17 = this.updates;
        if (r2 >= (r17.length - 1)) goto L34;
        if (r9 <= r17[r2]) goto L31;
        r2 = r2 + 1;
        goto L26
    L31:
        return this.transformers[r2].transformed(r0);
    L34:
        return this.transformers[r17.length - 1].transformed(r0);
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public EventHandler.Action eventOccurred(double r1, double[] r3, boolean r4) {
        return this.rawHandler.eventOccurred(r1, r3, this.filter.getTriggeredIncreasing());
    }

    @Override // org.apache.commons.math3.ode.events.EventHandler
    public void resetState(double r1, double[] r3) {
        this.rawHandler.resetState(r1, r3);
    }
}
