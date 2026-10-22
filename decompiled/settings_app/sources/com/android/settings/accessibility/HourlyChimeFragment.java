package com.android.settings.accessibility;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.fragment.app.Fragment;
import com.android.settings.OptionsInfo;
import com.android.settings.R;
import com.android.settings.RingtoneSettingsFragment;
import com.android.settings.SoundSettingsFragment;
import com.android.settings.Utils;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.TimePicker;
import obric.widget.TimePickerDialog;

/* JADX INFO: loaded from: classes2.dex */
public class HourlyChimeFragment extends BaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, TimePickerDialog.OnTimeSetListener {
    private static final int CHIME_TYPE_SOUND = 1;
    private static final int CHIME_TYPE_VIBRATE = 2;
    private static final int CHIME_TYPE_VOICE = 0;
    public static final int DEFAULT_CHIME_END = 2200;
    public static final int DEFAULT_CHIME_START = 800;
    private static final String DEFAULT_REPORT_RINGTONE_PATH = "/system/media/audio/notifications/tiePianQin.ogg";
    public static final int MINIUM_CHIME_FREQUENCY = 900000;
    public static final String TYPE_HOURLY_CHIME = "type_now_time";
    private SettingItemText mHourlyChimeEndTime;
    private SettingItemText mHourlyChimeStartTime;
    private SettingItemSwitch mHourlyChimeSwitch;
    private boolean mIsStartOrEndTimeClicked;
    private SettingItemText mReportFrequency;
    private View mReportInRing;
    private RadioButton mReportInRingRadio;
    private View mReportInRingSetting;
    private View mReportInVibration;
    private RadioButton mReportInVibrationRadio;
    private View mReportInVoice;
    private RadioButton mReportInVoiceRadio;

    public void com_android_settings_accessibility_HourlyChimeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_accessibility_HourlyChimeFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public HourlyChimeFragment() {
        this.mIsStartOrEndTimeClicked = false;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        View r4 = r1.inflate(R.layout.hourly_chime_fragment, null);
        this.mHourlyChimeSwitch = (SettingItemSwitch) r4.findViewById(R.id.id_accessibility_hourly_chime_switch);
        this.mReportFrequency = (SettingItemText) r4.findViewById(R.id.id_accessibility_hourly_chime_report_frequency);
        this.mReportInVoice = r4.findViewById(R.id.id_accessibility_hourly_chime_in_voice);
        this.mReportInRing = r4.findViewById(R.id.id_accessibility_hourly_chime_in_ring);
        this.mReportInVibration = r4.findViewById(R.id.id_accessibility_hourly_chime_in_vibration);
        this.mReportInVoiceRadio = (RadioButton) r4.findViewById(R.id.id_accessibility_hourly_chime_in_voice_radio);
        this.mReportInRingRadio = (RadioButton) r4.findViewById(R.id.id_accessibility_hourly_chime_in_ring_radio);
        this.mReportInVibrationRadio = (RadioButton) r4.findViewById(R.id.id_accessibility_hourly_chime_in_vibration_radio);
        this.mReportInRingSetting = r4.findViewById(R.id.id_accessibility_hourly_chime_in_ring_setting);
        this.mHourlyChimeStartTime = (SettingItemText) r4.findViewById(R.id.id_accessibility_hourly_chime_start);
        this.mHourlyChimeEndTime = (SettingItemText) r4.findViewById(R.id.id_accessibility_hourly_chime_end);
        this.mReportFrequency.setOnClickListener(this);
        this.mReportInVoice.setOnClickListener(this);
        this.mReportInRing.setOnClickListener(this);
        this.mReportInVibration.setOnClickListener(this);
        this.mReportInRingSetting.setOnClickListener(this);
        this.mHourlyChimeStartTime.setOnClickListener(this);
        this.mHourlyChimeEndTime.setOnClickListener(this);
        initRingtone();
        return r4;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mHourlyChimeSwitch.setOnCheckedChangeListener(this);
    }

