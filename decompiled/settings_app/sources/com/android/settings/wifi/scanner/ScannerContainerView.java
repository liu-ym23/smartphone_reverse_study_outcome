package com.android.settings.wifi.scanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScannerContainerView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0016R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/android/settings/wifi/scanner/ScannerContainerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "handleInterceptEvent", "Lkotlin/Function0;", "", "getHandleInterceptEvent", "()Lkotlin/jvm/functions/Function0;", "setHandleInterceptEvent", "(Lkotlin/jvm/functions/Function0;)V", "onInterceptHoverEvent", "", "event", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "ev", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScannerContainerView extends FrameLayout {
    private Function0<Unit> handleInterceptEvent;

    public ScannerContainerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.handleInterceptEvent = ScannerContainerView$handleInterceptEvent$1.INSTANCE;
    }

    public final Function0<Unit> getHandleInterceptEvent() {
        return this.handleInterceptEvent;
    }

    public final void setHandleInterceptEvent(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.handleInterceptEvent = r2;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r2) {
        this.handleInterceptEvent.invoke();
        return super.onInterceptTouchEvent(r2);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptHoverEvent(MotionEvent r2) {
        this.handleInterceptEvent.invoke();
        return super.onInterceptHoverEvent(r2);
    }
}
