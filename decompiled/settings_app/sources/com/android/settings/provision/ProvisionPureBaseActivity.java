package com.android.settings.provision;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.settings.R;
import com.android.settings.Utils;
import com.obric.olog.OLog;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ProvisionPureBaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    protected OButton mBottomButton;
    private boolean mIsBack;
    protected OTextView mLaterSettingsTv;

    protected int getBottomStringId(int r1) {
        return R.string.next_step;
    }

    protected abstract int getContentLayoutId();

    protected boolean getShowBack() {
        return true;
    }

    protected abstract int getTitleId();

    protected abstract void nextStep(int r1);

    public ProvisionPureBaseActivity() {
        this.mIsBack = false;
    }

    private void setupTitleBar(boolean r4, int r5) {
        OFloatingTitleBar r0 = (OFloatingTitleBar) findViewById(R.id.title_bar);
        if (r4 == false) goto L5;
        r0.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new ProvisionPureBaseActivity$$ExternalSyntheticLambda0(this));
    L5:
        TextView r3 = (TextView) findViewById(R.id.titlebar_title_tv);
        if (r3 == null) goto L9;
        r3.setText(r5);
        return;
    }

    /* JADX INFO: renamed from: lambda$setupTitleBar$0$com-android-settings-provision-ProvisionPureBaseActivity, reason: not valid java name */
    /* synthetic */ void m546xb6db54d2(View r1) {
        onBackPressed();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(R.layout.activity_base);
        setupTitleBar(getShowBack(), getTitleId());
        this.mBottomButton = (OButton) findViewById(R.id.bottom_button);
        this.mLaterSettingsTv = (OTextView) findViewById(R.id.later_setting);
        OButton r5 = this.mBottomButton;
        if (r5 == null) goto L5;
        r5.setText(getBottomStringId(0));
        this.mBottomButton.setOnClickListener(new ProvisionPureBaseActivity$$ExternalSyntheticLambda1(this));
    L5:
        this.mLaterSettingsTv.setText(getBottomStringId(0));
        this.mLaterSettingsTv.setOnClickListener(new ProvisionPureBaseActivity$$ExternalSyntheticLambda2(this));
        FrameLayout r6 = (FrameLayout) findViewById(R.id.content_frame);
        r6.addView(getLayoutInflater().inflate(getContentLayoutId(), r6, false));
        Window r7 = getWindow();
        if (r7 == null) goto L11;
        if (r7.getInsetsController() == null) goto L11;
        r7.getInsetsController().hide(WindowInsets.Type.statusBars());
        r7.setNavigationBarColor(getColor(R.color.transparent));
    L11:
        if (WizardManagerHelper.isAnySetupWizard(getIntent()) == false) goto L14;
        r7.getDecorView().setBackgroundDrawable(new ColorDrawable(getColor(R.color.oui_basic_bg_base_1_light)));
        return;
    }

    /* JADX INFO: renamed from: lambda$onCreate$1$com-android-settings-provision-ProvisionPureBaseActivity, reason: not valid java name */
    /* synthetic */ void m544xc1a547f4(View r1) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        nextStep(0);
    }

    /* JADX INFO: renamed from: lambda$onCreate$2$com-android-settings-provision-ProvisionPureBaseActivity, reason: not valid java name */
    /* synthetic */ void m545x4e925f13(View r1) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        nextStep(1);
    }

    protected void setOnTitleBarClickListener(View.OnClickListener r2) {
        View r1 = findViewById(R.id.titlebar_container);
        if (r1 == null) goto L6;
        r1.setOnClickListener(r2);
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        OLog.i(TAG, "onBackPressed");
        this.mIsBack = true;
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r3) {
        OLog.i(TAG, "startActivity");
        super.startActivity(r3);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.slide_out_to_right);
        OLog.i(TAG, "finish");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (Utils.isDeviceSetupComplete(this) == true) goto L6;
        OLog.w(TAG, "onWindowFocusChanged isDeviceSetupComplete false ");
        return;
    }
}
