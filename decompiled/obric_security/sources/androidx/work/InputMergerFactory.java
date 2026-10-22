package androidx.work;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMergerFactory {
    public abstract InputMerger createInputMerger(String className);

    public InputMergerFactory() {
    }

    public final InputMerger createInputMergerWithDefaultFallback(String className) {
        InputMerger r0 = createInputMerger(className);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return InputMerger.fromClassName(className);
    }

    public static InputMergerFactory getDefaultInputMergerFactory() {
        return new AnonymousClass1();
    }
}
