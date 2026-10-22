package com.obric.search.api.migration;

import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: AbstractMigration.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/obric/search/api/migration/AbstractMigration;", "", "startVersion", "", "endVersion", "(II)V", "getEndVersion", "()I", "getStartVersion", "getMigrationActions", "", "Lcom/obric/search/api/migration/IMigrationAction;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractMigration {
    private final int endVersion;
    private final int startVersion;

    public abstract List<IMigrationAction> getMigrationActions();

    public AbstractMigration(int r1, int r2) {
        this.startVersion = r1;
        this.endVersion = r2;
    }

    public final int getEndVersion() {
        return this.endVersion;
    }

    public final int getStartVersion() {
        return this.startVersion;
    }
}
