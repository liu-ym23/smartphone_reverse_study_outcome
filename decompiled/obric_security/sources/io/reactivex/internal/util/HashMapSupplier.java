package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes5.dex */
public final enum HashMapSupplier extends Enum<HashMapSupplier> implements Callable<Map<Object, Object>> {
    private static final /* synthetic */ HashMapSupplier[] $VALUES = null;
    public static final HashMapSupplier INSTANCE = null;

    private HashMapSupplier(String r1, int r2) {
        super(r1, r2);
    }

    public static HashMapSupplier valueOf(String r1) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, r1);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Map<Object, Object> call() throws Exception {
        return call2();
    }

    static {
        HashMapSupplier r0 = new HashMapSupplier("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new HashMapSupplier[]{r0};
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Map<Object, Object> call2() throws Exception {
        return new HashMap();
    }
}
