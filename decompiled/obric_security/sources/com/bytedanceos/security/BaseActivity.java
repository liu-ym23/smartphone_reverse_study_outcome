package com.bytedanceos.security;

import android.app.ActivityManager;
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
import com.bytedanceos.securitycenter.provider.CustomizedStatusBarHelp;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.PageMonitor;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;
import java.util.Observer;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public class BaseActivity extends FragmentActivity {
    private boolean mPerformanceContentViewHooked;

    @Nullable
    private PageMonitor mPerformancePageMonitor;
    private final HashMap<String, Long> mPerformancePeriodStartTimes;
    private Observer mStatusBarObserver;
    private View mStatusBarTintView;
    protected OFloatingTitleBar mTitle;
    protected View mTitleBarBackView;
    protected OButton mTitleBarRightView;

    protected boolean enablePerformanceActivityResumePeriod() {
        return false;
    }

    public boolean isFromSecurityCenter() {
        return true;
    }

    @Nullable
    protected String performancePageScene() {
        return null;
    }

    @Nullable
    protected String performanceThreadsSceneOnRealShow() {
        return null;
    }

    public String scene() {
        return "";
    }

    public BaseActivity() {
        this.mPerformanceContentViewHooked = false;
        this.mPerformancePeriodStartTimes = new HashMap();
    }

    static /* synthetic */ HashMap access$000(BaseActivity r0) {
        return r0.mPerformancePeriodStartTimes;
    }

    static /* synthetic */ PageMonitor access$100(BaseActivity r0) {
        return r0.mPerformancePageMonitor;
    }

    @Nullable
    protected final PageMonitor getPerformancePageMonitor() {
        return this.mPerformancePageMonitor;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.transparent));
        getWindow().setNavigationBarColor(0);
        setLightStatusBarIcon(true);
        String r0 = performancePageScene();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        this.mPerformancePageMonitor = PerformanceMonitors.createPageMonitor(r0);
        this.mPerformancePeriodStartTimes.put(PageMonitor.PERIOD_ACTIVITY_CREATE, Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.mPerformancePageMonitor.markStart(PageMonitor.PERIOD_ACTIVITY_CREATE);
    L5:
        super.onCreate(savedInstanceState);
        AppExitTrace.getInstance().cancelExit();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        if (this.mPerformancePageMonitor != null) goto L5;
    L7:
        super.onResume();
        onPageShow();
        if (this.mPerformancePageMonitor != null) goto L10;
        return;
    L10:
        if (enablePerformanceActivityResumePeriod() == false) goto L19;
        Long r0 = this.mPerformancePeriodStartTimes.remove(PageMonitor.PERIOD_ACTIVITY_RESUME);
        if (r0 == null) goto L16;
        long r2 = PerformanceMonitors.nowElapsedMs() - r0.longValue();
        String r1 = performancePageScene();
        if (TextUtils.isEmpty(r1) == true) goto L16;
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(r1, PageMonitor.PERIOD_ACTIVITY_RESUME), r2);
    L16:
        this.mPerformancePageMonitor.markEnd(PageMonitor.PERIOD_ACTIVITY_RESUME);
        return;
    L19:
        return;
    L5:
        if (enablePerformanceActivityResumePeriod() == false) goto L7;
        this.mPerformancePeriodStartTimes.put(PageMonitor.PERIOD_ACTIVITY_RESUME, Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.mPerformancePageMonitor.markStart(PageMonitor.PERIOD_ACTIVITY_RESUME);
        goto L7
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        hookPerformanceAfterSetContentView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        super.setContentView(view);
        hookPerformanceAfterSetContentView();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        hookPerformanceAfterSetContentView();
    }

    private void hookPerformanceAfterSetContentView() {
        if (this.mPerformanceContentViewHooked == false) goto L6;
        return;
    L6:
        if (this.mPerformancePageMonitor != null) goto L8;
        return;
    L8:
        final String r0 = performancePageScene();
        if (TextUtils.isEmpty(r0) == false) goto L11;
        return;
    L11:
        this.mPerformanceContentViewHooked = true;
        PerformanceMonitors.reportSceneFrequency(r0);
        PerformanceMonitors.markRealShowOnce(getWindow().getDecorView(), new AnonymousClass1(this, r0));
        this.mPerformancePeriodStartTimes.put("userdata_real_show", Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.mPerformancePageMonitor.markStart("userdata_real_show");
        Long r1 = this.mPerformancePeriodStartTimes.remove(PageMonitor.PERIOD_ACTIVITY_CREATE);
        if (r1 == null) goto L14;
        long r3 = PerformanceMonitors.nowElapsedMs() - r1.longValue();
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(r0, PageMonitor.PERIOD_ACTIVITY_CREATE), r3);
    L14:
        this.mPerformancePageMonitor.markEnd(PageMonitor.PERIOD_ACTIVITY_CREATE);
    }

    private void onPageShow() {
        if (TextUtils.isEmpty(scene()) == true) goto L6;
        HashMap r0 = new HashMap();
        r0.put(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, scene());
        TrackUtils.INSTANCE.trackEvent("page_show", r0);
        return;
    }

    public void setDescription() {
        setTaskDescription(new ActivityManager.TaskDescription(getString(R.string.security_manager)));
    }

    private void setLightStatusBarIcon(boolean lightMode) {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r4 = true;
    L6:
        WindowInsetsControllerCompat r3 = WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView());
        if (r4 == false) goto L9;
        r3.setAppearanceLightStatusBars(false);
        return;
    L9:
        r3.setAppearanceLightStatusBars(true);
        return;
    L5:
        r4 = false;
        goto L6
    }

    public void initTitleBar(boolean hasRight, boolean istop) {
        if (this.mTitle != null) goto L5;
        this.mTitle = (OFloatingTitleBar) findViewById(R.id.title_bar);
    L5:
        OFloatingTitleBar r0 = this.mTitle;
        if (r0 != null) goto L8;
        return;
    L8:
        r0.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new BaseActivity$$ExternalSyntheticLambda0(this));
        if (hasRight == false) goto L11;
        this.mTitle.removeAllStartAction();
        this.mTitle.addEndAction(R.string.done, -1, new BaseActivity$$ExternalSyntheticLambda1(this));
    L11:
        if (istop == false) goto L14;
        ViewCompat.setOnApplyWindowInsetsListener(this.mTitle, new BaseActivity$$ExternalSyntheticLambda2());
        return;
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$com-bytedanceos-security-BaseActivity, reason: not valid java name */
    /* synthetic */ void m125lambda$initTitleBar$0$combytedanceossecurityBaseActivity(View r1) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$1$com-bytedanceos-security-BaseActivity, reason: not valid java name */
    /* synthetic */ void m126lambda$initTitleBar$1$combytedanceossecurityBaseActivity(View r1) {
        finish();
    }

    static /* synthetic */ WindowInsetsCompat lambda$initTitleBar$2(View r2, WindowInsetsCompat r3) {
        Insets r0 = r3.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r2.getLayoutParams();
        r1.topMargin = r0.top;
        r2.setLayoutParams(r1);
        return r3;
    }

    public void initTitleBar(boolean hasRight) {
        initTitleBar(hasRight, true);
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
        if (this.mStatusBarObserver == null) goto L6;
        CustomizedStatusBarHelp.getInstance().deleteObserver(this.mStatusBarObserver);
        this.mStatusBarObserver = null;
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // android.app.Activity
    public void setTitle(CharSequence title) {
        super.setTitle(title);
        OFloatingTitleBar r0 = this.mTitle;
        if (r0 == null) goto L6;
        r0.setCenterTitle(title.toString());
        return;
    }

    public void updateViewWidth(int viewId) {
        Utils.updateViewWidth(findViewById(viewId), this);
    }

    public void updateViewWidth(View view) {
        Utils.updateViewWidth(view, this);
    }
}
