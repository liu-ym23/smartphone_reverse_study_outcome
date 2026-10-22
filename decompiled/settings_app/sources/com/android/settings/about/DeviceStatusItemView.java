package com.android.settings.about;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import com.android.settings.R;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.utils.ViewUtils;
import com.obric.oui.layout.OUIFrameLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceStatusItemView.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rJ\"\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0007J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010%H\u0016J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/settings/about/DeviceStatusItemView;", "Lcom/obric/oui/layout/OUIFrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "endWidth", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/Lifecycle;I)V", "TAG", "", "descTv", "Lcom/obric/oui/text/OTextView;", "getDescTv", "()Lcom/obric/oui/text/OTextView;", "mCardView", "Lcom/obric/oui/lisitem/OCardListItem;", "fixLongTailTitleUI", "", "cardView", "title", "desc", "initData", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "setCardPosition", "position", "setOnClickListener", "l", "Landroid/view/View$OnClickListener;", "setOnLongClickListener", "Landroid/view/View$OnLongClickListener;", "showRightArrow", "boolean", "", "updateDesc", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class DeviceStatusItemView extends OUIFrameLayout {
    private final String TAG;
    private final int endWidth;
    private final Lifecycle lifecycle;
    private final OCardListItem mCardView;

    /* JADX INFO: renamed from: $r8$lambda$VdnXe0yhQRRUQyX9T82nqbGQ-Kw, reason: not valid java name */
    public static /* synthetic */ boolean m221$r8$lambda$VdnXe0yhQRRUQyX9T82nqbGQKw(View.OnLongClickListener r0, DeviceStatusItemView r1, View r2) {
        return setOnLongClickListener$lambda$2(r0, r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$a8zG6JQ4YP7J0njvgo5yVdBfQeY(DeviceStatusItemView r0, String r1, View r2) {
        return initData$lambda$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$mx_LvwfDAmsdgmF2bYwM7a5wY3M(View.OnClickListener r0, DeviceStatusItemView r1, View r2) {
        setOnClickListener$lambda$3(r0, r1, r2);
    }

    public DeviceStatusItemView(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, null, 0, null, 0, 30, null);
    }

    public DeviceStatusItemView(Context r10, AttributeSet r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, 0, null, 0, 28, null);
    }

    public DeviceStatusItemView(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, null, 0, 24, null);
    }

    public DeviceStatusItemView(Context r10, AttributeSet r11, int r12, Lifecycle r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        this(r10, r11, r12, r13, 0, 16, null);
    }

    public /* synthetic */ DeviceStatusItemView(Context r8, AttributeSet r9, int r10, Lifecycle r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L5;
        AttributeSet r3 = null;
    L7:
        if ((r13 & 4) == 0) goto L9;
        r10 = 0;
    L9:
        int r4 = r10;
        if ((r13 & 8) == 0) goto L12;
        Lifecycle r5 = null;
    L14:
        if ((r13 & 16) == 0) goto L16;
        r12 = 182;
    L16:
        this(r8, r3, r4, r5, r12);
        return;
    L12:
        r5 = r11;
        goto L14
    L5:
        r3 = r9;
        goto L7
    }

    public DeviceStatusItemView(Context r9, AttributeSet r10, int r11, Lifecycle r12, int r13) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, null, 8, null);
        this.lifecycle = r12;
        this.endWidth = r13;
        this.TAG = "DeviceStatusItemView";
        OCardListItem r14 = new OCardListItem(r9, r10, r11);
        r14.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        r14.setDefaultTailIcon(0);
        r14.setDefaultCustomEndView(3);
        r14.showCustomEnd(true);
        OCardListItem.setCardPosition$default(r14, 2, false, 2, null);
        this.mCardView = r14;
        addView(r14);
    }

    private final OTextView getDescTv() {
        View r1 = this.mCardView.getCustomEndView();
        if ((r1 instanceof OTextView) == true) goto L5;
        return null;
    L5:
        return (OTextView) r1;
    }

    public final void initData(final String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "desc");
        this.mCardView.setTitle(r3);
        OTextView r0 = getDescTv();
        if (r0 == null) goto L6;
        r0.setText(r4);
    L6:
        setOnLongClickListener(new DeviceStatusItemView$$ExternalSyntheticLambda0(this, r3));
        fixLongTailTitleUI(this.mCardView, r3, r4);
    }

    private static final boolean initData$lambda$1(DeviceStatusItemView r8, String r9, View r10) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        Intrinsics.checkNotNullParameter(r9, "$title");
        Context r11 = r8.getContext();
        CharSequence r1 = null;
        if ((r11 instanceof Activity) == false) goto L5;
        Activity r12 = (Activity) r11;
    L6:
        if (r12 != null) goto L9;
        return false;
    L9:
        OToast.Companion.show$default(OToast.Companion, r12, ResourceUtils.getString(R.string.copied) + r9, 0, 4, null);
        Object r13 = r12.getSystemService("clipboard");
        if ((r13 instanceof ClipboardManager) == false) goto L12;
        ClipboardManager r14 = (ClipboardManager) r13;
    L13:
        if (r14 == null) goto L20;
        OTextView r15 = r8.getDescTv();
        if (r15 == null) goto L17;
        r1 = r15.getText();
    L17:
        r14.setPrimaryClip(ClipData.newPlainText(r10, r1));
        return true;
    L20:
        return true;
    L12:
        r14 = null;
        goto L13
    L5:
        r12 = null;
        goto L6
    }

    @Override // android.view.View
    public void setOnLongClickListener(final View.OnLongClickListener r3) {
        this.mCardView.setOnContentLongClickListener(new DeviceStatusItemView$$ExternalSyntheticLambda1(r3, this));
    }

    private static final boolean setOnLongClickListener$lambda$2(View.OnLongClickListener r0, DeviceStatusItemView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.onLongClick(r1);
    }

    @Override // android.view.View
    public void setOnClickListener(final View.OnClickListener r3) {
        this.mCardView.setOnContentClickListener(new DeviceStatusItemView$$ExternalSyntheticLambda2(r3, this));
    }

    private static final void setOnClickListener$lambda$3(View.OnClickListener r0, DeviceStatusItemView r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r0 == null) goto L6;
        r0.onClick(r1);
        return;
    }

    public final void updateDesc(String r2) {
        Intrinsics.checkNotNullParameter(r2, "desc");
        OTextView r1 = getDescTv();
        if (r1 == null) goto L7;
        r1.setText(r2);
        return;
    }

    public final void showRightArrow(boolean r1) {
        this.mCardView.showTailIcon(r1);
    }

    public void onActivityResult(int r1, int r2, Intent r3) {
        super.onActivityResult(r1, r2, r3);
    }

    public final void setCardPosition(int r4) {
        OCardListItem.setCardPosition$default(this.mCardView, r4, false, 2, null);
    }

    private final void fixLongTailTitleUI(OCardListItem r6, String r7, String r8) {
        View r9 = this.mCardView.getCustomEndView();
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.oui.text.OTextView");
        OTextView r10 = (OTextView) r9;
        r10.setMaxLines(Integer.MAX_VALUE);
        Configuration r11 = getContext().getResources().getConfiguration();
        float r0 = r11.fontScale;
        boolean r1 = Intrinsics.areEqual(r11.locale.getLanguage(), "zh");
        int r4 = 240;
        if (r11.densityDpi != 560) goto L9;
        if (r11.fontScale <= 1.0f) goto L7;
        r4 = 210;
        goto L9
    L7:
        r8 = ViewUtils.breakTextIntoLines(r8, UIUtils.INSTANCE.dp2px(this.endWidth), r10.getPaint());
        Intrinsics.checkNotNullExpressionValue(r8, "breakTextIntoLines(...)");
    L9:
        if (r11.densityDpi == 640) goto L11;
    L19:
        this.mCardView.setEndDetailText(r8, UIUtils.INSTANCE.dp2px(r4));
        return;
    L11:
        if (r11.fontScale <= 1.0f) goto L16;
        if (r1 == false) goto L14;
        int r12 = 168;
    L15:
        r4 = r12;
        goto L19
    L14:
        r12 = 160;
        goto L15
    L16:
        if (r1 == false) goto L18;
        r12 = 186;
        goto L15
    L18:
        r12 = 180;
        goto L15
    }
}
