package us;

import com.obric.oui.window.bean.WindowSizeClass;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile WindowSizeClass f22451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile int f22452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ss.a f22453c;
    public static final LinkedHashSet d = null;
    public static final ArrayList e = null;

    static {
        f22451a = WindowSizeClass.MINUS_ERROR_SIZE;
        f22452b = 1;
        f22453c = new ss.a(0.0f, 0.0f);
        d = new LinkedHashSet();
        e = new ArrayList();
    }

    public static boolean a(LinkedHashSet r5, int r10, Pair r11) {
        if (r5.contains(Integer.valueOf(r10)) == true) goto L24;
        ArrayList r12 = new ArrayList(CollectionsKt.h(r5));
        Iterator r13 = r5.iterator();
    L6:
        if (r13.hasNext() == false) goto L9;
        r12.add(Integer.valueOf((((Number) r13.next()).intValue() - ((Number) r11.getSecond()).intValue()) - ((Number) r11.getFirst()).intValue()));
        goto L6
    L9:
        if (r12.contains(Integer.valueOf(r10)) == true) goto L24;
        ArrayList r14 = new ArrayList(CollectionsKt.h(r5));
        Iterator r15 = r5.iterator();
    L12:
        if (r15.hasNext() == false) goto L15;
        r14.add(Integer.valueOf(((Number) r15.next()).intValue() - ((Number) r11.getSecond()).intValue()));
        goto L12
    L15:
        if (r14.contains(Integer.valueOf(r10)) == true) goto L24;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r5));
        Iterator r17 = r5.iterator();
    L18:
        if (r17.hasNext() == false) goto L21;
        r16.add(Integer.valueOf(((Number) r17.next()).intValue() - ((Number) r11.getFirst()).intValue()));
        goto L18
    L21:
        if (r16.contains(Integer.valueOf(r10)) == true) goto L24;
        return false;
    L24:
        return true;
    }
}
