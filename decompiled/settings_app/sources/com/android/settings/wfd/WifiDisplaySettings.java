package com.android.settings.wfd;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.database.ContentObserver;
import android.hardware.display.DisplayManager;
import android.hardware.display.WifiDisplay;
import android.hardware.display.WifiDisplayStatus;
import android.media.MediaRouter;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.app.ActivityCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.preference.CheckBoxPreference;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.preference.PreferenceViewHolder;
import androidx.recyclerview.widget.RecyclerView;
import bytedanceos.api.ViewSmt;
import bytedanceos.util.DeviceType;
import com.GlobalProxyLancet;
import com.android.settings.OptionsInfo;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment23;
import com.android.settings.SystemAlertDialog;
import com.android.settings.Utils;
import com.android.settings.applications.LayoutPreference;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.NullSafe;
import com.android.settings.wifi.preference.SectionLayoutPreference;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.wirelesscast.ICallback;
import com.bytedance.wirelesscast.IWirelessCastService;
import com.bytedance.wirelesscast.LeBoControllerDialogFragment;
import com.bytedance.wirelesscast.SmtLinkInfo;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.privacy.GrantUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiDisplaySettings extends SettingsPreferenceFragment23 implements View.OnClickListener {
    private static final int CHANGE_ALL = -1;
    private static final int CHANGE_LEBO_BROWSE_STATUS = 8;
    private static final int CHANGE_ROUTES = 2;
    private static final int CHANGE_SETTINGS = 1;
    private static final int CHANGE_WIFI_DISPLAY_STATUS = 4;
    private static final String CONTROLLER_LEBO_FRAGMENT_TAG = "com.bytedance.wirelesscast:LeBoControllerDialogFragment";
    private static final boolean DEBUG = false;
    public static final String EXTRA_ENTRY_FLAG = "entry_from_wifi";
    private static final int MENU_ID_ENABLE_WIFI_DISPLAY = 1;
    private static final int MIN_SWITCH_TIME = 2000;
    private static final int MSG_LEBO_SWITCH_CHANGED = 101;
    private static final int MSG_LEBO_UPDATE_LIST = 100;
    private static final int ORDER_AVAILABLE = 3;
    private static final int ORDER_CERTIFICATION = 1;
    private static final int ORDER_CONNECTED = 2;
    private static final int ORDER_HEADER = 0;
    private static final int ORDER_LEBO = 5;
    private static final int ORDER_UNAVAILABLE = 4;
    private static final String PKG_WIRELESS_CAST = "com.bytedance.wirelesscast";
    private static final String TAG = "WifiDisplaySettings";
    private SystemAlertDialog mAlertDialog;
    private ActivityManager mAm;
    private boolean mAutoGO;
    private ICallback mCallback;
    private IWirelessCastService mCastService;
    private PreferenceGroup mCertCategory;
    ServiceConnection mConnection;
    private Context mContext;
    private DisplayManager mDisplayManager;
    private View mFooterView;
    private final Handler mHandler;
    private SectionLayoutPreference mHeaderPreference;
    private ListContentItemText mIncallSetting;
    private String[] mIncallTitles;
    private boolean mIsBind;
    private boolean mIsConnectWifiTnt;
    private long mLastHanldeTime;
    private final List<SmtLinkInfo> mLeLinkList;
    private boolean mListen;
    private int mListenChannel;
    private int mOperatingChannel;
    private int mPendingChanges;
    private List<Preference> mPreferencesList;
    private String[] mReceivedSmsTitles;
    private final BroadcastReceiver mReceiver;
    private MediaRouter mRouter;
    private final MediaRouter.Callback mRouterCallback;
    private final ContentObserver mSettingsObserver;
    private ListContentItemText mSmsSetting;
    private boolean mStarted;
    private final Runnable mUpdateRunnable;
    private OCardListItem mWifiDisplay;
    private boolean mWifiDisplayCertificationOn;
    private boolean mWifiDisplayOnSetting;
    private WifiDisplayStatus mWifiDisplayStatus;
    private OSectionSupportiveText mWifiDisplaySwitchSupportiveText;
    private WifiManager mWifiManager;
    private WifiP2pManager.Channel mWifiP2pChannel;
    private WifiP2pManager mWifiP2pManager;
    private int mWpsConfig;

    class LeLinkDisplayPreference extends WifiDisplayBasePreference implements Preference.OnPreferenceClickListener, SmtLinkInfo.OnConnectedListener {
        private final SmtLinkInfo mLeLinkInfo;
        final /* synthetic */ WifiDisplaySettings this$0;

        LeLinkDisplayPreference(WifiDisplaySettings r3, Context r4, SmtLinkInfo r5) {
            this.this$0 = r3;
            super(r3, r4, null);
            this.mLeLinkInfo = r5;
            if (r5 == null) goto L21;
            setTitle(r5.getIp());
            setOrder(5);
            OLog.d(WifiDisplaySettings.TAG, "info: " + r5);
            int r0 = r5.getStatus();
            if (r0 != 0) goto L7;
            setSummary(r5.getName());
            return;
        L7:
            if (r0 != 1) goto L9;
        L18:
            setSummary(R.string.wifi_display_status_connecting);
            return;
        L9:
            if (r0 == 2) goto L18;
            if (r0 != 3) goto L13;
            setSummary(r5.getName() + HanziToPinyin.Token.SEPARATOR + WifiDisplaySettings.access$1200(r3).getString(R.string.wifi_display_status_connected));
            return;
        L13:
            if (r0 == 4) goto L16;
            if (r0 == 5) goto L16;
            return;
        L16:
            setSummary(R.string.lebo_disconnecting);
            return;
        }

        @Override // com.android.settings.wfd.WifiDisplaySettings.WifiDisplayBasePreference
        protected void setItemClick(OCardListItem r2) {
            super.setItemClick(r2);
            r2.setOnContentClickListener(new WifiDisplaySettings$LeLinkDisplayPreference$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$setItemClick$0$com-android-settings-wfd-WifiDisplaySettings$LeLinkDisplayPreference, reason: not valid java name */
        /* synthetic */ void m647xeae7ae86(View r3) {
        L15:
            e = move-exception;
            Slog.d(WifiDisplaySettings.TAG, "onPreferenceClick e:" + e.toString());
            return;
        L4:
            if (WifiDisplaySettings.access$000(this.this$0) == null) goto L18;
            SmtLinkInfo r0 = this.mLeLinkInfo;     // Catch: RemoteException -> L15
            if (r0 == null) goto L18;
            int r1 = r0.getStatus();     // Catch: RemoteException -> L15
            if (r1 != 0) goto L10;
            WifiDisplaySettings.access$1900(this.this$0).disconnectWifiDisplay();     // Catch: RemoteException -> L15
            WifiDisplaySettings.access$000(this.this$0).connectService(this.mLeLinkInfo);     // Catch: RemoteException -> L15
            goto L18
        L10:
            if (r1 != 3) goto L18;
            OLog.d(WifiDisplaySettings.TAG, "showLeBoDialogFragment");     // Catch: RemoteException -> L15
            this.this$0.showLeBoDialogFragment(this.mLeLinkInfo, this);     // Catch: RemoteException -> L15
        L18:
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r3) {
        L15:
            e = move-exception;
            Slog.d(WifiDisplaySettings.TAG, "onPreferenceClick e:" + e.toString());
            return true;
        L4:
            if (WifiDisplaySettings.access$000(this.this$0) == null) goto L19;
            SmtLinkInfo r0 = this.mLeLinkInfo;     // Catch: RemoteException -> L15
            if (r0 == null) goto L19;
            int r1 = r0.getStatus();     // Catch: RemoteException -> L15
            if (r1 != 0) goto L10;
            WifiDisplaySettings.access$1900(this.this$0).disconnectWifiDisplay();     // Catch: RemoteException -> L15
            WifiDisplaySettings.access$000(this.this$0).connectService(this.mLeLinkInfo);     // Catch: RemoteException -> L15
            goto L19
        L10:
            if (r1 != 3) goto L19;
            OLog.d(WifiDisplaySettings.TAG, "showLeBoDialogFragment");     // Catch: RemoteException -> L15
            this.this$0.showLeBoDialogFragment(this.mLeLinkInfo, this);     // Catch: RemoteException -> L15
        L19:
            return true;
        }

        @Override // com.bytedance.wirelesscast.SmtLinkInfo.OnConnectedListener
        public void disconnect() {
            WifiDisplaySettings.access$3300(this.this$0, this.mLeLinkInfo);
        }

        protected int getDeviceIconRes() {
            Class<?> r2 = Class.forName("bytedanceos.api.SettingsSmt.ResourceId");     // Catch: Exception -> L4
            Object r0 = r2.newInstance();     // Catch: Exception -> L4
            return r2.getField("LEBO_INFOS_DEVICE_ICON_RES").getInt(r0);
        L4:
            e = move-exception;
            e.printStackTrace();
            return -1;
        }
    }

    private class RoutePreference extends WifiDisplayBasePreference implements Preference.OnPreferenceClickListener, SmtLinkInfo.OnConnectedListener {
        private final MediaRouter.RouteInfo mRoute;
        final /* synthetic */ WifiDisplaySettings this$0;

        public RoutePreference(WifiDisplaySettings r2, Context r3, MediaRouter.RouteInfo r4) {
            this.this$0 = r2;
            super(r2, r3, null);
            this.mRoute = r4;
            setTitle(r4.getName());
            Class<?> r5 = Class.forName("com.android.internal.R$string");     // Catch: Throwable -> L5
            Object r6 = r5.newInstance();     // Catch: Throwable -> L5
            setSummary(r5.getField("wireless_display_route_description").getInt(r6));     // Catch: Throwable -> L5
        L7:
            setEnabled(r4.isEnabled());
            if (r4.isSelected() == false) goto L14;
            setOrder(2);
            if (r4.isConnecting() == false) goto L12;
            setSummary(R.string.wifi_display_status_connecting);
            return;
        L12:
            setSummary(R.string.wifi_display_status_connected);
            return;
        L14:
            if (isEnabled() == false) goto L16;
            setOrder(3);
            return;
        L16:
            setOrder(4);
            if (r4.getStatusCode() != 5) goto L19;
            setSummary(R.string.wifi_display_status_in_use);
            return;
        L19:
            setSummary(R.string.wifi_display_status_not_available);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        /* JADX INFO: renamed from: lambda$setItemClick$0$com-android-settings-wfd-WifiDisplaySettings$RoutePreference, reason: not valid java name */
        /* synthetic */ void m648x280b4c20(View r2) {
            WifiDisplaySettings.access$3000(this.this$0, this.mRoute, this);
        }

        @Override // com.android.settings.wfd.WifiDisplaySettings.WifiDisplayBasePreference
        protected void setItemClick(OCardListItem r2) {
            r2.setOnContentClickListener(new WifiDisplaySettings$RoutePreference$$ExternalSyntheticLambda0(this));
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r2) {
            WifiDisplaySettings.access$3000(this.this$0, this.mRoute, this);
            return true;
        }

        @Override // com.bytedance.wirelesscast.SmtLinkInfo.OnConnectedListener
        public void disconnect() {
            if (this.mRoute.isSelected() == true) goto L5;
            return;
        L5:
            if (this.mRoute.isBluetooth() == false) goto L7;
            WifiDisplaySettings.access$3100(this.this$0).getDefaultRoute().select();
            return;
        L7:
            WifiDisplaySettings.access$3100(this.this$0).getFallbackRoute().select();
        }
    }

    private static class UIHandler extends Handler {
        private WeakReference<WifiDisplaySettings> mReference;

        UIHandler(WifiDisplaySettings r2) {
            this.mReference = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            WifiDisplaySettings r2 = this.mReference.get();
            if (r2 != null) goto L5;
            return;
        L5:
            int r0 = r3.what;
            if (r0 != 100) goto L8;
            List r4 = (List) r3.obj;
            WifiDisplaySettings.access$500(r2).clear();
            if (r4 != null) goto L17;
        L19:
            WifiDisplaySettings.access$600(r2, 8);
            return;
        L17:
            if (r4.isEmpty() == true) goto L19;
            WifiDisplaySettings.access$500(r2).addAll(r4);
            goto L19
        L8:
            if (r0 == 101) goto L11;
            return;
        L11:
            if (WifiDisplaySettings.access$100(r2) == false) goto L13;
            WifiDisplaySettings.access$800(r2);
            return;
        L13:
            WifiDisplaySettings.access$200(r2, false);
        }
    }

    private class UnpairedWifiDisplayPreference extends WifiDisplayBasePreference implements Preference.OnPreferenceClickListener {
        private final WifiDisplay mDisplay;
        final /* synthetic */ WifiDisplaySettings this$0;

        protected int getDeviceIconRes() {
            return 0;
        }

        public UnpairedWifiDisplayPreference(WifiDisplaySettings r2, Context r3, WifiDisplay r4) {
            this.this$0 = r2;
            super(r2, r3, null);
            this.mDisplay = r4;
            setTitle(r4.getFriendlyDisplayName());
            Class<?> r5 = Class.forName("com.android.internal.R$string");     // Catch: Throwable -> L5
            Object r6 = r5.newInstance();     // Catch: Throwable -> L5
            setSummary(r5.getField("wireless_display_route_description").getInt(r6));     // Catch: Throwable -> L5
        L7:
            setEnabled(r4.canConnect());
            if (isEnabled() == false) goto L10;
            setOrder(3);
            return;
        L10:
            setOrder(4);
            setSummary(R.string.wifi_display_status_in_use);
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
            goto L7
        }

        @Override // com.android.settings.wfd.WifiDisplaySettings.WifiDisplayBasePreference
        protected void setItemClick(OCardListItem r2) {
            super.setItemClick(r2);
            r2.setOnContentClickListener(new WifiDisplaySettings$UnpairedWifiDisplayPreference$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$setItemClick$0$com-android-settings-wfd-WifiDisplaySettings$UnpairedWifiDisplayPreference, reason: not valid java name */
        /* synthetic */ void m649xc1059a12(View r1) {
            WifiDisplaySettings.access$3400(this.this$0, this.mDisplay);
        }

        @Override // androidx.preference.Preference.OnPreferenceClickListener
        public boolean onPreferenceClick(Preference r1) {
            WifiDisplaySettings.access$3400(this.this$0, this.mDisplay);
            return true;
        }
    }

    private class WifiDisplayBasePreference extends Preference {
        protected ImageView mDetail;
        private ImageView mIcon;
        protected OCardListItem mItemContainer;
        private String mSummary;
        private int mSummaryRes;
        private String mTitle;
        protected int position;
        final /* synthetic */ WifiDisplaySettings this$0;
        protected int totalCount;

        protected void setItemClick(OCardListItem r1) {
        }

        /* synthetic */ WifiDisplayBasePreference(WifiDisplaySettings r1, Context r2, AnonymousClass1 r3) {
            this(r1, r2);
        }

        private WifiDisplayBasePreference(WifiDisplaySettings r1, Context r2) {
            this.this$0 = r1;
            super(r2);
            setLayoutResource(R.layout.wifi_display_base_preference);
        }

        @Override // androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r2) {
            super.onBindViewHolder(r2);
            OCardListItem r3 = (OCardListItem) r2.itemView.findViewById(R.id.list_item_container);
            this.mItemContainer = r3;
            if (r3 == null) goto L5;
            r3.setCardPosition(getCardPosition());
            this.mItemContainer.showCustomEnd(false);
        L5:
            setItemClick(this.mItemContainer);
            if (this.mTitle.isEmpty() == true) goto L9;
            this.mItemContainer.setTitle(this.mTitle);
        L9:
            if (this.mSummary.isEmpty() == true) goto L11;
            this.mItemContainer.setSubTitle(this.mSummary);
        L11:
            int r4 = this.mSummaryRes;
            if (r4 == 0) goto L15;
            this.mItemContainer.setSubTitle(this.this$0.getString(r4));
            return;
        }

        private int getCardPosition() {
            int r0 = this.totalCount;
            if (r0 != 1) goto L6;
            return 0;
        L6:
            int r2 = this.position;
            if (r2 != 0) goto L10;
            return 1;
        L10:
            if (r2 != (r0 - 1)) goto L13;
            return 3;
        L13:
            return 2;
        }

        @Override // androidx.preference.Preference
        public void setTitle(CharSequence r2) {
            super.setTitle(r2);
            this.mTitle = r2.toString();
            OCardListItem r1 = this.mItemContainer;
            if (r1 == null) goto L6;
            r1.setTitle(r2);
            return;
        }

        @Override // androidx.preference.Preference
        public void setSummary(CharSequence r2) {
            super.setSummary(r2);
            this.mSummary = r2.toString();
            OCardListItem r1 = this.mItemContainer;
            if (r1 == null) goto L6;
            r1.setSubTitle(r2);
            return;
        }

        @Override // androidx.preference.Preference
        public void setSummary(int r2) {
            super.setSummary(r2);
            this.mSummaryRes = r2;
            OCardListItem r0 = this.mItemContainer;
            if (r0 == null) goto L6;
            r0.setSubTitle(this.this$0.getString(r2));
            return;
        }

        public void setBackgroundStyle(int r1) {
            notifyChanged();
        }
    }

    private class WifiDisplayRoutePreference extends RoutePreference implements View.OnClickListener {
        private final WifiDisplay mDisplay;
        final /* synthetic */ WifiDisplaySettings this$0;

        protected int getDeviceIconRes() {
            return 0;
        }

        public WifiDisplayRoutePreference(WifiDisplaySettings r1, Context r2, MediaRouter.RouteInfo r3, WifiDisplay r4, int r5, int r6) {
            this.this$0 = r1;
            super(r1, r2, r3);
            this.position = r5;
            this.totalCount = r6;
            this.mDisplay = r4;
        }

        @Override // com.android.settings.wfd.WifiDisplaySettings.WifiDisplayBasePreference, androidx.preference.Preference
        public void onBindViewHolder(PreferenceViewHolder r4) {
            super.onBindViewHolder(r4);
            View r5 = r4.itemView;
            if (this.mItemContainer == null) goto L8;
            ImageView r6 = new ImageView(this.this$0.getActivity());
            r6.setImageResource(R.drawable.ic_info_button_bold);
            r6.setOnClickListener(this);
            this.mItemContainer.setCustomEndView(r6);
            this.mItemContainer.showCustomEnd(true);
            int r0 = getPosition();
            this.mItemContainer.setCardPosition(r0);
            if (isEnabled() == true) goto L9;
            r6.setEnabled(true);
            return;
        L9:
            return;
        }

        private int getPosition() {
            if (this.totalCount != 1) goto L6;
            return 0;
        L6:
            if (this.position != 0) goto L9;
            return 1;
        L9:
            if (this.position != (this.totalCount - 1)) goto L11;
            return 3;
        L11:
            return 2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            WifiDisplaySettings.access$3200(this.this$0, this.mDisplay);
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment23
    protected int getHelpResource() {
        return R.string.help_url_remote_display;
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ IWirelessCastService access$000(WifiDisplaySettings r0) {
        return r0.mCastService;
    }

    static /* synthetic */ IWirelessCastService access$002(WifiDisplaySettings r0, IWirelessCastService r1) {
        r0.mCastService = r1;
        return r1;
    }

    static /* synthetic */ boolean access$100(WifiDisplaySettings r0) {
        return r0.mWifiDisplayOnSetting;
    }

    static /* synthetic */ View access$1000(WifiDisplaySettings r0) {
        return r0.mFooterView;
    }

    static /* synthetic */ boolean access$102(WifiDisplaySettings r0, boolean r1) {
        r0.mWifiDisplayOnSetting = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1100(WifiDisplaySettings r0) {
        return r0.isWifiDisplaySettingsAvailable();
    }

    static /* synthetic */ Context access$1200(WifiDisplaySettings r0) {
        return r0.mContext;
    }

    static /* synthetic */ SystemAlertDialog access$1300(WifiDisplaySettings r0) {
        return r0.mAlertDialog;
    }

    static /* synthetic */ SystemAlertDialog access$1302(WifiDisplaySettings r0, SystemAlertDialog r1) {
        r0.mAlertDialog = r1;
        return r1;
    }

    static /* synthetic */ OCardListItem access$1400(WifiDisplaySettings r0) {
        return r0.mWifiDisplay;
    }

    static /* synthetic */ ContentResolver access$1500(WifiDisplaySettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ long access$1600(WifiDisplaySettings r2) {
        return r2.mLastHanldeTime;
    }

    static /* synthetic */ ContentResolver access$1700(WifiDisplaySettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ boolean access$1800(WifiDisplaySettings r0) {
        return r0.isWifiApOn();
    }

    static /* synthetic */ DisplayManager access$1900(WifiDisplaySettings r0) {
        return r0.mDisplayManager;
    }

    static /* synthetic */ void access$200(WifiDisplaySettings r0, boolean r1) {
        r0.forceStopCastServiceIfNeeded(r1);
    }

    static /* synthetic */ boolean access$2000(WifiDisplaySettings r0) {
        return r0.mListen;
    }

    static /* synthetic */ boolean access$2002(WifiDisplaySettings r0, boolean r1) {
        r0.mListen = r1;
        return r1;
    }

    static /* synthetic */ void access$2100(WifiDisplaySettings r0, boolean r1) {
        r0.setListenMode(r1);
    }

    static /* synthetic */ boolean access$2200(WifiDisplaySettings r0) {
        return r0.mAutoGO;
    }

    static /* synthetic */ boolean access$2202(WifiDisplaySettings r0, boolean r1) {
        r0.mAutoGO = r1;
        return r1;
    }

    static /* synthetic */ void access$2300(WifiDisplaySettings r0) {
        r0.startAutoGO();
    }

    static /* synthetic */ void access$2400(WifiDisplaySettings r0) {
        r0.stopAutoGO();
    }

    static /* synthetic */ int access$2500(WifiDisplaySettings r0) {
        return r0.mPendingChanges;
    }

    static /* synthetic */ int access$2502(WifiDisplaySettings r0, int r1) {
        r0.mPendingChanges = r1;
        return r1;
    }

    static /* synthetic */ void access$2600(WifiDisplaySettings r0, int r1) {
        r0.scheduleUpdate(r1);
    }

    static /* synthetic */ ContentResolver access$2700(WifiDisplaySettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ boolean access$2800(WifiDisplaySettings r0) {
        return r0.isWifiDisplayOn();
    }

    static /* synthetic */ ICallback access$300(WifiDisplaySettings r0) {
        return r0.mCallback;
    }

    static /* synthetic */ void access$3000(WifiDisplaySettings r0, MediaRouter.RouteInfo r1, SmtLinkInfo.OnConnectedListener r2) {
        r0.toggleRoute(r1, r2);
    }

    static /* synthetic */ MediaRouter access$3100(WifiDisplaySettings r0) {
        return r0.mRouter;
    }

    static /* synthetic */ void access$3200(WifiDisplaySettings r0, WifiDisplay r1) {
        r0.launchWifiDisplayDetail(r1);
    }

    static /* synthetic */ boolean access$3300(WifiDisplaySettings r0, SmtLinkInfo r1) {
        return r0.disconnectSingle(r1);
    }

    static /* synthetic */ void access$3400(WifiDisplaySettings r0, WifiDisplay r1) {
        r0.pairWifiDisplay(r1);
    }

    static /* synthetic */ boolean access$402(WifiDisplaySettings r0, boolean r1) {
        r0.mIsBind = r1;
        return r1;
    }

    static /* synthetic */ List access$500(WifiDisplaySettings r0) {
        return r0.mLeLinkList;
    }

    static /* synthetic */ void access$600(WifiDisplaySettings r0, int r1) {
        r0.update(r1);
    }

    static /* synthetic */ boolean access$700(WifiDisplaySettings r0) {
        return r0.mStarted;
    }

    static /* synthetic */ void access$800(WifiDisplaySettings r0) {
        r0.bindServiceIfNeeded();
    }

    static /* synthetic */ Handler access$900(WifiDisplaySettings r0) {
        return r0.mHandler;
    }

    public WifiDisplaySettings() {
        this.mWpsConfig = 4;
        this.mLeLinkList = new ArrayList();
        this.mIsBind = false;
        this.mConnection = new AnonymousClass1(this);
        this.mCallback = new AnonymousClass2(this);
        this.mUpdateRunnable = new AnonymousClass14(this);
        this.mReceiver = new AnonymousClass15(this);
        final Handler r1 = new Handler();
        this.mSettingsObserver = new AnonymousClass16(this, r1);
        this.mRouterCallback = new AnonymousClass17(this);
        this.mHandler = new UIHandler(this);
    }

    private void bindServiceIfNeeded() {
        if (this.mIsBind == true) goto L6;
        OLog.d(TAG, "bind service");
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(PKG_WIRELESS_CAST, "com.bytedance.wirelesscast.WirelessCastService"));
        this.mIsBind = this.mContext.bindService(r0, this.mConnection, 1);
        this.mLastHanldeTime = SystemClock.uptimeMillis();
        return;
    }

    protected void unbindService() {
        IWirelessCastService r0 = this.mCastService;
        if (r0 == null) goto L11;
        if (r0.asBinder().isBinderAlive() == false) goto L11;
        this.mCastService.unregisterCallback(this.mCallback);     // Catch: RemoteException -> L8
    L8:
        e = move-exception;
        Slog.d(TAG, "unregisterCallback e" + e.toString());
    L11:
        if (this.mIsBind == false) goto L13;
        OLog.d(TAG, "unbind service");
        this.mContext.unbindService(this.mConnection);
        this.mIsBind = false;
        this.mLastHanldeTime = SystemClock.uptimeMillis();
    L13:
        this.mCastService = null;
        this.mLeLinkList.clear();
    }

    private void forceStopCastServiceIfNeeded(boolean r5) {
        IWirelessCastService r0 = this.mCastService;
        if (r0 != null) goto L13;
    L9:
        unbindService();
        if (r5 == false) goto L15;
        OLog.d(TAG, "force stop cast service!");
        Settings.Global.putString(getContentResolver(), "custom_key_wireless_cast_name", null);
        this.mAm.forceStopPackage(PKG_WIRELESS_CAST);
        return;
    L15:
        return;
    L13:
        if (r0.hasConnected() == false) goto L9;
        r5 = true;
    L7:
        e = move-exception;
        Slog.d(TAG, "unregisterCallback e" + e.toString());
        goto L9
    }

    public void com_android_settings_wfd_WifiDisplaySettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        FragmentActivity r5 = getActivity();
        this.mContext = r5;
        this.mRouter = (MediaRouter) r5.getSystemService("media_router");
        this.mDisplayManager = (DisplayManager) r5.getSystemService("display");
        WifiP2pManager r0 = (WifiP2pManager) r5.getSystemService("wifip2p");
        this.mWifiP2pManager = r0;
        this.mWifiP2pChannel = r0.initialize(r5, Looper.getMainLooper(), null);
        this.mAm = (ActivityManager) r5.getSystemService("activity");
        this.mWifiManager = (WifiManager) r5.getSystemService("wifi");
        this.mIncallTitles = getResources().getStringArray(R.array.wifi_display_incall_settings_titles);
        this.mReceivedSmsTitles = getResources().getStringArray(R.array.wifi_display_received_sms_settings_titles);
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
        super.onCreatePreferences(r1, r2);
        addPreferencesFromResource(R.xml.wifi_display_settings);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        setupWifiDisplaySwitch();
        setupWifiDisplaySettings();
    }

    private void setupWifiDisplaySwitch() {
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.wifi_display_setting_switch_layout, getListView(), false);
        this.mWifiDisplay = (OCardListItem) r0.findViewById(R.id.wifi_display_switch);
        this.mWifiDisplaySwitchSupportiveText = (OSectionSupportiveText) r0.findViewById(R.id.wifi_display_switch_supportive_text_tips);
        if (WifiDisplaySettingsFragment.mFromWifi == true) goto L5;
        this.mWifiDisplay.setTitle(this.mContext.getResources().getString(R.string.wifi_tnt_settings_title));
    L5:
        WifiManager r1 = this.mWifiManager;
        if (r1 == null) goto L8;
        this.mWifiDisplay.setEnabled(r1.isWifiEnabled());
    L8:
        SectionLayoutPreference r2 = new SectionLayoutPreference(getContext(), r0);
        this.mHeaderPreference = r2;
        r2.setSelectable(false);
        this.mHeaderPreference.setOrder(0);
        getPreferenceScreen().addPreference(this.mHeaderPreference);
        RecyclerView r5 = getListView();
        r5.setItemAnimator(null);
        r5.setOverScrollMode(0);
        ViewSmt.getInstance().setClipToBounds(r5, false);
        r5.setClipToPadding(false);
        r5.setClipChildren(false);
    }

    private void setupWifiDisplaySettings() {
        int r3 = 0;
        View r0 = LayoutInflater.from(getActivity()).inflate(R.layout.wifi_display_settings_footer_view, getListView(), false);
        this.mFooterView = r0;
        ListContentItemText r1 = (ListContentItemText) r0.findViewById(R.id.incall_settings);
        this.mIncallSetting = r1;
        r1.setOnClickListener(this);
        ListContentItemText r2 = (ListContentItemText) this.mFooterView.findViewById(R.id.received_sms_settings);
        this.mSmsSetting = r2;
        r2.setOnClickListener(this);
        View r4 = this.mFooterView;
        if (isWifiDisplaySettingsAvailable() == true) goto L6;
        r3 = 8;
    L6:
        r4.setVisibility(r3);
        RecyclerView r5 = getListView();
        if (this.mFooterView.getParent() != null) goto L10;
        ((ViewGroup) r5.getParent()).addView(this.mFooterView);
        return;
    }

    private boolean isWifiDisplaySettingsAvailable() {
        if (isWifiDisplayOn() == true) goto L5;
        return false;
    L5:
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.ODIN, DeviceType.M1, DeviceType.M1L}) == true) goto L7;
        return false;
    L7:
        return true;
    }

    private void setWifiDisplaySettingsSubtitle() {
        this.mIncallSetting.setSubtitle(this.mIncallTitles[getWifiDisplayIncallSettingValue()]);
        this.mSmsSetting.setSubtitle(this.mReceivedSmsTitles[getWifiDisplayRecevedSmsSettingValue()]);
    }

    private boolean isWifiDisplayOn() {
        if (Settings.Global.getInt(getContentResolver(), "wifi_display_on", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int getWifiDisplayIncallSettingValue() {
        return Settings.Global.getInt(getContentResolver(), "wifi_display_while_incall", 2);
    }

    private int getWifiDisplayRecevedSmsSettingValue() {
        return Settings.Global.getInt(getContentResolver(), "wifi_display_while_receive_sms", 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r8) {
        if (r8 != this.mIncallSetting) goto L6;
        Utils.launchOptionsActivity(getActivity(), new OptionsInfo(this.mIncallTitles, new Integer[]{0, 1, 2}, OptionsInfo.SaveTargetTable.Global, "wifi_display_while_incall"), String.valueOf(getWifiDisplayIncallSettingValue()), this.mIncallSetting.getTitle().toString(), R.string.wifi_display_settings_title);
        return;
    L6:
        if (r8 != this.mSmsSetting) goto L12;
        OptionsInfo r0 = new OptionsInfo(this.mReceivedSmsTitles, new Integer[]{0, 1}, OptionsInfo.SaveTargetTable.Global, "wifi_display_while_receive_sms");
        CharSequence r9 = this.mSmsSetting.getTitle();
        if (r9 == null) goto L13;
        Utils.launchOptionsActivity(getActivity(), r0, String.valueOf(getWifiDisplayRecevedSmsSettingValue()), r9.toString(), R.string.wifi_display_settings_title);
        return;
    L13:
        return;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        Context r1 = (Context) NullSafe.nonNull(getActivity());
        IntentFilter r2 = new IntentFilter();
        r2.addAction("android.hardware.display.action.WIFI_DISPLAY_STATUS_CHANGED");
        r2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, this.mReceiver, r2, 2);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("wifi_display_on"), false, this.mSettingsObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("wifi_display_certification_on"), false, this.mSettingsObserver);
        getContentResolver().registerContentObserver(Settings.Global.getUriFor("wifi_display_wps_config"), false, this.mSettingsObserver);
        this.mRouter.addCallback(4, this.mRouterCallback, 1);
        update(-1);
        if (this.mWifiDisplayOnSetting == false) goto L6;
        bindServiceIfNeeded();
        return;
    }

    public void com_android_settings_wfd_WifiDisplaySettings__onResume$___twin___() {
        super.onResume();
        setWifiDisplaySettingsSubtitle();
        this.mWifiDisplay.getEndSwitch().setChecked(isWifiDisplayOn());
        this.mWifiDisplay.getEndSwitch().setOnCheckedChangeListener(new AnonymousClass3(this));
    }

    @Override // com.android.settings.SettingsPreferenceFragment23, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mStarted = false;
        unbindService();
        getActivity().unregisterReceiver(this.mReceiver);
        getContentResolver().unregisterContentObserver(this.mSettingsObserver);
        this.mRouter.removeCallback(this.mRouterCallback);
        unscheduleUpdate();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        if (this.mWifiDisplayOnSetting == true) goto L5;
        forceStopCastServiceIfNeeded(true);
    L5:
        Handler r0 = this.mHandler;
        if (r0 == null) goto L8;
        r0.removeCallbacksAndMessages(null);
    L8:
        super.onDestroy();
    }

    private void scheduleUpdate(int r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L6;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return;
    L6:
        if (this.mPendingChanges != 0) goto L8;
        this.mHandler.post(this.mUpdateRunnable);     // Catch: Throwable -> L11
    L8:
        this.mPendingChanges = r3 | this.mPendingChanges;     // Catch: Throwable -> L11
        goto L9
    }

    private void unscheduleUpdate() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingChanges == 0) goto L6;
        this.mPendingChanges = 0;     // Catch: Throwable -> L8
        this.mHandler.removeCallbacks(this.mUpdateRunnable);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
    }

    private void update(int r12) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if ((r12 & 1) != 0) goto L8;
        boolean r0 = false;
    L18:
        if ((r12 & 4) == 0) goto L21;
        this.mWifiDisplayStatus = this.mDisplayManager.getWifiDisplayStatus();
        r0 = true;
    L21:
        if ((r12 & 8) == 0) goto L23;
        r0 = true;
    L23:
        PreferenceScreen r13 = getPreferenceScreen();
        if (this.mPreferencesList == null) goto L83;
    L29:
        removeItemPreference(r13);
        int r3 = this.mRouter.getRouteCount();
        int r4 = 0;
        int r6 = 0;
    L30:
        if (r4 >= r3) goto L35;
        if (this.mRouter.getRouteAt(r4).matchesTypes(4) == false) goto L34;
        r6 = r6 + 1;
    L34:
        r4 = r4 + 1;
        goto L30
    L35:
        int r5 = 0;
        int r7 = 0;
    L36:
        if (r5 >= r3) goto L41;
        MediaRouter.RouteInfo r8 = this.mRouter.getRouteAt(r5);
        if (r8.matchesTypes(4) == false) goto L40;
        OLog.e(TAG, "update: position =" + r5 + "  totalCount=" + r3);
        r13.addPreference(createRoutePreference(r8, r7, r6));
        r7 = r7 + 1;
    L40:
        r5 = r5 + 1;
        goto L36
    L41:
        WifiDisplayStatus r1 = this.mWifiDisplayStatus;
        if (r1 == null) goto L57;
        if (r1.getFeatureState() != 3) goto L57;
        int r9 = 0;
    L47:
        if (r9 >= this.mWifiDisplayStatus.getDisplays().length) goto L57;
        WifiDisplay r10 = this.mWifiDisplayStatus.getDisplays()[r9];
        if (r10.isRemembered() == true) goto L55;
        if (r10.isAvailable() == false) goto L55;
        if (r10.equals(this.mWifiDisplayStatus.getActiveDisplay()) == true) goto L55;
        UnpairedWifiDisplayPreference r11 = new UnpairedWifiDisplayPreference(this, getActivity(), r10);
        r11.position = r9;
        r11.totalCount = this.mWifiDisplayStatus.getDisplays().length;
        r13.addPreference(r11);
    L55:
        r9 = r9 + 1;
    L57:
        if (this.mWifiDisplayOnSetting == true) goto L59;
    L64:
        int r14 = r13.getPreferenceCount();
        OLog.i(TAG, "update, count:" + r14);
    L65:
        if (r2 >= r14) goto L75;
        Preference r15 = r13.getPreference(r2);
        if ((r15 instanceof WifiDisplayBasePreference) == false) goto L73;
        WifiDisplayBasePreference r16 = (WifiDisplayBasePreference) r15;
        if (this.mHeaderPreference != null) goto L71;
        int r17 = r14;
    L72:
        r16.totalCount = r17;
        goto L73
    L71:
        r17 = r14 - 1;
    L73:
        r2 = r2 + 1;
        goto L65
    L75:
        if (WifiDisplaySettingsFragment.mFromWifi == false) goto L77;
        this.mWifiDisplaySwitchSupportiveText.setSectionDes(getString(R.string.wifi_display_settings_title_tips));
    L78:
        if (r0 == true) goto L80;
        return;
    L80:
        if (getActivity() == null) goto L101;
        getActivity().invalidateOptionsMenu();
        return;
    L101:
        return;
    L77:
        this.mWifiDisplaySwitchSupportiveText.setSectionDes(getString(R.string.wifi_tnt_settings_title_tips));
        goto L78
    L59:
        if (this.mLeLinkList.isEmpty() == true) goto L64;
        Iterator<SmtLinkInfo> r18 = this.mLeLinkList.iterator();
    L62:
        if (r18.hasNext() == false) goto L64;
        r13.addPreference(new LeLinkDisplayPreference(this, getActivity(), r18.next()));
        goto L62
    L83:
        Field r19 = r13.getClass().getSuperclass().getDeclaredField("mPreferences");     // Catch: Throwable -> L27
        r19.setAccessible(true);     // Catch: Throwable -> L27
        this.mPreferencesList = (List) r19.get(r13);     // Catch: Throwable -> L27
    L27:
        e = move-exception;
        OLog.e(TAG, "display getlist error", e);
        goto L29
    L8:
        if (Settings.Global.getInt(getContentResolver(), "wifi_display_on", 0) == 0) goto L10;
        boolean r20 = true;
    L11:
        this.mWifiDisplayOnSetting = r20;
        if (Settings.Global.getInt(getContentResolver(), "wifi_display_certification_on", 0) == 0) goto L14;
        boolean r21 = true;
    L15:
        this.mWifiDisplayCertificationOn = r21;
        this.mWpsConfig = Settings.Global.getInt(getContentResolver(), "wifi_display_wps_config", 4);
        r0 = true;
        goto L18
    L14:
        r21 = false;
        goto L15
    L10:
        r20 = false;
        goto L11
    }

    private void removeItemPreference(PreferenceScreen r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r5.getPreferenceCount()) goto L9;
        Preference r2 = r5.getPreference(r1);
        if (r2 == this.mHeaderPreference) goto L8;
        r0.add(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        Iterator r4 = r0.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        r5.removePreference((Preference) r4.next());
        goto L11
    }

    private RoutePreference createRoutePreference(MediaRouter.RouteInfo r9, int r10, int r11) {
        WifiDisplay r5 = findWifiDisplay(r9.getDeviceAddress());
        if (r5 == null) goto L7;
        return new WifiDisplayRoutePreference(this, getActivity(), r9, r5, r10, r11);
    L7:
        return new RoutePreference(this, getActivity(), r9);
    }

    private WifiDisplay findWifiDisplay(String r5) {
        WifiDisplayStatus r4 = this.mWifiDisplayStatus;
        if (r4 == null) goto L11;
        if (r5 == null) goto L15;
        WifiDisplay[] r6 = r4.getDisplays();
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L16;
        WifiDisplay r2 = r6[r1];
        if (r2.getDeviceAddress().equals(r5) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return r2;
    L16:
        return null;
    L15:
        return null;
    L11:
        return null;
    }

    private void buildCertificationMenu(PreferenceScreen r11) {
        PreferenceGroup r0 = this.mCertCategory;
        if (r0 != null) goto L5;
        PreferenceCategory r1 = new PreferenceCategory(getActivity());
        this.mCertCategory = r1;
        r1.setTitle(R.string.wifi_display_certification_heading);
        this.mCertCategory.setOrder(1);
    L6:
        r11.addPreference(this.mCertCategory);
        if (this.mWifiDisplayStatus.getSessionInfo().getGroupId().isEmpty() == true) goto L11;
        Preference r12 = new Preference(getActivity());
        r12.setTitle(R.string.wifi_display_session_info);
        r12.setSummary(this.mWifiDisplayStatus.getSessionInfo().toString());
        this.mCertCategory.addPreference(r12);
        if (this.mWifiDisplayStatus.getSessionInfo().getSessionId() == 0) goto L11;
        LayoutPreference r13 = new LayoutPreference(getActivity(), R.layout.two_buttons_panel);
        OButton r2 = (OButton) r13.findViewById(R.id.left_button);
        r2.setText(R.string.wifi_display_pause);
        r2.setOnClickListener(new AnonymousClass4(this));
        OButton r3 = (OButton) r13.findViewById(R.id.right_button);
        r3.setText(R.string.wifi_display_resume);
        r3.setOnClickListener(new AnonymousClass5(this));
        this.mCertCategory.addPreference(r13);
    L11:
        final FragmentActivity r4 = getActivity();
        CheckBoxPreference r14 = new AnonymousClass6(this, r4);
        r14.setTitle(R.string.wifi_display_listen_mode);
        r14.setChecked(this.mListen);
        this.mCertCategory.addPreference(r14);
        final FragmentActivity r5 = getActivity();
        CheckBoxPreference r15 = new AnonymousClass7(this, r5);
        r15.setTitle(R.string.wifi_display_autonomous_go);
        r15.setChecked(this.mAutoGO);
        this.mCertCategory.addPreference(r15);
        ListPreference r16 = new ListPreference(getActivity());
        this.mWpsConfig = Settings.Global.getInt(getActivity().getContentResolver(), "wifi_display_wps_config", 4);
        String[] r6 = {"4", "0", ExifInterface.GPS_MEASUREMENT_2D, "1"};
        r16.setTitle(R.string.wifi_display_wps_config);
        r16.setEntries(new String[]{"Default", "PBC", "KEYPAD", "DISPLAY"});
        r16.setEntryValues(r6);
        r16.setValue("" + this.mWpsConfig);
        r16.setSummary("%1$s");
        r16.setOnPreferenceChangeListener(new WifiDisplaySettings$$ExternalSyntheticLambda0(this));
        this.mCertCategory.addPreference(r16);
        ListPreference r17 = new ListPreference(getActivity());
        String[] r7 = {"Auto", "1", "6", CommonServiceName.CRONET_ERROR_CODE_CANCEL};
        String[] r8 = {"0", "1", "6", CommonServiceName.CRONET_ERROR_CODE_CANCEL};
        r17.setTitle(R.string.wifi_display_listen_channel);
        r17.setEntries(r7);
        r17.setEntryValues(r8);
        r17.setValue("" + this.mListenChannel);
        r17.setSummary("%1$s");
        r17.setOnPreferenceChangeListener(new WifiDisplaySettings$$ExternalSyntheticLambda1(this));
        this.mCertCategory.addPreference(r17);
        ListPreference r18 = new ListPreference(getActivity());
        String[] r9 = {"Auto", "1", "6", CommonServiceName.CRONET_ERROR_CODE_CANCEL, "36"};
        String[] r10 = {"0", "1", "6", CommonServiceName.CRONET_ERROR_CODE_CANCEL, "36"};
        r18.setTitle(R.string.wifi_display_operating_channel);
        r18.setEntries(r9);
        r18.setEntryValues(r10);
        r18.setValue("" + this.mOperatingChannel);
        r18.setSummary("%1$s");
        r18.setOnPreferenceChangeListener(new WifiDisplaySettings$$ExternalSyntheticLambda2(this));
        this.mCertCategory.addPreference(r18);
        return;
    L5:
        r0.removeAll();
        goto L6
    }

    /* JADX INFO: renamed from: lambda$buildCertificationMenu$0$com-android-settings-wfd-WifiDisplaySettings, reason: not valid java name */
    /* synthetic */ boolean m644x5356b9a8(Preference r2, Object r3) {
        this.mWpsConfig = Integer.parseInt(String.valueOf(r3));
        ((ListPreference) r2).setValue(String.valueOf(r3));
        r2.setSummary("%1$s");
        getActivity().invalidateOptionsMenu();
        Settings.Global.putInt(getActivity().getContentResolver(), "wifi_display_wps_config", this.mWpsConfig);
        return false;
    }

    /* JADX INFO: renamed from: lambda$buildCertificationMenu$1$com-android-settings-wfd-WifiDisplaySettings, reason: not valid java name */
    /* synthetic */ boolean m645xcce4747(Preference r2, Object r3) {
        this.mListenChannel = Integer.parseInt(String.valueOf(r3));
        ((ListPreference) r2).setValue(String.valueOf(r3));
        r2.setSummary("%1$s");
        getActivity().invalidateOptionsMenu();
        setWifiP2pChannels(this.mListenChannel, this.mOperatingChannel);
        return false;
    }

    /* JADX INFO: renamed from: lambda$buildCertificationMenu$2$com-android-settings-wfd-WifiDisplaySettings, reason: not valid java name */
    /* synthetic */ boolean m646xc645d4e6(Preference r2, Object r3) {
        this.mOperatingChannel = Integer.parseInt(String.valueOf(r3));
        ((ListPreference) r2).setValue(String.valueOf(r3));
        r2.setSummary("%1$s");
        getActivity().invalidateOptionsMenu();
        setWifiP2pChannels(this.mListenChannel, this.mOperatingChannel);
        return false;
    }

    private void startAutoGO() {
        this.mWifiP2pManager.createGroup(this.mWifiP2pChannel, new AnonymousClass8(this));
    }

    private void stopAutoGO() {
        this.mWifiP2pManager.removeGroup(this.mWifiP2pChannel, new AnonymousClass9(this));
    }

    private void setListenMode(final boolean r3) {
        WifiP2pManager.ActionListener r0 = new AnonymousClass10(this, r3);
        if (r3 == true) goto L5;
        this.mWifiP2pManager.stopListening(this.mWifiP2pChannel, r0);
        return;
    L5:
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) goto L7;
    L10:
        OLog.d(TAG, "setListenMode: permission denied");
        return;
    L7:
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.NEARBY_WIFI_DEVICES") != 0) goto L10;
        this.mWifiP2pManager.startListening(this.mWifiP2pChannel, r0);
    }

    private void setWifiP2pChannels(int r4, int r5) {
        this.mWifiP2pManager.setWifiP2pChannels(this.mWifiP2pChannel, r4, r5, new AnonymousClass11(this));
    }

    private void toggleRoute(MediaRouter.RouteInfo r2, SmtLinkInfo.OnConnectedListener r3) {
        if (r2.isSelected() == false) goto L5;
        showRouteDialogFragment(r2.getName().toString(), r3);
        return;
    L5:
        r2.select();
    }

    private void pairWifiDisplay(WifiDisplay r2) {
        if (r2.canConnect() == false) goto L6;
        disconnectAll();
        this.mDisplayManager.connectWifiDisplay(r2.getDeviceAddress());
        return;
    }

    private void showWifiDisplayOptionsDialog(final WifiDisplay r4) {
        View r0 = getActivity().getLayoutInflater().inflate(R.layout.wifi_display_options, null);
        final EditText r1 = (EditText) r0.findViewById(R.id.name);
        r1.setText(r4.getFriendlyDisplayName());
        DialogInterface.OnClickListener r2 = new AnonymousClass12(this, r1, r4);
        DialogInterface.OnClickListener r3 = new AnonymousClass13(this, r4);
        new AlertDialog.Builder(getActivity()).setCancelable(true).setTitle(R.string.wifi_display_options_title).setView(r0).setPositiveButton(R.string.wifi_display_options_done, r2).setNegativeButton(R.string.wifi_display_options_forget, r3).create().show();
    }

    private void launchWifiDisplayDetail(WifiDisplay r4) {
        Intent r0 = new Intent(getActivity(), WifiDisplayDetailActivity.class);
        r0.putExtra(WifiDisplayDetail.EXTRA_WIFI_DISPLAY, r4);
        r0.putExtra("back_text_id", R.string.wifi_display_settings_title);
        Utils.startActivity(getActivity(), r0);
    }

    private DialogFragment showRouteDialogFragment(String r3, SmtLinkInfo.OnConnectedListener r4) {
        FragmentManager r2 = getFragmentManager();
        if (r2.findFragmentByTag(CONTROLLER_LEBO_FRAGMENT_TAG) == null) goto L6;
        OLog.i(TAG, "showDialog(): Route dialog already showing!");
        return null;
    L6:
        LeBoControllerDialogFragment r1 = new LeBoControllerDialogFragment(r3, r4);
        r1.show(r2, CONTROLLER_LEBO_FRAGMENT_TAG);
        return r1;
    }

    private boolean disconnectAll() {
        boolean r1 = false;
        if (this.mCastService != null) goto L5;
        return false;
    L5:
        Iterator<SmtLinkInfo> r0 = this.mLeLinkList.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r1 = r1 | disconnectSingle(r0.next());
        goto L7
    L9:
        return r1;
    }

    private boolean disconnectSingle(SmtLinkInfo r4) {
        if (this.mCastService == null) goto L13;
        if (r4 == null) goto L13;
        if (r4.isConnect() == false) goto L13;
        OLog.d(TAG, "disconnect: " + r4);
        this.mCastService.disConnectService(r4);     // Catch: RemoteException -> L11
        return true;
    L11:
        e = move-exception;
        Slog.d(TAG, "disconnect error" + e.toString());
    L13:
        return false;
    }

    public DialogFragment showLeBoDialogFragment(SmtLinkInfo r3, SmtLinkInfo.OnConnectedListener r4) {
        FragmentManager r2 = getFragmentManager();
        if (r2.findFragmentByTag(CONTROLLER_LEBO_FRAGMENT_TAG) == null) goto L6;
        OLog.w(TAG, "showDialog(): Route controller lebo dialog already showing!");
        return null;
    L6:
        LeBoControllerDialogFragment r1 = new LeBoControllerDialogFragment(r3.getName(), r4);
        r1.show(r2, CONTROLLER_LEBO_FRAGMENT_TAG);
        return r1;
    }

    private boolean isWifiApOn() {
        WifiManager r0 = this.mWifiManager;
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.isWifiApEnabled();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(WifiDisplaySettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wfd_WifiDisplaySettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(WifiDisplaySettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_wfd_WifiDisplaySettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(WifiDisplaySettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_wfd_WifiDisplaySettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
