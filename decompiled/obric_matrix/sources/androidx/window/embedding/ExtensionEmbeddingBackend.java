package androidx.window.embedding;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 )2\u00020\u0001:\u0003)*+B\u0011\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J,\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!H\u0016J\u0016\u0010$\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0013H\u0016J\u001c\u0010'\u001a\u00020\u00192\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"0!H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\"\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend;", "Landroidx/window/embedding/EmbeddingBackend;", "embeddingExtension", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "(Landroidx/window/embedding/EmbeddingInterfaceCompat;)V", "getEmbeddingExtension", "()Landroidx/window/embedding/EmbeddingInterfaceCompat;", "setEmbeddingExtension", "splitChangeCallbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "getSplitChangeCallbacks$annotations", "()V", "getSplitChangeCallbacks", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "splitInfoEmbeddingCallback", "Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "splitRules", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Landroidx/window/embedding/EmbeddingRule;", "getSplitRules", "", "isSplitSupported", "", "registerRule", "", "rule", "registerSplitListenerForActivity", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "setSplitRules", "rules", "unregisterRule", "unregisterSplitListenerForActivity", "consumer", "Companion", "EmbeddingCallbackImpl", "SplitListenerWrapper", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {
    public static final Companion Companion = null;
    private static final String TAG = "EmbeddingBackend";
    private static volatile ExtensionEmbeddingBackend globalInstance;
    private static final ReentrantLock globalLock = null;

    @GuardedBy("globalLock")
    @VisibleForTesting
    private EmbeddingInterfaceCompat embeddingExtension;
    private final CopyOnWriteArrayList<SplitListenerWrapper> splitChangeCallbacks;
    private final EmbeddingCallbackImpl splitInfoEmbeddingCallback;
    private final CopyOnWriteArraySet<EmbeddingRule> splitRules;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0006J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$Companion;", "", "()V", "TAG", "", "globalInstance", "Landroidx/window/embedding/ExtensionEmbeddingBackend;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getInstance", "initAndVerifyEmbeddingExtension", "Landroidx/window/embedding/EmbeddingInterfaceCompat;", "isExtensionVersionSupported", "", "extensionVersion", "", "(Ljava/lang/Integer;)Z", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        private final EmbeddingInterfaceCompat initAndVerifyEmbeddingExtension() {
            EmbeddingCompat r1 = null;
            EmbeddingCompat.Companion r2 = EmbeddingCompat.Companion;     // Catch: Throwable -> L9
            if (isExtensionVersionSupported(r2.getExtensionApiLevel()) == true) goto L6;
        L11:
            if (r1 != null) goto L13;
            Log.d(ExtensionEmbeddingBackend.TAG, "No supported embedding extension found");
        L13:
            return r1;
        L6:
            if (r2.isEmbeddingAvailable() == false) goto L11;
            r1 = new EmbeddingCompat();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Log.d(ExtensionEmbeddingBackend.TAG, o.m("Failed to load embedding extension: ", th));
            goto L11
        }

        public final ExtensionEmbeddingBackend getInstance() {
            if (ExtensionEmbeddingBackend.access$getGlobalInstance$cp() != null) goto L13;
            ReentrantLock r2 = ExtensionEmbeddingBackend.access$getGlobalLock$cp();
            r2.lock();
        L10:
            th = move-exception;
            r2.unlock();
            throw th;
        L6:
            if (ExtensionEmbeddingBackend.access$getGlobalInstance$cp() != null) goto L8;
            ExtensionEmbeddingBackend.access$setGlobalInstance$cp(new ExtensionEmbeddingBackend(ExtensionEmbeddingBackend.Companion.initAndVerifyEmbeddingExtension()));     // Catch: Throwable -> L10
        L8:
            f0 r0 = f0.f18324a;     // Catch: Throwable -> L10
            r2.unlock();
        L13:
            ExtensionEmbeddingBackend r3 = ExtensionEmbeddingBackend.access$getGlobalInstance$cp();
            o.c(r3);
            return r3;
        }

        @VisibleForTesting
        public final boolean isExtensionVersionSupported(Integer r2) {
            if (r2 != null) goto L6;
            return false;
        L6:
            if (r2.intValue() >= 1) goto L8;
            return false;
        L8:
            return true;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$EmbeddingCallbackImpl;", "Landroidx/window/embedding/EmbeddingInterfaceCompat$EmbeddingCallbackInterface;", "(Landroidx/window/embedding/ExtensionEmbeddingBackend;)V", "lastInfo", "", "Landroidx/window/embedding/SplitInfo;", "getLastInfo", "()Ljava/util/List;", "setLastInfo", "(Ljava/util/List;)V", "onSplitInfoChanged", "", "splitInfo", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {
        private List<SplitInfo> lastInfo;
        final /* synthetic */ ExtensionEmbeddingBackend this$0;

        public EmbeddingCallbackImpl(ExtensionEmbeddingBackend r2) {
            o.f(r2, "this$0");
            this.this$0 = r2;
        }

        public final List<SplitInfo> getLastInfo() {
            return this.lastInfo;
        }

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public void onSplitInfoChanged(List<SplitInfo> r2) {
            o.f(r2, "splitInfo");
            this.lastInfo = r2;
            Iterator<SplitListenerWrapper> r1 = this.this$0.getSplitChangeCallbacks().iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().accept(r2);
            goto L4
        }

        public final void setLastInfo(List<SplitInfo> r1) {
            this.lastInfo = r1;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\u0002\u0010\nJ\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/window/embedding/ExtensionEmbeddingBackend$SplitListenerWrapper;", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "callback", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "(Landroid/app/Activity;Ljava/util/concurrent/Executor;Landroidx/core/util/Consumer;)V", "getCallback", "()Landroidx/core/util/Consumer;", "lastValue", "accept", "", "splitInfoList", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SplitListenerWrapper {
        private final Activity activity;
        private final Consumer<List<SplitInfo>> callback;
        private final Executor executor;
        private List<SplitInfo> lastValue;

        public SplitListenerWrapper(Activity r2, Executor r3, Consumer<List<SplitInfo>> r4) {
            o.f(r2, "activity");
            o.f(r3, "executor");
            o.f(r4, "callback");
            this.activity = r2;
            this.executor = r3;
            this.callback = r4;
        }

        public static /* synthetic */ void a(SplitListenerWrapper r0, List r1) {
            m49accept$lambda1(r0, r1);
        }

        /* JADX INFO: renamed from: accept$lambda-1, reason: not valid java name */
        private static final void m49accept$lambda1(SplitListenerWrapper r1, List r2) {
            o.f(r1, "this$0");
            o.f(r2, "$splitsWithActivity");
            r1.callback.accept(r2);
        }

        public final void accept(List<SplitInfo> r5) {
            o.f(r5, "splitInfoList");
            final ArrayList r0 = new ArrayList();
            Iterator<T> r6 = r5.iterator();
        L4:
            if (r6.hasNext() == false) goto L9;
            Object r1 = r6.next();
            if (((SplitInfo) r1).contains(this.activity) == false) goto L4;
            r0.add(r1);
            goto L4
        L9:
            if (o.a(r0, this.lastValue) == false) goto L11;
            return;
        L11:
            this.lastValue = r0;
            this.executor.execute(new f(this, r0));
        }

        public final Consumer<List<SplitInfo>> getCallback() {
            return this.callback;
        }
    }

    static {
        Companion = new Companion(null);
        globalLock = new ReentrantLock();
    }

    @VisibleForTesting
    public ExtensionEmbeddingBackend(EmbeddingInterfaceCompat r2) {
        this.embeddingExtension = r2;
        EmbeddingCallbackImpl r3 = new EmbeddingCallbackImpl(this);
        this.splitInfoEmbeddingCallback = r3;
        this.splitChangeCallbacks = new CopyOnWriteArrayList();
        EmbeddingInterfaceCompat r0 = this.embeddingExtension;
        if (r0 == null) goto L6;
        r0.setEmbeddingCallback(r3);
    L6:
        this.splitRules = new CopyOnWriteArraySet();
    }

    public static final /* synthetic */ ExtensionEmbeddingBackend access$getGlobalInstance$cp() {
        return globalInstance;
    }

    public static final /* synthetic */ ReentrantLock access$getGlobalLock$cp() {
        return globalLock;
    }

    public static final /* synthetic */ void access$setGlobalInstance$cp(ExtensionEmbeddingBackend r0) {
        globalInstance = r0;
    }

    @VisibleForTesting
    public static /* synthetic */ void getSplitChangeCallbacks$annotations() {
    }

    public final EmbeddingInterfaceCompat getEmbeddingExtension() {
        return this.embeddingExtension;
    }

    public final CopyOnWriteArrayList<SplitListenerWrapper> getSplitChangeCallbacks() {
        return this.splitChangeCallbacks;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public Set<EmbeddingRule> getSplitRules() {
        return this.splitRules;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public boolean isSplitSupported() {
        if (this.embeddingExtension == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void registerRule(EmbeddingRule r2) {
        o.f(r2, "rule");
        if (this.splitRules.contains(r2) == true) goto L9;
        this.splitRules.add(r2);
        EmbeddingInterfaceCompat r3 = this.embeddingExtension;
        if (r3 == null) goto L10;
        r3.setSplitRules(this.splitRules);
        return;
    L10:
        return;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void registerSplitListenerForActivity(Activity r3, Executor r4, Consumer<List<SplitInfo>> r5) {
        o.f(r3, "activity");
        o.f(r4, "executor");
        o.f(r5, "callback");
        ReentrantLock r0 = globalLock;
        r0.lock();
    L16:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (getEmbeddingExtension() != null) goto L8;
        Log.v(TAG, "Extension not loaded, skipping callback registration.");     // Catch: Throwable -> L16
        r5.accept(r.g());     // Catch: Throwable -> L16
        r0.unlock();
        return;
    L8:
        SplitListenerWrapper r1 = new SplitListenerWrapper(r3, r4, r5);     // Catch: Throwable -> L16
        getSplitChangeCallbacks().add(r1);     // Catch: Throwable -> L16
        if (this.splitInfoEmbeddingCallback.getLastInfo() == null) goto L12;
        List<SplitInfo> r2 = this.splitInfoEmbeddingCallback.getLastInfo();     // Catch: Throwable -> L16
        o.c(r2);     // Catch: Throwable -> L16
    L11:
        r1.accept(r2);     // Catch: Throwable -> L16
        f0 r6 = f0.f18324a;     // Catch: Throwable -> L16
        r0.unlock();
        return;
    L12:
        r2 = r.g();     // Catch: Throwable -> L16
        goto L11
    }

    public final void setEmbeddingExtension(EmbeddingInterfaceCompat r1) {
        this.embeddingExtension = r1;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void setSplitRules(Set<? extends EmbeddingRule> r2) {
        o.f(r2, "rules");
        this.splitRules.clear();
        this.splitRules.addAll(r2);
        EmbeddingInterfaceCompat r3 = this.embeddingExtension;
        if (r3 == null) goto L7;
        r3.setSplitRules(this.splitRules);
        return;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void unregisterRule(EmbeddingRule r2) {
        o.f(r2, "rule");
        if (this.splitRules.contains(r2) == false) goto L9;
        this.splitRules.remove(r2);
        EmbeddingInterfaceCompat r3 = this.embeddingExtension;
        if (r3 == null) goto L10;
        r3.setSplitRules(this.splitRules);
        return;
    L10:
        return;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void unregisterSplitListenerForActivity(Consumer<List<SplitInfo>> r5) {
        o.f(r5, "consumer");
        ReentrantLock r0 = globalLock;
        r0.lock();
        Iterator<SplitListenerWrapper> r1 = getSplitChangeCallbacks().iterator();     // Catch: Throwable -> L12
    L5:
        if (r1.hasNext() == false) goto L9;
        SplitListenerWrapper r2 = r1.next();     // Catch: Throwable -> L12
        if (o.a(r2.getCallback(), r5) == false) goto L5;
        getSplitChangeCallbacks().remove(r2);     // Catch: Throwable -> L12
    L9:
        f0 r4 = f0.f18324a;     // Catch: Throwable -> L12
        r0.unlock();
        return;
    L12:
        th = move-exception;
        r0.unlock();
        throw th;
    }
}
