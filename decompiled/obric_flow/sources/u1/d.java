package u1;

import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavConflictException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavForbiddenException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavHttpException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavNotFoundException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavPreconditionFailedException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavServiceUnavailableException;
import com.bytedance.ai.bridge.method.calendar.remote.exception.CalDavUnauthorizedException;
import com.bytedance.ai.event.MessageIndication;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.e0;
import okhttp3.h0;
import okhttp3.s0;
import okhttp3.w0;
import okhttp3.z;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
import w1.o;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SimpleDateFormat f22220c = null;
    public static final h0 d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OkHttpClient f22221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e0 f22222b;

    static {
        SimpleDateFormat r5 = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'", Locale.US);
        r5.setTimeZone(TimeZone.getTimeZone("UTC"));
        f22220c = r5;
        Pattern r10 = h0.e;
        d = z.j("application/xml; charset=utf-8");
    }

    public d(OkHttpClient r5, e0 r10) {
        Intrinsics.checkNotNullParameter(r5, "httpClient");
        Intrinsics.checkNotNullParameter(r10, "location");
        this.f22221a = r5;
        if (r5.f20590h == true) goto L7;
        this.f22222b = r10;
        return;
    L7:
        throw new IllegalArgumentException("httpClient must not follow redirects automatically");
    }

    public static final void h(XmlPullParser r5, d r10, Function2 r11, ArrayList r12) {
        int r13 = r5.getDepth();
        int r14 = r5.getEventType();
    L4:
        if (r14 != 3) goto L10;
        if (r5.getDepth() != r13) goto L10;
        return;
    L10:
        if (r14 != 2) goto L21;
        if (r5.getDepth() != (r13 + 1)) goto L21;
        Property$NodeInfo r15 = x1.b.a(r5);
        if (Intrinsics.areEqual(r15, e.f22223a) == false) goto L17;
        xq.b.b(r5, r10.f22222b, r11);
        goto L21
    L17:
        if (Intrinsics.areEqual(r15, o.f22699b) == false) goto L21;
        String r16 = x1.b.c(r5);
        if (r16 == null) goto L21;
        r12.add(new o(r16));
    L21:
        r14 = r5.next();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList a(Reader r10, Function2 r11) {
        ArrayList r5 = new ArrayList();
        XmlPullParser r12 = x1.b.f22944a.newPullParser();
        int r13 = 4;
        Exception r14 = null;
        Object[] r15 = 0;
        Object[] r16 = 0;
        Object[] r17 = 0;
        r12.setInput(r10);     // Catch: XmlPullParserException -> L14 EOFException -> L16
        int r18 = r12.getEventType();     // Catch: XmlPullParserException -> L14 EOFException -> L16
    L5:
        if (r18 == 1) goto L19;
        if (r18 != 2) goto L18;
        if (r12.getDepth() != 1) goto L18;
        if (Intrinsics.areEqual(x1.b.a(r12), e.f22224b) == false) goto L18;
        h(r12, this, r11, r5);     // Catch: XmlPullParserException -> L14 EOFException -> L16
        return r5;
    L18:
        r18 = r12.next();     // Catch: XmlPullParserException -> L14 EOFException -> L16
        goto L5
    L19:
        Object[] r19 = r17 == true ? 1 : 0;
        throw new CalDavException("Multi-Status response didn't contain multistatus XML element", r14, r19, 6);     // Catch: XmlPullParserException -> L14 EOFException -> L16
    L16:
        e = move-exception;
        throw new CalDavException("Incomplete multistatus XML element", e, r16 == true ? 1 : 0, r13);
    L14:
        e = move-exception;
        throw new CalDavException("Couldn't parse multistatus XML element", e, r15 == true ? 1 : 0, r13);
    }

    public final List b(String r10, Property$NodeInfo[] r11, t1.e r12) {
        Intrinsics.checkNotNullParameter(r11, "properties");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlSerializer r5 = x1.b.f22944a.newSerializer();
        StringWriter r13 = new StringWriter();
        r5.setOutput(r13);
        r5.startDocument("UTF-8", null);
        r5.setPrefix("", "DAV:");
        x1.b.b(r5, e.f22226h, new com.bytedance.ai.model.widgets.d(13, r10, r11));
        r5.endDocument();
        s0 r14 = d(new c(this, r13, 2));
        List r15 = c(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return r15;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final List c(s0 r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        int r5 = r10.e;
        int r12 = 2;
        if ((r5 / 100) != 2) goto L35;
        Exception r13 = null;
        if (r5 != 207) goto L33;
        w0 r14 = r10.f20748h;
        if (r14 == null) goto L31;
        h0 r15 = r14.contentType();
        if (r15 == null) goto L19;
        String r16 = r15.f20658b;
        if (Intrinsics.areEqual(r16, "application") == true) goto L15;
        if (Intrinsics.areEqual(r16, MessageIndication.CONTENT_TYPE_TEXT) == true) goto L15;
    L18:
        throw new CalDavException("Received non-XML 207 Multi-Status", r13, r10, r12);
    L15:
        if (Intrinsics.areEqual(r15.f20659c, "xml") == false) goto L18;
    L56:
        ArrayList r17 = a(r14.charStream(), r11);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r14, null);
        return r17;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L19:
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");
        t0.d r18 = com.bytedance.ai.utils.c.f2846a;
        if (r18 == null) goto L56;
        r18.w("CalDavClient", "Received 207 Multi-Status without Content-Type, assuming XML");
        goto L56
    L31:
        throw new CalDavException("Received 207 Multi-Status without body", r13, r10, r12);
    L33:
        throw new CalDavException("Expected 207 Multi-Status, got " + r10.e + ' ' + r10.d, r13, r10, r12);
    L35:
        if (r5 == 401) goto L53;
        if (r5 == 409) goto L63;
        if (r5 == 412) goto L62;
        if (r5 == 503) goto L61;
        if (r5 == 403) goto L60;
        if (r5 == 404) goto L59;
        throw new CalDavHttpException(r10);
    L59:
        throw new CalDavNotFoundException(r10);
    L60:
        throw new CalDavForbiddenException(r10);
    L61:
        throw new CalDavServiceUnavailableException(r10);
    L62:
        throw new CalDavPreconditionFailedException(r10);
    L63:
        throw new CalDavConflictException(r10);
    L53:
        throw new CalDavUnauthorizedException(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final s0 d(Function0 r10) {
        Exception r5 = null;
        Object[] r11 = 0;
        Object[] r12 = 0;
        Object[] r13 = 0;
        s0 r14 = null;
        int r15 = 1;
    L3:
        int r16 = 6;
        if (r15 >= 6) goto L40;
        r14 = (s0) r10.invoke();
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        s0 r17 = null;
    L9:
        int r18 = r17.e;
        if (r18 != 307) goto L12;
    L46:
        r14.getClass();     // Catch: Throwable -> L18
        String r19 = r14.d("Location", null);     // Catch: Throwable -> L18
        if (r19 == null) goto L20;
        e0 r20 = this.f22222b.j(r19);     // Catch: Throwable -> L18
    L21:
        if (r20 == null) goto L35;
        String r21 = "Redirected, new location = " + r20;     // Catch: Throwable -> L18
        Intrinsics.checkNotNullParameter("CalDavClient", "tag");     // Catch: Throwable -> L18
        t0.d r22 = com.bytedance.ai.utils.c.f2846a;     // Catch: Throwable -> L18
        if (r22 == null) goto L26;
        r22.e("CalDavClient", r21);     // Catch: Throwable -> L18
    L26:
        if (this.f22222b.f20639a == true) goto L28;
    L32:
        this.f22222b = r20;     // Catch: Throwable -> L18
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r14, null);
        r15 = r15 + 1;
        goto L3
    L28:
        if (r20.f20639a == true) goto L32;
        throw new CalDavException("Received redirect from HTTPS to HTTP", r5, r13 == true ? 1 : 0, r16);     // Catch: Throwable -> L18
    L35:
        throw new CalDavException("Redirected without new Location", r12 == true ? 1 : 0, r11 == true ? 1 : 0, r16);     // Catch: Throwable -> L18
    L20:
        r20 = null;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L12:
        if (r18 == 308) goto L46;
        switch(r18) {
            case 300: goto L46;
            case 301: goto L46;
            case 302: goto L46;
            case 303: goto L46;
            default: goto L40;
        };
    L8:
        r17 = r14;
    L40:
        if (r14 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("response");
        return null;
    L43:
        return r14;
    }

    public final void e(int r10, Property$NodeInfo[] r11, Function2 r12) {
        Intrinsics.checkNotNullParameter(r11, "reqProp");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlSerializer r5 = x1.b.f22944a.newSerializer();
        StringWriter r13 = new StringWriter();
        r5.setOutput(r13);
        r5.setPrefix("", "DAV:");
        r5.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        r5.setPrefix("CARD", "urn:ietf:params:xml:ns:carddav");
        r5.startDocument("UTF-8", null);
        x1.b.b(r5, e.e, new a(r11, 2));
        r5.endDocument();
        s0 r14 = d(new b3.b(r10, this, 2, r13));
        c(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final void f(Date r10, Date r11, t1.b r12) {
        Intrinsics.checkNotNullParameter("VEVENT", "component");
        Intrinsics.checkNotNullParameter(r12, "callback");
        XmlSerializer r5 = x1.b.f22944a.newSerializer();
        StringWriter r13 = new StringWriter();
        r5.setOutput(r13);
        r5.startDocument("UTF-8", null);
        r5.setPrefix("", "DAV:");
        r5.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        x1.b.b(r5, e.f22228j, new b(r10, r11, 4));
        r5.endDocument();
        s0 r14 = d(new c(this, r13, 1));
        c(r14, r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r14, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    }

    public final void g(List r10, Function2 r11) {
        Intrinsics.checkNotNullParameter(r10, "urls");
        Intrinsics.checkNotNullParameter(r11, "callback");
        XmlSerializer r5 = x1.b.f22944a.newSerializer();
        StringWriter r12 = new StringWriter();
        r5.setOutput(r12);
        r5.startDocument("UTF-8", null);
        r5.setPrefix("", "DAV:");
        r5.setPrefix("CAL", "urn:ietf:params:xml:ns:caldav");
        x1.b.b(r5, e.f22229k, new com.bytedance.ai.model.widgets.d(12, r10, r5));
        r5.endDocument();
        s0 r13 = d(new c(this, r12, 0));
        c(r13, r11);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r13, null);
        return;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);
        throw th;
    }
}
