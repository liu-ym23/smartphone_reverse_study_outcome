package com.android.settings.about.status;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.Lifecycle;
import com.android.settings.about.DeviceStatusItemView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\f\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/android/settings/about/status/BatteryItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "mBatteryInfoReceiver", "com/android/settings/about/status/BatteryItemView$mBatteryInfoReceiver$1", "Lcom/android/settings/about/status/BatteryItemView$mBatteryInfoReceiver$1;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BatteryItemView extends DeviceStatusItemView {
    private final Lifecycle lifecycle;
    private final BatteryItemView$mBatteryInfoReceiver$1 mBatteryInfoReceiver;

    public BatteryItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public BatteryItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public BatteryItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public static final /* synthetic */ BatteryItemView$mBatteryInfoReceiver$1 access$getMBatteryInfoReceiver$p(BatteryItemView r0) {
        return r0.mBatteryInfoReceiver;
    }

    public /* synthetic */ BatteryItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
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

    /* JADX WARN: Type inference failed for: r11v1, types: [com.android.settings.about.status.BatteryItemView$mBatteryInfoReceiver$1] */
    public BatteryItemView(final Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, 0, 16, null);
        this.lifecycle = r13;
        this.mBatteryInfoReceiver = new BatteryItemView$mBatteryInfoReceiver$1(this);
        if (r13 == null) goto L6;
        r13.addObserver(new AnonymousClass1(r10, this));
        return;
    }
}
