package com.android.settings.about.status;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.utils.ResourceUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.android.settingslib.utils.StringUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpTimeStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/android/settings/about/status/UpTimeStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "WHAT_UPDATE_TIME", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "convert", "", "t", "", "pad", "i", "updateTime", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UpTimeStatusItemView extends DeviceStatusItemView {
    private final int WHAT_UPDATE_TIME;
    private final Lifecycle lifecycle;
    private final Handler mHandler;

    public UpTimeStatusItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public UpTimeStatusItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public UpTimeStatusItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ UpTimeStatusItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r4, r5);
    }

    public static final /* synthetic */ int access$getWHAT_UPDATE_TIME$p(UpTimeStatusItemView r0) {
        return r0.WHAT_UPDATE_TIME;
    }

    public static final /* synthetic */ void access$updateTime(UpTimeStatusItemView r0) {
        r0.updateTime();
    }

    public UpTimeStatusItemView(Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, 0, 16, null);
        this.lifecycle = r13;
        this.WHAT_UPDATE_TIME = 1;
        final Looper r14 = Looper.getMainLooper();
        Handler r15 = new UpTimeStatusItemView$mHandler$1(this, r14);
        this.mHandler = r15;
        r15.sendEmptyMessage(1);
        if (r13 == null) goto L5;
        r13.addObserver(new AnonymousClass1(this));
    L5:
        long r16 = SystemClock.elapsedRealtime() / ((long) 1000);
        String r17 = ResourceUtils.getString(R.string.status_up_time);
        if (r16 > 0) goto L9;
        r16 = 1;
    L9:
        initData(r17, convert(r16));
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }

    private final void updateTime() {
        updateDesc(convert(SystemClock.elapsedRealtime() / ((long) 1000)));
    }

    private final String convert(long r6) {
        long r0 = 60;
        int r2 = (int) (r6 % r0);
        int r1 = (int) ((r6 / r0) % r0);
        return ((int) (r6 / ((long) StringUtil.SECONDS_PER_HOUR))) + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + pad(r1) + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + pad(r2);
    }

    private final String pad(int r2) {
        if (r2 >= 10) goto L6;
        return "0" + r2;
    L6:
        return String.valueOf(r2);
    }
}
