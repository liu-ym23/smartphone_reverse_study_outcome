package com.android.settings.bluetooth;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.ProgressCategory;
import com.android.settings.R;
import com.android.settings.utils.HanziToPinyin;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.SLog;
import com.android.settings.utils.UIUtils;
import com.obric.cae.libs.bluetooth.BtDeviceInfoExtEvent;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.text.OTextView;
import java.util.Iterator;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothDevicePreference extends Preference implements CachedBluetoothDevice.Callback, View.OnClickListener {
    protected static final int MSG_REFRESH_DEVICE_PREFERENCE_BACKGROUND = 1;
    private static final int OK_BUTTON = -1;
    private static final String TAG = "BluetoothDevicePreference";
    private static int sDimAlpha = Integer.MIN_VALUE;
    private View loadingImg;
    private ImageView mAudioCodec;
    private SmartBluetoothBinderClient mBluetoothBinderClient;
    private final BroadcastReceiver mBluetoothReceiver;
    private final CachedBluetoothDevice mCachedDevice;
    private Context mContext;
    private View mDeviceDetails;
    private OnGetDeviceViewListener mDeviceViewListener;
    private OAlertDialog mDisconnectDialog;
    private PreferenceGroup mGroup;
    private Handler mHandler;
    private boolean mIsConnected;
    private boolean mIsPair;
    private boolean mIsProfileButtonVisible;
    private OCardListItem mItemContainer;
    private final OnPreferenceClickListener mOnPreferenceClickListener;
    private View.OnClickListener mOnSettingsClickListener;
    private LinearLayout mTitleContainer;
    private OTextView titleView;

    public interface OnGetDeviceViewListener {
        boolean onGetDeviceViewVisible();
    }

    public interface OnPreferenceClickListener {
        void onClick(BluetoothDevicePreference r1);
    }

    static {
    }

    private int getCardPosition(int r1, int r2) {
        if (r2 == 1) goto L9;
        if (r1 == 0) goto L10;
        return 2;
    L10:
        return 1;
    L9:
        return 1;
    }

    private int getCardPositionNormal(int r1, int r2) {
        if (r2 != 1) goto L5;
        return 0;
    L5:
        if (r1 != 0) goto L8;
        return 1;
    L8:
        if (r1 != (r2 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }

    private String safeString(String r1) {
        if (r1 != null) goto L5;
        return "";
    L5:
        return r1;
    }

    static /* synthetic */ CachedBluetoothDevice access$000(BluetoothDevicePreference r0) {
        return r0.mCachedDevice;
    }

    static /* synthetic */ BroadcastReceiver access$100(BluetoothDevicePreference r0) {
        return r0.mBluetoothReceiver;
    }

    static /* synthetic */ Context access$200(BluetoothDevicePreference r0) {
        return r0.mContext;
    }

    static /* synthetic */ OAlertDialog access$300(BluetoothDevicePreference r0) {
        return r0.mDisconnectDialog;
    }

    @Override // androidx.preference.Preference, java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Preference r1) {
        return compareTo(r1);
    }

    public BluetoothDevicePreference(Context r4, CachedBluetoothDevice r5, OnPreferenceClickListener r6) {
        super(r4);
        this.mBluetoothReceiver = new AnonymousClass5(this);
        setLayoutResource(R.layout.bluetooth_setting_item_layout);
        if (sDimAlpha != Integer.MIN_VALUE) goto L5;
        TypedValue r0 = new TypedValue();
        r4.getTheme().resolveAttribute(android.R.attr.disabledAlpha, r0, true);
        sDimAlpha = (int) (r0.getFloat() * 255.0f);
    L5:
        this.mCachedDevice = r5;
        this.mIsConnected = r5.isConnected();
        this.mOnPreferenceClickListener = r6;
        onDeviceAttributesChanged(false);
    }

    public BluetoothDevicePreference(Context r1, CachedBluetoothDevice r2, Handler r3, OnPreferenceClickListener r4, SmartBluetoothBinderClient r5, PreferenceGroup r6) {
        this(r1, r2, r4);
        this.mHandler = r3;
        this.mBluetoothBinderClient = r5;
        this.mGroup = r6;
    }

    public void setPair(boolean r1) {
        this.mIsPair = r1;
    }

    CachedBluetoothDevice getCachedDevice() {
        return this.mCachedDevice;
    }

    public void setOnSettingsClickListener(View.OnClickListener r1) {
        this.mOnSettingsClickListener = r1;
    }

    public void setOnGetDeviceViewListener(OnGetDeviceViewListener r1) {
        this.mDeviceViewListener = r1;
    }

    @Override // androidx.preference.Preference
    protected void onPrepareForRemoval() {
        super.onPrepareForRemoval();
        this.mCachedDevice.unregisterCallback(this);
        clearViewReferences();
    }

    @Override // androidx.preference.Preference
    public void onDetached() {
        super.onDetached();
        clearViewReferences();
    }

    private void clearViewReferences() {
        this.mItemContainer = null;
        this.mTitleContainer = null;
        this.titleView = null;
        this.loadingImg = null;
        this.mDeviceDetails = null;
        this.mAudioCodec = null;
    }

    public void refresh() {
        notifyHierarchyChanged();
    }

    public void refreshParent() {
        PreferenceGroup r1 = getParent();
        if ((r1 instanceof ProgressCategory) == false) goto L6;
        ((ProgressCategory) r1).refreshOrder();
        return;
    }

    private void setCardListItemTitle(CharSequence r2) {
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setTitle(r2);
        this.mItemContainer.showTitle(true);
        return;
    }

    private void setCardListItemSubTitle(CharSequence r2) {
        OCardListItem r0 = this.mItemContainer;
        if (r0 == null) goto L6;
        r0.setSubTitle(r2);
        this.mItemContainer.showSubTitle(true);
        return;
    }

    public void setCardPosition() {
        PreferenceGroup r0 = this.mGroup;
        if (r0 == null) goto L34;
        int r1 = r0.getPreferenceCount();     // Catch: Exception -> L27
        int r2 = 0;
    L5:
        if (r2 >= r1) goto L10;
        if (this.mGroup.getPreference(r2) == this) goto L11;
        r2 = r2 + 1;     // Catch: Exception -> L27
    L11:
        if (r2 < 0) goto L35;
        OCardListItem r3 = this.mItemContainer;     // Catch: Exception -> L27
        if (r3 != null) goto L15;
        return;
    L15:
        if ((r3.getContext() instanceof HiddenDeviceActivity) == false) goto L17;
    L24:
        int r4 = getCardPositionNormal(r2, r1);     // Catch: Exception -> L27
    L25:
        this.mItemContainer.setCardPosition(r4);     // Catch: Exception -> L27
        return;
    L17:
        if (this.mIsPair == true) goto L24;
        OnGetDeviceViewListener r5 = this.mDeviceViewListener;     // Catch: Exception -> L27
        if (r5 == null) goto L24;
        if (r5.onGetDeviceViewVisible() == false) goto L24;
        r4 = getCardPosition(r2, r1);     // Catch: Exception -> L27
        goto L25
    L35:
        return;
    L10:
        r2 = -1;
    L27:
        e = move-exception;
        OLog.e(TAG, "setCardPosition: error: " + e.getMessage());
        return;
    }

    @Override // com.android.settings.bluetooth.CachedBluetoothDevice.Callback
    public void onDeviceAttributesChanged(boolean r5) {
        SLog.d(TAG, "DeviceAttributesChanged on device:" + this.mCachedDevice.getDevice().getAddress() + "; mCachedDevice name: " + this.mCachedDevice.getName());
        setCardPosition();
        setCardListItemTitle(this.mCachedDevice.getName());
        String r0 = getConnectionSummary();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        String r1 = r0;
    L6:
        setCardListItemSubTitle(r1);
        if (r5 == true) goto L13;
        setTitle(this.mCachedDevice.getName());
        if (TextUtils.isEmpty(r0) == false) goto L12;
        r0 = null;
    L12:
        setSummary(r0);
    L13:
        updateCodecIconUI();
        boolean r6 = this.mCachedDevice.isBusy();
        if (BluetoothUtils.isActiveDevice(this.mCachedDevice.getDevice()) == false) goto L16;
        r6 = false;
    L16:
        View r2 = this.loadingImg;
        if (r2 == null) goto L23;
        if (r6 == false) goto L20;
        int r3 = 0;
    L21:
        r2.setVisibility(r3);
        goto L23
    L20:
        r3 = 8;
    L23:
        if (this.mDeviceDetails != null) goto L25;
    L31:
        CachedBluetoothDevice r7 = this.mCachedDevice;
        monitor-enter(r7);
        boolean r4 = this.mCachedDevice.isConnected();     // Catch: Throwable -> L40
        if (this.mIsConnected == r4) goto L38;
        this.mIsConnected = r4;     // Catch: Throwable -> L40
        notifyHierarchyChanged();     // Catch: Throwable -> L40
        if (this.mHandler == null) goto L38;
        OLog.d(TAG, "connection state changed, send msg to refresh");     // Catch: Throwable -> L40
        this.mHandler.removeMessages(1);     // Catch: Throwable -> L40
        this.mHandler.sendEmptyMessage(1);     // Catch: Throwable -> L40
    L38:
        monitor-exit(r7);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        throw th;
    L25:
        if (this.mCachedDevice.getBondState() == 12) goto L27;
    L30:
        this.mDeviceDetails.setVisibility(8);
        goto L31
    L27:
        if (this.mIsProfileButtonVisible == false) goto L30;
        if (r6 == true) goto L30;
        this.mDeviceDetails.setVisibility(0);
        goto L31
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r6) {
        super.onBindViewHolder(r6);
        View r7 = r6.itemView;
        if (findPreferenceInHierarchy("bt_checkbox") == null) goto L5;
        setDependency("bt_checkbox");
    L5:
        OCardListItem r8 = (OCardListItem) r7.findViewById(R.id.list_item_container);
        this.mItemContainer = r8;
        this.mTitleContainer = (LinearLayout) r8.findViewById(R.id.title_container);
        this.mItemContainer.setOnContentClickListener(new BluetoothDevicePreference$$ExternalSyntheticLambda0(this));
        View r9 = LayoutInflater.from(getContext()).inflate(R.layout.bluetooth_info_loading_layout, null, false);
        View r0 = r9.findViewById(R.id.info_img);
        this.loadingImg = r9.findViewById(R.id.loading_view);
        this.mDeviceDetails = r0;
        this.mItemContainer.showCustomEnd(true);
        this.mItemContainer.setCustomEndView(r9);
        ViewGroup.LayoutParams r1 = r9.getLayoutParams();
        r1.height = -1;
        r1.width = -1;
        r9.setLayoutParams(r1);
        UIUtils.updatePadding(r9, -1, -1, UIUtils.INSTANCE.dp2px(7), -1);
        if (this.mCachedDevice.getBondState() != 12) goto L10;
        View r10 = this.mDeviceDetails;
        if (r10 == null) goto L10;
        r10.setOnClickListener(this);
        this.mDeviceDetails.setTag(this.mCachedDevice);
    L10:
        View r11 = this.mDeviceDetails;
        if (r11 == null) goto L13;
        UIUtils.expandTouchArea(r11, 10);
    L13:
        ImageView r12 = this.mItemContainer.getIconView();
        if (r12 == null) goto L19;
        r12.setScaleType(ImageView.ScaleType.CENTER);
        int r2 = getBluetoothDeviceDrawable();
        if (r2 == 0) goto L18;
        this.mItemContainer.setIcon(r2);
    L18:
        r12.setVisibility(0);
    L19:
        this.mAudioCodec = new ImageView(getContext());
        OTextView r13 = this.mItemContainer.getTitleView();
        this.titleView = r13;
        LinearLayout.LayoutParams r14 = (LinearLayout.LayoutParams) r13.getLayoutParams();
        r14.width = -2;
        this.titleView.setLayoutParams(r14);
        this.titleView.setCompoundDrawablePadding(com.android.settings.Utils.dp2Pixels(getContext(), 6.0f));
        this.titleView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams r15 = (LinearLayout.LayoutParams) this.mItemContainer.getSubTitleView().getLayoutParams();
        r15.width = -2;
        this.mItemContainer.getSubTitleView().setLayoutParams(r15);
        this.mItemContainer.showSubTitle(true);
        this.mTitleContainer.setGravity(16);
        updateCodecIconUI();
        onDeviceAttributesChanged(true);
    }

    /* JADX INFO: renamed from: lambda$onBindViewHolder$0$com-android-settings-bluetooth-BluetoothDevicePreference, reason: not valid java name */
    /* synthetic */ void m348x85b831ee(View r2) {
        OLog.d(TAG, "onClick BluetoothDevicePreference: " + this.mCachedDevice.getName());
        this.mOnPreferenceClickListener.onClick(this);
    }

    public void setProfileButtonVisible(boolean r1) {
        this.mIsProfileButtonVisible = r1;
        if (this.mDeviceDetails != null) goto L6;
        OLog.d(TAG, "mDeviceDetails == null");
        return;
    L6:
        onDeviceAttributesChanged(false);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
        View.OnClickListener r0 = this.mOnSettingsClickListener;
        if (r0 == null) goto L6;
        r0.onClick(r1);
        return;
    }

    public boolean equals(Object r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if ((r2 instanceof BluetoothDevicePreference) == true) goto L7;
        return false;
    L7:
        return this.mCachedDevice.equals(((BluetoothDevicePreference) r2).mCachedDevice);
    }

    public int hashCode() {
        return this.mCachedDevice.hashCode();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.preference.Preference
    public int compareTo(Preference r5) {
        if ((r5 instanceof BluetoothDevicePreference) == false) goto L5;
        int r1 = this.mCachedDevice.compareTo2(((BluetoothDevicePreference) r5).mCachedDevice);     // Catch: Exception -> L9
        OLog.d(TAG, "compareTo_compared another=" + getCachedDeviceName((BluetoothDevicePreference) r5) + " this=" + getCachedDeviceName(this) + HanziToPinyin.Token.SEPARATOR + r1);
        return r1;
    L9:
        e = move-exception;
        OLog.e(TAG, "compareTo error", e);
        return compareFallback((BluetoothDevicePreference) r5);
    L5:
        return super.compareTo2(r5);
    }

    private String getCachedDeviceName(BluetoothDevicePreference r1) {
        if (r1 == null) goto L8;
        CachedBluetoothDevice r2 = r1.mCachedDevice;
        if (r2 != null) goto L7;
        return "";
    L7:
        return safeString(r2.getName());
    L8:
        return "";
    }

    private int compareFallback(BluetoothDevicePreference r4) {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        String r1 = "";
        if (r0 != null) goto L5;
        String r2 = "";
    L6:
        if (r4 == null) goto L11;
        CachedBluetoothDevice r3 = r4.mCachedDevice;
        if (r3 == null) goto L11;
        String r5 = r3.getName();
    L12:
        int r6 = safeString(r2).compareTo(safeString(r5));
        if (r6 == 0) goto L15;
        return r6;
    L15:
        CachedBluetoothDevice r7 = this.mCachedDevice;
        if (r7 != null) goto L18;
    L21:
        String r8 = "";
    L22:
        if (r4 == null) goto L30;
        CachedBluetoothDevice r9 = r4.mCachedDevice;
        if (r9 == null) goto L30;
        if (r9.getDevice() == null) goto L30;
        r1 = r4.mCachedDevice.getDevice().getAddress();
    L30:
        return safeString(r8).compareTo(safeString(r1));
    L18:
        if (r7.getDevice() == null) goto L21;
        r8 = this.mCachedDevice.getDevice().getAddress();
    L11:
        r5 = "";
        goto L12
    L5:
        r2 = r0.getName();
        goto L6
    }

    @Override // androidx.preference.Preference
    protected void onAttachedToHierarchy(PreferenceManager r1) {
        super.onAttachedToHierarchy(r1);
        this.mCachedDevice.registerCallback(this);
    }

    void onClicked() {
        int r0 = this.mCachedDevice.getBondState();
        boolean r1 = BluetoothUtils.isActiveDevice(this.mCachedDevice.getDevice());
        OLog.d(TAG, "onClicked, bondState:" + r0 + "; isActiveDevice:" + r1 + "; connected:" + this.mCachedDevice.isConnected());
        if (r1 == false) goto L8;
        View r4 = this.mDeviceDetails;
        if (r4 == null) goto L22;
        r4.performClick();
        return;
    L22:
        return;
    L8:
        if (this.mCachedDevice.isConnected() == false) goto L16;
        if (BluetoothUtils.canSetActive(this.mCachedDevice) == false) goto L12;
        BluetoothUtils.setActiveDevice(this.mCachedDevice.getDevice());
        return;
    L12:
        View r5 = this.mDeviceDetails;
        if (r5 == null) goto L25;
        r5.performClick();
        return;
    L25:
        return;
    L16:
        if (r0 != 12) goto L19;
        this.mCachedDevice.connect(true);
        return;
    L19:
        if (r0 != 10) goto L28;
        pair();
        return;
    }

    private void askDisconnect() {
        this.mContext = getContext();
        String r0 = this.mCachedDevice.getName();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        r0 = this.mContext.getString(R.string.bluetooth_device);
    L5:
        String r1 = this.mContext.getString(R.string.bluetooth_disconnect_all_profiles, new Object[]{r0});
        String r6 = this.mContext.getString(R.string.bluetooth_disconnect_title);
        final IntentFilter r2 = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
        DialogInterface.OnClickListener r4 = new AnonymousClass1(this);
        DialogInterface.OnClickListener r5 = new AnonymousClass2(this);
        DialogInterface.OnDismissListener r9 = new AnonymousClass3(this);
        DialogInterface.OnShowListener r8 = new AnonymousClass4(this, r2);
        OAlertDialog r3 = this.mDisconnectDialog;
        if (r3 == null) goto L8;
        r3.dismiss();
    L8:
        this.mDisconnectDialog = Utils.showDisconnectDialog(this.mContext, r4, r5, r6, Html.fromHtml(r1), r8, r9);
    }

    private void pair() {
        if (this.mCachedDevice.startPairing() == true) goto L6;
        Utils.showError(getContext(), this.mCachedDevice.getName(), R.string.bluetooth_pairing_error_message);
        return;
    }

    private String getConnectionSummary() {
        CachedBluetoothDevice r0 = this.mCachedDevice;
        SLog.d(TAG, "getConnectionSummary " + r0.getName());
        Iterator<LocalBluetoothProfile> r1 = r0.getProfiles().iterator();
        boolean r5 = false;
        int r6 = -1;
    L4:
        if (r1.hasNext() == false) goto L29;
        LocalBluetoothProfile r7 = r1.next();
        int r9 = r0.getProfileConnectionState(r7);
        if (r9 != 0) goto L7;
        if (r7.isProfileReady() == false) goto L4;
        if ((r7 instanceof A2dpProfile) == true) goto L4;
        boolean r8 = r7 instanceof HeadsetProfile;
        goto L4
    L7:
        if (r9 == 1) goto L15;
        if (r9 != 2) goto L11;
        r5 = true;
        goto L4
    L11:
        if (r9 != 3) goto L4;
    L15:
        if ((r7 instanceof A2dpProfile) == true) goto L21;
        if ((r7 instanceof HeadsetProfile) == true) goto L21;
        r6 = r9;
    L21:
        return ResourceUtils.getString(Utils.getConnectionStateSummary(r9));
    L29:
        if (r5 == false) goto L40;
        String r2 = ResourceUtils.getString(R.string.bluetooth_connected);
        boolean r4 = BluetoothUtils.isActiveDevice(r0.getDevice());
        if (r4 == false) goto L33;
        refreshParent();
        r2 = ResourceUtils.getString(R.string.bluetooth_active_device);
    L33:
        int r11 = r0.getDevice().getBatteryLevel();
        OLog.d(TAG, "batteryLevel:" + r11 + " isActiveDevice:" + r4);
        if (r11 >= 0) goto L36;
    L39:
        return r2;
    L36:
        if (r11 > 100) goto L39;
        return r2 + ResourceUtils.getStringFormat(R.string.bluetooth_device_battery, new Object[]{Integer.valueOf(r11)});
    L40:
        if (r6 == (-1)) goto L44;
        return ResourceUtils.getString(Utils.getConnectionStateSummary(r6));
    L44:
        if (r0.getBondState() == 11) goto L56;
        BluetoothDevice r12 = r0.getDevice();
        if (r12 != null) goto L49;
        return "";
    L49:
        if (r12.isConnected() == true) goto L51;
    L54:
        return "";
    L51:
        if (r12.getBondState() == 10) goto L54;
        OLog.i(TAG, "device is connected but bond state is not none, show connect");
        return ResourceUtils.getString(R.string.bluetooth_connected);
    L56:
        return ResourceUtils.getString(R.string.bluetooth_pairing);
    }

    private int getBluetoothDeviceDrawable() {
        int r0 = this.mCachedDevice.getProductId();
        if (r0 != (-1)) goto L7;
        SmartBluetoothBinderClient r1 = this.mBluetoothBinderClient;
        if (r1 == null) goto L7;
        r0 = r1.getProductId(this.mCachedDevice.getDevice());
    L7:
        OLog.d(TAG, this.mCachedDevice.getName() + " productId:" + r0);
        if (r0 != 4096) goto L10;
        return R.drawable.settings_oic_glasses_fill;
    L10:
        boolean r2 = true;
        if (r0 != 1) goto L15;
        return R.drawable.settings_oic_oladance_earphone;
    L15:
        if (r0 != 365) goto L17;
        return R.drawable.settings_oic_freebudspro_double;
    L17:
        if (r0 != 363) goto L20;
        return R.drawable.settings_oic_freebudspro_double;
    L20:
        if (r0 != 359) goto L23;
        return R.drawable.settings_oic_freeclip2_double;
    L23:
        SmartBluetoothBinderClient r3 = this.mBluetoothBinderClient;
        if (r3 == null) goto L26;
        BtDeviceInfoExtEvent r4 = r3.getDeviceType(this.mCachedDevice.getDevice());
    L27:
        if (r4 == null) goto L76;
        int r5 = r4.getDeviceType();
        OLog.i(TAG, "device_name:" + this.mCachedDevice.getName() + " deviceType：" + r5);
        switch(r5) {
            case 1: goto L74;
            case 2: goto L72;
            case 3: goto L70;
            case 4: goto L68;
            case 5: goto L66;
            case 6: goto L64;
            case 7: goto L62;
            case 8: goto L60;
            case 9: goto L58;
            case 10: goto L30;
            case 11: goto L56;
            case 12: goto L55;
            case 13: goto L53;
            case 14: goto L51;
            case 15: goto L49;
            case 16: goto L47;
            case 17: goto L45;
            case 18: goto L43;
            case 19: goto L41;
            case 20: goto L39;
            case 21: goto L37;
            case 22: goto L35;
            case 23: goto L33;
            case 24: goto L31;
            default: goto L30;
        };
    L30:
        OLog.d(TAG, "unrecognized deviceType");
    L77:
        Iterator<LocalBluetoothProfile> r6 = this.mCachedDevice.getProfiles().iterator();
    L79:
        if (r6.hasNext() == false) goto L85;
        LocalBluetoothProfile r7 = r6.next();
        if ((r7 instanceof A2dpProfile) == true) goto L86;
        if ((r7 instanceof HeadsetProfile) == false) goto L79;
    L86:
        if (r2 == false) goto L89;
        return R.drawable.settings_oic_speaker_bluetooth_fill;
    L89:
        return R.drawable.settings_oicon_selector_ic_bt_unknown;
    L85:
        r2 = false;
        goto L86
    L31:
        return R.drawable.settings_oic_gimbal_camera_fill;
    L33:
        return R.drawable.settings_oic_electric_vehicles_fill;
    L35:
        return R.drawable.settings_oic_phone_selfie_stick_fill;
    L37:
        return R.drawable.settings_oic_printer_fill;
    L39:
        return R.drawable.settings_oic_projector_fill;
    L41:
        return R.drawable.settings_oic_vr_fill;
    L43:
        return R.drawable.settings_oic_game_controller_fill;
    L45:
        return R.drawable.settings_oic_headphone;
    L47:
        return R.drawable.settings_oic_tv_fill;
    L49:
        return R.drawable.settings_oic_microphone_fill;
    L51:
        return R.drawable.settings_oic_laptop_macbookf_fill;
    L53:
        return R.drawable.settings_oic_pad_fill;
    L55:
        return R.drawable.settings_oic_glasses_fill;
    L56:
        return R.drawable.settings_oic_bike_fill;
    L58:
        return R.drawable.settings_oic_mouse_fill;
    L60:
        return R.drawable.settings_oic_keyboard_26_fill;
    L62:
        return R.drawable.settings_oic_phone_portrait_fill;
    L64:
        return R.drawable.settings_oic_desktop_pc_fill;
    L66:
        return R.drawable.settings_oic_watch_rectangle_fill;
    L68:
        return R.drawable.settings_oic_watch_circle_fill;
    L70:
        return R.drawable.settings_oic_hifi_speaker_fill;
    L72:
        return R.drawable.settings_oic_car_fill;
    L74:
        return R.drawable.settings_oic_earphone_earbud_alt_fill;
    L76:
        OLog.w(TAG, "deviceInfoExtEvent is null");
        goto L77
    L26:
        r4 = null;
        goto L27
    }

    private int getAudioCodecDrawable() {
        if (this.mCachedDevice.isConnected() == true) goto L5;
        return 0;
    L5:
        int r3 = this.mCachedDevice.getAudioCodec();
        OLog.d(TAG, "audio codec is " + r3);
        switch(r3) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            default: goto L7;
        };
    L7:
        return 0;
    L8:
        return R.drawable.ldhc;
    L10:
        return R.drawable.aptx_adaptive;
    L12:
        return R.drawable.opus;
    L14:
        return R.drawable.lc3;
    L16:
        return R.drawable.ldac;
    L18:
        return R.drawable.aptx_hd;
    L20:
        return R.drawable.aptx;
    L22:
        return R.drawable.aac;
    L24:
        return R.drawable.sbc;
    }

    private boolean isA2dpConnected() {
        CachedBluetoothDevice r4 = this.mCachedDevice;
        Iterator<LocalBluetoothProfile> r0 = r4.getProfiles().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        LocalBluetoothProfile r1 = r0.next();
        if (r4.getProfileConnectionState(r1) != 2) goto L4;
        if ((r1 instanceof A2dpProfile) == false) goto L4;
        return true;
    L10:
        return false;
    }

    private void updateCodecIconUI() {
        if (this.mAudioCodec != null) goto L5;
    L10:
        ImageView r0 = this.mAudioCodec;
        if (r0 == null) goto L13;
        r0.setVisibility(8);
    L13:
        OTextView r4 = this.titleView;
        if (r4 == null) goto L19;
        r4.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        return;
    L19:
        return;
    L5:
        if (isA2dpConnected() == false) goto L10;
        int r1 = getAudioCodecDrawable();
        if (r1 == 0) goto L9;
        BluetoothUtils.updateCodeType(this.mCachedDevice.getDevice().getAddress(), this.mCachedDevice.getAudioCodec());
        this.mAudioCodec.setVisibility(0);
        Drawable r2 = getContext().getDrawable(r1);
        this.mAudioCodec.setImageDrawable(r2);
        this.titleView.setCompoundDrawablesWithIntrinsicBounds(null, null, r2, null);
        return;
    L9:
        this.mAudioCodec.setVisibility(8);
        this.titleView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
}
