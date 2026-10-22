package com.bytedance.blockframework.contract;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import com.bytedance.blockframework.interaction.StateAndEventModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AbstractBlockManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J!\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0019¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH&J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rH&J\u000e\u0010!\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rJ\b\u0010\"\u001a\u00020\u001cH\u0016J\u000e\u0010#\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/bytedance/blockframework/contract/AbstractBlockManager;", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "context", "Landroid/content/Context;", "blockBlockMessageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "(Landroid/content/Context;Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;)V", "getBlockBlockMessageCenter", "()Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "setBlockBlockMessageCenter", "(Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;)V", "blockList", "", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "getBlockList", "()Ljava/util/List;", "setBlockList", "(Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getBlockService", ExifInterface.GPS_DIRECTION_TRUE, "klass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "onPrepared", "", "onRegisterBlock", "block", "onUnRegister", "onUnregisterBlock", "registerBlock", "unregisterAllBlock", "unregisterBlock", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractBlockManager extends StateAndEventModel {
    private IBlockMessageCenter blockBlockMessageCenter;
    private List<AbstractBlock> blockList;
    private Context context;

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public void onPrepared() {
    }

    public abstract void onRegisterBlock(AbstractBlock r1);

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public void onUnRegister() {
    }

    public abstract void onUnregisterBlock(AbstractBlock r1);

    public AbstractBlockManager(Context r2, IBlockMessageCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "blockBlockMessageCenter");
        this.context = r2;
        this.blockBlockMessageCenter = r3;
        this.blockList = new ArrayList();
    }

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public IBlockMessageCenter getBlockBlockMessageCenter() {
        return this.blockBlockMessageCenter;
    }

    public final Context getContext() {
        return this.context;
    }

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public void setBlockBlockMessageCenter(IBlockMessageCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockBlockMessageCenter = r2;
    }

    public final void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final List<AbstractBlock> getBlockList() {
        return this.blockList;
    }

    public final void setBlockList(List<AbstractBlock> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockList = r2;
    }

    public final void registerBlock(AbstractBlock r3) {
        Intrinsics.checkNotNullParameter(r3, "block");
        if (this.blockList.contains(r3) == false) goto L5;
        return;
    L5:
        this.blockList.add(r3);
        r3.performInstall(this.context, getBlockBlockMessageCenter());
        onRegisterBlock(r3);
        r3.onPrepared();
    }

    public void unregisterAllBlock() {
        Iterator<AbstractBlock> r0 = this.blockList.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        AbstractBlock r1 = r0.next();
        r1.performUnRegister();
        onUnregisterBlock(r1);
        r0.remove();
        goto L4
    }

    public final void unregisterBlock(AbstractBlock r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.blockList.remove(r2);
        r2.performUnRegister();
        onUnregisterBlock(r2);
    }

    public final <T> T getBlockService(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "klass");
        return (T) IBlockMessageCenter.DefaultImpls.queryService$default(getBlockBlockMessageCenter(), r4, false, 2, null);
    }
}
