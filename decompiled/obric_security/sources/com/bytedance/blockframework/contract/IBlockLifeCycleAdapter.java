package com.bytedance.blockframework.contract;

import androidx.lifecycle.LifecycleObserver;
import com.bytedance.apm.constant.AgentConstants;
import com.bytedance.blockframework.contract.AbstractLifecycleBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IBlockLifeCycleAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u001e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/bytedance/blockframework/contract/IBlockLifeCycleAdapter;", "B", "Lcom/bytedance/blockframework/contract/AbstractLifecycleBlock;", "Landroidx/lifecycle/LifecycleObserver;", "blockList", "", "getBlockList", "()Ljava/util/List;", "setBlockList", "(Ljava/util/List;)V", "addLifecycleObserve", "", "block", "(Lcom/bytedance/blockframework/contract/AbstractLifecycleBlock;)V", "onCreate", "onDestroy", "onPause", "onResume", AgentConstants.ON_START, "onStop", "removeLifecycleObserve", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBlockLifeCycleAdapter<B extends AbstractLifecycleBlock> extends LifecycleObserver {

    /* JADX INFO: compiled from: IBlockLifeCycleAdapter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static <B extends AbstractLifecycleBlock> void onCreate(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void onDestroy(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void onPause(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void onResume(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void onStart(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void onStop(IBlockLifeCycleAdapter<B> r0) {
        }

        public static <B extends AbstractLifecycleBlock> void addLifecycleObserve(IBlockLifeCycleAdapter<B> r1, B r2) {
            Intrinsics.checkNotNullParameter(r2, "block");
            r1.getBlockList().add(r2);
        }

        public static <B extends AbstractLifecycleBlock> void removeLifecycleObserve(IBlockLifeCycleAdapter<B> r1, B r2) {
            Intrinsics.checkNotNullParameter(r2, "block");
            r1.getBlockList().remove(r2);
        }
    }

    void addLifecycleObserve(B r1);

    List<B> getBlockList();

    void onCreate();

    void onDestroy();

    void onPause();

    void onResume();

    void onStart();

    void onStop();

    void removeLifecycleObserve(B r1);

    void setBlockList(List<B> r1);
}
