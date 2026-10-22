package com.google.common.io;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final enum RecursiveDeleteOption extends Enum<RecursiveDeleteOption> {
    private static final /* synthetic */ RecursiveDeleteOption[] $VALUES = null;
    public static final RecursiveDeleteOption ALLOW_INSECURE = null;

    private static /* synthetic */ RecursiveDeleteOption[] $values() {
        return new RecursiveDeleteOption[]{ALLOW_INSECURE};
    }

    public static RecursiveDeleteOption valueOf(String r1) {
        return (RecursiveDeleteOption) Enum.valueOf(RecursiveDeleteOption.class, r1);
    }

    public static RecursiveDeleteOption[] values() {
        return (RecursiveDeleteOption[]) $VALUES.clone();
    }

    private RecursiveDeleteOption(String r1, int r2) {
        super(r1, r2);
    }

    static {
        ALLOW_INSECURE = new RecursiveDeleteOption("ALLOW_INSECURE", 0);
        $VALUES = $values();
    }
}
