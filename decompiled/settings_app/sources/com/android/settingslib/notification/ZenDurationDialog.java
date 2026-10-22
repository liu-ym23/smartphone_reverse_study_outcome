package com.android.settingslib.notification;

import android.app.ActivityManager;
import android.app.Dialog;
import android.content.Context;
import android.provider.Settings;
import android.service.notification.ZenModeConfig;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.policy.PhoneWindow;
import com.android.settingslib.R;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ZenDurationDialog {
    protected static final int ALWAYS_ASK_CONDITION_INDEX = 2;
    protected static final int COUNTDOWN_CONDITION_INDEX = 1;
    private static final int DEFAULT_BUCKET_INDEX = 0;
    protected static final int FOREVER_CONDITION_INDEX = 0;
    protected static final int MAX_BUCKET_MINUTES = 0;
    private static final int[] MINUTE_BUCKETS = null;
    protected static final int MIN_BUCKET_MINUTES = 0;
    private int MAX_MANUAL_DND_OPTIONS;
    protected int mBucketIndex;
    protected Context mContext;
    protected LayoutInflater mLayoutInflater;
    private RadioGroup mZenRadioGroup;
    protected LinearLayout mZenRadioGroupContent;

    protected static class ConditionTag {
        public int countdownZenDuration;
        public TextView line1;
        public View lines;
        public RadioButton rb;

        protected ConditionTag() {
        }
    }

    static {
        int[] r0 = ZenModeConfig.MINUTE_BUCKETS;
        MINUTE_BUCKETS = r0;
        MIN_BUCKET_MINUTES = r0[0];
        MAX_BUCKET_MINUTES = r0[r0.length - 1];
        DEFAULT_BUCKET_INDEX = Arrays.binarySearch(r0, 60);
    }

    public ZenDurationDialog(Context r2) {
        this.mBucketIndex = -1;
        this.MAX_MANUAL_DND_OPTIONS = 3;
        this.mContext = r2;
    }

    public Dialog createDialog() {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this.mContext);
        setupDialog(r0);
        return r0.create();
    }

    public void setupDialog(AlertDialog.Builder r5) {
        final int r0 = Settings.Secure.getInt(this.mContext.getContentResolver(), "zen_duration", 0);
        r5.setTitle(R.string.zen_mode_duration_settings_title).setNegativeButton(R.string.cancel, null).setPositiveButton(R.string.okay, new AnonymousClass1(this, r0));
        View r1 = getContentView();
        setupRadioButtons(r0);
        r5.setView(r1);
    }

    protected void updateZenDuration(int r5) {
        int r0 = this.mZenRadioGroup.getCheckedRadioButtonId();
        int r3 = 0;
        int r1 = Settings.Secure.getInt(this.mContext.getContentResolver(), "zen_duration", 0);
        if (r0 != 0) goto L5;
        MetricsLogger.action(this.mContext, 1343);
    L12:
        if (r5 == r3) goto L15;
        Settings.Secure.putInt(this.mContext.getContentResolver(), "zen_duration", r3);
        return;
    L15:
        return;
    L5:
        if (r0 != 1) goto L7;
        r3 = getConditionTagAt(r0).countdownZenDuration;
        MetricsLogger.action(this.mContext, 1342, r3);
        goto L12
    L7:
        if (r0 == 2) goto L9;
        r3 = r1;
        goto L12
    L9:
        MetricsLogger.action(this.mContext, 1344);
        r3 = -1;
        goto L12
    }

    protected View getContentView() {
        if (this.mLayoutInflater != null) goto L5;
        this.mLayoutInflater = new PhoneWindow(this.mContext).getLayoutInflater();
    L5:
        View r0 = this.mLayoutInflater.inflate(R.layout.zen_mode_duration_dialog, null);
        ScrollView r1 = (ScrollView) r0.findViewById(R.id.zen_duration_container);
        this.mZenRadioGroup = (RadioGroup) r1.findViewById(R.id.zen_radio_buttons);
        this.mZenRadioGroupContent = (LinearLayout) r1.findViewById(R.id.zen_radio_buttons_content);
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
        return r0;
    }

    protected void setupRadioButtons(int r6) {
        if (r6 != 0) goto L5;
        int r3 = 0;
    L8:
        bindTag(r6, this.mZenRadioGroupContent.getChildAt(0), 0);
        bindTag(r6, this.mZenRadioGroupContent.getChildAt(1), 1);
        bindTag(r6, this.mZenRadioGroupContent.getChildAt(2), 2);
        getConditionTagAt(r3).rb.setChecked(true);
        return;
    L5:
        if (r6 <= 0) goto L7;
        r3 = 1;
        goto L8
    L7:
        r3 = 2;
        goto L8
    }

    private void bindTag(int r3, View r4, int r5) {
        if (r4.getTag() == null) goto L5;
        final ConditionTag r0 = (ConditionTag) r4.getTag();
    L6:
        r4.setTag(r0);
        if (r0.rb != null) goto L9;
        r0.rb = (RadioButton) this.mZenRadioGroup.getChildAt(r5);
    L9:
        if (r3 > 0) goto L11;
        r0.countdownZenDuration = MINUTE_BUCKETS[DEFAULT_BUCKET_INDEX];
    L12:
        r0.rb.setOnCheckedChangeListener(new AnonymousClass2(this, r0));
        updateUi(r0, r4, r5);
        return;
    L11:
        r0.countdownZenDuration = r3;
        goto L12
    L5:
        r0 = new ConditionTag();
        goto L6
    }

    protected ConditionTag getConditionTagAt(int r1) {
        return (ConditionTag) this.mZenRadioGroupContent.getChildAt(r1).getTag();
    }

    private void setupUi(final ConditionTag r2, View r3) {
        if (r2.lines != null) goto L6;
        r2.lines = r3.findViewById(android.R.id.content);
    L6:
        if (r2.line1 != null) goto L8;
        r2.line1 = (TextView) r3.findViewById(android.R.id.text1);
    L8:
        r3.findViewById(android.R.id.text2).setVisibility(8);
        r2.lines.setOnClickListener(new AnonymousClass3(this, r2));
    }

    private void updateButtons(final ConditionTag r7, final View r8, final int r9) {
        ImageView r0 = (ImageView) r8.findViewById(android.R.id.button1);
        ImageView r1 = (ImageView) r8.findViewById(android.R.id.button2);
        long r2 = r7.countdownZenDuration;
        boolean r4 = true;
        if (r9 != 1) goto L21;
        r0.setOnClickListener(new AnonymousClass4(this, r8, r7, r9));
        r1.setOnClickListener(new AnonymousClass5(this, r8, r7, r9));
        r0.setVisibility(0);
        r1.setVisibility(0);
        if (r2 <= MIN_BUCKET_MINUTES) goto L7;
        boolean r10 = true;
    L8:
        r0.setEnabled(r10);
        if (r7.countdownZenDuration != MAX_BUCKET_MINUTES) goto L12;
        r4 = false;
    L12:
        r1.setEnabled(r4);
        float r11 = 1.0f;
        if (r0.isEnabled() == false) goto L15;
        float r6 = 1.0f;
    L16:
        r0.setAlpha(r6);
        if (r1.isEnabled() == true) goto L20;
        r11 = 0.5f;
    L20:
        r1.setAlpha(r11);
        return;
    L15:
        r6 = 0.5f;
        goto L16
    L7:
        r10 = false;
        goto L8
    L21:
        if (r0 == null) goto L23;
        ((ViewGroup) r8).removeView(r0);
    L23:
        if (r1 == null) goto L27;
        ((ViewGroup) r8).removeView(r1);
        return;
    }

    protected void updateUi(ConditionTag r2, View r3, int r4) {
        if (r2.lines != null) goto L5;
        setupUi(r2, r3);
    L5:
        updateButtons(r2, r3, r4);
        if (r4 != 0) goto L8;
        String r1 = this.mContext.getString(R.string.zen_mode_forever);
    L15:
        r2.line1.setText(r1);
        return;
    L8:
        if (r4 != 1) goto L10;
        r1 = ZenModeConfig.toTimeCondition(this.mContext, r2.countdownZenDuration, ActivityManager.getCurrentUser(), false).line1;
        goto L15
    L10:
        if (r4 == 2) goto L12;
        r1 = "";
        goto L15
    L12:
        r1 = this.mContext.getString(R.string.zen_mode_duration_always_prompt_title);
        goto L15
    }

    protected void onClickTimeButton(View r11, ConditionTag r12, boolean r13, int r14) {
        int[] r0 = MINUTE_BUCKETS;
        int r1 = r0.length;
        int r2 = this.mBucketIndex;
        int r3 = 0;
        int r5 = -1;
        if (r2 != (-1)) goto L21;
        long r6 = r12.countdownZenDuration;
    L5:
        if (r3 >= r1) goto L18;
        if (r13 == false) goto L8;
        int r4 = r3;
    L9:
        int r7 = MINUTE_BUCKETS[r4];
        if (r13 == true) goto L12;
    L13:
        if (r13 == true) goto L17;
        if (r7 >= r6) goto L17;
    L16:
        this.mBucketIndex = r4;
    L19:
        if (r7 != (-1)) goto L25;
        int r15 = DEFAULT_BUCKET_INDEX;
        this.mBucketIndex = r15;
        r7 = MINUTE_BUCKETS[r15];
    L25:
        r12.countdownZenDuration = r7;
        bindTag(r7, r11, r14);
        r12.rb.setChecked(true);
        return;
    L17:
        r3 = r3 + 1;
        goto L5
    L12:
        if (r7 > r6) goto L16;
    L8:
        r4 = (r1 - 1) - r3;
        goto L9
    L18:
        r7 = -1;
        goto L19
    L21:
        int r8 = r1 - 1;
        if (r13 == false) goto L24;
        r5 = 1;
    L24:
        int r16 = Math.max(0, Math.min(r8, r2 + r5));
        this.mBucketIndex = r16;
        r7 = r0[r16];
        goto L25
    }
}
