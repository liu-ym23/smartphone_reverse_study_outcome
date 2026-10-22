package com.obric.search.api.migration;

import com.android.settings.search.IndexDatabaseHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MigrationBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00002\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u000b\"\u00020\b¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/search/api/migration/MigrationBuilder;", "", "startVersion", "", "endVersion", "(II)V", "migrationActions", "", "Lcom/obric/search/api/migration/IMigrationAction;", "addActions", "actions", "", "([Lcom/obric/search/api/migration/IMigrationAction;)Lcom/obric/search/api/migration/MigrationBuilder;", IndexDatabaseHelper.MetaColumns.BUILD, "Lcom/obric/search/api/migration/AbstractMigration;", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MigrationBuilder {
    private final int endVersion;
    private final List<IMigrationAction> migrationActions;
    private final int startVersion;

    public MigrationBuilder(int r1, int r2) {
        this.startVersion = r1;
        this.endVersion = r2;
        this.migrationActions = new ArrayList();
    }

    public static final /* synthetic */ List access$getMigrationActions$p(MigrationBuilder r0) {
        return r0.migrationActions;
    }

    public final MigrationBuilder addActions(IMigrationAction... r5) {
        Intrinsics.checkNotNullParameter(r5, "actions");
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        IMigrationAction r2 = r5[r1];
        this.migrationActions.add(r2);
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public final AbstractMigration build() {
        final int r0 = this.startVersion;
        final int r1 = this.endVersion;
        return new AnonymousClass1(this, r0, r1);
    }
}
