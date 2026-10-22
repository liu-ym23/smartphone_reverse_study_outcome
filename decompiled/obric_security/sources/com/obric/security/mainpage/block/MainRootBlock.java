package com.obric.security.mainpage.block;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.blockframework.framework.base.UIBlock;
import com.bytedance.blockframework.framework.core.BlockGenerator;
import com.bytedance.blockframework.framework.core.IBlockModel;
import com.bytedance.blockframework.framework.core.SubBlockCreator;
import com.bytedance.blockframework.framework.join.IBlockContext;
import com.obric.security.R;
import com.obric.security.mainpage.MainViewModel;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MainRootBlock.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/security/mainpage/block/MainRootBlock;", "Lcom/bytedance/blockframework/framework/base/UIBlock;", "Ljava/util/Objects;", "Lcom/bytedance/blockframework/framework/core/IBlockModel;", "rootView", "Landroid/view/ViewGroup;", "blockContext", "Lcom/bytedance/blockframework/framework/join/IBlockContext;", "(Landroid/view/ViewGroup;Lcom/bytedance/blockframework/framework/join/IBlockContext;)V", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "rotatePannelViewContainer", "Landroid/widget/LinearLayout;", "typeContainer", "Landroid/view/View;", "generateSubBlocks", "", "generator", "Lcom/bytedance/blockframework/framework/core/BlockGenerator;", "layoutResource", "", "onCreateView", "parent", "onPause", "onResume", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class MainRootBlock extends UIBlock<Objects, IBlockModel<Objects>> {
    private MainViewModel mainViewModel;
    private final ViewGroup rootView;
    private LinearLayout rotatePannelViewContainer;
    private View typeContainer;

    /* JADX INFO: renamed from: com.obric.security.mainpage.block.MainRootBlock$generateSubBlocks$1, reason: invalid class name */
    /* JADX INFO: compiled from: MainRootBlock.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/bytedance/blockframework/framework/core/SubBlockCreator;", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass1 extends Lambda implements Function1<SubBlockCreator, Unit> {
        final /* synthetic */ MainRootBlock this$0;

        AnonymousClass1(MainRootBlock r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SubBlockCreator r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SubBlockCreator r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.addBlock(new C00701(this));
            r2.addBlock(new AnonymousClass2(this));
            r2.addBlock(new AnonymousClass3(this));
            r2.addBlock(new AnonymousClass4(this));
            r2.addBlock(new AnonymousClass5(this));
            r2.addBlock(new AnonymousClass6(this));
            r2.addBlock(new AnonymousClass7(this));
        }
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock
    public int layoutResource() {
        return -1;
    }

    public MainRootBlock(ViewGroup r2, IBlockContext r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "blockContext");
        super(r3);
        this.rootView = r2;
    }

    @Override // com.bytedance.blockframework.framework.base.UIBlock, com.bytedance.blockframework.framework.base.IUIBlock
    public View onCreateView(View r2) {
        this.typeContainer = this.rootView.findViewById(R.id.type_container);
        this.rotatePannelViewContainer = (LinearLayout) this.rootView.findViewById(R.id.rotate_pannel_view_container);
        return this.rootView;
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onResume() {
        super.onResume();
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock, com.bytedance.blockframework.contract.AbstractLifecycleBlock
    public void onPause() {
        super.onPause();
    }

    @Override // com.bytedance.blockframework.framework.base.BaseBlock
    public void generateSubBlocks(BlockGenerator r2) {
        Intrinsics.checkNotNullParameter(r2, "generator");
        r2.generate(new AnonymousClass1(this));
    }
}
