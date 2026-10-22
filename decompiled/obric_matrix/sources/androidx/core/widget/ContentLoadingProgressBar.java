package androidx.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public class ContentLoadingProgressBar extends ProgressBar {
    private static final int MIN_DELAY_MS = 500;
    private static final int MIN_SHOW_TIME_MS = 500;
    private final Runnable mDelayedHide;
    private final Runnable mDelayedShow;
    boolean mDismissed;
    boolean mPostedHide;
    boolean mPostedShow;
    long mStartTime;

    public ContentLoadingProgressBar(@NonNull Context r2) {
        this(r2, null);
    }

    public ContentLoadingProgressBar(@NonNull Context r2, @Nullable AttributeSet r3) {
        super(r2, r3, 0);
        this.mStartTime = -1;
        this.mPostedHide = false;
        this.mPostedShow = false;
        this.mDismissed = false;
        this.mDelayedHide = new a(this);
        this.mDelayedShow = new c(this);
    }

    public static /* synthetic */ void a(ContentLoadingProgressBar r0) {
        r0.hideOnUiThread();
    }

    private /* synthetic */ void b() {
        this.mPostedHide = false;
        this.mStartTime = -1;
        setVisibility(8);
    }

    private /* synthetic */ void d() {
        this.mPostedShow = false;
        if (this.mDismissed == true) goto L6;
        this.mStartTime = System.currentTimeMillis();
        setVisibility(0);
        return;
    }

    public static /* synthetic */ void f(ContentLoadingProgressBar r0) {
        r0.showOnUiThread();
    }

    @UiThread
    private void hideOnUiThread() {
        this.mDismissed = true;
        removeCallbacks(this.mDelayedShow);
        this.mPostedShow = false;
        long r1 = System.currentTimeMillis();
        long r3 = this.mStartTime;
        long r2 = r1 - r3;
        if (r2 < 500) goto L5;
    L10:
        setVisibility(8);
        return;
    L5:
        if (r3 == (-1)) goto L10;
        if (this.mPostedHide == true) goto L12;
        postDelayed(this.mDelayedHide, 500 - r2);
        this.mPostedHide = true;
        return;
    }

    private void removeCallbacks() {
        removeCallbacks(this.mDelayedHide);
        removeCallbacks(this.mDelayedShow);
    }

    @UiThread
    private void showOnUiThread() {
        this.mStartTime = -1;
        this.mDismissed = false;
        removeCallbacks(this.mDelayedHide);
        this.mPostedHide = false;
        if (this.mPostedShow == true) goto L6;
        postDelayed(this.mDelayedShow, 500);
        this.mPostedShow = true;
        return;
    }

    public /* synthetic */ void c() {
        b();
    }

    public /* synthetic */ void e() {
        d();
    }

    public void hide() {
        post(new b(this));
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        removeCallbacks();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks();
    }

    public void show() {
        post(new d(this));
    }
}
