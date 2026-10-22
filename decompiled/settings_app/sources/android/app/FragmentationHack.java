package android.app;

import android.util.SparseArray;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FragmentationHack {
    private static final String TAG = "FragmentationHack";
    private static Class<?> sFragmentManagerImplClass = null;
    private static boolean sSupportLessThan25dot4 = false;

    public static void reorderIndices(androidx.fragment.app.FragmentManager r0) {
    }

    public FragmentationHack() {
    }

    static {
        Class<?> r0 = Class.forName("android.app.FragmentManagerImpl");     // Catch: ClassNotFoundException -> L9
        sFragmentManagerImplClass = r0;     // Catch: ClassNotFoundException -> L9
        Field[] r1 = r0.getDeclaredFields();     // Catch: ClassNotFoundException -> L9
        int r2 = r1.length;     // Catch: ClassNotFoundException -> L9
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L17;
        if (r1[r3].getName().equals("mAvailIndices") == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        sSupportLessThan25dot4 = true;     // Catch: ClassNotFoundException -> L9
        return;
    L17:
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isExecutingActions(FragmentManager r2) {
        if ((r2 instanceof FragmentManagerImpl) == true) goto L10;
        return false;
    L10:
        return ((FragmentManagerImpl) r2).mExecutingActions;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isExecutingActions(androidx.fragment.app.FragmentManager r1) {
        Object r2 = getValueFromHierarchy(r1, "mExecutingActions");
        if ((r2 instanceof Boolean) == true) goto L5;
    L7:
        return false;
    L5:
        if (((Boolean) r2).booleanValue() == false) goto L7;
        return true;
    }

    public static void reorderIndices(FragmentManager r2) {
        if (sSupportLessThan25dot4 == true) goto L6;
        return;
    L6:
        if (sFragmentManagerImplClass.isInstance(r2) == true) goto L18;
        return;
    L18:
        Object r3 = getValue(sFragmentManagerImplClass.cast(r2), "mAvailIndices");     // Catch: Exception -> L15
        if (r3 != null) goto L11;
        return;
    L11:
        ArrayList r4 = (ArrayList) r3;     // Catch: Exception -> L15
        if (r4.size() <= 1) goto L20;
        Collections.sort(r4, Collections.reverseOrder());     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }

    public static boolean isStateSaved(FragmentManager r2) {
        if (sFragmentManagerImplClass.isInstance(r2) == true) goto L13;
        return false;
    L13:
        Object r3 = getValue(sFragmentManagerImplClass.cast(r2), "mStateSaved");     // Catch: Exception -> L10
        if (r3 != null) goto L8;
        return false;
    L8:
        return ((Boolean) r3).booleanValue();
    L10:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isStateSaved(androidx.fragment.app.FragmentManager r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.isStateSaved() == false) goto L6;
        return true;
    }

    public static void setStateSaved(FragmentManager r1, boolean r2) {
        if (sFragmentManagerImplClass.isInstance(r1) == true) goto L10;
        return;
    L10:
        setValue(sFragmentManagerImplClass.cast(r1), "mStateSaved", Boolean.valueOf(r2));     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setStateSaved(androidx.fragment.app.FragmentManager r1, boolean r2) {
        setValueFromHierarchy(r1, "mStateSaved", Boolean.valueOf(r2));
    }

    public static List<Fragment> getActiveFragments(FragmentManager r2) {
        if (sFragmentManagerImplClass.isInstance(r2) == false) goto L5;
        Object r0 = getValue(sFragmentManagerImplClass.cast(r2), "mActive");     // Catch: Exception -> L20
        Object r3 = getValue(sFragmentManagerImplClass.cast(r2), "mAdded");     // Catch: Exception -> L20
        if (r3 == null) goto L9;
        r0 = r3;
    L9:
        if (r0 != null) goto L13;
        return Collections.EMPTY_LIST;
    L13:
        if ((r0 instanceof ArrayList) == false) goto L17;
        return getActiveList((ArrayList) r0);
    L17:
        if ((r0 instanceof SparseArray) == false) goto L23;
        return getActiveList((SparseArray) r0);
    L23:
        return Collections.EMPTY_LIST;
    L20:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L5:
        return Collections.EMPTY_LIST;
    }

    public static List<androidx.fragment.app.Fragment> getActiveFragments(androidx.fragment.app.FragmentManager r2) {
        if (r2 == null) goto L4;
        List<androidx.fragment.app.Fragment> r3 = r2.getFragments();
        if (r3 == null) goto L18;
        if (r3.isEmpty() == true) goto L18;
        ArrayList r0 = new ArrayList(r3.size());
        Iterator<androidx.fragment.app.Fragment> r4 = r3.iterator();
    L12:
        if (r4.hasNext() == false) goto L16;
        androidx.fragment.app.Fragment r1 = r4.next();
        if (r1 == null) goto L12;
        r0.add(r1);
        goto L12
    L16:
        return r0;
    L18:
        return Collections.emptyList();
    L4:
        return Collections.emptyList();
    }

    private static List<Fragment> getActiveList(ArrayList<Fragment> r4) {
        if (r4 == null) goto L4;
        int r0 = r4.size();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1.add(r4.get(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    L4:
        return Collections.EMPTY_LIST;
    }

    private static List<Fragment> getActiveList(SparseArray<Fragment> r4) {
        if (r4 == null) goto L4;
        int r0 = r4.size();
        ArrayList r1 = new ArrayList(r0);
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L8;
        r1.add(r4.valueAt(r2));
        r2 = r2 + 1;
        goto L6
    L8:
        return r1;
    L4:
        return Collections.EMPTY_LIST;
    }

    private static Object getValue(Object r1, String r2) throws Exception {
        Field r3 = r1.getClass().getDeclaredField(r2);     // Catch: Exception -> L5
        r3.setAccessible(true);     // Catch: Exception -> L5
        return r3.get(r1);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static Object getValueFromHierarchy(Object r4, String r5) {
        if (r4 != null) goto L5;
        return null;
    L5:
        Class<?> r1 = r4.getClass();
    L6:
        if (r1 == null) goto L10;
        Field r2 = r1.getDeclaredField(r5);     // Catch: Exception -> L9
        r2.setAccessible(true);     // Catch: Exception -> L9
        return r2.get(r4);
    L9:
        r1 = r1.getSuperclass();
        goto L6
    L10:
        return null;
    }

    private static void setValue(Object r1, String r2, Object r3) {
        Field r4 = r1.getClass().getDeclaredField(r2);     // Catch: Exception -> L5
        r4.setAccessible(true);     // Catch: Exception -> L5
        r4.set(r1, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
    }

    private static void setValueFromHierarchy(Object r3, String r4, Object r5) {
        if (r3 != null) goto L4;
        return;
    L4:
        Class<?> r0 = r3.getClass();
    L5:
        if (r0 == null) goto L9;
        Field r1 = r0.getDeclaredField(r4);     // Catch: Exception -> L8
        r1.setAccessible(true);     // Catch: Exception -> L8
        r1.set(r3, r5);     // Catch: Exception -> L8
        return;
    L8:
        r0 = r0.getSuperclass();
        goto L5
    }
}
