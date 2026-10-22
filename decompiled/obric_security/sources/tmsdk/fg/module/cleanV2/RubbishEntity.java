package tmsdk.fg.module.cleanV2;

import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class RubbishEntity implements Serializable, Comparable<RubbishEntity> {
    public static final int FILE_TYPE_DOC = 3;
    public static final int FILE_TYPE_OTHER = -1;
    public static final int FILE_TYPE_PIC = 1;
    public static final int FILE_TYPE_SOUND = 0;
    public static final int FILE_TYPE_VIDEO = 2;
    public static final int INDEX_APK = 2;
    public static final int INDEX_SOFTWARE_CACHE = 0;
    public static final int INDEX_SYSTEM_RUBBISH = 1;
    public static final int INDEX_UNINSTALL_RETAIL = 4;
    public static final int MODEL_TYPE_DELETED = 2;
    public static final int MODEL_TYPE_SELECTED = 1;
    public static final int MODEL_TYPE_UNSELECTED = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f67a;
    private volatile HashSet b;
    private HashMap c;
    private boolean d;
    private long e;
    private String f;
    private String g;
    private String h;
    private int i;
    private int j;
    private String k;
    private Integer[] l;
    int m;

    public RubbishEntity(int r3, String r4, boolean r5, long r6, String r8, String r9, String r10) {
        this.m = 0;
        this.f67a = r3;
        this.b = new HashSet();
        this.b.add(r4);
        this.c = new HashMap();
        if (TextUtils.isEmpty(r4) == true) goto L5;
        this.c.put(r4, Long.valueOf(r6));
    L5:
        this.d = r5;
        if (r5 == false) goto L8;
        this.m = 1;
    L8:
        this.e = r6;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = 0;
    }

    protected void a(List r6, long r7) {
        if (r6 != null) goto L4;
        return;
    L4:
        if (r6.isEmpty() == true) goto L25;
        boolean r1 = false;
        if (r6.size() != 1) goto L9;
        this.c.put((String) r6.get(0), Long.valueOf(r7));
    L9:
        Iterator r8 = r6.iterator();
    L11:
        if (r8.hasNext() == false) goto L15;
        String r0 = (String) r8.next();
        if (this.b.contains(r0) == true) goto L11;
        this.b.add(r0);
        r1 = true;
        goto L11
    L15:
        if (r1 == false) goto L24;
        this.e += r7;
        return;
    L24:
        return;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(RubbishEntity r1) {
        return compareTo2(r1);
    }

    public Object deepClone() {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();     // Catch: Exception -> L4
        new ObjectOutputStream(r0).writeObject(this);     // Catch: Exception -> L4
        return new ObjectInputStream(new ByteArrayInputStream(r0.toByteArray())).readObject();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public String getAppName() {
        return this.f;
    }

    public String getDescription() {
        return this.h;
    }

    public String getPackageName() {
        return this.g;
    }

    public List<String> getRubbishKey() {
        if (this.b == null) goto L9;
        if (this.b.isEmpty() == true) goto L9;
        return new ArrayList(this.b);
    L9:
        return new ArrayList();
    }

    public int getRubbishType() {
        return this.f67a;
    }

    public HashMap<String, Long> getSinglePathSizeMap() {
        return this.c;
    }

    public long getSize() {
        return this.e;
    }

    public int getStatus() {
        return this.m;
    }

    public int getVersionCode() {
        return this.i;
    }

    public String getmCleanTips() {
        return this.k;
    }

    public int getmFileType() {
        return this.j;
    }

    public Integer[] getmGroupIds() {
        return this.l;
    }

    public boolean isSuggest() {
        return this.d;
    }

    public void setExtendData(int r1, String r2, List<Integer> r3) {
        this.j = r1;
        this.k = r2;
        if (r3 == null) goto L6;
        this.l = (Integer[]) r3.toArray(new Integer[r3.size()]);
        return;
    }

    public boolean setStatus(int r3) {
        if (2 != r3) goto L6;
        return false;
    L6:
        if (r3 == 0) goto L9;
        if (1 == r3) goto L9;
        return false;
    L9:
        this.m = r3;
        return true;
    }

    public void setVersionCode(int r1) {
        this.i = r1;
    }

    public RubbishEntity(int r4, List<String> r5, boolean r6, long r7, String r9, String r10, String r11) {
        this.m = 0;
        this.f67a = r4;
        this.b = new HashSet(r5);
        this.c = new HashMap();
        if (r5 != null) goto L5;
    L7:
        this.d = r6;
        if (r6 == false) goto L10;
        this.m = 1;
    L10:
        this.e = r7;
        this.f = r9;
        this.g = r10;
        this.h = r11;
        this.i = 0;
        return;
    L5:
        if (r5.size() != 1) goto L7;
        this.c.put(r5.get(0), Long.valueOf(r7));
        goto L7
    }

    protected void a() {
        this.m = 2;
        this.b.clear();
        this.c.clear();
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(RubbishEntity r2) {
        String r1 = this.h;
        if (r1 != null) goto L9;
        if (r2 == null) goto L9;
        if (r2.h != null) goto L9;
        return 0;
    L9:
        if (r1 != null) goto L12;
        return -1;
    L12:
        if (r2 == null) goto L18;
        String r3 = r2.h;
        if (r3 != null) goto L17;
        return 1;
    L17:
        return r1.compareTo(r3);
    L18:
        return 1;
    }
}
