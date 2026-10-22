package com.android.settingslib.notification;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.service.notification.Condition;
import android.service.notification.ZenModeConfig;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.Log;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.GlobalProxyLancet;
import com.android.internal.policy.PhoneWindow;
import com.android.settingslib.R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class EnableZenModeDialog {
    protected static final int COUNTDOWN_ALARM_CONDITION_INDEX = 2;
    protected static final int COUNTDOWN_CONDITION_INDEX = 1;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_BUCKET_INDEX = 0;
    protected static final int FOREVER_CONDITION_INDEX = 0;
    private static final int MAX_BUCKET_MINUTES = 0;
    private static final int MINUTES_MS = 60000;
    private static final int[] MINUTE_BUCKETS = null;
    private static final int MIN_BUCKET_MINUTES = 0;
    private static final int SECONDS_MS = 1000;
    private static final String TAG = "EnableZenModeDialog";
    private int MAX_MANUAL_DND_OPTIONS;
    private AlarmManager mAlarmManager;
    private boolean mAttached;
    private int mBucketIndex;
    private final boolean mCancelIsNeutral;
    protected Context mContext;
    protected Uri mForeverId;
    protected LayoutInflater mLayoutInflater;
    private final ZenModeDialogMetricsLogger mMetricsLogger;
    protected NotificationManager mNotificationManager;
    private final int mThemeResId;
    private int mUserId;
    protected TextView mZenAlarmWarning;
    private RadioGroup mZenRadioGroup;
    protected LinearLayout mZenRadioGroupContent;

    protected static class ConditionTag {
        public Condition condition;
        public TextView line1;
        public TextView line2;
        public View lines;
        public RadioButton rb;

        protected ConditionTag() {
        }
    }

    static /* synthetic */ RadioGroup access$000(EnableZenModeDialog r0) {
        return r0.mZenRadioGroup;
    }

    static /* synthetic */ boolean access$100(EnableZenModeDialog r0, Condition r1) {
        return r0.isForever(r1);
    }

    static /* synthetic */ ZenModeDialogMetricsLogger access$200(EnableZenModeDialog r0) {
        return r0.mMetricsLogger;
    }

    static /* synthetic */ Uri access$300(EnableZenModeDialog r0, Condition r1) {
        return r0.getRealConditionId(r1);
    }

    static /* synthetic */ boolean access$400() {
        return DEBUG;
    }

    static /* synthetic */ void access$500(EnableZenModeDialog r0, Condition r1) {
        r0.updateAlarmWarningText(r1);
    }

    static /* synthetic */ void access$600(EnableZenModeDialog r0, View r1, ConditionTag r2, boolean r3, int r4) {
        r0.onClickTimeButton(r1, r2, r3, r4);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        int[] r0 = ZenModeConfig.MINUTE_BUCKETS;
        MINUTE_BUCKETS = r0;
        MIN_BUCKET_MINUTES = r0[0];
        MAX_BUCKET_MINUTES = r0[r0.length - 1];
        DEFAULT_BUCKET_INDEX = Arrays.binarySearch(r0, 60);
    }

    public EnableZenModeDialog(Context r2) {
        this(r2, 0);
    }

    public EnableZenModeDialog(Context r3, int r4) {
        this(r3, r4, false, new ZenModeDialogMetricsLogger(r3));
    }

    public EnableZenModeDialog(Context r2, int r3, boolean r4, ZenModeDialogMetricsLogger r5) {
        this.mBucketIndex = -1;
        this.MAX_MANUAL_DND_OPTIONS = 3;
        this.mContext = r2;
        this.mThemeResId = r3;
        this.mCancelIsNeutral = r4;
        this.mMetricsLogger = r5;
    }

    public AlertDialog createDialog() {
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        this.mForeverId = Condition.newId(this.mContext).appendPath("forever").build();
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService("alarm");
        this.mUserId = this.mContext.getUserId();
        this.mAttached = false;
        AlertDialog.Builder r0 = new AlertDialog.Builder(this.mContext, this.mThemeResId).setTitle(R.string.zen_mode_settings_turn_on_dialog_title).setPositiveButton(R.string.zen_mode_enable_dialog_turn_on, new AnonymousClass1(this));
        if (this.mCancelIsNeutral == false) goto L5;
        r0.setNeutralButton(R.string.cancel, null);
    L6:
        View r1 = getContentView();
        bindConditions(forever());
        r0.setView(r1);
        return r0.create();
    L5:
        r0.setNegativeButton(R.string.cancel, null);
        goto L6
    }

    private void hideAllConditions() {
        int r0 = this.mZenRadioGroupContent.getChildCount();
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L6;
        this.mZenRadioGroupContent.getChildAt(r1).setVisibility(8);
        r1 = r1 + 1;
        goto L4
    L6:
        this.mZenAlarmWarning.setVisibility(8);
    }

    protected View getContentView() {
        if (this.mLayoutInflater != null) goto L5;
        this.mLayoutInflater = new PhoneWindow(this.mContext).getLayoutInflater();
    L5:
        View r0 = this.mLayoutInflater.inflate(R.layout.zen_mode_turn_on_dialog_container, null);
        ScrollView r1 = (ScrollView) r0.findViewById(R.id.container);
        this.mZenRadioGroup = (RadioGroup) r1.findViewById(R.id.zen_radio_buttons);
        this.mZenRadioGroupContent = (LinearLayout) r1.findViewById(R.id.zen_radio_buttons_content);
        this.mZenAlarmWarning = (TextView) r1.findViewById(R.id.zen_alarm_warning);
        int r2 = 0;
    L7:
        if (r2 >= this.MAX_MANUAL_DND_OPTIONS) goto L9;
        View r3 = this.mLayoutInflater.inflate(R.layout.zen_mode_radio_button, this.mZenRadioGroup, false);
        this.mZenRadioGroup.addView(r3);
        r3.setId(r2);
        View r4 = this.mLayoutInflater.inflate(R.layout.zen_mode_condition, this.mZenRadioGroupContent, false);
        r4.setId(this.MAX_MANUAL_DND_OPTIONS + r2);
        this.mZenRadioGroupContent.addView(r4);
        r2 = r2 + 1;
        goto L7
    L9:
        hideAllConditions();
        return r0;
    }

    protected void bind(Condition r11, View r12, int r13) {
        if (r11 == null) goto L24;
        boolean r2 = true;
        if (r11.state != 1) goto L6;
        boolean r7 = true;
    L8:
        if (r12.getTag() == null) goto L10;
        ConditionTag r0 = (ConditionTag) r12.getTag();
    L11:
        final ConditionTag r4 = r0;
        r12.setTag(r4);
        if (r4.rb == null) goto L16;
        r2 = false;
    L16:
        if (r4.rb != null) goto L18;
        r4.rb = (RadioButton) this.mZenRadioGroup.getChildAt(r13);
    L18:
        r4.condition = r11;
        final Uri r9 = getConditionId(r4.condition);
        if (DEBUG == false) goto L21;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "bind i=" + this.mZenRadioGroupContent.indexOfChild(r12) + " first=" + r2 + " condition=" + r9);
    L21:
        r4.rb.setEnabled(r7);
        r4.rb.setOnCheckedChangeListener(new AnonymousClass2(this, r4, r9));
        updateUi(r4, r12, r11, r7, r13, r9);
        r12.setVisibility(0);
        return;
    L10:
        r0 = new ConditionTag();
        goto L11
    L6:
        r7 = false;
        goto L8
    L24:
        throw new IllegalArgumentException("condition must not be null");
    }

    protected ConditionTag getConditionTagAt(int r1) {
        return (ConditionTag) this.mZenRadioGroupContent.getChildAt(r1).getTag();
    }

    protected void bindConditions(Condition r4) {
        bind(forever(), this.mZenRadioGroupContent.getChildAt(0), 0);
        if (r4 != null) goto L6;
        bindGenericCountdown();
        bindNextAlarm(getTimeUntilNextAlarmCondition());
        return;
    L6:
        if (isForever(r4) == false) goto L9;
        getConditionTagAt(0).rb.setChecked(true);
        bindGenericCountdown();
        bindNextAlarm(getTimeUntilNextAlarmCondition());
        return;
    L9:
        if (isAlarm(r4) == false) goto L12;
        bindGenericCountdown();
        bindNextAlarm(r4);
        getConditionTagAt(2).rb.setChecked(true);
        return;
    L12:
        if (isCountdown(r4) == false) goto L14;
        bindNextAlarm(getTimeUntilNextAlarmCondition());
        bind(r4, this.mZenRadioGroupContent.getChildAt(1), 1);
        getConditionTagAt(1).rb.setChecked(true);
        return;
    L14:
        Slog.d(TAG, "Invalid manual condition: " + r4);
    }

    public static Uri getConditionId(Condition r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.id;
    }

    public Condition forever() {
        return new Condition(Condition.newId(this.mContext).appendPath("forever").build(), foreverSummary(this.mContext), "", "", 0, 1, 0);
    }

    public long getNextAlarm() {
        AlarmManager.AlarmClockInfo r2 = this.mAlarmManager.getNextAlarmClock(this.mUserId);
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.getTriggerTime();
    }

    protected boolean isAlarm(Condition r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (ZenModeConfig.isValidCountdownToAlarmConditionId(r1.id) == false) goto L6;
        return true;
    }

    protected boolean isCountdown(Condition r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (ZenModeConfig.isValidCountdownConditionId(r1.id) == false) goto L6;
        return true;
    }

    private boolean isForever(Condition r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (this.mForeverId.equals(r1.id) == false) goto L6;
        return true;
    }

    private Uri getRealConditionId(Condition r1) {
        if (isForever(r1) == false) goto L6;
        return null;
    L6:
        return getConditionId(r1);
    }

    private String foreverSummary(Context r1) {
        return r1.getString(17042312);
    }

    private static void setToMidnight(Calendar r2) {
        r2.set(11, 0);
        r2.set(12, 0);
        r2.set(13, 0);
        r2.set(14, 0);
    }

    protected Condition getTimeUntilNextAlarmCondition() {
        GregorianCalendar r0 = new GregorianCalendar();
        setToMidnight(r0);
        r0.add(5, 6);
        long r1 = getNextAlarm();
        if (r1 <= 0) goto L8;
        GregorianCalendar r3 = new GregorianCalendar();
        r3.setTimeInMillis(r1);
        setToMidnight(r3);
        if (r0.compareTo(r3) >= 0) goto L7;
        return null;
    L7:
        return ZenModeConfig.toNextAlarmCondition(this.mContext, r1, ActivityManager.getCurrentUser());
    L8:
        return null;
    }

    protected void bindGenericCountdown() {
        int r0 = DEFAULT_BUCKET_INDEX;
        this.mBucketIndex = r0;
        Condition r1 = ZenModeConfig.toTimeCondition(this.mContext, MINUTE_BUCKETS[r0], ActivityManager.getCurrentUser());
        if (this.mAttached == true) goto L5;
    L6:
        bind(r1, this.mZenRadioGroupContent.getChildAt(1), 1);
        return;
    L5:
        if (getConditionTagAt(1).condition == null) goto L6;
    }

    private void updateUi(final ConditionTag r8, final View r9, Condition r10, boolean r11, final int r12, Uri r13) {
        if (r8.lines != null) goto L6;
        r8.lines = r9.findViewById(android.R.id.content);
    L6:
        if (r8.line1 != null) goto L9;
        r8.line1 = (TextView) r9.findViewById(android.R.id.text1);
    L9:
        if (r8.line2 != null) goto L12;
        r8.line2 = (TextView) r9.findViewById(android.R.id.text2);
    L12:
        if (TextUtils.isEmpty(r10.line1) == true) goto L14;
        String r0 = r10.line1;
    L15:
        String r1 = r10.line2;
        r8.line1.setText(r0);
        boolean r2 = false;
        if (TextUtils.isEmpty(r1) == false) goto L18;
        r8.line2.setVisibility(8);
    L19:
        r8.lines.setEnabled(r11);
        View r3 = r8.lines;
        float r4 = 1.0f;
        if (r11 == false) goto L22;
        float r14 = 1.0f;
    L23:
        r3.setAlpha(r14);
        r8.lines.setOnClickListener(new AnonymousClass3(this, r8));
        long r5 = ZenModeConfig.tryParseCountdownConditionId(r13);
        ImageView r15 = (ImageView) r9.findViewById(android.R.id.button1);
        ImageView r16 = (ImageView) r9.findViewById(android.R.id.button2);
        if (r12 == 1) goto L26;
    L49:
        if (r15 == null) goto L51;
        ((ViewGroup) r9).removeView(r15);
    L51:
        if (r16 == null) goto L55;
        ((ViewGroup) r9).removeView(r16);
        return;
    L55:
        return;
    L26:
        if (r5 <= 0) goto L49;
        r15.setOnClickListener(new AnonymousClass4(this, r9, r8, r12));
        r16.setOnClickListener(new AnonymousClass5(this, r9, r8, r12));
        int r17 = this.mBucketIndex;
        if (r17 <= (-1)) goto L37;
        if (r17 <= 0) goto L31;
        boolean r18 = true;
    L32:
        r15.setEnabled(r18);
        if (this.mBucketIndex >= (MINUTE_BUCKETS.length - 1)) goto L35;
        r2 = true;
    L35:
        r16.setEnabled(r2);
    L41:
        if (r15.isEnabled() == false) goto L43;
        float r7 = 1.0f;
    L44:
        r15.setAlpha(r7);
        if (r16.isEnabled() == true) goto L48;
        r4 = 0.5f;
    L48:
        r16.setAlpha(r4);
        return;
    L43:
        r7 = 0.5f;
        goto L44
    L31:
        r18 = false;
        goto L32
    L37:
        if ((r5 - System.currentTimeMillis()) <= (MIN_BUCKET_MINUTES * 60000)) goto L39;
        r2 = true;
    L39:
        r15.setEnabled(r2);
        r16.setEnabled(!Objects.equals(r10.summary, ZenModeConfig.toTimeCondition(this.mContext, MAX_BUCKET_MINUTES, ActivityManager.getCurrentUser()).summary));
        goto L41
    L22:
        r14 = 0.4f;
        goto L23
    L18:
        r8.line2.setVisibility(0);
        r8.line2.setText(r1);
        goto L19
    L14:
        r0 = r10.summary;
        goto L15
    }

    protected void bindNextAlarm(Condition r5) {
        View r0 = this.mZenRadioGroupContent.getChildAt(2);
        ConditionTag r2 = (ConditionTag) r0.getTag();
        if (r5 != null) goto L5;
    L10:
        ConditionTag r6 = (ConditionTag) r0.getTag();
        int r3 = 0;
        if (r6 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        View r4 = this.mZenRadioGroup.getChildAt(2);
        if (r7 == false) goto L19;
        int r8 = 0;
    L20:
        r4.setVisibility(r8);
        if (r7 == true) goto L24;
        r3 = 8;
    L24:
        r0.setVisibility(r3);
        return;
    L19:
        r8 = 8;
        goto L20
    L13:
        if (r6.condition == null) goto L15;
        r7 = true;
        goto L16
    L5:
        if (this.mAttached == false) goto L9;
        if (r2 == null) goto L9;
        if (r2.condition != null) goto L10;
    L9:
        bind(r5, r0, 2);
        goto L10
    }

    private void onClickTimeButton(View r19, ConditionTag r20, boolean r21, int r22) {
        this.mMetricsLogger.logOnClickTimeButton(r21);
        int[] r3 = MINUTE_BUCKETS;
        int r4 = r3.length;
        int r5 = this.mBucketIndex;
        int r6 = 0;
        int r8 = -1;
        if (r5 != (-1)) goto L21;
        long r9 = ZenModeConfig.tryParseCountdownConditionId(getConditionId(r20.condition));
        long r10 = System.currentTimeMillis();
    L5:
        if (r6 >= r4) goto L18;
        if (r21 == false) goto L8;
        int r7 = r6;
    L9:
        int r15 = MINUTE_BUCKETS[r7];
        long r13 = r10 + ((long) (60000 * r15));
        if (r21 == true) goto L12;
    L13:
        if (r21 == true) goto L17;
        if (r13 >= r9) goto L17;
    L16:
        this.mBucketIndex = r7;
        Condition r2 = ZenModeConfig.toTimeCondition(this.mContext, r13, r15, ActivityManager.getCurrentUser(), false);
    L19:
        if (r2 != null) goto L25;
        int r11 = DEFAULT_BUCKET_INDEX;
        this.mBucketIndex = r11;
        r2 = ZenModeConfig.toTimeCondition(this.mContext, MINUTE_BUCKETS[r11], ActivityManager.getCurrentUser());
    L25:
        bind(r2, r19, r22);
        updateAlarmWarningText(r20.condition);
        r20.rb.setChecked(true);
        return;
    L17:
        r6 = r6 + 1;
        goto L5
    L12:
        if (r13 > r9) goto L16;
    L8:
        r7 = (r4 - 1) - r6;
        goto L9
    L18:
        r2 = null;
        goto L19
    L21:
        int r12 = r4 - 1;
        if (r21 == false) goto L24;
        r8 = 1;
    L24:
        int r14 = Math.max(0, Math.min(r12, r5 + r8));
        this.mBucketIndex = r14;
        r2 = ZenModeConfig.toTimeCondition(this.mContext, r3[r14], ActivityManager.getCurrentUser());
        goto L25
    }

    private void updateAlarmWarningText(Condition r2) {
        String r3 = computeAlarmWarningText(r2);
        this.mZenAlarmWarning.setText(r3);
        TextView r1 = this.mZenAlarmWarning;
        if (r3 != null) goto L5;
        int r4 = 8;
    L6:
        r1.setVisibility(r4);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    protected String computeAlarmWarningText(Condition r11) {
        if ((this.mNotificationManager.getNotificationPolicy().priorityCategories & 32) == 0) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == false) goto L9;
        return null;
    L9:
        long r4 = System.currentTimeMillis();
        long r6 = getNextAlarm();
        if (r6 >= r4) goto L12;
        return null;
    L12:
        if (r11 != null) goto L14;
    L22:
        int r12 = R.string.zen_alarm_warning_indef;
    L23:
        if (r12 != 0) goto L26;
        return null;
    L26:
        return this.mContext.getResources().getString(r12, new Object[]{getTime(r6, r4)});
    L14:
        if (isForever(r11) == true) goto L22;
        long r8 = ZenModeConfig.tryParseCountdownConditionId(r11.id);
        if (r8 > r4) goto L19;
    L21:
        r12 = 0;
        goto L23
    L19:
        if (r6 >= r8) goto L21;
        r12 = R.string.zen_alarm_warning;
        goto L23
    L5:
        r0 = false;
        goto L7
    }

    protected String getTime(long r4, long r6) {
        if ((r4 - r6) >= 86400000) goto L5;
        boolean r7 = true;
    L6:
        boolean r1 = DateFormat.is24HourFormat(this.mContext, ActivityManager.getCurrentUser());
        if (r7 == false) goto L11;
        if (r1 == false) goto L10;
        String r2 = android.icu.text.DateFormat.HOUR24_MINUTE;
    L14:
        CharSequence r5 = DateFormat.format(DateFormat.getBestDateTimePattern(Locale.getDefault(), r2), r4);
        if (r7 == false) goto L17;
        int r8 = R.string.alarm_template;
    L19:
        return this.mContext.getResources().getString(r8, new Object[]{r5});
    L17:
        r8 = R.string.alarm_template_far;
        goto L19
    L10:
        r2 = "hma";
        goto L14
    L11:
        if (r1 == false) goto L13;
        r2 = "EEEHm";
        goto L14
    L13:
        r2 = "EEEhma";
        goto L14
    L5:
        r7 = false;
        goto L6
    }
}
