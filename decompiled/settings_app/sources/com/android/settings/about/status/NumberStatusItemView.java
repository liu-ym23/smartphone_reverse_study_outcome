package com.android.settings.about.status;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.android.settings.MultiSimSimStatus;
import com.android.settings.R;
import com.android.settings.about.DeviceStatusItemView;
import com.android.settings.deviceinfo.MSimInfoHelper;
import com.android.settings.utils.ResourceUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NumberStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J*\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/settings/about/status/NumberStatusItemView;", "Lcom/android/settings/about/DeviceStatusItemView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;)V", "displaySimStatus", "", "simIndex", "initData", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "simStatusHelper", "Lcom/android/settings/about/status/SimStatusHelper;", "title", "", "showEndIcon", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NumberStatusItemView extends DeviceStatusItemView {
    private final Lifecycle lifecycle;

    /* JADX INFO: renamed from: $r8$lambda$jEU5rOKZm2w316-mlDmCC2RRnkM, reason: not valid java name */
    public static /* synthetic */ void m225$r8$lambda$jEU5rOKZm2w316mlDmCC2RRnkM(SimStatusHelper r0, NumberStatusItemView r1, View r2) {
        initData$lambda$0(r0, r1, r2);
    }

    public NumberStatusItemView(Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, null, 0, null, 14, null);
    }

    public NumberStatusItemView(Context r9, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, 0, null, 12, null);
    }

    public NumberStatusItemView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ NumberStatusItemView(Context r2, AttributeSet r3, int r4, Lifecycle r5, int r6, DefaultConstructorMarker r7) {
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

    public NumberStatusItemView(Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, r13, 0, 16, null);
        this.lifecycle = r13;
    }

    public static /* synthetic */ void initData$default(NumberStatusItemView r0, LifecycleOwner r1, SimStatusHelper r2, String r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = ResourceUtils.getString(R.string.status_number);
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = false;
    L8:
        r0.initData(r1, r2, r3, r4);
    }

    public final void initData(LifecycleOwner r3, final SimStatusHelper r4, final String r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r3, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r4, "simStatusHelper");
        Intrinsics.checkNotNullParameter(r5, "title");
        if (this.lifecycle != null) goto L5;
        return;
    L5:
        r4.getNumberLv().observe(r3, new NumberStatusItemView$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(this, r5)));
        showRightArrow(r6);
        if (r6 == false) goto L9;
        setOnClickListener(new NumberStatusItemView$$ExternalSyntheticLambda0(r4, this));
        return;
    }

    private static final void initData$lambda$0(SimStatusHelper r2, NumberStatusItemView r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "$simStatusHelper");
        Intrinsics.checkNotNullParameter(r3, "this$0");
        String r5 = r2.getNumberLv().getValue();
        boolean r0 = false;
        if (r5 != null) goto L5;
    L7:
        if (r0 == true) goto L9;
        return;
    L9:
        r3.displaySimStatus(r2.getMSlotId());
        return;
    L5:
        if (Character.isDigit(StringsKt.last(r5)) != true) goto L7;
        r0 = true;
        goto L7
    }

    private final void displaySimStatus(int r4) {
        Intent r0 = new Intent(getContext(), MultiSimSimStatus.class);
        r0.putExtra("title", MSimInfoHelper.getSimName(getContext(), r4));
        r0.putExtra("back_text_id", R.string.about_item_title_device_status);
        r0.putExtra("subscription", r4);
        getContext().startActivity(r0);
    }
}
