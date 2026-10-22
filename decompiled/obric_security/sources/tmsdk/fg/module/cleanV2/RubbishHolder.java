package tmsdk.fg.module.cleanV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class RubbishHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map f68a;
    List b;
    Map c;
    Map d;

    public RubbishHolder() {
    }

    private void a(RubbishEntity r2) {
        if (this.b != null) goto L5;
        this.b = new ArrayList();
    L5:
        this.b.add(r2);
    }

    private void b(RubbishEntity r5) {
        if (this.c != null) goto L5;
        this.c = new HashMap();
    L5:
        String r0 = r5.getPackageName() + r5.getDescription() + r5.isSuggest();
        RubbishEntity r1 = (RubbishEntity) this.c.get(r0);
        if (r1 != null) goto L8;
        this.c.put(r0, r5);
        return;
    L8:
        r1.a(r5.getRubbishKey(), r5.getSize());
    }

    private void c(RubbishEntity r4) {
        if (this.f68a != null) goto L5;
        this.f68a = new HashMap();
    L5:
        RubbishEntity r0 = (RubbishEntity) this.f68a.get(r4.getDescription());
        if (r0 == null) goto L8;
        r0.a(r4.getRubbishKey(), r4.getSize());
        return;
    L8:
        this.f68a.put(r4.getDescription(), r4);
    }

    private void d(RubbishEntity r5) {
        if (this.d != null) goto L5;
        this.d = new HashMap();
    L5:
        String r0 = r5.getPackageName() + r5.getDescription() + r5.isSuggest();
        RubbishEntity r1 = (RubbishEntity) this.d.get(r0);
        if (r1 != null) goto L8;
        this.d.put(r0, r5);
        return;
    L8:
        r1.a(r5.getRubbishKey(), r5.getSize());
    }

    public void addRubbish(String r3, RubbishEntity r4) {
        int r0 = r4.getRubbishType();
        if (r0 != 0) goto L5;
        a(r3, r4);
        return;
    L5:
        if (r0 != 1) goto L7;
        b(r3, r4);
        return;
    L7:
        if (r0 != 2) goto L9;
        a(r4);
        return;
    L9:
        if (r0 != 4) goto L19;
        c(r3, r4);
        return;
    }

    public long getAllRubbishFileSize() {
        Map r0 = this.f68a;
        long r1 = 0;
        if (r0 == null) goto L8;
        Iterator r2 = r0.values().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        r1 = r1 + ((RubbishEntity) r2.next()).getSize();
    L8:
        List r3 = this.b;
        if (r3 == null) goto L14;
        Iterator r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L14;
        r1 = r1 + ((RubbishEntity) r4.next()).getSize();
    L14:
        Map r5 = this.c;
        if (r5 == null) goto L20;
        Iterator r6 = r5.values().iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        r1 = r1 + ((RubbishEntity) r6.next()).getSize();
    L20:
        Map r7 = this.d;
        if (r7 == null) goto L26;
        Iterator r8 = r7.values().iterator();
    L24:
        if (r8.hasNext() == false) goto L26;
        r1 = r1 + ((RubbishEntity) r8.next()).getSize();
    L26:
        return r1;
    }

    public long getApkRubbishFileSize() {
        List r4 = this.b;
        long r0 = 0;
        if (r4 == null) goto L10;
        Iterator r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        RubbishEntity r2 = (RubbishEntity) r5.next();
        if (r2.isSuggest() == false) goto L6;
        r0 = r0 + r2.getSize();
    L10:
        return r0;
    }

    public long getCleanRubbishFileSize() {
        Map r0 = this.f68a;
        long r2 = 0;
        if (r0 == null) goto L10;
        Iterator r1 = r0.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        RubbishEntity r4 = (RubbishEntity) r1.next();
        if (2 != r4.getStatus()) goto L6;
        r2 = r2 + r4.getSize();
    L10:
        List r3 = this.b;
        if (r3 == null) goto L18;
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        RubbishEntity r6 = (RubbishEntity) r5.next();
        if (2 != r6.getStatus()) goto L14;
        r2 = r2 + r6.getSize();
    L18:
        Map r7 = this.c;
        if (r7 == null) goto L26;
        Iterator r8 = r7.values().iterator();
    L22:
        if (r8.hasNext() == false) goto L26;
        RubbishEntity r9 = (RubbishEntity) r8.next();
        if (2 != r9.getStatus()) goto L22;
        r2 = r2 + r9.getSize();
    L26:
        Map r10 = this.d;
        if (r10 == null) goto L34;
        Iterator r11 = r10.values().iterator();
    L30:
        if (r11.hasNext() == false) goto L34;
        RubbishEntity r12 = (RubbishEntity) r11.next();
        if (2 != r12.getStatus()) goto L30;
        r2 = r2 + r12.getSize();
    L34:
        return r2;
    }

    public long getInstallRubbishFileSize() {
        Map r4 = this.c;
        long r0 = 0;
        if (r4 == null) goto L10;
        Iterator r5 = r4.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        RubbishEntity r2 = (RubbishEntity) r5.next();
        if (r2.isSuggest() == false) goto L6;
        r0 = r0 + r2.getSize();
    L10:
        return r0;
    }

    public int getScanAllFileCount() {
        Map r0 = this.f68a;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        List r2 = this.b;
        if (r2 != null) goto L16;
    L24:
        Map r3 = this.c;
        if (r3 != null) goto L27;
    L35:
        Map r4 = this.d;
        if (r4 != null) goto L38;
    L46:
        return r1;
    L38:
        if (r4.isEmpty() == true) goto L46;
        Iterator r5 = this.d.values().iterator();
    L41:
        if (r5.hasNext() == false) goto L46;
        RubbishEntity r6 = (RubbishEntity) r5.next();
        if (r6 == null) goto L41;
        r1 = r1 + r6.getRubbishKey().size();
        goto L41
    L27:
        if (r3.isEmpty() == true) goto L35;
        Iterator r7 = this.c.values().iterator();
    L30:
        if (r7.hasNext() == false) goto L35;
        RubbishEntity r8 = (RubbishEntity) r7.next();
        if (r8 == null) goto L30;
        r1 = r1 + r8.getRubbishKey().size();
        goto L30
    L16:
        if (r2.isEmpty() == true) goto L24;
        Iterator r9 = this.b.iterator();
    L19:
        if (r9.hasNext() == false) goto L24;
        RubbishEntity r10 = (RubbishEntity) r9.next();
        if (r10 == null) goto L19;
        r1 = r1 + r10.getRubbishKey().size();
        goto L19
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r11 = this.f68a.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L13;
        RubbishEntity r12 = (RubbishEntity) r11.next();
        if (r12 == null) goto L8;
        r1 = r1 + r12.getRubbishKey().size();
        goto L8
    }

    public int getScanApkFileCount() {
        List r0 = this.b;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r2 = this.b.iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        if (r3 == null) goto L8;
        r1 = r1 + r3.getRubbishKey().size();
        goto L8
    }

    public int getScanInstallFileCount() {
        Map r0 = this.c;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r2 = this.c.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        if (r3 == null) goto L8;
        r1 = r1 + r3.getRubbishKey().size();
        goto L8
    }

    public int getScanSystemFileCount() {
        Map r0 = this.f68a;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r2 = this.f68a.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        if (r3 == null) goto L8;
        r1 = r1 + r3.getRubbishKey().size();
        goto L8
    }

    public int getScanUnInstallFileCount() {
        Map r0 = this.d;
        int r1 = 0;
        if (r0 != null) goto L5;
    L13:
        return r1;
    L5:
        if (r0.isEmpty() == true) goto L13;
        Iterator r2 = this.d.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        if (r3 == null) goto L8;
        r1 = r1 + r3.getRubbishKey().size();
        goto L8
    }

    public long getSelectedRubbishFileSize() {
        Map r0 = this.f68a;
        long r2 = 0;
        if (r0 == null) goto L10;
        Iterator r1 = r0.values().iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        RubbishEntity r4 = (RubbishEntity) r1.next();
        if (1 != r4.getStatus()) goto L6;
        r2 = r2 + r4.getSize();
    L10:
        List r3 = this.b;
        if (r3 == null) goto L18;
        Iterator r5 = r3.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        RubbishEntity r6 = (RubbishEntity) r5.next();
        if (1 != r6.getStatus()) goto L14;
        r2 = r2 + r6.getSize();
    L18:
        Map r7 = this.c;
        if (r7 == null) goto L26;
        Iterator r8 = r7.values().iterator();
    L22:
        if (r8.hasNext() == false) goto L26;
        RubbishEntity r9 = (RubbishEntity) r8.next();
        if (1 != r9.getStatus()) goto L22;
        r2 = r2 + r9.getSize();
    L26:
        Map r10 = this.d;
        if (r10 == null) goto L34;
        Iterator r11 = r10.values().iterator();
    L30:
        if (r11.hasNext() == false) goto L34;
        RubbishEntity r12 = (RubbishEntity) r11.next();
        if (1 != r12.getStatus()) goto L30;
        r2 = r2 + r12.getSize();
    L34:
        return r2;
    }

    public long getSuggetRubbishFileSize() {
        Map r0 = this.f68a;
        long r1 = 0;
        if (r0 == null) goto L10;
        Iterator r2 = r0.values().iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        RubbishEntity r3 = (RubbishEntity) r2.next();
        if (r3.isSuggest() == false) goto L6;
        r1 = r1 + r3.getSize();
    L10:
        List r4 = this.b;
        if (r4 == null) goto L18;
        Iterator r5 = r4.iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        RubbishEntity r6 = (RubbishEntity) r5.next();
        if (r6.isSuggest() == false) goto L14;
        r1 = r1 + r6.getSize();
    L18:
        Map r7 = this.c;
        if (r7 == null) goto L26;
        Iterator r8 = r7.values().iterator();
    L22:
        if (r8.hasNext() == false) goto L26;
        RubbishEntity r9 = (RubbishEntity) r8.next();
        if (r9.isSuggest() == false) goto L22;
        r1 = r1 + r9.getSize();
    L26:
        Map r10 = this.d;
        if (r10 == null) goto L34;
        Iterator r11 = r10.values().iterator();
    L30:
        if (r11.hasNext() == false) goto L34;
        RubbishEntity r12 = (RubbishEntity) r11.next();
        if (r12.isSuggest() == false) goto L30;
        r1 = r1 + r12.getSize();
    L34:
        return r1;
    }

    public long getSystemRubbishFileSize() {
        Map r4 = this.f68a;
        long r0 = 0;
        if (r4 == null) goto L10;
        Iterator r5 = r4.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        RubbishEntity r2 = (RubbishEntity) r5.next();
        if (r2.isSuggest() == false) goto L6;
        r0 = r0 + r2.getSize();
    L10:
        return r0;
    }

    public long getUnInstallRubbishFileSize() {
        Map r4 = this.d;
        long r0 = 0;
        if (r4 == null) goto L10;
        Iterator r5 = r4.values().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        RubbishEntity r2 = (RubbishEntity) r5.next();
        if (r2.isSuggest() == false) goto L6;
        r0 = r0 + r2.getSize();
    L10:
        return r0;
    }

    public List<RubbishEntity> getmApkRubbishes() {
        return this.b;
    }

    public Map<String, RubbishEntity> getmInstallRubbishes() {
        return this.c;
    }

    public Map<String, RubbishEntity> getmSystemRubbishes() {
        return this.f68a;
    }

    public Map<String, RubbishEntity> getmUnInstallRubbishes() {
        return this.d;
    }

    public void resetRubbishes() {
        Map r0 = this.f68a;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        List r1 = this.b;
        if (r1 == null) goto L8;
        r1.clear();
    L8:
        Map r2 = this.c;
        if (r2 == null) goto L11;
        r2.clear();
    L11:
        Map r3 = this.d;
        if (r3 == null) goto L15;
        r3.clear();
        return;
    }

    private void a(String r2, RubbishEntity r3) {
        if (this.c != null) goto L5;
        this.c = new HashMap();
    L5:
        String r4 = r2 + r3.getPackageName();
        RubbishEntity r0 = (RubbishEntity) this.c.get(r4);
        if (r0 != null) goto L8;
        this.c.put(r4, r3);
        return;
    L8:
        r0.a(r3.getRubbishKey(), r3.getSize());
    }

    private void b(String r2, RubbishEntity r3) {
        if (this.f68a != null) goto L5;
        this.f68a = new HashMap();
    L5:
        RubbishEntity r0 = (RubbishEntity) this.f68a.get(r2);
        if (r0 == null) goto L8;
        r0.a(r3.getRubbishKey(), r3.getSize());
        return;
    L8:
        this.f68a.put(r2, r3);
    }

    private void c(String r2, RubbishEntity r3) {
        if (this.d != null) goto L5;
        this.d = new HashMap();
    L5:
        String r4 = r3.getPackageName() + r3.getDescription() + r3.isSuggest();
        RubbishEntity r0 = (RubbishEntity) this.d.get(r4);
        if (r0 != null) goto L8;
        this.d.put(r4, r3);
        return;
    L8:
        r0.a(r3.getRubbishKey(), r3.getSize());
    }

    @Deprecated
    public void addRubbish(RubbishEntity r3) {
        int r0 = r3.getRubbishType();
        if (r0 != 0) goto L5;
        b(r3);
        return;
    L5:
        if (r0 != 1) goto L7;
        c(r3);
        return;
    L7:
        if (r0 != 2) goto L9;
        a(r3);
        return;
    L9:
        if (r0 != 4) goto L19;
        d(r3);
        return;
    }
}
