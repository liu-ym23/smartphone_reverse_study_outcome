package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;

/* JADX INFO: loaded from: classes6.dex */
class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final FindState[] FIND_STATE_POOL = null;
    private static final Map<Class<?>, List<SubscriberMethod>> METHOD_CACHE = null;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int POOL_SIZE = 4;
    private static final int SYNTHETIC = 4096;
    private final boolean ignoreGeneratedIndex;
    private final boolean strictMethodVerification;
    private List<SubscriberInfoIndex> subscriberInfoIndexes;

    static class FindState {
        final Map<Class, Object> anyMethodByEventType;
        Class<?> clazz;
        final StringBuilder methodKeyBuilder;
        boolean skipSuperClasses;
        Class<?> subscriberClass;
        final Map<String, Class> subscriberClassByMethodKey;
        SubscriberInfo subscriberInfo;
        final List<SubscriberMethod> subscriberMethods;

        FindState() {
            this.subscriberMethods = new ArrayList();
            this.anyMethodByEventType = new HashMap();
            this.subscriberClassByMethodKey = new HashMap();
            this.methodKeyBuilder = new StringBuilder(128);
        }

        void initForSubscriber(Class<?> r1) {
            this.clazz = r1;
            this.subscriberClass = r1;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        void recycle() {
            this.subscriberMethods.clear();
            this.anyMethodByEventType.clear();
            this.subscriberClassByMethodKey.clear();
            this.methodKeyBuilder.setLength(0);
            this.subscriberClass = null;
            this.clazz = null;
            this.skipSuperClasses = false;
            this.subscriberInfo = null;
        }

        boolean checkAdd(Method r3, Class<?> r4) {
            Object r0 = this.anyMethodByEventType.put(r4, r3);
            if (r0 != null) goto L7;
            return true;
        L7:
            if ((r0 instanceof Method) == false) goto L14;
            if (checkAddWithMethodSignature((Method) r0, r4) == false) goto L12;
            this.anyMethodByEventType.put(r4, this);
            goto L14
        L12:
            throw new IllegalStateException();
        L14:
            return checkAddWithMethodSignature(r3, r4);
        }

        private boolean checkAddWithMethodSignature(Method r4, Class<?> r5) {
            this.methodKeyBuilder.setLength(0);
            this.methodKeyBuilder.append(r4.getName());
            this.methodKeyBuilder.append('>').append(r5.getName());
            String r6 = this.methodKeyBuilder.toString();
            Class<?> r7 = r4.getDeclaringClass();
            Class r0 = this.subscriberClassByMethodKey.put(r6, r7);
            if (r0 != null) goto L5;
            return true;
        L5:
            if (r0.isAssignableFrom(r7) == true) goto L11;
            this.subscriberClassByMethodKey.put(r6, r0);
            return false;
        L11:
            return true;
        }

        void moveToSuperclass() {
            if (this.skipSuperClasses == false) goto L5;
            this.clazz = null;
            return;
        L5:
            Class<? super Object> r0 = this.clazz.getSuperclass();
            this.clazz = r0;
            String r1 = r0.getName();
            if (r1.startsWith("java.") == false) goto L8;
        L11:
            this.clazz = null;
            return;
        L8:
            if (r1.startsWith("javax.") == true) goto L11;
            if (r1.startsWith("android.") == true) goto L11;
        }
    }

    static {
        METHOD_CACHE = new ConcurrentHashMap();
        FIND_STATE_POOL = new FindState[4];
    }

    SubscriberMethodFinder(List<SubscriberInfoIndex> r1, boolean r2, boolean r3) {
        this.subscriberInfoIndexes = r1;
        this.strictMethodVerification = r2;
        this.ignoreGeneratedIndex = r3;
    }

    List<SubscriberMethod> findSubscriberMethods(Class<?> r3) {
        Map<Class<?>, List<SubscriberMethod>> r0 = METHOD_CACHE;
        List<SubscriberMethod> r1 = r0.get(r3);
        if (r1 == null) goto L6;
        return r1;
    L6:
        if (this.ignoreGeneratedIndex == false) goto L8;
        List<SubscriberMethod> r2 = findUsingReflection(r3);
    L10:
        if (r2.isEmpty() == true) goto L14;
        r0.put(r3, r2);
        return r2;
    L14:
        throw new EventBusException("Subscriber " + r3 + " and its super classes have no public methods with the @Subscribe annotation");
    L8:
        r2 = findUsingInfo(r3);
        goto L10
    }

    private List<SubscriberMethod> findUsingInfo(Class<?> r7) {
        FindState r0 = prepareFindState();
        r0.initForSubscriber(r7);
    L4:
        if (r0.clazz == null) goto L16;
        r0.subscriberInfo = getSubscriberInfo(r0);
        if (r0.subscriberInfo == null) goto L13;
        SubscriberMethod[] r8 = r0.subscriberInfo.getSubscriberMethods();
        int r1 = r8.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L14;
        SubscriberMethod r3 = r8[r2];
        if (r0.checkAdd(r3.method, r3.eventType) == false) goto L12;
        r0.subscriberMethods.add(r3);
    L12:
        r2 = r2 + 1;
    L14:
        r0.moveToSuperclass();
        goto L4
    L13:
        findUsingReflectionInSingleClass(r0);
        goto L14
    L16:
        return getMethodsAndRelease(r0);
    }

    private List<SubscriberMethod> getMethodsAndRelease(FindState r5) {
        ArrayList r4 = new ArrayList(r5.subscriberMethods);
        r5.recycle();
        FindState[] r0 = FIND_STATE_POOL;
        monitor-enter(r0);
        int r1 = 0;
    L6:
        if (r1 >= 4) goto L11;
        FindState[] r2 = FIND_STATE_POOL;     // Catch: Throwable -> L13
        if (r2[r1] == null) goto L9;
        r1 = r1 + 1;     // Catch: Throwable -> L13
        goto L6
    L9:
        r2[r1] = r5;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r4;
    }

    private FindState prepareFindState() {
        FindState[] r4 = FIND_STATE_POOL;
        monitor-enter(r4);
        int r0 = 0;
    L6:
        if (r0 >= 4) goto L13;
        FindState[] r1 = FIND_STATE_POOL;     // Catch: Throwable -> L16
        FindState r2 = r1[r0];     // Catch: Throwable -> L16
        if (r2 != null) goto L9;
        r0 = r0 + 1;     // Catch: Throwable -> L16
        goto L6
    L9:
        r1[r0] = null;     // Catch: Throwable -> L16
        monitor-exit(r4);     // Catch: Throwable -> L16
        return r2;
    L16:
        th = move-exception;
        throw th;
    L13:
        monitor-exit(r4);     // Catch: Throwable -> L16
        return new FindState();
    }

    private SubscriberInfo getSubscriberInfo(FindState r4) {
        if (r4.subscriberInfo != null) goto L5;
    L9:
        List<SubscriberInfoIndex> r3 = this.subscriberInfoIndexes;
        if (r3 == null) goto L17;
        Iterator<SubscriberInfoIndex> r5 = r3.iterator();
    L13:
        if (r5.hasNext() == false) goto L22;
        SubscriberInfo r0 = r5.next().getSubscriberInfo(r4.clazz);
        if (r0 == null) goto L13;
        return r0;
    L22:
        return null;
    L17:
        return null;
    L5:
        if (r4.subscriberInfo.getSuperSubscriberInfo() == null) goto L9;
        SubscriberInfo r1 = r4.subscriberInfo.getSuperSubscriberInfo();
        if (r4.clazz != r1.getSubscriberClass()) goto L9;
        return r1;
    }

    private List<SubscriberMethod> findUsingReflection(Class<?> r2) {
        FindState r0 = prepareFindState();
        r0.initForSubscriber(r2);
    L4:
        if (r0.clazz == null) goto L7;
        findUsingReflectionInSingleClass(r0);
        r0.moveToSuperclass();
        goto L4
    L7:
        return getMethodsAndRelease(r0);
    }

    private void findUsingReflectionInSingleClass(FindState r15) {
        Method[] r1 = r15.clazz.getDeclaredMethods();     // Catch: Throwable -> L5
    L6:
        int r2 = r1.length;
        int r4 = 0;
    L7:
        if (r4 >= r2) goto L34;
        Method r6 = r1[r4];
        int r5 = r6.getModifiers();
        if ((r5 & 1) == 0) goto L27;
        if ((r5 & MODIFIERS_IGNORE) != 0) goto L27;
        Class<?>[] r7 = r6.getParameterTypes();
        if (r7.length != 1) goto L20;
        Subscribe r8 = (Subscribe) r6.getAnnotation(Subscribe.class);
        if (r8 == null) goto L33;
        Class<?> r9 = r7[0];
        if (r15.checkAdd(r6, r9) == false) goto L33;
        r15.subscriberMethods.add(new SubscriberMethod(r6, r9, r8.threadMode(), r8.priority(), r8.sticky()));
    L33:
        r4 = r4 + 1;
        goto L7
    L20:
        if (this.strictMethodVerification == false) goto L33;
        if (r6.isAnnotationPresent(Subscribe.class) == false) goto L33;
        throw new EventBusException("@Subscribe method " + (r6.getDeclaringClass().getName() + "." + r6.getName()) + "must have exactly 1 parameter but has " + r7.length);
    L27:
        if (this.strictMethodVerification == false) goto L33;
        if (r6.isAnnotationPresent(Subscribe.class) == false) goto L33;
        throw new EventBusException((r6.getDeclaringClass().getName() + "." + r6.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
    L34:
        return;
    L5:
        r1 = r15.clazz.getMethods();
        r15.skipSuperClasses = true;
        goto L6
    }

    static void clearCaches() {
        METHOD_CACHE.clear();
    }
}
