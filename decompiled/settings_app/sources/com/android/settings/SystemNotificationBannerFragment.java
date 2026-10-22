package com.android.settings;

import android.database.ContentObserver;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.VideoView;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.AppCustomConfig;
import com.android.settings.utils.NullSafe;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public class SystemNotificationBannerFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener {
    public static final Uri AUTHORITY_CONFIG_URI = null;
    private static final int DELAY_MILLIS_TIME = 300;
    public static final String SYSTEM_NOTIFICATION_BANNER_FROM = "system_notification_banner_from";
    private static final String TAG = "SystemNotificationBannerFragment";
    private static final long TOAST_TIME_GAP = 10000;
    private final ContentObserver mAppCustomConfigObserver;
    private SettingItemSwitch mBluetoothTransportSwitch;
    private SettingItemSwitch mCallMissedSwitch;
    private SettingItemSwitch mContactImportAndExportSwitch;
    private SettingItemSwitch mDebugModeSwitch;
    private SettingItemSwitch mDrivingModeSwitch;
    private SettingItemSwitch mEyeProtectionModePlanSwitch;
    private SettingItemSwitch mGameSpeedUpSwitch;
    private Handler mHandler;
    private ImageView mImageView;
    private String mNotificationBannerFrom;
    private ScrollView mPageScrollview;
    private SettingItemSwitch mPersonalHotspotSwitch;
    private SettingItemSwitch mPictureInPictureSwitch;
    private SettingItemSwitch mPositioningSwitch;
    private SettingItemSwitch mPrinterSwitch;
    private SettingItemSwitch mReadingModeSwitch;
    private SettingItemSwitch mScreenLightSwitch;
    private SettingItemSwitch mScreenRecordingSwitch;
    private SettingItemSwitch mSimCardUnavailableSwitch;
    private SettingItemSwitch mStorageFullSwitch;
    private SettingItemSwitch mTntModeSwitch;
    private long mToastTime;
    private SettingItemSwitch mUploadDownloadSwitch;
    private SettingItemSwitch mUsbDeviceConnectionSwitch;
    private View mVideoBg;
    private VideoView mVideoView;
    private SettingItemSwitch mVirtualMemorySwitch;
    private SettingItemSwitch mVirtualTouchPadSwitch;
    private SettingItemSwitch mVoiceMailboxSwitch;
    private SettingItemSwitch mVpnSwitch;
    private Runnable runnableScroll;
    private Runnable runnableSwitch;
    private String uriStr;

    /* JADX INFO: renamed from: com.android.settings.SystemNotificationBannerFragment$4, reason: invalid class name */
    class AnonymousClass4 implements MediaPlayer.OnPreparedListener {
        final /* synthetic */ SystemNotificationBannerFragment this$0;

        AnonymousClass4(SystemNotificationBannerFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer r2) {
            r2.setLooping(true);
            SystemNotificationBannerFragment.access$2800(this.this$0).start();
            r2.setOnInfoListener(new SystemNotificationBannerFragment$4$$ExternalSyntheticLambda0(this));
        }

        /* JADX INFO: renamed from: lambda$onPrepared$0$com-android-settings-SystemNotificationBannerFragment$4, reason: not valid java name */
        /* synthetic */ boolean m211x3c0eac47(MediaPlayer r1, int r2, int r3) {
            if (r2 != 3) goto L7;
            SystemNotificationBannerFragment.access$2900(this.this$0).setVisibility(8);
            return true;
        L7:
            return true;
        }
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ void access$000(SystemNotificationBannerFragment r0) {
        r0.scrollViewToSpecifiedOffset();
    }

    static /* synthetic */ String access$100(SystemNotificationBannerFragment r0) {
        return r0.uriStr;
    }

    static /* synthetic */ SettingItemSwitch access$1000(SystemNotificationBannerFragment r0) {
        return r0.mBluetoothTransportSwitch;
    }

    static /* synthetic */ String access$102(SystemNotificationBannerFragment r0, String r1) {
        r0.uriStr = r1;
        return r1;
    }

    static /* synthetic */ SettingItemSwitch access$1100(SystemNotificationBannerFragment r0) {
        return r0.mContactImportAndExportSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1200(SystemNotificationBannerFragment r0) {
        return r0.mScreenLightSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1300(SystemNotificationBannerFragment r0) {
        return r0.mScreenRecordingSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1400(SystemNotificationBannerFragment r0) {
        return r0.mUploadDownloadSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1500(SystemNotificationBannerFragment r0) {
        return r0.mSimCardUnavailableSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1600(SystemNotificationBannerFragment r0) {
        return r0.mTntModeSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1700(SystemNotificationBannerFragment r0) {
        return r0.mVirtualMemorySwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1800(SystemNotificationBannerFragment r0) {
        return r0.mUsbDeviceConnectionSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$1900(SystemNotificationBannerFragment r0) {
        return r0.mVpnSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$200(SystemNotificationBannerFragment r0) {
        return r0.mStorageFullSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2000(SystemNotificationBannerFragment r0) {
        return r0.mCallMissedSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2100(SystemNotificationBannerFragment r0) {
        return r0.mVirtualTouchPadSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2200(SystemNotificationBannerFragment r0) {
        return r0.mGameSpeedUpSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2300(SystemNotificationBannerFragment r0) {
        return r0.mVoiceMailboxSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2400(SystemNotificationBannerFragment r0) {
        return r0.mReadingModeSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$2500(SystemNotificationBannerFragment r0) {
        return r0.mPositioningSwitch;
    }

    static /* synthetic */ Runnable access$2600(SystemNotificationBannerFragment r0) {
        return r0.runnableSwitch;
    }

    static /* synthetic */ Handler access$2700(SystemNotificationBannerFragment r0) {
        return r0.mHandler;
    }

    static /* synthetic */ VideoView access$2800(SystemNotificationBannerFragment r0) {
        return r0.mVideoView;
    }

    static /* synthetic */ ImageView access$2900(SystemNotificationBannerFragment r0) {
        return r0.mImageView;
    }

    static /* synthetic */ void access$300(SystemNotificationBannerFragment r0, SettingItemSwitch r1, String r2, int r3) {
        r0.updateSwitchState(r1, r2, r3);
    }

    static /* synthetic */ void access$3000(SystemNotificationBannerFragment r0, boolean r1, Uri r2) {
        r0.updateVideoView(r1, r2);
    }

    static /* synthetic */ SettingItemSwitch access$400(SystemNotificationBannerFragment r0) {
        return r0.mPrinterSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$500(SystemNotificationBannerFragment r0) {
        return r0.mDebugModeSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$600(SystemNotificationBannerFragment r0) {
        return r0.mPersonalHotspotSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$700(SystemNotificationBannerFragment r0) {
        return r0.mEyeProtectionModePlanSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$800(SystemNotificationBannerFragment r0) {
        return r0.mPictureInPictureSwitch;
    }

    static /* synthetic */ SettingItemSwitch access$900(SystemNotificationBannerFragment r0) {
        return r0.mDrivingModeSwitch;
    }

    static {
        AUTHORITY_CONFIG_URI = Uri.parse("content://com.bytedanceos.expandservice.appconfig");
    }

    public SystemNotificationBannerFragment() {
        super(R.layout.system_notification_banner_layout);
        this.mToastTime = 0;
        this.mHandler = new Handler();
        this.runnableScroll = new AnonymousClass1(this);
        this.runnableSwitch = new AnonymousClass2(this);
        final Handler r1 = null;
        this.mAppCustomConfigObserver = new AnonymousClass3(this, r1);
    }

    private void updateSwitchState(SettingItemSwitch r2, String r3, int r4) {
        int r1 = AppCustomConfig.getInt(getContext(), r3, "notification_heads_up", r4);
        boolean r5 = true;
        if (r1 == 1) goto L6;
        r5 = false;
    L6:
        r2.setChecked(r5);
    }

    private void scrollViewToSpecifiedOffset() {
        int[] r0 = new int[2];
        if ("com.bytedanceos.fake.storage.full".equals(this.mNotificationBannerFrom) == false) goto L6;
        this.mStorageFullSwitch.getLocationOnScreen(r0);
    L72:
        int r1 = r0[1] - this.mPageScrollview.getMeasuredHeight();
        if (r1 >= 0) goto L75;
        r1 = 0;
    L75:
        OLog.d(TAG, "mPageScrollview...offset = " + r1);
        this.mPageScrollview.smoothScrollTo(0, r1);
        return;
    L6:
        if ("com.bytedanceos.fake.printer".equals(this.mNotificationBannerFrom) == false) goto L9;
        this.mPrinterSwitch.getLocationOnScreen(r0);
        goto L72
    L9:
        if ("com.bytedanceos.fake.debug.mode".equals(this.mNotificationBannerFrom) == false) goto L12;
        this.mDebugModeSwitch.getLocationOnScreen(r0);
        goto L72
    L12:
        if ("com.bytedanceos.fake.persona.hotspot".equals(this.mNotificationBannerFrom) == false) goto L15;
        this.mPersonalHotspotSwitch.getLocationOnScreen(r0);
        goto L72
    L15:
        if ("com.bytedanceos.fake.eye.protection.mode.plan".equals(this.mNotificationBannerFrom) == false) goto L18;
        this.mEyeProtectionModePlanSwitch.getLocationOnScreen(r0);
        goto L72
    L18:
        if ("com.bytedanceos.fake.picture.in.picture".equals(this.mNotificationBannerFrom) == false) goto L21;
        this.mPictureInPictureSwitch.getLocationOnScreen(r0);
        goto L72
    L21:
        if ("com.bytedanceos.fake.driving.mode".equals(this.mNotificationBannerFrom) == false) goto L24;
        this.mDrivingModeSwitch.getLocationOnScreen(r0);
        goto L72
    L24:
        if ("com.bytedanceos.fake.bluetooth.transport".equals(this.mNotificationBannerFrom) == false) goto L27;
        this.mBluetoothTransportSwitch.getLocationOnScreen(r0);
        goto L72
    L27:
        if ("com.bytedanceos.fake.contact.import.and.export".equals(this.mNotificationBannerFrom) == false) goto L30;
        this.mBluetoothTransportSwitch.getLocationOnScreen(r0);
        goto L72
    L30:
        if ("com.bytedanceos.fake.screen.light".equals(this.mNotificationBannerFrom) == false) goto L33;
        this.mScreenLightSwitch.getLocationOnScreen(r0);
        goto L72
    L33:
        if ("com.bytedanceos.fake.screen.recording".equals(this.mNotificationBannerFrom) == false) goto L36;
        this.mScreenRecordingSwitch.getLocationOnScreen(r0);
        goto L72
    L36:
        if ("com.bytedanceos.fake.upload.download".equals(this.mNotificationBannerFrom) == false) goto L39;
        this.mUploadDownloadSwitch.getLocationOnScreen(r0);
        goto L72
    L39:
        if ("com.bytedanceos.fake.sim.card.unavailable".equals(this.mNotificationBannerFrom) == false) goto L42;
        this.mSimCardUnavailableSwitch.getLocationOnScreen(r0);
        goto L72
    L42:
        if ("com.bytedanceos.fake.tnt.mode".equals(this.mNotificationBannerFrom) == false) goto L45;
        this.mTntModeSwitch.getLocationOnScreen(r0);
        goto L72
    L45:
        if ("com.bytedanceos.fake.virtual.memory".equals(this.mNotificationBannerFrom) == false) goto L48;
        this.mVirtualMemorySwitch.getLocationOnScreen(r0);
        goto L72
    L48:
        if ("com.bytedanceos.fake.usb.device.connection".equals(this.mNotificationBannerFrom) == false) goto L51;
        this.mUsbDeviceConnectionSwitch.getLocationOnScreen(r0);
        goto L72
    L51:
        if ("com.bytedanceos.fake.vpn".equals(this.mNotificationBannerFrom) == false) goto L54;
        this.mVpnSwitch.getLocationOnScreen(r0);
        goto L72
    L54:
        if ("com.bytedanceos.fake.call.missed".equals(this.mNotificationBannerFrom) == false) goto L57;
        this.mCallMissedSwitch.getLocationOnScreen(r0);
        goto L72
    L57:
        if ("com.bytedanceos.fake.virtual.touch.pad".equals(this.mNotificationBannerFrom) == false) goto L60;
        this.mVirtualTouchPadSwitch.getLocationOnScreen(r0);
        goto L72
    L60:
        if ("com.bytedanceos.fake.game.speed.up".equals(this.mNotificationBannerFrom) == false) goto L63;
        this.mGameSpeedUpSwitch.getLocationOnScreen(r0);
        goto L72
    L63:
        if ("com.bytedanceos.fake.voice.mailbox".equals(this.mNotificationBannerFrom) == false) goto L66;
        this.mVoiceMailboxSwitch.getLocationOnScreen(r0);
        goto L72
    L66:
        if ("com.bytedanceos.fake.reading.mode".equals(this.mNotificationBannerFrom) == false) goto L69;
        this.mReadingModeSwitch.getLocationOnScreen(r0);
        goto L72
    L69:
        if ("com.bytedanceos.fake.positioning".equals(this.mNotificationBannerFrom) == false) goto L71;
        this.mPositioningSwitch.getLocationOnScreen(r0);
        goto L72
    L71:
        this.mStorageFullSwitch.getLocationOnScreen(r0);
        goto L72
    }

    public void com_android_settings_SystemNotificationBannerFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        OLog.d(TAG, "onCreate......");
    }

    public void com_android_settings_SystemNotificationBannerFragment__onResume$___twin___() {
        OLog.d(TAG, "onResume......");
        super.onResume();
        Bundle r0 = getArguments();
        if (r0 == null) goto L5;
        this.mNotificationBannerFrom = r0.getString(SYSTEM_NOTIFICATION_BANNER_FROM);
        OLog.d(TAG, "mNotificationBannerFrom = " + this.mNotificationBannerFrom);
    L5:
        getContentResolver().registerContentObserver(AUTHORITY_CONFIG_URI, true, this.mAppCustomConfigObserver);
        initVideoView();
        if (this.mNotificationBannerFrom == null) goto L9;
        this.mHandler.postDelayed(this.runnableScroll, 300);
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        this.mPageScrollview = (ScrollView) NullSafe.nonNull(findViewByIdNullable(R.id.page_scrollview));
        this.mVideoView = (VideoView) NullSafe.nonNull(findViewByIdNullable(R.id.video_view));
        this.mVideoBg = NullSafe.nonNull(findViewByIdNullable(R.id.video_background));
        this.mImageView = (ImageView) NullSafe.nonNull(findViewByIdNullable(R.id.video_default));
        SettingItemSwitch r5 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.storage_full_switch));
        this.mStorageFullSwitch = r5;
        updateSwitchState(r5, "com.bytedanceos.fake.storage.full", 1);
        this.mStorageFullSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r6 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.printer_switch));
        this.mPrinterSwitch = r6;
        updateSwitchState(r6, "com.bytedanceos.fake.printer", 1);
        this.mPrinterSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r7 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.debug_mode_switch));
        this.mDebugModeSwitch = r7;
        updateSwitchState(r7, "com.bytedanceos.fake.debug.mode", 1);
        this.mDebugModeSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r8 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.personal_hotspot_switch));
        this.mPersonalHotspotSwitch = r8;
        updateSwitchState(r8, "com.bytedanceos.fake.persona.hotspot", 1);
        this.mPersonalHotspotSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r9 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.eye_protection_mode_plan_switch));
        this.mEyeProtectionModePlanSwitch = r9;
        updateSwitchState(r9, "com.bytedanceos.fake.eye.protection.mode.plan", 1);
        this.mEyeProtectionModePlanSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r10 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.picture_in_picture_switch));
        this.mPictureInPictureSwitch = r10;
        updateSwitchState(r10, "com.bytedanceos.fake.picture.in.picture", 1);
        this.mPictureInPictureSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r11 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.driving_mode_switch));
        this.mDrivingModeSwitch = r11;
        updateSwitchState(r11, "com.bytedanceos.fake.driving.mode", 1);
        this.mDrivingModeSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r12 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.bluetooth_transport_switch));
        this.mBluetoothTransportSwitch = r12;
        updateSwitchState(r12, "com.bytedanceos.fake.bluetooth.transport", 1);
        this.mBluetoothTransportSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r13 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.contact_import_and_export_switch));
        this.mContactImportAndExportSwitch = r13;
        updateSwitchState(r13, "com.bytedanceos.fake.contact.import.and.export", 1);
        this.mContactImportAndExportSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r14 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.screen_light_switch));
        this.mScreenLightSwitch = r14;
        updateSwitchState(r14, "com.bytedanceos.fake.screen.light", 0);
        this.mScreenLightSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r15 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.screen_recording_switch));
        this.mScreenRecordingSwitch = r15;
        updateSwitchState(r15, "com.bytedanceos.fake.screen.recording", 1);
        this.mScreenRecordingSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r16 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.upload_download_switch));
        this.mUploadDownloadSwitch = r16;
        updateSwitchState(r16, "com.bytedanceos.fake.upload.download", 1);
        this.mUploadDownloadSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r17 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.sim_card_unavailable_switch));
        this.mSimCardUnavailableSwitch = r17;
        updateSwitchState(r17, "com.bytedanceos.fake.sim.card.unavailable", 1);
        this.mSimCardUnavailableSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r18 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.tnt_mode_switch));
        this.mTntModeSwitch = r18;
        updateSwitchState(r18, "com.bytedanceos.fake.tnt.mode", 1);
        this.mTntModeSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r19 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.virtual_memory_switch));
        this.mVirtualMemorySwitch = r19;
        updateSwitchState(r19, "com.bytedanceos.fake.virtual.memory", 1);
        this.mVirtualMemorySwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r20 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.usb_device_connection_switch));
        this.mUsbDeviceConnectionSwitch = r20;
        updateSwitchState(r20, "com.bytedanceos.fake.usb.device.connection", 1);
        this.mUsbDeviceConnectionSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r21 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.vpn_switch));
        this.mVpnSwitch = r21;
        updateSwitchState(r21, "com.bytedanceos.fake.vpn", 1);
        this.mVpnSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r22 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.call_missed_switch));
        this.mCallMissedSwitch = r22;
        updateSwitchState(r22, "com.bytedanceos.fake.call.missed", 1);
        this.mCallMissedSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r23 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.virtual_touch_pad_switch));
        this.mVirtualTouchPadSwitch = r23;
        updateSwitchState(r23, "com.bytedanceos.fake.virtual.touch.pad", 0);
        this.mVirtualTouchPadSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r24 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.game_speed_up_switch));
        this.mGameSpeedUpSwitch = r24;
        updateSwitchState(r24, "com.bytedanceos.fake.game.speed.up", 1);
        this.mGameSpeedUpSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r25 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.voice_mailbox_switch));
        this.mVoiceMailboxSwitch = r25;
        updateSwitchState(r25, "com.bytedanceos.fake.voice.mailbox", 1);
        this.mVoiceMailboxSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r26 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.reading_mode_switch));
        this.mReadingModeSwitch = r26;
        updateSwitchState(r26, "com.bytedanceos.fake.reading.mode", 0);
        this.mReadingModeSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r27 = (SettingItemSwitch) NullSafe.nonNull(findViewByIdNullable(R.id.positioning_switch));
        this.mPositioningSwitch = r27;
        updateSwitchState(r27, "com.bytedanceos.fake.positioning", 0);
        this.mPositioningSwitch.setOnCheckedChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r3, boolean r4) {
        if (r3 != this.mStorageFullSwitch.getSwitch()) goto L6;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.storage.full", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L6:
        if (r3 != this.mPrinterSwitch.getSwitch()) goto L9;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.printer", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L9:
        if (r3 != this.mDebugModeSwitch.getSwitch()) goto L12;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.debug.mode", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L12:
        if (r3 != this.mPersonalHotspotSwitch.getSwitch()) goto L15;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.persona.hotspot", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L15:
        if (r3 != this.mEyeProtectionModePlanSwitch.getSwitch()) goto L18;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.eye.protection.mode.plan", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L18:
        if (r3 != this.mPictureInPictureSwitch.getSwitch()) goto L21;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.picture.in.picture", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L21:
        if (r3 != this.mDrivingModeSwitch.getSwitch()) goto L24;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.driving.mode", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L24:
        if (r3 != this.mBluetoothTransportSwitch.getSwitch()) goto L27;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.bluetooth.transport", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L27:
        if (r3 != this.mContactImportAndExportSwitch.getSwitch()) goto L30;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.contact.import.and.export", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L30:
        if (r3 != this.mScreenLightSwitch.getSwitch()) goto L33;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.screen.light", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L33:
        if (r3 != this.mScreenRecordingSwitch.getSwitch()) goto L36;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.screen.recording", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L36:
        if (r3 != this.mUploadDownloadSwitch.getSwitch()) goto L39;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.upload.download", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L39:
        if (r3 != this.mSimCardUnavailableSwitch.getSwitch()) goto L42;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.sim.card.unavailable", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L42:
        if (r3 != this.mTntModeSwitch.getSwitch()) goto L45;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.tnt.mode", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L45:
        if (r3 != this.mVirtualMemorySwitch.getSwitch()) goto L48;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.virtual.memory", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L48:
        if (r3 != this.mUsbDeviceConnectionSwitch.getSwitch()) goto L51;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.usb.device.connection", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L51:
        if (r3 != this.mVpnSwitch.getSwitch()) goto L54;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.vpn", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L54:
        if (r3 != this.mCallMissedSwitch.getSwitch()) goto L57;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.call.missed", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L57:
        if (r3 != this.mVirtualTouchPadSwitch.getSwitch()) goto L60;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.virtual.touch.pad", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L60:
        if (r3 != this.mGameSpeedUpSwitch.getSwitch()) goto L63;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.game.speed.up", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L63:
        if (r3 != this.mVoiceMailboxSwitch.getSwitch()) goto L66;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.voice.mailbox", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L66:
        if (r3 != this.mReadingModeSwitch.getSwitch()) goto L69;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.reading.mode", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    L69:
        if (r3 != this.mPositioningSwitch.getSwitch()) goto L94;
        AppCustomConfig.setInteger(getContext(), "com.bytedanceos.fake.positioning", "notification_heads_up", Integer.valueOf(r4 ? 1 : 0));
        return;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        VideoView r0 = this.mVideoView;
        if (r0 == null) goto L6;
        r0.stopPlayback();
    L6:
        if (this.mAppCustomConfigObserver == null) goto L9;
        getContentResolver().unregisterContentObserver(this.mAppCustomConfigObserver);
        return;
    }

    private void initVideoView() {
        final Uri r0 = getVideoUri();
        if (r0 != null) goto L5;
        updateVideoView(false, null);
    L6:
        this.mVideoView.setOnPreparedListener(new AnonymousClass4(this));
        this.mVideoView.setOnCompletionListener(new AnonymousClass5(this));
        this.mVideoView.setOnErrorListener(new AnonymousClass6(this, r0));
        this.mVideoView.setOnInfoListener(new AnonymousClass7(this));
        return;
    L5:
        updateVideoView(true, r0);
        goto L6
    }

    private void updateVideoView(boolean r3, Uri r4) {
        if (r3 == false) goto L4;
        this.mVideoView.setVideoURI(r4);
        this.mVideoBg.setVisibility(4);
        return;
    L4:
        this.mVideoView.stopPlayback();
        this.mVideoView.setVisibility(8);
        this.mVideoBg.setVisibility(0);
        this.mVideoBg.setBackgroundResource(R.drawable.load_fail_video);
        if (this.mToastTime != 0) goto L7;
    L8:
        ToastUtils.show(getActivity(), R.string.toast_gesture_download_error);
        this.mToastTime = System.currentTimeMillis();
        return;
    L7:
        if ((System.currentTimeMillis() - this.mToastTime) > TOAST_TIME_GAP) goto L8;
    }

    private Uri getVideoUri() {
        if (getContext() != null) goto L7;
        return null;
    L7:
        return Uri.parse("android.resource://" + getContext().getPackageName() + "/2131886138");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        VideoView r0 = this.mVideoView;
        if (r0 == null) goto L5;
        r0.stopPlayback();
    L5:
        Handler r1 = this.mHandler;
        if (r1 == null) goto L8;
        r1.removeCallbacksAndMessages(null);
    L8:
        super.onDestroyView();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SystemNotificationBannerFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SystemNotificationBannerFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SystemNotificationBannerFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_SystemNotificationBannerFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SystemNotificationBannerFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SystemNotificationBannerFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
