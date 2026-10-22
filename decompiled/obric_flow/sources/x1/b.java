package x1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final XmlPullParserFactory f22944a = null;

    static {
        XmlPullParserFactory r5 = XmlPullParserFactory.newInstance();     // Catch: XmlPullParserException -> L4
        f22944a = r5;     // Catch: XmlPullParserException -> L4
        r5.setNamespaceAware(true);     // Catch: XmlPullParserException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("Couldn't create XmlPullParserFactory", e);
    }

    public static Property$NodeInfo a(XmlPullParser r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = r5.getNamespace();
        String r11 = r5.getName();
        if (r10 == null) goto L8;
        if (r11 == null) goto L8;
        return new Property$NodeInfo(r10, r11);
    L8:
        throw new IllegalStateException("invalid node");
    }

    public static void b(XmlSerializer r5, Property$NodeInfo r10, Function1 r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "node");
        Intrinsics.checkNotNullParameter(r11, "contentGenerator");
        r5.startTag(r10.f1813a, r10.f1814b);
        r11.invoke(r5);
        r5.endTag(r10.f1813a, r10.f1814b);
    }

    public static String c(XmlPullParser r5) {
        Intrinsics.checkNotNullParameter(r5, "parser");
        int r10 = r5.getDepth();
        int r11 = r5.getEventType();
        String r12 = null;
    L4:
        if (r11 != 3) goto L10;
        if (r5.getDepth() != r10) goto L10;
        return r12;
    L10:
        if (r11 != 4) goto L14;
        if (r5.getDepth() != r10) goto L14;
        r12 = r5.getText();
    L14:
        r11 = r5.next();
        goto L4
    }
}
