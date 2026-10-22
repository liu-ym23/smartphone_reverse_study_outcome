package t1;

import com.bytedance.ai.bridge.calendar.AbsSyncCalendarMethodIDL;
import com.bytedance.ai.bridge.method.calendar.GetCalendarsMethod;
import com.bytedance.ai.bridge.method.calendar.SyncCalendarMethod;
import com.bytedance.ai.bridge.method.calendar.remote.CalDavResponse$HrefRelation;
import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class e implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f22065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f22066c;
    public final /* synthetic */ Object d;

    public /* synthetic */ e(AbsSyncCalendarMethodIDL.SyncCalendarParamModel r5, ArrayList r10, ArrayList r11) {
        this.f22064a = 1;
        this.f22066c = r5;
        this.f22065b = r10;
        this.d = r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(Object r5, Object r10) {
        u1.f r11 = (u1.f) r5;
        CalDavResponse$HrefRelation r12 = (CalDavResponse$HrefRelation) r10;
        switch(this.f22064a) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        ArrayList r13 = this.f22065b;
        ArrayList r14 = (ArrayList) this.d;
        return SyncCalendarMethod.b((AbsSyncCalendarMethodIDL.SyncCalendarParamModel) this.f22066c, r13, r14, r11, r12);
    L6:
        u1.d r15 = (u1.d) this.f22066c;
        ArrayList r16 = this.f22065b;
        return GetCalendarsMethod.b(r15, (o1.f) this.d, r16, r11, r12);
    }

    public /* synthetic */ e(u1.d r5, o1.f r10, ArrayList r11) {
        this.f22064a = 0;
        this.f22066c = r5;
        this.d = r10;
        this.f22065b = r11;
    }
}
