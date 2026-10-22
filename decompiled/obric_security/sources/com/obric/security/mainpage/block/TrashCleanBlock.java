package com.obric.security.mainpage.block;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OTextView;
import com.obric.security.R;
import com.obric.security.mainpage.MainViewModel;
import com.obric.security.mainpage.block.depend.IHolderBlockDepend;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.obric.security.mainpage.delegate.data.KeyFeatureModel;
import com.obric.security.service.SecurityServiceBinder;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import obric.util.DisplayHelper;

/* JADX INFO: compiled from: TrashCleanBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000b\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001(B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/security/mainpage/block/TrashCleanBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureModel;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "agreeGrantObserver", "Landroidx/lifecycle/Observer;", "", "eventCallback", "com/obric/security/mainpage/block/TrashCleanBlock$eventCallback$1", "Lcom/obric/security/mainpage/block/TrashCleanBlock$eventCallback$1;", "holderDepend", "Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "getHolderDepend", "()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "holderDepend$delegate", "Lkotlin/properties/ReadOnlyProperty;", "icon", "Landroid/widget/ImageView;", "isPause", PushLog.KEY_LABEL, "Lcom/obric/oui/text/OTextView;", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "securityCenterService", "Lcom/obric/security/service/SecurityServiceBinder;", "title", "bindModel", "", "model", "layoutResource", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class TrashCleanBlock extends UIBlock<KeyFeatureData, KeyFeatureModel> {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private static boolean CLICK_ENTER_TRASH_CLEAN;
    public static final Companion Companion = null;
    private Observer<Boolean> agreeGrantObserver;
    private TrashCleanBlock$eventCallback$1 eventCallback;
    private final ReadOnlyProperty holderDepend$delegate;
    private ImageView icon;
    private boolean isPause;
    private OTextView label;
    private MainViewModel mainViewModel;
    private SecurityServiceBinder securityCenterService;
    private OTextView title;

    /* JADX INFO: compiled from: TrashCleanBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/security/mainpage/block/TrashCleanBlock$Companion;", "", "()V", "CLICK_ENTER_TRASH_CLEAN", "", "getCLICK_ENTER_TRASH_CLEAN", "()Z", "setCLICK_ENTER_TRASH_CLEAN", "(Z)V", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final boolean getCLICK_ENTER_TRASH_CLEAN() {
            return TrashCleanBlock.access$getCLICK_ENTER_TRASH_CLEAN$cp();
        }

        public final void setCLICK_ENTER_TRASH_CLEAN(boolean r1) {
            TrashCleanBlock.access$setCLICK_ENTER_TRASH_CLEAN$cp(r1);
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(TrashCleanBlock.class, "holderDepend", "getHolderDepend()Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", 0))};
        Companion = new Companion(null);
    }

    private final IHolderBlockDepend getHolderDepend() {
        return (IHolderBlockDepend) this.holderDepend$delegate.getValue(this, $$delegatedProperties[0]);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return R.layout.key_feature_item_block;
    }

    public TrashCleanBlock(IBlockContext r2) {
        Intrinsics.checkNotNullParameter(r2, "blockContext");
        super(r2);
        this.holderDepend$delegate = new TrashCleanBlock$$special$$inlined$findDepend$1(this);
        this.agreeGrantObserver = new TrashCleanBlock$agreeGrantObserver$1(this);
        this.eventCallback = new TrashCleanBlock$eventCallback$1(this);
    }

    public static final /* synthetic */ boolean access$getCLICK_ENTER_TRASH_CLEAN$cp() {
        return CLICK_ENTER_TRASH_CLEAN;
    }

    public static final /* synthetic */ OTextView access$getLabel$p(TrashCleanBlock r0) {
        return r0.label;
    }

    public static final /* synthetic */ SecurityServiceBinder access$getSecurityCenterService$p(TrashCleanBlock r0) {
        return r0.securityCenterService;
    }

    public static final /* synthetic */ OTextView access$getTitle$p(TrashCleanBlock r0) {
        return r0.title;
    }

    public static final /* synthetic */ void access$setCLICK_ENTER_TRASH_CLEAN$cp(boolean r0) {
        CLICK_ENTER_TRASH_CLEAN = r0;
    }

    public static final /* synthetic */ void access$setLabel$p(TrashCleanBlock r0, OTextView r1) {
        r0.label = r1;
    }

    public static final /* synthetic */ void access$setSecurityCenterService$p(TrashCleanBlock r0, SecurityServiceBinder r1) {
        r0.securityCenterService = r1;
    }

    public static final /* synthetic */ void access$setTitle$p(TrashCleanBlock r0, OTextView r1) {
        r0.title = r1;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public /* bridge */ /* synthetic */ void bindModel(IBlockModel r1) {
        bindModel((KeyFeatureModel) r1);
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public void onViewCreated(final View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        SecurityServiceBinder r0 = SecurityServiceBinder.Companion.getInstance();
        this.securityCenterService = r0;
        if (r0 == null) goto L5;
        r0.onCreate();
    L5:
        SecurityServiceBinder r1 = this.securityCenterService;
        if (r1 == null) goto L8;
        r1.subscribe(this.eventCallback);
    L8:
        this.mainViewModel = MainViewModel.Companion.getMainViewModel(r5.getContext());
        this.icon = (ImageView) r5.findViewById(R.id.icon);
        this.title = (OTextView) r5.findViewById(R.id.title);
        this.label = (OTextView) r5.findViewById(R.id.label);
        ImageView r2 = this.icon;
        if (r2 == null) goto L11;
        Intrinsics.checkNotNull(r2);
        r2.setImageDrawable(AppCompatResources.getDrawable(r2.getContext(), R.drawable.trash_clean));
    L11:
        OTextView r3 = this.title;
        View r4 = null;
        if (r3 == null) goto L19;
        if (r3 == null) goto L17;
        Context r6 = r3.getContext();
        if (r6 == null) goto L17;
        String r7 = r6.getString(R.string.clean_trash);
    L18:
        r3.setText(r7);
    L17:
        r7 = null;
    L19:
        OTextView r8 = this.label;
        if (r8 == null) goto L29;
        OTextView r9 = this.title;
        if (r9 == null) goto L26;
        Context r10 = r9.getContext();
        if (r10 == null) goto L26;
        String r11 = r10.getString(R.string.clean_trash_label);
    L27:
        r8.setText(r11);
    L26:
        r11 = null;
    L29:
        if ((r5 instanceof OUILinearLayout) == false) goto L32;
        r4 = r5;
    L32:
        OUILinearLayout r12 = (OUILinearLayout) r4;
        if (r12 == null) goto L35;
        r12.setRadius(DisplayHelper.dpToPx(16));
    L35:
        r5.setOnClickListener(new AnonymousClass1(r5));
        MainViewModel r13 = this.mainViewModel;
        if (r13 == null) goto L44;
        MutableLiveData<Boolean> r14 = r13.getAgreeGrant();
        if (r14 == null) goto L45;
        Context r15 = r5.getContext();
        if (r15 == null) goto L43;
        r14.observe((FragmentActivity) r15, this.agreeGrantObserver);
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L45:
        return;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L7;
        Boolean r2 = r1.getValue();
    L9:
        if (Intrinsics.areEqual(r2, true) == true) goto L11;
    L17:
        CLICK_ENTER_TRASH_CLEAN = false;
        this.isPause = false;
        return;
    L11:
        if (this.isPause == false) goto L17;
        if (CLICK_ENTER_TRASH_CLEAN == false) goto L17;
        SecurityServiceBinder r3 = this.securityCenterService;
        if (r3 == null) goto L17;
        r3.startScanTrashAndMem();
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
        this.isPause = true;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onDestroy() {
        super.onDestroy();
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L7;
        r1.removeObserver(this.agreeGrantObserver);
    L7:
        SecurityServiceBinder r2 = this.securityCenterService;
        if (r2 == null) goto L11;
        r2.unsubscribe(this.eventCallback);
        return;
    }

    public void bindModel(KeyFeatureModel r1) {
        super.bindModel(r1);
    }
}
