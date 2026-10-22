package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.contract.BlockImplWrapper;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: compiled from: IBlockMessageCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u0010H'¢\u0006\u0002\u0010\u0013J'\u0010\u000e\u001a\u00020\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u0013J'\u0010\u0017\u001a\u00020\u000f\"\b\b\u0000\u0010\u0010*\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u0002H\u0010H&¢\u0006\u0002\u0010\u0016J5\u0010\u0018\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0014\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u000fH&¢\u0006\u0002\u0010\u001cJ-\u0010\u0018\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\b\b\u0002\u0010\u001b\u001a\u00020\u000fH'¢\u0006\u0002\u0010\u001dJ'\u0010\u001e\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u000b2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0004H&¢\u0006\u0002\u0010 J$\u0010!\u001a\u00020\"\"\u0004\b\u0000\u0010\u00102\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00042\u0006\u0010#\u001a\u00020\u0005H&J \u0010$\u001a\u00020\"\"\b\b\u0000\u0010\u0010*\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00100\fH&J0\u0010&\u001a\u00020\"\"\b\b\u0000\u0010\u0010*\u00020\u00112\u000e\u0010'\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00100(2\f\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0004H&J\u0016\u0010*\u001a\u00020\"2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110(H&J \u0010+\u001a\u00020\"\"\b\b\u0000\u0010\u0010*\u00020\u000b2\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u00100\fH&R(\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR.\u0010\n\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007¨\u0006,"}, d2 = {"Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "", "blockServiceMap", "", "Ljava/lang/Class;", "Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "getBlockServiceMap", "()Ljava/util/Map;", "setBlockServiceMap", "(Ljava/util/Map;)V", "stateProviderMap", "Lcom/bytedance/blockframework/interaction/State;", "Lcom/bytedance/blockframework/interaction/IStatusProvider;", "getStateProviderMap", "notifyEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/interaction/Event;", "event", "(Lcom/bytedance/blockframework/interaction/Event;)Z", "block", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "(Lcom/bytedance/blockframework/interaction/StateAndEventModel;Lcom/bytedance/blockframework/interaction/Event;)Z", "notifyEventForResult", "queryService", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "klass", "activeIfNeed", "(Lcom/bytedance/blockframework/contract/AbstractBlock;Ljava/lang/Class;Z)Ljava/lang/Object;", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "queryState", "stateClass", "(Ljava/lang/Class;)Lcom/bytedance/blockframework/interaction/State;", "registerService", "", "blockImplWrapper", "registerStateProvider", "provider", "subscribeEvent", "observer", "Lcom/bytedance/blockframework/interaction/IObserver;", "eventClass", "unregisterObserver", "unregisterStateProvider", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IBlockMessageCenter {

    /* JADX INFO: compiled from: IBlockMessageCenter.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Object queryService$default(IBlockMessageCenter r0, Class r1, boolean r2, int r3, Object r4) {
            if (r4 != null) goto L9;
            if ((r3 & 2) == 0) goto L7;
            r2 = true;
        L7:
            return r0.queryService(r1, r2);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryService");
        }

        public static /* synthetic */ Object queryService$default(IBlockMessageCenter r0, AbstractBlock r1, Class r2, boolean r3, int r4, Object r5) {
            if (r5 != null) goto L9;
            if ((r4 & 4) == 0) goto L7;
            r3 = true;
        L7:
            return r0.queryService(r1, r2, r3);
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queryService");
        }
    }

    Map<Class<?>, BlockImplWrapper> getBlockServiceMap();

    Map<Class<? extends State>, IStatusProvider<? extends State>> getStateProviderMap();

    @Deprecated(message = "use Block.notifyEvent(event: T) or notifyEvent(block: StateAndEventModel, event: T)")
    <T extends Event> boolean notifyEvent(T r1);

    <T extends Event> boolean notifyEvent(StateAndEventModel r1, T r2);

    <T extends Event> boolean notifyEventForResult(T r1);

    <T extends Event> boolean notifyEventForResult(StateAndEventModel r1, T r2);

    <T> T queryService(AbstractBlock r1, Class<T> r2, boolean r3);

    @Deprecated(message = "use block.getBlockService(klass: Class<T>) or queryService(block: AbstractBlock, klass: Class<T>)")
    <T> T queryService(Class<T> r1, boolean r2);

    <T extends State> T queryState(Class<T> r1);

    <T> void registerService(Class<T> r1, BlockImplWrapper r2);

    <T extends State> void registerStateProvider(IStatusProvider<T> r1);

    void setBlockServiceMap(Map<Class<?>, BlockImplWrapper> r1);

    <T extends Event> void subscribeEvent(IObserver<? super T> r1, Class<T> r2);

    void unregisterObserver(IObserver<Event> r1);

    <T extends State> void unregisterStateProvider(IStatusProvider<T> r1);
}
