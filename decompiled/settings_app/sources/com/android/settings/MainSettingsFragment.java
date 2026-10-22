package com.android.settings;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.telephony.TelephonyCallback;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewInfo;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.android.settings.accounts.OAccountHelper;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.base.TransactionType;
import com.android.settings.bluetooth.BluetoothSettingsActivity;
import com.android.settings.bluetooth.LocalBluetoothManager;
import com.android.settings.intelligent.DoubaoAssistantEnabler;
import com.android.settings.search.SearchFragment;
import com.android.settings.servicemanager.IEmergencyHelp;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.teaevent.TrackerEvent;
import com.android.settings.utils.DevicePolicyUtils;
import com.android.settings.utils.SmtTntUtil;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.wifi.CacheMgr;
import com.android.settings.wifi.WifiSettingsActivity;
import com.android.settingslib.drawer.CategoryKey;
import com.android.settingslib.drawer.DashboardCategory;
import com.android.settingslib.drawer.Tile;
import com.android.wifitrackerlib.WifiPickerTracker;
import com.bytedance.apm.trace.fps.FpsTracer;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.google.common.net.HttpHeaders;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.account.api.IAccountStatusListener;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.time.Clock;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import org.apache.commons.math3.geometry.VectorFormat;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: classes2.dex */
public class MainSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener, LifecycleOwner {
    private static final String ACTION_SEARCH = "com.bytedanceos.action.SEARCH";
    private static final long DELAY_TIME_UPDATE_LISTVIEW = 100;
    private static final int ID_ABOUT_NEW = 20;
    public static final int ID_ACCOUNT_MODE = 0;
    private static final int ID_ADVANCED = 18;
    private static final int ID_AIRPLANE_MODE = 2;
    private static final int ID_APPLICATION = 14;
    private static final int ID_BATTERY = 15;
    private static final int ID_BLUETOOTH = 5;
    private static final int ID_BRIGHTNESS = 10;
    private static final int ID_CELLULAR = 4;
    private static final int ID_DASHBOARD = 10000;
    private static final int ID_DESKTOP = 8;
    private static final int ID_EMERGENCY = 21;
    private static final int ID_LAUNCHER = 9;
    private static final int ID_LOCATION = 22;
    private static final int ID_LOCKSCREEN = 12;
    private static final int ID_MULTI_SIM = 6;
    private static final int ID_NETWORK = 7;
    private static final int ID_NOTIFICATION = 17;
    private static final int ID_OTA = 19;
    private static final int ID_PERMISSION = 13;
    private static final int ID_SOUND = 11;
    private static final int ID_STORAGE = 16;
    private static final int ID_SYSTEM_INTELLIGENT_MODE = 1;
    private static final int ID_WLAN = 3;
    private static final long MAX_SCAN_AGE_MILLIS = 15000;
    private static final int MSG_UPDATE_WIFI_ITEM_VIEW = 1;
    private static final long SCAN_INTERVAL_MILLIS = 10000;
    private static final int SEARCH_BUTTON_ID = 4999;
    public static final String SETTINGS_NETWORK_PERMISSION_GRANTED = "settings_network_permission_granted";
    private static final int TYPE_ITEM_SWITCH = 0;
    private static final int TYPE_ITEM_TEXT = 1;
    private IntentFilter bluetoothFilter;
    private final CellularCallback cellularCallback;
    private long coldStartTime;
    LifecycleRegistry lifecycle;
    private LocalBluetoothManager localBtManager;
    private SettingItem mAboutNew;
    private SettingItem mAccount;
    private IAccountStatusListener mAccountStatusListener;
    private SettingsAdapter mAdapter;
    private SettingItem mAdvanced;
    private SystemAlertDialog mAirPlanModeDialog;
    private SettingItem mAirplaneMode;
    private AirplaneModeEnablerEx mAirplaneModeEnabler;
    private final ContentObserver mAirplaneModeObserver;
    private OFloatingTitleBar mAppBar;
    private SettingItem mApplication;
    private SettingItem mBattery;
    private SettingItem mBluetooth;
    private BroadcastReceiver mBluetoothReceiver;
    private SettingItem mBrightness;
    private SettingItem mCellular;
    private CellularEnabler mCellularEnabler;
    private SettingItem mDesktop;
    private SettingItem mEmergency;
    private FpsTracer mFpsTracer;
    private Handler mHandler;
    private SettingItem mLauncher;
    private RecyclerView mListview;
    private SettingItem mLocation;
    private SettingItem mLockscreen;
    private Handler mMainHandler;
    private SettingItem mMultiSim;
    private SettingItem mNetwork;
    private SettingItem mNotification;
    private SettingItem mOta;
    private SettingItem mPermission;
    private HandInHandProcessor mProcessor;
    private View mSearchView;
    private ArrayList<SettingItem> mSettingItems;
    private final BroadcastReceiver mSimStateChangedReceiver;
    private SettingItem mSound;
    private SettingItem mStorage;
    private boolean mSupportTelephonyFeature;
    private SettingItem mSystemIntelligent;
    WifiPickerTracker mWifiPickerTracker;
    private HandlerThread mWifiPickerTrackerWorkerThread;
    private SettingItem mWlan;
    private Handler mWorkerHandler;
    private BroadcastReceiver networkStateChangedReceiver;
    private WifiManager wifiManager;

    /* JADX INFO: renamed from: com.android.settings.MainSettingsFragment$25, reason: invalid class name */
    static /* synthetic */ class AnonymousClass25 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settingslib$drawer$Tile$Type = null;

