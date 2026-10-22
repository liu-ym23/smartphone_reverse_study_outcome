package androidx.work.impl.utils.futures;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final enum DirectExecutor extends Enum<DirectExecutor> implements Executor {
    private static final /* synthetic */ DirectExecutor[] $VALUES = null;
    public static final DirectExecutor INSTANCE = null;

    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }

    private static /* synthetic */ DirectExecutor[] $values() {
        return new DirectExecutor[]{INSTANCE};
    }

    public static DirectExecutor valueOf(String name) {
        return (DirectExecutor) Enum.valueOf(DirectExecutor.class, name);
    }

    public static DirectExecutor[] values() {
        return (DirectExecutor[]) $VALUES.clone();
    }

    private DirectExecutor(String $enum$name, int $enum$ordinal) {
        super($enum$name, $enum$ordinal);
    }

    static {
        INSTANCE = new DirectExecutor("INSTANCE", 0);
        $VALUES = $values();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        command.run();
    }
}
