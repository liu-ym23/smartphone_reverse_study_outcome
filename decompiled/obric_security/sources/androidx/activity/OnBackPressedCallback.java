package androidx.activity;

import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables;
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public abstract void handleOnBackPressed();

    public OnBackPressedCallback(boolean r2) {
        this.mCancellables = new CopyOnWriteArrayList();
        this.mEnabled = r2;
    }

    public final void setEnabled(boolean r1) {
        this.mEnabled = r1;
        Consumer<Boolean> r0 = this.mEnabledConsumer;
        if (r0 == null) goto L6;
        r0.accept(Boolean.valueOf(r1));
        return;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void remove() {
        Iterator<Cancellable> r1 = this.mCancellables.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().cancel();
        goto L4
    }

    void addCancellable(Cancellable r1) {
        this.mCancellables.add(r1);
    }

    void removeCancellable(Cancellable r1) {
        this.mCancellables.remove(r1);
    }

    void setIsEnabledConsumer(Consumer<Boolean> r1) {
        this.mEnabledConsumer = r1;
    }
}
