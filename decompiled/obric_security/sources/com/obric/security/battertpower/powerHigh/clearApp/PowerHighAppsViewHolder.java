package com.obric.security.battertpower.powerHigh.clearApp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.ViewModelProvider;
import com.obric.oui.OuiWidgetUtils;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: PowerHighAppsViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "setCheckBox", "(Lcom/obric/oui/checkbox/OCheckBox;)V", "checkBoxRoot", "Landroid/widget/FrameLayout;", "getCheckBoxRoot", "()Landroid/widget/FrameLayout;", "setCheckBoxRoot", "(Landroid/widget/FrameLayout;)V", "item", "Lcom/obric/oui/lisitem/OCardListItem;", "getItem", "()Lcom/obric/oui/lisitem/OCardListItem;", "setItem", "(Lcom/obric/oui/lisitem/OCardListItem;)V", "getAppIconByPackageName", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "packageName", "", "onBind", "", "app", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "position", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighAppsViewHolder extends RecyclerView.ViewHolder {
    private OCheckBox checkBox;
    private FrameLayout checkBoxRoot;
    private OCardListItem item;

    public PowerHighAppsViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.item = (OCardListItem) r2.findViewById(R.id.list_item);
        this.checkBox = (OCheckBox) r2.findViewById(R.id.checkBox);
        this.checkBoxRoot = (FrameLayout) r2.findViewById(R.id.check_box_root);
    }

    public final OCardListItem getItem() {
        return this.item;
    }

    public final void setItem(OCardListItem r1) {
        this.item = r1;
    }

    public final OCheckBox getCheckBox() {
        return this.checkBox;
    }

    public final void setCheckBox(OCheckBox r1) {
        this.checkBox = r1;
    }

    public final FrameLayout getCheckBoxRoot() {
        return this.checkBoxRoot;
    }

    public final void setCheckBoxRoot(FrameLayout r1) {
        this.checkBoxRoot = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.security.battertpower.powerHigh.clearApp.PowerHighAppsViewModel] */
    public final void onBind(final PowerHighApp r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "app");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        if (r3 == null) goto L50;
        r0.element = (PowerHighAppsViewModel) new ViewModelProvider((ClearPowerHighAppsActivity) r3).get(PowerHighAppsViewModel.class);
        OCardListItem r1 = this.item;
        if (r1 == null) goto L7;
        r1.setTitle(r6.getLabel());
    L7:
        OCardListItem r4 = this.item;
        if (r4 == null) goto L10;
        View r5 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r5, "itemView");
        Context r8 = r5.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "itemView.context");
        r4.setAppIcon(getAppIconByPackageName(r8, r6.getPackageName()));
    L10:
        OCardListItem r9 = this.item;
        if (r9 == null) goto L13;
        r9.showIcon(true);
    L13:
        OCheckBox r10 = this.checkBox;
        if (r10 == null) goto L17;
        r10.setChecked(r6.getTempCheck());
    L17:
        if (r6.getTempCheck() == false) goto L21;
        HashSet<PowerHighApp> r11 = ((PowerHighAppsViewModel) r0.element).getCheckApps().getValue();
        if (r11 == null) goto L24;
        r11.add(r6);
    L24:
        ((PowerHighAppsViewModel) r0.element).setCheckAppChange();
        if (r7 == 0) goto L42;
        OCardListItem r12 = this.item;
        ViewGroup.LayoutParams r13 = null;
        if (r12 == null) goto L29;
        ViewGroup.LayoutParams r14 = r12.getLayoutParams();
    L31:
        if ((r14 instanceof RecyclerView.LayoutParams) == false) goto L34;
        r13 = r14;
    L34:
        RecyclerView.LayoutParams r15 = (RecyclerView.LayoutParams) r13;
        if (r15 == null) goto L37;
        r15.topMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics()));
    L37:
        if (r15 == null) goto L39;
        r15.bottomMargin = MathKt.roundToInt(TypedValue.applyDimension(1, 0, Resources.getSystem().getDisplayMetrics()));
    L39:
        OCardListItem r16 = this.item;
        if (r16 == null) goto L42;
        r16.setLayoutParams(r15);
        goto L42
    L29:
        r14 = null;
    L42:
        OCheckBox r17 = this.checkBox;
        if (r17 == null) goto L45;
        r17.setClickable(false);
    L45:
        FrameLayout r18 = this.checkBoxRoot;
        if (r18 == null) goto L51;
        r18.setOnClickListener(new AnonymousClass1(this, r6, r0));
        return;
    L51:
        return;
    L21:
        HashSet<PowerHighApp> r19 = ((PowerHighAppsViewModel) r0.element).getCheckApps().getValue();
        if (r19 == null) goto L24;
        r19.remove(r6);
        goto L24
    L50:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity");
    }

    public final Drawable getAppIconByPackageName(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "packageName");
        PackageManager r2 = r3.getPackageManager();
        boolean r0 = false;
        ApplicationInfo r5 = r2.getApplicationInfo(r4, 0);     // Catch: PackageManager.NameNotFoundException -> L11
        Intrinsics.checkNotNullExpressionValue(r5, "packageManager.getApplicationInfo(packageName, 0)");     // Catch: PackageManager.NameNotFoundException -> L11
        Drawable r1 = r5.loadIcon(r2);     // Catch: PackageManager.NameNotFoundException -> L11
        if (r1 != null) goto L7;
        r1 = r2.getDefaultActivityIcon();     // Catch: PackageManager.NameNotFoundException -> L11
    L7:
        if (UserHandle.getUserId(r5.uid) != 10) goto L9;
        r0 = true;
    L9:
        return OuiWidgetUtils.applyDopplegangerBadge(r3, r1, r0);
    L11:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
