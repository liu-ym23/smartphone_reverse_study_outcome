package t1;

import com.bytedance.ai.bridge.method.calendar.GetCalendarEventDetailMethod;
import com.bytedance.ai.bridge.method.calendar.GetCalendarObjectsMethod;
import com.bytedance.ai.bridge.method.calendar.GetCalendarsMethod;
import com.bytedance.ai.bridge.method.calendar.SyncCalendarMethod;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f22063b;

    public /* synthetic */ b(ArrayList r5, int r10) {
        this.f22062a = r10;
        this.f22063b = r5;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Object r5, Object r10) {
        int r11 = this.f22062a;
        u1.f r12 = (u1.f) r5;
        CalDavResponse$HrefRelation r13 = (CalDavResponse$HrefRelation) r10;
        ArrayList r14 = this.f22063b;
        switch(r11) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return SyncCalendarMethod.c(r14, r12, r13);
    L7:
        return GetCalendarsMethod.c(r14, r12, r13);
    L9:
        return GetCalendarObjectsMethod.b(r14, r12, r13);
    L11:
        return GetCalendarObjectsMethod.c(r14, r12, r13);
    L13:
        return GetCalendarEventDetailMethod.b(r14, r12, r13);
    }
}
