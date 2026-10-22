package com.android.settings.wifi.main;

import android.content.Context;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.util.BoostFramework;
import android.view.View;
import android.view.ViewGroup;
import com.android.settings.R;
import com.android.settings.SettingsAdapter;
import com.android.settings.SettingsApplication;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.wifi.AccessPointInfo;
import com.android.settings.wifi.AccessPointView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiListAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t¢\u0006\u0002\u0010\fJ\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0006\u0010$\u001a\u00020#J\u0018\u0010%\u001a\u00020#2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006'"}, d2 = {"Lcom/android/settings/wifi/main/WifiListAdapter;", "Lcom/android/settings/SettingsAdapter;", "context", "Landroid/content/Context;", "isActivateMode", "", "mPerf", "Landroid/util/BoostFramework;", "constructAccessPointsAction", "Lkotlin/Function0;", "", "Lcom/android/settings/wifi/AccessPointInfo;", "(Landroid/content/Context;ZLandroid/util/BoostFramework;Lkotlin/jvm/functions/Function0;)V", "TAG", "", "accessPointsList", "", "mWifiManager", "Landroid/net/wifi/WifiManager;", "getMWifiManager", "()Landroid/net/wifi/WifiManager;", "getAccessPointInfo", "position", "", "getCount", "getData", "getItem", "", "pos", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "initData", "", "tryUpdateConnectedAccessPointRssi", "updateData", "accessPoints", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class WifiListAdapter extends SettingsAdapter {
    private final String TAG;
    private final List<AccessPointInfo> accessPointsList;
    private final Function0<List<AccessPointInfo>> constructAccessPointsAction;
    private final Context context;
    private final boolean isActivateMode;
    private final BoostFramework mPerf;
    private final WifiManager mWifiManager;

    /* JADX WARN: Multi-variable type inference failed */
    public WifiListAdapter(Context r2, boolean r3, BoostFramework r4, Function0<? extends List<? extends AccessPointInfo>> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "constructAccessPointsAction");
        this.context = r2;
        this.isActivateMode = r3;
        this.mPerf = r4;
        this.constructAccessPointsAction = r5;
        this.TAG = "WifiListAdapter";
        Object r6 = SettingsApplication.getContext().getSystemService("wifi");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.mWifiManager = (WifiManager) r6;
        this.accessPointsList = new ArrayList();
    }

    protected final WifiManager getMWifiManager() {
        return this.mWifiManager;
    }

    public void initData() {
        if (this.mWifiManager.getWifiState() != 3) goto L6;
        updateData(this.constructAccessPointsAction.invoke());
        return;
    }

    public List<AccessPointInfo> getData() {
        return this.accessPointsList;
    }

    public void updateData(List<? extends AccessPointInfo> r3) {
        List<AccessPointInfo> r0 = this.accessPointsList;
        r0.clear();
        if (r3 == null) goto L5;
        r0.addAll(r3);
    L5:
        notifyDataSetChanged();
        List<? extends AccessPointInfo> r4 = r3;
        if (r4 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        AppMetricsUtils.INSTANCE.durationEventEnd("wifi_switch_on");
        return;
    L15:
        return;
    L8:
        if (r4.isEmpty() == true) goto L11;
        r2 = false;
        goto L12
    }

    @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
    public int getCount() {
        return this.accessPointsList.size();
    }

    @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
    public Object getItem(int r1) {
        return CollectionsKt.getOrNull(this.accessPointsList, r1);
    }

    public AccessPointInfo getAccessPointInfo(int r1) {
        return (AccessPointInfo) CollectionsKt.getOrNull(this.accessPointsList, r1);
    }

    @Override // com.android.settings.SettingsAdapter, android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        if ((r5 instanceof AccessPointView) == false) goto L5;
        AccessPointView r7 = (AccessPointView) r5;
    L6:
        int r0 = 0;
        if (r7 != null) goto L9;
        r7 = new AccessPointView(this.context);
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        r7.setGravity(1);
    L9:
        View r1 = r7.findViewById(R.id.list_bottom_view);
        if (r1 == null) goto L16;
        Intrinsics.checkNotNull(r1);
        if (r4 == (getCount() - 1)) goto L15;
        r0 = 8;
    L15:
        r1.setVisibility(r0);
    L16:
        r7.bindData(this.accessPointsList.get(r4), r4, this.isActivateMode);
        return r7;
    L5:
        r7 = null;
        goto L6
    }

    public final void tryUpdateConnectedAccessPointRssi() {
        AccessPointInfo r0 = getAccessPointInfo(0);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getState() != NetworkInfo.DetailedState.CONNECTED) goto L9;
        notifyDataSetChanged();
        return;
    }
}
