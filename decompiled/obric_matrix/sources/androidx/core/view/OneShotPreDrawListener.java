package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
    private final Runnable mRunnable;
    private final View mView;
    private ViewTreeObserver mViewTreeObserver;

    private OneShotPreDrawListener(View r1, Runnable r2) {
        this.mView = r1;
        this.mViewTreeObserver = r1.getViewTreeObserver();
        this.mRunnable = r2;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View r1, @NonNull Runnable r2) {
        Objects.requireNonNull(r1, "view == null");
        Objects.requireNonNull(r2, "runnable == null");
        OneShotPreDrawListener r0 = new OneShotPreDrawListener(r1, r2);
        r1.getViewTreeObserver().addOnPreDrawListener(r0);
        r1.addOnAttachStateChangeListener(r0);
        return r0;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NonNull View r1) {
        this.mViewTreeObserver = r1.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NonNull View r1) {
        removeListener();
    }

    public void removeListener() {
        if (this.mViewTreeObserver.isAlive() == false) goto L5;
        ViewTreeObserver r0 = this.mViewTreeObserver;
    L6:
        r0.removeOnPreDrawListener(this);
        this.mView.removeOnAttachStateChangeListener(this);
        return;
    L5:
        r0 = this.mView.getViewTreeObserver();
        goto L6
    }
}
