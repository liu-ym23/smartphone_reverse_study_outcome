package androidx.work.impl.utils;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.work.WorkInfo;
import androidx.work.WorkQuery;
import androidx.work.impl.model.WorkTypeConverters;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RawQueries.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t¨\u0006\n"}, d2 = {"bindings", "", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "count", "", "toRawQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/work/WorkQuery;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class RawQueries {
    public static final SupportSQLiteQuery toRawQuery(WorkQuery r8) {
        Intrinsics.checkNotNullParameter(r8, "<this>");
        ArrayList r0 = new ArrayList();
        StringBuilder r1 = new StringBuilder("SELECT * FROM workspec");
        List<WorkInfo.State> r2 = r8.getStates();
        Intrinsics.checkNotNullExpressionValue(r2, "states");
        String r6 = " AND";
        if ((!r2.isEmpty()) == false) goto L9;
        List<WorkInfo.State> r3 = r8.getStates();
        Intrinsics.checkNotNullExpressionValue(r3, "states");
        List<WorkInfo.State> r4 = r3;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator<T> r7 = r4.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        WorkInfo.State r9 = (WorkInfo.State) r7.next();
        Intrinsics.checkNotNull(r9);
        r5.add(Integer.valueOf(WorkTypeConverters.stateToInt(r9)));
        goto L6
    L8:
        ArrayList r10 = r5;
        r1.append(" WHERE state IN (");
        bindings(r1, r10.size());
        r1.append(")");
        r0.addAll(r10);
        String r11 = " AND";
    L10:
        List<UUID> r12 = r8.getIds();
        Intrinsics.checkNotNullExpressionValue(r12, "ids");
        if ((!r12.isEmpty()) == false) goto L17;
        List<UUID> r13 = r8.getIds();
        Intrinsics.checkNotNullExpressionValue(r13, "ids");
        List<UUID> r14 = r13;
        ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r16 = r14.iterator();
    L14:
        if (r16.hasNext() == false) goto L16;
        r15.add(((UUID) r16.next()).toString());
        goto L14
    L16:
        r1.append(r11.concat(" id IN ("));
        bindings(r1, r8.getIds().size());
        r1.append(")");
        r0.addAll(r15);
        r11 = " AND";
    L17:
        List<String> r17 = r8.getTags();
        Intrinsics.checkNotNullExpressionValue(r17, TracingConstants.KEY_TAGS);
        if ((!r17.isEmpty()) == false) goto L20;
        r1.append(r11.concat(" id IN (SELECT work_spec_id FROM worktag WHERE tag IN ("));
        bindings(r1, r8.getTags().size());
        r1.append("))");
        List<String> r18 = r8.getTags();
        Intrinsics.checkNotNullExpressionValue(r18, TracingConstants.KEY_TAGS);
        r0.addAll(r18);
    L21:
        List<String> r19 = r8.getUniqueWorkNames();
        Intrinsics.checkNotNullExpressionValue(r19, "uniqueWorkNames");
        if ((!r19.isEmpty()) == false) goto L24;
        r1.append(r6.concat(" id IN (SELECT work_spec_id FROM workname WHERE name IN ("));
        bindings(r1, r8.getUniqueWorkNames().size());
        r1.append("))");
        List<String> r20 = r8.getUniqueWorkNames();
        Intrinsics.checkNotNullExpressionValue(r20, "uniqueWorkNames");
        r0.addAll(r20);
    L24:
        r1.append(";");
        String r21 = r1.toString();
        Intrinsics.checkNotNullExpressionValue(r21, "builder.toString()");
        return new SimpleSQLiteQuery(r21, r0.toArray(new Object[0]));
    L20:
        r6 = r11;
        goto L21
    L9:
        r11 = " WHERE";
        goto L10
    }

    private static final void bindings(StringBuilder r10, int r11) {
        if (r11 > 0) goto L4;
        return;
    L4:
        ArrayList r0 = new ArrayList(r11);
        int r1 = 0;
    L5:
        if (r1 >= r11) goto L7;
        r0.add("?");
        r1 = r1 + 1;
        goto L5
    L7:
        r10.append(CollectionsKt.joinToString$default(r0, ",", null, null, 0, null, null, 62, null));
    }
}
