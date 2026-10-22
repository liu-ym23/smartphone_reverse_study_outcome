package com.bytedanceos.security.debug.settings;

import com.obric.securitycenter.api.settings.IScope;
import com.obric.securitycenter.api.settings.Scope;
import com.obric.securitycenter.api.settings.SettingsKey;
import com.obric.securitycenter.api.settings.Title;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsKeyAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0004¨\u0006\b"}, d2 = {"Lcom/bytedanceos/security/debug/settings/SettingsKeyEntryBuilder;", "", "()V", "build", "", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "settingsKeyClasses", "Ljava/lang/Class;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsKeyEntryBuilder {
    public static final SettingsKeyEntryBuilder INSTANCE = null;

    static {
        INSTANCE = new SettingsKeyEntryBuilder();
    }

    private SettingsKeyEntryBuilder() {
    }

    public final List<SettingsKeyEntry> build(List<? extends Class<?>> r9) {
        Intrinsics.checkNotNullParameter(r9, "settingsKeyClasses");
        List<? extends Class<?>> r8 = r9;
        ArrayList r0 = new ArrayList();
        Iterator<T> r1 = r8.iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        if (IScope.class.isAssignableFrom((Class) r2) == false) goto L4;
        r0.add(r2);
        goto L4
    L8:
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L9:
        SettingsKeyEntry.ScopeEntry r5 = null;
        if (r4.hasNext() == false) goto L25;
        Class r6 = (Class) r4.next();
        if ((r6 instanceof Class) == true) goto L14;
        Class r7 = null;
    L15:
        if (r7 == null) goto L23;
        SettingsKey r10 = (SettingsKey) r6.getAnnotation(SettingsKey.class);
        if (r10 == null) goto L23;
        String r11 = r10.value();
        if (r11 == null) goto L23;
        r5 = new SettingsKeyEntry.ScopeEntry(r7, r11);
    L23:
        if (r5 == null) goto L9;
        r3.add(r5);
        goto L9
    L14:
        r7 = r6;
        goto L15
    L25:
        List r12 = CollectionsKt.sortedWith(r3, new SettingsKeyEntryBuilder$build$$inlined$sortedBy$1());
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r8.iterator();
    L27:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        if (IScope.class.isAssignableFrom((Class) r15) == true) goto L27;
        r13.add(r15);
        goto L27
    L31:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r13.iterator();
    L33:
        if (r17.hasNext() == false) goto L53;
        Class r18 = (Class) r17.next();
        SettingsKey r19 = (SettingsKey) r18.getAnnotation(SettingsKey.class);
        if (r19 == null) goto L50;
        String r20 = r19.value();
        if (r20 == null) goto L50;
        Title r21 = (Title) r18.getAnnotation(Title.class);
        if (r21 == null) goto L42;
        String r22 = r21.value();
    L43:
        if (r22 != null) goto L45;
        r22 = "";
    L45:
        Scope r23 = (Scope) r18.getAnnotation(Scope.class);
        if (r23 == null) goto L48;
        Class<? extends IScope> r24 = r23.module();
    L49:
        SettingsKeyEntry.ChildEntry r25 = new SettingsKeyEntry.ChildEntry(r18, r20, r22, r24);
    L51:
        if (r25 == null) goto L33;
        r16.add(r25);
        goto L33
    L48:
        r24 = null;
        goto L49
    L42:
        r22 = null;
    L50:
        r25 = null;
        goto L51
    L53:
        ArrayList r26 = r16;
        LinkedHashMap r27 = new LinkedHashMap();
        Iterator r28 = r26.iterator();
    L55:
        if (r28.hasNext() == false) goto L60;
        Object r29 = r28.next();
        Class<? extends IScope> r30 = ((SettingsKeyEntry.ChildEntry) r29).getModuleScopeClass();
        Object r31 = r27.get(r30);
        if (r31 != null) goto L59;
        r31 = (List) new ArrayList();
        r27.put(r30, r31);
    L59:
        ((List) r31).add(r29);
        goto L55
    L60:
        ArrayList r32 = new ArrayList(r9.size() + r12.size());
        HashSet r33 = new HashSet();
        Iterator r34 = r12.iterator();
    L62:
        if (r34.hasNext() == false) goto L70;
        SettingsKeyEntry.ScopeEntry r35 = (SettingsKeyEntry.ScopeEntry) r34.next();
        r32.add(r35);
        r33.add(r35.getScopeClass());
        List r36 = (List) r27.get(r35.getScopeClass());
        if (r36 != null) goto L66;
        r36 = CollectionsKt.emptyList();
    L66:
        List r37 = CollectionsKt.sortedWith(r36, new SettingsKeyEntryBuilder$build$$inlined$sortedBy$2());
        r32.addAll(r37);
        Iterator r38 = r37.iterator();
    L68:
        if (r38.hasNext() == false) goto L62;
        r33.add(((SettingsKeyEntry.ChildEntry) r38.next()).getSettingsClass());
        goto L68
    L70:
        ArrayList r39 = new ArrayList();
        Iterator r40 = r26.iterator();
    L72:
        if (r40.hasNext() == false) goto L76;
        Object r41 = r40.next();
        if ((!r33.contains(((SettingsKeyEntry.ChildEntry) r41).getSettingsClass())) == false) goto L72;
        r39.add(r41);
        goto L72
    L76:
        r32.addAll(CollectionsKt.sortedWith(r39, new SettingsKeyEntryBuilder$build$$inlined$sortedBy$3()));
        return r32;
    }
}
