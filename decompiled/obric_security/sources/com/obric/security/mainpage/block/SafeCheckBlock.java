package com.obric.security.mainpage.block;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.safecheck.riskcontrol.ui.RiskControlRuntimeDependencies;
import com.obric.security.R;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import obric.util.DisplayHelper;

/* JADX INFO: compiled from: SafeCheckBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/security/mainpage/block/SafeCheckBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "icon", "Landroid/widget/ImageView;", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "title", "bindModel", "", "model", "layoutResource", "", "onDestroy", "onResume", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SafeCheckBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> {
    public static final Companion Companion = null;
    private static final String TAG = "SafeCheckBlock";
    private ImageView icon;
    private OTextView label;
    private final CoroutineScope mainScope;
    private OTextView title;

    /* JADX INFO: compiled from: SafeCheckBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/security/mainpage/block/SafeCheckBlock$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.security.mainpage.block.SafeCheckBlock$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: SafeCheckBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.mainpage.block.SafeCheckBlock$onResume$1", f = "SafeCheckBlock.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;
        final /* synthetic */ SafeCheckBlock this$0;

        AnonymousClass1(SafeCheckBlock r1, Context r2, Continuation r3) {
            this.this$0 = r1;
            this.$context = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, this.$context, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r5);     // Catch: Exception -> L7
        L15:
            int r6 = ((Number) r5).intValue();     // Catch: Exception -> L7
        L18:
            OTextView r2 = SafeCheckBlock.access$getLabel$p(this.this$0);
            if (r2 == null) goto L25;
            if (r6 <= 0) goto L22;
            String r4 = this.$context.getString(R.string.safe_check_has_risk);
        L23:
            r2.setText(r4);
            goto L25
        L22:
            r4 = this.$context.getString(R.string.safe_check_no_risk);
        L25:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r5);
            CoroutineDispatcher r7 = RiskControlRuntimeDependencies.INSTANCE.getIoDispatcher();     // Catch: Exception -> L7
            SafeCheckBlock$onResume$1$riskCount$1 r3 = new SafeCheckBlock$onResume$1$riskCount$1(this, null);     // Catch: Exception -> L7
            this.label = 1;     // Catch: Exception -> L7
            r5 = BuildersKt.withContext(r7, r3, this);     // Catch: Exception -> L7
            if (r5 != r0) goto L15;
            return r0;
        L7:
            e = move-exception;
            Log.w(SafeCheckBlock.TAG, "get uncontrolled risk app count failed", e);
            r6 = 0;
            goto L18
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    public SafeCheckBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.mainScope = CoroutineScopeKt.MainScope();
    }

    public static final /* synthetic */ OTextView access$getLabel$p(SafeCheckBlock r0) {
        return r0.label;
    }

    public static final /* synthetic */ void access$setLabel$p(SafeCheckBlock r0, OTextView r1) {
        r0.label = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((KeyFeatureModel) r1);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        this.icon = (ImageView) r4.findViewById(R.id.icon);
        this.title = (OTextView) r4.findViewById(R.id.title);
        this.label = (OTextView) r4.findViewById(R.id.label);
        ImageView r0 = this.icon;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        r0.setImageDrawable(AppCompatResources.getDrawable(r0.getContext(), R.drawable.safe_check));
    L5:
        OTextView r3 = this.title;
        View r1 = null;
        if (r3 == null) goto L14;
        if (r3 == null) goto L11;
        Context r2 = r3.getContext();
        if (r2 == null) goto L11;
        String r5 = r2.getString(R.string.safe_check);
    L12:
        r3.setText(r5);
    L11:
        r5 = null;
    L14:
        if ((r4 instanceof OUILinearLayout) == false) goto L17;
        r1 = r4;
    L17:
        OUILinearLayout r6 = (OUILinearLayout) r1;
        if (r6 == null) goto L20;
        r6.setRadius(DisplayHelper.dpToPx(16));
    L20:
        r4.setOnClickListener(new ViewOnClickListenerC03881(r4));
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        OTextView r0 = this.label;
        if (r0 == null) goto L9;
        Context r1 = r0.getContext();
        if (r1 == null) goto L10;
        BuildersKt.launch$default(this.mainScope, null, null, new AnonymousClass1(this, r1, null), 3, null);
        return;
    L10:
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
        CoroutineScopeKt.cancel$default(this.mainScope, null, 1, null);
        super.onDestroy();
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }
}
