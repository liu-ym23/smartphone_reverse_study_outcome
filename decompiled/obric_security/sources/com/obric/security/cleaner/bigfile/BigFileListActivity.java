package com.obric.security.cleaner.bigfile;

import android.content.Context;
import android.os.Bundle;
import android.security.bytedance.guard.BDSettingsEvent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedanceos.security.BaseActivity;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.R;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.security.util.BDSecurityGuardUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import obric.widget.calendar.MonthWeekEventsView;

/* JADX INFO: compiled from: BigFileListActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0012\u0010#\u001a\u00020\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020\u001bH\u0014J\b\u0010'\u001a\u00020\u001bH\u0014J\b\u0010(\u001a\u00020\u001bH\u0014J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u001bH\u0002J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002J\b\u0010.\u001a\u00020\u001bH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigFileListActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "adapter", "Lcom/obric/security/cleaner/bigfile/BigFileListAdapter;", "bigFileViewModel", "Lcom/obric/security/cleaner/bigfile/BigFileViewModel;", "bottomClear", "Lcom/obric/oui/button/OButtonFloating;", "bottomDeleteAction", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "listFpsSession", "Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "listFpsStarted", "", "mMenuDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mProgressDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "statusEmpty", "Lcom/obric/oui/status/OPageStatus;", "statusLoading", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "dismissDialogsIfShowing", "", "getMenuDialog", "handleDeleteBigFile", "initDeleteActionView", "initEmptyStatusView", "initRecycleView", "launchDeleteConfirmDialog", "observe", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "scene", "", "showDeleteProgressDialog", "startListFps", "stopListFps", "updateBottomDeleteAction", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BigFileListActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private BigFileListAdapter adapter;
    private BigFileViewModel bigFileViewModel;
    private OButtonFloating bottomClear;
    private OBottomActionBarFloating bottomDeleteAction;
    private final PerformanceMonitors.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private OAlertDialog mMenuDialog;
    private StatusDialog mProgressDialog;
    private RecyclerView recyclerView;
    private OPageStatus statusEmpty;
    private OPageStatus statusLoading;
    private OFloatingTitleBar titleBar;

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileListActivity$initDeleteActionView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BigFileListActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButtonFloating;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 4, 3})
    static final class C03551 extends Lambda implements Function3<Context, Integer, Integer, OButtonFloating> {
        final /* synthetic */ BigFileListActivity this$0;

        C03551(BigFileListActivity r1) {
            this.this$0 = r1;
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ OButtonFloating invoke(Context r1, Integer r2, Integer r3) {
            return invoke(r1, r2.intValue(), r3.intValue());
        }

        public final OButtonFloating invoke(Context r9, final int r10, final int r11) {
            Intrinsics.checkNotNullParameter(r9, "styledContext");
            OButtonFloating r0 = new OButtonFloating(r9, null, 0, 0, 14, null);
            String r12 = this.this$0.getString(R.string.dialog_delete_conform);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.dialog_delete_conform)");
            r0.setTitle(r12);
            OBaseTextView r13 = r0.getTextView();
            OBottomActionBarFloating r1 = BigFileListActivity.access$getBottomDeleteAction$p(this.this$0);
            Intrinsics.checkNotNull(r1);
            r13.setTextColor(r1.getContext().getColor(R.color.oui_on_accent_default));
            r0.setLayoutParams(new ViewGroup.LayoutParams(r10, r11));
            r0.setOnClickListener(new BigFileListActivity$initDeleteActionView$1$$special$$inlined$apply$lambda$1(this, r10, r11));
            return r0;
        }
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
        return "big_file_clean_page";
    }

    public BigFileListActivity() {
        this.listFpsSession = new PerformanceMonitors.FpsSceneSession(PerformanceScenes.FPS_BIG_FILE_LIST);
    }

    public static final /* synthetic */ BigFileListAdapter access$getAdapter$p(BigFileListActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ BigFileViewModel access$getBigFileViewModel$p(BigFileListActivity r0) {
        return r0.bigFileViewModel;
    }

    public static final /* synthetic */ OBottomActionBarFloating access$getBottomDeleteAction$p(BigFileListActivity r0) {
        return r0.bottomDeleteAction;
    }

    public static final /* synthetic */ OAlertDialog access$getMMenuDialog$p(BigFileListActivity r0) {
        return r0.mMenuDialog;
    }

    public static final /* synthetic */ StatusDialog access$getMProgressDialog$p(BigFileListActivity r0) {
        return r0.mProgressDialog;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(BigFileListActivity r0) {
        return r0.recyclerView;
    }

    public static final /* synthetic */ OPageStatus access$getStatusEmpty$p(BigFileListActivity r0) {
        return r0.statusEmpty;
    }

    public static final /* synthetic */ OPageStatus access$getStatusLoading$p(BigFileListActivity r0) {
        return r0.statusLoading;
    }

    public static final /* synthetic */ void access$handleDeleteBigFile(BigFileListActivity r0) {
        r0.handleDeleteBigFile();
    }

    public static final /* synthetic */ void access$launchDeleteConfirmDialog(BigFileListActivity r0) {
        r0.launchDeleteConfirmDialog();
    }

    public static final /* synthetic */ void access$setAdapter$p(BigFileListActivity r0, BigFileListAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$setBigFileViewModel$p(BigFileListActivity r0, BigFileViewModel r1) {
        r0.bigFileViewModel = r1;
    }

    public static final /* synthetic */ void access$setBottomDeleteAction$p(BigFileListActivity r0, OBottomActionBarFloating r1) {
        r0.bottomDeleteAction = r1;
    }

    public static final /* synthetic */ void access$setMMenuDialog$p(BigFileListActivity r0, OAlertDialog r1) {
        r0.mMenuDialog = r1;
    }

    public static final /* synthetic */ void access$setMProgressDialog$p(BigFileListActivity r0, StatusDialog r1) {
        r0.mProgressDialog = r1;
    }

    public static final /* synthetic */ void access$setRecyclerView$p(BigFileListActivity r0, RecyclerView r1) {
        r0.recyclerView = r1;
    }

    public static final /* synthetic */ void access$setStatusEmpty$p(BigFileListActivity r0, OPageStatus r1) {
        r0.statusEmpty = r1;
    }

    public static final /* synthetic */ void access$setStatusLoading$p(BigFileListActivity r0, OPageStatus r1) {
        r0.statusLoading = r1;
    }

    public static final /* synthetic */ void access$showDeleteProgressDialog(BigFileListActivity r0) {
        r0.showDeleteProgressDialog();
    }

    public static final /* synthetic */ void access$startListFps(BigFileListActivity r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(BigFileListActivity r0) {
        r0.stopListFps();
    }

    public static final /* synthetic */ void access$updateBottomDeleteAction(BigFileListActivity r0) {
        r0.updateBottomDeleteAction();
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        setContentView(R.layout.activity_big_file_list);
        if ((this instanceof ViewModelStoreOwner) == true) goto L5;
        BigFileListActivity r8 = null;
    L6:
        BigFileListActivity r9 = r8;
        if (r9 == null) goto L9;
        this.bigFileViewModel = (BigFileViewModel) new ViewModelProvider(r9).get(BigFileViewModel.class);
    L9:
        this.titleBar = (OFloatingTitleBar) findViewById(R.id.title_bar);
        this.statusEmpty = (OPageStatus) findViewById(R.id.status_large);
        OBottomActionBarFloating r10 = (OBottomActionBarFloating) findViewById(R.id.bottom_delete_action);
        this.bottomDeleteAction = r10;
        if (r10 == null) goto L12;
        r10.applyMaskMaterial(false);
    L12:
        OBottomActionBarFloating r11 = this.bottomDeleteAction;
        if (r11 == null) goto L15;
        r11.setVisibility(8);
    L15:
        OPageStatus r12 = (OPageStatus) findViewById(R.id.status_loading_s);
        this.statusLoading = r12;
        if (r12 == null) goto L18;
        r12.setVisibility(0);
    L18:
        this.recyclerView = (RecyclerView) findViewById(R.id.big_file_list);
        initEmptyStatusView();
        initRecycleView();
        initDeleteActionView();
        observe();
        OFloatingTitleBar r0 = this.titleBar;
        if (r0 == null) goto L24;
        View r13 = OFloatingTitleBar.addStartAction$default(r0, R.drawable.back_icon, 0, null, 6, null);
        if (r13 == null) goto L25;
        r13.setOnClickListener(new ViewOnClickListenerC03602(this));
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r8 = this;
        goto L6
    }

    private final void dismissDialogsIfShowing() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        BigFileListActivity r2 = this;     // Catch: Throwable -> L12
        OAlertDialog r3 = this.mMenuDialog;     // Catch: Throwable -> L12
        if (r3 != null) goto L6;
    L10:
        Object r4 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r5 = Result.m777exceptionOrNullimpl(r4);
        if (r5 == null) goto L32;
        Log.w("BigFileList", "Failed to dismiss menu dialog", r5);
    L32:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L26
        BigFileListActivity r7 = this;     // Catch: Throwable -> L26
        StatusDialog r8 = this.mProgressDialog;     // Catch: Throwable -> L26
        if (r8 != null) goto L20;
    L24:
        Object r9 = Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L28:
        Throwable r10 = Result.m777exceptionOrNullimpl(r9);
        if (r10 == null) goto L36;
        Log.w("BigFileList", "Failed to dismiss dialogs", r10);
        return;
    L36:
        return;
    L20:
        if (r8.isShowing() != true) goto L24;
        StatusDialog r11 = this.mProgressDialog;     // Catch: Throwable -> L26
        if (r11 == null) goto L24;
        r11.dismiss();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r9 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L28
    L6:
        if (r3.isShowing() != true) goto L10;
        OAlertDialog r12 = this.mMenuDialog;     // Catch: Throwable -> L12
        if (r12 == null) goto L10;
        r12.dismiss();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final void initDeleteActionView() {
        OBottomActionBarFloating r0 = this.bottomDeleteAction;
        Intrinsics.checkNotNull(r0);
        Context r1 = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "bottomDeleteAction!!.context");
        OButtonFloating r2 = (OButtonFloating) StyleUtil.createWidgetWithStyle(r1, 2131821330, new C03551(this));
        this.bottomClear = r2;
        if (r2 == null) goto L5;
        OBottomActionBarFloating r3 = this.bottomDeleteAction;
        Intrinsics.checkNotNull(r3);
        r2.setBgColor(r3.getContext().getColor(R.color.oui_functional_red_6));
    L5:
        OBottomActionBarFloating r4 = this.bottomDeleteAction;
        if (r4 == null) goto L12;
        List<? extends View> r5 = CollectionsKt.listOf(this.bottomClear);
        if (r5 == null) goto L11;
        r4.setButtons(r5);
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<android.view.View>");
    }

    private final void initRecycleView() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.adapter = new BigFileListAdapter();
        RecyclerView r1 = this.recyclerView;
        if (r1 == null) goto L8;
        r1.setLayoutManager(new LinearLayoutManager(this));
    L8:
        RecyclerView r2 = this.recyclerView;
        if (r2 == null) goto L11;
        r2.setAdapter(this.adapter);
    L11:
        RecyclerView r3 = this.recyclerView;
        if (r3 == null) goto L14;
        RecyclerView.ItemAnimator r4 = (RecyclerView.ItemAnimator) null;
        r3.setItemAnimator(null);
    L14:
        RecyclerView r5 = this.recyclerView;
        if (r5 == null) goto L18;
        r5.addOnScrollListener(new C03561(this));
        return;
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

    private final void initEmptyStatusView() {
        OPageStatus r0 = this.statusEmpty;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        OPageStatus r1 = this.statusEmpty;
        if (r1 == null) goto L9;
        r1.setTitle(getString(R.string.big_file_empty_title));
        r1.setMessage(getString(R.string.big_file_empty_message));
        r1.showButton(true);
        r1.getButton().setText(getString(R.string.big_file_empty_button));
        r1.getButton().setOnClickListener(new BigFileListActivity$initEmptyStatusView$$inlined$apply$lambda$1(this));
        return;
    }

    private final void observe() {
        BigFileViewModel r0 = this.bigFileViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<ArrayList<BigFileScanResultItem>> r1 = r0.getBigFileList();
        if (r1 == null) goto L7;
        r1.observe(this, new C03571(this));
    L7:
        BigFileViewModel r2 = this.bigFileViewModel;
        if (r2 == null) goto L12;
        MutableLiveData<Boolean> r3 = r2.getSelectedChange();
        if (r3 == null) goto L12;
        r3.observe(this, new C03582(this));
    L12:
        BigFileViewModel r4 = this.bigFileViewModel;
        if (r4 == null) goto L18;
        MutableLiveData<Boolean> r5 = r4.getStartLoading();
        if (r5 == null) goto L19;
        r5.observe(this, new C03593(this));
        return;
    L19:
        return;
    }

    private final void updateBottomDeleteAction() {
        BigFileListAdapter r0 = this.adapter;
        if (r0 == null) goto L25;
        ArrayList<BigFileScanResultItem> r1 = r0.getDataList();
        if (r1 == null) goto L25;
        ArrayList<BigFileScanResultItem> r2 = r1;
        boolean r3 = true;
        if ((r2 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r4 = r2.iterator();
    L13:
        if (r4.hasNext() == false) goto L10;
        BigFileScanResultItem r5 = (BigFileScanResultItem) r4.next();
        BigFileViewModel r6 = this.bigFileViewModel;
        if (r6 == null) goto L19;
        HashMap<String, Boolean> r7 = r6.getSelectedItem();
        if (r7 == null) goto L19;
        Boolean r8 = r7.get(r5.mPath);
    L21:
        if (Intrinsics.areEqual(r8, true) == false) goto L13;
        boolean r9 = true;
    L23:
        if (r9 != true) goto L25;
    L26:
        OButtonFloating r10 = this.bottomClear;
        if (r10 == null) goto L29;
        r10.setEnabled(r3);
    L29:
        BigFileViewModel r11 = this.bigFileViewModel;
        if (r11 == null) goto L38;
        MutableLiveData<Boolean> r12 = r11.getSelectedChange();
        if (r12 == null) goto L39;
        r12.setValue(false);
        return;
    L39:
        return;
    L38:
        return;
    L19:
        r8 = null;
    L10:
        r9 = false;
        goto L23
    L9:
        if (r2.isEmpty() == false) goto L11;
    L25:
        r3 = false;
        goto L26
    }

    private final void launchDeleteConfirmDialog() {
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (isDestroyed() == true) goto L13;
        OAlertDialog r0 = getMenuDialog();
        if (r0 == null) goto L10;
        r0.show();
    L10:
        BDSecurityGuardUtils.INSTANCE.bdSettingsEventStart(this, BDSettingsEvent.EVENT_TYPE_JUNK_CLEAR.getType());
        return;
    }

    private final OAlertDialog getMenuDialog() {
        OAlertDialog r0 = this.mMenuDialog;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OAlertDialogBuilder r1 = new OAlertDialogBuilder(this).title(R.string.delete_file_dialog_title).message(R.string.delete_file_dialog_desc).overrideButtonStyleController(BigFileListActivity$getMenuDialog$builder$1.INSTANCE).horizontalButton(true);
        OAlertDialogBuilder.positiveButton$default(r1, R.string.dialog_delete_conform, new AnonymousClass1(this), null, 4, null);
        OAlertDialogBuilder.negativeButton$default(r1, R.string.cancel, new AnonymousClass2(this), null, 4, null);
        OAlertDialog r2 = r1.build();
        this.mMenuDialog = r2;
        if (r2 == null) goto L8;
        r2.setOnCancelListener(new AnonymousClass3(this));
    L8:
        OAlertDialog r3 = this.mMenuDialog;
        View r4 = null;
        if (r3 == null) goto L11;
        View r5 = r3.getPositiveButton();
    L13:
        if ((r5 instanceof OButton) == false) goto L16;
        r4 = r5;
    L16:
        OButton r6 = (OButton) r4;
        if (r6 == null) goto L19;
        r6.setTextColor(getColor(R.color.oui_on_accent_default));
    L19:
        if (r6 == null) goto L22;
        r6.setBackgroundColor(getColor(R.color.oui_functional_red_6));
    L22:
        return this.mMenuDialog;
    L11:
        r5 = null;
        goto L13
    }

    private final void showDeleteProgressDialog() {
        StatusDialog r0 = this.mProgressDialog;
        if (r0 == null) goto L8;
        if (r0 == null) goto L6;
        r0.dismiss();
    L6:
        StatusDialog r1 = (StatusDialog) null;
        this.mProgressDialog = null;
    L8:
        if (isFinishing() == false) goto L10;
        return;
    L10:
        if (isDestroyed() == true) goto L15;
        String r2 = getString(R.string.progress_dialog_deleting_big_file);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.progr…dialog_deleting_big_file)");
        StatusDialog.Modifier r3 = new StatusDialog.Modifier(r2, "", null, null);
        StatusDialog r4 = new StatusDialog(this, r3);
        this.mProgressDialog = r4;
        r4.show();
        return;
    }

    private final void handleDeleteBigFile() {
        BigFileViewModel r0 = this.bigFileViewModel;
        if (r0 == null) goto L10;
        BigFileListAdapter r1 = this.adapter;
        if (r1 == null) goto L7;
        ArrayList<BigFileScanResultItem> r2 = r1.getDataList();
    L8:
        Intrinsics.checkNotNull(r2);
        r0.deleteFiles(r2);
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        BigFileViewModel r0 = this.bigFileViewModel;
        if (r0 == null) goto L6;
        r0.m604getBigFileList();
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
        dismissDialogsIfShowing();
        OAlertDialog r1 = (OAlertDialog) null;
        this.mMenuDialog = null;
        super.onDestroy();
    }
}
