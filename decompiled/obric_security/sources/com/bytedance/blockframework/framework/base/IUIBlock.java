package com.bytedance.blockframework.framework.base;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;

/* JADX INFO: compiled from: IUIBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H&J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/blockframework/framework/base/IUIBlock;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "getContainerView", "()Landroid/view/View;", "setContainerView", "(Landroid/view/View;)V", "uiConfig", "Lcom/bytedance/blockframework/framework/base/UIBlockConfig;", "getUiConfig", "()Lcom/bytedance/blockframework/framework/base/UIBlockConfig;", "customGenerateView", "", "currentView", "parent", "getView", "onCreateView", "onViewCreated", "", "view", "Companion", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IUIBlock extends LayoutContainer {
    public static final Companion Companion = null;
    public static final int USE_PARENT_LAYOUT = -1;

    /* JADX INFO: compiled from: IUIBlock.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/blockframework/framework/base/IUIBlock$Companion;", "", "()V", "USE_PARENT_LAYOUT", "", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int USE_PARENT_LAYOUT = -1;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IUIBlock.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static boolean customGenerateView(IUIBlock r0, View r1, View r2) {
            Intrinsics.checkNotNullParameter(r1, "currentView");
            return false;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean customGenerateView(View r1, View r2);

    @Override // kotlinx.android.extensions.LayoutContainer
    View getContainerView();

    UIBlockConfig getUiConfig();

    View getView();

    View onCreateView(View r1);

    void onViewCreated(View r1);

    void setContainerView(View r1);
}
