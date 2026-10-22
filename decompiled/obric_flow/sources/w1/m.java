package w1;

import ai.j0;
import com.bytedance.ai.bridge.method.calendar.remote.Property$NodeInfo;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements u1.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Property$NodeInfo f22694b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Property$NodeInfo f22695c = null;
    public static final Property$NodeInfo d = null;
    public static final Property$NodeInfo e = null;
    public static final Property$NodeInfo f = null;
    public static final Property$NodeInfo g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f22696a;

    static {
        f22694b = new Property$NodeInfo("DAV:", "resourcetype");
        f22695c = new Property$NodeInfo("DAV:", "collection");
        d = new Property$NodeInfo("DAV:", "principal");
        e = new Property$NodeInfo("urn:ietf:params:xml:ns:carddav", "addressbook");
        f = new Property$NodeInfo("urn:ietf:params:xml:ns:caldav", "calendar");
        g = new Property$NodeInfo("http://calendarserver.org/ns/", "subscribed");
    }

    public m() {
        this.f22696a = new LinkedHashSet();
    }

    public final String toString() {
        return j0.p(new StringBuilder("["), CollectionsKt.q(this.f22696a, ", ", null, null, 0, null, null, 62), ']');
    }
}
