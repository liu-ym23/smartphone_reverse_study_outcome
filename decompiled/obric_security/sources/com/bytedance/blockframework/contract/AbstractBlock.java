package com.bytedance.blockframework.contract;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.interaction.Event;
import com.bytedance.blockframework.interaction.IBlockMessageCenter;
import com.bytedance.blockframework.interaction.IObserver;
import com.bytedance.blockframework.interaction.IStatusProvider;
import com.bytedance.blockframework.interaction.StateAndEventModel;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: AbstractBlock.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0015H&J-\u0010\u0016\u001a\u0004\u0018\u0001H\u0017\"\u0004\b\u0000\u0010\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0006H&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u0011H\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\u0016\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/bytedance/blockframework/contract/AbstractBlock;", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "Lcom/bytedance/blockframework/interaction/IObserver;", "Lcom/bytedance/blockframework/interaction/Event;", "()V", "DEBUG", "", "TAG", "", "kotlin.jvm.PlatformType", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "clearEvent", "", "clearService", "clearState", "defineBlockService", "Ljava/lang/Class;", "getBlockService", ExifInterface.GPS_DIRECTION_TRUE, "klass", "activeIfNeed", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "isActive", "onEvent", "event", "onPrepared", "onUnRegister", "performInstall", "_context", "messageCenter", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "performUnRegister", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractBlock extends StateAndEventModel implements IObserver<Event> {
    private final boolean DEBUG;
    private final String TAG;
    public Context context;

    public abstract Class<?> defineBlockService();

    public abstract boolean isActive();

    @Override // com.bytedance.blockframework.interaction.IObserver
    public boolean onEvent(Event r1) {
        Intrinsics.checkNotNullParameter(r1, "event");
        return false;
    }

    public AbstractBlock() {
        this.TAG = getClass().getSimpleName();
        this.DEBUG = BlockLogger.Companion.debug();
    }

    public Context getContext() {
        Context r0 = this.context;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    public void setContext(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.context = r2;
    }

    public final void performInstall(Context r2, IBlockMessageCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "_context");
        Intrinsics.checkNotNullParameter(r3, "messageCenter");
        setContext(r2);
        setBlockBlockMessageCenter(r3);
        Class<?> r4 = defineBlockService();
        if (r4 == null) goto L6;
        getBlockBlockMessageCenter().registerService(r4, new BlockImplWrapper(this));
        return;
    }

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public void onPrepared() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onActive");
        return;
    }

    public final void performUnRegister() {
        clearState();
        clearEvent();
        clearService();
        onUnRegister();
    }

    public static /* synthetic */ Object getBlockService$default(AbstractBlock r0, Class r1, boolean r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 2) == 0) goto L7;
        r2 = true;
    L7:
        return r0.getBlockService(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBlockService");
    }

    public <T> T getBlockService(Class<T> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "klass");
        return (T) getBlockBlockMessageCenter().queryService(this, r2, r3);
    }

    private final void clearState() {
        Iterator<T> r0 = getProviders().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IStatusProvider r1 = (IStatusProvider) r0.next();
        getBlockBlockMessageCenter().unregisterStateProvider(r1);
        goto L4
    L6:
        getProviders().clear();
    }

    private final void clearEvent() {
        Iterator<T> r0 = getObservers().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        IObserver<Event> r1 = (IObserver) r0.next();
        getBlockBlockMessageCenter().unregisterObserver(r1);
        goto L4
    L6:
        getObservers().clear();
    }

    private final void clearService() {
        Map<Class<?>, BlockImplWrapper> r0 = getBlockBlockMessageCenter().getBlockServiceMap();
        Class<?> r1 = defineBlockService();
        TypeIntrinsics.asMutableMap(r0).remove(r1);
    }

    @Override // com.bytedance.blockframework.interaction.StateAndEventModel
    public void onUnRegister() {
        if (this.DEBUG == false) goto L6;
        BlockLogger.Companion r0 = BlockLogger.Companion;
        String r2 = this.TAG;
        Intrinsics.checkNotNullExpressionValue(r2, "TAG");
        r0.log(r2, "onInactive");
        return;
    }
}
