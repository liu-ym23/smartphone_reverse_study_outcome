package com.android.settings.revone;

import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import bytedanceos.util.DeviceType;
import com.GlobalProxyLancet;
import com.android.settings.Constants;
import com.android.settings.MultiSimAdapter;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.VolumeSeekBar;
import com.google.gson.JsonSyntaxException;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemCheck;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class TNTSoundSettingsFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AdapterView.OnItemClickListener {
    private static final int BOSTON_MIC_MODE_FAILED_TIME = 8000;
    private static final int CELLPHONE_DEVICE_VALUE = 3;
    private static final int DEFAULT_DEVICE_VALUE = 0;
    private static final String DEVICE_DATA_KEY = "audio_device_data";
    private static final String DEVICE_SET_KEY = "checked_audio_device";
    private static final int EXTERNAL_DEVICE_VALUE = 2;
    public static final String KEY_VOLUME_ACTIVE_STATE = "KEY_VOLUME_ACTIVE_STATE";
    private static final int PICKUP_DISABLE = 102;
    private static final int PICKUP_ENABLE = 101;
    private static final int PICKUP_FAILED = 103;
    private static final String TAG = "TNTSoundSettingsFragment";
    private static final int TYPE_BT = 1;
    private static final int TYPE_DEFAULT = 0;
    private static final int TYPE_HEADSET = 2;
    private static final int TYPE_PHONE = 5;
    private static final int TYPE_PHONE_DP = 6;
    private static final int TYPE_PHONE_SPEAKER = 7;
    private static final int TYPE_TNT_BOSTON = 3;
    private static final int TYPE_TNT_OTHER = 4;
    private static final int VOLUME_MUTE_DISABLE = 0;
    private static final int VOLUME_MUTE_ENABLE = 1;
    private ContentObserver OutputDeviceModeObserver;
    private ContentObserver VolumePanelMuteModeObserver;
    private ContentObserver deviceDataObserver;
    private AudioManager mAudioManager;
    private BroadcastReceiver mBroadcastReceiver;
    private CasthalManager mCasthalManager;
    private int mCurrentMicMode;
    private SettingItemCheck mDeviceItemCheck;
    private Handler mHandler;
    private LinearLayout mMicrophonePickupModeContainer;
    private SettingItemCheck mMultiPickupMode;
    private SettingItemSwitch mMuteItemSwitch;
    private SettingItemCheck mOutputDeviceItemCheck;
    private VolumeSeekBar mSeekBar;
    private SettingItemCheck mSinglePickupMode;
    private SoundDeviceAdapter mSoundDeviceAdapter;
    private List<SoundDevice> mSoundDevices;
    private SoundDeviceListView mSoundDevicesListView;

    private class SoundDevice {
        private Boolean checked;
        private Boolean enable;
        private String key;
        private String name;
        final /* synthetic */ TNTSoundSettingsFragment this$0;
        private Integer type;

        static /* synthetic */ Boolean access$1100(SoundDevice r0) {
            return r0.enable;
        }

        static /* synthetic */ String access$1200(SoundDevice r0) {
            return r0.key;
        }

        static /* synthetic */ Integer access$2300(SoundDevice r0) {
            return r0.type;
        }

        static /* synthetic */ Boolean access$2500(SoundDevice r0) {
            return r0.checked;
        }

        public SoundDevice(TNTSoundSettingsFragment r1) {
            this.this$0 = r1;
        }

        public SoundDevice(TNTSoundSettingsFragment r1, String r2, String r3, Integer r4, Boolean r5, Boolean r6) {
            this.this$0 = r1;
            this.name = r2;
            this.key = r3;
            this.type = r4;
            this.enable = r5;
            this.checked = r6;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String r1) {
            this.name = r1;
        }

        public String getKey() {
            return this.key;
        }

        public void setKey(String r1) {
            this.key = r1;
        }

        public Integer getType() {
            return this.type;
        }

        public void setType(Integer r1) {
            this.type = r1;
        }

        public Boolean getEnable() {
            return this.enable;
        }

        public void setEnable(Boolean r1) {
            this.enable = r1;
        }

        public Boolean getChecked() {
            return this.checked;
        }

        public void setChecked(Boolean r1) {
            this.checked = r1;
        }
    }

    private class SoundDeviceAdapter extends BaseAdapter {
        final /* synthetic */ TNTSoundSettingsFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        private SoundDeviceAdapter(TNTSoundSettingsFragment r1) {
            this.this$0 = r1;
        }

        /* synthetic */ SoundDeviceAdapter(TNTSoundSettingsFragment r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (TNTSoundSettingsFragment.access$2100(this.this$0) != null) goto L7;
            return 0;
        L7:
            return TNTSoundSettingsFragment.access$2100(this.this$0).size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            return TNTSoundSettingsFragment.access$2100(this.this$0).get(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = View.inflate(this.this$0.getActivity(), R.layout.list_content_item_check, null);
            SettingItemCheck r6 = (SettingItemCheck) r4.findViewById(R.id.item_check);
            SoundDeviceViewHolder r1 = new SoundDeviceViewHolder(null);
            r1.mItemCheck = r6;
            r4.setTag(r1);
        L5:
            SettingItemCheck r7 = r1.mItemCheck;
            Utils.setItemBgStyle(r7, getCount(), r3);
            SoundDevice r8 = (SoundDevice) TNTSoundSettingsFragment.access$2100(this.this$0).get(r3);
            r7.setIcon(TNTSoundSettingsFragment.access$2400(this.this$0, SoundDevice.access$2300(r8).intValue()));
            r7.setTitle(r8.getName());
            r7.setChecked(SoundDevice.access$2500(r8).booleanValue());
            r7.setEnabled(SoundDevice.access$1100(r8).booleanValue());
            return r4;
        L4:
            r1 = (SoundDeviceViewHolder) r4.getTag();
            goto L5
        }
    }

    private class SoundDeviceGroup {
        private List<SoundDevice> media;
        private List<SoundDevice> phone;
        private String state;
        final /* synthetic */ TNTSoundSettingsFragment this$0;

        private SoundDeviceGroup(TNTSoundSettingsFragment r1) {
            this.this$0 = r1;
        }

        static /* synthetic */ String access$1800(SoundDeviceGroup r0) {
            return r0.state;
        }

        static /* synthetic */ List access$1900(SoundDeviceGroup r0) {
            return r0.phone;
        }

        static /* synthetic */ List access$2000(SoundDeviceGroup r0) {
            return r0.media;
        }
    }

    public static class SoundDeviceListView extends ListView {
        public SoundDeviceListView(Context r1) {
            super(r1);
        }

        public SoundDeviceListView(Context r1, AttributeSet r2) {
            super(r1, r2);
        }

        public SoundDeviceListView(Context r1, AttributeSet r2, int r3) {
            super(r1, r2, r3);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
        protected void onMeasure(int r2, int r3) {
            super.onMeasure(r2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        }
    }

    private static class SoundDeviceViewHolder {
        SettingItemCheck mItemCheck;

        private SoundDeviceViewHolder() {
        }

        /* synthetic */ SoundDeviceViewHolder(AnonymousClass1 r1) {
            this();
        }
    }

    public void com_android_settings_revone_TNTSoundSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ SettingItemCheck access$000(TNTSoundSettingsFragment r0) {
        return r0.mSinglePickupMode;
    }

    static /* synthetic */ SettingItemCheck access$100(TNTSoundSettingsFragment r0) {
        return r0.mMultiPickupMode;
    }

    static /* synthetic */ boolean access$1000(TNTSoundSettingsFragment r0) {
        return r0.mIsFragmentVisible;
    }

    static /* synthetic */ void access$1300(TNTSoundSettingsFragment r0) {
        r0.setOutputCheckView();
    }

    static /* synthetic */ boolean access$1400(TNTSoundSettingsFragment r0) {
        return r0.isTntVolumeMuteMode();
    }

    static /* synthetic */ SettingItemSwitch access$1500(TNTSoundSettingsFragment r0) {
        return r0.mMuteItemSwitch;
    }

    static /* synthetic */ VolumeSeekBar access$1600(TNTSoundSettingsFragment r0) {
        return r0.mSeekBar;
    }

    static /* synthetic */ void access$200(TNTSoundSettingsFragment r0, boolean r1) {
        r0.setPickupModeEnable(r1);
    }

    static /* synthetic */ List access$2100(TNTSoundSettingsFragment r0) {
        return r0.mSoundDevices;
    }

    static /* synthetic */ int access$2400(TNTSoundSettingsFragment r0, int r1) {
        return r0.getIconResourceByDeviceType(r1);
    }

    static /* synthetic */ int access$300(TNTSoundSettingsFragment r0) {
        return r0.mCurrentMicMode;
    }

    static /* synthetic */ void access$400(TNTSoundSettingsFragment r0) {
        r0.updatePickupModeCheckState();
    }

    static /* synthetic */ void access$500(TNTSoundSettingsFragment r0) {
        r0.changeAudioData();
    }

    static /* synthetic */ boolean access$600(TNTSoundSettingsFragment r0) {
        return r0.mIsFragmentVisible;
    }

    static /* synthetic */ void access$700(TNTSoundSettingsFragment r0, int r1) {
        r0.sendMessage(r1);
    }

    static /* synthetic */ boolean access$800(TNTSoundSettingsFragment r0) {
        return r0.mIsFragmentVisible;
    }

    static /* synthetic */ Handler access$900(TNTSoundSettingsFragment r0) {
        return r0.mHandler;
    }

    public void com_android_settings_revone_TNTSoundSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        if (Constants.sIsBostonConnected == false) goto L5;
        this.mCasthalManager = CasthalManager.getInstance(this.mContext);
    L5:
        registerContent();
    }

    private void registerContent() {
        OLog.d(TAG, "registerContentAudioDeviceListData");
        final Handler r1 = this.mHandler;
        this.deviceDataObserver = new AnonymousClass2(this, r1);
        this.mContext.getContentResolver().registerContentObserver(Settings.Global.getUriFor(DEVICE_DATA_KEY), false, this.deviceDataObserver);
    }

    public TNTSoundSettingsFragment() {
        super(R.layout.tnt_sound_settings_layout);
        final Looper r1 = Looper.getMainLooper();
        this.mHandler = new AnonymousClass1(this, r1);
        final Handler r2 = new Handler();
        this.OutputDeviceModeObserver = new AnonymousClass5(this, r2);
        final Handler r3 = new Handler();
        this.VolumePanelMuteModeObserver = new AnonymousClass6(this, r3);
        this.mBroadcastReceiver = new AnonymousClass7(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mMuteItemSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.mute_enable_switch);
        VolumeSeekBar r3 = (VolumeSeekBar) findViewByIdNullable(R.id.system_volume_seek_bar);
        this.mSeekBar = r3;
        if (phoneIsInUse() == false) goto L5;
        int r4 = 0;
    L6:
        r3.setStream(r4);
        this.mOutputDeviceItemCheck = (SettingItemCheck) findViewByIdNullable(R.id.item_id_output_device_check);
        SettingItemCheck r5 = (SettingItemCheck) findViewByIdNullable(R.id.item_id_device_check);
        this.mDeviceItemCheck = r5;
        r5.setTitle(Utils.getDeviceName(getContext()));
        this.mDeviceItemCheck.setIcon(getDeviceIconResId());
        this.mSinglePickupMode = (SettingItemCheck) findViewByIdNullable(R.id.item_id_single_pickup_mode);
        this.mMultiPickupMode = (SettingItemCheck) findViewByIdNullable(R.id.item_id_multi_pickup_mode);
        this.mMicrophonePickupModeContainer = (LinearLayout) findViewByIdNullable(R.id.microphone_pickup_mode_container);
        this.mSinglePickupMode.setOnClickListener(this);
        this.mMultiPickupMode.setOnClickListener(this);
        this.mOutputDeviceItemCheck.setOnClickListener(this);
        this.mDeviceItemCheck.setOnClickListener(this);
        if (Utils.isMonkeyRunning() == true) goto L9;
        this.mSeekBar.initVolumizer();
    L9:
        initSoundDeives();
        this.mOutputDeviceItemCheck.setEnabled(isSupportOutput());
        return;
    L5:
        r4 = 3;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mMuteItemSwitch.setOnCheckedChangeListener(this);
    }

    private void setOutputCheckView() {
        int r0 = getOutputDeviceMode();
        this.mMuteItemSwitch.setChecked(isTntVolumeMuteMode());
        if (r0 == 2) goto L9;
        if (r0 == 0) goto L9;
        if (r0 != 3) goto L10;
        this.mOutputDeviceItemCheck.setChecked(false);
        this.mDeviceItemCheck.setChecked(true);
    L10:
        OLog.d(TAG, "onCreateView: output device flag : " + r0);
        return;
    L9:
        this.mOutputDeviceItemCheck.setChecked(true);
        this.mDeviceItemCheck.setChecked(false);
        goto L10
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        switch(r2.getId()) {
            case 2131429366: goto L12;
            case 2131429387: goto L10;
            case 2131429393: goto L8;
            case 2131429401: goto L6;
            default: goto L19;
        };
    L8:
        setOutputDeviceMode(2);
        return;
    L12:
        setOutputDeviceMode(3);
        return;
    L19:
        return;
    L6:
        if (this.mSinglePickupMode.isChecked() == true) goto L14;
        this.mCurrentMicMode = 1;
        sendMessage(1);
        setPickupModeEnable(false);
        setBostonMicMode(1);
        return;
    L14:
        return;
    L10:
        if (this.mMultiPickupMode.isChecked() == true) goto L17;
        this.mCurrentMicMode = 0;
        sendMessage(0);
        setPickupModeEnable(false);
        setBostonMicMode(0);
        return;
    }

    private void updatePickupModeCheckState() {
        OLog.d(TAG, "updatePickupModeCheckState: ");
        CasthalManager r0 = this.mCasthalManager;
        if (r0 != null) goto L6;
        OLog.d(TAG, "updatePickupModeCheckState: CasthalManager == null ");
        return;
    L6:
        r0.getBostonMicMode(new AnonymousClass3(this));
    }

    private void setPickupModeEnable(boolean r2) {
        this.mMultiPickupMode.setEnabled(r2);
        this.mSinglePickupMode.setEnabled(r2);
    }

    private void setBostonMicMode(int r5) {
        OLog.d(TAG, "setBostonMicMode: mode : " + r5);
        if (this.mCasthalManager != null) goto L6;
        OLog.d(TAG, "setBostonMicMode: CasthalManager == null ");
        return;
    L6:
        Handler r0 = this.mHandler;
        r0.sendMessageDelayed(r0.obtainMessage(103), 8000);
        this.mCasthalManager.setBostonMicMode(r5, new AnonymousClass4(this));
    }

    private void sendMessage(int r1) {
        Message r0 = this.mHandler.obtainMessage();
        r0.what = r1;
        r0.sendToTarget();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mMuteItemSwitch.getSwitch()) goto L8;
        if (r3 == false) goto L6;
        setTntVolumeMuteMode(1);
        return;
    L6:
        setTntVolumeMuteMode(0);
        return;
    }

    private void updateViews() {
        this.mOutputDeviceItemCheck.setEnabled(isSupportOutput());
        setOutputCheckView();
        registerOutputDeviceModeChangeObserver();
        registerVolumePanelMuteModeChangeObserver();
        IntentFilter r0 = new IntentFilter();
        r0.addAction("bytedanceos.intent.action.ACTION_PHONE_MODE_CHANGED");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBroadcastReceiver, r0, 2);
        if (Constants.sIsBostonConnected == false) goto L6;
        this.mOutputDeviceItemCheck.setTitle(R.string.boston_device_title);
        updatePickupModeCheckState();
        this.mMicrophonePickupModeContainer.setVisibility(0);
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mHandler.removeMessages(103);
        unregisterOutputDeviceModeChangeObserver();
        unregisterVolumePanelMuteModeChangeObserver();
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        if (Utils.isMonkeyRunning() == true) goto L6;
        this.mSeekBar.stopVolumizer();
    L6:
        if (this.deviceDataObserver == null) goto L9;
        OLog.d(TAG, "unRegisterContentAudioDeviceListData");
        this.mContext.getContentResolver().unregisterContentObserver(this.deviceDataObserver);
        this.deviceDataObserver = null;
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        SoundDevice r5 = this.mSoundDevices.get(r3);
        List r6 = (List) ((List) Optional.ofNullable(this.mSoundDevices).orElseGet(new TNTSoundSettingsFragment$$ExternalSyntheticLambda0())).stream().filter(new TNTSoundSettingsFragment$$ExternalSyntheticLambda1()).collect(Collectors.toList());
        if (r6.contains(r5) == false) goto L5;
        return;
    L5:
        if (SoundDevice.access$1100(r5).booleanValue() == false) goto L9;
        r5.setChecked(true);
        Settings.Global.putString(this.mContext.getContentResolver(), DEVICE_SET_KEY, SoundDevice.access$1200(r5));
        r6.stream().forEach(new TNTSoundSettingsFragment$$ExternalSyntheticLambda2());
        this.mSoundDeviceAdapter.notifyDataSetChanged();
        return;
    }

    static /* synthetic */ List lambda$onItemClick$0() {
        return new ArrayList();
    }

    static /* synthetic */ boolean lambda$onItemClick$1(SoundDevice r0) {
        return SoundDevice.access$2500(r0).booleanValue();
    }

    static /* synthetic */ void lambda$onItemClick$2(SoundDevice r1) {
        r1.setChecked(false);
    }

    private void setOutputDeviceMode(int r2) {
        Settings.System.putInt(getContentResolver(), "extended_screen_audio_policy", r2);
    }

    private void setTntVolumeMuteMode(int r4) {
        Settings.System.putInt(getContentResolver(), KEY_VOLUME_ACTIVE_STATE + getOutputDeviceMode(), r4);
    }

    private boolean isTntVolumeMuteMode() {
        if (Settings.System.getInt(getContentResolver(), KEY_VOLUME_ACTIVE_STATE + getOutputDeviceMode(), 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private int getOutputDeviceMode() {
        return Settings.System.getInt(getContentResolver(), "extended_screen_audio_policy", 0);
    }

    private void registerOutputDeviceModeChangeObserver() {
        getContentResolver().registerContentObserver(Settings.System.getUriFor("extended_screen_audio_policy"), true, this.OutputDeviceModeObserver);
    }

    private void unregisterOutputDeviceModeChangeObserver() {
        getContentResolver().unregisterContentObserver(this.OutputDeviceModeObserver);
    }

    private void registerVolumePanelMuteModeChangeObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.registerContentObserver(Settings.System.getUriFor("KEY_VOLUME_ACTIVE_STATE2"), true, this.VolumePanelMuteModeObserver);
        r0.registerContentObserver(Settings.System.getUriFor("KEY_VOLUME_ACTIVE_STATE3"), true, this.VolumePanelMuteModeObserver);
        r0.registerContentObserver(Settings.System.getUriFor("KEY_VOLUME_ACTIVE_STATE0"), true, this.VolumePanelMuteModeObserver);
    }

    private void unregisterVolumePanelMuteModeChangeObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.unregisterContentObserver(this.VolumePanelMuteModeObserver);
    }

    private boolean phoneIsInUse() {
        if (((TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY)).getCallState() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isSupportOutput() {
        if (isSmartDisplayMode(this.mContext) == false) goto L5;
        return true;
    L5:
        AudioDeviceInfo[] r8 = this.mAudioManager.getDevices(3);
        int r0 = r8.length;
        int r2 = 0;
        boolean r3 = false;
    L7:
        if (r2 >= r0) goto L17;
        int r5 = r8[r2].getType();
        OLog.d(TAG, "isSupportOutput type " + r5);
        if (r5 != 9) goto L11;
    L15:
        r3 = true;
    L16:
        r2 = r2 + 1;
        goto L7
    L11:
        if (r5 == 11) goto L15;
        if (r5 == 22) goto L15;
    L17:
        OLog.d(TAG, "isSupportOutput  isSupport " + r3);
        return r3;
    }

    private boolean isSmartDisplayMode(Context r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getDisplay() == null) goto L13;
        int r3 = r2.getDisplay().getType();
        if (r3 != 3) goto L9;
    L10:
        return true;
    L9:
        if (r3 == 5) goto L10;
        return false;
    L13:
        return false;
    }

    private int getDeviceIconResId() {
        if (DeviceType.is(DeviceType.DELTA) == false) goto L6;
        return R.drawable.icn_audio_internal_delta;
    L6:
        if (DeviceType.is(DeviceType.DARWIN) == false) goto L9;
        return R.drawable.icn_audio_internal_darwin;
    L9:
        if (DeviceType.is(DeviceType.TRIDENT) == false) goto L12;
        return R.drawable.icn_audio_internal_r1;
    L12:
        if (DeviceType.is(DeviceType.OCEAN) == false) goto L14;
        return R.drawable.icn_audio_internal_pro2;
    L14:
        return R.drawable.icn_audio_internal;
    }

    private int getIconResourceByDeviceType(int r1) {
        switch(r1) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L15;
            case 6: goto L5;
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        return R.drawable.icn_audio_default;
    L4:
        return R.drawable.icn_audio_phone_speaker;
    L5:
        return R.drawable.icn_audio_phone_handset;
    L7:
        return R.drawable.icn_audio_tnt;
    L8:
        return R.drawable.icn_audio_boston;
    L9:
        return R.drawable.icn_audio_headset;
    L10:
        return R.drawable.icn_audio_bluetooth_headset;
    L15:
        return getDeviceIconResId();
    }

    private void initSoundDeives() {
        this.mSoundDevicesListView = (SoundDeviceListView) findViewByIdNullable(R.id.sound_devices);
        this.mSoundDevices = new ArrayList();
        this.mSoundDeviceAdapter = new SoundDeviceAdapter(this, null);
        changeAudioData();
        this.mSoundDevicesListView.setAdapter(this.mSoundDeviceAdapter);
        this.mSoundDevicesListView.setOnItemClickListener(this);
    }

    private void changeAudioData() {
        String r2 = Settings.Global.getString(this.mContext.getContentResolver(), DEVICE_DATA_KEY);     // Catch: JsonSyntaxException -> L19
        OLog.d(TAG, "getAudioDeviceListData " + r2);     // Catch: JsonSyntaxException -> L19
        if (TextUtils.isEmpty(r2) == false) goto L6;
        return;
    L6:
        SoundDeviceGroup r1 = (SoundDeviceGroup) Utils.fromJson(r2, new AnonymousClass8(this));     // Catch: JsonSyntaxException -> L19
        if (TextUtils.isEmpty(SoundDeviceGroup.access$1800(r1)) == false) goto L9;
        return;
    L9:
        this.mSoundDevices.clear();     // Catch: JsonSyntaxException -> L19
        if (MultiSimAdapter.PHONE_KEY.equals(SoundDeviceGroup.access$1800(r1)) == false) goto L15;
        if (SoundDeviceGroup.access$1900(r1) == null) goto L15;
        this.mSoundDevices.addAll(SoundDeviceGroup.access$1900(r1));     // Catch: JsonSyntaxException -> L19
    L17:
        this.mSoundDeviceAdapter.notifyDataSetChanged();     // Catch: JsonSyntaxException -> L19
        return;
    L15:
        if (SoundDeviceGroup.access$2000(r1) == null) goto L17;
        this.mSoundDevices.addAll(SoundDeviceGroup.access$2000(r1));     // Catch: JsonSyntaxException -> L19
    L19:
        e = move-exception;
        OLog.e(TAG, "getAudioDeviceListData JsonSyntaxException" + e.getMessage());
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(TNTSoundSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTSoundSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(TNTSoundSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_TNTSoundSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(TNTSoundSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_TNTSoundSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
