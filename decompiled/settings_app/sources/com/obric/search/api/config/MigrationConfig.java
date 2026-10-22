package com.obric.search.api.config;

import com.obric.search.api.migration.AbstractMigration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MigrationConfig.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/search/api/config/MigrationConfig;", "", "()V", "migrations", "", "Lcom/obric/search/api/migration/AbstractMigration;", "getMigrations", "()Ljava/util/List;", "mutableMigrations", "", "addMigration", "", "migration", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MigrationConfig {
    private final List<AbstractMigration> mutableMigrations;

    public MigrationConfig() {
        this.mutableMigrations = new ArrayList();
    }

    public final List<AbstractMigration> getMigrations() {
        return CollectionsKt.toList(this.mutableMigrations);
    }

    public final void addMigration(AbstractMigration r2) {
        Intrinsics.checkNotNullParameter(r2, "migration");
        this.mutableMigrations.add(r2);
    }
}
