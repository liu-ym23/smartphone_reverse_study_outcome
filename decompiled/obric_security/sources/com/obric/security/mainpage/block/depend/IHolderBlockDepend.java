package com.obric.security.mainpage.block.depend;

import android.view.View;
import com.bytedance.blockframework.framework.join.IBlockDepend;
import kotlin.Metadata;

/* JADX INFO: compiled from: IHolderBlockDepend.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/security/mainpage/block/depend/IHolderBlockDepend;", "Lcom/bytedance/blockframework/framework/join/IBlockDepend;", "enableAsyncBind", "", "getHolderView", "Landroid/view/View;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface IHolderBlockDepend extends IBlockDepend {
    boolean enableAsyncBind();

    View getHolderView();
}
