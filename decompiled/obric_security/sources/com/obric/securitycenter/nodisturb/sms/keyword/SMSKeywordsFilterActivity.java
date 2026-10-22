package com.obric.securitycenter.nodisturb.sms.keyword;

import android.content.ContentResolver;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.oui.button.OButton;
import com.obric.oui.dialog.base.OBaseDialog;
import com.obric.oui.dialog.v2.misc.OSimpleFormDialog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.security.monitor.PerformanceScenes;
import com.obric.securitycenter.nodisturb.BaseActivity;
import com.obric.securitycenter.nodisturb.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: SMSKeywordsFilterActivity.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0002J\b\u0010 \u001a\u00020\u0016H\u0002J\b\u0010!\u001a\u00020\u0016H\u0002J\f\u0010\"\u001a\u00020\u0016*\u00020\u0012H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/obric/securitycenter/nodisturb/sms/keyword/SMSKeywordsFilterActivity;", "Lcom/obric/securitycenter/nodisturb/BaseActivity;", "()V", "adapter", "Lcom/obric/securitycenter/nodisturb/sms/keyword/KeywordAdapter;", "addKeywordDialog", "Lcom/obric/oui/dialog/v2/misc/OSimpleFormDialog;", "emptyAddBtn", "Lcom/obric/oui/button/OButton;", "emptyGroup", "Landroidx/constraintlayout/widget/Group;", "listFpsSession", "Lcom/obric/securitycenter/nodisturb/BaseActivity$FpsSceneSession;", "listFpsStarted", "", "mTitle", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewModel", "Lcom/obric/securitycenter/nodisturb/sms/keyword/SMSKeywordFilterViewModel;", "addKeyword", "", "observe", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "scene", "", "showNormalTitleButton", "startListFps", "stopListFps", "removeItemAnimatorTemporary", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SMSKeywordsFilterActivity extends BaseActivity {
    private KeywordAdapter adapter;
    private OSimpleFormDialog addKeywordDialog;
    private OButton emptyAddBtn;
    private Group emptyGroup;
    private final BaseActivity.FpsSceneSession listFpsSession;
    private boolean listFpsStarted;
    private OFloatingTitleBar mTitle;
    private RecyclerView recyclerView;
    private SMSKeywordFilterViewModel viewModel;

    public static /* synthetic */ void $r8$lambda$2l3syuTkQgXUYhZz9NQ8VG8TdJw(RecyclerView r0, RecyclerView.ItemAnimator r1) {
        removeItemAnimatorTemporary$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$8rg2fJjuopgu99Y0y5DtiyQdJnw(Function1 r0, Object r1) {
        observe$lambda$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$GOuVOdV0W5SJDfkNcAjONdleOfc(SMSKeywordsFilterActivity r0, View r1) {
        onCreate$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$MRWk97vP0mCz7Hrh4HTtrbHs_eg(SMSKeywordsFilterActivity r0, View r1) {
        showNormalTitleButton$lambda$2(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$_MlNgrt3b5m1ktr-7O5wP69XCxM, reason: not valid java name */
    public static /* synthetic */ void m617$r8$lambda$_MlNgrt3b5m1ktr7O5wP69XCxM(Function1 r0, Object r1) {
        observe$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$vVJJJVlgcOnAPb6--kLkXwmz-FA, reason: not valid java name */
    public static /* synthetic */ void m618$r8$lambda$vVJJJVlgcOnAPb6kLkXwmzFA(SMSKeywordsFilterActivity r0, View r1) {
        showNormalTitleButton$lambda$1(r0, r1);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity
    public String scene() {
        return "sms_keyword_setting_page";
    }

    public SMSKeywordsFilterActivity() {
        this.listFpsSession = new BaseActivity.FpsSceneSession(PerformanceScenes.FPS_NODISTURB_SMS_KEYWORD_LIST);
    }

    public static final /* synthetic */ KeywordAdapter access$getAdapter$p(SMSKeywordsFilterActivity r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ Group access$getEmptyGroup$p(SMSKeywordsFilterActivity r0) {
        return r0.emptyGroup;
    }

    public static final /* synthetic */ RecyclerView access$getRecyclerView$p(SMSKeywordsFilterActivity r0) {
        return r0.recyclerView;
    }

    public static final /* synthetic */ SMSKeywordFilterViewModel access$getViewModel$p(SMSKeywordsFilterActivity r0) {
        return r0.viewModel;
    }

    public static final /* synthetic */ void access$startListFps(SMSKeywordsFilterActivity r0) {
        r0.startListFps();
    }

    public static final /* synthetic */ void access$stopListFps(SMSKeywordsFilterActivity r0) {
        r0.stopListFps();
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r5) {
        super.onCreate(r5);
        setContentView(R.layout.sms_keyword_filter_layout);
        initTitleBar(false, false);
        getWindow().setStatusBarColor(0);
        View r0 = findViewById(R.id.title_bar);
        Intrinsics.checkNotNull(r0);
        this.mTitle = (OFloatingTitleBar) r0;
        this.viewModel = (SMSKeywordFilterViewModel) new ViewModelProvider(this).get(SMSKeywordFilterViewModel.class);
        View r1 = findViewById(R.id.keyword_list);
        Intrinsics.checkNotNull(r1);
        RecyclerView r2 = (RecyclerView) r1;
        this.recyclerView = r2;
        SMSKeywordFilterViewModel r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r2 = null;
    L5:
        r2.setClipToPadding(false);
        View r6 = findViewById(R.id.empty_group);
        Intrinsics.checkNotNull(r6);
        this.emptyGroup = (Group) r6;
        View r7 = findViewById(R.id.empty_add);
        Intrinsics.checkNotNull(r7);
        this.emptyAddBtn = (OButton) r7;
        this.adapter = new KeywordAdapter(new C03921(this));
        GridLayoutManager r8 = new GridLayoutManager(this, 2);
        r8.setSpanSizeLookup(new C03932(this));
        RecyclerView r4 = this.recyclerView;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r4 = null;
    L8:
        r4.setLayoutManager(r8);
        RecyclerView r9 = this.recyclerView;
        if (r9 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r9 = null;
    L11:
        KeywordAdapter r10 = this.adapter;
        if (r10 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r10 = null;
    L14:
        r9.setAdapter(r10);
        RecyclerView r11 = this.recyclerView;
        if (r11 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r11 = null;
    L17:
        r11.addOnScrollListener(new AnonymousClass3(this));
        OButton r12 = this.emptyAddBtn;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("emptyAddBtn");
        r12 = null;
    L20:
        r12.setOnClickListener(new SMSKeywordsFilterActivity$$ExternalSyntheticLambda2(this));
        observe();
        SMSKeywordFilterViewModel r13 = this.viewModel;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L23:
        ContentResolver r14 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r14, "contentResolver");
        r13.observeProvider(r14);
        SMSKeywordFilterViewModel r15 = this.viewModel;
        if (r15 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L27:
        ContentResolver r16 = getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r16, "contentResolver");
        r3.refreshKeywords(r16);
        showNormalTitleButton();
        return;
    L26:
        r3 = r15;
        goto L27
    }

    private static final void onCreate$lambda$0(SMSKeywordsFilterActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.addKeyword();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        stopListFps();
        super.onPause();
    }

    private final void showNormalTitleButton() {
        this.mTitle.removeStartAction();
        this.mTitle.removeEndAction();
        this.mTitle.addStartAction(R.drawable.o_floating_title_bar_icon_back, -1, new SMSKeywordsFilterActivity$$ExternalSyntheticLambda3(this));
        OFloatingTitleBar r4 = this.mTitle;
        Intrinsics.checkNotNullExpressionValue(r4, "mTitle");
        OFloatingTitleBar.addEndAction$default(r4, R.drawable.icon_add, 0, null, 6, null).setOnClickListener(new SMSKeywordsFilterActivity$$ExternalSyntheticLambda4(this));
        this.mTitle.setCenterTitle(getString(R.string.sms_keyword_filter_title));
    }

    private static final void showNormalTitleButton$lambda$1(SMSKeywordsFilterActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.finish();
    }

    private static final void showNormalTitleButton$lambda$2(SMSKeywordsFilterActivity r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.addKeyword();
    }

    private final void addKeyword() {
        final Ref.ObjectRef r1 = new Ref.ObjectRef();
        String r2 = getString(R.string.add_keyword);
        String r3 = getString(R.string.add_keyword_tips);
        OSimpleFormDialog.InputViewConfig r10 = new OSimpleFormDialog.InputViewConfig(true, false, new SMSKeywordsFilterActivity$addKeyword$modifier$1(r1, this), 2, null);
        String r12 = getString(R.string.keyword_empty_add);
        Intrinsics.checkNotNullExpressionValue(r12, "getString(R.string.keyword_empty_add)");
        DefaultConstructorMarker r16 = null;
        OBaseDialog.ButtonConfig r9 = new OBaseDialog.ButtonConfig(r12, new SMSKeywordsFilterActivity$addKeyword$modifier$2(r1, this), null, 4, r16);
        String r4 = getString(R.string.btn_cancel);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.btn_cancel)");
        OBaseDialog.ButtonConfig r5 = new OBaseDialog.ButtonConfig(r4, SMSKeywordsFilterActivity$addKeyword$modifier$3.INSTANCE, null, 4, null);
        OSimpleFormDialog.InputViewConfig r8 = new OSimpleFormDialog.InputViewConfig(false, false, SMSKeywordsFilterActivity$addKeyword$modifier$4.INSTANCE, 2, r16);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.add_keyword)");
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.add_keyword_tips)");
        OSimpleFormDialog.Modifier r11 = new OSimpleFormDialog.Modifier(r2, r3, r10, r8, r9, r5);
        OSimpleFormDialog r6 = this.addKeywordDialog;
        if (r6 == null) goto L5;
        r6.hide();
    L5:
        OSimpleFormDialog r7 = new OSimpleFormDialog(this, r11);
        r7.show();
        this.addKeywordDialog = r7;
    }

    private final void observe() {
        SMSKeywordFilterViewModel r0 = this.viewModel;
        SMSKeywordFilterViewModel r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        MutableLiveData<List<KeywordItem>> r2 = r0.getKeywords();
        SMSKeywordsFilterActivity r3 = this;
        final Function1<List<? extends KeywordItem>, Unit> r4 = new AnonymousClass1(this);
        r2.observe(r3, new SMSKeywordsFilterActivity$$ExternalSyntheticLambda0(r4));
        SMSKeywordFilterViewModel r5 = this.viewModel;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L9:
        MutableLiveData<List<KeywordItem>> r6 = r1.getKeywords();
        final Function1<List<? extends KeywordItem>, Unit> r7 = new AnonymousClass2(this);
        r6.observe(r3, new SMSKeywordsFilterActivity$$ExternalSyntheticLambda1(r7));
        return;
    L8:
        r1 = r5;
        goto L9
    }

    private static final void observe$lambda$4(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke(r2);
    }

    private static final void observe$lambda$5(Function1 r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "$tmp0");
        r1.invoke(r2);
    }

    private final void removeItemAnimatorTemporary(final RecyclerView r4) {
        final RecyclerView.ItemAnimator r3 = r4.getItemAnimator();
        if (r3 == null) goto L6;
        r4.setItemAnimator(null);
        r4.postDelayed(new SMSKeywordsFilterActivity$$ExternalSyntheticLambda5(r4, r3), r3.getChangeDuration());
        return;
    }

    private static final void removeItemAnimatorTemporary$lambda$7$lambda$6(RecyclerView r1, RecyclerView.ItemAnimator r2) {
        Intrinsics.checkNotNullParameter(r1, "$this_removeItemAnimatorTemporary");
        Intrinsics.checkNotNullParameter(r2, "$preItemAnimator");
        r1.setItemAnimator(r2);
    }

    @Override // com.obric.securitycenter.nodisturb.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        stopListFps();
        SMSKeywordFilterViewModel r0 = this.viewModel;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r0 = null;
    L5:
        r0.unobserveProvider();
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
}
