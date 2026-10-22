package com.obric.securitycenter.nodisturb;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;
import java.util.Observer;

/* JADX INFO: loaded from: classes4.dex */
public class BaseActivity extends FragmentActivity {
    private Observer mStatusBarObserver;
    private View mStatusBarTintView;
    public OFloatingTitleBar mTitle;
    protected View mTitleBarBackView;
    protected OButton mTitleBarRightView;

    public static class FpsSceneSession {
        private FPSSceneMonitor monitor;
        private final String scene;
        private boolean started;

        /* JADX INFO: renamed from: -$$Nest$fgetscene, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m607$$Nest$fgetscene(FpsSceneSession r0) {
            return r0.scene;
        }

        public FpsSceneSession(String r1) {
            this.scene = r1;
        }

        public void start() {
            if (this.started == false) goto L6;
            return;
        L6:
            if (TextUtils.isEmpty(this.scene) == false) goto L8;
            return;
        L8:
            this.started = true;
            FPSSceneMonitor r0 = new FPSSceneMonitor(this.scene, false, new AnonymousClass1(this));
            this.monitor = r0;
            r0.start();
        }

        public void stop() {
            if (this.started == true) goto L5;
            return;
        L5:
            this.started = false;
            FPSSceneMonitor r0 = this.monitor;
            if (r0 == null) goto L9;
            r0.stop();
            this.monitor = null;
            return;
        }
    }

    public boolean isFromSecurityCenter() {
        return true;
    }

    public String scene() {
        return "";
    }

    public BaseActivity() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r4) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.oui_bg_base_1));
        getWindow().setNavigationBarColor(0);
        setLightStatusBarIcon(true);
        super.onCreate(r4);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        onPageShow();
    }

    private void onPageShow() {
        if (TextUtils.isEmpty(scene()) == true) goto L6;
        HashMap r0 = new HashMap();
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, scene());
        TrackUtils.INSTANCE.trackEvent("page_show", r0);
        return;
    }

    private void setLightStatusBarIcon(boolean r4) {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r5 = true;
    L6:
        WindowInsetsControllerCompat r3 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        if (r5 == false) goto L9;
        r3.setAppearanceLightStatusBars(false);
        return;
    L9:
        r3.setAppearanceLightStatusBars(true);
        return;
    L5:
        r5 = false;
        goto L6
    }

    public void initTitleBar(boolean r4, boolean r5) {
        if (this.mTitle != null) goto L5;
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.title_bar);
    L5:
        OFloatingTitleBar r6 = this.mTitle;
        if (r6 != null) goto L8;
        return;
    L8:
        this.mTitleBarBackView = r6.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new BaseActivity$$ExternalSyntheticLambda0(this));
        if (r5 == false) goto L12;
        ViewCompat.setOnApplyWindowInsetsListener(this.mTitle, new BaseActivity$$ExternalSyntheticLambda1());
        return;
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$com-obric-securitycenter-nodisturb-BaseActivity, reason: not valid java name */
    /* synthetic */ void m606xa417ff57(View r1) {
        finish();
    }

    static /* synthetic */ WindowInsetsCompat lambda$initTitleBar$1(View r2, WindowInsetsCompat r3) {
        Insets r0 = r3.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        r1.topMargin = r0.top;
        r2.setLayoutParams(r1);
        return r3;
    }

    public void initTitleBar(boolean r2) {
        initTitleBar(r2, true);
    }

    public void removeTitleBarLeft() {
        OFloatingTitleBar r0 = this.mTitle;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeAllStartAction();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence r1) {
        super.setTitle(r1);
        OFloatingTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setCenterTitle(r1.toString());
        return;
    }
}
