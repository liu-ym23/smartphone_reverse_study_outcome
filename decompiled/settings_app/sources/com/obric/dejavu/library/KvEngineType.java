package com.obric.dejavu.library;

import kotlin.Metadata;

/* JADX INFO: compiled from: KvEngineType.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/dejavu/library/KvEngineType;", "", "data", "", "(Ljava/lang/String;II)V", "getData", "()I", "LevelDb", "RocksDb", "Redis", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final enum KvEngineType extends Enum<KvEngineType> {
    private static final /* synthetic */ KvEngineType[] $VALUES = null;
    public static final KvEngineType LevelDb = null;
    public static final KvEngineType Redis = null;
    public static final KvEngineType RocksDb = null;
    private final int data;

    private static final /* synthetic */ KvEngineType[] $values() {
        return new KvEngineType[]{LevelDb, RocksDb, Redis};
    }

    public static KvEngineType valueOf(String r1) {
        return (KvEngineType) Enum.valueOf(KvEngineType.class, r1);
    }

    public static KvEngineType[] values() {
        return (KvEngineType[]) $VALUES.clone();
    }

    private KvEngineType(String r1, int r2, int r3) {
        super(r1, r2);
        this.data = r3;
    }

    public final int getData() {
        return this.data;
    }

    static {
        LevelDb = new KvEngineType("LevelDb", 0, 0);
        RocksDb = new KvEngineType("RocksDb", 1, 1);
        Redis = new KvEngineType("Redis", 2, 2);
        $VALUES = $values();
    }
}
