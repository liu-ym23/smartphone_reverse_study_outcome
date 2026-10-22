package com.android.settings.fingerprint;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.UserManager;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.view.View;
import com.android.settings.ChooseLockGeneric;
import com.android.settings.ChooseLockSettingsHelper;
import com.android.settings.R;
import com.android.settingslib.HelpUtils;
import com.android.setupwizardlib.SetupWizardRecyclerLayout;
import com.android.setupwizardlib.items.IItem;
import com.android.setupwizardlib.items.Item;
import com.android.setupwizardlib.items.RecyclerItemAdapter;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class FingerprintEnrollIntroduction extends FingerprintEnrollBase implements RecyclerItemAdapter.OnItemSelectedListener {
    protected static final int CHOOSE_LOCK_GENERIC_REQUEST = 1;
    protected static final int FINGERPRINT_FIND_SENSOR_REQUEST = 2;
    protected static final int LEARN_MORE_REQUEST = 3;
    private boolean mHasPassword;
    private UserManager mUserManager;

    private static class LearnMoreSpan extends URLSpan {
        private static final String TAG = "LearnMoreSpan";
        private static final Typeface TYPEFACE_MEDIUM = null;

        static {
            TYPEFACE_MEDIUM = Typeface.create("sans-serif-medium", 0);
        }

        private LearnMoreSpan(String r1) {
            super(r1);
        }

        @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
        public void onClick(View r3) {
            Context r0 = r3.getContext();
            Intent r2 = HelpUtils.getHelpIntent(r0, getURL(), r0.getClass().getName());
            if (r2 != null) goto L10;
            return;
        L10:
            r3.startActivityForResult(r2, 3);     // Catch: ActivityNotFoundException -> L8
            return;
        L8:
            OLog.w(TAG, "Actvity was not found for intent, " + r2.toString());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r1) {
            super.updateDrawState(r1);
            r1.setUnderlineText(false);
            r1.setTypeface(TYPEFACE_MEDIUM);
        }

        public static CharSequence linkify(CharSequence r8, String r9) {
            SpannableString r0 = new SpannableString(r8);
            int r3 = 0;
            Annotation[] r1 = (Annotation[]) r0.getSpans(0, r0.length(), Annotation.class);
            if (TextUtils.isEmpty(r9) == false) goto L8;
            int r10 = r1.length;
            int r2 = 0;
        L5:
            if (r2 >= r10) goto L7;
            Annotation r4 = r1[r2];
            r8 = TextUtils.concat(new CharSequence[]{r8.subSequence(0, r0.getSpanStart(r4)), r0.subSequence(r0.getSpanEnd(r4), r0.length())});
            r2 = r2 + 1;
            goto L5
        L7:
            return r8;
        L8:
            SpannableStringBuilder r11 = new SpannableStringBuilder(r0);
            int r5 = r1.length;
        L9:
            if (r3 >= r5) goto L11;
            Annotation r6 = r1[r3];
            int r7 = r0.getSpanStart(r6);
            int r12 = r0.getSpanEnd(r6);
            LearnMoreSpan r13 = new LearnMoreSpan(r9);
            r11.setSpan(r13, r7, r12, r0.getSpanFlags(r13));
            r3 = r3 + 1;
            goto L9
        L11:
            return r11;
        }
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        com_android_settings_fingerprint_FingerprintEnrollIntroduction_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(this, r1);
    }

    public FingerprintEnrollIntroduction() {
    }

    public void com_android_settings_fingerprint_FingerprintEnrollIntroduction__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.fingerprint_enroll_introduction);
        setHeaderText(R.string.security_settings_fingerprint_enroll_introduction_title);
        SetupWizardRecyclerLayout r5 = (SetupWizardRecyclerLayout) findViewById(R.id.setup_wizard_layout);
        this.mUserManager = UserManager.get(this);
        RecyclerItemAdapter r0 = (RecyclerItemAdapter) r5.getAdapter();
        r0.setOnItemSelectedListener(this);
        ((Item) r0.findItemById(R.id.fingerprint_introduction_message)).setTitle(LearnMoreSpan.linkify(getText(R.string.security_settings_fingerprint_enroll_introduction_message), getString(R.string.help_url_fingerprint)));
        r5.setDividerInset(0);
        updatePasswordQuality();
    }

    private void updatePasswordQuality() {
        if (new ChooseLockSettingsHelper(this).utils().getActivePasswordQuality(this.mUserManager.getCredentialOwnerProfile(this.mUserId)) == 0) goto L5;
        boolean r0 = true;
    L6:
        this.mHasPassword = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.settings.fingerprint.FingerprintEnrollBase
    protected void onNextButtonClick() {
        if (this.mHasPassword == true) goto L5;
        launchChooseLock();
        return;
    L5:
        launchFindSensor(null);
    }

    private void launchChooseLock() {
        Intent r0 = getChooseLockIntent();
        OLog.i("FingerprintEnrollIntroduction", "launchChooseLock challenge 0");
        r0.putExtra("minimum_quality", 65536);
        r0.putExtra(ChooseLockGeneric.ChooseLockGenericFragment.HIDE_DISABLED_PREFS, true);
        r0.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r0.putExtra("challenge", 0);
        r0.putExtra("for_fingerprint", true);
        if (this.mUserId == (-10000)) goto L5;
        r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
    L5:
        startActivityForResult(r0, 1);
    }

    private void launchFindSensor(byte[] r3) {
        Intent r0 = getFindSensorIntent();
        if (r3 == null) goto L6;
        r0.putExtra("hw_auth_token", r3);
    L6:
        if (this.mUserId == (-10000)) goto L8;
        r0.putExtra("android.intent.extra.USER_ID", this.mUserId);
    L8:
        startActivityForResult(r0, 2);
    }

    protected Intent getChooseLockIntent() {
        return new Intent(this, ChooseLockGeneric.class);
    }

    protected Intent getFindSensorIntent() {
        return new Intent(this, FingerprintEnrollFindSensor.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r4, int r5, Intent r6) {
        if (r5 != 1) goto L5;
        boolean r1 = true;
    L6:
        int r2 = 2;
        if (r4 != 2) goto L14;
        if (r1 == true) goto L10;
        if (r5 == 2) goto L10;
    L18:
        super.onActivityResult(r4, r5, r6);
        return;
    L10:
        if (r1 == false) goto L12;
        r2 = -1;
    L12:
        setResult(r2, r6);
        finish();
        return;
    L14:
        if (r4 != 1) goto L18;
        if (r1 == false) goto L18;
        updatePasswordQuality();
        launchFindSensor(r6.getByteArrayExtra("hw_auth_token"));
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.android.setupwizardlib.items.RecyclerItemAdapter.OnItemSelectedListener
    public void onItemSelected(IItem r2) {
        int r3 = ((Item) r2).getId();
        if (r3 != R.id.cancel_button) goto L5;
        onCancelButtonClick();
        return;
    L5:
        if (r3 != R.id.next_button) goto L11;
        onNextButtonClick();
        return;
    }

    protected void onCancelButtonClick() {
        finish();
    }

    @Insert("onCreate")
    public static void com_android_settings_fingerprint_FingerprintEnrollIntroduction_com_obric_hook_lancet_PrivacyHookActivity2_onCreate(FingerprintEnrollIntroduction r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity2");
        FingerprintEnrollIntroduction r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_fingerprint_FingerprintEnrollIntroduction__onCreate$___twin___(r4);
    }
}
