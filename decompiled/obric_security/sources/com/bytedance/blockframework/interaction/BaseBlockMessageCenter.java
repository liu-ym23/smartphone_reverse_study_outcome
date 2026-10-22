package com.bytedance.blockframework.interaction;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.blockframework.contract.AbstractBlock;
import com.bytedance.blockframework.contract.BlockImplWrapper;
import com.bytedance.blockframework.framework.base.BaseBlock;
import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.monitor.BlockLogger;
import com.bytedance.blockframework.framework.utils.BlockExtKt;
import com.obric.security.devenvcheck.WlanSecurityRiskPromptActivity;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseBlockMessageCenter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001cH\u0017¢\u0006\u0002\u0010\u001fJ'\u0010\u001a\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u0002H\u001cH\u0016¢\u0006\u0002\u0010\"J\u001f\u0010#\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u0002H\u001cH\u0016¢\u0006\u0002\u0010\u001fJ'\u0010#\u001a\u00020\u001b\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001e\u001a\u0002H\u001cH\u0016¢\u0006\u0002\u0010\"J3\u0010$\u001a\u0004\u0018\u0001H\u001c\"\u0004\b\u0000\u0010\u001c2\u0006\u0010 \u001a\u00020%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001c0\t2\u0006\u0010'\u001a\u00020\u001bH\u0016¢\u0006\u0002\u0010(J+\u0010$\u001a\u0004\u0018\u0001H\u001c\"\u0004\b\u0000\u0010\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001c0\t2\u0006\u0010'\u001a\u00020\u001bH\u0017¢\u0006\u0002\u0010)J'\u0010*\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u00162\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H\u001c0\tH\u0016¢\u0006\u0002\u0010,J$\u0010-\u001a\u00020.\"\u0004\b\u0000\u0010\u001c2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u001c0\t2\u0006\u0010/\u001a\u00020\nH\u0016J \u00100\u001a\u00020.\"\b\b\u0000\u0010\u001c*\u00020\u00162\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0017H\u0016J0\u00102\u001a\u00020.\"\b\b\u0000\u0010\u001c*\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001c042\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u001c0\tH\u0016J\u0016\u00106\u001a\u00020.2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001d04H\u0016J \u00107\u001a\u00020.\"\b\b\u0000\u0010\u001c*\u00020\u00162\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001c0\u0017H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0007\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t\u0012\u0004\u0012\u00020\n0\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R6\u0010\u0015\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\t\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u00170\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u00068"}, d2 = {"Lcom/bytedance/blockframework/interaction/BaseBlockMessageCenter;", "Lcom/bytedance/blockframework/interaction/IBlockMessageCenter;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "blockServiceMap", "", "Ljava/lang/Class;", "Lcom/bytedance/blockframework/contract/BlockImplWrapper;", "getBlockServiceMap", "()Ljava/util/Map;", "setBlockServiceMap", "(Ljava/util/Map;)V", "eventManager", "Lcom/bytedance/blockframework/interaction/EventManager;", "getEventManager", "()Lcom/bytedance/blockframework/interaction/EventManager;", "setEventManager", "(Lcom/bytedance/blockframework/interaction/EventManager;)V", "stateProviderMap", "Lcom/bytedance/blockframework/interaction/State;", "Lcom/bytedance/blockframework/interaction/IStatusProvider;", "getStateProviderMap", "setStateProviderMap", "notifyEvent", "", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/blockframework/interaction/Event;", "event", "(Lcom/bytedance/blockframework/interaction/Event;)Z", "block", "Lcom/bytedance/blockframework/interaction/StateAndEventModel;", "(Lcom/bytedance/blockframework/interaction/StateAndEventModel;Lcom/bytedance/blockframework/interaction/Event;)Z", "notifyEventForResult", "queryService", "Lcom/bytedance/blockframework/contract/AbstractBlock;", "klass", "activeIfNeed", "(Lcom/bytedance/blockframework/contract/AbstractBlock;Ljava/lang/Class;Z)Ljava/lang/Object;", "(Ljava/lang/Class;Z)Ljava/lang/Object;", "queryState", "stateClass", "(Ljava/lang/Class;)Lcom/bytedance/blockframework/interaction/State;", "registerService", "", "blockImplWrapper", "registerStateProvider", "provider", "subscribeEvent", "observer", "Lcom/bytedance/blockframework/interaction/IObserver;", "eventClass", "unregisterObserver", "unregisterStateProvider", "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class BaseBlockMessageCenter implements IBlockMessageCenter {
    private final String TAG;
    private Map<Class<?>, BlockImplWrapper> blockServiceMap;
    private EventManager eventManager;
    private Map<Class<? extends State>, IStatusProvider<? extends State>> stateProviderMap;

    public BaseBlockMessageCenter() {
        this.TAG = "BaseBlockMessageCenter";
        this.stateProviderMap = new LinkedHashMap();
        this.eventManager = new EventManager();
        this.blockServiceMap = new LinkedHashMap();
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public Map<Class<? extends State>, IStatusProvider<? extends State>> getStateProviderMap() {
        return this.stateProviderMap;
    }

    public void setStateProviderMap(Map<Class<? extends State>, IStatusProvider<? extends State>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.stateProviderMap = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends State> void registerStateProvider(IStatusProvider<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "provider");
        Class<? extends State> r0 = r4.getStateClass();
        if (getStateProviderMap().containsKey(r0) == true) goto L6;
        getStateProviderMap().put(r0, r4);
        return;
    L6:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L8;
    L9:
        BlockExtKt.uploadException(new RuntimeException("registerStateProvider " + r4 + " for state " + r0 + " already exists"), true);
        return;
    L8:
        if (BlockLogger.Companion.debug() == true) goto L9;
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends State> void unregisterStateProvider(IStatusProvider<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "provider");
        Class<T> r3 = r2.getStateClass();
        if (getStateProviderMap().containsKey(r3) == false) goto L6;
        getStateProviderMap().remove(r3);
        return;
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends State> T queryState(Class<T> r4) {
        Intrinsics.checkNotNullParameter(r4, "stateClass");
        if (getStateProviderMap().containsKey(r4) == false) goto L8;
        IStatusProvider<? extends State> r3 = getStateProviderMap().get(r4);
        if (r3 != null) goto L14;
        return null;
    L14:
        return (T) r3.getState();
    L8:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L10;
    L11:
        BlockExtKt.uploadException(new RuntimeException("queryState " + r4 + " not find"), true);
        return null;
    L10:
        if (BlockLogger.Companion.debug() == true) goto L11;
        return null;
    }

    protected EventManager getEventManager() {
        return this.eventManager;
    }

    protected void setEventManager(EventManager r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.eventManager = r2;
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends Event> void subscribeEvent(IObserver<? super T> r2, Class<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        Intrinsics.checkNotNullParameter(r3, "eventClass");
        getEventManager().registerObserver(r2, r3);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public void unregisterObserver(IObserver<Event> r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        getEventManager().unregisterObserver(r2);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends Event> boolean notifyEvent(StateAndEventModel r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Intrinsics.checkNotNullParameter(r3, "event");
        return getEventManager().notifyEvent(r2, r3);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    @Deprecated(message = WlanSecurityRiskPromptActivity.USER_ACTION_IGNORE)
    public <T extends Event> boolean notifyEvent(T r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return getEventManager().notifyEvent(r2);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends Event> boolean notifyEventForResult(T r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return getEventManager().notifyEventForResult(r2);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T extends Event> boolean notifyEventForResult(StateAndEventModel r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Intrinsics.checkNotNullParameter(r3, "event");
        return notifyEventForResult(r3);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public Map<Class<?>, BlockImplWrapper> getBlockServiceMap() {
        return this.blockServiceMap;
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public void setBlockServiceMap(Map<Class<?>, BlockImplWrapper> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.blockServiceMap = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T> void registerService(Class<T> r4, BlockImplWrapper r5) {
        Intrinsics.checkNotNullParameter(r4, "klass");
        Intrinsics.checkNotNullParameter(r5, "blockImplWrapper");
        if (getBlockServiceMap().containsKey(r4) == true) goto L5;
    L9:
        getBlockServiceMap().put(r4, r5);
        return;
    L5:
        if (BlockInit.INSTANCE.logOptEnable() == true) goto L7;
    L8:
        BlockExtKt.uploadException(new RuntimeException("registerService " + r4 + " already exists"), true);
        goto L9
    L7:
        if (BlockLogger.Companion.debug() == false) goto L9;
        goto L8
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    public <T> T queryService(AbstractBlock r2, Class<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "block");
        Intrinsics.checkNotNullParameter(r3, "klass");
        return (T) IBlockMessageCenter.DefaultImpls.queryService$default(this, r3, false, 2, null);
    }

    @Override // com.bytedance.blockframework.interaction.IBlockMessageCenter
    @Deprecated(message = WlanSecurityRiskPromptActivity.USER_ACTION_IGNORE)
    public <T> T queryService(Class<T> r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "klass");
        BaseBlock r1 = null;
        if (getBlockServiceMap().containsKey(r3) == false) goto L15;
        BlockImplWrapper r2 = getBlockServiceMap().get(r3);
        if (r2 == null) goto L7;
        T r5 = (T) r2.getImpl();
    L8:
        if (r4 == true) goto L10;
    L14:
        return r5;
    L10:
        if ((r5 instanceof BaseBlock) == false) goto L12;
        r1 = r5;
    L12:
        if (r1 == null) goto L14;
        r1.activeIfNeed();
        goto L14
    L7:
        r5 = null;
        goto L8
    L15:
        Iterator<BlockImplWrapper> r6 = getBlockServiceMap().values().iterator();
    L17:
        if (r6.hasNext() == false) goto L22;
        BlockImplWrapper r7 = r6.next();
        if (r3.isInstance(r7.getImpl()) == false) goto L17;
        return (T) r7.getImpl();
    L22:
        return null;
    }
}
