package org.apache.commons.math3.util;

import java.util.EventObject;

/* JADX INFO: loaded from: classes6.dex */
public class IterationEvent extends EventObject {
    private static final long serialVersionUID = 20120128;
    private final int iterations;

    public IterationEvent(Object r1, int r2) {
        super(r1);
        this.iterations = r2;
    }

    public int getIterations() {
        return this.iterations;
    }
}
