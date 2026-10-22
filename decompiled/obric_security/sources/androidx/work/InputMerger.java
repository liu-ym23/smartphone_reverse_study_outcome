package androidx.work;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class InputMerger {
    private static final String TAG = null;

    public abstract Data merge(List<Data> inputs);

    public InputMerger() {
    }

    static {
        TAG = Logger.tagWithPrefix("InputMerger");
    }

    public static InputMerger fromClassName(String className) {
        return (InputMerger) Class.forName(className).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L4:
        e = move-exception;
        Logger.get().error(TAG, "Trouble instantiating + " + className, e);
        return null;
    }
}