        static {
            int[] r0 = new int[Tile.Type.values().length];
            $SwitchMap$com$android$settingslib$drawer$Tile$Type = r0;
            r0[Tile.Type.EXTERNAL_ACTION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.ACTION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.SWITCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.SWITCH_WITH_ACTION.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$com$android$settingslib$drawer$Tile$Type[Tile.Type.GROUP.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    private class CellularCallback extends TelephonyCallback implements TelephonyCallback.UserMobileDataStateListener {
        final /* synthetic */ MainSettingsFragment this$0;

        private CellularCallback(MainSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ CellularCallback(MainSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.telephony.TelephonyCallback.UserMobileDataStateListener
        public void onUserMobileDataStateChanged(boolean r1) {
            ThreadUtils.postOnMainThread(new MainSettingsFragment$CellularCallback$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onUserMobileDataStateChanged$0$com-android-settings-MainSettingsFragment$CellularCallback, reason: not valid java name */
        /* synthetic */ void m154xee1b9a89() {
            if (MainSettingsFragment.access$2100(this.this$0) != null) goto L5;
            return;
        L5:
            MainSettingsFragment.access$2100(this.this$0).updateSettingItemState();
            MainSettingsFragment.access$100(this.this$0).notifyItemChanged(MainSettingsFragment.access$2300(this.this$0).indexOf(MainSettingsFragment.access$2500(this.this$0)));
        }
    }

    class SettingItem {
        private int mCardType;
        boolean mChecked;
        boolean mEnable;
        int mIconRes;
        int mId;
        Intent mIntent;
        private int mPosition;
        boolean mShowItemTextBadge;
        String mSubTitle;
        String mTitle;
        int mTitleRes;
        int mType;
        private ViewInfo mViewInfo;
        final /* synthetic */ MainSettingsFragment this$0;

        public SettingItem(MainSettingsFragment r1, int r2, int r3, int r4, int r5) {
            this.this$0 = r1;
            this.mEnable = true;
            this.mPosition = 2;
            this.mCardType = 0;
            this.mId = r2;
            this.mType = r3;
            this.mIconRes = r4;
            this.mTitleRes = r5;
        }

        public void setViewInfo(int r3, int r4) {
            ViewInfo r0 = new ViewInfo();
            this.mViewInfo = r0;
            r0.title = this.this$0.getString(r3);
            ViewInfo r5 = this.mViewInfo;
            r5.content = this.this$0.getString(r4);
        }

        public void setPosition(int r1) {
            this.mPosition = r1;
        }

        public int getPosition() {
            return this.mPosition;
        }

        public void setCardType(int r1) {
            this.mCardType = r1;
        }

        public int getCardType() {
            return this.mCardType;
        }
    }

    public class SettingsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        final /* synthetic */ MainSettingsFragment this$0;

        public class SettingsMainViewHolder extends RecyclerView.ViewHolder {
            private OCardListItem cardView;
            final /* synthetic */ SettingsAdapter this$1;

            static /* synthetic */ OCardListItem access$2400(SettingsMainViewHolder r0) {
                return r0.cardView;
            }

            public SettingsMainViewHolder(SettingsAdapter r1, OCardListItem r2) {
                this.this$1 = r1;
                super(r2);
                this.cardView = r2;
            }

            private void fixLongTailTitleUI(OCardListItem r5, Context r6, String r7) {
                Configuration r4 = r6.getResources().getConfiguration();
                if (r4.densityDpi == 560) goto L5;
            L10:
                int r8 = 168;
            L12:
                if (r4.densityDpi == 640) goto L14;
            L22:
                r5.setEndDetailText(r7, UIUtils.INSTANCE.dp2px(r8));
                return;
            L14:
                if (r4.fontScale <= 1.2f) goto L17;
                r8 = 100;
                goto L22
            L17:
                if (r4.fontScale <= 1.0f) goto L20;
                r8 = 112;
                goto L22
            L20:
                if (r4.fontScale != 1.0f) goto L22;
                r8 = 120;
                goto L22
            L5:
                if (r4.fontScale <= 1.2f) goto L8;
                r8 = 132;
                goto L12
            L8:
                if (r4.fontScale <= 1.0f) goto L10;
                r8 = 140;
                goto L12
            }

            public void bindData(Context r5, final SettingItem r6, int r7) {
                this.cardView.setCardPosition(r6.getPosition());
                this.cardView.setCardType(r6.getCardType());
                this.cardView.setIcon(ContextCompat.getDrawable(r5, r6.mIconRes));
                OCardListItem r8 = this.cardView;
                if (r6.mTitle == null) goto L5;
                String r0 = r6.mTitle;
            L6:
                r8.setTitle(r0);
                this.cardView.showIcon(true);
                this.cardView.showTitle(true);
                if (r6.mType != 0) goto L13;
                this.cardView.setDefaultCustomEndView(1);
                this.cardView.showCustomEnd(true);
                View r9 = this.cardView.getCustomEndView();
                if ((r9 instanceof OSwitch) == false) goto L11;
                OSwitch r10 = (OSwitch) r9;
                r10.setId(r6.mId);
                r10.setClickable(true);
                r10.setChecked(r6.mChecked);
                r10.setOnCheckedChangeListener(this.this$1.this$0);
            L11:
                this.cardView.setOnContentClickListener(null);
                this.cardView.setEnabled(r6.mEnable);
                return;
            L13:
                if (r6.mType != 1) goto L45;
                this.cardView.setDefaultTailIcon(0);
                this.cardView.showTailIcon(true);
                if (r6.mId != 0) goto L18;
                AccountSettingHelper.INSTANCE.setupSettingItemView(r5, this.cardView, r6, this.this$1.this$0);
                this.cardView.showSubTitle(true);
                this.cardView.showCustomEnd(false);
            L32:
                if (r6.mId == 4) goto L38;
                if (r6.mId == 6) goto L38;
                this.cardView.setEnabled(r6.mEnable);
                return;
            L38:
                if (r6.mEnable == false) goto L40;
            L42:
                OCardListItemUtils.setContentContainerEnabled(this.cardView, r6.mEnable);
                this.cardView.setEnabled(r6.mEnable);
                return;
            L40:
                if (DevicePolicyUtils.hasUserRestriction(this.this$1.this$0.mContext, "no_config_mobile_networks") == false) goto L42;
                OCardListItemUtils.setContentContainerEnabled(this.cardView, false);
                this.cardView.getContentContainer().setClickable(true);
                return;
            L18:
                if (r6.mId < 10000) goto L22;
                this.cardView.setOnContentClickListener(new AnonymousClass1(this, r6));
                if (r6.mSubTitle == null) goto L32;
                OLog.d("setDashboardItemPosition1", "title: " + r6.mTitle + ", summary: " + r6.mSubTitle);
                this.cardView.setSubTitle(r6.mSubTitle);
                this.cardView.showSubTitle(true);
                goto L32
            L22:
                this.cardView.showSubTitle(false);
                this.cardView.setOnContentClickListener(new AnonymousClass2(this, r6));
                if (r6.mShowItemTextBadge == false) goto L28;
                if (r6.mId != 19) goto L28;
                this.cardView.showCustomEnd(true);
                this.cardView.setCustomEndView(R.layout.widget_badge_view);
            L28:
                if (TextUtils.isEmpty(r6.mSubTitle) == true) goto L30;
                this.cardView.setDefaultCustomEndView(3);
                fixLongTailTitleUI(this.cardView, r5, r6.mSubTitle);
                this.cardView.showCustomEnd(true);
                goto L32
            L30:
                this.cardView.showCustomEnd(false);
                goto L32
            L45:
                return;
            L5:
                r0 = r5.getString(r6.mTitleRes);
                goto L6
            }
        }

        public SettingsAdapter(MainSettingsFragment r1) {
            this.this$0 = r1;
        }

        public SettingItem getItem(int r1) {
            return (SettingItem) MainSettingsFragment.access$2300(this.this$0).get(r1);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r1) {
            return ((SettingItem) MainSettingsFragment.access$2300(this.this$0).get(r1)).mId;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
            OCardListItem r4 = new OCardListItem(r2.getContext());
            r4.getTitleView().setId(android.R.id.title);
            return new SettingsMainViewHolder(this, r4);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder r3, int r4) {
            SettingItem r0 = (SettingItem) MainSettingsFragment.access$2300(this.this$0).get(r4);
            if ((r3 instanceof SettingsMainViewHolder) == false) goto L6;
            ((SettingsMainViewHolder) r3).bindData(this.this$0.mContext, r0, r4);
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return MainSettingsFragment.access$2300(this.this$0).size();
        }
    }

    public class SettingsMainItemDecoration extends RecyclerView.ItemDecoration {
        private SettingsAdapter mAdapter;
        final /* synthetic */ MainSettingsFragment this$0;

        public SettingsMainItemDecoration(MainSettingsFragment r1, SettingsAdapter r2) {
            this.this$0 = r1;
            this.mAdapter = r2;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect r3, View r4, RecyclerView r5, RecyclerView.State r6) {
            int r7 = r5.getChildAdapterPosition(r4);
            SettingsAdapter r8 = this.mAdapter;
            if (r8 != null) goto L5;
            return;
        L5:
            SettingItem r9 = r8.getItem(r7);
            if (r9 != null) goto L9;
            return;
        L9:
            if (r9.getPosition() != 1) goto L11;
        L14:
            r3.set(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_item_card_gap), 0, 0);
        L15:
            if (r7 != 0) goto L18;
            r3.set(0, this.this$0.getResources().getDimensionPixelSize(R.dimen.main_settings_first_item_card_gap), 0, 0);
            return;
        L18:
            return;
        L11:
            if (r9.getPosition() == 0) goto L14;
            r3.set(0, 0, 0, 0);
            goto L15
        }
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public MainSettingsFragment() {
        this.mSettingItems = new ArrayList();
        this.coldStartTime = 0;
        this.lifecycle = new LifecycleRegistry(this);
        this.mHandler = new AnonymousClass1(this);
        this.mAccountStatusListener = null;
        this.mProcessor = new HandInHandProcessor();
        this.mBluetoothReceiver = new AnonymousClass2(this);
        this.mSimStateChangedReceiver = new AnonymousClass3(this);
        this.cellularCallback = new CellularCallback(this, null);
        final Handler r1 = new Handler();
        this.mAirplaneModeObserver = new AnonymousClass16(this, r1);
        this.networkStateChangedReceiver = new AnonymousClass17(this);
    }

    static /* synthetic */ void access$000(MainSettingsFragment r0) {
        r0.setWifiTitle();
    }

    static /* synthetic */ SettingsAdapter access$100(MainSettingsFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ String access$1000(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ long access$1100(MainSettingsFragment r2) {
        return r2.coldStartTime;
    }

    static /* synthetic */ long access$1102(MainSettingsFragment r0, long r1) {
        r0.coldStartTime = r1;
        return r1;
    }

    static /* synthetic */ String access$1200(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$1300(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ FpsTracer access$1400(MainSettingsFragment r0) {
        return r0.mFpsTracer;
    }

    static /* synthetic */ void access$1500(MainSettingsFragment r0, Intent r1) {
        r0.systemAccountLogin(r1);
    }

    static /* synthetic */ void access$1600(MainSettingsFragment r0, boolean r1) {
        r0.switchAirplane(r1);
    }

    static /* synthetic */ SettingItem access$1800(MainSettingsFragment r0) {
        return r0.mAirplaneMode;
    }

    static /* synthetic */ SystemAlertDialog access$1900(MainSettingsFragment r0) {
        return r0.mAirPlanModeDialog;
    }

    static /* synthetic */ void access$200(MainSettingsFragment r0) {
        r0.setupMultiSimItem();
    }

    static /* synthetic */ void access$2000(MainSettingsFragment r0) {
        r0.setupPhoneItemEnableState();
    }

    static /* synthetic */ CellularEnabler access$2100(MainSettingsFragment r0) {
        return r0.mCellularEnabler;
    }

    static /* synthetic */ AirplaneModeEnablerEx access$2200(MainSettingsFragment r0) {
        return r0.mAirplaneModeEnabler;
    }

    static /* synthetic */ ArrayList access$2300(MainSettingsFragment r0) {
        return r0.mSettingItems;
    }

    static /* synthetic */ SettingItem access$2500(MainSettingsFragment r0) {
        return r0.mCellular;
    }

    static /* synthetic */ String access$300(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$400(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$500(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$600(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$700(MainSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ Handler access$800(MainSettingsFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ RecyclerView access$900(MainSettingsFragment r0) {
        return r0.mListview;
    }

    void handleStateChanged(int r1) {
        setBluetoothSubTitle(r1);
    }

    public void com_android_settings_MainSettingsFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        SettingsTracker.onLaunch();
        trackLauncherOrigin(this._mActivity.getIntent());
        WallpaperCache.getInstance().prefetchWallpaperIfNeed();
        this.coldStartTime = AppMetricsUtils.INSTANCE.getColdStartTime();
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
        OLog.d(this.TAG, "onCreate coldStartTime=" + this.coldStartTime);
        this.mAccountStatusListener = new AnonymousClass4(this);
        OAccount.INSTANCE.addAccountStatusListener(this.mAccountStatusListener);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.settings_layout_oui, r4, false);
        this.mSupportTelephonyFeature = Utils.hasTelephonyFeature(this.mContext);
        OFloatingTitleBar r6 = (OFloatingTitleBar) findViewByIdNullable(R.id.app_bar);
        this.mAppBar = r6;
        View r7 = r6.addEndAction(R.drawable.settings_ext_oic_magnifier_search, -1, null);
        this.mSearchView = r7;
        r7.setId(SEARCH_BUTTON_ID);
        this.mSearchView.setOnClickListener(this);
        initItems();
        RecyclerView r8 = (RecyclerView) findViewByIdNullable(R.id.main_content_scrollable_container);
        this.mListview = r8;
        r8.setEnableOverFling(true);
        this.mListview.avoidStateChangeInAnim();
        this.mListview.setLayoutManager(new LinearLayoutManager(this.mContext));
        SettingsAdapter r9 = new SettingsAdapter(this);
        this.mAdapter = r9;
        this.mListview.setAdapter(r9);
        this.mListview.addItemDecoration(new SettingsMainItemDecoration(this, this.mAdapter));
        if (this.coldStartTime <= 0) goto L5;
        this.mListview.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass5(this));
    L5:
        final String r10 = this.TAG + "_list_view_scroll";
        FpsTracer r11 = new FpsTracer(r10);
        this.mFpsTracer = r11;
        r11.setIFPSCallBack(new AnonymousClass6(this, r10));
        this.mFpsTracer.setDropFrameCallback(new AnonymousClass7(this, r10));
        this.mListview.addOnScrollListener(new AnonymousClass8(this));
        AirplaneModeEnablerEx r12 = new AirplaneModeEnablerEx(this.mContext, this.mAirplaneMode, this.mAirplaneModeObserver);
        this.mAirplaneModeEnabler = r12;
        r12.resume();
        if (this.mCellular == null) goto L8;
        this.mCellularEnabler = new CellularEnabler(this.mContext, this.mCellular, this.cellularCallback);
    L8:
        this.wifiManager = (WifiManager) this.mContext.getSystemService("wifi");
        this.localBtManager = LocalBluetoothManager.getInstance(this.mContext);
        IntentFilter r13 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        this.bluetoothFilter = r13;
        r13.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        this.mHandler.postDelayed(new AnonymousClass9(this), 300);
        showPermissionGrantDialogIfNeed();
        UIUtils.setUpBottomPaddingOnApplyWindowInsets(this.mListview);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        r3.postDelayed(new MainSettingsFragment$$ExternalSyntheticLambda1(this), 100);
        setupWifiPickerTracker();
        if ((r3 instanceof ViewGroup) == false) goto L5;
        ((ViewGroup) r3).setClipChildren(false);
    L5:
        updateViewWhenResume();
        this.mSearchView.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-MainSettingsFragment, reason: not valid java name */
    /* synthetic */ void m153lambda$onViewCreated$0$comandroidsettingsMainSettingsFragment() {
        SettingsApplication.notifyLauncher(this._mActivity, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r3) {
        super.onActivityCreated(r3);
        Intent r4 = getIntent();
        if (ACTION_SEARCH.equals(r4.getAction()) == false) goto L6;
        r4.setAction(null);
        SearchFragment r0 = new SearchFragment();
        r0.setArguments(r4.getExtras());
        start(r0);
        return;
    }

    private void showPermissionGrantDialogIfNeed() {
        if (Utils.isCtaTestModeOn() == true) goto L6;
        return;
    L6:
        if (android.provider.Settings.Global.getInt(getContentResolver(), SETTINGS_NETWORK_PERMISSION_GRANTED, 0) != 1) goto L8;
        return;
    L8:
        new AlertDialog.Builder(this._mActivity).setTitle(R.string.dialog_title_alert).setMessage(R.string.permission_grant_text).setNegativeButton(R.string.disagree, new AnonymousClass11(this)).setPositiveButton(R.string.agree, new AnonymousClass10(this)).setCancelable(false).show();
    }

    private void trackLauncherOrigin(Intent r6) {
        String r5 = r6.getAction();
        int r1 = 0;
        boolean r0 = r6.getBooleanExtra("from_search", false);
        if (r6.hasExtra(HttpHeaders.ReferrerPolicyValues.ORIGIN) == false) goto L5;
        r1 = r6.getIntExtra(HttpHeaders.ReferrerPolicyValues.ORIGIN, 4);
    L11:
        SettingsTracker.onEvent("A130003", HttpHeaders.ReferrerPolicyValues.ORIGIN, Integer.valueOf(r1));
        return;
    L5:
        if (r0 == false) goto L8;
        r1 = 3;
        goto L11
    L8:
        if ("android.intent.action.MAIN".equals(r5) == true) goto L11;
        r1 = 4;
        goto L11
    }

    private void initItems() {
        this.mSettingItems.clear();
        SettingItem r0 = new SettingItem(this, 0, 1, R.drawable.setting_item_oicon_cloud, R.string.system_account_header_title);
        this.mAccount = r0;
        r0.setPosition(0);
        this.mAccount.setCardType(1);
        this.mSettingItems.add(this.mAccount);
        SettingItem r1 = new SettingItem(this, 1, 1, R.drawable.doubao_icon, R.string.system_intelligent_title);
        this.mSystemIntelligent = r1;
        this.mSettingItems.add(r1);
        this.mSystemIntelligent.setPosition(0);
        SettingItem r2 = new SettingItem(this, 2, 0, R.drawable.setting_item_oicon_airplane, R.string.airplane_mode_header_title);
        this.mAirplaneMode = r2;
        r2.setPosition(1);
        this.mSettingItems.add(this.mAirplaneMode);
        SettingItem r3 = new SettingItem(this, 3, 1, R.drawable.setting_item_oicon_wifi, R.string.wifi_settings_title);
        this.mWlan = r3;
        this.mSettingItems.add(r3);
        SettingItem r4 = new SettingItem(this, 5, 1, R.drawable.setting_item_oicon_bluetooth, R.string.bluetooth_settings_title);
        this.mBluetooth = r4;
        this.mSettingItems.add(r4);
        if (this.mSupportTelephonyFeature == false) goto L6;
        SettingItem r5 = new SettingItem(this, 4, 1, R.drawable.setting_item_oicon_cellular, R.string.data_usage_summary_title);
        this.mCellular = r5;
        this.mSettingItems.add(r5);
    L6:
        if (this.mSupportTelephonyFeature == true) goto L8;
    L10:
        SettingItem r6 = new SettingItem(this, 7, 1, R.drawable.setting_item_oicon_network, R.string.more_network_settings);
        this.mNetwork = r6;
        r6.setPosition(3);
        this.mSettingItems.add(this.mNetwork);
        SettingItem r7 = new SettingItem(this, 8, 1, R.drawable.setting_item_oicon_launcher, R.string.desktop_header_title);
        this.mDesktop = r7;
        r7.setPosition(1);
        this.mSettingItems.add(this.mDesktop);
        SettingItem r8 = new SettingItem(this, 10, 1, R.drawable.setting_item_oicon_brightness, R.string.brightness_header_title);
        this.mBrightness = r8;
        this.mSettingItems.add(r8);
        SettingItem r9 = new SettingItem(this, 11, 1, R.drawable.setting_item_oicon_sound, R.string.sound_settings);
        this.mSound = r9;
        this.mSettingItems.add(r9);
        SettingItem r10 = new SettingItem(this, 17, 1, R.drawable.setting_item_oicon_notification, R.string.system_notification_title);
        this.mNotification = r10;
        r10.setPosition(3);
        this.mSettingItems.add(this.mNotification);
        SettingItem r11 = new SettingItem(this, 12, 1, R.drawable.setting_item_oicon_lock, R.string.lock_screen_header_title);
        this.mLockscreen = r11;
        r11.setPosition(1);
        this.mSettingItems.add(this.mLockscreen);
        SettingItem r12 = new SettingItem(this, 13, 1, R.drawable.setting_item_oicon_permission, R.string.permissions_and_privacy);
        this.mPermission = r12;
        this.mSettingItems.add(r12);
        SettingItem r13 = new SettingItem(this, 15, 1, R.drawable.setting_item_oicon_battery, R.string.battery_and_power_optimization);
        this.mBattery = r13;
        this.mSettingItems.add(r13);
        SettingItem r14 = new SettingItem(this, 14, 1, R.drawable.setting_item_oicon_application, R.string.manager_application);
        this.mApplication = r14;
        this.mSettingItems.add(r14);
        SettingItem r15 = new SettingItem(this, 16, 1, R.drawable.setting_item_oicon_storage, R.string.storage_pager_header_title);
        this.mStorage = r15;
        r15.setPosition(3);
        this.mSettingItems.add(this.mStorage);
        IEmergencyHelp r16 = (IEmergencyHelp) ServiceManager.getService(IEmergencyHelp.class);
        if (r16 != null) goto L13;
    L15:
        SettingItem r17 = new SettingItem(this, 18, 1, R.drawable.setting_item_oicon_advanced, R.string.advanced_settings_header_title);
        this.mAdvanced = r17;
        r17.setPosition(1);
        this.mSettingItems.add(this.mAdvanced);
        SettingItem r18 = new SettingItem(this, 19, 1, R.drawable.setting_item_oicon_update, R.string.about_item_title_update);
        this.mOta = r18;
        this.mSettingItems.add(r18);
        SettingItem r19 = new SettingItem(this, 20, 1, R.drawable.setting_item_oicon_about, R.string.about_settings);
        this.mAboutNew = r19;
        r19.setPosition(3);
        this.mSettingItems.add(this.mAboutNew);
        refreshDashboardTiles(this.TAG);
        return;
    L13:
        if (r16.isShowEmergency() == false) goto L15;
        OLog.d(this.TAG, "isShowEmergency");
        SettingItem r20 = new SettingItem(this, 22, 1, R.drawable.ic_settings_location, R.string.gadget_location);
        this.mLocation = r20;
        this.mSettingItems.add(r20);
        this.mLocation.setPosition(2);
        SettingItem r21 = new SettingItem(this, 21, 1, R.drawable.emergency_icon, r16.getTitle());
        this.mEmergency = r21;
        this.mSettingItems.add(r21);
        this.mStorage.setPosition(2);
        this.mEmergency.setPosition(3);
        goto L15
    L8:
        if (Utils.isMultiSimSupport() == false) goto L10;
        SettingItem r22 = new SettingItem(this, 6, 1, R.drawable.setting_item_oicon_sim, R.string.multi_sim_settings_title);
        this.mMultiSim = r22;
        this.mSettingItems.add(r22);
        goto L10
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        onClick(r2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View r12) {
        if (r12.isEnabled() == true) goto L5;
        return;
    L5:
        final Intent r0 = new Intent();
        if (this.mTitleResId == null) goto L8;
        r0.putExtra("back_text_id", this.mTitleResId);
    L8:
        r0.putExtra(Utils.EXTRA_FROM_SETTINGS, true);
        int r1 = r12.getId();
        if (r1 != SEARCH_BUTTON_ID) goto L11;
        start(SearchFragment.class, TransactionType.POPUP);
        SettingsTracker.onEvent("A130006");
        TrackerEvent.buttonEvent("settings_search_page_search_icon", null);
        return;
    L11:
        switch(r1) {
            case 0: goto L60;
            case 1: goto L53;
            case 2: goto L45;
            case 3: goto L44;
            case 4: goto L38;
            case 5: goto L36;
            case 6: goto L33;
            case 7: goto L31;
            case 8: goto L30;
            case 9: goto L29;
            case 10: goto L28;
            case 11: goto L27;
            case 12: goto L26;
            case 13: goto L25;
            case 14: goto L24;
            case 15: goto L23;
            case 16: goto L22;
            case 17: goto L21;
            case 18: goto L20;
            case 19: goto L65;
            case 20: goto L15;
            case 21: goto L14;
            case 22: goto L13;
            default: goto L90;
        };
    L13:
        r0.setClass(this.mContext, Settings.LocationServiceSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        return;
    L14:
        start(EmergencyDashboardFragment.class);
        return;
    L15:
        r0.setClass(this.mContext, AboutActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(29);
        return;
    L20:
        r0.setClass(this.mContext, Settings.AdvancedSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(26);
        return;
    L21:
        r0.setClass(this.mContext, Settings.NotificationSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(18);
        return;
    L22:
        r0.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.storage.StorageActivity");
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "settings_application");
        Utils.startActivity(this._mActivity, r0);
        return;
    L23:
        r0.setClassName(Constants.PKG_SECURITY, "com.obric.security.battertpower.BatteryPowerActivity");
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "settings_application");
        Utils.startActivity(this._mActivity, r0);
        return;
    L24:
        r0.setClassName(Constants.PKG_SECURITY, "com.bytedanceos.appmanager.ApplicationManagerActivitySettings");
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra(BaseActivity.EXTRA_FROM_SECURITY, false);
        r0.putExtra("back_text_res_name", "settings_application");
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(17);
        return;
    L25:
        PermissionControllerHelp.INSTANCE.launchPermissionPage(this._mActivity);
        return;
    L26:
        launchLockscreenActivity();
        SettingsTracker.onItemClick(16);
        return;
    L27:
        r0.setClass(this.mContext, SoundSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(12);
        return;
    L28:
        r0.setClass(this.mContext, BrightnessSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(11);
        return;
    L29:
        SettingsTracker.onItemClick(10);
        start(LauncherSettingsFragment.class);
        return;
    L30:
        r0.setAction("android.intent.action.SET_WALLPAPER");
        r0.setPackage(Constants.PKG_WALLPAPER_PROVIDER);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(9);
        return;
    L31:
        r0.setClass(this.mContext, Settings.NetworkSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(7);
        return;
    L36:
        r0.setClass(this.mContext, BluetoothSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(5);
        return;
    L44:
        CacheMgr.INSTANCE.setConnectedEntry(this.mWifiPickerTracker.getConnectedWifiEntry());
        r0.setClass(this.mContext, WifiSettingsActivity.class);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(2);
        return;
    L45:
        final boolean r2 = ((OSwitch) r12).isChecked();
        OLog.d("airPlane", "onClick " + r2);
        if (r2 == true) goto L48;
    L50:
        switchAirplane(r2);
    L51:
        OLog.d("airPlane", "onCheckedChange to " + r2);
        return;
    L48:
        if (SmtTntUtil.isMiracastWirelessConnect(this.mContext) == false) goto L50;
        SystemAlertDialog r3 = new SystemAlertDialog(this.mContext);
        this.mAirPlanModeDialog = r3;
        r3.setTitle(R.string.dlg_title_notice);
        this.mAirPlanModeDialog.setMessage(getString(R.string.open_some_switch_dialog_content, new Object[]{this.mContext.getString(R.string.airplane_mode_header_title)}));
        this.mAirPlanModeDialog.setCancelable(true);
        this.mAirPlanModeDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass13(this, r12, r2));
        this.mAirPlanModeDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass14(this, r12));
        this.mAirPlanModeDialog.setOnCancelListener(new AnonymousClass15(this, r12));
        this.mAirPlanModeDialog.getWindow().setType(2020);
        this.mAirPlanModeDialog.show();
        goto L51
    L60:
        OLog.i(this.TAG, "onClick ID_ACCOUNT_MODE");
        this.mAdapter.notifyDataSetChanged();
        this.mHandler.post(new AnonymousClass12(this, r0));
        SettingsTracker.onItemClick(26);
        return;
    L65:
        r0.setClassName("com.obric.updater", "com.obric.updater.UpdatesCheck");     // Catch: Exception -> L18
        r0.setAction("android.intent.action.MAIN");     // Catch: Exception -> L18
        Utils.startActivityForResult(this._mActivity, r0, 0, 0);     // Catch: Exception -> L18
        SettingsTracker.onItemClick(28);     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        e.printStackTrace();
        return;
    L90:
        return;
    L33:
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_mobile_networks") == true) goto L92;
        r0.setClass(this._mActivity, MultiSimSettings.class);
        r0.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
        Utils.startActivity(this._mActivity, r0);
        SettingsTracker.onItemClick(6);
        return;
    L92:
        return;
    L38:
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_config_mobile_networks") == true) goto L93;
        r0.setClassName("com.android.phone", "com.bytedanceos.phone.settings.settings.mobilenetwork.MobileNetworkSettings");     // Catch: Exception -> L42
        r0.setAction("android.intent.action.MAIN");     // Catch: Exception -> L42
        r0.putExtra("back_text_res_name", "settings");     // Catch: Exception -> L42
        Utils.startActivity(this._mActivity, r0);     // Catch: Exception -> L42
        SettingsTracker.onItemClick(3);     // Catch: Exception -> L42
        return;
    L42:
        e = move-exception;
        e.printStackTrace();
        return;
    L93:
        return;
    L53:
        if (Utils.isFastDoubleClick() == false) goto L56;
        return;
    L56:
        if (DoubaoAssistantEnabler.isInstalled(this._mActivity) == true) goto L59;
        DoubaoAssistantEnabler.showInstallDialog(this._mActivity);
        return;
    L59:
        r0.setClass(this.mContext, Settings.SystemIntelligentActivity.class);
        Utils.startActivity(this._mActivity, r0);
    }

    private void setupPhoneItemEnableState() {
        if (isAdded() == true) goto L5;
        return;
    L5:
        SettingItem r2 = this.mCellular;
        if (r2 == null) goto L9;
        r2.setViewInfo(R.string.data_usage_summary_title, R.string.cellular_intro_summary);
        return;
    }

    private int getBluetoothState() {
        if (this.localBtManager.getBluetoothAdapter().getConnectionState() != 2) goto L5;
        return 2;
    L5:
        return this.localBtManager.getBluetoothAdapter().getBluetoothState();
    }

    private void setBluetoothSubTitle(int r4) {
        if (r4 == 0) goto L17;
        if (r4 != 1) goto L7;
    L15:
        SettingItem r5 = this.mBluetooth;
        r5.mSubTitle = getString(R.string.bluetooth_state_opened);
        return;
    L7:
        if (r4 != 2) goto L9;
        SettingItem r6 = this.mBluetooth;
        r6.mSubTitle = getString(R.string.bluetooth_state_connected);
        return;
    L9:
        if (r4 == 3) goto L17;
        switch(r4) {
            case 10: goto L13;
            case 11: goto L12;
            case 12: goto L15;
            case 13: goto L13;
            default: goto L26;
        };
    L12:
        this.mBluetooth.mSubTitle = "";
        return;
    L13:
        SettingItem r7 = this.mBluetooth;
        r7.mSubTitle = getString(R.string.bluetooth_state_closed);
        return;
    L26:
        return;
    L17:
        if (this.localBtManager.getBluetoothAdapter().getBluetoothState() == 12) goto L19;
        SettingItem r8 = this.mBluetooth;
        r8.mSubTitle = getString(R.string.bluetooth_state_closed);
        return;
    L19:
        SettingItem r9 = this.mBluetooth;
        r9.mSubTitle = getString(R.string.bluetooth_state_opened);
    }

    public void com_android_settings_MainSettingsFragment__onResume$___twin___() {
        super.onResume();
        registerEventBusIfNeeded();
        CellularEnabler r0 = this.mCellularEnabler;
        if (r0 == null) goto L5;
        r0.resume();
    L5:
        registerReceiver(this.networkStateChangedReceiver, getNetworkIntentFilter());
        registerReceiver(this.mBluetoothReceiver, this.bluetoothFilter);
        if (this.mMultiSim == null) goto L13;
        registerReceiver(this.mSimStateChangedReceiver, getSimStateChangedFilter());
    L13:
        OAccount.INSTANCE.forceUpdateAccount();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        OLog.e(this.TAG, "forceUpdateAccount e=" + th);
    }

    private void registerEventBusIfNeeded() {
        EventBus r0 = EventBus.getDefault();
        if (r0.isRegistered(this) == true) goto L6;
        r0.register(this);
        return;
    }

    private void unregisterEventBusIfNeeded() {
        EventBus r0 = EventBus.getDefault();
        if (r0.isRegistered(this) == false) goto L6;
        r0.unregister(this);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViewWhenResume();
    }

    private void updateViewWhenResume() {
        setupPhoneItemEnableState();
        setWifiTitle();
        setBluetoothSubTitle(getBluetoothState());
        if (this.mMultiSim == null) goto L5;
        setupMultiSimItem();
    L5:
        SettingItem r0 = this.mOta;
        r0.mShowItemTextBadge = Utils.findSystemUpdatable(this.mContext);
        this.mAdapter.notifyDataSetChanged();
    }

    @Subscribe
    public void onEvent(EventType.OTABadgeUpdateEvent r4) {
        boolean r5 = r4.showOTABadge();
        OLog.d(this.TAG, "onEvent showOTABadge " + r5);
        if (this.mOta.mShowItemTextBadge == r5) goto L6;
        this.mOta.mShowItemTextBadge = r5;
        this.mAdapter.notifyDataSetChanged();
        return;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        if (this.mTitleResId == null) goto L6;
        setTitle(this.mTitleResId.intValue());
        return;
    }

    private void setupMultiSimItem() {
        if (isAdded() == true) goto L6;
        return;
    L6:
        if (this.mMultiSim == null) goto L28;
        boolean r0 = DevicePolicyUtils.hasUserRestriction(this.mContext, "no_config_mobile_networks");
        boolean r1 = AirplaneModeEnablerEx.isAirplaneModeOn(this.mContext);
        boolean r2 = isSimExists();
        if (r0 == false) goto L10;
        this.mMultiSim.mSubTitle = this.mContext.getString(R.string.disabled_by_admin_summary_text);
    L15:
        SettingItem r3 = this.mMultiSim;
        if (r1 == true) goto L20;
        if (r2 == false) goto L20;
        if (r0 == true) goto L20;
        boolean r4 = true;
    L21:
        r3.mEnable = r4;
        SettingItem r5 = this.mCellular;
        if (Utils.hasMultiSimInDevice() == true) goto L24;
        this.mSettingItems.remove(this.mMultiSim);
        return;
    L24:
        if (this.mSettingItems.contains(this.mMultiSim) == true) goto L29;
        this.mSettingItems.add(this.mSettingItems.indexOf(r5) + 1, this.mMultiSim);
        return;
    L29:
        return;
    L20:
        r4 = false;
        goto L21
    L10:
        if (r1 == false) goto L12;
        this.mMultiSim.mSubTitle = getString(R.string.airplane_mode_header_title);
        goto L15
    L12:
        if (r2 == true) goto L14;
        this.mMultiSim.mSubTitle = getString(R.string.sim_not_found);
        goto L15
    L14:
        this.mMultiSim.mSubTitle = null;
        goto L15
    }

    private IntentFilter getSimStateChangedFilter() {
        return new IntentFilter("android.intent.action.SIM_STATE_CHANGED");
    }

    private boolean isSimExists() {
        return Utils.isSimExists();
    }

    private void setWifiTitle() {
        WifiInfo r0 = this.wifiManager.getConnectionInfo();
        if (r0 != null) goto L5;
        return;
    L5:
        String r1 = r0.getSSID();
        if (r0.getNetworkId() == (-1)) goto L11;
        if (r0.getSupplicantState() != SupplicantState.COMPLETED) goto L11;
        SettingItem r4 = this.mWlan;
        r4.mSubTitle = r1.substring(1, r1.length() - 1);
        return;
    L11:
        if (isWifiEnabled() == false) goto L13;
        SettingItem r2 = this.mWlan;
        r2.mSubTitle = getString(R.string.wifi_state_disconnect);
        return;
    L13:
        SettingItem r3 = this.mWlan;
        r3.mSubTitle = getString(R.string.wifi_state_closed);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.coldStartTime = 0;
        unregisterEventBusIfNeeded();
        unregisterReceiver(this.networkStateChangedReceiver);
        unregisterReceiver(this.mBluetoothReceiver);
        if (this.mMultiSim == null) goto L5;
        unregisterReceiver(this.mSimStateChangedReceiver);
    L5:
        CellularEnabler r2 = this.mCellularEnabler;
        if (r2 == null) goto L9;
        r2.pause();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSettingItems.clear();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.mAccountStatusListener == null) goto L5;
        OAccount.INSTANCE.removeAccountStatusListener(this.mAccountStatusListener);
        this.mAccountStatusListener = null;
    L5:
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mAirplaneModeEnabler.pause();
    }

    private IntentFilter getNetworkIntentFilter() {
        IntentFilter r1 = new IntentFilter();
        r1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r1.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r1.addAction("android.net.wifi.STATE_CHANGE");
        r1.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        r1.addAction("android.intent.action.SIM_STATE_CHANGED");
        r1.addAction("android.intent.action.ACTION_DEFAULT_DATA_SUBSCRIPTION_CHANGED");
        return r1;
    }

    private boolean isWifiEnabled() {
        if (this.wifiManager.getWifiState() != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(final CompoundButton r7, final boolean r8) {
        if (r7.getId() == 2) goto L6;
        return;
    L6:
        if (DevicePolicyUtils.trySendShowAdminSupportDetailsIntent(this.mContext, "no_airplane_mode") == false) goto L9;
        r7.setOnCheckedChangeListener(null);
        r7.setChecked(false);
        r7.setOnCheckedChangeListener(this);
        return;
    L9:
        if (r8 == true) goto L11;
    L13:
        switchAirplane(r8);
    L14:
        OLog.d("airPlane", "onCheckedChange to " + r8);
        return;
    L11:
        if (SmtTntUtil.isMiracastWirelessConnect(this.mContext) == false) goto L13;
        SystemAlertDialog r0 = new SystemAlertDialog(this.mContext);
        this.mAirPlanModeDialog = r0;
        r0.setTitle(R.string.dlg_title_notice);
        this.mAirPlanModeDialog.setMessage(getString(R.string.open_some_switch_dialog_content, new Object[]{this.mContext.getString(R.string.airplane_mode_header_title)}));
        this.mAirPlanModeDialog.setCancelable(true);
        this.mAirPlanModeDialog.setPositiveButton(R.string.notification_warning_dialog_ok_btn, new AnonymousClass18(this, r7, r8));
        this.mAirPlanModeDialog.setNegativeButton(R.string.hand_in_hand_dialog_cancel_button_text, new AnonymousClass19(this, r7));
        this.mAirPlanModeDialog.setOnCancelListener(new AnonymousClass20(this, r7));
        this.mAirPlanModeDialog.getWindow().setType(2020);
        this.mAirPlanModeDialog.show();
        goto L14
    }

    private void switchAirplane(final boolean r8) {
        if (Utils.isMonkeyRunning() == false) goto L6;
        return;
    L6:
        if (AirplaneModeEnablerEx.isAirplaneModeOn(this.mContext) != r8) goto L8;
        return;
    L8:
        this.mAirplaneMode.mChecked = r8;
        OLog.d("airPlane", "switchAirplane as " + r8);
        if (r8 == true) goto L11;
    L13:
        this.mAirplaneModeEnabler.setAirplaneModeOn(r8);
    L14:
        SettingsTracker.onSwitcherClick(1, r8);
        TrackerEvent.switchEvent("airplane_mode_on", r8);
        return;
    L11:
        if (this.mProcessor.isHandInHandle(this._mActivity) == false) goto L13;
        this.mProcessor.showDialog(this._mActivity, 0, new AnonymousClass21(this), new AnonymousClass22(this, r8), new AnonymousClass23(this));
        goto L14
    }

    private void systemAccountLogin(Intent r3) {
        OLog.d(this.TAG, "systemAccountLogin, start");
        OAccountHelper.prepareAccountLaunchIntent(this._mActivity, r3);     // Catch: Exception -> L5
        Utils.startActivity(this._mActivity, r3, 0, 0);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(this.TAG, "start account app error:" + e);
    }

    private void launchLockscreenActivity() {
        Intent r0 = new Intent(this._mActivity, Settings.LockScreenActivity.class);
        r0.putExtra("back_text_id", R.string.settings_label);
        Utils.startActivity(this._mActivity, r0);
    }

    private void setupWifiPickerTracker() {
        Context r2 = SettingsApplication.getContext();
        final ZoneOffset r0 = ZoneOffset.UTC;
        Clock r5 = new AnonymousClass24(this, r0);
        HandlerThread r1 = new HandlerThread(this.TAG + VectorFormat.DEFAULT_PREFIX + Integer.toHexString(System.identityHashCode(this)) + VectorFormat.DEFAULT_SUFFIX, 10);
        this.mWifiPickerTrackerWorkerThread = r1;
        r1.start();
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mWorkerHandler = this.mWifiPickerTrackerWorkerThread.getThreadHandler();
        WifiPickerTracker r3 = FeatureFactory.getFactory(r2).getWifiTrackerLibProvider().createWifiPickerTracker(this.lifecycle, r2, this.mMainHandler, this.mWorkerHandler, r5, 15000, SCAN_INTERVAL_MILLIS, null);
        this.mWifiPickerTracker = r3;
        r3.disableScanning();
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
    }

    private void refreshDashboardTiles(String r11) {
        DashboardCategory r0 = this.mDashboardFeatureProvider.getTilesForCategory(CategoryKey.CATEGORY_HOMEPAGE);
        if (r0 != null) goto L6;
        OLog.d(r11, "NO dashboard tiles for " + r11);
        return;
    L6:
        List<Tile> r1 = r0.getTiles();
        if (r1 != null) goto L10;
        OLog.d(r11, "tile list is empty, skipping category " + r0.key);
        return;
    L10:
        r1.sort(Comparator.comparingInt(new MainSettingsFragment$$ExternalSyntheticLambda0()));
        Iterator<Tile> r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L35;
        Tile r3 = r2.next();
        if (TextUtils.isEmpty(this.mDashboardFeatureProvider.getDashboardKeyForTile(r3)) == true) goto L15;
        if (displayTile(r3) == false) goto L12;
        if (isAllowDashboardItem(r3.getPackageName()) == false) goto L12;
        SettingItem r4 = new SettingItem(this, r1.indexOf(r3) + 10000, 1, r3.getIcon(this.mContext).getResId(), R.string.summary_placeholder);
        String r5 = null;
        if (r3.getTitle(this.mContext) != null) goto L24;
        String r6 = null;
    L25:
        r4.mTitle = r6;
        if (r3.getSummary(this.mContext) == null) goto L29;
        r5 = r3.getSummary(this.mContext).toString();
    L29:
        r4.mSubTitle = r5;
        int r7 = AnonymousClass25.$SwitchMap$com$android$settingslib$drawer$Tile$Type[r3.getType().ordinal()];
        if (r7 == 1) goto L34;
        if (r7 != 2) goto L12;
    L34:
        r4.mType = 1;
        r4.mIntent = r3.getIntent();
        setDashboardItemPosition(r3, r4);
        goto L12
    L24:
        r6 = r3.getTitle(this.mContext).toString();
        goto L25
    L15:
        OLog.d(r11, "tile does not contain a key, skipping " + r3);
        goto L12
    }

    static /* synthetic */ int lambda$refreshDashboardTiles$1(Tile r1) {
        if (r1.getType() != Tile.Type.GROUP) goto L5;
        return 0;
    L5:
        return 1;
    }

    private boolean isAllowDashboardItem(String r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (r1.isEmpty() == true) goto L12;
        if (r1.contains("com.google.android.apps.wellbeing") == false) goto L8;
    L11:
        return true;
    L8:
        if (r1.contains("com.google.android.gms") == true) goto L11;
        if (r1.contains("com.zte.usebalance") == false) goto L12;
        goto L11
    }

    private void setDashboardItemPosition(Tile r5, SettingItem r6) {
        String r0 = r5.getPackageName();
        if (r0.equals("com.zte.usebalance") == false) goto L8;
        if (this.mSettingItems.contains(this.mBattery) == false) goto L8;
        int r1 = this.mSettingItems.indexOf(this.mBattery) + 1;
        r6.setPosition(2);
        r6.mIconRes = R.drawable.minor_app_icon;
        this.mSettingItems.add(r1, r6);
    L8:
        if (GoogleHelp.INSTANCE.isShowGoogleWellbeing() == false) goto L15;
        if (r0.equals("com.google.android.apps.wellbeing") == false) goto L15;
        if (this.mSettingItems.contains(this.mStorage) == false) goto L15;
        int r2 = this.mSettingItems.indexOf(this.mStorage) + 1;
        r6.setPosition(2);
        r6.mIconRes = R.drawable.wellbeing_icon;
        this.mSettingItems.add(r2, r6);
        this.mStorage.setPosition(2);
    L15:
        if (GoogleHelp.INSTANCE.isShowGoogleGms() == true) goto L17;
        return;
    L17:
        if (r0.equals("com.google.android.gms") == false) goto L28;
        r6.setPosition(3);
        r6.mIconRes = R.drawable.gms_icon;
        if (this.mSettingItems.contains(this.mEmergency) == false) goto L21;
        int r3 = this.mSettingItems.indexOf(this.mEmergency) + 1;
        this.mSettingItems.add(r3, r6);
        this.mEmergency.setPosition(2);
    L22:
        String r4 = com.android.settings.overlay.FeatureFactory.getFeatureFactory().getDashboardFeatureProvider().getTitleFromUri(r5);
        if (r4 == null) goto L25;
        r6.mTitle = r4;
        return;
    L25:
        r6.mTitle = "Google";
        return;
    L21:
        int r7 = this.mSettingItems.indexOf(this.mStorage) + 2;
        this.mSettingItems.add(r7, r6);
        goto L22
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(MainSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MainSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(MainSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_MainSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(MainSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_MainSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
