package kotlin.s0.w.d.l0.f.a0.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.r;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19873a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<String, String> f19874b = null;

    static {
        int r2 = 0;
        f19873a = r.Z(r.j(new Character[]{'k', 'o', 't', 'l', 'i', 'n'}), "", null, null, 0, null, null, 62, null);
        LinkedHashMap r0 = new LinkedHashMap();
        List r1 = r.j(new String[]{"Boolean", "Z", "Char", "C", "Byte", "B", "Short", "S", "Int", "I", "Float", "F", "Long", "J", "Double", "D"});
        int r3 = kotlin.l0.c.b(0, r1.size() - 1, 2);
        if (r3 < 0) goto L8;
        int r4 = 0;
    L5:
        StringBuilder r5 = new StringBuilder();
        String r6 = f19873a;
        r5.append(r6);
        r5.append('/');
        r5.append((String) r1.get(r4));
        int r8 = r4 + 1;
        r0.put(r5.toString(), r1.get(r8));
        r0.put(r6 + '/' + ((String) r1.get(r4)) + "Array", '[' + ((String) r1.get(r8)));
        if (r4 == r3) goto L8;
        r4 = r4 + 2;
    L8:
        r0.put(f19873a + "/Unit", "V");
        a(r0, "Any", "java/lang/Object");
        a(r0, "Nothing", "java/lang/Void");
        a(r0, "Annotation", "java/lang/annotation/Annotation");
        Iterator r7 = r.j(new String[]{"String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum"}).iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        String r9 = (String) r7.next();
        a(r0, r9, "java/lang/" + r9);
        goto L10
    L12:
        Iterator r10 = r.j(new String[]{"Iterator", "Collection", "List", "Set", "Map", "ListIterator"}).iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        String r11 = (String) r10.next();
        a(r0, "collections/" + r11, "java/util/" + r11);
        a(r0, "collections/Mutable" + r11, "java/util/" + r11);
        goto L14
    L16:
        a(r0, "collections/Iterable", "java/lang/Iterable");
        a(r0, "collections/MutableIterable", "java/lang/Iterable");
        a(r0, "collections/Map.Entry", "java/util/Map$Entry");
        a(r0, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
    L18:
        if (r2 >= 23) goto L20;
        StringBuilder r12 = new StringBuilder();
        String r13 = f19873a;
        r12.append(r13);
        r12.append("/jvm/functions/Function");
        r12.append(r2);
        a(r0, "Function" + r2, r12.toString());
        a(r0, "reflect/KFunction" + r2, r13 + "/reflect/KFunction");
        r2 = r2 + 1;
        goto L18
    L20:
        Iterator r14 = r.j(new String[]{"Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum"}).iterator();
    L22:
        if (r14.hasNext() == false) goto L24;
        String r15 = (String) r14.next();
        a(r0, r15 + ".Companion", f19873a + "/jvm/internal/" + r15 + "CompanionObject");
        goto L22
    L24:
        f19874b = r0;
    }

    private static final void a(Map<String, String> r2, String r3, String r4) {
        r2.put(f19873a + '/' + r3, 'L' + r4 + ';');
    }

    public static final String b(String r8) {
        o.f(r8, "classId");
        String r0 = f19874b.get(r8);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return 'L' + k.v(r8, '.', '$', false, 4, null) + ';';
    }
}
