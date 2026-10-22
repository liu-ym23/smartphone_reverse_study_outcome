package com.android.settings;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHidDevice;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import bytedanceos.util.SettingsUtil;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PhoneCaseKeySettingFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, PhoneCaseShortcutSettingFragment.ShortcutKeyChangeListener {
    public static final String ARG_PHONE_CASE_KEYS = "phone_case_keys";
    public static final String ARG_PHONE_CASE_KEY_INDEX = "phone_case_key_index";
    private static final int CONNECT_TIME_OUT = 120000;
    public static final long DELAY_MILLIS = 1000;
    private static final int MSG_BT_BOND = 4353;
    private static final int MSG_BT_CONNECTED = 4354;
    private static final int MSG_BT_DISCONNECTED = 4355;
    private static final int MSG_CREATE_INPUT_DEVICE = 4352;
    private static final int MSG_DEVICE_CONNECT_WAIT = 4356;
    private static final int MSG_RE_CONNECT_PHONE_CASE = 4359;
    private static final int MSG_START_CONNECT_PHONE_CASE = 4357;
    private static final int MSG_START_CONNECT_TIME_OUT = 4358;
    private static final int REQUEST_CODE_PLAY_VIDEO = 10;
    private static final String TAG = "ltan/PhoneCaseKeySettingFrag";
    private static String sBulletSmsIntentString;
    private static String sSearchIntentString;
    private static String sthinkboostIntentString;
    private final boolean introVideoPrepared;
    private BluetoothAdapter mAdapter;
    private BroadcastReceiver mBtReceiver;
    private ArrayList<TextView> mButtons;
    private IntentFilter mConnectedFilter;
    private BluetoothDevice mCurrentDevice;
    private ArrayList<String> mDefaultValues;
    private TextView mEnableWayTipsView;
    private TextView mEnableWayTitle;
    private Handler mHandler;
    private BluetoothHidDevice mInputDevice;
    private boolean mIsPhoneCasePutOn;
    private ClickableSpan mLearMoreSpan;
    private boolean mMatchEnabled;
    private TextView mPhoneCaseButton1;
    private TextView mPhoneCaseButton2;
    private TextView mPhoneCaseButton3;
    private ImageView mPhoneCaseEnableWayIntro;
    private boolean mPhoneCaseEnabled;
    private ArrayList<String> mPhoneCaseGlobalKeys;
    private PreferenceMgr mPhoneCasePreferenceMgr;
    private ImageView mPhoneCasePreview;
    private View mPhoneCaseShowContainer;
    private ViewStub mPhoneCaseShowStub;
    private SettingItemSwitch mPhoneCaseSwitch;
    private SpannableStringBuilder mSpannableBuilder;
    private TextView mTipsView;
    private List<String> mTmpBordNames;
    private ImageView mVideoIntro;

    private class BondDevicesTask extends AsyncTask<Void, Void, BluetoothDevice> {
        final /* synthetic */ PhoneCaseKeySettingFragment this$0;

        private BondDevicesTask(PhoneCaseKeySettingFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ BondDevicesTask(PhoneCaseKeySettingFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ BluetoothDevice doInBackground(Void[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        protected /* bridge */ /* synthetic */ void onPostExecute(BluetoothDevice r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            if (PhoneCaseKeySettingFragment.access$1500(this.this$0) == true) goto L5;
            PhoneCaseKeySettingFragment.access$1100(this.this$0).enable();
        L5:
            PhoneCaseKeySettingFragment.access$1400(this.this$0).sendEmptyMessageDelayed(PhoneCaseKeySettingFragment.MSG_START_CONNECT_TIME_OUT, 120000);
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected BluetoothDevice doInBackground2(Void... r6) {
            Set<BluetoothDevice> r7 = PhoneCaseKeySettingFragment.access$1100(this.this$0).getBondedDevices();
            StringBuilder r0 = new StringBuilder("doInBackground: getBondDevices: size:");
            if (r7 != null) goto L5;
            int r1 = 0;
        L6:
            OLog.d(PhoneCaseKeySettingFragment.TAG, r0.append(r1).toString());
            BluetoothDevice r2 = null;
            if (r7 != null) goto L9;
        L21:
            PhoneCaseKeySettingFragment.access$1100(this.this$0).startDiscovery();
            return null;
        L9:
            if (r7.isEmpty() == true) goto L21;
            Iterator<BluetoothDevice> r8 = r7.iterator();
        L13:
            if (r8.hasNext() == false) goto L17;
            BluetoothDevice r3 = r8.next();
            OLog.d(PhoneCaseKeySettingFragment.TAG, "doInBackground: item name:" + r3.getName() + ", addr:" + r3.getAddress());
            OLog.d(PhoneCaseKeySettingFragment.TAG, "doInBackground: mInputDevice:" + PhoneCaseKeySettingFragment.access$700(this.this$0));
            if (handleDeviceItem(r3) == false) goto L13;
            r2 = r3;
        L17:
            OLog.d(PhoneCaseKeySettingFragment.TAG, "doInBackground: fond device ?" + r2);
            if (r2 != null) goto L20;
            PhoneCaseKeySettingFragment.access$1100(this.this$0).startDiscovery();
        L20:
            return r2;
        L5:
            r1 = r7.size();
            goto L6
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(BluetoothDevice r1) {
            super.onPostExecute(r1);
            PhoneCaseKeySettingFragment.access$202(this.this$0, r1);
        }

        private boolean handleDeviceItem(BluetoothDevice r5) {
            int r1 = 0;
            if (PhoneCaseKeySettingFragment.access$1300(this.this$0, r5.getName()) == true) goto L5;
            return false;
        L5:
            if (r5.getBluetoothClass().doesClassMatch(3) == true) goto L7;
            return false;
        L7:
            if (PhoneCaseKeySettingFragment.access$700(this.this$0) == null) goto L10;
            r1 = PhoneCaseKeySettingFragment.access$700(this.this$0).getConnectionState(r5);
        L10:
            if (PhoneCaseKeySettingFragment.access$700(this.this$0) != null) goto L12;
        L18:
            PhoneCaseKeySettingFragment.access$1600(this.this$0, PhoneCaseKeySettingFragment.MSG_BT_BOND, r5, 10);
        L19:
            PhoneCaseKeySettingFragment.access$1700(this.this$0);
            return true;
        L12:
            if (r1 != 2) goto L18;
            if (PhoneCaseKeySettingFragment.access$700(this.this$0) != null) goto L17;
            PhoneCaseKeySettingFragment.access$1400(this.this$0).sendEmptyMessageDelayed(PhoneCaseKeySettingFragment.MSG_CREATE_INPUT_DEVICE, 10);
            PhoneCaseKeySettingFragment.access$1600(this.this$0, PhoneCaseKeySettingFragment.MSG_DEVICE_CONNECT_WAIT, r5, 50);
            goto L19
        L17:
            PhoneCaseKeySettingFragment.access$1400(this.this$0).sendEmptyMessageDelayed(PhoneCaseKeySettingFragment.MSG_BT_CONNECTED, 10);
            goto L19
        }
    }

    class ShortcutClickListener implements View.OnClickListener {
        int category;
        final /* synthetic */ PhoneCaseKeySettingFragment this$0;

        ShortcutClickListener(PhoneCaseKeySettingFragment r1, int r2) {
            this.this$0 = r1;
            this.category = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            PhoneCaseKeySettingFragment.access$1900(this.this$0, this.category);
        }
    }

    public void com_android_settings_PhoneCaseKeySettingFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public PhoneCaseKeySettingFragment() {
        this.mPhoneCaseGlobalKeys = new ArrayList();
        this.mDefaultValues = new ArrayList();
        this.mButtons = new ArrayList();
        this.mSpannableBuilder = new SpannableStringBuilder();
        this.mLearMoreSpan = new AnonymousClass1(this);
        this.introVideoPrepared = false;
        this.mTmpBordNames = Arrays.asList(new String[]{Constants.SM_BOARD_NAME.toLowerCase(), Constants.SM_BT_KEYBOARD_NAME.toLowerCase()});
        this.mHandler = new AnonymousClass2(this);
        this.mBtReceiver = new AnonymousClass3(this);
    }

    static /* synthetic */ void access$000(PhoneCaseKeySettingFragment r0) {
        r0.createBluetoothInputDevice();
    }

    static /* synthetic */ boolean access$100(PhoneCaseKeySettingFragment r0, BluetoothDevice r1) {
        return r0.handleBtBond(r1);
    }

    static /* synthetic */ void access$1000(PhoneCaseKeySettingFragment r0) {
        r0.updatePhoneCaseTimeOut();
    }

    static /* synthetic */ BluetoothAdapter access$1100(PhoneCaseKeySettingFragment r0) {
        return r0.mAdapter;
    }

    static /* synthetic */ boolean access$1200(PhoneCaseKeySettingFragment r0, BluetoothDevice r1) {
        return r0.handleBtFond(r1);
    }

    static /* synthetic */ boolean access$1300(PhoneCaseKeySettingFragment r0, String r1) {
        return r0.isDeviceNameMatched(r1);
    }

    static /* synthetic */ Handler access$1400(PhoneCaseKeySettingFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$1500(PhoneCaseKeySettingFragment r0) {
        return r0.isBluetoothOn();
    }

    static /* synthetic */ void access$1600(PhoneCaseKeySettingFragment r0, int r1, BluetoothDevice r2, long r3) {
        r0.sendMessageContainsDevice(r1, r2, r3);
    }

    static /* synthetic */ void access$1700(PhoneCaseKeySettingFragment r0) {
        r0.cancelDiscovery();
    }

    static /* synthetic */ void access$1900(PhoneCaseKeySettingFragment r0, int r1) {
        r0.doPhoneCaseSetup(r1);
    }

    static /* synthetic */ BluetoothDevice access$202(PhoneCaseKeySettingFragment r0, BluetoothDevice r1) {
        r0.mCurrentDevice = r1;
        return r1;
    }

    static /* synthetic */ void access$300(PhoneCaseKeySettingFragment r0) {
        r0.startConnectPhoneCase();
    }

    static /* synthetic */ void access$400(PhoneCaseKeySettingFragment r0) {
        r0.reStartConnectPhoneCase();
    }

    static /* synthetic */ void access$500(PhoneCaseKeySettingFragment r0) {
        r0.phoneCaseConnected();
    }

    static /* synthetic */ void access$600(PhoneCaseKeySettingFragment r0, boolean r1) {
        r0.phoneCaseDisconnected(r1);
    }

    static /* synthetic */ BluetoothHidDevice access$700(PhoneCaseKeySettingFragment r0) {
        return r0.mInputDevice;
    }

    static /* synthetic */ BluetoothHidDevice access$702(PhoneCaseKeySettingFragment r0, BluetoothHidDevice r1) {
        r0.mInputDevice = r1;
        return r1;
    }

    static /* synthetic */ boolean access$800(PhoneCaseKeySettingFragment r0, BluetoothDevice r1) {
        return r0.connect(r1);
    }

    static /* synthetic */ boolean access$902(PhoneCaseKeySettingFragment r0, boolean r1) {
        r0.mMatchEnabled = r1;
        return r1;
    }

    private static void initShortcutIntentString(Context r4) {
        sBulletSmsIntentString = PhoneCaseShortcutSettingFragment.appendOptionJson(PhoneCaseShortcutSettingFragment.createActivityJsonArray(r4.getPackageManager().getLaunchIntentForPackage(Constants.PKG_BULLET_SMS), Constants.PKG_BULLET_SMS, 0), "bullet_messenger", Constants.PKG_BULLET_SMS, 3);
        sthinkboostIntentString = PhoneCaseShortcutSettingFragment.appendOptionJson(PhoneCaseShortcutSettingFragment.createOptionJsonArray("idea_pills_list", 0), "voice_assistant", 3);
        sSearchIntentString = PhoneCaseShortcutSettingFragment.createOptionJson("search", 3);
    }

    private void initDefaultIfNeed() {
        Iterator<String> r0 = this.mPhoneCaseGlobalKeys.iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        if (TextUtils.isEmpty(this.mPhoneCasePreferenceMgr.getString(r1, null)) == false) goto L4;
        this.mPhoneCasePreferenceMgr.putString(this.mPhoneCaseGlobalKeys.get(0), initTitleJsonString(R.string.phone_case_shortcut_bullet_sms));
        this.mPhoneCasePreferenceMgr.putString(this.mPhoneCaseGlobalKeys.get(1), initTitleJsonString(R.string.phone_case_shortcut_idea_pills));
        this.mPhoneCasePreferenceMgr.putString(this.mPhoneCaseGlobalKeys.get(2), initTitleJsonString(R.string.phone_case_shortcut_search));
        String r2 = android.provider.Settings.Global.getString(getContentResolver(), "smart_key_click_function");
        updatePhoneCaseSettings(this.mContext, r2);
        return;
    }

    private String initTitleJsonString(int r1) {
        return initTitleJsonString(this.mContext, r1);
    }

    private void sendMessageContainsDevice(int r3, BluetoothDevice r4) {
        sendMessageContainsDevice(r3, r4, 0);
    }

    private void sendMessageContainsDevice(int r2, BluetoothDevice r3, long r4) {
        Message r5 = this.mHandler.obtainMessage(r2);
        r5.obj = r3;
        this.mHandler.sendMessageDelayed(r5, r4);
    }

    private void cancelDiscovery() {
        if (this.mAdapter.isDiscovering() == false) goto L6;
        this.mAdapter.cancelDiscovery();
        return;
    }

    private void closeConnectPhoneCase(BluetoothDevice r2) {
        BluetoothHidDevice r0 = this.mInputDevice;
        if (r0 == null) goto L5;
        r0.disconnect(r2);
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0);
    }

    private void createBluetoothInputDevice() {
        if (isBluetoothOn() == true) goto L6;
        this.mAdapter.enable();
    L6:
        if (this.mInputDevice == null) goto L8;
        return;
    L8:
        this.mAdapter.getProfileProxy(this.mContext, new AnonymousClass4(this), 19);
    }

    private boolean isDeviceNameMatched(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L6;
        return false;
    L6:
        OLog.d(TAG, "isDeviceNameMatched: name:" + r3);
        return this.mTmpBordNames.contains(r3.toLowerCase());
    }

    private boolean handleBtFond(BluetoothDevice r4) {
        boolean r1 = false;
        if (isDeviceNameMatched(r4.getName()) == false) goto L12;
        int r0 = r4.getBondState();
        if (r0 != 10) goto L7;
        r4.createBond();
    L11:
        cancelDiscovery();
        goto L12
    L7:
        if (r0 != 12) goto L11;
        r1 = connect(r4);
    L12:
        return r1;
    }

    private boolean handleBtBond(BluetoothDevice r5) {
        boolean r1 = false;
        if (isDeviceNameMatched(r5.getName()) == false) goto L9;
        int r0 = r5.getBondState();
        OLog.d(TAG, "handleBtBond: state " + r0);
        if (r0 != 12) goto L8;
        OLog.d(TAG, "handleBtBond: bondState = BOND_BONDED, connecting...");
        r1 = connect(r5);
    L8:
        cancelDiscovery();
    L9:
        return r1;
    }

    private boolean connect(BluetoothDevice r6) {
        BluetoothHidDevice r0 = this.mInputDevice;
        boolean r1 = false;
        if (r0 != null) goto L6;
        this.mHandler.sendEmptyMessageDelayed(MSG_CREATE_INPUT_DEVICE, 10);
        sendMessageContainsDevice(MSG_DEVICE_CONNECT_WAIT, r6, 1000);
    L11:
        OLog.d(TAG, "connect: request mInputDevice:" + this.mInputDevice + ", connectResult:" + r1);
        return r1;
    L6:
        if (r0.getConnectionState(r6) != 2) goto L8;
    L9:
        r1 = true;
    L10:
        this.mCurrentDevice = r6;
        goto L11
    L8:
        if (this.mInputDevice.connect(r6) == false) goto L10;
        goto L9
    }

    private boolean isBluetoothOn() {
        if (this.mAdapter != null) goto L5;
        this.mAdapter = BluetoothAdapter.getDefaultAdapter();
    L5:
        BluetoothAdapter r1 = this.mAdapter;
        if (r1 != null) goto L8;
    L10:
        return false;
    L8:
        if (r1.isEnabled() == false) goto L10;
        return true;
    }

    private void reStartConnectPhoneCase() {
        new BondDevicesTask(this, null).execute(new Void[0]);
    }

    private void startConnectPhoneCase() {
        this.mPhoneCaseSwitch.setEnabled(false);
        this.mTipsView.setText(R.string.phone_case_connecting_tips);
        if (isBluetoothOn() == true) goto L5;
        this.mAdapter.enable();
    L5:
        createBluetoothInputDevice();
        this.mAdapter.startDiscovery();
        new BondDevicesTask(this, null).execute(new Void[0]);
    }

    private void phoneCaseConnected() {
        OLog.d(TAG, "phoneCaseConnected");
        this.mHandler.removeCallbacksAndMessages(null);
        cancelDiscovery();
        this.mTipsView.setText(R.string.phone_case_shortcut_key_tips_enabled);
        this.mMatchEnabled = true;
        this.mPhoneCaseSwitch.setEnabled(true);
        this.mPhoneCaseSwitch.setChecked(true);
        if (this.mPhoneCaseEnabled == true) goto L5;
        ToastUtils.show(getActivity(), R.string.phone_case_connect_succeed);
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 1);
        updatePhoneCase();
    }

    private void phoneCaseDisconnected(boolean r3) {
        OLog.d(TAG, "phoneCaseDisconnected");
        this.mMatchEnabled = false;
        this.mPhoneCaseSwitch.setChecked(false);
        this.mPhoneCaseSwitch.setEnabled(true);
        if (r3 == false) goto L5;
    L7:
        this.mHandler.removeCallbacksAndMessages(null);
        updatePhoneCase();
        return;
    L5:
        if (isBluetoothOn() == false) goto L7;
        ToastUtils.show(getActivity(), R.string.phone_case_connect_failed);
        goto L7
    }

    public void com_android_settings_PhoneCaseKeySettingFragment__onCreate$___twin___(Bundle r2) {
        super.onCreate(r2);
        initShortcutIntentString(this.mContext);
        IntentFilter r3 = new IntentFilter();
        this.mConnectedFilter = r3;
        r3.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
        this.mConnectedFilter.addAction("android.bluetooth.hiddevice.profile.action.CONNECTION_STATE_CHANGED");
        this.mConnectedFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        this.mConnectedFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        this.mConnectedFilter.addAction("android.bluetooth.device.action.FOUND");
        this.mConnectedFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        OLog.d(TAG, "onCreate: mConnectedFilter init...");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.phone_case_key_settings_layout, r4, false);
        this.mTipsView = (TextView) findViewByIdNullable(R.id.id_phone_case_tips);
        this.mEnableWayTipsView = (TextView) findViewByIdNullable(R.id.id_phone_case_video_intro_tips);
        this.mVideoIntro = (ImageView) findViewByIdNullable(R.id.id_phone_case_video_intro);
        this.mPhoneCaseEnableWayIntro = (ImageView) findViewByIdNullable(R.id.id_phone_case_contact);
        this.mPhoneCaseSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.trigger_phone_case_keys);
        this.mPhoneCaseShowStub = (ViewStub) findViewByIdNullable(R.id.id_phone_case_show_stub);
        this.mPhoneCasePreferenceMgr = PreferenceMgr.getInstance(this.mContext);
        this.mEnableWayTitle = (TextView) findViewByIdNullable(R.id.id_phone_case_contact_title);
        this.mVideoIntro.setOnClickListener(this);
        setSpannable();
        if (android.provider.Settings.Global.getInt(getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0) != 1) goto L5;
        boolean r6 = true;
    L6:
        this.mPhoneCaseEnabled = r6;
        if (r6 == false) goto L9;
        inflatePhoneCaseStubIfNeed(true);
    L9:
        initGlobalKey();
        initDefaultIfNeed();
        Utils.createShortcut(this.mContext, getString(R.string.phone_case_shortcut_icon), Settings.PhoneCaseSettingsActivity.class, R.drawable.ic_launcher_settings);
        this.mVideoIntro.setVisibility(8);
        this.mPhoneCaseEnableWayIntro.setVisibility(0);
        this.mEnableWayTitle.setVisibility(0);
        this.mEnableWayTipsView.setText(R.string.phone_case_enable_way_tips);
        return this.mRootView;
    L5:
        r6 = false;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mPhoneCaseSwitch.setOnCheckedChangeListener(this);
    }

    private void setSpannable() {
        String r0 = getString(R.string.phone_case_shortcut_key_tips);
        String r1 = getString(R.string.phone_case_shortcut_keys_learn_more);
        this.mSpannableBuilder.append(r0).append(r1);
        this.mSpannableBuilder.setSpan(this.mLearMoreSpan, r0.length(), this.mSpannableBuilder.length(), 33);
        this.mTipsView.setText(this.mSpannableBuilder);
        this.mTipsView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initGlobalKey() {
        this.mPhoneCaseGlobalKeys.add("phone_case_shortcut_key_1");
        this.mPhoneCaseGlobalKeys.add("phone_case_shortcut_key_2");
        this.mPhoneCaseGlobalKeys.add("phone_case_shortcut_key_3");
        this.mDefaultValues.add(getResources().getString(R.string.phone_case_shortcut_bullet_sms));
        this.mDefaultValues.add(getResources().getString(R.string.phone_case_shortcut_idea_pills));
        this.mDefaultValues.add(getResources().getString(R.string.phone_case_shortcut_search));
    }

    private void playTutorialVideo() {
        Intent r0 = new Intent();
        r0.setComponent(new ComponentName(Constants.PACKAGE_NAME_HANDBOOK, Constants.CLASS_NAME_HANDBOOK));
        r0.putExtra(Constants.VIDEO_NAME_KEY, "thinkboost_video");
        startActivityForResult(r0, 10);
    }

    public void learnMore() {
        Intent r0 = new Intent();
        Uri r1 = Uri.parse("");
        r0.setAction("android.intent.action.VIEW");
        r0.setData(r1);
        startActivity(r0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2.getId() != R.id.id_phone_case_video_intro) goto L7;
        playTutorialVideo();
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mPhoneCaseSwitch.getSwitch()) goto L9;
        inflatePhoneCaseStubIfNeed(r3);
        if (r3 == false) goto L7;
        registerBt();
        this.mHandler.sendEmptyMessage(MSG_START_CONNECT_PHONE_CASE);
        return;
    L7:
        closeConnectPhoneCase(this.mCurrentDevice);
        phoneCaseDisconnected(true);
        updatePhoneCase();
        unregisterBt();
        return;
    }

    public void updateViews() {
        updatePhoneCase();
        this.mPhoneCaseSwitch.setChecked(this.mPhoneCaseEnabled);
        if (this.mPhoneCaseEnabled == true) goto L5;
    L7:
        updateSwitchIfNeed();
        return;
    L5:
        if (this.mMatchEnabled == true) goto L7;
        registerBt();
        this.mHandler.sendEmptyMessage(MSG_RE_CONNECT_PHONE_CASE);
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updatePhoneCaseTimeOut() {
        OLog.w(TAG, "phone case connecting time out...");
        android.provider.Settings.Global.putInt(getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0);
        ToastUtils.show(getActivity(), R.string.phone_case_connect_time_out);
        updatePhoneCase();
        this.mPhoneCaseSwitch.setChecked(this.mPhoneCaseEnabled);
        this.mPhoneCaseSwitch.setEnabled(true);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void updateSwitchIfNeed() {
        if (isConnecting() == false) goto L8;
        this.mPhoneCaseSwitch.setChecked(true);
        this.mPhoneCaseSwitch.setEnabled(false);
        this.mTipsView.setText(R.string.phone_case_connecting_tips);
        this.mEnableWayTitle.setVisibility(0);
        this.mPhoneCaseEnableWayIntro.setVisibility(0);
        this.mEnableWayTipsView.setVisibility(0);
        View r3 = this.mPhoneCaseShowContainer;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        return;
    L9:
        return;
    }

    private boolean isConnecting() {
        if (this.mHandler.hasMessages(MSG_START_CONNECT_TIME_OUT) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.mHandler.hasMessages(MSG_DEVICE_CONNECT_WAIT) == true) goto L8;
        return false;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        OLog.d(TAG, "resultCode " + r3);
        if (r2 == 10) goto L5;
        return;
    L5:
        if (r3 != RESULT_OK) goto L9;
        this.mPhoneCasePreferenceMgr.putBoolean("custom_video_played", true);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        unregisterBt();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void registerBt() {
        OLog.d(TAG, "registerBt");     // Catch: Exception -> L5
        registerReceiver(this.mBtReceiver, this.mConnectedFilter);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "registerBt: e:" + e);
    }

    private void unregisterBt() {
        OLog.d(TAG, "unregisterBt");     // Catch: Exception -> L5
        unregisterReceiver(this.mBtReceiver);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        OLog.e(TAG, "unregisterBt: e:" + e);
    }

    @Override // com.android.settings.PhoneCaseShortcutSettingFragment.ShortcutKeyChangeListener
    public void onKeyChange(int r2, String r3) {
        this.mButtons.get(r2).setText(r3);
        resizeTextIfNeed(this.mButtons.get(r2));
        updateSelectValueForSmartkeyFunc(this.mContext);
    }

    private void inflatePhoneCaseStubIfNeed(boolean r3) {
        if (this.mPhoneCaseShowContainer != null) goto L8;
        if (r3 == false) goto L9;
        View r4 = this.mPhoneCaseShowStub.inflate();
        this.mPhoneCaseShowContainer = r4;
        this.mPhoneCasePreview = (ImageView) r4.findViewById(R.id.id_phone_case_preview);
        this.mPhoneCaseButton1 = (TextView) this.mPhoneCaseShowContainer.findViewById(R.id.id_test_tv_1);
        this.mPhoneCaseButton2 = (TextView) this.mPhoneCaseShowContainer.findViewById(R.id.id_test_tv_2);
        this.mPhoneCaseButton3 = (TextView) this.mPhoneCaseShowContainer.findViewById(R.id.id_test_tv_3);
        this.mButtons.add(this.mPhoneCaseButton1);
        this.mButtons.add(this.mPhoneCaseButton2);
        this.mButtons.add(this.mPhoneCaseButton3);
        this.mPhoneCaseButton2.setEnabled(SettingsFeature.isSmartKeyCustomized());
        this.mPhoneCaseButton1.setOnClickListener(new ShortcutClickListener(this, 0));
        this.mPhoneCaseButton2.setOnClickListener(new ShortcutClickListener(this, 1));
        this.mPhoneCaseButton3.setOnClickListener(new ShortcutClickListener(this, 2));
        this.mPhoneCaseShowContainer.setVisibility(8);
        return;
    L9:
        return;
    }

    private void doPhoneCaseSetup(int r3) {
        Bundle r0 = new Bundle();
        r0.putInt(ARG_PHONE_CASE_KEY_INDEX, r3);
        r0.putStringArrayList(ARG_PHONE_CASE_KEYS, this.mPhoneCaseGlobalKeys);
        PhoneCaseShortcutSettingFragment r4 = new PhoneCaseShortcutSettingFragment();
        r4.setKeyChangeListener(this);
        start(r4, r0);
    }

    private void updatePhoneCase() {
        int r2 = 0;
        boolean r1 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), PreferenceMgr.KEY_PHONE_CASE_STATE, 0) == 1) goto L6;
        r1 = false;
    L6:
        this.mPhoneCaseEnabled = r1;
        TextView r0 = this.mEnableWayTitle;
        if (r1 == false) goto L9;
        int r4 = 8;
    L10:
        r0.setVisibility(r4);
        ImageView r3 = this.mPhoneCaseEnableWayIntro;
        if (r1 == false) goto L13;
        int r5 = 8;
    L14:
        r3.setVisibility(r5);
        TextView r6 = this.mEnableWayTipsView;
        if (r1 == false) goto L17;
        int r7 = 8;
    L18:
        r6.setVisibility(r7);
        View r8 = this.mPhoneCaseShowContainer;
        if (r8 == null) goto L24;
        if (r1 == true) goto L23;
        r2 = 8;
    L23:
        r8.setVisibility(r2);
    L24:
        if (r1 == false) goto L26;
        this.mTipsView.setText(R.string.phone_case_shortcut_key_tips_enabled);
        updateShortcutButtonTitle();
        return;
    L26:
        this.mTipsView.setText(this.mSpannableBuilder);
        return;
    L17:
        r7 = 0;
        goto L18
    L13:
        r5 = 0;
        goto L14
    L9:
        r4 = 0;
        goto L10
    }

    private void updateShortcutButtonTitle() {
        int r0 = 0;
    L4:
        if (r0 >= this.mButtons.size()) goto L6;
        this.mButtons.get(r0).setText(readJsonLocaleString(this.mPhoneCaseGlobalKeys.get(r0)));
        resizeTextIfNeed(this.mButtons.get(r0));
        r0 = r0 + 1;
        goto L4
    }

    private void resizeTextIfNeed(TextView r3) {
        if (0.0f > getResources().getDimensionPixelOffset(R.dimen.phone_case_button_text_max_width)) goto L5;
        return;
    L5:
        if (getResources().getConfiguration().densityDpi < 480) goto L7;
        r3.setTextSize(2, 9.0f);
        return;
    L7:
        r3.setMaxWidth(getResources().getDimensionPixelOffset(R.dimen.phone_case_button_text_bg_max_width));
    }

    private String readJsonLocaleString(String r3) {
        JSONObject r0 = new JSONObject(this.mPhoneCasePreferenceMgr.getString(r3, "{}"));     // Catch: JSONException -> L10
        Locale r2 = Locale.getDefault();     // Catch: JSONException -> L10
        if (Locale.SIMPLIFIED_CHINESE.equals(r2) == false) goto L6;
        String r4 = r0.getString(Constants.APP_LABELS_OF_ZH_CN);     // Catch: JSONException -> L10
    L13:
        return r4;
    L6:
        if (Locale.TRADITIONAL_CHINESE.equals(r2) == false) goto L8;
        r4 = r0.getString(Constants.APP_LABELS_OF_ZH_TW);     // Catch: JSONException -> L10
        goto L13
    L8:
        r4 = r0.getString(Constants.APP_LABELS_OF_EN_US);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        OLog.e(TAG, "readJsonString: e:" + e);
        return "not found";
    }

    public static void updatePhoneCaseSettings(Context r0, String r1) {
        updateFirstButtonTitle(r0, r1);
        updateSecondButtonTitle(r0, r1);
        updateThirdButtonTitle(r0, r1);
        updateSelectValueForSmartkeyFunc(r0);
    }

    private static void updateThirdButtonTitle(Context r2, String r3) {
        String r4 = android.provider.Settings.Global.getString(r2.getContentResolver(), "phone_case_shortcut_key_3");
        if (TextUtils.isEmpty(r4) == false) goto L5;
    L8:
        saveAsSearch(r2, "phone_case_shortcut_key_3");
        PreferenceMgr.getInstance(r2).putString("phone_case_shortcut_key_3", initTitleJsonString(r2, R.string.phone_case_shortcut_search));
        return;
    L5:
        if (r4.equals(sthinkboostIntentString) == true) goto L8;
        if (r4.equals(sBulletSmsIntentString) == true) goto L8;
    }

    private static void updateFirstButtonTitle(Context r3, String r4) {
        String r0 = android.provider.Settings.Global.getString(r3.getContentResolver(), "phone_case_shortcut_key_1");
        if (TextUtils.isEmpty(r0) == false) goto L5;
    L8:
        PreferenceMgr r1 = PreferenceMgr.getInstance(r3);
        if ("bullet_sms".equals(r4) == false) goto L11;
        saveAsthinkboost(r3, "phone_case_shortcut_key_1");
        r1.putString("phone_case_shortcut_key_1", initTitleJsonString(r3, R.string.phone_case_shortcut_idea_pills));
        r1.putString(PreferenceMgr.KEY_PHONE_CASE_FUNC_VALUES, "voice_assistant,bullet_messenger,search,");
        return;
    L11:
        saveAsBulletSms(r3, "phone_case_shortcut_key_1");
        r1.putString("phone_case_shortcut_key_1", initTitleJsonString(r3, R.string.phone_case_shortcut_bullet_sms));
        r1.putString(PreferenceMgr.KEY_PHONE_CASE_FUNC_VALUES, "bullet_messenger,search,");
        return;
    L5:
        if (r0.equals(sthinkboostIntentString) == true) goto L8;
        if (r0.equals(sBulletSmsIntentString) == true) goto L8;
    }

    private static void updateSecondButtonTitle(Context r5, String r6) {
        if ("side_bar".equals(r6) == false) goto L6;
        int r7 = R.string.phone_case_shortcut_side_bar;
    L15:
        PreferenceMgr.getInstance(r5).putString("phone_case_shortcut_key_2", initTitleJsonString(r5, r7));
        if (r7 != R.string.phone_case_shortcut_bullet_sms) goto L18;
        saveAsBulletSms(r5, "phone_case_shortcut_key_2");
        return;
    L18:
        if (r7 != R.string.phone_case_shortcut_idea_pills) goto L20;
        saveAsthinkboost(r5, "phone_case_shortcut_key_2");
        return;
    L20:
        android.provider.Settings.Global.putString(r5.getContentResolver(), "phone_case_shortcut_key_2", null);
        return;
    L6:
        if ("bullet_sms".equals(r6) == false) goto L9;
        r7 = R.string.phone_case_shortcut_bullet_sms;
        goto L15
    L9:
        if ("idea_pills_list".equals(r6) == false) goto L12;
    L10:
        r7 = R.string.phone_case_shortcut_idea_pills;
        goto L15
    L12:
        if (SettingsUtil.hasSmartKey() == false) goto L10;
        r7 = R.string.undefined;
        goto L15
    }

    private static String initTitleJsonString(Context r4, int r5) {
        JSONObject r0 = new JSONObject();     // Catch: JSONException -> L4
        String r1 = Utils.getLocalizedStringResources(r4, Locale.ENGLISH, r5);     // Catch: JSONException -> L4
        String r2 = Utils.getLocalizedStringResources(r4, Locale.SIMPLIFIED_CHINESE, r5);     // Catch: JSONException -> L4
        String r6 = Utils.getLocalizedStringResources(r4, Locale.TRADITIONAL_CHINESE, r5);     // Catch: JSONException -> L4
        r0.put(Constants.APP_LABELS_OF_EN_US, r1);     // Catch: JSONException -> L4
        r0.put(Constants.APP_LABELS_OF_ZH_CN, r2);     // Catch: JSONException -> L4
        r0.put(Constants.APP_LABELS_OF_ZH_TW, r6);     // Catch: JSONException -> L4
        return r0.toString();
    L4:
        e = move-exception;
        OLog.e(TAG, "initJsonString: e:" + e);
        return null;
    }

    private static void updateSelectValueForSmartkeyFunc(Context r8) {
        List r1 = Arrays.asList(new String[]{"phone_case_shortcut_key_1", "phone_case_shortcut_key_2", "phone_case_shortcut_key_3"});
        StringBuilder r2 = new StringBuilder();
        ContentResolver r3 = r8.getContentResolver();
        int r4 = 0;
    L20:
    L16:
        e = move-exception;
        e.printStackTrace();
        OLog.e(TAG, "saveCurrentValue exception:" + e);
    L18:
        PreferenceMgr.getInstance(r8).putString(PreferenceMgr.KEY_PHONE_CASE_FUNC_VALUES, r2.toString());
        return;
    L4:
        if (r4 >= r1.size()) goto L18;
        String r5 = android.provider.Settings.Global.getString(r3, (String) r1.get(r4));     // Catch: JSONException -> L16
        if (r4 == 1) goto L15;
        if (TextUtils.isEmpty(r5) == true) goto L15;
        JSONObject r6 = new JSONArray(r5).optJSONObject(1);     // Catch: JSONException -> L16
        if (r6 == null) goto L15;
        if (TextUtils.isEmpty(r6.getString("action")) == true) goto L15;
        r2.append(r6.getString("action")).append(",");     // Catch: JSONException -> L16
    L15:
        r4 = r4 + 1;
        goto L20
    }

    private static void saveAsBulletSms(Context r1, String r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), r2, sBulletSmsIntentString);
    }

    private static void saveAsthinkboost(Context r1, String r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), r2, sthinkboostIntentString);
    }

    private static void saveAsSearch(Context r1, String r2) {
        android.provider.Settings.Global.putString(r1.getContentResolver(), r2, sSearchIntentString);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(PhoneCaseKeySettingFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PhoneCaseKeySettingFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(PhoneCaseKeySettingFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_PhoneCaseKeySettingFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(PhoneCaseKeySettingFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_PhoneCaseKeySettingFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
