package com.android.settings.specialaccess.datausage;

import android.net.NetworkPolicyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.datausage.AppStateDataUsageBridge;
import com.android.settings.datausage.DataSaverBackend;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.applications.ApplicationsState;
import com.android.settingslib.drawer.EntriesProvider;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DataSaverViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001cJ\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lcom/android/settings/specialaccess/datausage/DataSaverViewHolder;", "Lcom/obric/oui/orecyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "dataSaverBackend", "Lcom/android/settings/datausage/DataSaverBackend;", "(Landroid/view/View;Lcom/android/settings/datausage/DataSaverBackend;)V", "getDataSaverBackend", "()Lcom/android/settings/datausage/DataSaverBackend;", "itemBackgroundData", "Lcom/obric/oui/lisitem/OCardListItem;", "getItemBackgroundData", "()Lcom/obric/oui/lisitem/OCardListItem;", "itemBackgroundData$delegate", "Lkotlin/Lazy;", "itemUnrestrictedData", "getItemUnrestrictedData", "itemUnrestrictedData$delegate", "mNpm", "Landroid/net/NetworkPolicyManager;", "getMNpm", "()Landroid/net/NetworkPolicyManager;", "mNpm$delegate", "getView", "()Landroid/view/View;", "bindData", "", "info", "Lcom/android/settingslib/applications/ApplicationsState$AppEntry;", "isBackgroundDataEnable", "", "setBackgroundDataEnable", EntriesProvider.METHOD_IS_CHECKED, "updateItemUnrestricted", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DataSaverViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = null;
    private final DataSaverBackend dataSaverBackend;
    private final Lazy itemBackgroundData$delegate;
    private final Lazy itemUnrestrictedData$delegate;
    private final Lazy mNpm$delegate;
    private final View view;

    /* JADX INFO: compiled from: DataSaverViewHolder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/android/settings/specialaccess/datausage/DataSaverViewHolder$Companion;", "", "()V", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/android/settings/specialaccess/datausage/DataSaverViewHolder;", "parent", "Landroid/view/ViewGroup;", "dataSaverBackend", "Lcom/android/settings/datausage/DataSaverBackend;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DataSaverViewHolder build(ViewGroup r3, DataSaverBackend r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            Intrinsics.checkNotNullParameter(r4, "dataSaverBackend");
            View r2 = LayoutInflater.from(r3.getContext()).inflate(R.layout.item_data_saver_app_info, r3, false);
            Intrinsics.checkNotNull(r2);
            return new DataSaverViewHolder(r2, r4);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$Zgn2LvNMyYu_pFdxUOjXHwe0-iw, reason: not valid java name */
    public static /* synthetic */ void m611$r8$lambda$Zgn2LvNMyYu_pFdxUOjXHwe0iw(DataSaverViewHolder r0, ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        bindData$lambda$5$lambda$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$gnkU6TGpvNNPNgfimVpDui2T3Jk(DataSaverViewHolder r0, ApplicationsState.AppEntry r1, CompoundButton r2, boolean r3) {
        bindData$lambda$3$lambda$1(r0, r1, r2, r3);
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final DataSaverViewHolder build(ViewGroup r1, DataSaverBackend r2) {
        return Companion.build(r1, r2);
    }

    public DataSaverViewHolder(View r2, DataSaverBackend r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataSaverBackend");
        super(r2);
        this.view = r2;
        this.dataSaverBackend = r3;
        this.itemBackgroundData$delegate = LazyKt.lazy(new DataSaverViewHolder$itemBackgroundData$2(this));
        this.itemUnrestrictedData$delegate = LazyKt.lazy(new DataSaverViewHolder$itemUnrestrictedData$2(this));
        this.mNpm$delegate = LazyKt.lazy(new DataSaverViewHolder$mNpm$2(this));
    }

    public final DataSaverBackend getDataSaverBackend() {
        return this.dataSaverBackend;
    }

    public final View getView() {
        return this.view;
    }

    private final OCardListItem getItemBackgroundData() {
        Object r1 = this.itemBackgroundData$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OCardListItem) r1;
    }

    private final OCardListItem getItemUnrestrictedData() {
        Object r1 = this.itemUnrestrictedData$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (OCardListItem) r1;
    }

    private final NetworkPolicyManager getMNpm() {
        Object r1 = this.mNpm$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(r1, "getValue(...)");
        return (NetworkPolicyManager) r1;
    }

    public final void bindData(final ApplicationsState.AppEntry r4) {
        Intrinsics.checkNotNullParameter(r4, "info");
        if (r4.info != null) goto L5;
        return;
    L5:
        Utils.setAppLabelAndIconViews(this.view, r4.info.packageName, r4.info.uid);
        OSwitch r0 = getItemBackgroundData().getEndSwitch();
        if (r0 == null) goto L10;
        r0.setChecked(isBackgroundDataEnable(r4));
        r0.setOnCheckedChangeListener(new DataSaverViewHolder$$ExternalSyntheticLambda0(this, r4));
        AppStateDataUsageBridge.DataUsageState r1 = (AppStateDataUsageBridge.DataUsageState) r4.extraInfo;
        if (r1 == null) goto L10;
        r1.isDataSaverDenylisted = !r0.isChecked();
    L10:
        OSwitch r2 = getItemUnrestrictedData().getEndSwitch();
        if (r2 == null) goto L13;
        r2.setOnCheckedChangeListener(new DataSaverViewHolder$$ExternalSyntheticLambda1(this, r4));
    L13:
        updateItemUnrestricted(r4);
    }

    private static final void bindData$lambda$3$lambda$1(DataSaverViewHolder r1, ApplicationsState.AppEntry r2, CompoundButton r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$info");
        Intrinsics.checkNotNullParameter(r3, "buttonView");
        r1.setBackgroundDataEnable(r4, r2);
        AppStateDataUsageBridge.DataUsageState r5 = (AppStateDataUsageBridge.DataUsageState) r2.extraInfo;
        if (r5 == null) goto L7;
        r5.isDataSaverDenylisted = !r4;
        if (r5.isDataSaverDenylisted == false) goto L7;
        r5.isDataSaverAllowlisted = false;
    L7:
        r1.updateItemUnrestricted(r2);
    }

    private static final void bindData$lambda$5$lambda$4(DataSaverViewHolder r1, ApplicationsState.AppEntry r2, CompoundButton r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$info");
        Intrinsics.checkNotNullParameter(r3, "buttonView");
        r1.dataSaverBackend.setIsAllowlisted(r2.info.uid, r2.info.packageName, r4);
    }

    public final void setBackgroundDataEnable(boolean r2, ApplicationsState.AppEntry r3) {
        Intrinsics.checkNotNullParameter(r3, "info");
        if (r2 == false) goto L5;
        getMNpm().setUidPolicy(r3.info.uid, 0);
        return;
    L5:
        getMNpm().setUidPolicy(r3.info.uid, 16);
    }

    public final boolean isBackgroundDataEnable(ApplicationsState.AppEntry r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
        if ((getMNpm().getUidPolicy(r2.info.uid) & 16) == 0) goto L5;
        boolean r1 = true;
    L7:
        return !r1;
    L5:
        r1 = false;
        goto L7
    }

    private final void updateItemUnrestricted(ApplicationsState.AppEntry r3) {
        OSwitch r0 = getItemUnrestrictedData().getEndSwitch();
        if (r0 == null) goto L8;
        AppStateDataUsageBridge.DataUsageState r4 = (AppStateDataUsageBridge.DataUsageState) r3.extraInfo;
        if (r4 == null) goto L9;
        getItemUnrestrictedData().setEnabled(!r4.isDataSaverDenylisted);
        r0.setChecked(r4.isDataSaverAllowlisted);
        return;
    L9:
        return;
    }
}
