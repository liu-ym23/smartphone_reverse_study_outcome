package com.android.settings.revone;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.settings.Constants;
import com.android.settings.GpsEnabler;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.bluetooth.BluetoothEnabler;
import com.android.settings.bluetooth.LocalBluetoothManager;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.MovieView;
import com.android.settings.widget.SettingItemButton;
import com.obric.olog.OLog;
import com.obric.oui.oswitch.OSwitch;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItem;
import obric.widget.ListContentItemCustom;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class StylusSearchFragment extends BaseFragment implements View.OnClickListener, BluetoothEnabler.OnUpdateViewListener, CompoundButton.OnCheckedChangeListener {
    private static final int HEX = 16;
    private static final int MULTIPLICATION_TEN = 10;
    private static final int PLAY_VIDEO_DELAY_TIME = 100;
    private static final int STYLUS_MAC_BEGIN = 6145;
    private static final int STYLUS_MAC_END = 56144;
    private static final String STYLUS_MAC_PREFIX = "4C:93:A6:A3";
    private static final String TAG = "StylusSearchFragment";
    private static final int TEN_SECONDS = 10000;
    private final int CONNECT_STYLUS_TIMEOUT;
    private final int MSG_CONNECT_STYLUS_TIMEOUT;
    private TextView mAvalaibleDevice;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothEnabler mBluetoothEnabler;
    private BluetoothLeScanner mBluetoothLeScanner;
    private BluetoothManager mBluetoothManager;
    private boolean mBluetoothState;
    private SettingItemSwitch mBluetoothSwitchEx;
    private TextView mBtTips;
    private String mConnectingStylus;
    private final BroadcastReceiver mGattUpdateReceiver;
    private GpsEnabler mGpsEnabler;
    private final ContentObserver mGpsObserver;
    private Handler mHandler;
    private Handler mHandlerStopScan;
    private boolean mIsScan;
    private SettingItemText mItemClick;
    private ListContentItemCustom mItemContainer;
    private SettingItemText mItemDoubleClick;
    private SettingItemText mItemLongPress;
    private TextView mKeyTips;
    private boolean mLocationState;
    private SettingItemSwitch mLocationSwitchEx;
    private LocalBluetoothManager mManager;
    private TextView mMovieTips;
    private MovieView mMovieView;
    private LinearLayout mPageContainer;
    private View mPointerGap;
    private ScanCallback mScanCallback;
    private StylusAdapter mStylusAdapter;
    private RecyclerView mStylusListView;
    private int mStylusState;

    private class BottomViewHolder extends RecyclerView.ViewHolder {
        ImageView mItemBanner;
        private SettingItemButton mItemCustom;
        final /* synthetic */ StylusSearchFragment this$0;

        public BottomViewHolder(StylusSearchFragment r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.mItemCustom = (SettingItemButton) r2.findViewById(R.id.bottom_view);
            this.mItemBanner = (ImageView) r2.findViewById(R.id.banner);
        }

        public SettingItemButton getItemCustom() {
            return this.mItemCustom;
        }
    }

    private class SampleScanCallback extends ScanCallback {
        final /* synthetic */ StylusSearchFragment this$0;

        private SampleScanCallback(StylusSearchFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SampleScanCallback(StylusSearchFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanResult(int r3, ScanResult r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.getDevice() != null) goto L6;
            return;
        L6:
            if (r4.getDevice().getName() == null) goto L15;
            OLog.i(StylusSearchFragment.TAG, "result getName:" + r4.getDevice().getName());
            super.onScanResult(r3, r4);
            if (StylusSearchFragment.access$2100(this.this$0, r4.getDevice().getAddress()) == false) goto L14;
            StylusSearchFragment.access$200(this.this$0).add(r4.getDevice());
            return;
        L14:
            return;
        }

        @Override // android.bluetooth.le.ScanCallback
        public void onScanFailed(int r3) {
            OLog.i(StylusSearchFragment.TAG, "SampleScanCallback onScanFailed");
            super.onScanFailed(r3);
        }
    }

    private class StylusAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int ITEM_TYPE_BOTTOM = 1;
        private static final int ITEM_TYPE_CONTENT = 0;
        private int mBottonCount;
        private List<BluetoothDevice> mStylusList;
        final /* synthetic */ StylusSearchFragment this$0;

        private int getItemBgStyle(int r1, int r2) {
            if (r1 != 1) goto L5;
            return 1;
        L5:
            if (r2 != 0) goto L9;
            return 2;
        L9:
            if (r2 != (r1 - 1)) goto L12;
            return 4;
        L12:
            return 3;
        }

        private StylusAdapter(StylusSearchFragment r1) {
            this.this$0 = r1;
            this.mBottonCount = 1;
            this.mStylusList = new ArrayList();
        }

        /* synthetic */ StylusAdapter(StylusSearchFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
            if (r2 != 0) goto L6;
            return onCreateContentView(r1);
        L6:
            return onCreateBottomView(r1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(final RecyclerView.ViewHolder r10, int r11) {
            OLog.i(StylusSearchFragment.TAG, "onBindViewHolder");
            if (getItemViewType(r11) == 1) goto L5;
            int r0 = Settings.Global.getInt(this.this$0.getContentResolver(), Constants.KEY_STYLUS_BATTERY, -1);
            StylusViewHolder r3 = (StylusViewHolder) r10;
            final BluetoothDevice r5 = this.mStylusList.get(r11);
            if (StylusSearchFragment.access$2000(this.this$0, r5.getAddress()) == false) goto L23;
            if (r0 == (-1)) goto L23;
            r3.getItemText().setEnabled(true);
            r3.getItemText().setSummary(this.this$0.getString(R.string.stylus_connect_battery, new Object[]{((r0 + 1) * 10) + "%"}));
        L27:
            if (StylusSearchFragment.access$2000(this.this$0, r5.getAddress()) == false) goto L29;
            r3.getItemText().setArrowVisible(true);
        L30:
            r3.getItemText().setTitle(Utils.getStylusName(r5, this.this$0.mContext));
            setItemBgStyle(r3.getItemText(), getItemCount(), r11);
            r3.getItemText().setOnClickListener(new AnonymousClass2(this, r5, r10));
            return;
        L29:
            r3.getItemText().setArrowVisible(false);
        L23:
            if (TextUtils.equals(r5.getAddress(), StylusSearchFragment.access$100(this.this$0)) == false) goto L25;
            r3.getItemText().setEnabled(false);
            r3.getItemText().setSummary(R.string.pbap_connecting_title);
            goto L27
        L25:
            r3.getItemText().setEnabled(true);
            r3.getItemText().setSummary("");
            goto L27
        L5:
            if (getContentItemCount() != 0) goto L7;
            ((BottomViewHolder) r10).getItemCustom().setBackgroundStyle(1);
        L9:
            if (StylusSearchFragment.access$1600(this.this$0) == false) goto L12;
            BottomViewHolder r12 = (BottomViewHolder) r10;
            r12.getItemCustom().setEnabled(false);
            r12.getItemCustom().setText(R.string.bluetooth_searching_for_devices);
        L16:
            ((BottomViewHolder) r10).mItemBanner.setOnClickListener(new StylusSearchFragment$StylusAdapter$$ExternalSyntheticLambda0(this));
            return;
        L12:
            if (StylusSearchFragment.access$000(this.this$0) != 1) goto L14;
            ((BottomViewHolder) r10).getItemCustom().setEnabled(false);
        L15:
            BottomViewHolder r13 = (BottomViewHolder) r10;
            r13.getItemCustom().setText(R.string.bluetooth_search_for_devices);
            r13.getItemCustom().setOnClickListener(new AnonymousClass1(this));
            goto L16
        L14:
            ((BottomViewHolder) r10).getItemCustom().setEnabled(true);
            goto L15
        L7:
            ((BottomViewHolder) r10).getItemCustom().setBackgroundStyle(4);
            goto L9
        }

        /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-revone-StylusSearchFragment$StylusAdapter, reason: not valid java name */
        /* synthetic */ void m559xee7402fb(View r3) {
            Intent r4 = new Intent("android.intent.action.VIEW", Uri.parse(""));
            r4.setFlags(335544320);
            r4.putExtra("com.android.browser.application_id", this.this$0.mContext.getPackageName());
            this.this$0.mContext.startActivity(r4);
        }

        public int getContentItemCount() {
            return this.mStylusList.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return getContentItemCount() + this.mBottonCount;
        }

        public RecyclerView.ViewHolder onCreateBottomView(ViewGroup r4) {
            View r5 = LayoutInflater.from(r4.getContext()).inflate(R.layout.revone_stylus_bottom, r4, false);
            return new BottomViewHolder(this.this$0, r5);
        }

        public RecyclerView.ViewHolder onCreateContentView(ViewGroup r4) {
            View r5 = LayoutInflater.from(r4.getContext()).inflate(R.layout.list_content_item_text, r4, false);
            return new StylusViewHolder(this.this$0, r5);
        }

        private int getPosition(String r3) {
            OLog.i(StylusSearchFragment.TAG, "mStylusList size:" + getContentItemCount());
            int r0 = 0;
        L4:
            if (r0 >= getContentItemCount()) goto L9;
            if (this.mStylusList.get(r0).getAddress().equals(r3) == true) goto L13;
            r0 = r0 + 1;
            goto L4
        L13:
            return r0;
        L9:
            return -1;
        }

        public void add(BluetoothDevice r3) {
            OLog.i(StylusSearchFragment.TAG, "getAddress:" + r3.getAddress());
            if (getPosition(r3.getAddress()) >= 0) goto L6;
            this.mStylusList.add(r3);
            this.mBottonCount = 1;
            notifyDataSetChanged();
            return;
        }

        public void clear() {
            List<BluetoothDevice> r0 = this.mStylusList;
            if (r0 == null) goto L6;
            r0.clear();
            return;
        }

        public BluetoothDevice getItem(int r1) {
            return this.mStylusList.get(r1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int r2) {
            int r0 = getContentItemCount();
            if (this.mBottonCount == 0) goto L7;
            if (r2 < r0) goto L9;
            return 1;
        L9:
            return 0;
        L7:
            return 0;
        }

        private void setItemBgStyle(ListContentItem r1, int r2, int r3) {
            if (r1 != null) goto L4;
            return;
        L4:
            r1.setBackgroundStyle(getItemBgStyle(r2, r3));
        }

        public void setBottomCount(int r1) {
            this.mBottonCount = r1;
        }
    }

    private class StylusViewHolder extends RecyclerView.ViewHolder {
        private SettingItemText mItemText;
        final /* synthetic */ StylusSearchFragment this$0;

        public StylusViewHolder(StylusSearchFragment r1, View r2) {
            this.this$0 = r1;
            super(r2);
            this.mItemText = (SettingItemText) r2.findViewById(R.id.item_text);
        }

        public SettingItemText getItemText() {
            return this.mItemText;
        }
    }

    public void com_android_settings_revone_StylusSearchFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_revone_StylusSearchFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ int access$000(StylusSearchFragment r0) {
        return r0.mStylusState;
    }

    static /* synthetic */ int access$002(StylusSearchFragment r0, int r1) {
        r0.mStylusState = r1;
        return r1;
    }

    static /* synthetic */ String access$100(StylusSearchFragment r0) {
        return r0.mConnectingStylus;
    }

    static /* synthetic */ String access$102(StylusSearchFragment r0, String r1) {
        r0.mConnectingStylus = r1;
        return r1;
    }

    static /* synthetic */ BluetoothAdapter access$1200(StylusSearchFragment r0) {
        return r0.mBluetoothAdapter;
    }

    static /* synthetic */ BluetoothAdapter access$1202(StylusSearchFragment r0, BluetoothAdapter r1) {
        r0.mBluetoothAdapter = r1;
        return r1;
    }

    static /* synthetic */ BluetoothLeScanner access$1300(StylusSearchFragment r0) {
        return r0.mBluetoothLeScanner;
    }

    static /* synthetic */ BluetoothLeScanner access$1302(StylusSearchFragment r0, BluetoothLeScanner r1) {
        r0.mBluetoothLeScanner = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1400(StylusSearchFragment r0) {
        return r0.checkAdapterStateOn();
    }

    static /* synthetic */ ScanCallback access$1500(StylusSearchFragment r0) {
        return r0.mScanCallback;
    }

    static /* synthetic */ boolean access$1600(StylusSearchFragment r0) {
        return r0.mIsScan;
    }

    static /* synthetic */ boolean access$1602(StylusSearchFragment r0, boolean r1) {
        r0.mIsScan = r1;
        return r1;
    }

    static /* synthetic */ MovieView access$1700(StylusSearchFragment r0) {
        return r0.mMovieView;
    }

    static /* synthetic */ ScanSettings access$1800(StylusSearchFragment r0) {
        return r0.buildScanSettings();
    }

    static /* synthetic */ void access$1900(StylusSearchFragment r0) {
        r0.stylusScanTimeout();
    }

    static /* synthetic */ StylusAdapter access$200(StylusSearchFragment r0) {
        return r0.mStylusAdapter;
    }

    static /* synthetic */ boolean access$2000(StylusSearchFragment r0, String r1) {
        return r0.isDeviceConnected(r1);
    }

    static /* synthetic */ boolean access$2100(StylusSearchFragment r0, String r1) {
        return r0.isStylus(r1);
    }

    static /* synthetic */ GpsEnabler access$300(StylusSearchFragment r0) {
        return r0.mGpsEnabler;
    }

    static /* synthetic */ boolean access$400(StylusSearchFragment r0) {
        return r0.mLocationState;
    }

    static /* synthetic */ boolean access$402(StylusSearchFragment r0, boolean r1) {
        r0.mLocationState = r1;
        return r1;
    }

    static /* synthetic */ boolean access$500(StylusSearchFragment r0) {
        return r0.mBluetoothState;
    }

    static /* synthetic */ void access$600(StylusSearchFragment r0, boolean r1) {
        r0.stylusToConnectUpdateView(r1);
    }

    static /* synthetic */ void access$700(StylusSearchFragment r0, BluetoothDevice r1) {
        r0.saveStylusName(r1);
    }

    static /* synthetic */ void access$800(StylusSearchFragment r0, boolean r1) {
        r0.stylusConnectedUpdateView(r1);
    }

    static /* synthetic */ Handler access$900(StylusSearchFragment r0) {
        return r0.mHandler;
    }

    public StylusSearchFragment() {
        super(R.layout.revone_fragment_stylus_search);
        this.MSG_CONNECT_STYLUS_TIMEOUT = 1;
        this.CONNECT_STYLUS_TIMEOUT = 5000;
        this.mIsScan = false;
        this.mBluetoothState = false;
        this.mLocationState = false;
        this.mStylusState = -1;
        this.mHandler = new AnonymousClass1(this);
        final Handler r1 = this.mHandler;
        this.mGpsObserver = new AnonymousClass2(this, r1);
        this.mGattUpdateReceiver = new AnonymousClass3(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r5, Bundle r6) {
        super.onViewCreated(r5, r6);
        this.mPageContainer = (LinearLayout) findViewByIdNullable(R.id.page_container);
        this.mBluetoothSwitchEx = (SettingItemSwitch) findViewByIdNullable(R.id.bluetooth_switch);
        this.mLocationSwitchEx = (SettingItemSwitch) findViewByIdNullable(R.id.location_switch);
        this.mPageContainer.setVisibility(8);
        this.mBtTips = (TextView) findViewByIdNullable(R.id.bt_tips);
        this.mMovieTips = (TextView) findViewByIdNullable(R.id.stylus_movie_tips);
        this.mAvalaibleDevice = (TextView) findViewByIdNullable(R.id.avalaible_device);
        this.mKeyTips = (TextView) findViewByIdNullable(R.id.key_tips);
        this.mStylusListView = (RecyclerView) findViewByIdNullable(R.id.stylus_listView);
        this.mItemContainer = (ListContentItemCustom) findViewByIdNullable(R.id.movie_view_container);
        this.mItemClick = (SettingItemText) findViewByIdNullable(R.id.one_click_item);
        this.mItemDoubleClick = (SettingItemText) findViewByIdNullable(R.id.double_click_item);
        this.mItemLongPress = (SettingItemText) findViewByIdNullable(R.id.long_press_item);
        this.mPointerGap = findViewByIdNullable(R.id.id_pointer_gap);
        this.mMovieView = (MovieView) findViewByIdNullable(R.id.movie_view_overview);
        this.mItemClick.setOnClickListener(this);
        this.mItemDoubleClick.setOnClickListener(this);
        this.mItemLongPress.setOnClickListener(this);
        this.mStylusListView.setNestedScrollingEnabled(false);
        BluetoothManager r7 = new BluetoothManager(this.mContext);
        this.mBluetoothManager = r7;
        List<BluetoothDevice> r8 = r7.getConnectedDevices(7);
        this.mStylusListView.setLayoutManager(new LinearLayoutManager(this.mContext));
        AnonymousClass1 r1 = null;
        this.mStylusAdapter = new StylusAdapter(this, r1);
        if (r8 != null) goto L5;
    L12:
        this.mStylusListView.setAdapter(this.mStylusAdapter);
        BluetoothEnabler r9 = new BluetoothEnabler(this.mContext, new OSwitch(this.mContext), null);
        this.mBluetoothEnabler = r9;
        r9.setOnUpdateViewListener(this);
        this.mGpsEnabler = new GpsEnabler(this.mContext, this.mLocationSwitchEx.getSwitch(), this.mGpsObserver);
        BluetoothAdapter r10 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r10;
        this.mBluetoothLeScanner = r10.getBluetoothLeScanner();
        this.mScanCallback = new SampleScanCallback(this, r1);
        this.mHandlerStopScan = new Handler();
        if (this.mBluetoothLeScanner != null) goto L15;
    L17:
        this.mManager = LocalBluetoothManager.getInstance(this.mContext);
        return;
    L15:
        if (isDeviceConnected() == true) goto L17;
        this.mIsScan = true;
        OLog.i(TAG, "startScan 1");
        this.mBluetoothLeScanner.startScan(null, buildScanSettings(), this.mScanCallback);
        stylusScanTimeout();
        goto L17
    L5:
        if (r8.size() <= 0) goto L12;
        OLog.i(TAG, "deviceList:" + r8.size());
        Iterator<BluetoothDevice> r11 = r8.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        BluetoothDevice r2 = r11.next();
        if (isStylus(r2.getAddress()) == false) goto L8;
        this.mStylusAdapter.add(r2);
        this.mStylusAdapter.setBottomCount(0);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        this.mLocationState = this.mGpsEnabler.getGpsSwitchState();
        updateViews();
        this.mLocationSwitchEx.setOnCheckedChangeListener(this);
    }

    private boolean isDeviceConnected() {
        Iterator<BluetoothDevice> r0 = this.mBluetoothManager.getConnectedDevices(7).iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L8;
        if (isStylus(r0.next().getAddress()) == false) goto L4;
        r1 = true;
        goto L4
    L8:
        return r1;
    }

    private boolean isDeviceConnected(String r3) {
        List<BluetoothDevice> r2 = this.mBluetoothManager.getConnectedDevices(7);
        OLog.i(TAG, "isDeviceConnected size:" + r2.size());
        Iterator<BluetoothDevice> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        if (r4.next().getAddress().equals(r3) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isStylus(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L19:
        return false;
    L5:
        if (BluetoothAdapter.checkBluetoothAddress(r4.toUpperCase()) == false) goto L19;
        String[] r3 = r4.split(":");
        String r5 = r3[4] + r3[5];
        OLog.d(TAG, "subString = " + r5);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    L9:
        if (r4.startsWith(STYLUS_MAC_PREFIX) == false) goto L19;
        if (Integer.parseInt(r5, 16) < STYLUS_MAC_BEGIN) goto L19;
        if (Integer.parseInt(r5, 16) > STYLUS_MAC_END) goto L19;
        return true;
    }

    private void stylusScanTimeout() {
        Handler r0 = this.mHandlerStopScan;
        if (r0 == null) goto L6;
        r0.postDelayed(new AnonymousClass4(this), 10000);
        return;
    }

    private ScanSettings buildScanSettings() {
        ScanSettings.Builder r1 = new ScanSettings.Builder();
        r1.setScanMode(2);
        return r1.build();
    }

    public void updateViews() {
        this.mPageContainer.setVisibility(0);
        BluetoothEnabler r0 = this.mBluetoothEnabler;
        if (r0 == null) goto L5;
        r0.resume();
    L5:
        GpsEnabler r1 = this.mGpsEnabler;
        if (r1 == null) goto L8;
        r1.resume();
    L8:
        registerReceiver(this.mGattUpdateReceiver, getGattUpdateIntentFilter());
        if (this.mBluetoothState == true) goto L11;
    L13:
        this.mItemClick.setSubTitle(StylusKeyOperation.getOperationByType(this.mContext, new StylusClickType(144)));
        this.mItemDoubleClick.setSubTitle(StylusKeyOperation.getOperationByType(this.mContext, new StylusClickType(145)));
        this.mItemLongPress.setSubTitle(StylusKeyOperation.getOperationByType(this.mContext, new StylusClickType(147)));
        StylusAdapter r2 = this.mStylusAdapter;
        if (r2 == null) goto L16;
        r2.notifyDataSetChanged();
    L16:
        this.mMovieView.postDelayed(new AnonymousClass5(this), 100);
        return;
    L11:
        if (this.mLocationState == false) goto L13;
        stylusConnectedUpdateView(isDeviceConnected());
        goto L13
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        BluetoothEnabler r0 = this.mBluetoothEnabler;
        if (r0 == null) goto L5;
        r0.pause();
    L5:
        GpsEnabler r1 = this.mGpsEnabler;
        if (r1 == null) goto L8;
        r1.pause();
    L8:
        unregisterReceiver(this.mGattUpdateReceiver);
        this.mMovieView.pauseVideo();
        if (this.mBluetoothLeScanner != null) goto L11;
    L15:
        removeHandlerCallback();
        return;
    L11:
        if (this.mIsScan == false) goto L15;
        if (checkAdapterStateOn() == false) goto L15;
        OLog.i(TAG, "stopScan 1");
        this.mBluetoothLeScanner.stopScan(this.mScanCallback);
        this.mIsScan = false;
        goto L15
    }

    private boolean checkAdapterStateOn() {
        BluetoothAdapter r0 = this.mBluetoothAdapter;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isLeEnabled() == false) goto L7;
        return true;
    }

    private IntentFilter getGattUpdateIntentFilter() {
        IntentFilter r1 = new IntentFilter();
        r1.addAction(Constants.ACTION_GATT_CONNECTED);
        r1.addAction(Constants.ACTION_GATT_DISCONNECTED);
        r1.addAction(Constants.ACTION_STYLUS_BATTERY_LEVEL_CHANGED);
        return r1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r4) {
        Bundle r0 = new Bundle();
        int r5 = r4.getId();
        if (r5 != R.id.double_click_item) goto L5;
        r0.putInt(StylusKeySettingsFragment.EXTRA_CLICK_TYPE, 145);
    L12:
        start(StylusKeySettingsFragment.class, r0);
        return;
    L5:
        if (r5 != R.id.long_press_item) goto L7;
        r0.putInt(StylusKeySettingsFragment.EXTRA_CLICK_TYPE, 147);
        goto L12
    L7:
        if (r5 != R.id.one_click_item) goto L12;
        r0.putInt(StylusKeySettingsFragment.EXTRA_CLICK_TYPE, 144);
        goto L12
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        this.mGpsEnabler.setLocationProviderEnabled(r2);
    }

    @Override // com.android.settings.bluetooth.BluetoothEnabler.OnUpdateViewListener
    public void onUpdateView(boolean r3) {
        this.mBluetoothState = r3;
        OLog.i(TAG, "onUpdateView state:" + r3);
        boolean r0 = this.mGpsEnabler.getGpsSwitchState();
        this.mLocationState = r0;
        if (r3 == false) goto L6;
        if (r0 == false) goto L6;
        boolean r4 = true;
    L7:
        stylusToConnectUpdateView(r4);
        return;
    L6:
        r4 = false;
        goto L7
    }

    private void stylusToConnectUpdateView(boolean r5) {
        if (r5 == false) goto L14;
        this.mBluetoothSwitchEx.setVisibility(8);
        this.mLocationSwitchEx.setVisibility(8);
        this.mBtTips.setVisibility(8);
        this.mMovieTips.setVisibility(0);
        this.mAvalaibleDevice.setVisibility(0);
        this.mStylusListView.setVisibility(0);
        this.mItemContainer.setVisibility(0);
        BluetoothAdapter r6 = BluetoothAdapter.getDefaultAdapter();
        this.mBluetoothAdapter = r6;
        BluetoothLeScanner r7 = r6.getBluetoothLeScanner();
        this.mBluetoothLeScanner = r7;
        if (r7 == null) goto L12;
        if (this.mIsScan == true) goto L12;
        if (isDeviceConnected() == true) goto L12;
        this.mIsScan = true;
        OLog.i(TAG, "startScan 2");
        this.mStylusAdapter.clear();
        this.mBluetoothLeScanner.startScan(null, buildScanSettings(), this.mScanCallback);
        this.mStylusAdapter.notifyDataSetChanged();
        stylusScanTimeout();
    L12:
        if (isDeviceConnected() == false) goto L16;
        stylusConnectedUpdateView(true);
        return;
    L16:
        return;
    L14:
        this.mBluetoothSwitchEx.setVisibility(0);
        this.mLocationSwitchEx.setVisibility(0);
        this.mBtTips.setVisibility(0);
        this.mMovieTips.setVisibility(8);
        this.mAvalaibleDevice.setVisibility(8);
        this.mKeyTips.setVisibility(8);
        this.mItemClick.setVisibility(8);
        this.mItemDoubleClick.setVisibility(8);
        this.mItemLongPress.setVisibility(8);
        this.mStylusListView.setVisibility(8);
        this.mItemContainer.setVisibility(8);
    }

    private void stylusConnectedUpdateView(boolean r3) {
        OLog.i(TAG, "stylusConnectedUpdateView connected:" + r3);
        if (this.mBluetoothState == true) goto L5;
        return;
    L5:
        if (this.mLocationState == true) goto L8;
        return;
    L8:
        if (r3 == false) goto L10;
        this.mKeyTips.setVisibility(0);
        this.mItemClick.setVisibility(0);
        this.mItemDoubleClick.setVisibility(0);
        this.mItemLongPress.setVisibility(0);
        this.mPointerGap.setVisibility(0);
        this.mItemContainer.setVisibility(8);
        this.mMovieTips.setVisibility(8);
        this.mAvalaibleDevice.setVisibility(8);
        this.mStylusAdapter.setBottomCount(0);
        return;
    L10:
        this.mKeyTips.setVisibility(8);
        this.mItemClick.setVisibility(8);
        this.mItemDoubleClick.setVisibility(8);
        this.mItemLongPress.setVisibility(8);
        this.mPointerGap.setVisibility(8);
        this.mItemContainer.setVisibility(0);
        this.mMovieTips.setVisibility(0);
        this.mAvalaibleDevice.setVisibility(0);
        this.mStylusAdapter.setBottomCount(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mMovieView.releaseVideo();
    }

    private void removeHandlerCallback() {
        Handler r0 = this.mHandlerStopScan;
        if (r0 == null) goto L5;
        r0.removeCallbacksAndMessages(null);
    L5:
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void sendDisconnectBroadcast(String r2) {
        sendBroadcast(new Intent(r2));
    }

    private void saveStylusName(BluetoothDevice r5) {
        HashMap<String, String> r0 = Utils.getStylus(this.mContext, Constants.KEY_STYLUS_NAME, null);
        if (r0 != null) goto L5;
        r0 = new HashMap();
    L5:
        OLog.i(TAG, "stylusNameMap:" + r0);
        if (TextUtils.isEmpty(r0.get(r5.getAddress())) == false) goto L9;
        r0.put(r5.getAddress(), r5.getName());
        Utils.putStylus(this.mContext, Constants.KEY_STYLUS_NAME, r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(StylusSearchFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusSearchFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(StylusSearchFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_StylusSearchFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(StylusSearchFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_StylusSearchFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
