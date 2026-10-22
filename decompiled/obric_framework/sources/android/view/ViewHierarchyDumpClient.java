package android.view;

import android.text.TextUtils;
import android.util.Slog;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.ScrollView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewHierarchyDumpClient {
    public static final String EXTRA_VHD_VIEW_HASH_CODE = "android.view.ViewStructure.extra.vhd.VIEW_HASH_CODE";
    public static final String EXTRA_VHD_VIEW_PROPERTY_PREFIX = "android.view.ViewStructure.extra.vhd.prop.";
    public static final String EXTRA_VHD_VIEW_REAL_CLASS_NAME = "android.view.ViewStructure.extra.vhd.REAL_CLASS_NAME";
    private static final String TAG = "VHD-Client";
    private final IViewHierarchyDumpExtension[] dumpers;

    private static class AndroidXScrollViewDumpExtension implements IViewHierarchyDumpExtension {
        /* synthetic */ AndroidXScrollViewDumpExtension(ViewHierarchyDumpClientIA r1) {
            this();
        }

        private AndroidXScrollViewDumpExtension() {
        }

        @Override // android.view.ViewHierarchyDumpClient.IViewHierarchyDumpExtension
        public boolean maybeDumpView(View view, ViewStructure structure) {
            if (ViewHierarchyDumpClient.m50$$Nest$smisSwipeListForAndroidxComponent(view) == false) goto L12;
            ViewHierarchyDumpClient.m49$$Nest$smdumpScrollRegions(view, structure);     // Catch: Exception -> L6
            return false;
        L12:
            return false;
        L7:
            return false;
        }
    }

    private static class BuiltInLayoutsDumpExtension implements IViewHierarchyDumpExtension {
        /* synthetic */ BuiltInLayoutsDumpExtension(ViewHierarchyDumpClientIA r1) {
            this();
        }

        private BuiltInLayoutsDumpExtension() {
        }

        @Override // android.view.ViewHierarchyDumpClient.IViewHierarchyDumpExtension
        public boolean maybeDumpView(View view, ViewStructure structure) {
            String orientation = getOrientation(view);     // Catch: IOException -> L12
            if (orientation != null) goto L7;
            return false;
        L7:
            if ((view instanceof ListView) == false) goto L9;
            ListView lv = (ListView) view;     // Catch: IOException -> L12
            ViewHierarchyDumpClient.m51$$Nest$smwriteVHDProperty(structure, "scl_amt", lv.getMaxScrollAmount());     // Catch: IOException -> L12
        L9:
            ViewHierarchyDumpClient.m52$$Nest$smwriteVHDProperty(structure, "scl_ori", orientation);     // Catch: IOException -> L12
            ViewHierarchyDumpClient.m49$$Nest$smdumpScrollRegions(view, structure);     // Catch: IOException -> L12
            return true;
        L12:
            e = move-exception;
            Slog.w(ViewHierarchyDumpClient.TAG, "Could not get scroll orientation for view", e);
            return false;
        }

        private static String getOrientation(View view) {
            if ((view instanceof HorizontalScrollView) == false) goto L6;
            return "H";
        L6:
            if ((view instanceof ScrollView) == false) goto L8;
        L9:
            return "V";
        L8:
            if ((view instanceof ListView) == true) goto L9;
            return null;
        }
    }

    private interface IViewHierarchyDumpExtension {
        boolean maybeDumpView(View r1, ViewStructure r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smdumpScrollRegions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m49$$Nest$smdumpScrollRegions(View r0, ViewStructure r1) {
        dumpScrollRegions(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$smisSwipeListForAndroidxComponent, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m50$$Nest$smisSwipeListForAndroidxComponent(Object r0) {
        return isSwipeListForAndroidxComponent(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smwriteVHDProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m51$$Nest$smwriteVHDProperty(ViewStructure r0, String r1, int r2) {
        writeVHDProperty(r0, r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smwriteVHDProperty, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m52$$Nest$smwriteVHDProperty(ViewStructure r0, String r1, String r2) {
        writeVHDProperty(r0, r1, r2);
    }

    public ViewHierarchyDumpClient() {
        ViewHierarchyDumpClientIA r2 = null;
        this.dumpers = new IViewHierarchyDumpExtension[]{new BuiltInLayoutsDumpExtension(r2), new AndroidXScrollViewDumpExtension(r2)};
    }

    public void populateStructureExtras(View view, ViewStructure structure) {
        populateStructureExtrasUnsafe(view, structure);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Slog.w(TAG, "Could not populateStructureExtras", t);
    }

    private void populateStructureExtrasUnsafe(View view, ViewStructure structure) {
        structure.getExtras().putString(EXTRA_VHD_VIEW_REAL_CLASS_NAME, view.getClass().getName());
        structure.getExtras().putInt(EXTRA_VHD_VIEW_HASH_CODE, view.hashCode());
        writeViewProperties(view, structure);
    }

    private void writeViewProperties(View view, ViewStructure structure) {
        IViewHierarchyDumpExtension[] r0 = this.dumpers;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        IViewHierarchyDumpExtension dumpExtension = r0[r2];
        boolean dumped = dumpExtension.maybeDumpView(view, structure);
        if (dumped == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return;
    }

    private static void writeVHDProperty(ViewStructure structure, String name, String value) {
        if (value != null) goto L4;
        return;
    L4:
        structure.getExtras().putString(EXTRA_VHD_VIEW_PROPERTY_PREFIX + name, value);
    }

    private static void writeVHDProperty(ViewStructure structure, String name, boolean value) {
        structure.getExtras().putBoolean(EXTRA_VHD_VIEW_PROPERTY_PREFIX + name, value);
    }

    private static void writeVHDProperty(ViewStructure structure, String name, int value) {
        structure.getExtras().putInt(EXTRA_VHD_VIEW_PROPERTY_PREFIX + name, value);
    }

    private static void dumpScrollRegions(View view, ViewStructure structure) throws IOException {
        int verticalScrollRange = view.computeVerticalScrollRange();
        int verticalScrollExtent = view.computeVerticalScrollExtent();
        int horizontalScrollRange = view.computeHorizontalScrollRange();
        int horizontalScrollExtent = view.computeHorizontalScrollExtent();
        if (verticalScrollRange <= verticalScrollExtent) goto L5;
        writeVHDProperty(structure, "scl_v", true);
    L7:
        if (horizontalScrollRange <= horizontalScrollExtent) goto L9;
        writeVHDProperty(structure, "scl_h", true);
    L10:
        writeVHDProperty(structure, "scl_up", view.canScrollVertically(-1));
        writeVHDProperty(structure, "scl_down", view.canScrollVertically(1));
        writeVHDProperty(structure, "scl_left", view.canScrollHorizontally(-1));
        writeVHDProperty(structure, "scl_right", view.canScrollHorizontally(1));
        int verticalScrollOffset = view.computeVerticalScrollOffset();
        writeVHDProperty(structure, "scl_ran", verticalScrollRange);
        writeVHDProperty(structure, "scl_off", verticalScrollOffset);
        writeVHDProperty(structure, "scl_ext", verticalScrollExtent);
        return;
    L9:
        writeVHDProperty(structure, "scl_h", false);
        goto L10
    L5:
        writeVHDProperty(structure, "scl_v", false);
        goto L7
    }

    private static boolean isSwipeListForAndroidxComponent(Object object) {
        if (isInstanceOf(object, "RecyclerView") == false) goto L5;
    L12:
        return true;
    L5:
        if (isInstanceOf(object, "ViewPager") == true) goto L12;
        if (isInstanceOf(object, "ViewPager2") == true) goto L12;
        if (isInstanceOf(object, "NestedScrollView") == true) goto L12;
        return false;
    }

    private static boolean isInstanceOf(Object object, String className) {
        if (TextUtils.equals(className, object.getClass().getSimpleName()) == false) goto L5;
        return true;
    L5:
        List<Class<?>> superClasses = getSuperClass(object.getClass());
        Iterator<Class<?>> r2 = superClasses.iterator();
    L7:
        if (r2.hasNext() == false) goto L12;
        Class<?> clazz = r2.next();
        if (TextUtils.equals(className, clazz.getSimpleName()) == false) goto L7;
        return true;
    L12:
        return false;
    }

    private static List<Class<?>> getSuperClass(Class<?> clazz) {
        List<Class<?>> clazzs = new ArrayList();
        Class<?> suCl = clazz.getSuperclass();
    L3:
        if (suCl == null) goto L5;
        clazzs.add(suCl);
        suCl = suCl.getSuperclass();
        goto L3
    L5:
        return clazzs;
    }
}
