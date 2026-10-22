package d.h.a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.text.TextUtils;
import android.util.LruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LruCache<Class, String> f17023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SparseArray<String> f17024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Set<Integer> f17025c;

    static {
        f17023a = new LruCache(100);
    }

    static int a(@NonNull List r0, int r1) {
        return r1 % r0.size();
    }

    private static String b(String r0) {
        return r0;
    }

    @Nullable
    private static Activity c(@NonNull Context r2) {
        if ((r2 instanceof ContextWrapper) == true) goto L5;
        return null;
    L5:
        ContextWrapper r3 = (ContextWrapper) r2;
        if ((r3 instanceof Activity) == true) goto L11;
        r2 = r3.getBaseContext();
        if ((r2 instanceof ContextWrapper) == true) goto L5;
        return null;
    L11:
        return (Activity) r3;
    }

    @RequiresApi(api = 11)
    private static int d(View r1, ViewGroup r2) {
        if (b.b(r2) == false) goto L7;
        return ((RecyclerView) r2).getChildAdapterPosition(r1);
    L7:
        if (b.e(r2) == false) goto L13;
        return ((RecyclerView) r2).getChildAdapterPosition(r1);
    L11:
        return ((RecyclerView) r2).getChildPosition(r1);
    L13:
        if (b.f16977a == true) goto L19;
        return -1;
    L19:
        return b.i(r2, r1);
    }

    static String e(View r3, boolean r4) {
        if (r4 == false) goto L6;
        return null;
    L6:
        if (f17024b != null) goto L9;
        f17024b = new SparseArray();
    L9:
        if (f17025c != null) goto L11;
        f17025c = new HashSet();
    L11:
        int r5 = r3.getId();
        if (r5 > 2130706432) goto L14;
    L21:
        return null;
    L14:
        if (f17025c.contains(Integer.valueOf(r5)) == true) goto L21;
        String r1 = f17024b.get(r5);
        if (r1 == null) goto L22;
        return r1;
    L22:
        String r6 = r3.getResources().getResourceEntryName(r5);     // Catch: Exception -> L20
        f17024b.put(r5, r6);     // Catch: Exception -> L20
        return r6;
    L20:
        f17025c.add(Integer.valueOf(r5));
        goto L21
    }

    static String f(Class r2) {
        String r0 = f17023a.get(r2);
        if (TextUtils.isEmpty(r0) == false) goto L8;
        r0 = r2.getSimpleName();
        if (TextUtils.isEmpty(r0) == false) goto L7;
        r0 = "Anonymous";
    L7:
        f17023a.put(r2, r0);
    L8:
        return r0;
    }

    @Nullable
    public static String g(@Nullable View r17) {
        ArrayList r1 = null;
        if (r17 != null) goto L5;
        return null;
    L5:
        Activity r2 = c(r17.getContext());
        if (r2 != null) goto L8;
        return null;
    L8:
        ArrayList r3 = new ArrayList(8);
        ViewParent r4 = r17.getParent();
        r3.add(r17);
    L10:
        if ((r4 instanceof ViewGroup) == false) goto L12;
        r3.add((ViewGroup) r4);
        r4 = r4.getParent();
        goto L10
    L12:
        int r0 = r3.size() - 1;
        View r5 = (View) r3.get(r0);
        k.b();
        String r6 = k.a(r5);
        if (k.c(r5) == true) goto L20;
        if ((r5.getParent() instanceof View) == true) goto L20;
        r6 = r6 + "/" + f(r5.getClass());
        String r7 = e(r5, false);
        if (r7 == null) goto L20;
        r6 = r6 + "#" + r7;
    L20:
        if ((r5 instanceof ViewGroup) == false) goto L78;
        ViewGroup r8 = (ViewGroup) r5;
        int r9 = r0 - 1;
        String r10 = r6;
    L22:
        if (r9 < 0) goto L78;
        View r11 = (View) r3.get(r9);
        String r12 = f(r11.getClass());
        int r13 = r8.indexOfChild(r11);
        if (b.c(r8) == false) goto L27;
    L25:
        r13 = ((ViewPager) r8).getCurrentItem();
    L38:
        if ((r8 instanceof ExpandableListView) == false) goto L55;
        ExpandableListView r14 = (ExpandableListView) r8;
        long r15 = r14.getExpandableListPosition(r13);
        ArrayList r16 = r3;
        if (ExpandableListView.getPackedPositionType(r15) == 2) goto L42;
        int r18 = ExpandableListView.getPackedPositionGroup(r15);
        int r19 = ExpandableListView.getPackedPositionChild(r15);
        if (r19 == (-1)) goto L51;
        if (r1 != null) goto L50;
        r1 = new ArrayList(4);
    L50:
        r1.add(String.valueOf(r18));
        r1.add(String.valueOf(r19));
        String r20 = r10 + "/ELVG[-]/ELVC[-]/" + r12 + "[0]";
        String r21 = r6 + "/ELVG[" + r18 + "]/ELVC[" + r19 + "]/" + r12 + "[0]";
    L54:
        String r22 = r20;
    L65:
        r10 = r22;
        r6 = r21;
    L74:
        if ((r11 instanceof ViewGroup) == false) goto L78;
        r8 = (ViewGroup) r11;
        r9 = r9 - 1;
        r3 = r16;
        goto L22
    L51:
        if (r1 != null) goto L53;
        r1 = new ArrayList(4);
    L53:
        r1.add(String.valueOf(r18));
        r20 = r10 + "/ELVG[-]/" + r12 + "[0]";
        r21 = r6 + "/ELVG[" + r18 + "]/" + r12 + "[0]";
        goto L54
    L42:
        if (r13 >= r14.getHeaderViewsCount()) goto L44;
        StringBuilder r23 = new StringBuilder();
        r23.append(r6);
        String r24 = "/ELH[";
        r23.append("/ELH[");
        r23.append(r13);
        r23.append("]/");
        r23.append(r12);
        r23.append("[0]");
        r21 = r23.toString();
        StringBuilder r110 = new StringBuilder();
    L45:
        r110.append(r10);
        r110.append(r24);
        r110.append(r13);
        r110.append("]/");
        r110.append(r12);
        r110.append("[0]");
        r22 = r110.toString();
        goto L65
    L44:
        r13 = r13 - (r14.getCount() - r14.getFooterViewsCount());
        StringBuilder r25 = new StringBuilder();
        r25.append(r6);
        r24 = "/ELF[";
        r25.append("/ELF[");
        r25.append(r13);
        r25.append("]/");
        r25.append(r12);
        r25.append("[0]");
        r21 = r25.toString();
        r110 = new StringBuilder();
        goto L45
    L55:
        r16 = r3;
        if (h(r8) == false) goto L67;
        Object r26 = r8.getTag(84159247);
        if ((r26 instanceof List) == false) goto L62;
        List r27 = (List) r26;
        if (r27.size() <= 0) goto L62;
        r13 = a(r27, r13);
        i((String) r27.get(r13));
    L62:
        if (r1 != null) goto L64;
        r1 = new ArrayList(4);
    L64:
        r1.add(String.valueOf(r13));
        r22 = r10 + "/" + r12 + "[-]";
        r21 = r6 + "/" + r12 + "[" + r13 + "]";
        goto L65
    L67:
        if (b.h(r8) == false) goto L69;
    L71:
        String r28 = r6 + "/" + r12 + "[0]";
        StringBuilder r29 = new StringBuilder();
        r29.append(r10);
        r29.append("/");
        r29.append(r12);
        r29.append("[0]");
    L72:
        r6 = r28;
        r10 = r29.toString();
        goto L74
    L69:
        if (b.f(r8) == true) goto L71;
        r28 = r6 + "/" + r12 + "[" + r13 + "]";
        r29 = new StringBuilder();
        r29.append(r10);
        r29.append("/");
        r29.append(r12);
        r29.append("[");
        r29.append(r13);
        r29.append("]");
        goto L72
    L27:
        if (b.g(r8) == true) goto L25;
        if ((r8 instanceof AdapterView) == false) goto L33;
        r13 = r13 + ((AdapterView) r8).getFirstVisiblePosition();
        goto L38
    L33:
        if (b.d(r8) == false) goto L38;
        int r111 = d(r11, r8);
        if (r111 < 0) goto L38;
        r13 = r111;
    L78:
        return r2.getClass().getSimpleName() + "/" + r6;
    }

    static boolean h(View r1) {
        if ((r1 instanceof AdapterView) == false) goto L5;
    L14:
        return true;
    L5:
        if (b.b(r1) == true) goto L14;
        if (b.c(r1) == true) goto L14;
        if (b.e(r1) == true) goto L14;
        if (b.g(r1) == true) goto L14;
        return false;
    }

    static String i(String r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        if (TextUtils.isEmpty(r2) == false) goto L8;
    L10:
        b(r2);
        return r2;
    L8:
        if (r2.length() <= 20) goto L10;
        r2 = r2.substring(0, 20);
        goto L10
    }
}
