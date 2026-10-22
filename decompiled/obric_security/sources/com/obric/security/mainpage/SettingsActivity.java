package com.obric.security.mainpage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.ExtKt;
import com.obric.matrix.platform.sdk.ones.commonmonitor.page.PageMonitor;
import com.obric.oui.button.OIconButton;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.securitycenter.api.TrackUtils;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: SettingsActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\u0006\u0010\u001a\u001a\u00020\u0007J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/security/mainpage/SettingsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "pageMonitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/page/PageMonitor;", "periodStarts", "", "", "", "permission_note", "Lcom/obric/oui/lisitem/OListItemSettings;", "privacyPolicy", "titleBar", "Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "getTitleBar", "()Lcom/obric/oui/titlebar/optimize/OCTitleBar;", "setTitleBar", "(Lcom/obric/oui/titlebar/optimize/OCTitleBar;)V", "markEnd", "", "period", "markStart", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "scene", "setwindow", "dismiss", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    private final PageMonitor pageMonitor;
    private final Map<String, Long> periodStarts;
    private OListItemSettings permission_note;
    private OListItemSettings privacyPolicy;
    private OCTitleBar titleBar;

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public final String scene() {
        return "settings_page";
    }

    public SettingsActivity() {
        this.pageMonitor = PerformanceMonitors.createPageMonitor(PerformanceScenes.PAGE_SETTINGS);
        this.periodStarts = new LinkedHashMap();
    }

    public static final /* synthetic */ void access$markEnd(SettingsActivity r0, String r1) {
        r0.markEnd(r1);
    }

    public static final /* synthetic */ void access$setwindow(SettingsActivity r0, boolean r1) {
        r0.setwindow(r1);
    }

    public final OCTitleBar getTitleBar() {
        return this.titleBar;
    }

    public final void setTitleBar(OCTitleBar r1) {
        this.titleBar = r1;
    }

    private final void markStart(String r4) {
        this.periodStarts.put(r4, Long.valueOf(PerformanceMonitors.nowElapsedMs()));
        this.pageMonitor.markStart(r4);
    }

    private final void markEnd(String r6) {
        Long r0 = this.periodStarts.remove(r6);
        if (r0 == null) goto L5;
        long r1 = PerformanceMonitors.nowElapsedMs() - r0.longValue();
        PerformanceMonitors.reportPageActionTime(PerformanceMonitors.composePagePeriodScene(PerformanceScenes.PAGE_SETTINGS, r6), r1);
    L5:
        this.pageMonitor.markEnd(r6);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        markStart(PageMonitor.PERIOD_ACTIVITY_CREATE);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().addFlags(Integer.MIN_VALUE);
        Window r1 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r1, "window");
        r1.setStatusBarColor(0);
        Window r2 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r2, "window");
        r2.setNavigationBarColor(0);
        super.onCreate(r7);
        setContentView(R.layout.activity_settings);
        this.titleBar = (OCTitleBar) findViewById(R.id.title_bar);
        this.privacyPolicy = (OListItemSettings) findViewById(R.id.privacy_policy_text);
        this.permission_note = (OListItemSettings) findViewById(R.id.permission_note);
        OListItemSettings r8 = this.privacyPolicy;
        if (r8 == null) goto L5;
        r8.setOnClickListener(new AnonymousClass1(this));
    L5:
        OListItemSettings r9 = this.permission_note;
        if (r9 == null) goto L8;
        r9.setOnClickListener(new AnonymousClass2(this));
    L8:
        setwindow(false);
        View r10 = LayoutInflater.from(this).inflate(R.layout.activity_settings_dismiss, null, false);
        if (r10 == null) goto L16;
        OIconButton r11 = (OIconButton) r10;
        r11.setLayoutParams(new RelativeLayout.LayoutParams(MathKt.roundToInt(TypedValue.applyDimension(1, 44, Resources.getSystem().getDisplayMetrics())), MathKt.roundToInt(TypedValue.applyDimension(1, 32, Resources.getSystem().getDisplayMetrics()))));
        OCTitleBar r3 = this.titleBar;
        if (r3 == null) goto L13;
        r3.addRightView(r11);
    L13:
        r11.setOnClickListener(new AnonymousClass3(this));
        ExtKt.onPreDrawOnce(getWindow(), new AnonymousClass4(this));
        markStart("userdata_real_show");
        markEnd(PageMonitor.PERIOD_ACTIVITY_CREATE);
        return;
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OIconButton");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        markStart(PageMonitor.PERIOD_ACTIVITY_RESUME);
        super.onResume();
        markEnd(PageMonitor.PERIOD_ACTIVITY_RESUME);
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "page_show", MapsKt.mapOf(TuplesKt.to(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, scene())), false, 4, null);
    }

    private final void setwindow(boolean r5) {
        Window r4 = getWindow();
        if (r4 == null) goto L20;
        Context r0 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "context");
        Resources r1 = r0.getResources();
        Intrinsics.checkNotNullExpressionValue(r1, "context.resources");
        if ((r1.getConfiguration().uiMode & 48) != 32) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        float r3 = 0.5f;
    L11:
        if (r5 == false) goto L13;
        r3 = 0.0f;
    L13:
        WindowManager.LayoutParams r6 = r4.getAttributes();
        r6.dimAmount = r3;
        r4.setAttributes(r6);
        WindowInsetsControllerCompat r7 = WindowCompat.getInsetsController(r4, r4.getDecorView());
        Intrinsics.checkNotNullExpressionValue(r7, "WindowCompat.getInsetsCo…ler(this, this.decorView)");
        if (r2 == false) goto L17;
        if (r7 == null) goto L21;
        r7.setAppearanceLightStatusBars(false);
        return;
    L21:
        return;
    L17:
        if (r7 == null) goto L23;
        r7.setAppearanceLightStatusBars(true);
        return;
    L23:
        return;
    L10:
        r3 = 0.16f;
        goto L11
    L7:
        r2 = false;
        goto L8
    }
}
