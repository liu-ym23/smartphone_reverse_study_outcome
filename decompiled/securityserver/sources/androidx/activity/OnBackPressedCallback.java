package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables;
    private boolean mEnabled;

    public OnBackPressedCallback(boolean r2) {
        this.mCancellables = new CopyOnWriteArrayList();
        this.mEnabled = r2;
    }

    public void addCancellable(@NonNull Cancellable r1) {
        this.mCancellables.add(r1);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> r1 = this.mCancellables.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().cancel();
        goto L4
    }

    public void removeCancellable(@NonNull Cancellable r1) {
        this.mCancellables.remove(r1);
    }

    @MainThread
    public final void setEnabled(boolean r1) {
        this.mEnabled = r1;
    }
}
