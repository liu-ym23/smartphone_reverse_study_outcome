package com.bytedance.blockframework.contract;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.blockframework.contract.AbstractLifecycleBlock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBlockLifeCycleAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0017J\b\u0010\u000e\u001a\u00020\rH\u0017J\b\u0010\u000f\u001a\u00020\rH\u0017J\b\u0010\u0010\u001a\u00020\rH\u0017J\b\u0010\u0011\u001a\u00020\rH\u0017J\b\u0010\u0012\u001a\u00020\rH\u0017R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/blockframework/contract/BaseBlockLifeCycleAdapter;", "B", "Lcom/bytedance/blockframework/contract/AbstractLifecycleBlock;", "Lcom/bytedance/blockframework/contract/IBlockLifeCycleAdapter;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "blockList", "", "getBlockList", "()Ljava/util/List;", "setBlockList", "(Ljava/util/List;)V", "onCreate", "", "onDestroy", "onPause", "onResume", AgentConstants.ON_START, "onStop", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseBlockLifeCycleAdapter<B extends AbstractLifecycleBlock> implements IBlockLifeCycleAdapter<B>, LifecycleObserver {
    private List<B> blockList;

    public BaseBlockLifeCycleAdapter() {
        this.blockList = new ArrayList();
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    public void addLifecycleObserve(B r1) {
        IBlockLifeCycleAdapter.DefaultImpls.addLifecycleObserve(this, r1);
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    public void removeLifecycleObserve(B r1) {
        IBlockLifeCycleAdapter.DefaultImpls.removeLifecycleObserve(this, r1);
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    public List<B> getBlockList() {
        return this.blockList;
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    public void setBlockList(List<B> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockList = r2;
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performCreate();
        goto L4
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performStart();
        goto L4
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performResume();
        goto L4
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performPause();
        goto L4
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performStop();
        goto L4
    }

    @Override // com.bytedance.blockframework.contract.IBlockLifeCycleAdapter
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        Iterator<T> r2 = getBlockList().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        AbstractLifecycleBlock r0 = (AbstractLifecycleBlock) r2.next();
        if (r0.isActive() == false) goto L4;
        r0.performDestroy();
        goto L4
    }
}
