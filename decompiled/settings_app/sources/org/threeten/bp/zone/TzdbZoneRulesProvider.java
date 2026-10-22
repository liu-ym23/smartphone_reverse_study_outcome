package org.threeten.bp.zone;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.threeten.bp.jdk8.Jdk8Methods;

/* JADX INFO: loaded from: classes6.dex */
public final class TzdbZoneRulesProvider extends ZoneRulesProvider {
    private Set<String> loadedUrls;
    private List<String> regionIds;
    private final ConcurrentNavigableMap<String, Version> versions;

    static class Version {
        private final String[] regionArray;
        private final AtomicReferenceArray<Object> ruleData;
        private final short[] ruleIndices;
        private final String versionId;

        static /* synthetic */ String access$000(Version r0) {
            return r0.versionId;
        }

        Version(String r1, String[] r2, short[] r3, AtomicReferenceArray<Object> r4) {
            this.ruleData = r4;
            this.versionId = r1;
            this.regionArray = r2;
            this.ruleIndices = r3;
        }

        ZoneRules getRules(String r5) {
            int r0 = Arrays.binarySearch(this.regionArray, r5);
            if (r0 >= 0) goto L11;
            return null;
        L11:
            return createRule(this.ruleIndices[r0]);
        L8:
            e = move-exception;
            throw new ZoneRulesException("Invalid binary time-zone data: TZDB:" + r5 + ", version: " + this.versionId, e);
        }

        ZoneRules createRule(short r4) throws Exception {
            Object r0 = this.ruleData.get(r4);
            if ((r0 instanceof byte[]) == false) goto L6;
            r0 = Ser.read(new DataInputStream(new ByteArrayInputStream((byte[]) r0)));
            this.ruleData.set(r4, r0);
        L6:
            return (ZoneRules) r0;
        }

        public String toString() {
            return this.versionId;
        }
    }

    public String toString() {
        return "TZDB";
    }

    public TzdbZoneRulesProvider() {
        this.versions = new ConcurrentSkipListMap();
        this.loadedUrls = new CopyOnWriteArraySet();
        if (load(ZoneRulesProvider.class.getClassLoader()) == false) goto L6;
        return;
    L6:
        throw new ZoneRulesException("No time-zone rules found for 'TZDB'");
    }

