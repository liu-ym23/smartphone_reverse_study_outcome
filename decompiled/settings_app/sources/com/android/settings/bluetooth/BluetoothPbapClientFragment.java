package com.android.settings.bluetooth;

import android.accounts.Account;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.client.pbap.BluetoothPbapClient;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.OperationApplicationException;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.preference.BluetoothCategory;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceScreen;
import androidx.recyclerview.widget.RecyclerView;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.accounts.ManageAccountsSettings;
import com.android.settings.applications.utils.ODialogUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.HanziToPinyin;
import com.android.vcard.VCardEntry;
import com.obric.olog.OLog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class BluetoothPbapClientFragment extends DeviceListPreferenceFragment {
    private static final int CONNECTION_TIMEOUT = 8000;
    private static final boolean D = true;
    private static final int DEVICE_DELAY_TIMEOUT = 10000;
    private static final String EXTRA_FROM_OUTSIDE = "from_outside";
    private static final int MAX_SIZE_GROUP = 20;
    private static final int MSG_CANCEL_SCAN = 62;
    private static final int MSG_HIDE_REFRESH_LOADING = 64;
    private static final int MSG_REFESH = 4;
    private static final int MSG_SCAN = 65;
    private static final int MSG_SHOW_REFRESH_LOADING = 63;
    public static final String PB_PATH = "telecom/pb.vcf";
    private static final int SELECT_ACCOUNT = 19;
    private static final String TAG = "BluetoothPbapClientIntroduction";
    private static boolean mShouldShutdownBt = false;
    private final int MSG_ABORT;
    private final int MSG_CONNECT;
    private final int MSG_DEVICE_DELAYED;
    private final int MSG_DISCONNECT;
    private final int MSG_GET_PBSIZE;
    private final int MSG_IMPORT_DIALOG;
    private final int MSG_IMPORT_PHONEBOOK;
    private final int MSG_NO_CONTACTS;
    private final int MSG_PULL_PHONEBOOK;
    private final int MSG_REFRESH_DEVICE;
    private final int MSG_TIMEOUT;
    private final int MSG_UPDATE_PROGRESS;
    private final String PACKAGE_NAME;
    private HashSet<String> entrySet;
    private Account mAccount;
    private int mActualNumber;
    private BluetoothAdapter mAdapter;
    private int mAdapterState;
    private BluetoothCategory mAvailableDevicesCategory;
    private Button mButton;
    private ArrayList<VCardEntry> mCards;
    private BluetoothPbapClient mClient;
    private OAlertDialog mConfirmDialog;
    private boolean mConnectSocketWhenBonded;
    private Context mContext;
    private int mCurrentSize;
    private BluetoothDevice mDevice;
    private Handler mHandler;
    private IntentFilter mIntentFilter;
    private boolean mIsCancel;
    private boolean mIsException;
    private boolean mIsSuccess;
    private boolean mNeedContinue;
    private PreferenceGroup mPairedDevicesCategory;
    private int mPhoneBookSize;
    private boolean mProfileConnected;
    private StatusDialog mProgress;
    private int mProgressCount;
    public final BroadcastReceiver mReceiver;
    private Handler mWorkHandler;
    private HandlerThread mWorkThread;
    private boolean stopScanForNoNecessary;

    private class VCardImportHandler extends Handler {
        final /* synthetic */ BluetoothPbapClientFragment this$0;

        public VCardImportHandler(BluetoothPbapClientFragment r1, Looper r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r1) {
            ArrayList r2 = (ArrayList) r1.obj;
            if (r2 == null) goto L6;
            BluetoothPbapClientFragment.access$2300(this.this$0, r2);
            return;
        }
    }

    static {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // androidx.preference.PreferenceFragmentCompat
    public void onCreatePreferences(Bundle r1, String r2) {
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ BluetoothDevice access$000(BluetoothPbapClientFragment r0) {
        return r0.mDevice;
    }

    static /* synthetic */ BluetoothDevice access$002(BluetoothPbapClientFragment r0, BluetoothDevice r1) {
        r0.mDevice = r1;
        return r1;
    }

    static /* synthetic */ Handler access$100(BluetoothPbapClientFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ int access$1000(BluetoothPbapClientFragment r0) {
        return r0.mProgressCount;
    }

    static /* synthetic */ int access$1002(BluetoothPbapClientFragment r0, int r1) {
        r0.mProgressCount = r1;
        return r1;
    }

    static /* synthetic */ int access$1004(BluetoothPbapClientFragment r1) {
        int r0 = r1.mProgressCount + 1;
        r1.mProgressCount = r0;
        return r0;
    }

    static /* synthetic */ boolean access$1100(BluetoothPbapClientFragment r0) {
        return r0.mIsSuccess;
    }

    static /* synthetic */ boolean access$1102(BluetoothPbapClientFragment r0, boolean r1) {
        r0.mIsSuccess = r1;
        return r1;
    }

    static /* synthetic */ Handler access$1200(BluetoothPbapClientFragment r0) {
        return r0.mWorkHandler;
    }

    static /* synthetic */ StatusDialog access$1300(BluetoothPbapClientFragment r0) {
        return r0.mProgress;
    }

    static /* synthetic */ void access$1400(BluetoothPbapClientFragment r0, int r1) {
        r0.refreshProgressDialog(r1);
    }

    static /* synthetic */ Account access$1500(BluetoothPbapClientFragment r0) {
        return r0.mAccount;
    }

    static /* synthetic */ ArrayList access$1600(BluetoothPbapClientFragment r0) {
        return r0.mCards;
    }

    static /* synthetic */ boolean access$1700(BluetoothPbapClientFragment r0) {
        return r0.mIsCancel;
    }

    static /* synthetic */ boolean access$1702(BluetoothPbapClientFragment r0, boolean r1) {
        r0.mIsCancel = r1;
        return r1;
    }

    static /* synthetic */ Context access$1800(BluetoothPbapClientFragment r0) {
        return r0.mContext;
    }

    static /* synthetic */ OAlertDialog access$1900(BluetoothPbapClientFragment r0) {
        return r0.mConfirmDialog;
    }

    static /* synthetic */ OAlertDialog access$1902(BluetoothPbapClientFragment r0, OAlertDialog r1) {
        r0.mConfirmDialog = r1;
        return r1;
    }

    static /* synthetic */ BluetoothPbapClient access$200(BluetoothPbapClientFragment r0) {
        return r0.mClient;
    }

    static /* synthetic */ void access$2000(BluetoothPbapClientFragment r0, int r1, boolean r2) {
        r0.updateContent(r1, r2);
    }

    static /* synthetic */ boolean access$2102(BluetoothPbapClientFragment r0, boolean r1) {
        r0.stopScanForNoNecessary = r1;
        return r1;
    }

    static /* synthetic */ BluetoothCategory access$2200(BluetoothPbapClientFragment r0) {
        return r0.mAvailableDevicesCategory;
    }

    static /* synthetic */ void access$2300(BluetoothPbapClientFragment r0, ArrayList r1) {
        r0.importVCardEntries(r1);
    }

    static /* synthetic */ boolean access$300(BluetoothPbapClientFragment r0, String r1) {
        return r0.startScanning(r1);
    }

    static /* synthetic */ boolean access$400(BluetoothPbapClientFragment r0) {
        return r0.mIsException;
    }

    static /* synthetic */ boolean access$402(BluetoothPbapClientFragment r0, boolean r1) {
        r0.mIsException = r1;
        return r1;
    }

    static /* synthetic */ boolean access$500(BluetoothPbapClientFragment r0) {
        return r0.mProfileConnected;
    }

    static /* synthetic */ boolean access$502(BluetoothPbapClientFragment r0, boolean r1) {
        r0.mProfileConnected = r1;
        return r1;
    }

    static /* synthetic */ boolean access$600(BluetoothPbapClientFragment r0) {
        return r0.mNeedContinue;
    }

    static /* synthetic */ boolean access$602(BluetoothPbapClientFragment r0, boolean r1) {
        r0.mNeedContinue = r1;
        return r1;
    }

    static /* synthetic */ int access$700(BluetoothPbapClientFragment r0) {
        return r0.mCurrentSize;
    }

    static /* synthetic */ int access$702(BluetoothPbapClientFragment r0, int r1) {
        r0.mCurrentSize = r1;
        return r1;
    }

    static /* synthetic */ int access$800(BluetoothPbapClientFragment r0) {
        return r0.mPhoneBookSize;
    }

    static /* synthetic */ int access$802(BluetoothPbapClientFragment r0, int r1) {
        r0.mPhoneBookSize = r1;
        return r1;
    }

    static /* synthetic */ int access$900(BluetoothPbapClientFragment r0) {
        return r0.mActualNumber;
    }

    static /* synthetic */ int access$902(BluetoothPbapClientFragment r0, int r1) {
        r0.mActualNumber = r1;
        return r1;
    }

    public BluetoothPbapClientFragment() {
        this.PACKAGE_NAME = "com.android.settings.bluetooth";
        this.MSG_CONNECT = 50;
        this.MSG_DISCONNECT = 51;
        this.MSG_GET_PBSIZE = 52;
        this.MSG_PULL_PHONEBOOK = 53;
        this.MSG_IMPORT_PHONEBOOK = 54;
        this.MSG_IMPORT_DIALOG = 55;
        this.MSG_UPDATE_PROGRESS = 56;
        this.MSG_ABORT = 57;
        this.MSG_REFRESH_DEVICE = 58;
        this.MSG_TIMEOUT = 59;
        this.MSG_NO_CONTACTS = 60;
        this.MSG_DEVICE_DELAYED = 61;
        this.stopScanForNoNecessary = false;
        this.mPhoneBookSize = 0;
        this.mActualNumber = 0;
        this.mNeedContinue = false;
        this.mCurrentSize = 0;
        this.mProfileConnected = false;
        this.mProgressCount = 0;
        this.mIsSuccess = false;
        this.mIsException = false;
        this.mIsCancel = false;
        this.mAdapterState = 10;
        this.mProgress = null;
        this.mConnectSocketWhenBonded = false;
        this.mReceiver = new AnonymousClass1(this);
        this.mHandler = new AnonymousClass2(this);
        this.entrySet = new HashSet();
    }

    private void printVcards(ArrayList<VCardEntry> r7) {
        ArrayList r0 = new ArrayList();
        r0.addAll(r7);
        int r8 = r0.size();
        OLog.d(TAG, "printVcards = " + r8);
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L5;
        OLog.d(TAG, "printVcard = " + ((VCardEntry) r0.get(r1)).toString() + "; current size = " + this.mProgressCount);
        int r3 = this.mProgressCount + 1;
        this.mProgressCount = r3;
        refreshProgressDialog(r3);
        r1 = r1 + 1;
        goto L3
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientFragment__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        this.mContext = getActivity();
        BluetoothAdapter r5 = BluetoothAdapter.getDefaultAdapter();
        this.mAdapter = r5;
        if (r5 != null) goto L6;
        OLog.e(TAG, "getDefaultAdapter fail, return");
        return;
    L6:
        this.mAdapterState = r5.getState();
        createConnectStateDialog();
        this.mProgress.setOnKeyListener(new AnonymousClass3(this));
        IntentFilter r6 = new IntentFilter();
        this.mIntentFilter = r6;
        r6.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mReceiver, this.mIntentFilter, 2);
        HandlerThread r7 = new HandlerThread("vCard work thread");
        this.mWorkThread = r7;
        r7.start();
        this.mWorkHandler = new VCardImportHandler(this, this.mWorkThread.getLooper());
        int r8 = this.mAdapterState;
        if (r8 != 10) goto L10;
        mShouldShutdownBt = true;
        this.mAdapter.enableNoAutoConnect();
        return;
    L10:
        if (r8 == 12) goto L12;
        return;
    L12:
        if (this.mHandler.hasMessages(4) == true) goto L14;
        Handler r9 = this.mHandler;
        r9.sendMessage(r9.obtainMessage(4));
    L14:
        startScanning("onCreate");
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        OLog.d(TAG, "onDestroy");
        if (mShouldShutdownBt == false) goto L11;
        mShouldShutdownBt = false;
        BluetoothAdapter r0 = this.mAdapter;     // Catch: Exception -> L9
        if (r0 == null) goto L11;
        r0.disable();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        OLog.e(TAG, e.toString());
    L11:
        this.mContext.unregisterReceiver(this.mReceiver);
        OAlertDialog r1 = this.mConfirmDialog;
        if (r1 == null) goto L14;
        r1.dismiss();
        this.mConfirmDialog = null;
    L14:
        HandlerThread r2 = this.mWorkThread;
        if (r2 == null) goto L20;
        r2.quitSafely();
        this.mWorkThread = null;
        return;
    }

    public void onBackPressed() {
        OLog.d(TAG, "onBackPressed");
        Handler r2 = this.mHandler;
        r2.sendMessage(r2.obtainMessage(57));
    }

    private void createConnectStateDialog() {
        this.mProgress = ODialogUtils.INSTANCE.showStatusDialog(getActivity(), "", "", "", false, null);
    }

    void showNoContactsDialog() {
        OAlertDialog r2 = new OAlertDialogBuilder(getActivity()).title(R.string.pbap_import_title).message(R.string.pbap_no_contacts).autoDismiss(true).positiveButton(R.string.dlg_ok, new AnonymousClass4(this)).build();
        r2.setOnDismissListener(null);
        r2.show();
    }

    void showConfirmDialog() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        Resources r0 = this.mContext.getResources();
        int r1 = this.mPhoneBookSize;
        OAlertDialog r2 = new OAlertDialogBuilder(getActivity()).autoDismiss(true).horizontalButton().title(R.string.pbap_import_title).message(r0.getQuantityString(R.plurals.pbap_import_text, r1, new Object[]{Integer.valueOf(r1)})).positiveButton(android.R.string.ok, new AnonymousClass6(this)).negativeButton(android.R.string.cancel, new AnonymousClass5(this)).build();
        this.mConfirmDialog = r2;
        r2.setOnDismissListener(null);
        DialogInterface.OnKeyListener r3 = new AnonymousClass7(this);
        OAlertDialog r4 = this.mConfirmDialog;
        if (r4 == null) goto L8;
        r4.setCanceledOnTouchOutside(false);
        this.mConfirmDialog.setOnKeyListener(r3);
    L8:
        this.mConfirmDialog.show();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r3, int r4, Intent r5) {
        OLog.d(TAG, "requestCode = " + r3 + ", resultCode " + r4);
        if (r3 == 19) goto L5;
        return;
    L5:
        if (r4 != (-1)) goto L15;
        if (r5 != null) goto L8;
        OLog.d(TAG, "no account, set mAccount = null");
        this.mAccount = null;
    L14:
        Handler r2 = this.mHandler;
        r2.sendMessage(r2.obtainMessage(53));
        return;
    L8:
        String r6 = r5.getStringExtra("account_name");
        String r7 = r5.getStringExtra(ManageAccountsSettings.KEY_ACCOUNT_TYPE);
        OLog.d(TAG, "accountName = " + r6 + ", accountType = " + r7);
        if (TextUtils.isEmpty(r6) == false) goto L11;
    L13:
        OLog.d(TAG, "account = " + this.mAccount);
        goto L14
    L11:
        if (TextUtils.isEmpty(r7) == true) goto L13;
        this.mAccount = new Account(r6, r7);
        goto L13
    L15:
        OLog.d(TAG, "user cancel in selecting account, abort");
        this.mIsCancel = true;
        Handler r8 = this.mHandler;
        r8.sendMessage(r8.obtainMessage(51));
    }

    private void refreshProgressDialog(int r5) {
    L8:
        e = move-exception;
        OLog.e(TAG, e.toString());
        return;
    L3:
        if (getActivity() == null) goto L13;
        this.mProgress.setTitleText(getString(R.string.pbap_importing_title) + HanziToPinyin.Token.SEPARATOR + getString(R.string.pbap_importing_text, new Object[]{Integer.valueOf(r5), Integer.valueOf(this.mPhoneBookSize)}));     // Catch: Exception -> L8
        if (this.mProgress.isShowing() == true) goto L14;
        this.mProgress.show();     // Catch: Exception -> L8
        return;
    L14:
        return;
    }

    private void importVCardEntries(ArrayList<VCardEntry> r10) {
        Iterator r11 = new ArrayList(r10).iterator();
    L4:
        if (r11.hasNext() == false) goto L38;
        VCardEntry r1 = (VCardEntry) r11.next();
        if (this.mIsException == true) goto L27;
        if (this.mPhoneBookSize == 0) goto L27;
        String r2 = r1.toString();
        int r4 = r2.indexOf("\n");
        if (r4 == (-1)) goto L14;
        r2 = r2.substring(r4);
    L14:
        if (this.entrySet.contains(r2) == true) goto L4;
        ContentResolver r5 = this.mContext.getContentResolver();
        ArrayList<ContentProviderOperation> r6 = new ArrayList();
        r1.constructInsertOperations(r5, r6);
        r5.applyBatch("com.android.contacts", r6);     // Catch: OperationApplicationException -> L19 RemoteException -> L21
    L24:
        if (TextUtils.isEmpty(r2) == true) goto L26;
        this.entrySet.add(r2);
    L26:
        this.mHandler.sendEmptyMessage(56);
    L19:
        e = move-exception;
        OLog.e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
    L21:
        e = move-exception;
        OLog.e(TAG, String.format("%s: %s", new Object[]{e.toString(), e.getMessage()}));
    L27:
        OLog.e(TAG, "mIsException, quit loop");
        return;
    }

    private boolean startScanning(String r4) {
        OLog.i(TAG, String.format("startScanning, enable=%s scene=%s pause=%s stopScanForNoNecessary=%s", new Object[]{Boolean.valueOf(this.mLocalAdapter.isEnabled()), r4, Boolean.valueOf(this.mPaused), Boolean.valueOf(this.stopScanForNoNecessary)}));
        if (this.mLocalAdapter.isEnabled() == true) goto L5;
    L20:
        return false;
    L5:
        if (this.mPaused == true) goto L20;
        if (this.stopScanForNoNecessary == true) goto L20;
        BluetoothCategory r5 = this.mAvailableDevicesCategory;
        if (r5 == null) goto L19;
        if (r5.isShowLoadingView() == true) goto L19;
        if (this.mHandler.hasMessages(63) == true) goto L19;
        if (this.mHandler.hasMessages(64) == true) goto L19;
        OLog.i(TAG, "restart refresh loading animation");
        this.mHandler.sendEmptyMessage(63);
    L19:
        return this.mLocalAdapter.startScanning();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r6) {
        super.onActivityCreated(r6);
        getActivity().getLayoutInflater();
        RecyclerView r7 = getListView();
        r7.setItemAnimator(null);
        r7.setPadding(r7.getPaddingLeft(), com.android.settings.Utils.dp2Pixels(getActivity(), 96.0f), r7.getPaddingRight(), com.android.settings.Utils.dp2Pixels(getActivity(), 32.0f));
        r7.setOverScrollMode(0);
        r7.setClipChildren(false);
        r7.setClipToPadding(false);
        ViewParent r8 = r7.getParent();
        if ((r8 instanceof FrameLayout) == false) goto L8;
        FrameLayout r1 = (FrameLayout) r8;
        r1.addView(getTouchCallbackFrameLayout());
        Object r5 = r8.getParent();
        if ((r5 instanceof View) == false) goto L9;
        ((View) r5).setPadding(0, 0, 0, 0);
        return;
    L9:
        return;
    }

    private TouchCallbackFrameLayout getTouchCallbackFrameLayout() {
        TouchCallbackFrameLayout r0 = new TouchCallbackFrameLayout(this.mContext);
        r0.addOnTouchListener(new BluetoothPbapClientFragment$$ExternalSyntheticLambda0(this));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$getTouchCallbackFrameLayout$0$com-android-settings-bluetooth-BluetoothPbapClientFragment, reason: not valid java name */
    /* synthetic */ boolean m354x1a826f57(View r4, MotionEvent r5) {
        this.stopScanForNoNecessary = false;
        this.mHandler.removeMessages(62);
        this.mHandler.sendEmptyMessageDelayed(62, this.autoStopDuration);
        if (this.mLocalAdapter.isDiscovering() == true) goto L5;
        startScanning("touch");
    L5:
        return false;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void onDevicePreferenceClick(BluetoothDevicePreference r6) {
        CachedBluetoothDevice r7 = r6.getCachedDevice();
        if (r7 != null) goto L6;
        OLog.e(TAG, "cachedDevice is null");
        return;
    L6:
        BluetoothDevice r8 = r7.getDevice();
        if (r8 != null) goto L10;
        OLog.e(TAG, "device is null");
        return;
    L10:
        this.mLocalAdapter.stopScanning();
        OLog.d(TAG, "onDevicePreferenceClick");
        if (this.mDevice == null) goto L14;
        OLog.e(TAG, "Still in progress");
        return;
    L14:
        this.mDevice = r8;
        this.mClient = new BluetoothPbapClient(this.mDevice, this.mAccount, this.mHandler);
        if (r8.getBondState() != 12) goto L17;
        Handler r5 = this.mHandler;
        r5.sendMessage(r5.obtainMessage(50));
        return;
    L17:
        OLog.d(TAG, "createBond");
        r8.createBond();
        this.mConnectSocketWhenBonded = true;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onBluetoothStateChanged(int r2) {
        super.onBluetoothStateChanged(r2);
        if (r2 != 12) goto L9;
        if (this.mHandler.hasMessages(4) == true) goto L7;
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(4));
    L7:
        startScanning("STATE_ON");
        setupDevicePreferenceBackground();
        return;
    L9:
        if (r2 != 10) goto L16;
        OLog.d(TAG, "ACTION_STATE_CHANGED OFF");
        if (this.mDeviceListGroup == null) goto L13;
        this.mDeviceListGroup.removeAll();
    L13:
        Handler r1 = this.mHandler;
        r1.sendMessage(r1.obtainMessage(57));
        return;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, com.android.settings.bluetooth.BluetoothCallback
    public void onScanningStateChanged(boolean r1) {
        super.onScanningStateChanged(r1);
        getActivity().invalidateOptionsMenu();
    }

    @Override // com.android.settings.bluetooth.BluetoothCallback
    public void onDeviceBondStateChanged(CachedBluetoothDevice r4, int r5) {
        if (r5 == 12) goto L5;
    L8:
        BluetoothDevicePreference r1 = this.mDevicePreferenceMap.get(r4);
        if (r1 != null) goto L11;
    L14:
        if (r5 == 12) goto L16;
        return;
    L16:
        if (r4.getDevice() == this.mDevice) goto L18;
        return;
    L18:
        if (this.mConnectSocketWhenBonded == false) goto L23;
        this.mConnectSocketWhenBonded = false;
        Handler r3 = this.mHandler;
        r3.sendMessage(r3.obtainMessage(50));
        return;
    L23:
        return;
    L11:
        if (r5 != 11) goto L13;
        r1.setSummary(R.string.bluetooth_pairing);
        goto L14
    L13:
        r1.setSummary("");
        goto L14
    L5:
        if (this.mHandler.hasMessages(4) == true) goto L7;
        Handler r2 = this.mHandler;
        r2.sendMessage(r2.obtainMessage(4));
    L7:
        setupDevicePreferenceBackground();
        goto L8
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    void addPreferencesForActivity() {
        addPreferencesFromResource(R.xml.device_picker);
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment
    protected void setupDevicePreferenceBackground() {
        setupBackground(this.mPairedDevicesCategory, true);
        setupBackground(this.mAvailableDevicesCategory, false);
    }

    private void updateContent(int r4, boolean r5) {
        PreferenceScreen r6 = getPreferenceScreen();
        int r0 = 0;
        switch(r4) {
            case 10: goto L19;
            case 11: goto L18;
            case 12: goto L6;
            case 13: goto L5;
            default: goto L20;
        };
    L5:
        r0 = R.string.bluetooth_turning_off;
        goto L20
    L6:
        r6.removeAll();
        r6.setOrderingAsAdded(true);
        this.mDevicePreferenceMap.clear();
        PreferenceGroup r7 = this.mPairedDevicesCategory;
        if (r7 != null) goto L9;
        this.mPairedDevicesCategory = new BluetoothCategory(getActivity(), this.mIsLandScreen, false, false);
    L10:
        addDeviceCategory(this.mPairedDevicesCategory, R.string.bluetooth_preference_paired_devices, BluetoothDeviceFilter.BONDED_DEVICE_FILTER);
        int r8 = this.mPairedDevicesCategory.getPreferenceCount();
        BluetoothCategory r1 = this.mAvailableDevicesCategory;
        if (r1 != null) goto L13;
        BluetoothCategory r2 = new BluetoothCategory(getActivity(), this.mIsLandScreen);
        this.mAvailableDevicesCategory = r2;
        r2.setOnClickListener(new AnonymousClass8(this));
    L14:
        addDeviceCategory(this.mAvailableDevicesCategory, R.string.bluetooth_preference_found_devices, BluetoothDeviceFilter.UNBONDED_DEVICE_FILTER);
        this.mAvailableDevicesCategory.getPreferenceCount();
        if (r8 != 0) goto L22;
        r6.removePreference(this.mPairedDevicesCategory);
        return;
    L22:
        return;
    L13:
        r1.removeAll();
        goto L14
    L9:
        r7.removeAll();
        goto L10
    L18:
        r0 = R.string.bluetooth_turning_on;
        goto L20
    L19:
        r0 = R.string.bytedance_bluetooth_empty_list_bluetooth_off;
    L20:
        setDeviceListGroup(r6);
        removeAllDevices();
        addFakePreferenceAsTips(getActivity(), r0);
        getActivity().invalidateOptionsMenu();
    }

    private void addDeviceCategory(PreferenceGroup r1, int r2, BluetoothDeviceFilter.Filter r3) {
        r1.setTitle(r2);
        getPreferenceScreen().addPreference(r1);
        setFilter(r3);
        setDeviceListGroup(r1);
        addCachedDevices();
        r1.setEnabled(true);
    }

    public void com_android_settings_bluetooth_BluetoothPbapClientFragment__onResume$___twin___() {
        super.onResume();
        setDeviceListGroupTag(Utils.TAG_DEVICE_LIST_GROUP_PICKER);
        this.stopScanForNoNecessary = false;
        this.mHandler.sendEmptyMessageDelayed(62, this.autoStopDuration);
        if (this.mLocalAdapter.isEnabled() == false) goto L6;
        this.mHandler.sendEmptyMessage(63);
        return;
    }

    @Override // com.android.settings.bluetooth.DeviceListPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHandler.removeMessages(62);
        this.mHandler.removeMessages(64);
        this.mHandler.removeMessages(63);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(BluetoothPbapClientFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothPbapClientFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(BluetoothPbapClientFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_bluetooth_BluetoothPbapClientFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(BluetoothPbapClientFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_bluetooth_BluetoothPbapClientFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
