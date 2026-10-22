package androidx.work.impl.workers;

import androidx.work.Logger;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import androidx.work.impl.model.WorkTagDao;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: DiagnosticsWorker.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a/\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a.\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"TAG", "", "workSpecRow", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "name", "systemId", "", TracingConstants.KEY_TAGS, "(Landroidx/work/impl/model/WorkSpec;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Ljava/lang/String;", "workSpecRows", "workNameDao", "Landroidx/work/impl/model/WorkNameDao;", "workTagDao", "Landroidx/work/impl/model/WorkTagDao;", "systemIdInfoDao", "Landroidx/work/impl/model/SystemIdInfoDao;", "workSpecs", "", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DiagnosticsWorkerKt {
    private static final String TAG = null;

    public static final /* synthetic */ String access$getTAG$p() {
        return TAG;
    }

    public static final /* synthetic */ String access$workSpecRows(WorkNameDao r0, WorkTagDao r1, SystemIdInfoDao r2, List r3) {
        return workSpecRows(r0, r1, r2, r3);
    }

    static {
        String r0 = Logger.tagWithPrefix("DiagnosticsWrkr");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"DiagnosticsWrkr\")");
        TAG = r0;
    }

    private static final String workSpecRows(WorkNameDao r19, WorkTagDao r20, SystemIdInfoDao r21, List<WorkSpec> r22) {
        StringBuilder r0 = new StringBuilder();
        r0.append("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator<T> r1 = r22.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        WorkSpec r2 = (WorkSpec) r1.next();
        SystemIdInfo r3 = r21.getSystemIdInfo(WorkSpecKt.generationalId(r2));
        if (r3 == null) goto L8;
        Integer r4 = Integer.valueOf(r3.systemId);
    L9:
        r0.append(workSpecRow(r2, CollectionsKt.joinToString$default(r19.getNamesForWorkSpecId(r2.id), ",", null, null, 0, null, null, 62, null), r4, CollectionsKt.joinToString$default(r20.getTagsForWorkSpecId(r2.id), ",", null, null, 0, null, null, 62, null)));
        goto L4
    L8:
        r4 = null;
        goto L9
    L10:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "StringBuilder().apply(builderAction).toString()");
        return r5;
    }

    private static final String workSpecRow(WorkSpec r3, String r4, Integer r5, String r6) {
        return IOUtils.LINE_SEPARATOR_UNIX + r3.id + "\t " + r3.workerClassName + "\t " + r5 + "\t " + r3.state.name() + "\t " + r4 + "\t " + r6 + '\t';
    }
}
