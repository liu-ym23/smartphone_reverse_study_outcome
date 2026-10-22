package com.android.settings.wifi;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import com.android.settings.FeatureFactory;
import com.android.settings.R;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.core.lifecycle.Lifecycle;
import com.android.wifitrackerlib.WifiEntry;
import com.android.wifitrackerlib.WifiPickerTracker;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.alert.style.DialogContainer;
import com.obric.oui.dialog.v2.alert.style.OViewStyleController;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.time.Clock;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestDialogFragment extends Fragment implements DialogInterface.OnClickListener, WifiPickerTracker.WifiPickerTrackerCallback, LifecycleOwner {
    public static final String EXTRA_APP_NAME = "DIALOG_REQUEST_APP_NAME";
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final long SCAN_INTERVAL_MILLIS = 10000;
    private static final String TAG = "NetworkRequestDialogFragment";
    private String mAppName;
    private Dialog mDialog;
    private WifiEntryAdapter mDialogAdapter;
    List<WifiEntry> mFilteredWifiEntries;
    private final Lifecycle mLifecycle;
    private List<MatchWifi> mMatchWifis;
    private WifiManager.NetworkRequestUserSelectionCallback mUserSelectionCallback;
    WifiPickerTracker mWifiPickerTracker;
    private HandlerThread mWorkerThread;

    private static class MatchWifi {
        List<Integer> mSecurityTypes;
        String mSsid;

        private MatchWifi() {
        }

        /* synthetic */ MatchWifi(AnonymousClass1 r1) {
            this();
        }
    }

    private class WifiEntryAdapter extends ArrayAdapter<WifiEntry> {
        private final LayoutInflater mInflater;
        final /* synthetic */ NetworkRequestDialogFragment this$0;

        WifiEntryAdapter(NetworkRequestDialogFragment r1, Context r2, int r3, List<WifiEntry> r4) {
            this.this$0 = r1;
            super(r2, r3, r4);
            this.mInflater = LayoutInflater.from(r2);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(final int r6, View r7, ViewGroup r8) {
            if (r7 != null) goto L5;
            r7 = this.mInflater.inflate(R.layout.list_content_item_check_oui_with_icon_2, r8, false);
        L5:
            WifiEntry r9 = getItem(r6);
            OCardListItem r1 = (OCardListItem) r7.findViewById(R.id.item_check);
            if (r9 == null) goto L12;
            r1.setTitle(r9.getTitle());
            r1.setSubTitle(r9.getSummary());
            r1.showSubTitle(true);
            int r10 = r9.getLevel();
            if (r10 == (-1)) goto L10;
            r1.setIcon(R.drawable.wifi_signal);
            r1.getIconView().setImageLevel(Math.min(r10, 3));
        L10:
            r1.setOnContentClickListener(new NetworkRequestDialogFragment$WifiEntryAdapter$$ExternalSyntheticLambda0(this, r6));
        L12:
            if (getCount() != 1) goto L14;
            r1.setCardPosition(0);
            r1.setPadding(0, 0, 0, com.android.settings.Utils.dp2Pixels(this.this$0.getActivity(), 16.0f));
        L20:
            return r7;
        L14:
            if (r6 != 0) goto L17;
            r1.setCardPosition(1);
            goto L20
        L17:
            if (r6 != (getCount() - 1)) goto L19;
            r1.setCardPosition(3);
            r1.setPadding(0, 0, 0, com.android.settings.Utils.dp2Pixels(this.this$0.getActivity(), 16.0f));
            goto L20
        L19:
            r1.setCardPosition(2);
            goto L20
        }

        /* JADX INFO: renamed from: lambda$getView$0$com-android-settings-wifi-NetworkRequestDialogFragment$WifiEntryAdapter, reason: not valid java name */
        /* synthetic */ void m669x7503b70b(int r1, View r2) {
            NetworkRequestDialogFragment r0 = this.this$0;
            r0.onClick(NetworkRequestDialogFragment.access$000(r0), r1);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onNumSavedNetworksChanged() {
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onNumSavedSubscriptionsChanged() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public NetworkRequestDialogFragment() {
        this.mLifecycle = new Lifecycle(this);
        this.mMatchWifis = new ArrayList();
        this.mFilteredWifiEntries = new ArrayList();
        this.mDialog = null;
        this.mAppName = "";
    }

    static /* synthetic */ Dialog access$000(NetworkRequestDialogFragment r0) {
        return r0.mDialog;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mLifecycle;
    }

    public static NetworkRequestDialogFragment newInstance() {
        return new NetworkRequestDialogFragment();
    }

    public void com_android_settings_wifi_NetworkRequestDialogFragment__onCreate$___twin___(Bundle r15) {
        this.mLifecycle.onCreate(r15);
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        super.onCreate(r15);
        if (getArguments() == null) goto L5;
        this.mAppName = getArguments().getString("DIALOG_REQUEST_APP_NAME", "");
    L5:
        HandlerThread r0 = new HandlerThread("NetworkRequestDialogFragment{" + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWorkerThread = r0;
        r0.start();
        final ZoneOffset r1 = ZoneOffset.UTC;
        Clock r8 = new AnonymousClass1(this, r1);
        Context r5 = getContext();
        this.mWifiPickerTracker = FeatureFactory.getFactory(r5).getWifiTrackerLibProvider().createWifiPickerTracker(getLifecycle(), r5, new Handler(Looper.getMainLooper()), this.mWorkerThread.getThreadHandler(), r8, 15000, SCAN_INTERVAL_MILLIS, this);
        Dialog r16 = onCreateDialog(r15);
        this.mDialog = r16;
        r16.show();
    }

    public void show() {
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.show();
        return;
    }

    public void dismiss() {
        Dialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        r0.dismiss();
        return;
    }

    public Dialog onCreateDialog(Bundle r6) {
        Context r7 = getContext();
        final View r0 = LayoutInflater.from(r7).inflate(R.layout.network_request_dialog, null);
        ListView r1 = (ListView) r0.findViewById(R.id.request_network);
        WifiEntryAdapter r2 = new WifiEntryAdapter(this, r7, R.layout.preference_access_point, this.mFilteredWifiEntries);
        this.mDialogAdapter = r2;
        r1.setAdapter(r2);
        OAlertDialog r8 = new OAlertDialogBuilder(r7).autoDismiss(false).horizontalButton().title(R.string.network_connection_request_dialog_title).message(getString(R.string.network_connection_request_dialog_summary, new Object[]{this.mAppName})).body(new OViewStyleController(new NetworkRequestDialogFragment$$ExternalSyntheticLambda0(r0))).negativeButton(R.string.cancel, new NetworkRequestDialogFragment$$ExternalSyntheticLambda1(this)).createDialog();
        this.mDialog = r8;
        return r8;
    }

    static /* synthetic */ Unit lambda$onCreateDialog$0(View r0, DialogContainer r1) {
        r1.getBodySlot().addView(r0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: lambda$onCreateDialog$1$com-android-settings-wifi-NetworkRequestDialogFragment, reason: not valid java name */
    /* synthetic */ void m667xff13e3c8(DialogInterface r1, int r2) {
        r1.dismiss();
        WifiManager.NetworkRequestUserSelectionCallback r0 = this.mUserSelectionCallback;
        if (r0 == null) goto L6;
        r0.reject();
        return;
    }

    private BaseAdapter getDialogAdapter() {
        return this.mDialogAdapter;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r1, int r2) {
        if (this.mFilteredWifiEntries.size() != 0) goto L5;
        return;
    L5:
        if (r2 < this.mFilteredWifiEntries.size()) goto L8;
        return;
    L8:
        if (this.mUserSelectionCallback != null) goto L10;
        return;
    L10:
        WifiEntry r3 = this.mFilteredWifiEntries.get(r2);
        WifiConfiguration r4 = r3.getWifiConfiguration();
        if (r4 != null) goto L13;
        r4 = Utils.getWifiConfig(r3, null);
    L13:
        this.mUserSelectionCallback.select(r4);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        this.mWorkerThread.quit();
        super.onDestroy();
    }

    @Override // com.android.wifitrackerlib.BaseWifiTracker.BaseWifiTrackerCallback
    public void onWifiStateChanged() {
        if (this.mMatchWifis.size() != 0) goto L5;
        return;
    L5:
        updateWifiEntries();
        updateUi();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
        super.onStart();
    }

    public void com_android_settings_wifi_NetworkRequestDialogFragment__onResume$___twin___() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        this.mLifecycle.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
        super.onStop();
    }

    @Override // com.android.wifitrackerlib.WifiPickerTracker.WifiPickerTrackerCallback
    public void onWifiEntriesChanged() {
        if (this.mMatchWifis.size() != 0) goto L5;
        return;
    L5:
        updateWifiEntries();
        updateUi();
    }

    void updateWifiEntries() {
        if (this.mWifiPickerTracker != null) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList();
        WifiEntry r1 = this.mWifiPickerTracker.getConnectedWifiEntry();
        if (r1 == null) goto L8;
        final String r2 = r1.getSsid();
        r0.add(r1);
    L9:
        r0.addAll(this.mWifiPickerTracker.getWifiEntries());
        this.mFilteredWifiEntries.clear();
        this.mFilteredWifiEntries.addAll(r0.stream().filter(new NetworkRequestDialogFragment$$ExternalSyntheticLambda2(this, r2)).limit(Long.MAX_VALUE).toList());
        return;
    L8:
        r2 = null;
        goto L9
    }

    /* JADX INFO: renamed from: lambda$updateWifiEntries$2$com-android-settings-wifi-NetworkRequestDialogFragment, reason: not valid java name */
    /* synthetic */ boolean m668xaecb4012(String r1, WifiEntry r2) {
        return isMatchedWifiEntry(r2, r1);
    }

    private boolean isMatchedWifiEntry(WifiEntry r4, String r5) {
        if (r4.getConnectedState() == 0) goto L5;
    L7:
        Iterator<MatchWifi> r3 = this.mMatchWifis.iterator();
    L9:
        if (r3.hasNext() == false) goto L20;
        MatchWifi r6 = r3.next();
        if (TextUtils.equals(r4.getSsid(), r6.mSsid) == false) goto L9;
        Iterator<Integer> r7 = r6.mSecurityTypes.iterator();
    L15:
        if (r7.hasNext() == false) goto L9;
        Integer r0 = r7.next();
        if (r4.getSecurityTypes().contains(r0) == false) goto L15;
        return true;
    L20:
        return false;
    L5:
        if (TextUtils.equals(r4.getSsid(), r5) == false) goto L7;
        return false;
    }

    public void onUserSelectionCallbackRegistration(WifiManager.NetworkRequestUserSelectionCallback r1) {
        this.mUserSelectionCallback = r1;
    }

    public void onMatch(List<ScanResult> r4) {
        this.mMatchWifis.clear();
        Iterator<ScanResult> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        ScanResult r0 = r5.next();
        MatchWifi r1 = new MatchWifi(null);
        r1.mSsid = r0.SSID;
        r1.mSecurityTypes = com.android.wifitrackerlib.Utils.getSecurityTypesFromScanResult(r0);
        this.mMatchWifis.add(r1);
        goto L4
    L6:
        updateWifiEntries();
        updateUi();
    }

    void updateUi() {
        if (getDialogAdapter() == null) goto L6;
        getDialogAdapter().notifyDataSetChanged();
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(NetworkRequestDialogFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestDialogFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(NetworkRequestDialogFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wifi_NetworkRequestDialogFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(NetworkRequestDialogFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wifi_NetworkRequestDialogFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
