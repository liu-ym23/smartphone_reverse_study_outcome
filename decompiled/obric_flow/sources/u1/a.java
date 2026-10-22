package u1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.model.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22212a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Property$NodeInfo[] f22213b;

    public /* synthetic */ a(Property$NodeInfo[] r5, int r10) {
        this.f22212a = r10;
        this.f22213b = r5;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r10) {
        int r5 = 0;
        Property$NodeInfo[] r11 = this.f22213b;
        XmlSerializer r12 = (XmlSerializer) r10;
        switch(this.f22212a) {
            case 0: goto L11;
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        XmlPullParserFactory r13 = x1.b.f22944a;
        x1.b.b(r12, e.f, new a(r11, r5));
        return Unit.INSTANCE;
    L6:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        int r14 = r11.length;
    L7:
        if (r5 >= r14) goto L10;
        x1.b.b(r12, r11[r5], new m(24));
        r5 = r5 + 1;
        goto L7
    L10:
        return Unit.INSTANCE;
    L11:
        Intrinsics.checkNotNullParameter(r12, "$this$insertTag");
        int r15 = r11.length;
    L12:
        if (r5 >= r15) goto L15;
        x1.b.b(r12, r11[r5], new m(24));
        r5 = r5 + 1;
        goto L12
    L15:
        return Unit.INSTANCE;
    }
}
