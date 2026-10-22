package com.android.settings.wifi;

import android.content.Context;
import android.util.AttributeSet;
import androidx.core.widget.NestedScrollView;
import com.obric.oui.material.MaterialConfigFormatNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObservableScrollView.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0014J\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/android/settings/wifi/ObservableScrollView;", "Landroidx/core/widget/NestedScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scrollListener", "Lcom/android/settings/wifi/ObservableScrollView$OnScrollStateChangeListener;", "onScrollChanged", "", "l", "", "t", "oldl", "oldt", "setOnScrollStateChangeListener", "listener", "OnScrollStateChangeListener", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ObservableScrollView extends NestedScrollView {
    private OnScrollStateChangeListener scrollListener;

    /* JADX INFO: compiled from: ObservableScrollView.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/android/settings/wifi/ObservableScrollView$OnScrollStateChangeListener;", "", "onScrollChanged", "", "scrollView", "Lcom/android/settings/wifi/ObservableScrollView;", MaterialConfigFormatNames.X, "", "y", "oldx", "oldy", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnScrollStateChangeListener {
        void onScrollChanged(ObservableScrollView r1, int r2, int r3, int r4, int r5);
    }

    public ObservableScrollView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
    }

    public final void setOnScrollStateChangeListener(OnScrollStateChangeListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.scrollListener = r2;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    protected void onScrollChanged(int r7, int r8, int r9, int r10) {
        super.onScrollChanged(r7, r8, r9, r10);
        OnScrollStateChangeListener r0 = this.scrollListener;
        if (r0 == null) goto L6;
        r0.onScrollChanged(this, r7, r8, r9, r10);
        return;
    }
}