    public TzdbZoneRulesProvider(URL r4) {
        this.versions = new ConcurrentSkipListMap();
        this.loadedUrls = new CopyOnWriteArraySet();
    L8:
        e = move-exception;
        throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + r4, e);
    L4:
        if (load(r4) == false) goto L7;
        return;
    L7:
        throw new ZoneRulesException("No time-zone rules found: " + r4);     // Catch: Exception -> L8
    }

    public TzdbZoneRulesProvider(InputStream r2) {
        this.versions = new ConcurrentSkipListMap();
        this.loadedUrls = new CopyOnWriteArraySet();
        load(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        throw new ZoneRulesException("Unable to load TZDB time-zone rules", e);
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected Set<String> provideZoneIds() {
        return new HashSet(this.regionIds);
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected ZoneRules provideRules(String r2, boolean r3) {
        Jdk8Methods.requireNonNull(r2, "zoneId");
        ZoneRules r1 = this.versions.lastEntry().getValue().getRules(r2);
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new ZoneRulesException("Unknown time-zone ID: " + r2);
    }

    @Override // org.threeten.bp.zone.ZoneRulesProvider
    protected NavigableMap<String, ZoneRules> provideVersions(String r4) {
        TreeMap r0 = new TreeMap();
        Iterator r3 = this.versions.values().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        Version r1 = (Version) r3.next();
        ZoneRules r2 = r1.getRules(r4);
        if (r2 == null) goto L4;
        r0.put(Version.access$000(r1), r2);
        goto L4
    L8:
        return r0;
    }

    private boolean load(ClassLoader r4) {
        URL r0 = null;
        Enumeration<URL> r5 = r4.getResources("org/threeten/bp/TZDB.dat");     // Catch: Exception -> L12
        boolean r1 = false;
    L5:
        if (r5.hasMoreElements() == false) goto L11;
        URL r2 = r5.nextElement();     // Catch: Exception -> L12
        r1 = r1 | load(r2);
        r0 = r2;
    L9:
        e = e;
        r0 = r2;
    L14:
        throw new ZoneRulesException("Unable to load TZDB time-zone rules: " + r0, e);
    L11:
        return r1;
    L12:
        e = e;
        goto L14
    }

    private boolean load(URL r3) throws ClassNotFoundException, IOException, ZoneRulesException {
        boolean r1 = false;
        if (this.loadedUrls.add(r3.toExternalForm()) == true) goto L19;
    L16:
        return r1;
    L19:
        InputStream r4 = r3.openStream();     // Catch: Throwable -> L11
        r1 = false | load(r4);
        if (r4 == null) goto L16;
        r4.close();
    L9:
        th = th;
    L13:
        if (r4 == null) goto L15;
        r4.close();
    L15:
        throw th;
    L11:
        th = th;
        r4 = null;
        goto L13
    }

    private boolean load(InputStream r4) throws IOException, StreamCorruptedException {
        Iterator<Version> r5 = loadData(r4).iterator();
        boolean r0 = false;
    L4:
        if (r5.hasNext() == false) goto L13;
        Version r1 = r5.next();
        Version r2 = this.versions.putIfAbsent(Version.access$000(r1), r1);
        if (r2 == null) goto L12;
        if (Version.access$000(r2).equals(Version.access$000(r1)) == true) goto L12;
        throw new ZoneRulesException("Data already loaded for TZDB time-zone rules version: " + Version.access$000(r1));
    L12:
        r0 = true;
        goto L4
    L13:
        return r0;
    }

    private Iterable<Version> loadData(InputStream r12) throws IOException, StreamCorruptedException {
        DataInputStream r0 = new DataInputStream(r12);
        if (r0.readByte() != 1) goto L25;
        if ("TZDB".equals(r0.readUTF()) == false) goto L23;
        int r13 = r0.readShort();
        String[] r1 = new String[r13];
        int r3 = 0;
    L7:
        if (r3 >= r13) goto L9;
        r1[r3] = r0.readUTF();
        r3 = r3 + 1;
        goto L7
    L9:
        int r4 = r0.readShort();
        String[] r5 = new String[r4];
        int r6 = 0;
    L10:
        if (r6 >= r4) goto L12;
        r5[r6] = r0.readUTF();
        r6 = r6 + 1;
        goto L10
    L12:
        this.regionIds = Arrays.asList(r5);
        int r11 = r0.readShort();
        Object[] r7 = new Object[r11];
        int r8 = 0;
    L13:
        if (r8 >= r11) goto L15;
        byte[] r9 = new byte[r0.readShort()];
        r0.readFully(r9);
        r7[r8] = r9;
        r8 = r8 + 1;
        goto L13
    L15:
        AtomicReferenceArray r14 = new AtomicReferenceArray(r7);
        HashSet r10 = new HashSet(r13);
        int r15 = 0;
    L16:
        if (r15 >= r13) goto L21;
        int r16 = r0.readShort();
        String[] r17 = new String[r16];
        short[] r18 = new short[r16];
        int r19 = 0;
    L18:
        if (r19 >= r16) goto L20;
        r17[r19] = r5[r0.readShort()];
        r18[r19] = r0.readShort();
        r19 = r19 + 1;
        goto L18
    L20:
        r10.add(new Version(r1[r15], r17, r18, r14));
        r15 = r15 + 1;
        goto L16
    L21:
        return r10;
    L23:
        throw new StreamCorruptedException("File format not recognised");
    L25:
        throw new StreamCorruptedException("File format not recognised");
    }
}
