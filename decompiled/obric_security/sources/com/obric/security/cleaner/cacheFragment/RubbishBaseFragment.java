package com.obric.security.cleaner.cacheFragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.olog.OLog;
import com.obric.oui.actionbar.v2.OBottomActionBarFloating;
import com.obric.oui.button.OButtonFloating;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.material.MaterialConfigFormatNames;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OBaseTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.oui.titlebar.optimize.OCTitleBar;
import com.obric.oui.utils.StyleUtil;
import com.obric.security.R;
import com.obric.security.cleaner.CleanerDetailViewModel;
import com.obric.security.cleaner.cacheFragment.adapter.RubbishBaseAdapter;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import com.obric.security.monitor.PerformanceMonitors;
import com.obric.securitycenter.api.TrackUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import obric.widget.calendar.MonthWeekEventsView;
import tmsdk.fg.module.cleanV2.RubbishEntity;

/* JADX INFO: compiled from: RubbishBaseFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010D\u001a\u00020EH\u0002J\b\u0010F\u001a\u00020\u0004H\u0016J\n\u0010G\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010H\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010IH\u0016J\b\u0010K\u001a\u00020LH\u0016J\b\u0010M\u001a\u00020LH\u0016J\b\u0010N\u001a\u00020EH\u0002J\b\u0010O\u001a\u00020EH\u0016J\b\u0010P\u001a\u00020EH\u0016J&\u0010Q\u001a\u0004\u0018\u00010R2\u0006\u0010S\u001a\u00020T2\b\u0010U\u001a\u0004\u0018\u00010V2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020EH\u0016J\b\u0010Z\u001a\u00020EH\u0016J\b\u0010[\u001a\u00020EH\u0016J\u001a\u0010\\\u001a\u00020E2\u0006\u0010]\u001a\u00020R2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\u0006\u0010^\u001a\u00020EJ\b\u0010_\u001a\u00020\u0004H\u0016J\b\u0010`\u001a\u00020EH\u0002J\b\u0010a\u001a\u00020EH\u0002J\b\u0010b\u001a\u00020EH\u0002J\u0016\u0010c\u001a\u00020E2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020J0eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010/\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006f"}, d2 = {"Lcom/obric/security/cleaner/cacheFragment/RubbishBaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "TAG", "", "adapter", "Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "getAdapter", "()Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;", "setAdapter", "(Lcom/obric/security/cleaner/cacheFragment/adapter/RubbishBaseAdapter;)V", "bottomClear", "Lcom/obric/oui/button/OButtonFloating;", "getBottomClear", "()Lcom/obric/oui/button/OButtonFloating;", "setBottomClear", "(Lcom/obric/oui/button/OButtonFloating;)V", "bottomDeleteAction", "Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "getBottomDeleteAction", "()Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;", "setBottomDeleteAction", "(Lcom/obric/oui/actionbar/v2/OBottomActionBarFloating;)V", "listFpsSession", "Lcom/obric/security/monitor/PerformanceMonitors$FpsSceneSession;", "listFpsStarted", "", "mPendingDismissProgressDialog", "Ljava/lang/Runnable;", "mProgressDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "mProgressDialogShowAtUptimeMs", "", "mUiHandler", "Landroid/os/Handler;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "getRecyclerView", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "setRecyclerView", "(Lcom/obric/oui/orecyclerview/widget/RecyclerView;)V", "statusEmpty", "Lcom/obric/oui/status/OPageStatus;", "getStatusEmpty", "()Lcom/obric/oui/status/OPageStatus;", "setStatusEmpty", "(Lcom/obric/oui/status/OPageStatus;)V", "statusLoading", "getStatusLoading", "setStatusLoading", "titleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "getTitleBar", "()Lcom/obric/oui/titlebar/OFloatingTitleBar;", "setTitleBar", "(Lcom/obric/oui/titlebar/OFloatingTitleBar;)V", "trashClearHelper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "getTrashClearHelper", "()Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "setTrashClearHelper", "(Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;)V", "viewModel", "Lcom/obric/security/cleaner/CleanerDetailViewModel;", "getViewModel", "()Lcom/obric/security/cleaner/CleanerDetailViewModel;", "setViewModel", "(Lcom/obric/security/cleaner/CleanerDetailViewModel;)V", "dismissProgressDialogWithMinDuration", "", "fpsScene", "getListAdapter", "getRubbishList", "", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "getRubbishType", "", "getSelectCount", "initEmptyStatusView", "initRecycleView", "initTitleBar", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onPause", "onResume", "onViewCreated", "view", "requestData", "scene", "showDeleteProgressDialog", "startListFps", "stopListFps", "updateUI", "rubbishList", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public class RubbishBaseFragment extends Fragment {
    private final String TAG;
    private HashMap _$_findViewCache;
    private RubbishBaseAdapter adapter;
    private OButtonFloating bottomClear;
    private OBottomActionBarFloating bottomDeleteAction;
    private PerformanceMonitors.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private Runnable mPendingDismissProgressDialog;
    private StatusDialog mProgressDialog;
    private long mProgressDialogShowAtUptimeMs;
    private final Handler mUiHandler;
    private RecyclerView recyclerView;
    private OPageStatus statusEmpty;
    private OPageStatus statusLoading;
    private OFloatingTitleBar titleBar;
    private TcTrashClearHelper trashClearHelper;
    private CleanerDetailViewModel viewModel;

    /* JADX INFO: renamed from: com.obric.security.cleaner.cacheFragment.RubbishBaseFragment$onViewCreated$5, reason: invalid class name */
    /* JADX INFO: compiled from: RubbishBaseFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButtonFloating;", "styledContext", "Landroid/content/Context;", MaterialConfigFormatNames.WIDTH, "", MonthWeekEventsView.VIEW_PARAMS_HEIGHT, "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass5 extends Lambda implements Function3<Context, Integer, Integer, OButtonFloating> {
        final /* synthetic */ RubbishBaseFragment this$0;

        AnonymousClass5(RubbishBaseFragment r1) {
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
            String r12 = this.this$0.getString(R.string.clear_text);
            Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.clear_text)");
            r0.setTitle(r12);
            OBaseTextView r13 = r0.getTextView();
            OBottomActionBarFloating r1 = this.this$0.getBottomDeleteAction();
            Intrinsics.checkNotNull(r1);
            r13.setTextColor(r1.getContext().getColor(R.color.oui_red_6));
            r0.setLayoutParams(new ViewGroup.LayoutParams(r10, r11));
            r0.setOnClickListener(new RubbishBaseFragment$onViewCreated$5$$special$$inlined$apply$lambda$1(this, r10, r11));
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
        if (r0 != null) goto L13;
        View r1 = getView();
        if (r1 != null) goto L11;
        return null;
    L11:
        View r2 = r1.findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r2);
        return r2;
    L13:
        return r0;
    }

    public String fpsScene() {
        return "";
    }

    public RubbishBaseAdapter getListAdapter() {
        return null;
    }

    public Collection<RubbishEntity> getRubbishList() {
        return null;
    }

    public int getRubbishType() {
        return -1;
    }

    public String scene() {
        return "";
    }

    public RubbishBaseFragment() {
        this.TAG = "RubbishBaseFragment";
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    public static final /* synthetic */ StatusDialog access$getMProgressDialog$p(RubbishBaseFragment r0) {
        return r0.mProgressDialog;
    }

    public static final /* synthetic */ void access$setMProgressDialog$p(RubbishBaseFragment r0, StatusDialog r1) {
        r0.mProgressDialog = r1;
    }

    public static final /* synthetic */ void access$showDeleteProgressDialog(RubbishBaseFragment r0) {
        r0.showDeleteProgressDialog();
    }

    public static final /* synthetic */ void access$startListFps(RubbishBaseFragment r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(RubbishBaseFragment r0) {
        r0.stopListFps();
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    public final void setRecyclerView(RecyclerView r1) {
        this.recyclerView = r1;
    }

    public final OFloatingTitleBar getTitleBar() {
        return this.titleBar;
    }

    public final void setTitleBar(OFloatingTitleBar r1) {
        this.titleBar = r1;
    }

    public final OPageStatus getStatusEmpty() {
        return this.statusEmpty;
    }

    public final void setStatusEmpty(OPageStatus r1) {
        this.statusEmpty = r1;
    }

    public final OPageStatus getStatusLoading() {
        return this.statusLoading;
    }

    public final void setStatusLoading(OPageStatus r1) {
        this.statusLoading = r1;
    }

    public final OBottomActionBarFloating getBottomDeleteAction() {
        return this.bottomDeleteAction;
    }

    public final void setBottomDeleteAction(OBottomActionBarFloating r1) {
        this.bottomDeleteAction = r1;
    }

    public final RubbishBaseAdapter getAdapter() {
        return this.adapter;
    }

    public final void setAdapter(RubbishBaseAdapter r1) {
        this.adapter = r1;
    }

    public final OButtonFloating getBottomClear() {
        return this.bottomClear;
    }

    public final void setBottomClear(OButtonFloating r1) {
        this.bottomClear = r1;
    }

    public final TcTrashClearHelper getTrashClearHelper() {
        return this.trashClearHelper;
    }

    public final void setTrashClearHelper(TcTrashClearHelper r1) {
        this.trashClearHelper = r1;
    }

    public final CleanerDetailViewModel getViewModel() {
        return this.viewModel;
    }

    public final void setViewModel(CleanerDetailViewModel r1) {
        this.viewModel = r1;
    }

    private final void dismissProgressDialogWithMinDuration() {
        final StatusDialog r0 = this.mProgressDialog;
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.isShowing() == true) goto L9;
        StatusDialog r1 = (StatusDialog) null;
        this.mProgressDialog = null;
        return;
    L9:
        Runnable r2 = this.mPendingDismissProgressDialog;
        if (r2 == null) goto L12;
        this.mUiHandler.removeCallbacks(r2);
    L12:
        Runnable r3 = (Runnable) null;
        this.mPendingDismissProgressDialog = null;
        long r5 = 500 - (SystemClock.uptimeMillis() - this.mProgressDialogShowAtUptimeMs);
        if (r5 <= 0) goto L24;
        Runnable r4 = new RubbishBaseFragment$dismissProgressDialogWithMinDuration$r$1(this, r0);
        this.mPendingDismissProgressDialog = r4;
        this.mUiHandler.postDelayed(r4, r5);
        return;
    L24:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L16
        r0.dismiss();     // Catch: Throwable -> L16
        Result.m774constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L19:
        if (this.mProgressDialog != r0) goto L26;
        StatusDialog r7 = (StatusDialog) null;
        this.mProgressDialog = null;
        return;
    L26:
        return;
    L16:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    public void updateUI(List<? extends RubbishEntity> r5) {
        Intrinsics.checkNotNullParameter(r5, "rubbishList");
        boolean r1 = false;
        if (r5.isEmpty() == false) goto L13;
        OPageStatus r0 = this.statusEmpty;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        RecyclerView r2 = this.recyclerView;
        if (r2 == null) goto L10;
        r2.setVisibility(8);
    L10:
        OBottomActionBarFloating r3 = this.bottomDeleteAction;
        if (r3 == null) goto L22;
        r3.setVisibility(8);
    L22:
        StatusDialog r4 = this.mProgressDialog;
        if (r4 == null) goto L28;
        if (r4 == null) goto L28;
        if (r4.isShowing() != true) goto L28;
        dismissProgressDialogWithMinDuration();
    L28:
        RubbishBaseAdapter r6 = this.adapter;
        if (r6 == null) goto L31;
        r6.setData(r5);
    L31:
        OPageStatus r7 = this.statusLoading;
        if (r7 == null) goto L34;
        r7.setVisibility(8);
    L34:
        OButtonFloating r8 = this.bottomClear;
        if (r8 != null) goto L37;
        return;
    L37:
        if (getSelectCount() <= 0) goto L39;
        r1 = true;
    L39:
        r8.setEnabled(r1);
        return;
    L13:
        OPageStatus r9 = this.statusEmpty;
        if (r9 == null) goto L16;
        r9.setVisibility(8);
    L16:
        RecyclerView r10 = this.recyclerView;
        if (r10 == null) goto L19;
        r10.setVisibility(0);
    L19:
        OBottomActionBarFloating r11 = this.bottomDeleteAction;
        if (r11 == null) goto L22;
        r11.setVisibility(0);
        goto L22
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        return r1.inflate(R.layout.cleaner_detail_fragment, r2, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        String r6 = fpsScene();
        Object r2 = null;
        if ((!StringsKt.isBlank(r6)) == false) goto L5;
        PerformanceMonitors.FpsSceneSession r0 = new PerformanceMonitors.FpsSceneSession(r6);
    L6:
        this.listFpsSession = r0;
        Context r7 = r4.getContext();
        if ((r7 instanceof ViewModelStoreOwner) == false) goto L10;
        r2 = r7;
    L10:
        ViewModelStoreOwner r3 = (ViewModelStoreOwner) r2;
        if (r3 == null) goto L15;
        CleanerDetailViewModel r8 = (CleanerDetailViewModel) new ViewModelProvider(r3).get(CleanerDetailViewModel.class);
        this.viewModel = r8;
        if (r8 == null) goto L15;
        r8.setRubbishType(getRubbishType());
    L15:
        CleanerDetailViewModel r9 = this.viewModel;
        if (r9 == null) goto L20;
        MutableLiveData<ArrayList<RubbishEntity>> r10 = r9.getRubbishListLiveData();
        if (r10 == null) goto L20;
        r10.observe(getViewLifecycleOwner(), new AnonymousClass2(this));
    L20:
        CleanerDetailViewModel r11 = this.viewModel;
        if (r11 == null) goto L25;
        MutableLiveData<Boolean> r12 = r11.getSelectedChange();
        if (r12 == null) goto L25;
        r12.observe(getViewLifecycleOwner(), new AnonymousClass3(this));
    L25:
        CleanerDetailViewModel r13 = this.viewModel;
        if (r13 == null) goto L30;
        MutableLiveData<Boolean> r14 = r13.getCleanFinished();
        if (r14 == null) goto L30;
        r14.observe(getViewLifecycleOwner(), new AnonymousClass4(this));
    L30:
        this.recyclerView = (RecyclerView) r4.findViewById(R.id.list);
        this.titleBar = (OFloatingTitleBar) r4.findViewById(R.id.title_bar);
        this.statusEmpty = (OPageStatus) r4.findViewById(R.id.status_large);
        this.statusLoading = (OPageStatus) r4.findViewById(R.id.status_loading_s);
        OBottomActionBarFloating r15 = (OBottomActionBarFloating) r4.findViewById(R.id.bottom_delete_action);
        this.bottomDeleteAction = r15;
        if (r15 == null) goto L33;
        r15.applyMaskMaterial(false);
    L33:
        OBottomActionBarFloating r16 = this.bottomDeleteAction;
        if (r16 == null) goto L36;
        r16.setVisibility(8);
    L36:
        OBottomActionBarFloating r17 = this.bottomDeleteAction;
        Intrinsics.checkNotNull(r17);
        Context r18 = r17.getContext();
        Intrinsics.checkNotNullExpressionValue(r18, "bottomDeleteAction!!.context");
        OButtonFloating r19 = (OButtonFloating) StyleUtil.createWidgetWithStyle(r18, 2131821333, new AnonymousClass5(this));
        this.bottomClear = r19;
        OBottomActionBarFloating r20 = this.bottomDeleteAction;
        if (r20 == null) goto L43;
        List<? extends View> r21 = CollectionsKt.listOf(r19);
        if (r21 == null) goto L42;
        r20.setButtons(r21);
        goto L43
    L42:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<android.view.View>");
    L43:
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(getContext(), "");
        OLog.d("DeepScanCallBack", "onCreate:deepScan");
        OPageStatus r22 = this.statusLoading;
        if (r22 == null) goto L46;
        r22.showLoading(true);
        r22.setTitle(getString(R.string.blue_button_scanning));
    L46:
        initRecycleView();
        initEmptyStatusView();
        initTitleBar();
        requestData();
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        stopListFps();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        stopListFps();
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        r0.clearOnScrollListeners();
    L5:
        PerformanceMonitors.FpsSceneSession r1 = (PerformanceMonitors.FpsSceneSession) null;
        this.listFpsSession = null;
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void initTitleBar() {
        OFloatingTitleBar r0 = this.titleBar;
        if (r0 == null) goto L8;
        View r1 = OFloatingTitleBar.addStartAction$default(r0, OCTitleBar.Companion.getBACK_ICON_RES(), 0, null, 6, null);
        if (r1 == null) goto L9;
        r1.setOnClickListener(new ViewOnClickListenerC03651(this));
        return;
    L9:
        return;
    }

    public int getSelectCount() {
        RubbishBaseAdapter r0 = this.adapter;
        int r1 = 0;
        if (r0 == null) goto L14;
        List<RubbishEntity> r2 = r0.getDataList();
        if (r2 == null) goto L14;
        Iterator<T> r3 = r2.iterator();
    L8:
        if (r3.hasNext() == false) goto L14;
        RubbishEntity r4 = (RubbishEntity) r3.next();
        CleanerDetailViewModel r5 = this.viewModel;
        if (r5 == null) goto L8;
        if (r5.isSelected(r4) != true) goto L8;
        r1 = r1 + 1;
    L14:
        return r1;
    }

    private final void showDeleteProgressDialog() {
        Runnable r0 = this.mPendingDismissProgressDialog;
        if (r0 == null) goto L5;
        this.mUiHandler.removeCallbacks(r0);
    L5:
        Runnable r1 = (Runnable) null;
        this.mPendingDismissProgressDialog = null;
        StatusDialog r2 = this.mProgressDialog;
        if (r2 == null) goto L10;
        if (r2 == null) goto L9;
        r2.dismiss();
    L9:
        StatusDialog r3 = (StatusDialog) null;
        this.mProgressDialog = null;
    L10:
        String r4 = getString(R.string.progress_dialog_deleting_cache);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.progress_dialog_deleting_cache)");
        StatusDialog.Modifier r5 = new StatusDialog.Modifier(r4, "", null, null);
        Context r6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(r6, "requireContext()");
        StatusDialog r7 = new StatusDialog(r6, r5);
        this.mProgressDialog = r7;
        r7.show();
        this.mProgressDialogShowAtUptimeMs = SystemClock.uptimeMillis();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        TrackUtils.trackEvent$default(TrackUtils.INSTANCE, "page_show", MapsKt.mapOf(TuplesKt.to(TraceStatsConsts.PAGE_STATS_KEY_PAGE_NAME, scene())), false, 4, null);
    }

    public final void requestData() {
        CleanerDetailViewModel r0 = this.viewModel;
        if (r0 == null) goto L6;
        r0.requestData();
        return;
    }

    public void initRecycleView() {
        RecyclerView r0 = this.recyclerView;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        this.adapter = getListAdapter();
        RecyclerView r1 = this.recyclerView;
        if (r1 == null) goto L8;
        r1.setLayoutManager(new LinearLayoutManager(getContext()));
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
        r5.addOnScrollListener(new AnonymousClass1(this));
        return;
    }

    private final void startListFps() {
        PerformanceMonitors.FpsSceneSession r0 = this.listFpsSession;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.listFpsStarted == false) goto L8;
        return;
    L8:
        this.listFpsStarted = true;
        r0.start();
    }

    private final void stopListFps() {
        PerformanceMonitors.FpsSceneSession r0 = this.listFpsSession;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.listFpsStarted == true) goto L8;
        return;
    L8:
        this.listFpsStarted = false;
        r0.stop();
    }

    private final void initEmptyStatusView() {
        OPageStatus r0 = this.statusEmpty;
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        OPageStatus r1 = this.statusEmpty;
        if (r1 == null) goto L9;
        r1.setTitle(getString(R.string.no_cache_to_clean));
        return;
    }
}
