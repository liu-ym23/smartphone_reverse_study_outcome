package com.obric.security.cleaner;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Window;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.securitycenter.SecurityCenterApplication;
import com.obric.apm.ApmHelper;
import com.obric.security.R;
import com.obric.security.cleaner.bigfile.ImageLoadHelper;
import com.obric.security.cleaner.trashclear.CleanStatusCallBack;
import com.obric.security.cleaner.trashclear.DeepScanCallBack;
import com.obric.security.cleaner.trashclear.TcTrashClearHelper;
import com.obric.security.tcsecurity.cleansdk.CleanSDK;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import tmsdk.fg.module.cleanV2.RubbishEntity;
import tmsdk.fg.module.cleanV2.RubbishHolder;

/* JADX INFO: compiled from: CleanerDetailViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u001cJ\u001e\u00103\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00142\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\u0013J\u001e\u00106\u001a\u0002022\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;J \u0010<\u001a\u0002022\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00052\b\b\u0002\u0010@\u001a\u00020%J\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u000202J\u0016\u0010C\u001a\u0002022\u0006\u00105\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R'\u0010\u0019\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00140\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R9\u0010#\u001a*\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&0$j\u0014\u0012\u0004\u0012\u00020%\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0&`(¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006D"}, d2 = {"Lcom/obric/security/cleaner/CleanerDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "agreeGrant", "Landroidx/lifecycle/MutableLiveData;", "", "getAgreeGrant", "()Landroidx/lifecycle/MutableLiveData;", "callBack", "Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "getCallBack", "()Lcom/obric/security/cleaner/trashclear/CleanStatusCallBack;", "cleanFinished", "getCleanFinished", "deepScanCallBack", "com/obric/security/cleaner/CleanerDetailViewModel$deepScanCallBack$1", "Lcom/obric/security/cleaner/CleanerDetailViewModel$deepScanCallBack$1;", "rubbishList", "Ljava/util/ArrayList;", "Ltmsdk/fg/module/cleanV2/RubbishEntity;", "Lkotlin/collections/ArrayList;", "getRubbishList", "()Ljava/util/ArrayList;", "setRubbishList", "(Ljava/util/ArrayList;)V", "rubbishListLiveData", "getRubbishListLiveData", "rubbishType", "", "getRubbishType", "()I", "setRubbishType", "(I)V", "selectedChange", "getSelectedChange", "softRubbishGroup", "Ljava/util/HashMap;", "", "", "Lcom/obric/security/cleaner/RubbishEntityWrapper;", "Lkotlin/collections/HashMap;", "getSoftRubbishGroup", "()Ljava/util/HashMap;", "trashClearHelper", "Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "getTrashClearHelper", "()Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;", "setTrashClearHelper", "(Lcom/obric/security/cleaner/trashclear/TcTrashClearHelper;)V", "clearSelected", "", "getRubbishes", "isSelected", "rubbishEntity", "loadAppIconFromApk", "context", "Landroid/content/Context;", "apkPath", "iconView", "Landroid/widget/ImageView;", "popPermissionDialogIfNeeded", "activity", "Lcom/bytedanceos/security/BaseActivity;", "isAllowed", "from", "removeCallBack", "requestData", "updateSelectedItem", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class CleanerDetailViewModel extends ViewModel {
    private final MutableLiveData<Boolean> agreeGrant;
    private final CleanStatusCallBack callBack;
    private final MutableLiveData<Boolean> cleanFinished;
    private final CleanerDetailViewModel$deepScanCallBack$1 deepScanCallBack;
    private ArrayList<RubbishEntity> rubbishList;
    private final MutableLiveData<ArrayList<RubbishEntity>> rubbishListLiveData;
    private int rubbishType;
    private final MutableLiveData<Boolean> selectedChange;
    private final HashMap<String, List<RubbishEntityWrapper>> softRubbishGroup;
    private TcTrashClearHelper trashClearHelper;

    /* JADX INFO: renamed from: com.obric.security.cleaner.CleanerDetailViewModel$loadAppIconFromApk$1, reason: invalid class name */
    /* JADX INFO: compiled from: CleanerDetailViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.CleanerDetailViewModel$loadAppIconFromApk$1", f = "CleanerDetailViewModel.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apkPath;
        final /* synthetic */ ImageView $iconView;
        int label;

        /* JADX INFO: renamed from: com.obric.security.cleaner.CleanerDetailViewModel$loadAppIconFromApk$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: CleanerDetailViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.cleaner.CleanerDetailViewModel$loadAppIconFromApk$1$1", f = "CleanerDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $drawable;
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            C00541(AnonymousClass1 r1, Ref.ObjectRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$drawable = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00541(this.this$0, this.$drawable, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00541) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.this$0.$iconView.setImageDrawable((Drawable) this.$drawable.element);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(String r1, ImageView r2, Continuation r3) {
            this.$apkPath = r1;
            this.$iconView = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.$apkPath, this.$iconView, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, android.graphics.drawable.Drawable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Ref.ObjectRef r7 = new Ref.ObjectRef();
            r7.element = ImageLoadHelper.INSTANCE.getAppIconFromApk(this.$apkPath);
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00541 r3 = new C00541(this, r7, null);
            this.label = 1;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.obric.security.cleaner.CleanerDetailViewModel$deepScanCallBack$1] */
    public CleanerDetailViewModel() {
        this.agreeGrant = new MutableLiveData();
        this.selectedChange = new MutableLiveData();
        this.cleanFinished = new MutableLiveData();
        this.rubbishListLiveData = new MutableLiveData();
        this.rubbishList = new ArrayList();
        this.rubbishType = -1;
        this.deepScanCallBack = new CleanerDetailViewModel$deepScanCallBack$1(this);
        this.callBack = new CleanerDetailViewModel$callBack$1(this);
        this.softRubbishGroup = new HashMap();
    }

    public final MutableLiveData<Boolean> getAgreeGrant() {
        return this.agreeGrant;
    }

    public final TcTrashClearHelper getTrashClearHelper() {
        return this.trashClearHelper;
    }

    public final void setTrashClearHelper(TcTrashClearHelper r1) {
        this.trashClearHelper = r1;
    }

    public final MutableLiveData<Boolean> getSelectedChange() {
        return this.selectedChange;
    }

    public final MutableLiveData<Boolean> getCleanFinished() {
        return this.cleanFinished;
    }

    public final MutableLiveData<ArrayList<RubbishEntity>> getRubbishListLiveData() {
        return this.rubbishListLiveData;
    }

    public final ArrayList<RubbishEntity> getRubbishList() {
        return this.rubbishList;
    }

    public final void setRubbishList(ArrayList<RubbishEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.rubbishList = r2;
    }

    public final int getRubbishType() {
        return this.rubbishType;
    }

    public final void setRubbishType(int r1) {
        this.rubbishType = r1;
    }

    public static /* synthetic */ void popPermissionDialogIfNeeded$default(CleanerDetailViewModel r0, BaseActivity r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = "";
    L5:
        r0.popPermissionDialogIfNeeded(r1, r2, r3);
    }

    public final void popPermissionDialogIfNeeded(final BaseActivity r8, boolean r9, String r10) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r10, "from");
        if (GrantUtil.INSTANCE.isAllowed(r8, r10, false) == true) goto L5;
        GrantUtil.requestGrant$default(GrantUtil.INSTANCE, r8, new C03541(this, r8), r10, false, 8, null);
        return;
    L5:
        CleanSDK.INSTANCE.initCleanSDK();
        Context r11 = r8.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r11, "activity.applicationContext");
        ApmHelper.onPrivacyApproved(r11);
        Window r12 = r8.getWindow();
        Intrinsics.checkNotNullExpressionValue(r12, "activity.window");
        r12.getDecorView().postDelayed(new AnonymousClass2(this), 0);
    }

    public final CleanStatusCallBack getCallBack() {
        return this.callBack;
    }

    public final void requestData() {
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L9;
        r0.deepScan(this.deepScanCallBack, false);
        return;
    }

    public final void removeCallBack() {
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L5;
        r0.removeScanStatusCallBack(this.deepScanCallBack);
    L5:
        TcTrashClearHelper r1 = this.trashClearHelper;
        if (r1 == null) goto L9;
        r1.removeCleanStatusCallBack(this.callBack);
        return;
    }

    public final HashMap<String, List<RubbishEntityWrapper>> getSoftRubbishGroup() {
        return this.softRubbishGroup;
    }

    public final void updateSelectedItem(RubbishEntity r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "rubbishEntity");
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L12;
        DeepScanCallBack r1 = r0.deepScanCallBack;
        if (r1 == null) goto L12;
        HashMap<RubbishEntity, Boolean> r2 = r1.uiSelectedItem;
        if (r2 == null) goto L12;
        r2.put(r4, Boolean.valueOf(r5));
    L12:
        this.selectedChange.postValue(true);
    }

    public final boolean isSelected(RubbishEntity r4) {
        Intrinsics.checkNotNullParameter(r4, "rubbishEntity");
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r3 = this.trashClearHelper;
        if (r3 == null) goto L15;
        DeepScanCallBack r5 = r3.deepScanCallBack;
        if (r5 == null) goto L16;
        HashMap<RubbishEntity, Boolean> r6 = r5.uiSelectedItem;
        if (r6 == null) goto L17;
        Boolean r7 = r6.getOrDefault(r4, false);
        if (r7 != null) goto L14;
        return false;
    L14:
        return r7.booleanValue();
    L17:
        return false;
    L16:
        return false;
    L15:
        return false;
    }

    public final ArrayList<RubbishEntity> getRubbishes(int r4) {
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        ArrayList<RubbishEntity> r0 = new ArrayList();
        if (r4 != 0) goto L13;
        TcTrashClearHelper r3 = this.trashClearHelper;
        if (r3 == null) goto L11;
        ArrayList r5 = r3.getSoftCacheRubbish();
        if (r5 == null) goto L11;
    L34:
        r0.addAll(r5);
        return r0;
    L11:
        r5 = new ArrayList();
        goto L34
    L13:
        if (4 != r4) goto L20;
        TcTrashClearHelper r6 = this.trashClearHelper;
        if (r6 == null) goto L18;
        r5 = r6.getUninstallRubbish();
        if (r5 != null) goto L34;
    L18:
        r5 = new ArrayList();
        goto L34
    L20:
        if (2 != r4) goto L27;
        TcTrashClearHelper r7 = this.trashClearHelper;
        if (r7 == null) goto L25;
        r5 = r7.getApkRubbish();
        if (r5 != null) goto L34;
    L25:
        r5 = new ArrayList();
        goto L34
    L27:
        if (1 != r4) goto L33;
        TcTrashClearHelper r8 = this.trashClearHelper;
        if (r8 == null) goto L32;
        r5 = r8.getSystemRubbish();
        if (r5 != null) goto L34;
    L32:
        r5 = new ArrayList();
        goto L34
    L33:
        r5 = new ArrayList();
        goto L34
    }

    public final void clearSelected(int r6) {
        if (this.trashClearHelper != null) goto L5;
        this.trashClearHelper = TcTrashClearHelper.Companion.getInstance(SecurityCenterApplication.getContext(), "");
    L5:
        TcTrashClearHelper r0 = this.trashClearHelper;
        if (r0 == null) goto L10;
        DeepScanCallBack r1 = r0.deepScanCallBack;
        if (r1 == null) goto L10;
        RubbishHolder r2 = r1.currentRubbish;
    L11:
        ArrayList<RubbishEntity> r7 = getRubbishes(r6);
        if (r7 == null) goto L29;
        Iterator<RubbishEntity> r8 = r7.iterator();
    L15:
        if (r8.hasNext() == false) goto L29;
        RubbishEntity r3 = r8.next();
        boolean r4 = r3.isSuggest();
        TcTrashClearHelper r5 = this.trashClearHelper;
        if (r5 == null) goto L24;
        DeepScanCallBack r9 = r5.deepScanCallBack;
        if (r9 == null) goto L24;
        HashMap<RubbishEntity, Boolean> r10 = r9.uiSelectedItem;
        if (r10 == null) goto L24;
        Boolean r11 = r10.getOrDefault(r3, Boolean.valueOf(r4));
        if (r11 == null) goto L24;
    L25:
        Intrinsics.checkNotNullExpressionValue(r11, "trashClearHelper?.deepSc…, isSuggest) ?: isSuggest");
        if (r11.booleanValue() == true) goto L27;
        r3.setStatus(0);
        goto L15
    L27:
        r3.setStatus(1);
    L24:
        r11 = Boolean.valueOf(r4);
    L29:
        TcTrashClearHelper r12 = this.trashClearHelper;
        if (r12 == null) goto L39;
        r12.cleanRubbish(r2, this.callBack);
        return;
    L39:
        return;
    L10:
        r2 = null;
        goto L11
    }

    public final void loadAppIconFromApk(Context r9, String r10, ImageView r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "apkPath");
        Intrinsics.checkNotNullParameter(r11, "iconView");
        ImageLoadHelper.INSTANCE.loadLocalResourceImage(r9, R.drawable.apk, r11);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(r10, r11, null), 2, null);
    }
}
