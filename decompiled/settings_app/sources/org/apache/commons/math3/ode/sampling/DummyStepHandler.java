package org.apache.commons.math3.ode.sampling;

/* JADX INFO: loaded from: classes6.dex */
public class DummyStepHandler implements StepHandler {

    /* JADX INFO: renamed from: org.apache.commons.math3.ode.sampling.DummyStepHandler$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class LazyHolder {
        private static final DummyStepHandler INSTANCE = null;

        private LazyHolder() {
        }

        static /* synthetic */ DummyStepHandler access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new DummyStepHandler(null);
        }
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void handleStep(StepInterpolator r1, boolean r2) {
    }

    @Override // org.apache.commons.math3.ode.sampling.StepHandler
    public void init(double r1, double[] r3, double r4) {
    }

    /* synthetic */ DummyStepHandler(AnonymousClass1 r1) {
        this();
    }

    private DummyStepHandler() {
    }

    public static DummyStepHandler getInstance() {
        return LazyHolder.access$000();
    }

    private Object readResolve() {
        return LazyHolder.access$000();
    }
}
