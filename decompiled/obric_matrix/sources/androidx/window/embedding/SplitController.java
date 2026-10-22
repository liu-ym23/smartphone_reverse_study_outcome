package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalWindowApi
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fJ\u0006\u0010\u0012\u001a\u00020\tJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007J\u001a\u0010\u0018\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000fJ\u0016\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Landroidx/window/embedding/SplitController;", "", "()V", "embeddingBackend", "Landroidx/window/embedding/EmbeddingBackend;", "staticSplitRules", "", "Landroidx/window/embedding/EmbeddingRule;", "addSplitListener", "", "activity", "Landroid/app/Activity;", "executor", "Ljava/util/concurrent/Executor;", "consumer", "Landroidx/core/util/Consumer;", "", "Landroidx/window/embedding/SplitInfo;", "clearRegisteredRules", "getSplitRules", "isSplitSupported", "", "registerRule", "rule", "removeSplitListener", "setStaticSplitRules", "staticRules", "unregisterRule", "Companion", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SplitController {
    public static final Companion Companion = null;
    private static volatile SplitController globalInstance = null;
    private static final ReentrantLock globalLock = null;
    public static final boolean sDebug = false;
    private final EmbeddingBackend embeddingBackend;
    private Set<? extends EmbeddingRule> staticSplitRules;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/window/embedding/SplitController$Companion;", "", "()V", "globalInstance", "Landroidx/window/embedding/SplitController;", "globalLock", "Ljava/util/concurrent/locks/ReentrantLock;", "sDebug", "", "getInstance", "initialize", "", "context", "Landroid/content/Context;", "staticRuleResourceId", "", "window_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public final SplitController getInstance() {
            if (SplitController.access$getGlobalInstance$cp() != null) goto L13;
            ReentrantLock r2 = SplitController.access$getGlobalLock$cp();
            r2.lock();
        L10:
            th = move-exception;
            r2.unlock();
            throw th;
        L6:
            if (SplitController.access$getGlobalInstance$cp() != null) goto L8;
            Companion r0 = SplitController.Companion;     // Catch: Throwable -> L10
            SplitController.access$setGlobalInstance$cp(new SplitController(null));     // Catch: Throwable -> L10
        L8:
            f0 r1 = f0.f18324a;     // Catch: Throwable -> L10
            r2.unlock();
        L13:
            SplitController r3 = SplitController.access$getGlobalInstance$cp();
            o.c(r3);
            return r3;
        }

        public final void initialize(Context r2, int r3) {
            o.f(r2, "context");
            Set<EmbeddingRule> r4 = new SplitRuleParser().parseSplitRules$window_release(r2, r3);
            SplitController r1 = getInstance();
            if (r4 != null) goto L5;
            r4 = t0.b();
        L5:
            SplitController.access$setStaticSplitRules(r1, r4);
        }
    }

    static {
        Companion = new Companion(null);
        globalLock = new ReentrantLock();
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = t0.b();
    }

    public /* synthetic */ SplitController(g r1) {
        this();
    }

    public static final /* synthetic */ SplitController access$getGlobalInstance$cp() {
        return globalInstance;
    }

    public static final /* synthetic */ ReentrantLock access$getGlobalLock$cp() {
        return globalLock;
    }

    public static final /* synthetic */ void access$setGlobalInstance$cp(SplitController r0) {
        globalInstance = r0;
    }

    public static final /* synthetic */ void access$setStaticSplitRules(SplitController r0, Set r1) {
        r0.setStaticSplitRules(r1);
    }

    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    public static final void initialize(Context r1, int r2) {
        Companion.initialize(r1, r2);
    }

    private final void setStaticSplitRules(Set<? extends EmbeddingRule> r1) {
        this.staticSplitRules = r1;
        this.embeddingBackend.setSplitRules(r1);
    }

    public final void addSplitListener(Activity r2, Executor r3, Consumer<List<SplitInfo>> r4) {
        o.f(r2, "activity");
        o.f(r3, "executor");
        o.f(r4, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(r2, r3, r4);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    public final Set<EmbeddingRule> getSplitRules() {
        return r.D0(this.embeddingBackend.getSplitRules());
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(EmbeddingRule r2) {
        o.f(r2, "rule");
        this.embeddingBackend.registerRule(r2);
    }

    public final void removeSplitListener(Consumer<List<SplitInfo>> r2) {
        o.f(r2, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(r2);
    }

    public final void unregisterRule(EmbeddingRule r2) {
        o.f(r2, "rule");
        this.embeddingBackend.unregisterRule(r2);
    }
}
