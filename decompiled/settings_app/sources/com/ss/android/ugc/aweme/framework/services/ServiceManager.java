package com.ss.android.ugc.aweme.framework.services;

import android.text.TextUtils;
import com.bytedance.common.utility.collection.SetFromMap;
import com.ss.android.ugc.aweme.framework.services.plugin.PluginInstaller;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class ServiceManager {
    final ConcurrentHashMap<Class<?>, Set<ServiceProvider<?>>> classServiceProviderConcurrentHashMap;
    public volatile boolean enableDynamicProxyDefault;
    final Map<Class<?>, Map<String, ServiceProvider<?>>> groupServiceProviderConcurrentHashMap;
    final Set<String> legacyServiceSet;
    final Set<Class<?>> resolvedClasses;

    /* JADX INFO: renamed from: com.ss.android.ugc.aweme.framework.services.ServiceManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class Holder {
        private static final ServiceManager INSTANCE = null;

        private Holder() {
        }

        static /* synthetic */ ServiceManager access$000() {
            return INSTANCE;
        }

        static {
            INSTANCE = new ServiceManager(null);
        }
    }

    /* synthetic */ ServiceManager(AnonymousClass1 r1) {
        this();
    }

    public void setDynamicProxyEnableDefault(boolean r1) {
        this.enableDynamicProxyDefault = r1;
    }

    public void addLegacyService(Set<String> r1) {
        this.legacyServiceSet.addAll(r1);
    }

    public void addLegacyService(String r1) {
        this.legacyServiceSet.add(r1);
    }

    public <T> T getService(Class<T> r2, boolean r3) {
        return (T) getService(r2, r3, this.enableDynamicProxyDefault);
    }

    public <T> T getService(Class<T> r2) {
        return (T) getService(r2, false);
    }

    public <T> T getService(Class<T> r2, boolean r3, boolean r4) {
        return (T) getService(r2, r3, r4, false);
    }

    public <T> T getServiceForReal(Class<T> r4) {
        return (T) getService(r4, false, this.enableDynamicProxyDefault, true);
    }

    public <T> T getService(Class<T> r7, boolean r8, boolean r9, boolean r10) {
        if (r10 == false) goto L5;
    L10:
        T r2 = null;
        boolean r3 = false;
    L11:
        Set<ServiceProvider<?>> r4 = this.classServiceProviderConcurrentHashMap.get(r7);
        if (r4 != null) goto L14;
    L19:
        if (r2 == null) goto L22;
        markResolved(r7);
        return r2;
    L22:
        T r11 = (T) StaticServiceImplManager.getInstance().getStaticServiceImpl(r7);
        if (r11 == null) goto L26;
        markResolved(r7);
        return r11;
    L26:
        if (r10 == false) goto L28;
        return null;
    L28:
        T r12 = (T) getLegacyService(r7);
        if (r12 == null) goto L32;
        markResolved(r7);
        return r12;
    L32:
        if (r3 == true) goto L34;
        r12 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r7);
    L34:
        if (r12 != null) goto L38;
        if (r9 == false) goto L39;
        new DynamicProxy();
        return (T) DynamicProxy.get(r7);
    L39:
        return r12;
    L38:
        return r12;
    L14:
        if (r4.isEmpty() == true) goto L19;
        if (r8 == true) goto L19;
        Object[] r13 = r4.toArray();
        if (r13.length <= 0) goto L19;
        r2 = (T) ((ServiceProvider) r13[0]).get();
        goto L19
    L5:
        if (DowngradeImplManager.getInstance().isServiceForceDowngrade(r7) == false) goto L10;
        r2 = (T) DowngradeImplManager.getInstance().getDowngradeImpl(r7);
        if (r2 == null) goto L9;
        return r2;
    L9:
        r3 = true;
        goto L11
    }

    private void markResolved(Class r1) {
        this.resolvedClasses.add(r1);
    }

    public <T> void bindDowngradeImpl(Class<T> r2, ServiceProvider<T> r3) {
        bindDowngradeImpl(r2, r3, true);
    }

    public <T> void bindDowngradeImpl(Class<T> r1, ServiceProvider<T> r2, boolean r3) {
        if (r3 == false) goto L4;
        r2 = new SingletonProvider(r2);
    L4:
        DowngradeImplManager.getInstance().bindDowngradeImpl(r1, r2);
    }

    public boolean downgradeComponent(String r2) {
        return downgradeComponent(r2, false);
    }

    public boolean downgradeComponent(String r4, boolean r5) {
        if (r5 == true) goto L12;
        Map<String, String> r6 = DowngradeImplManager.getInstance().componentsMap;
        Iterator<String> r0 = r6.keySet().iterator();
    L5:
        if (r0.hasNext() == false) goto L12;
        String r1 = r0.next();
        if (this.resolvedClasses.contains(r1) == false) goto L5;
        if (TextUtils.equals(r6.get(r1), r4) == false) goto L5;
        return false;
    L12:
        DowngradeImplManager.getInstance().downgradeComponent(r4);
        return true;
    }

    private <T> T getLegacyService(Class<T> r2) {
        if (this.legacyServiceSet.contains(r2.getName()) == true) goto L5;
        return null;
    L5:
        Iterator r1 = ConfigLoader.iterator(r2);
        if (r1.hasNext() == true) goto L8;
        return null;
    L8:
        return (T) r1.next();
    }

    public ConcurrentHashMap getServiceProviderMap() {
        return this.classServiceProviderConcurrentHashMap;
    }

    public Map<Class<?>, Map<String, ServiceProvider<?>>> getGroupServiceProviderMap() {
        return this.groupServiceProviderConcurrentHashMap;
    }

    public <T> Set<T> getServices(Class<T> r2) {
        return getServices(r2, false);
    }

    public <T> Set<T> getServices(Class<T> r5, boolean r6) {
        Set<ServiceProvider<?>> r0 = this.classServiceProviderConcurrentHashMap.get(r5);
        if (r0 != null) goto L5;
    L17:
        Set<T> r7 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r5);
        if (r7 == null) goto L23;
        if (r7.isEmpty() == true) goto L23;
        return r7;
    L23:
        return getLegacyServices(r5);
    L5:
        if (r0.isEmpty() == true) goto L17;
        SetFromMap r4 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        Object[] r1 = r0.toArray();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L10;
        r4.add(((ServiceProvider) r1[r3]).get());
        r3 = r3 + 1;
        goto L8
    L10:
        if (r6 == false) goto L16;
        Set<T> r8 = StaticServiceImplManager.getInstance().getStaticServiceImplSet(r5);
        if (r8 == null) goto L16;
        if (r8.isEmpty() == true) goto L16;
        r4.addAll(r8);
    L16:
        return r4;
    }

    public <T> Set<T> getLegacyServices(Class<T> r3) {
        SetFromMap r0 = (Set<T>) Collections.synchronizedSet(new LinkedHashSet());
        if (this.legacyServiceSet.contains(r3.getName()) == true) goto L5;
        return r0;
    L5:
        Iterator r2 = ConfigLoader.iterator(r3);
    L7:
        if (r2.hasNext() == false) goto L9;
        r0.add(r2.next());
        goto L7
    L9:
        return r0;
    }

    public boolean onPluginInstall(String r1) {
        return PluginInstaller.INSTANCE.onPluginInstall(r1);
    }

    public <T> Binding bind(Class<T> r2, ServiceProvider<T> r3) {
        return new Binding(this, r2, r3);
    }

    public <T> GroupBinding bind(Class<T> r2, String r3, ServiceProvider<T> r4) {
        return new GroupBinding(this.groupServiceProviderConcurrentHashMap, r2, r3, r4);
    }

    public <T> T getServiceByGroup(Class<T> r1, String r2) {
        Map<String, ServiceProvider<?>> r0 = this.groupServiceProviderConcurrentHashMap.get(r1);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.containsKey(r2) == true) goto L8;
        return null;
    L8:
        return (T) r0.get(r2).get();
    }

    public static ServiceManager get() {
        return Holder.access$000();
    }

    private ServiceManager() {
        this.classServiceProviderConcurrentHashMap = new ConcurrentHashMap();
        this.groupServiceProviderConcurrentHashMap = Collections.synchronizedMap(new HashMap());
        this.legacyServiceSet = Collections.synchronizedSet(new HashSet());
        this.enableDynamicProxyDefault = true;
        this.resolvedClasses = Collections.synchronizedSet(new HashSet());
    }
}
