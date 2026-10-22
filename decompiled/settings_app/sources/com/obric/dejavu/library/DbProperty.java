package com.obric.dejavu.library;

import kotlin.Metadata;

/* JADX INFO: compiled from: DbProperty.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/dejavu/library/DbProperty;", "", "()V", "IndexStats", "", "getIndexStats", "()Ljava/lang/String;", "library_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DbProperty {
    public static final DbProperty INSTANCE = null;
    private static final String IndexStats = null;

    private DbProperty() {
    }

    static {
        INSTANCE = new DbProperty();
        IndexStats = "prop.IndexStats";
    }

    public final String getIndexStats() {
        return IndexStats;
    }
}
