package com.bytedance.boost_multidex;

import android.content.SharedPreferences;
import dalvik.system.DexFile;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
abstract class DexLoader {
    ElementConstructor mElementConstructor;

    /* JADX INFO: renamed from: com.bytedance.boost_multidex.DexLoader$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    interface ElementConstructor {
        Object newInstance(File r1, Object r2);
    }

    private static class ICSElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        ICSElementConstructor(Class<?> r5) {
            Constructor<?> r6 = r5.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
            this.mConstructor = r6;
            r6.setAccessible(true);
        }

        @Override // com.bytedance.boost_multidex.DexLoader.ElementConstructor
        public Object newInstance(File r3, Object r4) {
            return this.mConstructor.newInstance(new Object[]{r3, null, r4});
        }
    }

    private static class JBMR11ElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        JBMR11ElementConstructor(Class<?> r5) {
            Constructor<?> r6 = r5.getConstructor(new Class[]{File.class, File.class, DexFile.class});
            this.mConstructor = r6;
            r6.setAccessible(true);
        }

        @Override // com.bytedance.boost_multidex.DexLoader.ElementConstructor
        public Object newInstance(File r3, Object r4) {
            return this.mConstructor.newInstance(new Object[]{r3, null, r4});
        }
    }

    private static class JBMR2ElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        JBMR2ElementConstructor(Class<?> r5) {
            Constructor<?> r6 = r5.getConstructor(new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
            this.mConstructor = r6;
            r6.setAccessible(true);
        }

        @Override // com.bytedance.boost_multidex.DexLoader.ElementConstructor
        public Object newInstance(File r3, Object r4) {
            return this.mConstructor.newInstance(new Object[]{r3, Boolean.FALSE, null, r4});
        }
    }

    private static class KKElementConstructor implements ElementConstructor {
        private final Constructor<?> mConstructor;

        KKElementConstructor(Class<?> r5) {
            Constructor<?> r6 = Utility.findConstructor(r5, new Class[]{File.class, Boolean.TYPE, File.class, DexFile.class});
            this.mConstructor = r6;
            r6.setAccessible(true);
        }

        @Override // com.bytedance.boost_multidex.DexLoader.ElementConstructor
        public Object newInstance(File r3, Object r4) {
            return this.mConstructor.newInstance(new Object[]{r3, Boolean.FALSE, null, r4});
        }
    }

    private static class V14 extends DexLoader {
        private V14() {
            Class<?> r0 = Class.forName("dalvik.system.DexPathList$Element");     // Catch: Exception -> L15
            ElementConstructor r1 = new ICSElementConstructor(r0);     // Catch: Exception -> L6
        L7:
            if (r1 == null) goto L24;
        L10:
            if (r1 == null) goto L20;
        L13:
            this.mElementConstructor = r1;
            return;
        L20:
            r1 = new JBMR2ElementConstructor(r0);     // Catch: Exception -> L19
            goto L13
        L24:
            r1 = new JBMR11ElementConstructor(r0);     // Catch: Exception -> L18
        L6:
            r1 = null;
        L15:
            e = move-exception;
            Monitor.get().logError("can not find DexPathList$Element", e);
        }

        /* synthetic */ V14(AnonymousClass1 r1) {
            this();
        }
    }

    private static class V19 extends DexLoader {
        private V19() {
            this.mElementConstructor = new KKElementConstructor(Class.forName("dalvik.system.DexPathList$Element"));     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            Monitor.get().logError("fail to get Element constructor", th);
        }

        /* synthetic */ V19(AnonymousClass1 r1) {
            this();
        }
    }

    DexLoader() {
    }

    static DexLoader create(int r2) {
        AnonymousClass1 r0 = null;
        if (r2 < 19) goto L7;
        return new V19(r0);
    L7:
        if (r2 < 14) goto L11;
        return new V14(r0);
    L11:
        throw new UnsupportedOperationException("only support SDK_INT >= 14, give up when < 14");
    }

    private Object[] makeDexElements(List<DexHolder> r8, SharedPreferences r9) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r8.size()) goto L17;
        DexHolder r2 = r8.get(r1);
    L6:
        Object r3 = r2.toDexListElement(this.mElementConstructor);
    L7:
        if (r3 != null) goto L12;
        if (r2 == null) goto L12;
        Monitor.get().logWarning("Load faster dex in holder " + r2.toString());
        r2 = r2.toFasterHolder(r9);
        if (r2 == null) goto L7;
    L12:
        if (r3 == null) goto L15;
        Monitor.get().logInfo("Load dex in holder " + r2.toString());
        r8.set(r1, r2);
        r0.add(r3);
        String r4 = r2.toString();
        Result.get().addDexInfo(r4);
        Monitor.get().logInfo("Add info: " + r4);
        r1 = r1 + 1;
        goto L4
    L15:
        throw new RuntimeException("Fail to load dex, index is " + r1);
    L17:
        return r0.toArray();
    }

    void install(ClassLoader r7, List<DexHolder> r8) {
        Object r9 = Utility.findFieldRecursively(r7.getClass(), "pathList").get(r7);
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 >= r8.size()) goto L6;
        DexHolder r2 = r8.get(r1);
        r0.add(r2.toDexListElement(this.mElementConstructor));
        Monitor.get().logInfo("Install holder: " + r2.getClass().getName() + ", index " + r1);
        r1 = r1 + 1;
        goto L4
    L6:
        Utility.expandFieldArray(r9, "dexElements", r0.toArray());
    }

    void install(ClassLoader r3, List<DexHolder> r4, SharedPreferences r5) {
        Utility.expandFieldArray(Utility.findFieldRecursively(r3.getClass(), "pathList").get(r3), "dexElements", makeDexElements(r4, r5));
    }
}
