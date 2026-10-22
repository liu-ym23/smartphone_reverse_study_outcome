package androidx.slice.core;

import android.net.Uri;
import android.text.TextUtils;
import androidx.slice.Slice;
import androidx.slice.SliceItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SliceQuery {

    private interface Filter<T> {
        boolean filter(T r1);
    }

    public static boolean hasAnyHints(SliceItem r4, String... r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        List<String> r6 = r4.getHints();
        int r1 = r5.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r6.contains(r5[r2]) == true) goto L9;
        r2 = r2 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static boolean hasHints(SliceItem r6, String... r7) {
        if (r7 != null) goto L5;
        return true;
    L5:
        List<String> r8 = r6.getHints();
        int r1 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L13;
        String r4 = r7[r3];
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r8.contains(r4) == true) goto L12;
        return false;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return true;
    }

    public static boolean hasHints(Slice r6, String... r7) {
        if (r7 != null) goto L5;
        return true;
    L5:
        List<String> r8 = r6.getHints();
        int r1 = r7.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L13;
        String r4 = r7[r3];
        if (TextUtils.isEmpty(r4) == true) goto L12;
        if (r8.contains(r4) == true) goto L12;
        return false;
    L12:
        r3 = r3 + 1;
        goto L6
    L13:
        return true;
    }

    public static SliceItem findNotContaining(SliceItem r3, List<SliceItem> r4) {
        SliceItem r0 = null;
    L3:
        if (r0 != null) goto L9;
        if (r4.size() == 0) goto L9;
        SliceItem r1 = r4.remove(0);
        if (contains(r3, r1) == true) goto L3;
        r0 = r1;
    L9:
        return r0;
    }

    private static boolean contains(SliceItem r2, final SliceItem r3) {
        if (r2 == null) goto L10;
        if (r3 != null) goto L7;
        return false;
    L7:
        if (findFirst(filter(stream(r2), new AnonymousClass1(r3)), null) == null) goto L11;
        return true;
    L11:
        return false;
    L10:
        return false;
    }

    public static List<SliceItem> findAll(SliceItem r2, String r3) {
        String[] r1 = (String[]) null;
        return findAll(r2, r3, null, null);
    }

    public static List<SliceItem> findAll(Slice r3, String r4, String r5, String r6) {
        return findAll(r3, r4, new String[]{r5}, new String[]{r6});
    }

    public static List<SliceItem> findAll(SliceItem r3, String r4, String r5, String r6) {
        return findAll(r3, r4, new String[]{r5}, new String[]{r6});
    }

    public static List<SliceItem> findAll(Slice r1, final String r2, final String[] r3, final String[] r4) {
        return collect(filter(stream(r1), new AnonymousClass2(r2, r3, r4)));
    }

    public static List<SliceItem> findAll(SliceItem r1, final String r2, final String[] r3, final String[] r4) {
        return collect(filter(stream(r1), new AnonymousClass3(r2, r3, r4)));
    }

    public static SliceItem find(Slice r3, String r4, String r5, String r6) {
        return find(r3, r4, new String[]{r5}, new String[]{r6});
    }

    public static SliceItem find(Slice r2, String r3) {
        String[] r1 = (String[]) null;
        return find(r2, r3, null, null);
    }

    public static SliceItem find(SliceItem r2, String r3) {
        String[] r1 = (String[]) null;
        return find(r2, r3, null, null);
    }

    public static SliceItem find(SliceItem r3, String r4, String r5, String r6) {
        return find(r3, r4, new String[]{r5}, new String[]{r6});
    }

    public static SliceItem find(Slice r1, final String r2, final String[] r3, final String[] r4) {
        return (SliceItem) findFirst(filter(stream(r1), new AnonymousClass4(r2, r3, r4)), null);
    }

    public static SliceItem findSubtype(Slice r1, final String r2, final String r3) {
        return (SliceItem) findFirst(filter(stream(r1), new AnonymousClass5(r2, r3)), null);
    }

    public static SliceItem findSubtype(SliceItem r1, final String r2, final String r3) {
        return (SliceItem) findFirst(filter(stream(r1), new AnonymousClass6(r2, r3)), null);
    }

    public static SliceItem find(SliceItem r1, final String r2, final String[] r3, final String[] r4) {
        return (SliceItem) findFirst(filter(stream(r1), new AnonymousClass7(r2, r3, r4)), null);
    }

    static boolean checkFormat(SliceItem r0, String r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.equals(r0.getFormat()) == true) goto L7;
        return false;
    }

    static boolean checkSubtype(SliceItem r0, String r1) {
        if (r1 != null) goto L4;
    L7:
        return true;
    L4:
        if (r1.equals(r0.getSubType()) == true) goto L7;
        return false;
    }

    public static Iterator<SliceItem> stream(SliceItem r1) {
        ArrayList r0 = new ArrayList();
        r0.add(r1);
        return getSliceItemStream(r0);
    }

    public static Iterator<SliceItem> stream(Slice r1) {
        ArrayList r0 = new ArrayList();
        if (r1 == null) goto L6;
        r0.addAll(r1.getItems());
    L6:
        return getSliceItemStream(r0);
    }

    private static Iterator<SliceItem> getSliceItemStream(final ArrayList<SliceItem> r1) {
        return new AnonymousClass8(r1);
    }

    public static SliceItem findTopLevelItem(Slice r3, String r4, String r5, String[] r6, String[] r7) {
        List<SliceItem> r8 = r3.getItems();
        int r0 = 0;
    L4:
        if (r0 >= r8.size()) goto L15;
        SliceItem r1 = r8.get(r0);
        if (checkFormat(r1, r4) == false) goto L14;
        if (checkSubtype(r1, r5) == false) goto L14;
        if (hasHints(r1, r6) == false) goto L14;
        if (hasAnyHints(r1, r7) == true) goto L14;
        return r1;
    L14:
        r0 = r0 + 1;
        goto L4
    L15:
        return null;
    }

    private static <T> List<T> collect(Iterator<T> r2) {
        ArrayList r0 = new ArrayList();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(r2.next());
        goto L4
    L6:
        return r0;
    }

    private static <T> Iterator<T> filter(final Iterator<T> r1, final Filter<T> r2) {
        return new AnonymousClass9(r1, r2);
    }

    private static <T> T findFirst(Iterator<T> r1, T r2) {
    L3:
        if (r1.hasNext() == false) goto L7;
        T r0 = r1.next();
        if (r0 == null) goto L3;
        return r0;
    L7:
        return r2;
    }

    public static SliceItem findItem(Slice r1, final Uri r2) {
        return (SliceItem) findFirst(filter(stream(r1), new AnonymousClass10(r2)), null);
    }

    private SliceQuery() {
    }
}
