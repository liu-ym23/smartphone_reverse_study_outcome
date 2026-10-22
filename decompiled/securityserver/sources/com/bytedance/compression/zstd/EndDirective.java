package com.bytedance.compression.zstd;

/* JADX INFO: loaded from: classes.dex */
public final enum EndDirective extends Enum<EndDirective> {
    public static final /* synthetic */ EndDirective[] b = null;

    static {
        b = new EndDirective[]{new EndDirective("CONTINUE", 0), new EndDirective("FLUSH", 1), new EndDirective("END", 2)};
    }

    public static EndDirective valueOf(String r1) {
        return (EndDirective) Enum.valueOf(EndDirective.class, r1);
    }

    public static EndDirective[] values() {
        return (EndDirective[]) b.clone();
    }
}