    private void initRingtone() {
        if (Settings.System.getString(getContentResolver(), "hourly_chime_ringtone_uri") == null) goto L5;
        return;
    L5:
        if (Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime", -1) >= 0) goto L12;
        Uri r0 = getAudioUri(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, DEFAULT_REPORT_RINGTONE_PATH);
        if (r0 != null) goto L9;
        return;
    L9:
        Settings.System.putString(getContentResolver(), "hourly_chime_ringtone_uri", r0.toString());
        return;
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateViews() {
        SettingItemSwitch r0 = this.mHourlyChimeSwitch;
        boolean r3 = false;
        if (Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime", 0) != 1) goto L5;
        boolean r1 = true;
    L6:
        r0.setChecked(r1);
        this.mReportFrequency.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mReportInVoice.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mReportInRing.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mReportInVibration.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mHourlyChimeStartTime.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mHourlyChimeEndTime.setEnabled(this.mHourlyChimeSwitch.isChecked());
        this.mReportFrequency.setSubTitle(getResources().getStringArray(R.array.hourly_chime_frequency_titles)[getChimeFrequency()]);
        this.mHourlyChimeStartTime.setSubTitle(getTimeString(Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_start", 800)));
        this.mHourlyChimeEndTime.setSubTitle(getTimeString(Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_end", DEFAULT_CHIME_END)));
        int r2 = Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_type", 0);
        RadioButton r4 = this.mReportInVoiceRadio;
        if (r2 != 0) goto L9;
        boolean r5 = true;
    L10:
        r4.setChecked(r5);
        RadioButton r6 = this.mReportInRingRadio;
        if (r2 != 1) goto L13;
        boolean r7 = true;
    L14:
        r6.setChecked(r7);
        RadioButton r8 = this.mReportInVibrationRadio;
        if (r2 != 2) goto L17;
        r3 = true;
    L17:
        r8.setChecked(r3);
        return;
    L13:
        r7 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        if (r5 != this.mReportInVoice) goto L6;
        this.mReportInVoiceRadio.setChecked(true);
        this.mReportInRingRadio.setChecked(false);
        this.mReportInVibrationRadio.setChecked(false);
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime_type", 0);
        return;
    L6:
        if (r5 != this.mReportInRing) goto L9;
        this.mReportInVoiceRadio.setChecked(false);
        this.mReportInRingRadio.setChecked(true);
        this.mReportInVibrationRadio.setChecked(false);
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime_type", 1);
        return;
    L9:
        if (r5 != this.mReportInVibration) goto L12;
        this.mReportInVoiceRadio.setChecked(false);
        this.mReportInRingRadio.setChecked(false);
        this.mReportInVibrationRadio.setChecked(true);
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime_type", 2);
        return;
    L12:
        if (r5 != this.mReportFrequency) goto L15;
        lunchReportFrequencyOptions();
        return;
    L15:
        if (r5 != this.mHourlyChimeStartTime) goto L18;
        showTimePicker(true);
        return;
    L18:
        if (r5 != this.mHourlyChimeEndTime) goto L21;
        showTimePicker(false);
        return;
    L21:
        if (r5 != this.mReportInRingSetting) goto L30;
        RingtoneSettingsFragment r6 = new RingtoneSettingsFragment();
        prepareRingtonePickerIntent(r6, getString(R.string.accessibility_hourly_chime_report_ringtone), TYPE_HOURLY_CHIME);
        start(r6);
        return;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime", r3 ? 1 : 0);
        updateViews();
        if (r3 == false) goto L5;
        HourlyChimeReciever.maintainChimeLife(getContext());
        return;
    L5:
        HourlyChimeReciever.cancelChime(getContext());
    }

    private void lunchReportFrequencyOptions() {
        String[] r0 = getResources().getStringArray(R.array.hourly_chime_frequency_values);
        OptionsInfo r2 = new OptionsInfo(getResources().getStringArray(R.array.hourly_chime_frequency_titles), r0, OptionsInfo.SaveTargetTable.Global, "accessibility_hourly_chime_frequency");
        Utils.launchOptionsActivity(getActivity(), r2, r0[getChimeFrequency()], getString(R.string.accessibility_hourly_chime_frequency), R.string.accessibility_hourly_chime);
    }

    private int getChimeFrequency() {
        String[] r0 = getResources().getStringArray(R.array.hourly_chime_frequency_values);
        int r4 = Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_frequency", 60);
        int r2 = 0;
    L4:
        if (r2 >= r0.length) goto L9;
        if (Integer.parseInt(r0[r2]) == r4) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return r2;
    L9:
        return 0;
    }

    private void showTimePicker(boolean r10) {
        this.mIsStartOrEndTimeClicked = r10;
        Calendar r0 = Calendar.getInstance();
        if (r10 == false) goto L5;
        int r11 = Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_start", 800);
    L6:
        r0.set(11, r11 / 100);
        r0.set(12, r11 % 100);
        new TimePickerDialog(getContext(), this, r0.get(11), r0.get(12), DateFormat.is24HourFormat(getContext())).show();
        return;
    L5:
        r11 = Settings.Global.getInt(getContentResolver(), "accessibility_hourly_chime_end", DEFAULT_CHIME_END);
        goto L6
    }

    @Override // obric.widget.TimePickerDialog.OnTimeSetListener
    public void onTimeSet(TimePicker r4, int r5, int r6) {
        Calendar r7 = Calendar.getInstance();
        r7.set(11, r5);
        r7.set(12, r6);
        String r8 = DateUtils.formatDateTime(getContext(), r7.getTimeInMillis(), 1);
        if (this.mIsStartOrEndTimeClicked == false) goto L5;
        this.mHourlyChimeStartTime.setSubTitle(r8);
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime_start", (r5 * 100) + r6);
        return;
    L5:
        this.mHourlyChimeEndTime.setSubTitle(r8);
        Settings.Global.putInt(getContentResolver(), "accessibility_hourly_chime_end", (r5 * 100) + r6);
    }

    private String getTimeString(int r4) {
        int r0 = r4 % 100;
        Calendar r1 = Calendar.getInstance();
        r1.set(11, r4 / 100);
        r1.set(12, r0);
        return DateUtils.formatDateTime(getContext(), r1.getTimeInMillis(), 1);
    }

    private void prepareRingtonePickerIntent(Fragment r4, String r5, String r6) {
        Bundle r0 = new Bundle();
        String r3 = Settings.System.getString(getContentResolver(), "hourly_chime_ringtone_uri");
        r0.putBoolean("android.intent.extra.ringtone.SHOW_DEFAULT", false);
        if (r3 != null) goto L5;
        Uri r7 = null;
    L6:
        r0.putParcelable("android.intent.extra.ringtone.DEFAULT_URI", r7);
        r0.putInt("android.intent.extra.ringtone.TYPE", 2);
        r0.putBoolean("android.intent.extra.ringtone.SHOW_SILENT", true);
        r0.putString("title", r5);
        r0.putString(SoundSettingsFragment.EXTRA_TYPE, r6);
        r4.setArguments(r0);
        return;
    L5:
        r7 = Uri.parse(r3);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    private Uri getAudioUri(Uri r9, String r10) {
        ?? r0 = 0;
        int r1 = -1;
        Cursor r11 = getContentResolver().query(r9, null, "_data=?", new String[]{r10}, null);     // Catch: Throwable -> L13 Exception -> L15
        if (r11 != null) goto L30;
    L11:
        if (r11 == null) goto L20;
    L12:
        r11.close();
    L20:
        if (r1 > 0) goto L22;
        return null;
    L22:
        return Uri.withAppendedPath(r9, String.valueOf(r1));
    L30:
    L9:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r11 == null) goto L20;
    L6:
        if (r11.moveToFirst() == false) goto L11;
        r1 = r11.getInt(0);     // Catch: Exception -> L9 Throwable -> L24
        goto L11
    L24:
        th = th;
        r0 = r10;
    L26:
        if (r0 == 0) goto L28;
        r0.close();
    L28:
        throw th;
    L15:
        e = e;
        r11 = null;
    L13:
        th = th;
        goto L26
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(HourlyChimeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_HourlyChimeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(HourlyChimeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_HourlyChimeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(HourlyChimeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_HourlyChimeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
