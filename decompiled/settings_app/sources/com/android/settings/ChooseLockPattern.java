package com.android.settings;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.UserManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.PreferenceFragmentCompat;
import bytedanceos.api.TextViewSmt;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockPatternView;
import com.android.internal.widget.LockscreenCredential;
import com.android.settings.base.BaseActivity;
import com.android.settings.biometrics.BiometricsUtils;
import com.android.settings.fingerprint.BaseFingerprintEnrollingActivity;
import com.android.settings.fingerprint.FingerprintManageFragment;
import com.android.settings.provision.NextPageRouting.RoutingUtils;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.ThreadUtils;
import com.android.settings.utils.UIUtils;
import com.android.settings.widget.lockpatternview.KeyguardLockPatternView;
import com.android.settings.wifi.TrustedNetworkHelper;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.google.android.collect.Lists;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.util.VibratorHelper;
import obric.util.WindowUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ChooseLockPattern extends BaseActivity {
    static final int RESULT_FINISHED = 1;
    private static final String TAG = "ChooseLockPattern";

    /* JADX INFO: renamed from: com.android.settings.ChooseLockPattern$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage = null;

        static {
            int[] r0 = new int[ChooseLockPatternFragment.Stage.values().length];
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage = r0;
            r0[ChooseLockPatternFragment.Stage.Introduction.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[ChooseLockPatternFragment.Stage.HelpScreen.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[ChooseLockPatternFragment.Stage.ChoiceTooShort.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[ChooseLockPatternFragment.Stage.NeedToConfirm.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[ChooseLockPatternFragment.Stage.ConfirmWrong.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            $SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[ChooseLockPatternFragment.Stage.ChoiceConfirmed.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static class ChooseLockPatternFragment extends PreferenceFragmentCompat implements View.OnClickListener {
        public static final int CONFIRM_EXISTING_REQUEST = 55;
        private static final int ID_EMPTY_MESSAGE = -1;
        static final int INFORMATION_MSG_TIMEOUT_MS = 3000;
        private static final String KEY_CURRENT_PATTERN = "currentPattern";
        private static final String KEY_PATTERN_CHOICE = "chosenPattern";
        private static final String KEY_UI_STAGE = "uiStage";
        private static final int WRONG_PATTERN_CLEAR_TIMEOUT_MS = 2000;
        private boolean fromProvision;
        private boolean isInsideSettings;
        private final List<LockPatternView.Cell> mAnimatePattern;
        private View mBackView;
        private long mChallenge;
        private ChooseLockSettingsHelper mChooseLockSettingsHelper;
        protected KeyguardLockPatternView.OnPatternListener mChooseNewLockPatternListener;
        protected LockscreenCredential mChosenPattern;
        private final Runnable mClearPatternRunnable;
        private LockscreenCredential mCurrentCredential;
        private boolean mDone;
        private int mFingerType;
        protected TextView mFooterText;
        private boolean mForFingerprint;
        private boolean mHasChallenge;
        protected TextView mHeaderText;
        private ObjectAnimator mHeaderTextShakeAnim;
        private boolean mHideDrawer;
        private boolean mIsManagedProfile;
        protected KeyguardLockPatternView mLockPatternView;
        private OButton mOkView;
        private boolean mOnConfigurationChanging;
        private AsyncTask<?, ?, ?> mPendingLockCheck;
        private View mRightButton;
        private Stage mUiStage;
        private int mUserId;
        private UserManager mUserManager;
        private boolean requestResult;
        private OFloatingTitleBar title;

        static final enum LeftButtonMode extends Enum<LeftButtonMode> {
            private static final /* synthetic */ LeftButtonMode[] $VALUES = null;
            public static final LeftButtonMode Cancel = null;
            public static final LeftButtonMode CancelDisabled = null;
            public static final LeftButtonMode Gone = null;
            public static final LeftButtonMode Retry = null;
            public static final LeftButtonMode RetryDisabled = null;
            final boolean enabled;
            final int text;

            private static /* synthetic */ LeftButtonMode[] $values() {
                return new LeftButtonMode[]{Cancel, CancelDisabled, Retry, RetryDisabled, Gone};
            }

            public static LeftButtonMode valueOf(String r1) {
                return (LeftButtonMode) Enum.valueOf(LeftButtonMode.class, r1);
            }

            public static LeftButtonMode[] values() {
                return (LeftButtonMode[]) $VALUES.clone();
            }

            static {
                Cancel = new LeftButtonMode("Cancel", 0, R.string.cancel, true);
                CancelDisabled = new LeftButtonMode("CancelDisabled", 1, R.string.cancel, false);
                Retry = new LeftButtonMode("Retry", 2, R.string.lockpattern_retry_button_text, true);
                RetryDisabled = new LeftButtonMode("RetryDisabled", 3, R.string.lockpattern_retry_button_text, false);
                Gone = new LeftButtonMode("Gone", 4, -1, false);
                $VALUES = $values();
            }

            private LeftButtonMode(String r1, int r2, int r3, boolean r4) {
                super(r1, r2);
                this.text = r3;
                this.enabled = r4;
            }
        }

        static final enum RightButtonMode extends Enum<RightButtonMode> {
            private static final /* synthetic */ RightButtonMode[] $VALUES = null;
            public static final RightButtonMode Confirm = null;
            public static final RightButtonMode ConfirmDisabled = null;
            public static final RightButtonMode ContinueDisabled = null;
            public static final RightButtonMode Ok = null;
            public static final RightButtonMode Redraw = null;
            final boolean enabled;
            final int text;

            private static /* synthetic */ RightButtonMode[] $values() {
                return new RightButtonMode[]{ContinueDisabled, Confirm, ConfirmDisabled, Redraw, Ok};
            }

            public static RightButtonMode valueOf(String r1) {
                return (RightButtonMode) Enum.valueOf(RightButtonMode.class, r1);
            }

            public static RightButtonMode[] values() {
                return (RightButtonMode[]) $VALUES.clone();
            }

            static {
                ContinueDisabled = new RightButtonMode("ContinueDisabled", 0, R.string.lockpattern_continue_button_text, false);
                Confirm = new RightButtonMode("Confirm", 1, R.string.lockpattern_confirm_button_text, true);
                ConfirmDisabled = new RightButtonMode("ConfirmDisabled", 2, R.string.lockpattern_confirm_button_text, false);
                Redraw = new RightButtonMode("Redraw", 3, R.string.lockpattern_redraw_button_text, true);
                Ok = new RightButtonMode("Ok", 4, android.R.string.ok, true);
                $VALUES = $values();
            }

            private RightButtonMode(String r1, int r2, int r3, boolean r4) {
                super(r1, r2);
                this.text = r3;
                this.enabled = r4;
            }
        }

        protected static final enum Stage extends Enum<Stage> {
            private static final /* synthetic */ Stage[] $VALUES = null;
            public static final Stage ChoiceConfirmed = null;
            public static final Stage ChoiceTooShort = null;
            public static final Stage ConfirmWrong = null;
            public static final Stage HelpScreen = null;
            public static final Stage Introduction = null;
            public static final Stage NeedToConfirm = null;
            final int footerMessage;
            final int headerMessage;
            final LeftButtonMode leftMode;
            final boolean patternEnabled;
            final RightButtonMode rightMode;

            private static /* synthetic */ Stage[] $values() {
                return new Stage[]{Introduction, HelpScreen, ChoiceTooShort, NeedToConfirm, ConfirmWrong, ChoiceConfirmed};
            }

            public static Stage valueOf(String r1) {
                return (Stage) Enum.valueOf(Stage.class, r1);
            }

            public static Stage[] values() {
                return (Stage[]) $VALUES.clone();
            }

            static {
                Introduction = new Stage("Introduction", 0, R.string.lockpattern_recording_intro_header, LeftButtonMode.Cancel, RightButtonMode.ContinueDisabled, -1, true);
                HelpScreen = new Stage("HelpScreen", 1, R.string.lockpattern_settings_help_how_to_record, LeftButtonMode.Gone, RightButtonMode.Ok, -1, false);
                ChoiceTooShort = new Stage("ChoiceTooShort", 2, R.string.lockpattern_recording_incorrect_too_short, LeftButtonMode.Retry, RightButtonMode.ContinueDisabled, -1, true);
                NeedToConfirm = new Stage("NeedToConfirm", 3, R.string.confirm_draw_pattern, LeftButtonMode.Cancel, RightButtonMode.ConfirmDisabled, -1, true);
                ConfirmWrong = new Stage("ConfirmWrong", 4, R.string.pattern_mismatch, LeftButtonMode.Cancel, RightButtonMode.Redraw, -1, true);
                ChoiceConfirmed = new Stage("ChoiceConfirmed", 5, R.string.lockpattern_pattern_confirmed_header, LeftButtonMode.Cancel, RightButtonMode.Confirm, -1, false);
                $VALUES = $values();
            }

            private Stage(String r1, int r2, int r3, LeftButtonMode r4, RightButtonMode r5, int r6, boolean r7) {
                super(r1, r2);
                this.headerMessage = r3;
                this.leftMode = r4;
                this.rightMode = r5;
                this.footerMessage = r6;
                this.patternEnabled = r7;
            }
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onCreate(Bundle r1) {
            com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
        }

        @Override // androidx.preference.PreferenceFragmentCompat
        public void onCreatePreferences(Bundle r1, String r2) {
        }

        @Override // androidx.fragment.app.Fragment
        public void onResume() {
            com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
        }

        public ChooseLockPatternFragment() {
            this.mChosenPattern = null;
            this.requestResult = false;
            this.mForFingerprint = false;
            this.mHideDrawer = false;
            this.mOnConfigurationChanging = false;
            this.mAnimatePattern = Collections.unmodifiableList(Lists.newArrayList(new LockPatternView.Cell[]{LockPatternView.Cell.of(0, 0), LockPatternView.Cell.of(0, 1), LockPatternView.Cell.of(1, 1), LockPatternView.Cell.of(2, 1)}));
            this.mChooseNewLockPatternListener = new AnonymousClass1(this);
            this.mUiStage = Stage.Introduction;
            this.mDone = false;
            this.mClearPatternRunnable = new AnonymousClass2(this);
            this.isInsideSettings = false;
            this.mFingerType = -1;
        }

        static /* synthetic */ Runnable access$000(ChooseLockPatternFragment r0) {
            return r0.mClearPatternRunnable;
        }

        static /* synthetic */ Stage access$100(ChooseLockPatternFragment r0) {
            return r0.mUiStage;
        }

        static /* synthetic */ boolean access$1000(ChooseLockPatternFragment r0) {
            return r0.fromProvision;
        }

        static /* synthetic */ void access$1100(ChooseLockPatternFragment r0) {
            r0.doFinish();
        }

        static /* synthetic */ ObjectAnimator access$1202(ChooseLockPatternFragment r0, ObjectAnimator r1) {
            r0.mHeaderTextShakeAnim = r1;
            return r1;
        }

        static /* synthetic */ void access$200(ChooseLockPatternFragment r0, int r1) {
            r0.setupHeaderTextColor(r1);
        }

        static /* synthetic */ View access$300(ChooseLockPatternFragment r0) {
            return r0.mBackView;
        }

        static /* synthetic */ View access$400(ChooseLockPatternFragment r0) {
            return r0.mRightButton;
        }

        static /* synthetic */ OButton access$500(ChooseLockPatternFragment r0) {
            return r0.mOkView;
        }

        static /* synthetic */ int access$600(ChooseLockPatternFragment r0) {
            return r0.mUserId;
        }

        static /* synthetic */ void access$700(ChooseLockPatternFragment r0, LockscreenCredential r1) {
            r0.handleEnrolling(r1);
        }

        static /* synthetic */ boolean access$800(ChooseLockPatternFragment r0) {
            return r0.isInsideSettings;
        }

        static /* synthetic */ int access$900(ChooseLockPatternFragment r0) {
            return r0.mFingerType;
        }

        @Override // androidx.fragment.app.Fragment
        public void onActivityResult(int r2, int r3, Intent r4) {
            super.onActivityResult(r2, r3, r4);
            if (r2 == 55) goto L6;
            return;
        L6:
            if (r3 == (-1)) goto L8;
            getActivity().setResult(1, Utils.getPasswordIntent(this.mChosenPattern, this.isInsideSettings));
            getActivity().finish();
        L9:
            updateStage(Stage.Introduction);
            return;
        L8:
            this.mCurrentCredential = r4.getParcelableExtra("password");
            goto L9
        }

        public void com_android_settings_ChooseLockPattern$ChooseLockPatternFragment__onCreate$___twin___(Bundle r4) {
            super.onCreate(r4);
            this.mChooseLockSettingsHelper = new ChooseLockSettingsHelper(getActivity());
            if ((getActivity() instanceof ChooseLockPattern) == false) goto L7;
            Intent r5 = getActivity().getIntent();
            this.mUserManager = UserManager.get(getActivity());
            int r6 = Utils.getUserIdFromBundle(getActivity(), r5.getExtras());
            this.mUserId = r6;
            this.mIsManagedProfile = this.mUserManager.isManagedProfile(r6);
            this.mForFingerprint = getActivity().getIntent().getBooleanExtra("for_fingerprint", false);
            this.mFingerType = getActivity().getIntent().getIntExtra(FingerprintManageFragment.FINGER_TYPE, -1);
            this.requestResult = getActivity().getIntent().getBooleanExtra(TrustedNetworkHelper.EXTRA_REQUEST_RESULT, false);
            this.fromProvision = getActivity().getIntent().getBooleanExtra(BaseFingerprintEnrollingActivity.EXTRA_FROM_PROVISION, false);
            this.isInsideSettings = Utils.isInsidePackage(getActivity());
            OLog.d(ChooseLockPattern.TAG, "userId:" + this.mUserId + " ManagedProfile:" + this.mIsManagedProfile);
            return;
        L7:
            throw new SecurityException("Fragment contained in wrong activity");
        }

        @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r1) {
            super.onConfigurationChanged(r1);
            this.mOnConfigurationChanging = true;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public View onCreateView(LayoutInflater r6, ViewGroup r7, Bundle r8) {
            View r9 = r6.inflate(R.layout.choose_lock_pattern, null);
            ((FrameLayout) r9.findViewById(R.id.lockPatternFL)).addView(UIUtils.buildNoScaledView(getActivity(), R.layout.view_lockpattern_input));
            this.mHeaderText = (TextView) r9.findViewById(R.id.headerText);
            if (Utils.isEnglishLocale() == false) goto L5;
            TextViewSmt.getInstance().setMaxTextSize(this.mHeaderText, getActivity().getResources().getDimensionPixelSize(R.dimen.setting_item_text_size_of_one_point_two_factor));
        L5:
            setupHeaderTextColor(R.color.oui_text_3);
            KeyguardLockPatternView r10 = (KeyguardLockPatternView) r9.findViewById(R.id.lockPattern);
            this.mLockPatternView = r10;
            r10.setOnPatternListener(this.mChooseNewLockPatternListener);
            this.mFooterText = (TextView) r9.findViewById(R.id.footerText);
            OFloatingTitleBar r11 = (OFloatingTitleBar) r9.findViewById(R.id.view_title);
            this.title = r11;
            r11.setEndButtonGroupStyle(2132018095);
            this.mRightButton = this.title.addEndAction(getString(R.string.lockpassword_continue_label), -1, null);
            this.title.removeStartAction();
            View r12 = this.title.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, null);
            this.mBackView = r12;
            r12.setOnClickListener(this);
            this.mRightButton.setOnClickListener(this);
            r9.findViewById(R.id.topLayout).setDefaultTouchRecepient(this.mLockPatternView);
            boolean r13 = getActivity().getIntent().getBooleanExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, true);
            Intent r0 = getActivity().getIntent();
            if (r0.hasExtra("password") == false) goto L8;
            this.mCurrentCredential = r0.getParcelableExtra("password");
        L9:
            this.mHasChallenge = r0.getBooleanExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, false);
            this.mChallenge = r0.getLongExtra("challenge", 0);
            if (r8 != null) goto L16;
            if (r13 == false) goto L15;
            updateStage(Stage.NeedToConfirm);
            if (this.mChooseLockSettingsHelper.launchConfirmationActivity(55, getString(R.string.unlock_set_unlock_launch_picker_title), 0) == true) goto L17;
            updateStage(Stage.Introduction);
        L17:
            this.mDone = false;
            return r9;
        L15:
            updateStage(Stage.Introduction);
            goto L17
        L16:
            this.mChosenPattern = r8.getParcelable(KEY_PATTERN_CHOICE);
            this.mCurrentCredential = r8.getParcelable(KEY_CURRENT_PATTERN);
            updateStage(Stage.values()[r8.getInt(KEY_UI_STAGE)]);
            goto L17
        L8:
            OLog.e(ChooseLockPattern.TAG, "don't have EXTRA_KEY_PASSWORD");
            goto L9
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onViewCreated(View r3, Bundle r4) {
            UIUtils.fitMaskTitleInCommon((ViewGroup) r3, r3.findViewById(R.id.title));
            super.onViewCreated(r3, r4);
        }

        public void com_android_settings_ChooseLockPattern$ChooseLockPatternFragment__onResume$___twin___() {
            super.onResume();
            if (this.mUiStage != Stage.ChoiceConfirmed) goto L5;
            this.mLockPatternView.disableInput();
            return;
        L5:
            this.mLockPatternView.enableInput();
        }

        @Override // androidx.fragment.app.Fragment
        public void onPause() {
            super.onPause();
            AsyncTask<?, ?, ?> r0 = this.mPendingLockCheck;
            if (r0 == null) goto L6;
            r0.cancel(false);
            this.mPendingLockCheck = null;
            return;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onStop() {
            super.onStop();
            if (this.mOnConfigurationChanging == true) goto L6;
            Utils.finishActivityDelay(getActivity());
            return;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            if (r3 != this.mBackView) goto L16;
            if (this.mUiStage.leftMode != LeftButtonMode.Retry) goto L11;
            LockscreenCredential r4 = this.mChosenPattern;
            if (r4 == null) goto L9;
            r4.zeroize();
            this.mChosenPattern = null;
        L9:
            this.mLockPatternView.clearPattern();
            updateStage(Stage.Introduction);
            return;
        L11:
            if (this.mUiStage.leftMode != LeftButtonMode.Cancel) goto L14;
            getActivity().setResult(0);
            getActivity().finish();
            return;
        L14:
            throw new IllegalStateException("left footer button pressed, but stage of " + this.mUiStage + " doesn't make sense");
        L16:
            if (r3 != this.mRightButton) goto L18;
        L19:
            patternDone();
            return;
        L18:
            if (r3 == this.mOkView) goto L19;
        }

        private void patternDone() {
            VibratorHelper.INSTANCE.confirm(getActivity());
            if (this.mUiStage.rightMode != RightButtonMode.Confirm) goto L10;
            if (this.mUiStage != Stage.ChoiceConfirmed) goto L8;
            ThreadUtils.postOnBackgroundThread(new ChooseLockPattern$ChooseLockPatternFragment$$ExternalSyntheticLambda2(this));
            return;
        L8:
            throw new IllegalStateException("expected ui stage " + Stage.ChoiceConfirmed + " when button is " + RightButtonMode.Confirm);
        L10:
            if (this.mUiStage.rightMode != RightButtonMode.Ok) goto L17;
            if (this.mUiStage != Stage.HelpScreen) goto L15;
            this.mLockPatternView.clearPattern();
            this.mLockPatternView.setDisplayMode(KeyguardLockPatternView.DisplayMode.Correct);
            updateStage(Stage.Introduction);
            return;
        L15:
            throw new IllegalStateException("Help screen is only mode with ok button, but stage is " + this.mUiStage);
        L17:
            if (this.mUiStage.rightMode != RightButtonMode.Redraw) goto L25;
            LockscreenCredential r0 = this.mChosenPattern;
            if (r0 == null) goto L21;
            r0.zeroize();
            this.mChosenPattern = null;
        L21:
            this.mLockPatternView.clearPattern();
            updateStage(Stage.Introduction);
            return;
        }

        /* JADX INFO: renamed from: lambda$patternDone$0$com-android-settings-ChooseLockPattern$ChooseLockPatternFragment, reason: not valid java name */
        /* synthetic */ void m111x5ddd738b() {
            saveChosenPatternAndFinish();
        }

        public boolean onKeyDown(int r3, KeyEvent r4) {
            if (r3 != 4) goto L11;
            if (r4.getRepeatCount() != 0) goto L11;
            if (this.mUiStage != Stage.HelpScreen) goto L11;
            updateStage(Stage.Introduction);
            return true;
        L11:
            if (r3 == 82) goto L13;
            return false;
        L13:
            if (this.mUiStage != Stage.Introduction) goto L18;
            updateStage(Stage.HelpScreen);
            return true;
        L18:
            return false;
        }

        @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
        public void onSaveInstanceState(Bundle r3) {
            super.onSaveInstanceState(r3);
            r3.putInt(KEY_UI_STAGE, this.mUiStage.ordinal());
            LockscreenCredential r0 = this.mChosenPattern;
            if (r0 == null) goto L5;
            r3.putParcelable(KEY_PATTERN_CHOICE, r0);
        L5:
            LockscreenCredential r2 = this.mCurrentCredential;
            if (r2 == null) goto L9;
            r3.putParcelable(KEY_CURRENT_PATTERN, r2.duplicate());
            return;
        }

        private void setupHeaderTextColor(int r2) {
            this.mHeaderText.setTextColor(getResources().getColor(r2));
        }

        protected void updateStage(Stage r10) {
            Stage r0 = this.mUiStage;
            this.mUiStage = r10;
            if (r10 != Stage.ConfirmWrong) goto L5;
        L8:
            setupHeaderTextColor(R.color.lock_screen_header_warning_text_color);
            VibratorHelper.INSTANCE.reject(getActivity());
            playHeaderTextViewAnim();
        L9:
            boolean r3 = false;
            if (r10 != Stage.ChoiceTooShort) goto L12;
            this.mHeaderText.setText(getResources().getString(r10.headerMessage, new Object[]{4}));
        L14:
            if (r10.footerMessage != (-1)) goto L16;
            this.mFooterText.setText("");
        L18:
            if (r10.leftMode != LeftButtonMode.Gone) goto L20;
            this.mBackView.setVisibility(8);
        L21:
            this.title.removeEndAction();
            if (r10.rightMode.enabled == false) goto L25;
            patternDone();
        L25:
            if (r10.patternEnabled == false) goto L27;
            this.mLockPatternView.enableInput();
        L28:
            this.mLockPatternView.setDisplayMode(KeyguardLockPatternView.DisplayMode.Correct);
            int r1 = AnonymousClass1.$SwitchMap$com$android$settings$ChooseLockPattern$ChooseLockPatternFragment$Stage[this.mUiStage.ordinal()];
            if (r1 != 1) goto L31;
            this.mLockPatternView.clearPattern();
        L44:
            if (r0 != r10) goto L46;
            if (r3 == true) goto L46;
            return;
        L46:
            TextView r9 = this.mHeaderText;
            r9.announceForAccessibility(r9.getText());
            return;
        L31:
            if (r1 != 2) goto L33;
            this.mLockPatternView.setPattern(KeyguardLockPatternView.DisplayMode.Animate, this.mAnimatePattern);
            goto L44
        L33:
            if (r1 == 3) goto L40;
            if (r1 != 4) goto L36;
            this.mLockPatternView.clearPattern();
            VibratorHelper.INSTANCE.confirm(getActivity());
            goto L44
        L36:
            if (r1 != 5) goto L44;
            this.mLockPatternView.setDisplayMode(KeyguardLockPatternView.DisplayMode.Wrong);
            postClearPatternRunnable();
        L41:
            r3 = true;
            goto L44
        L40:
            this.mLockPatternView.setDisplayMode(KeyguardLockPatternView.DisplayMode.Wrong);
            postClearPatternRunnable();
            goto L41
        L27:
            this.mLockPatternView.disableInput();
            goto L28
        L20:
            this.mBackView.setVisibility(0);
            this.mBackView.setEnabled(r10.leftMode.enabled);
            goto L21
        L16:
            this.mFooterText.setText(r10.footerMessage);
            goto L18
        L12:
            this.mHeaderText.setText(r10.headerMessage);
            goto L14
        L5:
            if (r10 == Stage.ChoiceTooShort) goto L8;
            setupHeaderTextColor(R.color.oui_text_3);
            goto L9
        }

        private void postClearPatternRunnable() {
            this.mLockPatternView.removeCallbacks(this.mClearPatternRunnable);
            this.mLockPatternView.postDelayed(this.mClearPatternRunnable, 2000);
        }

        /* JADX WARN: Type inference failed for: r0v10, types: [com.android.settings.ChooseLockPattern$ChooseLockPatternFragment$3] */
        private void saveChosenPatternAndFinish() {
            if (this.mDone == false) goto L5;
            return;
        L5:
            final LockPatternUtils r2 = this.mChooseLockSettingsHelper.utils();
        L26:
            th = move-exception;
            OLog.e(ChooseLockPattern.TAG, "Failed to set lockscreen credential err:", th);
            AppMetricsUtils.INSTANCE.reportSetLockCredentialError("pattern", th);
            ThreadUtils.postOnMainThread(new ChooseLockPattern$ChooseLockPatternFragment$$ExternalSyntheticLambda1(this));
            getActivity().setResult(0);
            doFinish();
            return;
        L7:
            if (this.mCurrentCredential != null) goto L10;
            this.mCurrentCredential = LockscreenCredential.createNone();     // Catch: Throwable -> L26
        L10:
            if (r2.setLockCredential(this.mChosenPattern, this.mCurrentCredential, this.mUserId) == true) goto L14;
            OLog.e(ChooseLockPattern.TAG, "Failed to set lockscreen credential");     // Catch: Throwable -> L26
            AppMetricsUtils.INSTANCE.reportSetLockCredentialError("pattern", null);     // Catch: Throwable -> L26
            ThreadUtils.postOnMainThread(new ChooseLockPattern$ChooseLockPatternFragment$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L26
            getActivity().setResult(0);     // Catch: Throwable -> L26
            doFinish();     // Catch: Throwable -> L26
            return;
        L14:
            if (this.mHasChallenge == false) goto L18;
            new Intent();
            new AnonymousClass3(this, r2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        L18:
            if (this.requestResult == false) goto L21;
            getActivity().setResult(-1, Utils.getPasswordIntent(this.mChosenPattern, this.isInsideSettings));
        L21:
            if (finishSetupWizard() == false) goto L24;
            OLog.e(ChooseLockPattern.TAG, "finishSetupWizard: true");
            return;
        L24:
            OLog.i(ChooseLockPattern.TAG, "saveChosenPatternAndFinish: handleEnrolling");
            handleEnrolling(this.mChosenPattern);
            doFinish();
        }

        /* JADX INFO: renamed from: lambda$saveChosenPatternAndFinish$1$com-android-settings-ChooseLockPattern$ChooseLockPatternFragment, reason: not valid java name */
        /* synthetic */ void m112x3751b3d9() {
            ToastUtils.show(getActivity(), R.string.set_lock_credential_failed);
        }

        /* JADX INFO: renamed from: lambda$saveChosenPatternAndFinish$2$com-android-settings-ChooseLockPattern$ChooseLockPatternFragment, reason: not valid java name */
        /* synthetic */ void m113xa1813bf8() {
            ToastUtils.show(getActivity(), R.string.set_lock_credential_failed);
        }

        private void handleEnrolling(LockscreenCredential r4) {
            FragmentActivity r3 = getActivity();
            LockscreenCredential r5 = r4.duplicate();
            if (r5 != null) goto L5;
        L8:
            boolean r0 = true;
        L9:
            OLog.i(ChooseLockPattern.TAG, "handleEnrolling activity=" + r3 + ", pwdInvalid=" + r0);
            BiometricsUtils.INSTANCE.handleEnrolling(r3, r5);
            return;
        L5:
            if (r5.isNone() == true) goto L8;
            r0 = false;
            goto L9
        }

        private boolean finishSetupWizard() {
            BaseActivity r0 = (BaseActivity) getActivity();
            if (r0 != null) goto L5;
        L8:
            OLog.e(ChooseLockPattern.TAG, "finishSetupWizard return false");
            return false;
        L5:
            if (r0.mSetupWizardMode == false) goto L8;
            OLog.e(ChooseLockPattern.TAG, "finishSetupWizard, nextToAccount");
            RoutingUtils.nextToAccount(r0);
            r0.setResult(-1);
            r0.finish();
            this.mDone = true;
            return true;
        }

        private void doFinish() {
            LockscreenCredential r0 = this.mChosenPattern;
            if (r0 == null) goto L5;
            r0.zeroize();
        L5:
            LockscreenCredential r1 = this.mCurrentCredential;
            if (r1 == null) goto L8;
            r1.zeroize();
        L8:
            getActivity().finish();
            this.mDone = true;
        }

        private void playHeaderTextViewAnim() {
            ObjectAnimator r0 = this.mHeaderTextShakeAnim;
            if (r0 != null) goto L5;
        L7:
            ObjectAnimator r1 = Utils.createShakeAnim(this.mHeaderText, new AnonymousClass4(this));
            this.mHeaderTextShakeAnim = r1;
            r1.start();
            return;
        L5:
            if (r0.isRunning() == false) goto L7;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onCreate")
        public static void com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(ChooseLockPatternFragment r2, Bundle r3) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockPattern$ChooseLockPatternFragment__onCreate$___twin___(r3);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
            AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r4.callingPackageEvent("self", r0, true);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(ChooseLockPatternFragment r2) {
            String r0 = r2.getClass().getName();
            com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.recordVisibleTime(r0);
            return;
        }

        @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
        @Insert(mayCreateSuper = true, value = "onResume")
        public static void com_android_settings_ChooseLockPattern$ChooseLockPatternFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(ChooseLockPatternFragment r2) {
            String r0 = r2.getClass().getName();
            r2.com_android_settings_ChooseLockPattern$ChooseLockPatternFragment__onResume$___twin___();
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
            OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
            AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
            Intrinsics.checkNotNull(r0);
            r3.reportVisibleTime(r0, true);
            return;
        }
    }

    public void com_android_settings_ChooseLockPattern__onPause$___twin___() {
        super.onPause();
    }

    public void com_android_settings_ChooseLockPattern__onResume$___twin___() {
        super.onResume();
    }

    public void com_android_settings_ChooseLockPattern__onStop$___twin___() {
        super.onStop();
    }

    public void com_android_settings_ChooseLockPattern__startActivityForResult$___twin___(Intent r1, int r2, Bundle r3) {
        super.startActivityForResult(r1, r2, r3);
    }

    @Override // com.android.settings.base.BaseActivity, android.app.Activity
    public void finish() {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_finish(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r1) {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(this, r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_onResume(this);
    }

    @Override // com.android.settings.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_onStop(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void startActivityForResult(Intent r1, int r2, Bundle r3) {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(this, r1, r2, r3);
    }

    public ChooseLockPattern() {
    }

    public static Intent createIntent(Context r2, boolean r3, boolean r4, int r5) {
        Intent r0 = new Intent(r2, ChooseLockPattern.class);
        r0.putExtra("key_lock_method", "pattern");
        r0.putExtra(ChooseLockGeneric.CONFIRM_CREDENTIALS, r4);
        r0.putExtra(EncryptionInterstitial.EXTRA_REQUIRE_PASSWORD, r3);
        r0.putExtra("android.intent.extra.USER_ID", r5);
        return r0;
    }

    public static Intent createIntent(Context r1, boolean r2, LockscreenCredential r3, int r4) {
        Intent r5 = createIntent(r1, r2, false, r4);
        if (r3 != null) goto L5;
        OLog.i(TAG, "createIntent pattern is null");
    L5:
        r5.putExtra("password", r3);
        return r5;
    }

    public static Intent createIntent(Context r1, boolean r2, long r3, int r5) {
        Intent r4 = createIntent(r1, r2, false, r5);
        r4.putExtra(ChooseLockSettingsHelper.EXTRA_KEY_HAS_CHALLENGE, true);
        r4.putExtra("challenge", r3);
        return r4;
    }

    public void com_android_settings_ChooseLockPattern__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        setContentView(R.layout.choose_lock_pattern_activity);
        WindowUtils.Companion.addSecureFlag(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        recreate();
    }

    public void com_android_settings_ChooseLockPattern__finish$___twin___() {
        super.finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r1, KeyEvent r2) {
        return super.onKeyDown(r1, r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ChooseLockPattern_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(ChooseLockPattern r1) {
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onStop(r1);
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        r1.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    @Insert("onCreate")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onCreate(ChooseLockPattern r3, Bundle r4) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onCreateWhenPrivacyNotOk(null);
        r0.onSuperCreate(null);
        return;
    L6:
        GrantUtil.INSTANCE.applicationInit();
        r3.com_android_settings_ChooseLockPattern__onCreate$___twin___(r4);
    }

    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_onResume(ChooseLockPattern r1) {
        String r0 = r1.getClass().getName();
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(r1);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        AppMetricsUtils.INSTANCE.activityEventEnd(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_Activity(ChooseLockPattern r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onResume(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L13;
        OLog.i("AppLifecycle", "onResume_Activity " + r0);
        AppMetricsUtils r1 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r1.recordVisibleTime(r0);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type android.app.Activity");
        ChooseLockPattern r5 = r4;
        String r2 = r5.getCallingPackage();
        if (r2 != null) goto L9;
        OLog.e("BaseActivity", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r6 = r5.getReferrer();
        if (r6 == null) goto L9;
        r2 = r6.toString();
    L9:
        OLog.i("TeaEventReportUtil", "callingPkg=" + r2);
        if (r2 != null) goto L12;
        r2 = "null";
    L12:
        AppMetricsUtils.INSTANCE.reportColdStartActivity(r2, r0);
    L13:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }

    @Insert(mayCreateSuper = true, value = "startActivityForResult")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_startActivityForResult(ChooseLockPattern r2, Intent r3, int r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "intent");
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStart(r0);
    L5:
        r2.com_android_settings_ChooseLockPattern__startActivityForResult$___twin___(r3, r4, r5);
    }

    @Insert(mayCreateSuper = true, value = "onStop")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_BatchedActivityLancet_onStop(ChooseLockPattern r2) {
        String r0 = r2.getClass().getName();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils.INSTANCE.activityEventStoped(r0);
    L5:
        com_android_settings_ChooseLockPattern_com_bytedance_sysoptimizer_EnterTransitionLancet_onStop(r2);
    }

    @Insert("onResume")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onResume(ChooseLockPattern r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperResume();
        return;
    L6:
        r3.com_android_settings_ChooseLockPattern__onResume$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onPause")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_Activity(ChooseLockPattern r4) {
        String r0 = r4.getClass().getName();
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onPause(r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_Activity " + r0);
        AppMetricsUtils r5 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        AppMetricsUtils.reportVisibleTime$default(r5, r0, false, 2, null);
        return;
    }

    @Insert("onPause")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onPause(ChooseLockPattern r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperPause();
        return;
    L6:
        r3.com_android_settings_ChooseLockPattern__onPause$___twin___();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Activity(ChooseLockPattern r3, Bundle r4) {
        String r0 = r3.getClass().getName();
        com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onCreate(r3, r4);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L14;
        OLog.i("AppLifecycle", "onCreate_Activity " + r0);
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.Activity");
        ChooseLockPattern r5 = r3;
        String r6 = r5.getCallingPackage();
        if (r6 != null) goto L9;
        OLog.e("AppLifecycle", "isDeviceSetupComplete callingPkg is null, try getReferrer");
        Uri r7 = r5.getReferrer();
        if (r7 == null) goto L9;
        r6 = r7.toString();
    L9:
        OLog.i("AppLifecycle", "TeaEventReportUtil callingPkg=" + r6);
        if (r6 != null) goto L12;
        r6 = "null";
    L12:
        AppMetricsUtils r8 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r8.callingPackageEvent(r6, r0, false);
        return;
    }

    @Insert("onStop")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_onStop(ChooseLockPattern r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.onSuperStop();
        return;
    L6:
        r3.com_android_settings_ChooseLockPattern__onStop$___twin___();
    }

    @Insert("finish")
    public static void com_android_settings_ChooseLockPattern_com_obric_hook_lancet_PrivacyHook_finish(ChooseLockPattern r3) {
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.privacy.LifeHookActivity");
        ChooseLockPattern r0 = r3;
        if (GrantUtil.INSTANCE.isHookAllowed(r0) == false) goto L6;
        r0.superFinish();
        return;
    L6:
        r3.com_android_settings_ChooseLockPattern__finish$___twin___();
    }
}
