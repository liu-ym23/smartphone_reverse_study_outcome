package com.android.settings.applications.utils;

import android.app.Activity;
import android.view.View;
import com.android.settings.OptionsInfo;
import com.obric.oui.popover.v2.OPopover;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OptionsPopover.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J\u0006\u0010$\u001a\u00020\u001aJ\u0018\u0010%\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0018H\u0016J>\u0010'\u001a\u00020\u001a26\u0010(\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0014J\u0006\u0010)\u001a\u00020\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R@\u0010\u0013\u001a4\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 ¨\u0006*"}, d2 = {"Lcom/android/settings/applications/utils/OptionsPopover;", "Lcom/android/settings/applications/utils/OnPopoverItemClickListener;", "activity", "Landroid/app/Activity;", "anchor", "Landroid/view/View;", "opts", "Lcom/android/settings/OptionsInfo;", "currentValue", "", "optionTitle", "", "(Landroid/app/Activity;Landroid/view/View;Lcom/android/settings/OptionsInfo;Ljava/lang/Object;Ljava/lang/String;)V", "getActivity", "()Landroid/app/Activity;", "getAnchor", "()Landroid/view/View;", "getCurrentValue", "()Ljava/lang/Object;", "mOnSelect", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "", "index", "", "mPopover", "Lcom/obric/oui/popover/v2/OPopover;", "getOptionTitle", "()Ljava/lang/String;", "getOpts", "()Lcom/android/settings/OptionsInfo;", "buildItems", "", "Lcom/android/settings/applications/utils/Item;", "dismiss", "onPopoverItemClick", "position", "onSelect", "select", "show", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OptionsPopover implements OnPopoverItemClickListener {
    private final Activity activity;
    private final View anchor;
    private final Object currentValue;
    private Function2<? super View, ? super Integer, Unit> mOnSelect;
    private OPopover mPopover;
    private final String optionTitle;
    private final OptionsInfo opts;

    public OptionsPopover(Activity r2, View r3, OptionsInfo r4, Object r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "anchor");
        Intrinsics.checkNotNullParameter(r4, "opts");
        Intrinsics.checkNotNullParameter(r5, "currentValue");
        Intrinsics.checkNotNullParameter(r6, "optionTitle");
        this.activity = r2;
        this.anchor = r3;
        this.opts = r4;
        this.currentValue = r5;
        this.optionTitle = r6;
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final View getAnchor() {
        return this.anchor;
    }

    public final OptionsInfo getOpts() {
        return this.opts;
    }

    public final Object getCurrentValue() {
        return this.currentValue;
    }

    public final String getOptionTitle() {
        return this.optionTitle;
    }

    public final void show() {
        List<Item> r0 = buildItems();
        this.mPopover = OPopoverHelper.showPopoverList(this.activity, this.anchor, r0, this, true);
    }

    public final void onSelect(Function2<? super View, ? super Integer, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "select");
        this.mOnSelect = r2;
    }

    public final void dismiss() {
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    @Override // com.android.settings.applications.utils.OnPopoverItemClickListener
    public void onPopoverItemClick(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        this.opts.save(r2.getContext(), r3);
        Function2<? super View, ? super Integer, Unit> r4 = this.mOnSelect;
        if (r4 == null) goto L6;
        r4.invoke(this.anchor, Integer.valueOf(r3));
        return;
    }

    private final List<Item> buildItems() {
        ArrayList r0 = new ArrayList();
        String[] r1 = this.opts.getOptionEntries();
        if (r1 == null) goto L8;
        int r2 = r1.length;
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r3 >= r2) goto L8;
        String r5 = r1[r3];
        Intrinsics.checkNotNull(r5);
        r0.add(new Item(r5, Intrinsics.areEqual(this.currentValue, this.opts.getOptionValues()[r4]), null));
        r3 = r3 + 1;
        r4 = r4 + 1;
    L8:
        return r0;
    }
}
