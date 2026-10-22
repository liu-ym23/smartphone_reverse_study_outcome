package org.threeten.bp.zone;

import java.util.Collections;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ZoneRulesProvider {
    private static final CopyOnWriteArrayList<ZoneRulesProvider> PROVIDERS = null;
    private static final ConcurrentMap<String, ZoneRulesProvider> ZONES = null;

    protected boolean provideRefresh() {
        return false;
    }

    protected abstract ZoneRules provideRules(String r1, boolean r2);

    protected abstract NavigableMap<String, ZoneRules> provideVersions(String r1);

    protected abstract Set<String> provideZoneIds();

    static {
        PROVIDERS = new CopyOnWriteArrayList();
        ZONES = new ConcurrentHashMap(512, 0.75f, 2);
        ZoneRulesInitializer.initialize();
    }

    public static Set<String> getAvailableZoneIds() {
        return Collections.unmodifiableSet(ZONES.keySet());
    }

    public static ZoneRules getRules(String r1, boolean r2) {
        Jdk8Methods.requireNonNull(r1, "zoneId");
        return getProvider(r1).provideRules(r1, r2);
    }

    public static NavigableMap<String, ZoneRules> getVersions(String r1) {
        Jdk8Methods.requireNonNull(r1, "zoneId");
        return getProvider(r1).provideVersions(r1);
    }

    private static ZoneRulesProvider getProvider(String r3) {
        ConcurrentMap<String, ZoneRulesProvider> r0 = ZONES;
        ZoneRulesProvider r1 = r0.get(r3);
        if (r1 == null) goto L5;
        return r1;
    L5:
        if (r0.isEmpty() == false) goto L9;
        throw new ZoneRulesException("No time-zone data files registered");
    L9:
        throw new ZoneRulesException("Unknown time-zone ID: " + r3);
    }

    public static void registerProvider(ZoneRulesProvider r1) {
        Jdk8Methods.requireNonNull(r1, "provider");
        registerProvider0(r1);
        PROVIDERS.add(r1);
    }

    private static void registerProvider0(ZoneRulesProvider r4) {
        Iterator<String> r0 = r4.provideZoneIds().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        Jdk8Methods.requireNonNull(r1, "zoneId");
        if (ZONES.putIfAbsent(r1, r4) == null) goto L4;
        throw new ZoneRulesException("Unable to register zone as one already registered with that ID: " + r1 + ", currently loading from provider: " + r4);
    }

    public static boolean refresh() {
        Iterator<ZoneRulesProvider> r0 = PROVIDERS.iterator();
        boolean r1 = false;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 | r0.next().provideRefresh();
        goto L4
    L6:
        return r1;
    }

    protected ZoneRulesProvider() {
    }
}
