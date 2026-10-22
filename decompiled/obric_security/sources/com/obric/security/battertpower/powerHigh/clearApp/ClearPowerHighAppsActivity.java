package com.obric.security.battertpower.powerHigh.clearApp;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.R;
import com.obric.security.battertpower.powerHigh.notice.PowerHighApp;
import com.obric.security.battertpower.powerHigh.notice.PowerHighAppsManager;
import com.obric.security.battertpower.powerHigh.notice.PowerHighWarningReceiver;
import com.obric.security.battertpower.powerHigh.notice.PowerHightNoticeService;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.ss.android.message.log.PushLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: ClearPowerHighAppsActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 J2\u00020\u0001:\u0001JB\u0005¢\u0006\u0002\u0010\u0002J*\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u001a\u00109\u001a\u0016\u0012\u0004\u0012\u00020;\u0018\u00010:j\n\u0012\u0004\u0012\u00020;\u0018\u0001`<J\u0012\u0010=\u001a\u0002062\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\b\u0010@\u001a\u000206H\u0014J\u0012\u0010A\u001a\u0002062\b\u0010B\u001a\u0004\u0018\u00010CH\u0014J\b\u0010D\u001a\u000206H\u0014J\b\u0010E\u001a\u000206H\u0014J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000206H\u0002J\b\u0010I\u001a\u000206H\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010/\u001a\u0004\u0018\u000100X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u0006K"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/clearApp/ClearPowerHighAppsActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "adapter", "Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsAdapter;", "getAdapter", "()Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsAdapter;", "setAdapter", "(Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsAdapter;)V", "bottomClear", "Lcom/obric/oui/button/OButtonFloating;", "getBottomClear", "()Lcom/obric/oui/button/OButtonFloating;", "setBottomClear", "(Lcom/obric/oui/button/OButtonFloating;)V", "clearAction", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "getClearAction", "()Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "setClearAction", "(Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;)V", "empty", "Lcom/obric/oui/status/OPageStatus;", "getEmpty", "()Lcom/obric/oui/status/OPageStatus;", "setEmpty", "(Lcom/obric/oui/status/OPageStatus;)V", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "getLabel", "()Lcom/obric/oui/text/OTextView;", "setLabel", "(Lcom/obric/oui/text/OTextView;)V", "listFpsSession", "Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "listFpsStarted", "", "notProcessClearToast", "Landroid/widget/Toast;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "setRecyclerView", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;)V", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "viewModel", "Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewModel;", "getViewModel", "()Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewModel;", "setViewModel", "(Lcom/obric/security/battertpower/powerHigh/clearApp/PowerHighAppsViewModel;)V", "forceStopPackageAsUser", "", "context", "Landroid/content/Context;", "apps", "Ljava/util/HashSet;", "Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "Lkotlin/collections/HashSet;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "scene", "", "startListFps", "stopListFps", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ClearPowerHighAppsActivity extends BaseActivity {
    public static final String COME_FROM = "come_from";
    public static final String COME_FROM_NOTIFICATION = "notification";
    public static final Companion Companion = null;
    private HashMap _$_findViewCache;
    private PowerHighAppsAdapter adapter;
    private OButtonFloating bottomClear;
    private OBottomActionBarFloating clearAction;
    private OPageStatus empty;
    private OTextView label;
    private final PerformanceMonitors.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private Toast notProcessClearToast;
    private RecyclerView recyclerView;
    private OFloatingTitleBar titleBar;
    private PowerHighAppsViewModel viewModel;

    /* JADX INFO: compiled from: ClearPowerHighAppsActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/clearApp/ClearPowerHighAppsActivity$Companion;", "", "()V", "COME_FROM", "", "COME_FROM_NOTIFICATION", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.battertpower.powerHigh.clearApp.ClearPowerHighAppsActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClearPowerHighAppsActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButtonFloating;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass1 extends Lambda implements Function3<Context, Integer, Integer, OButtonFloating> {
        final /* synthetic */ ClearPowerHighAppsActivity this$0;

        AnonymousClass1(ClearPowerHighAppsActivity r1) {
            this.this$0 = r1;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButtonFloating invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButtonFloating invoke(Context r9, final int r10, final int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            final OButtonFloating r0 = new OButtonFloating(r9, null, 0, 0, 14, null);
            String r12 = this.this$0.getString(R.string.clear_text);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.clear_text)");
            r0.setTitle(r12);
            OBaseTextView r13 = r0.getTextView();
            OBottomActionBarFloating r1 = this.this$0.getClearAction();
            Intrinsics.checkNotNull(r1);
            r13.setTextColor(r1.getContext().getColor(R.color.oui_red_6));
            r0.setLayoutParams(new ViewGroup.LayoutParams(r10, r11));
            r0.setOnClickListener(new ClearPowerHighAppsActivity$onCreate$1$$special$$inlined$apply$lambda$1(r0, this, r10, r11));
            return r0;
        }
    }

    static {
        Companion = new Companion(null);
    }

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

    @Override // com.bytedanceos.security.BaseActivity
    public String scene() {
        return "high_power_clean_page";
    }

    public ClearPowerHighAppsActivity() {
        this.listFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_BATTERY_POWER_HIGH_POWER_LIST);
    }

    public static final /* synthetic */ void access$startListFps(ClearPowerHighAppsActivity r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(ClearPowerHighAppsActivity r0) {
        r0.stopListFps();
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView r1) {
        this.recyclerView = r1;
    }

    public final OTextView getLabel() {
        return this.label;
    }

    public final void setLabel(OTextView r1) {
        this.label = r1;
    }

    public final OPageStatus getEmpty() {
        return this.empty;
    }

    public final void setEmpty(OPageStatus r1) {
        this.empty = r1;
    }

    public final OBottomActionBarFloating getClearAction() {
        return this.clearAction;
    }

    public final void setClearAction(OBottomActionBarFloating r1) {
        this.clearAction = r1;
    }

    public final OButtonFloating getBottomClear() {
        return this.bottomClear;
    }

    public final void setBottomClear(OButtonFloating r1) {
        this.bottomClear = r1;
    }

    public final PowerHighAppsAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(PowerHighAppsAdapter r1) {
        this.adapter = r1;
    }

    public final PowerHighAppsViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel(PowerHighAppsViewModel r1) {
        this.viewModel = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r11) {
        super.onCreate(r11);
        setContentView(R.layout.chear_power_high_apps);
        Intent r12 = getIntent();
        if (r12 == null) goto L5;
        String r13 = r12.getStringExtra(COME_FROM);
    L7:
        if (Intrinsics.areEqual(r13, COME_FROM_NOTIFICATION) == false) goto L9;
        PowerHighWarningReceiver.noticeShowing = false;
        PowerHighAppsManager.INSTANCE.unregisterUidListener();
    L9:
        this.viewModel = (PowerHighAppsViewModel) new ViewModelProvider(this).get(PowerHighAppsViewModel.class);
        this.titleBar = (OFloatingTitleBar) findViewById(R.id.title_bar);
        this.recyclerView = (RecyclerView) findViewById(R.id.list_view);
        this.empty = (OPageStatus) findViewById(R.id.empty);
        OBottomActionBarFloating r2 = (OBottomActionBarFloating) findViewById(R.id.clear_action);
        this.clearAction = r2;
        Intrinsics.checkNotNull(r2);
        Context r3 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "clearAction!!.context");
        OButtonFloating r4 = (OButtonFloating) StyleUtil.createWidgetWithStyle(r3, 2131821333, new AnonymousClass1(this));
        this.bottomClear = r4;
        OBottomActionBarFloating r5 = this.clearAction;
        if (r5 == null) goto L16;
        List<? extends View> r6 = CollectionsKt.listOf(r4);
        if (r6 == null) goto L15;
        r5.setButtons(r6);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<android.view.View>");
    L16:
        OPageStatus r7 = this.empty;
        if (r7 == null) goto L19;
        r7.setTitle(getString(R.string.app_bg_battery_list_title_no_item));
        r7.getTitleView().setMaxLines(2);
        r7.getTitleView().setGravity(17);
    L19:
        OFloatingTitleBar r8 = this.titleBar;
        if (r8 == null) goto L24;
        View r9 = OFloatingTitleBar.addStartAction$default(r8, OCTitleBar.Companion.getBACK_ICON_RES(), 0, null, 6, null);
        if (r9 == null) goto L24;
        r9.setOnClickListener(new AnonymousClass3(this));
    L24:
        PowerHighAppsAdapter r10 = new PowerHighAppsAdapter();
        this.adapter = r10;
        RecyclerView r14 = this.recyclerView;
        if (r14 == null) goto L27;
        r14.setAdapter(r10);
    L27:
        RecyclerView r15 = this.recyclerView;
        if (r15 == null) goto L30;
        r15.addItemDecoration(new ItemSpacingDecoration(0, this.recyclerView));
    L30:
        RecyclerView r1 = this.recyclerView;
        if (r1 == null) goto L33;
        r1.setLayoutManager(new LinearLayoutManager(this));
    L33:
        RecyclerView r16 = this.recyclerView;
        if (r16 == null) goto L36;
        RecyclerView.ItemAnimator r17 = (RecyclerView.ItemAnimator) null;
        r16.setItemAnimator(null);
    L36:
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L39;
        r0.addOnScrollListener(new AnonymousClass4(this));
    L39:
        PowerHighAppsViewModel r18 = this.viewModel;
        if (r18 == null) goto L44;
        MutableLiveData<ArrayList<PowerHighApp>> r19 = r18.getPowerHighApps();
        if (r19 == null) goto L44;
        r19.observe(this, new AnonymousClass5(this));
    L44:
        PowerHighAppsViewModel r20 = this.viewModel;
        if (r20 == null) goto L49;
        MutableLiveData<Integer> r21 = r20.getCheckAppsChange();
        if (r21 == null) goto L49;
        r21.observe(this, new AnonymousClass6(this));
    L49:
        View r110 = findViewById(R.id.title_bar);
        Intrinsics.checkNotNull(r110);
        ViewCompat.setOnApplyWindowInsetsListener(r110, new AnonymousClass7(this));
        return;
    L5:
        r13 = null;
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        if (r1 == null) goto L5;
        String r0 = r1.getStringExtra(COME_FROM);
    L7:
        if (Intrinsics.areEqual(r0, COME_FROM_NOTIFICATION) == false) goto L10;
        PowerHighWarningReceiver.noticeShowing = false;
        return;
    L10:
        return;
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        PowerHighAppsViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.getPowerHighApps(this);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopListFps();
        super.onPause();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        stopListFps();
        super.onDestroy();
    }

    private final void startListFps() {
        if (this.listFpsStarted == false) goto L5;
        return;
    L5:
        this.listFpsStarted = true;
        this.listFpsSession.start();
    }

    private final void stopListFps() {
        if (this.listFpsStarted == true) goto L5;
        return;
    L5:
        this.listFpsStarted = false;
        this.listFpsSession.stop();
    }

    public final void forceStopPackageAsUser(Context r11, HashSet<PowerHighApp> r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        boolean r3 = PowerHighWarningReceiver.isNotificationShowing(r11, PowerHighWarningReceiver.CHANNEL_ID);     // Catch: Exception -> L37
        PackageManager r4 = r11.getPackageManager();     // Catch: Exception -> L37
        Object r5 = r11.getSystemService("activity");     // Catch: Exception -> L37
        if (r5 == null) goto L36;
        ActivityManager r6 = (ActivityManager) r5;     // Catch: Exception -> L37
        if (r12 == null) goto L11;
        Iterator<T> r7 = r12.iterator();     // Catch: Exception -> L37
    L9:
        if (r7.hasNext() == false) goto L11;
        PowerHighApp r8 = (PowerHighApp) r7.next();     // Catch: Exception -> L37
        OLog.e("PowerHighAppsManager", "forceStopPackageAsUser:" + r8.getPackageName());     // Catch: Exception -> L37
        ApplicationInfo r9 = r4.getApplicationInfo(r8.getPackageName(), 0);     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r9, "pm.getApplicationInfo(app.packageName, 0)");     // Catch: Exception -> L37
        r6.forceStopPackageAsUser(r8.getPackageName(), UserHandle.getUserId(r9.uid));     // Catch: Exception -> L37
        PowerHighWarningReceiver.powerHighApps.remove(r8);     // Catch: Exception -> L37
    L11:
        PowerHighAppsViewModel r10 = this.viewModel;     // Catch: Exception -> L37
        if (r10 == null) goto L14;
        r10.clearPowerHighApps(r12);     // Catch: Exception -> L37
    L14:
        PowerHighAppsViewModel r13 = this.viewModel;     // Catch: Exception -> L37
        if (r13 == null) goto L21;
        MutableLiveData<HashSet<PowerHighApp>> r14 = r13.getCheckApps();     // Catch: Exception -> L37
        if (r14 == null) goto L21;
        HashSet<PowerHighApp> r15 = r14.getValue();     // Catch: Exception -> L37
        if (r15 == null) goto L21;
        r15.clear();     // Catch: Exception -> L37
    L21:
        PowerHighAppsViewModel r16 = this.viewModel;     // Catch: Exception -> L37
        if (r16 == null) goto L24;
        r16.setCheckAppChange();     // Catch: Exception -> L37
    L24:
        if (r3 == true) goto L26;
        return;
    L26:
        if (PowerHighWarningReceiver.powerHighApps.size() != 0) goto L33;
        Object r17 = r11.getSystemService(COME_FROM_NOTIFICATION);     // Catch: Exception -> L37
        if (r17 == null) goto L31;
        ((NotificationManager) r17).cancel(PowerHighWarningReceiver.NOTIFICATION_ID);     // Catch: Exception -> L37
        PowerHighAppsManager.INSTANCE.clearLocalPowerHighApps(r11);     // Catch: Exception -> L37
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Exception -> L37
    L33:
        if (PowerHighWarningReceiver.powerHighApps.size() <= 0) goto L44;
        PowerHightNoticeService.Companion r18 = PowerHightNoticeService.Companion;     // Catch: Exception -> L37
        Context r19 = SecurityCenterApplication.getContext();     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r19, "SecurityCenterApplication.getContext()");     // Catch: Exception -> L37
        ArrayList<PowerHighApp> r110 = PowerHighWarningReceiver.powerHighApps;     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r110, "PowerHighWarningReceiver.powerHighApps");     // Catch: Exception -> L37
        String r111 = r18.getNotificationMessage(r19, r110);     // Catch: Exception -> L37
        PowerHightNoticeService.Companion r112 = PowerHightNoticeService.Companion;     // Catch: Exception -> L37
        Context r113 = SecurityCenterApplication.getContext();     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r113, "SecurityCenterApplication.getContext()");     // Catch: Exception -> L37
        String r20 = SecurityCenterApplication.getContext().getString(R.string.power_high_notification_title);     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r20, "SecurityCenterApplicatio…_high_notification_title)");     // Catch: Exception -> L37
        r112.sendNotification(r113, r20, r111);     // Catch: Exception -> L37
        PowerHighAppsManager r114 = PowerHighAppsManager.INSTANCE;     // Catch: Exception -> L37
        Context r115 = SecurityCenterApplication.getContext();     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r115, "SecurityCenterApplication.getContext()");     // Catch: Exception -> L37
        ArrayList<PowerHighApp> r116 = PowerHighWarningReceiver.powerHighApps;     // Catch: Exception -> L37
        Intrinsics.checkNotNullExpressionValue(r116, "PowerHighWarningReceiver.powerHighApps");     // Catch: Exception -> L37
        r114.savePowerHighApps(r115, r116);     // Catch: Exception -> L37
        return;
    L44:
        return;
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");     // Catch: Exception -> L37
    L37:
        e = move-exception;
        OLog.e("PowerHighAppsManager", "forceStopPackageAsUser:exception:" + e);
    }
}
