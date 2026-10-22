package u1;

import com.bytedance.ai.model.m;
import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Date f22215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Date f22216c;

    public /* synthetic */ b(Date r5, Date r10, int r11) {
        this.f22214a = r11;
        this.f22215b = r5;
        this.f22216c = r10;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        Date r5 = this.f22216c;
        Date r11 = this.f22215b;
        XmlSerializer r12 = (XmlSerializer) r10;
        switch(this.f22214a) {
            case 0: goto L21;
            case 1: goto L19;
            case 2: goto L13;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        XmlPullParserFactory r13 = x1.b.f22944a;
        x1.b.b(r12, e.f, new m(22));
        x1.b.b(r12, e.f22230l, new b(r11, r5, 0));
        return Unit.INSTANCE;
    L6:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        SimpleDateFormat r14 = d.f22220c;
        if (r11 == null) goto L9;
        r12.attribute(null, "start", r14.format(r11));
    L9:
        if (r5 == null) goto L12;
        r12.attribute(null, "end", r14.format(r5));
    L12:
        return Unit.INSTANCE;
    L13:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        r12.attribute(null, "name", "VEVENT");
        if (r11 != null) goto L16;
        if (r5 != null) goto L16;
    L18:
        return Unit.INSTANCE;
    L16:
        XmlPullParserFactory r15 = x1.b.f22944a;
        x1.b.b(r12, e.f22232n, new b(r11, r5, 3));
        goto L18
    L19:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        r12.attribute(null, "name", "VCALENDAR");
        XmlPullParserFactory r16 = x1.b.f22944a;
        x1.b.b(r12, e.f22231m, new b(r11, r5, 2));
        return Unit.INSTANCE;
    L21:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        XmlPullParserFactory r17 = x1.b.f22944a;
        x1.b.b(r12, e.f22231m, new b(r11, r5, 1));
        return Unit.INSTANCE;
    }
}
