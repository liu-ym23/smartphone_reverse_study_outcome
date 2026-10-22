package androidx.work.impl.model;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.bytedance.tracing.internal.TracingConstants;
import com.ss.android.message.log.PushLog;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkTagDao.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\u0005H'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH'J\u001e\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkTagDao;", "", "deleteByWorkSpecId", "", SlardarConfigConsts.CONFIG_ID, "", "getTagsForWorkSpecId", "", "getWorkSpecIdsWithTag", PushLog.KEY_TAG, "insert", "workTag", "Landroidx/work/impl/model/WorkTag;", "insertTags", TracingConstants.KEY_TAGS, "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface WorkTagDao {

    /* JADX INFO: compiled from: WorkTagDao.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class DefaultImpls {
        public static void insertTags(WorkTagDao r2, String r3, Set<String> r4) {
            Intrinsics.checkNotNullParameter(r3, SlardarConfigConsts.CONFIG_ID);
            Intrinsics.checkNotNullParameter(r4, TracingConstants.KEY_TAGS);
            Iterator<T> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            r2.insert(new WorkTag((String) r5.next(), r3));
            goto L4
        }
    }

    void deleteByWorkSpecId(String r1);

    List<String> getTagsForWorkSpecId(String r1);

    List<String> getWorkSpecIdsWithTag(String r1);

    void insert(WorkTag r1);

    void insertTags(String r1, Set<String> r2);
}
