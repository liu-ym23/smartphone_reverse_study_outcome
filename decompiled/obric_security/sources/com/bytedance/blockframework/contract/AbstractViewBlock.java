package com.bytedance.blockframework.contract;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.blockframework.interaction.BaseBlockMessageCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractViewBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00028\u0001¢\u0006\u0002\u0010\u0007J!\u0010\f\u001a\u0002H\u0003\"\b\b\u0002\u0010\u0003*\u00020\u00042\b\b\u0001\u0010\r\u001a\u00020\u000eH\u0004¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H&R\u0014\u0010\b\u001a\u00028\u00018DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0006\u001a\u00028\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/blockframework/contract/AbstractViewBlock;", "M", "Lcom/bytedance/blockframework/interaction/BaseBlockMessageCenter;", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/view/View;", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "mContentView", "(Landroid/view/View;)V", "contentView", "getContentView", "()Landroid/view/View;", "Landroid/view/View;", "findViewById", SlardarConfigConsts.CONFIG_ID, "", "(I)Landroid/view/View;", "getView", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractViewBlock<M extends BaseBlockMessageCenter, T extends View> extends AbstractBlock {
    private final T mContentView;

    public abstract View getView();

    public AbstractViewBlock(T r2) {
        Intrinsics.checkNotNullParameter(r2, "mContentView");
        this.mContentView = r2;
    }

    protected final T getContentView() {
        return this.mContentView;
    }

    protected final <T extends View> T findViewById(int r1) {
        T r0 = (T) this.mContentView.findViewById(r1);
        Intrinsics.checkNotNullExpressionValue(r0, "mContentView.findViewById(id)");
        return r0;
    }
}
