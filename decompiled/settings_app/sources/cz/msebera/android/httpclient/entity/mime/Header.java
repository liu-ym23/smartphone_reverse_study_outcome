package cz.msebera.android.httpclient.entity.mime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class Header implements Iterable<MinimalField> {
    private final Map<String, List<MinimalField>> fieldMap;
    private final List<MinimalField> fields;

    public Header() {
        this.fields = new LinkedList();
        this.fieldMap = new HashMap();
    }

    public void addField(MinimalField r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getName().toLowerCase(Locale.ROOT);
        List<MinimalField> r1 = this.fieldMap.get(r0);
        if (r1 != null) goto L7;
        r1 = new LinkedList();
        this.fieldMap.put(r0, r1);
    L7:
        r1.add(r4);
        this.fields.add(r4);
    }

    public List<MinimalField> getFields() {
        return new ArrayList(this.fields);
    }

    public MinimalField getField(String r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        String r4 = r3.toLowerCase(Locale.ROOT);
        List<MinimalField> r2 = this.fieldMap.get(r4);
        if (r2 != null) goto L8;
    L11:
        return null;
    L8:
        if (r2.isEmpty() == true) goto L11;
        return r2.get(0);
    }

    public List<MinimalField> getFields(String r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        String r3 = r2.toLowerCase(Locale.ROOT);
        List<MinimalField> r1 = this.fieldMap.get(r3);
        if (r1 == null) goto L13;
        if (r1.isEmpty() == true) goto L13;
        return new ArrayList(r1);
    L13:
        return Collections.emptyList();
    }

    public int removeFields(String r3) {
        if (r3 != null) goto L5;
        return 0;
    L5:
        String r4 = r3.toLowerCase(Locale.ROOT);
        List<MinimalField> r5 = this.fieldMap.remove(r4);
        if (r5 != null) goto L8;
    L12:
        return 0;
    L8:
        if (r5.isEmpty() == true) goto L12;
        this.fields.removeAll(r5);
        return r5.size();
    }

    public void setField(MinimalField r7) {
        if (r7 != null) goto L4;
        return;
    L4:
        List<MinimalField> r0 = this.fieldMap.get(r7.getName().toLowerCase(Locale.ROOT));
        if (r0 != null) goto L7;
    L20:
        addField(r7);
        return;
    L7:
        if (r0.isEmpty() == true) goto L20;
        r0.clear();
        r0.add(r7);
        Iterator<MinimalField> r1 = this.fields.iterator();
        int r2 = 0;
        int r3 = -1;
    L11:
        if (r1.hasNext() == false) goto L18;
        if (r1.next().getName().equalsIgnoreCase(r7.getName()) == false) goto L17;
        r1.remove();
        if (r3 != (-1)) goto L17;
        r3 = r2;
    L17:
        r2 = r2 + 1;
        goto L11
    L18:
        this.fields.add(r3, r7);
    }

    @Override // java.lang.Iterable
    public Iterator<MinimalField> iterator() {
        return Collections.unmodifiableList(this.fields).iterator();
    }

    public String toString() {
        return this.fields.toString();
    }
}
