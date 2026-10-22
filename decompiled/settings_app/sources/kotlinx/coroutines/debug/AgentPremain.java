package kotlinx.coroutines.debug;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.debug.internal.AgentInstallationType;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import sun.misc.Signal;

/* JADX INFO: compiled from: AgentPremain.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain;", "", "()V", "enableCreationStackTraces", "", "installSignalHandler", "", "premain", "args", "", "instrumentation", "Ljava/lang/instrument/Instrumentation;", "DebugProbesTransformer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AgentPremain {
    public static final AgentPremain INSTANCE = null;
    private static final boolean enableCreationStackTraces = false;

    /* JADX INFO: compiled from: AgentPremain.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J<\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/debug/AgentPremain$DebugProbesTransformer;", "Ljava/lang/instrument/ClassFileTransformer;", "()V", "transform", "", "loader", "Ljava/lang/ClassLoader;", "className", "", "classBeingRedefined", "Ljava/lang/Class;", "protectionDomain", "Ljava/security/ProtectionDomain;", "classfileBuffer", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DebugProbesTransformer implements ClassFileTransformer {
        public static final DebugProbesTransformer INSTANCE = null;

        static {
            INSTANCE = new DebugProbesTransformer();
        }

        private DebugProbesTransformer() {
        }

        public byte[] transform(ClassLoader r1, String r2, Class<?> r3, ProtectionDomain r4, byte[] r5) {
            if (r1 != null) goto L4;
            return null;
        L4:
            if (Intrinsics.areEqual(r2, "kotlin/coroutines/jvm/internal/DebugProbesKt") == false) goto L10;
            AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
            return ByteStreamsKt.readBytes(r1.getResourceAsStream("DebugProbesKt.bin"));
        L10:
            return null;
        }
    }

    public static /* synthetic */ void $r8$lambda$WCAflVvFictlq_GPLH_RKIlVunI(Signal r0) {
        installSignalHandler$lambda$1(r0);
    }

    private AgentPremain() {
    }

    static {
        INSTANCE = new AgentPremain();
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        String r2 = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");     // Catch: Throwable -> L9
        if (r2 == null) goto L6;
        Boolean r3 = Boolean.valueOf(Boolean.parseBoolean(r2));     // Catch: Throwable -> L9
    L7:
        Object r4 = Result.m1508constructorimpl(r3);     // Catch: Throwable -> L9
    L12:
        if (Result.m1514isFailureimpl(r4) == true) goto L15;
        r0 = r4;
    L15:
        Boolean r5 = (Boolean) r0;
        if (r5 == null) goto L18;
        boolean r6 = r5.booleanValue();
    L19:
        enableCreationStackTraces = r6;
        return;
    L18:
        r6 = DebugProbesImpl.INSTANCE.getEnableCreationStackTraces();
        goto L19
    L6:
        r3 = null;
    L9:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @JvmStatic
    public static final void premain(String r1, Instrumentation r2) {
        AgentInstallationType.INSTANCE.setInstalledStatically$kotlinx_coroutines_core(true);
        r2.addTransformer(DebugProbesTransformer.INSTANCE);
        DebugProbesImpl.INSTANCE.setEnableCreationStackTraces(enableCreationStackTraces);
        DebugProbesImpl.INSTANCE.install();
        INSTANCE.installSignalHandler();
    }

    private final void installSignalHandler() {
        Signal.handle(new Signal("TRAP"), new AgentPremain$$ExternalSyntheticLambda0());     // Catch: Throwable -> L4
        return;
    }

    private static final void installSignalHandler$lambda$1(Signal r1) {
        if (DebugProbesImpl.INSTANCE.isInstalled$kotlinx_coroutines_core() == false) goto L5;
        DebugProbesImpl.INSTANCE.dumpCoroutines(System.out);
        return;
    L5:
        System.out.println("Cannot perform coroutines dump, debug probes are disabled");
    }
}
