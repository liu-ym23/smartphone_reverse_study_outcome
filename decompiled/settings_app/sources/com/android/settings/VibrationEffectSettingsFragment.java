package com.android.settings;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.android.settings.applications.utils.OCardListItemUtils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.UIUtils;
import com.obric.olog.OLog;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class VibrationEffectSettingsFragment extends BaseFragment implements View.OnClickListener {
    private int mInternalRingtonePosition;
    private boolean mIsExternalRingtone;
    private OCardListItem mNone;
    private LinearLayout mPageContainer;
    private String[] mPresetNames;
    private String[] mPresetUris;
    private String mSoundSettingType;
    private OCardListItem mSync;
    private String[] mSyncUris;
    private Vibrator mVibratorManager;
    private List<OCardListItem> mViews;

    public void com_android_settings_VibrationEffectSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_VibrationEffectSettingsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public VibrationEffectSettingsFragment() {
        this.mViews = new ArrayList();
        this.mPresetNames = null;
        this.mPresetUris = null;
        this.mSyncUris = null;
    }

    static /* synthetic */ void access$000(VibrationEffectSettingsFragment r0) {
        r0.clearAllCheck();
    }

    static /* synthetic */ String access$100(VibrationEffectSettingsFragment r0) {
        return r0.mSoundSettingType;
    }

    static /* synthetic */ void access$200(VibrationEffectSettingsFragment r0, String r1) {
        r0.setVibrationEffect(r1);
    }

    static /* synthetic */ void access$300(VibrationEffectSettingsFragment r0, boolean r1) {
        r0.setVibrationEffectEnable(r1);
    }

    static /* synthetic */ void access$400(VibrationEffectSettingsFragment r0, String r1) {
        r0.setVibrationEffectUri(r1);
    }

    static /* synthetic */ Vibrator access$500(VibrationEffectSettingsFragment r0) {
        return r0.mVibratorManager;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        this.mRootView = r2.inflate(R.layout.vibration_effect_settings_layout, r3, false);
        Bundle r5 = getArguments();
        this.mVibratorManager = (Vibrator) getContext().getSystemService("vibrator");
        this.mSoundSettingType = r5.getString(SoundSettingsFragment.EXTRA_TYPE);
        this.mIsExternalRingtone = r5.getBoolean(RingtoneSettingsFragment.EXTRA_IS_EXTERNAL_RINGTONE);
        this.mInternalRingtonePosition = r5.getInt(RingtoneSettingsFragment.EXTRA_INTERNAL_RINGTONE_POSITION);
        String r6 = this.mSoundSettingType;
        if (r6 != null) goto L7;
        finish();
        return this.mRootView;
    L7:
        if (r6.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L9;
    L12:
        this.mPresetNames = this.mContext.getResources().getStringArray(R.array.vibration_title);
        this.mPresetUris = RingtoneSettingsFragment.mPresetLongVibrationUris;
        this.mSyncUris = RingtoneSettingsFragment.mSyncLongVibrationUris;
    L13:
        OCardListItem r7 = (OCardListItem) this.mRootView.findViewById(R.id.vibration_effect_none);
        this.mNone = r7;
        OCardListItemUtils.setCustomEndImageView(r7);
        this.mNone.setOnContentClickListener(this);
        OCardListItem r8 = (OCardListItem) this.mRootView.findViewById(R.id.vibration_effect_sync);
        this.mSync = r8;
        OCardListItemUtils.setCustomEndImageView(r8);
        this.mSync.setOnContentClickListener(this);
        if (this.mIsExternalRingtone == false) goto L16;
        this.mSync.setVisibility(8);
    L16:
        this.mPageContainer = (LinearLayout) this.mRootView.findViewById(R.id.page_container);
        initPresetItems();
        clearAllCheck();
        setItemCheck();
        UIUtils.setUpBottomPaddingOnApplyWindowInsets((ViewGroup) findViewByIdNullable(R.id.page_container));
        return this.mRootView;
    L9:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L12;
        this.mPresetNames = this.mContext.getResources().getStringArray(R.array.vibration_title);
        this.mPresetUris = RingtoneSettingsFragment.mPresetShortVibrationUris;
        this.mSyncUris = RingtoneSettingsFragment.mSyncShortVibrationUris;
        goto L13
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Vibrator r0 = this.mVibratorManager;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    private void initPresetItems() {
        if (this.mPresetNames.length == 0) goto L5;
    L8:
        int r0 = 0;
    L10:
        if (r0 >= this.mPresetNames.length) goto L16;
        View r3 = LayoutInflater.from(getContext()).inflate(R.layout.card_list_item_oui, null, false);
        final OCardListItem r4 = (OCardListItem) r3.findViewById(R.id.item_text);
        r4.setTitle(this.mPresetNames[r0]);
        OCardListItemUtils.setCustomEndImageView(r4);
        r4.showCustomEnd(false);
        final String r5 = this.mPresetUris[r0];
        r4.setOnContentClickListener(new AnonymousClass1(this, r4, r5));
        if (r0 != (this.mPresetNames.length - 1)) goto L14;
        r4.setCardPosition(3);
    L15:
        this.mPageContainer.addView(r3);
        this.mViews.add(r4);
        r0 = r0 + 1;
        goto L10
    L14:
        r4.setCardPosition(2);
        goto L15
    L16:
        return;
    L5:
        if (this.mSync.getVisibility() != 0) goto L7;
        this.mSync.setCardPosition(3);
        goto L8
    L7:
        this.mNone.setCardPosition(0);
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        clearAllCheck();
        if (r5 != this.mNone.getContentContainer()) goto L15;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L7;
    L10:
        setVibrationEffect("none");
    L11:
        this.mNone.showCustomEnd(true);
        Vibrator r4 = this.mVibratorManager;
        if (r4 == null) goto L35;
        r4.cancel();
        return;
    L35:
        return;
    L7:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L10;
        setVibrationEffectEnable(false);
        goto L11
    L15:
        if (r5 == this.mSync.getContentContainer()) goto L17;
        return;
    L17:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L19;
    L27:
        int r6 = this.mInternalRingtonePosition;
        if (r6 < 0) goto L32;
        String[] r1 = this.mSyncUris;
        if (r6 >= r1.length) goto L32;
        setVibrationEffect(r1[r6]);
    L33:
        this.mSync.showCustomEnd(true);
        vibrate();
        return;
    L32:
        setVibrationEffect(null);
        goto L33
    L19:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L27;
        setVibrationEffectEnable(true);
        int r7 = this.mInternalRingtonePosition;
        if (r7 < 0) goto L26;
        String[] r2 = this.mSyncUris;
        if (r7 >= r2.length) goto L26;
        setVibrationEffectUri(r2[r7]);
    L26:
        setVibrationEffectUri(null);
        goto L33
    }

    private void clearAllCheck() {
        this.mNone.showCustomEnd(false);
        this.mSync.showCustomEnd(false);
        int r0 = 0;
    L4:
        if (r0 >= this.mViews.size()) goto L6;
        this.mViews.get(r0).showCustomEnd(false);
        r0 = r0 + 1;
        goto L4
    }

    public static String getStorageKey(String r2, boolean r3) {
        r2.hashCode();
        byte r1 = -1;
        switch(r2.hashCode()) {
            case -883389629: goto L22;
            case -675989426: goto L18;
            case -150053113: goto L14;
            case 908205731: goto L10;
            case 1870114858: goto L6;
            default: goto L25;
        };
    L25:
        switch(r1) {
            case 0: goto L45;
            case 1: goto L40;
            case 2: goto L38;
            case 3: goto L33;
            case 4: goto L31;
            default: goto L26;
        };
    L26:
        if (r3 == false) goto L29;
        return RingtoneSettingsFragment.NOTIFICATION_VIBRATION_ENABLED;
    L29:
        return RingtoneSettingsFragment.NOTIFICATION_VIBRATION_EFFECT_URI;
    L31:
        return RingtoneSettingsFragment.RINGTONE_VIBRATION_EFFECT_2;
    L33:
        if (r3 == false) goto L36;
        return RingtoneSettingsFragment.CALENDAR_VIBRATION_ENABLED;
    L36:
        return RingtoneSettingsFragment.CALENDAR_VIBRATION_EFFECT_URI;
    L38:
        return RingtoneSettingsFragment.RINGTONE_VIBRATION_EFFECT;
    L40:
        if (r3 == false) goto L43;
        return RingtoneSettingsFragment.SMS_1_VIBRATION_ENABLED;
    L43:
        return RingtoneSettingsFragment.SMS_1_VIBRATION_EFFECT_URI;
    L45:
        if (r3 == false) goto L48;
        return RingtoneSettingsFragment.SMS_2_VIBRATION_ENABLED;
    L48:
        return RingtoneSettingsFragment.SMS_2_VIBRATION_EFFECT_URI;
    L6:
        if (r2.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L25;
        r1 = 4;
        goto L25
    L10:
        if (r2.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L25;
        r1 = 3;
        goto L25
    L14:
        if (r2.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L25;
        r1 = 2;
        goto L25
    L18:
        if (r2.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L25;
        r1 = 1;
        goto L25
    L22:
        if (r2.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L25;
        r1 = 0;
        goto L25
    }

    private void setVibrationEffect(String r3) {
        android.provider.Settings.System.putString(getContentResolver(), getStorageKey(this.mSoundSettingType, false), r3);
    }

    private String getVibrationEffect() {
        return android.provider.Settings.System.getString(getContentResolver(), getStorageKey(this.mSoundSettingType, false));
    }

    private void setVibrationEffectEnable(boolean r3) {
        android.provider.Settings.Global.putInt(getContentResolver(), getStorageKey(this.mSoundSettingType, true), r3 ? 1 : 0);
    }

    private boolean getVibrationEffectEnable() {
        if (android.provider.Settings.Global.getInt(getContentResolver(), getStorageKey(this.mSoundSettingType, true), 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private void setVibrationEffectUri(String r3) {
        android.provider.Settings.Global.putString(getContentResolver(), getStorageKey(this.mSoundSettingType, false), r3);
    }

    private String getVibrationEffectUri() {
        return android.provider.Settings.Global.getString(getContentResolver(), getStorageKey(this.mSoundSettingType, false));
    }

    private void setItemCheck() {
        int r1 = 0;
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L5;
    L21:
        String r0 = getVibrationEffect();
        if (r0 != null) goto L26;
        this.mSync.showCustomEnd(true);
        return;
    L26:
        if (r0.equals("none") == false) goto L29;
        this.mNone.showCustomEnd(true);
        return;
    L29:
        if (Arrays.asList(this.mSyncUris).contains(r0) == false) goto L32;
        this.mSync.showCustomEnd(true);
        return;
    L32:
        if (r1 >= this.mViews.size()) goto L48;
        if (r0.equals(this.mPresetUris[r1]) == false) goto L36;
        this.mViews.get(r1).showCustomEnd(true);
    L36:
        r1 = r1 + 1;
        goto L32
    L48:
        return;
    L5:
        if (this.mSoundSettingType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L21;
        String r2 = getVibrationEffectUri();
        if (getVibrationEffectEnable() == true) goto L10;
        this.mNone.showCustomEnd(true);
        return;
    L10:
        if (r2 != null) goto L12;
    L20:
        this.mSync.showCustomEnd(true);
        return;
    L12:
        if (Arrays.asList(this.mSyncUris).contains(r2) == true) goto L20;
    L15:
        if (r1 >= this.mViews.size()) goto L47;
        if (r2.equals(this.mPresetUris[r1]) == false) goto L19;
        this.mViews.get(r1).showCustomEnd(true);
    L19:
        r1 = r1 + 1;
        goto L15
    }

    private void vibrate() {
        Vibrator r0 = this.mVibratorManager;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.hasVibrator() == false) goto L53;
        String r1 = this.mSoundSettingType;
        r1.hashCode();
        byte r2 = -1;
        switch(r1.hashCode()) {
            case -883389629: goto L31;
            case -675989426: goto L27;
            case -150053113: goto L23;
            case 610021948: goto L19;
            case 908205731: goto L15;
            case 1870114858: goto L11;
            default: goto L34;
        };
    L34:
        switch(r2) {
            case 0: goto L41;
            case 1: goto L41;
            case 2: goto L36;
            case 3: goto L41;
            case 4: goto L41;
            case 5: goto L36;
            default: goto L54;
        };
    L36:
        String r3 = getVibrationEffect();
        if (r3 == null) goto L48;
        Uri r4 = Uri.parse(r3);
        VibrationEffect r5 = vibrationEffectGetEffectByUri(this.mContext, r4);
        if (r5 == null) goto L49;
        this.mVibratorManager.vibrate(r5);
        return;
    L49:
        return;
    L48:
        return;
    L41:
        String r6 = getVibrationEffectUri();
        if (r6 == null) goto L51;
        Uri r7 = Uri.parse(r6);
        VibrationEffect r8 = vibrationEffectGetEffectByUri(this.mContext, r7);
        if (r8 == null) goto L52;
        this.mVibratorManager.vibrate(r8);
        return;
    L52:
        return;
    L51:
        return;
    L54:
        return;
    L11:
        if (r1.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L34;
        r2 = 5;
        goto L34
    L15:
        if (r1.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L34;
        r2 = 4;
        goto L34
    L19:
        if (r1.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L34;
        r2 = 3;
        goto L34
    L23:
        if (r1.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L34;
        r2 = 2;
        goto L34
    L27:
        if (r1.equals(SoundSettingsFragment.TYPE_MMS) == false) goto L34;
        r2 = 1;
        goto L34
    L31:
        if (r1.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L34;
        r2 = 0;
        goto L34
    }

    private VibrationEffect vibrationEffectGet(Uri r9) {
        return (VibrationEffect) VibrationEffect.class.getMethod("get", new Class[]{Uri.class, Context.class}).invoke(null, new Object[]{r9, getContext()});
    L5:
        e = move-exception;
        e.printStackTrace();
        OLog.d(this.TAG, "get method: VibrationEffect.get() failed");
        return null;
    }

    public static VibrationEffect vibrationEffectGetEffectByUri(Context r8, Uri r9) {
        return (VibrationEffect) VibrationEffect.class.getMethod("getEffectByUri", new Class[]{Uri.class, Context.class}).invoke(null, new Object[]{r9, r8});
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(VibrationEffectSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_VibrationEffectSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(VibrationEffectSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_VibrationEffectSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(VibrationEffectSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_VibrationEffectSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
