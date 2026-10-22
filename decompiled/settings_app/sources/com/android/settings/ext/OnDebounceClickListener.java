package com.android.settings.ext;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/settings/ext/OnDebounceClickListener;", "Landroid/view/View$OnClickListener;", "throttleTime", "", "listener", "(JLandroid/view/View$OnClickListener;)V", "lastClickTime", "onClick", "", "v", "Landroid/view/View;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OnDebounceClickListener implements View.OnClickListener {
    private long lastClickTime;
    private final View.OnClickListener listener;
    private final long throttleTime;

    public OnDebounceClickListener(long r2, View.OnClickListener r4) {
        Intrinsics.checkNotNullParameter(r4, "listener");
        this.throttleTime = r2;
        this.listener = r4;
    }

    public /* synthetic */ OnDebounceClickListener(long r1, View.OnClickListener r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = 500;
    L5:
        this(r1, r3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r7) {
        long r0 = System.currentTimeMillis();
        long r2 = r0 - this.lastClickTime;
        if (r2 <= this.throttleTime) goto L5;
    L6:
        this.lastClickTime = r0;
        this.listener.onClick(r7);
        return;
    L5:
        if (r2 < 0) goto L6;
    }
}
