package xl;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;
import com.bytedance.ies.bullet.ui.common.AbsBulletContainerActivity;
import com.bytedance.ies.bullet.ui.common.BulletContainerView;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ActionSheetBuilderAction;
import com.bytedance.sdk.xbridge.cn.runtime.depend.DialogBuilder;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.PageTitleBar;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ShowActionSheetListener;
import com.bytedance.sdk.xbridge.cn.runtime.depend.ToastBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements IHostStyleUIDepend {
    public static void a() {
        ConcurrentHashMap r5 = com.ivy.ivykit.api.bridge.b.f9471a;
        Intrinsics.checkNotNullParameter(nl.e.class, "clazz");
        if (com.ivy.ivykit.api.bridge.b.f9471a.get(nl.e.class) != null) goto L6;
        return;
    L6:
        throw new ClassCastException();
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean hideLoading(cj.d r5) {
        if (r5 == null) goto L18;
        Activity r10 = r5.mo118c();
        if (r10 == null) goto L18;
        BulletContainerView r11 = (BulletContainerView) dn.a.I(r5, BulletContainerView.class);
        if (r10.isFinishing() == true) goto L12;
        if (r11 == null) goto L12;
        com.bytedance.ies.bullet.service.base.b.a(6, "message:BulletContainerView dispatchHideLoading", null);
        r11.k();
        return Boolean.TRUE;
    L12:
        if ((r10 instanceof AbsBulletContainerActivity) == false) goto L15;
        ((AbsBulletContainerActivity) r10).isFinishing();
        return Boolean.TRUE;
    L15:
        a();
        return Boolean.FALSE;
    L18:
        return Boolean.FALSE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final void setPageNaviStyle(cj.d r5, Activity r10, PageTitleBar r11) {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showActionSheet(ActionSheetBuilder r11, ShowActionSheetListener r12) {
        Intrinsics.checkNotNullParameter(r11, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r12, "showActionSheetListener");
        Context r5 = r11.getContext();
        String r10 = r11.getTitle();
        String r13 = r11.getSubtitle();
        List<ActionSheetBuilderAction> r14 = r11.getActions();
        ArrayList r15 = new ArrayList(CollectionsKt.h(r14));
        Iterator<T> r16 = r14.iterator();
    L4:
        if (r16.hasNext() == false) goto L6;
        ActionSheetBuilderAction r17 = (ActionSheetBuilderAction) r16.next();
        r15.add(new com.ivy.ivykit.api.bridge.inject.ActionSheetBuilderAction(r17.getTitle(), r17.getSubtitle(), r17.getType()));
        goto L4
    L6:
        new com.ivy.ivykit.api.bridge.inject.ActionSheetBuilder(r5, r10, r13, r15);
        a();
        Intrinsics.checkNotNullParameter(r11, "actionSheetBuilder");
        Intrinsics.checkNotNullParameter(r12, "showActionSheetListener");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showDialog(DialogBuilder r11) {
        Intrinsics.checkNotNullParameter(r11, "dialogBuilder");
        new com.ivy.ivykit.api.bridge.inject.DialogBuilder(r11.getContext(), r11.getTitle(), r11.getMessage(), r11.getPositiveBtnText(), r11.getPositiveClickListener(), r11.getNegativeBtnText(), r11.getNegativeClickListener(), r11.getCancelListener(), r11.getCancelOnTouchOutside());
        a();
        Intrinsics.checkNotNullParameter(r11, "dialogBuilder");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(ji.a r5, cj.d r10) {
        Intrinsics.checkNotNullParameter(null, "showLoadingParams");
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showToast(ToastBuilder r5) {
        Intrinsics.checkNotNullParameter(r5, "toastBuilder");
        String r10 = r5.getMessage();
        if (r10 == null) goto L6;
        a();
        Toast.makeText(r5.getContext(), r10, 0).show();
    L6:
        return Boolean.TRUE;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostStyleUIDepend
    public final Boolean showLoading(cj.d r5) {
        if (r5 == null) goto L18;
        Activity r10 = r5.mo118c();
        if (r10 == null) goto L18;
        BulletContainerView r11 = (BulletContainerView) dn.a.I(r5, BulletContainerView.class);
        if (r10.isFinishing() == true) goto L12;
        if (r11 == null) goto L12;
        com.bytedance.ies.bullet.service.base.b.a(6, "message:BulletContainerView dispatchShowLoading", null);
        r11.l();
        return Boolean.TRUE;
    L12:
        if ((r10 instanceof AbsBulletContainerActivity) == false) goto L15;
        ((AbsBulletContainerActivity) r10).isFinishing();
        return Boolean.TRUE;
    L15:
        a();
        return Boolean.FALSE;
    L18:
        return Boolean.FALSE;
    }
}
