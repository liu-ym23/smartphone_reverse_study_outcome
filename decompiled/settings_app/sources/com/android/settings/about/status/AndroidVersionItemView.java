package com.android.settings.about.status;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settingslib.applications.RecentAppOpsAccess;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AndroidVersionItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settings/about/status/AndroidVersionItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLastTapTime", "", "mTapCount", "onDevClick", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AndroidVersionItemView extends DeviceStatusItemView {
    private long mLastTapTime;
    private int mTapCount;

    public static /* synthetic */ void $r8$lambda$6wvk4JPdEJt7JCEFvXe4NqfBZ5Y(AndroidVersionItemView r0, View r1) {
        _init_$lambda$0(r0, r1);
    }

    public AndroidVersionItemView(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public AndroidVersionItemView(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public /* synthetic */ AndroidVersionItemView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }

    public AndroidVersionItemView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 0, 16, null);
        setOnClickListener(new AndroidVersionItemView$$ExternalSyntheticLambda0(this));
    }

    private static final void _init_$lambda$0(AndroidVersionItemView r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onDevClick();
    }

    private final void onDevClick() {
        Context r0 = getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "getContext(...)");
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(r0, "no_fun") == false) goto L5;
        return;
    L5:
        long r1 = SystemClock.uptimeMillis();
        if ((r1 - this.mLastTapTime) >= 500) goto L8;
        this.mTapCount++;
    L9:
        this.mLastTapTime = r1;
        if (this.mTapCount < 3) goto L24;
        this.mTapCount = 0;
        List r2 = CollectionsKt.listOf(new Intent("android.intent.action.MAIN").setClassName(RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME, "com.android.internal.app.PlatLogoActivity"));
        PackageManager r3 = getContext().getPackageManager();
        Iterator r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L25;
        Intent r5 = (Intent) r4.next();
        if (r5.resolveActivity(r3) == null) goto L13;
        if ((getContext() instanceof Activity) == true) goto L19;
        r5.addFlags(268435456);
    L19:
        getContext().startActivity(r5);
        return;
    L25:
        return;
    L24:
        return;
    L8:
        this.mTapCount = 1;
        goto L9
    }
}
