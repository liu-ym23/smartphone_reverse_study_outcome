package com.google.crypto.tink;

import com.google.crypto.tink.internal.InternalConfiguration;
import com.google.crypto.tink.internal.MutableKeyCreationRegistry;
import com.google.crypto.tink.internal.MutableParametersRegistry;
import com.google.crypto.tink.internal.MutableSerializationRegistry;
import com.google.crypto.tink.internal.PrimitiveSet;
import com.google.crypto.tink.internal.ProtoKeySerialization;
import com.google.crypto.tink.internal.TinkBugException;
import com.google.crypto.tink.monitoring.MonitoringAnnotations;
import com.google.crypto.tink.proto.EncryptedKeyset;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.KeyStatusType;
import com.google.crypto.tink.proto.Keyset;
import com.google.crypto.tink.proto.KeysetInfo;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.shaded.protobuf.ByteString;
import com.google.crypto.tink.shaded.protobuf.ExtensionRegistryLite;
import com.google.crypto.tink.shaded.protobuf.InvalidProtocolBufferException;
import com.google.crypto.tink.tinkkey.KeyAccess;
import com.google.crypto.tink.tinkkey.KeyHandle;
import com.google.crypto.tink.tinkkey.internal.InternalKeyHandle;
import com.google.crypto.tink.tinkkey.internal.ProtoKey;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class KeysetHandle {
    private final MonitoringAnnotations annotations;
    private final List<Entry> entries;
    private final Keyset keyset;

    /* JADX INFO: renamed from: com.google.crypto.tink.KeysetHandle$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = null;

        static {
            int[] r0 = new int[KeyStatusType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = r0;
            r0[KeyStatusType.ENABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final class Builder {
        private MonitoringAnnotations annotations;
        private boolean buildCalled;
        private final List<Entry> entries;

        @Nullable
        private GeneralSecurityException errorToThrow;

        public static final class Entry {

            @Nullable
            private Builder builder;
            private boolean isPrimary;

            @Nullable
            private final Key key;
            private KeyStatus keyStatus;

            @Nullable
            private final Parameters parameters;
            private KeyIdStrategy strategy;

            /* synthetic */ Entry(Key r1, AnonymousClass1 r2) {
                this(r1);
            }

            /* synthetic */ Entry(Parameters r1, AnonymousClass1 r2) {
                this(r1);
            }

            static /* synthetic */ Parameters access$1200(Entry r0) {
                return r0.parameters;
            }

            static /* synthetic */ boolean access$300(Entry r0) {
                return r0.isPrimary;
            }

            static /* synthetic */ boolean access$302(Entry r0, boolean r1) {
                r0.isPrimary = r1;
                return r1;
            }

            static /* synthetic */ Builder access$400(Entry r0) {
                return r0.builder;
            }

            static /* synthetic */ Builder access$402(Entry r0, Builder r1) {
                r0.builder = r1;
                return r1;
            }

            static /* synthetic */ KeyIdStrategy access$500(Entry r0) {
                return r0.strategy;
            }

            static /* synthetic */ KeyStatus access$800(Entry r0) {
                return r0.keyStatus;
            }

            static /* synthetic */ Key access$900(Entry r0) {
                return r0.key;
            }

            private Entry(Key key) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = key;
                this.parameters = null;
            }

            private Entry(Parameters parameters) {
                this.keyStatus = KeyStatus.ENABLED;
                this.strategy = null;
                this.builder = null;
                this.key = null;
                this.parameters = parameters;
            }

            public Entry makePrimary() {
                Builder r0 = this.builder;
                if (r0 == null) goto L5;
                Builder.access$000(r0);
            L5:
                this.isPrimary = true;
                return this;
            }

            public boolean isPrimary() {
                return this.isPrimary;
            }

            public Entry setStatus(KeyStatus status) {
                this.keyStatus = status;
                return this;
            }

            public KeyStatus getStatus() {
                return this.keyStatus;
            }

            public Entry withFixedId(int id) {
                this.strategy = KeyIdStrategy.access$100(id);
                return this;
            }

            public Entry withRandomId() {
                this.strategy = KeyIdStrategy.access$200();
                return this;
            }
        }

        private static class KeyIdStrategy {
            private static final KeyIdStrategy RANDOM_ID = null;
            private final int fixedId;

            static /* synthetic */ KeyIdStrategy access$100(int r0) {
                return fixedId(r0);
            }

            static /* synthetic */ KeyIdStrategy access$200() {
                return randomId();
            }

            static /* synthetic */ KeyIdStrategy access$600() {
                return RANDOM_ID;
            }

            static /* synthetic */ int access$700(KeyIdStrategy r0) {
                return r0.getFixedId();
            }

            static {
                RANDOM_ID = new KeyIdStrategy();
            }

            private KeyIdStrategy() {
                this.fixedId = 0;
            }

            private KeyIdStrategy(int id) {
                this.fixedId = id;
            }

            private static KeyIdStrategy randomId() {
                return RANDOM_ID;
            }

            private static KeyIdStrategy fixedId(int id) {
                return new KeyIdStrategy(id);
            }

            private int getFixedId() {
                return this.fixedId;
            }
        }

        public Builder() {
            this.entries = new ArrayList();
            this.errorToThrow = null;
            this.annotations = MonitoringAnnotations.EMPTY;
            this.buildCalled = false;
        }

        static /* synthetic */ void access$000(Builder r0) {
            r0.clearPrimary();
        }

        static /* synthetic */ void access$1700(Builder r0, GeneralSecurityException r1) {
            r0.setErrorToThrow(r1);
        }

        private void clearPrimary() {
            Iterator<Entry> r2 = this.entries.iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            Entry.access$302(r2.next(), false);
            goto L4
        }

        public Builder addEntry(Entry entry) {
            if (Entry.access$400(entry) != null) goto L10;
            if (Entry.access$300(entry) == false) goto L7;
            clearPrimary();
        L7:
            Entry.access$402(entry, this);
            this.entries.add(entry);
            return this;
        L10:
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }

        public Builder setMonitoringAnnotations(MonitoringAnnotations annotations) {
            this.annotations = annotations;
            return this;
        }

        public int size() {
            return this.entries.size();
        }

        public Entry getAt(int i) {
            return this.entries.get(i);
        }

        @Deprecated
        public Entry removeAt(int i) {
            return this.entries.remove(i);
        }

        public Builder deleteAt(int i) {
            this.entries.remove(i);
            return this;
        }

        private static void checkIdAssignments(List<Entry> entries) throws GeneralSecurityException {
            int r0 = 0;
        L4:
            if (r0 >= (entries.size() - 1)) goto L13;
            if (Entry.access$500(entries.get(r0)) != KeyIdStrategy.access$600()) goto L12;
            if (Entry.access$500(entries.get(r0 + 1)) == KeyIdStrategy.access$600()) goto L12;
            throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
        L12:
            r0 = r0 + 1;
            goto L4
        }

        private void setErrorToThrow(GeneralSecurityException errorToThrow) {
            this.errorToThrow = errorToThrow;
        }

        private static int randomIdNotInSet(Set<Integer> ids) {
            int r0 = 0;
        L3:
            if (r0 == 0) goto L8;
            if (ids.contains(Integer.valueOf(r0)) == true) goto L8;
            return r0;
        L8:
            r0 = com.google.crypto.tink.internal.Util.randKeyId();
            goto L3
        }

        private static int getNextIdFromBuilderEntry(Entry builderEntry, Set<Integer> idsSoFar) throws GeneralSecurityException {
            if (Entry.access$500(builderEntry) == null) goto L10;
            if (Entry.access$500(builderEntry) != KeyIdStrategy.access$600()) goto L8;
            return randomIdNotInSet(idsSoFar);
        L8:
            return KeyIdStrategy.access$700(Entry.access$500(builderEntry));
        L10:
            throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
        }

        public KeysetHandle build() throws GeneralSecurityException {
            if (this.errorToThrow != null) goto L44;
            if (this.buildCalled == true) goto L42;
            this.buildCalled = true;
            Keyset.Builder r1 = Keyset.newBuilder();
            ArrayList r2 = new ArrayList(this.entries.size());
            checkIdAssignments(this.entries);
            HashSet r3 = new HashSet();
            Iterator<Entry> r4 = this.entries.iterator();
            AnonymousClass1 r5 = null;
            Integer r6 = null;
        L8:
            if (r4.hasNext() == false) goto L36;
            Entry r7 = r4.next();
            if (Entry.access$800(r7) == null) goto L35;
            int r8 = getNextIdFromBuilderEntry(r7, r3);
            if (r3.contains(Integer.valueOf(r8)) == true) goto L33;
            r3.add(Integer.valueOf(r8));
            if (Entry.access$900(r7) == null) goto L17;
            Entry r15 = new Entry(Entry.access$900(r7), Entry.access$800(r7), r8, Entry.access$300(r7), null);
            Keyset.Key r9 = KeysetHandle.access$1100(Entry.access$900(r7), Entry.access$800(r7), r8);
        L21:
            r1.addKey(r9);
            if (Entry.access$300(r7) == false) goto L31;
            if (r6 != null) goto L30;
            r6 = Integer.valueOf(r8);
            if (Entry.access$800(r7) == KeyStatus.ENABLED) goto L31;
            throw new GeneralSecurityException("Primary key is not enabled");
        L30:
            throw new GeneralSecurityException("Two primaries were set");
        L31:
            r2.add(r15);
            goto L8
        L17:
            if (Entry.access$1200(r7).hasIdRequirement() == false) goto L19;
            Integer r10 = Integer.valueOf(r8);
        L20:
            Key r16 = MutableKeyCreationRegistry.globalInstance().createKey(Entry.access$1200(r7), r10);
            Entry r17 = new Entry(r16, Entry.access$800(r7), r8, Entry.access$300(r7), null);
            r9 = KeysetHandle.access$1100(r16, Entry.access$800(r7), r8);
            r15 = r17;
            goto L21
        L19:
            r10 = null;
            goto L20
        L33:
            throw new GeneralSecurityException("Id " + r8 + " is used twice in the keyset");
        L35:
            throw new GeneralSecurityException("Key Status not set.");
        L36:
            if (r6 == null) goto L40;
            r1.setPrimaryKeyId(r6.intValue());
            Keyset r11 = (Keyset) r1.build();
            KeysetHandle.access$1300(r11);
            return new KeysetHandle(r11, r2, this.annotations, r5);
        L40:
            throw new GeneralSecurityException("No primary was set");
        L42:
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        L44:
            throw new GeneralSecurityException("Cannot build keyset due to error in original", this.errorToThrow);
        }
    }

    @Immutable
    public static final class Entry {
        private final int id;
        private final boolean isPrimary;
        private final Key key;
        private final KeyStatus keyStatus;

        /* synthetic */ Entry(Key r1, KeyStatus r2, int r3, boolean r4, AnonymousClass1 r5) {
            this(r1, r2, r3, r4);
        }

        static /* synthetic */ boolean access$1800(Entry r0, Entry r1) {
            return r0.equalsEntry(r1);
        }

        static /* synthetic */ boolean access$1900(Entry r0) {
            return r0.isPrimary;
        }

        private Entry(Key key, KeyStatus keyStatus, int id, boolean isPrimary) {
            this.key = key;
            this.keyStatus = keyStatus;
            this.id = id;
            this.isPrimary = isPrimary;
        }

        public Key getKey() {
            return this.key;
        }

        public KeyStatus getStatus() {
            return this.keyStatus;
        }

        public int getId() {
            return this.id;
        }

        public boolean isPrimary() {
            return this.isPrimary;
        }

        private boolean equalsEntry(Entry other) {
            if (other.isPrimary == this.isPrimary) goto L6;
            return false;
        L6:
            if (other.keyStatus.equals(this.keyStatus) == true) goto L9;
            return false;
        L9:
            if (other.id == this.id) goto L12;
            return false;
        L12:
            if (other.key.equalsKey(this.key) == true) goto L14;
            return false;
        L14:
            return true;
        }
    }

    /* synthetic */ KeysetHandle(Keyset r1, List r2, MonitoringAnnotations r3, AnonymousClass1 r4) {
        this(r1, r2, r3);
    }

    static /* synthetic */ Keyset.Key access$1100(Key r0, KeyStatus r1, int r2) throws GeneralSecurityException {
        return createKeysetKey(r0, r1, r2);
    }

    static /* synthetic */ void access$1300(Keyset r0) throws GeneralSecurityException {
        assertEnoughKeyMaterial(r0);
    }

    private static KeyStatus parseStatus(KeyStatusType in) throws GeneralSecurityException {
        int r1 = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[in.ordinal()];
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L13;
        if (r1 != 3) goto L11;
        return KeyStatus.DESTROYED;
    L11:
        throw new GeneralSecurityException("Unknown key status");
    L13:
        return KeyStatus.DISABLED;
    L15:
        return KeyStatus.ENABLED;
    }

    private static KeyStatusType serializeStatus(KeyStatus in) {
        if (KeyStatus.ENABLED.equals(in) == false) goto L7;
        return KeyStatusType.ENABLED;
    L7:
        if (KeyStatus.DISABLED.equals(in) == false) goto L11;
        return KeyStatusType.DISABLED;
    L11:
        if (KeyStatus.DESTROYED.equals(in) == false) goto L15;
        return KeyStatusType.DESTROYED;
    L15:
        throw new IllegalStateException("Unknown key status");
    }

    private static List<Entry> getEntriesFromKeyset(Keyset keyset) {
        ArrayList r0 = new ArrayList(keyset.getKeyCount());
        Iterator<Keyset.Key> r1 = keyset.getKeyList().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Keyset.Key r2 = r1.next();
        int r6 = r2.getKeyId();
        Key r4 = toKey(r2);     // Catch: GeneralSecurityException -> L12
        KeyStatus r5 = parseStatus(r2.getStatus());     // Catch: GeneralSecurityException -> L12
        if (r6 != keyset.getPrimaryKeyId()) goto L9;
        boolean r3 = true;
    L10:
        r0.add(new Entry(r4, r5, r6, r3, null));     // Catch: GeneralSecurityException -> L12
        goto L4
    L9:
        r3 = false;
    L12:
        r0.add(null);
        goto L4
    L14:
        return Collections.unmodifiableList(r0);
    }

    private Entry entryByIndex(int i) {
        if (this.entries.get(i) == null) goto L7;
        return this.entries.get(i);
    L7:
        throw new IllegalStateException("Keyset-Entry at position " + i + " has wrong status or key parsing failed");
    }

    public static Builder.Entry importKey(Key key) {
        Builder.Entry r0 = new Builder.Entry(key, null);
        Integer r2 = key.getIdRequirementOrNull();
        if (r2 == null) goto L5;
        r0.withFixedId(r2.intValue());
    L5:
        return r0;
    }

    public static Builder.Entry generateEntryFromParametersName(String parametersName) throws GeneralSecurityException {
        return new Builder.Entry(MutableParametersRegistry.globalInstance().get(parametersName), null);
    }

    public static Builder.Entry generateEntryFromParameters(Parameters parameters) {
        return new Builder.Entry(parameters, null);
    }

    private KeysetHandle(Keyset keyset, List<Entry> entries) {
        this.keyset = keyset;
        this.entries = entries;
        this.annotations = MonitoringAnnotations.EMPTY;
    }

    private KeysetHandle(Keyset keyset, List<Entry> entries, MonitoringAnnotations annotations) {
        this.keyset = keyset;
        this.entries = entries;
        this.annotations = annotations;
    }

    static final KeysetHandle fromKeyset(Keyset keyset) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset));
    }

    static final KeysetHandle fromKeysetAndAnnotations(Keyset keyset, MonitoringAnnotations annotations) throws GeneralSecurityException {
        assertEnoughKeyMaterial(keyset);
        return new KeysetHandle(keyset, getEntriesFromKeyset(keyset), annotations);
    }

    Keyset getKeyset() {
        return this.keyset;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(KeysetHandle handle) {
        Builder r0 = new Builder();
        int r1 = 0;
    L4:
        if (r1 >= handle.size()) goto L12;
        Entry r2 = handle.entries.get(r1);
        if (r2 == null) goto L7;
        Builder.Entry r3 = importKey(r2.getKey()).withFixedId(r2.getId());
        r3.setStatus(r2.getStatus());
        if (r2.isPrimary() == false) goto L11;
        r3.makePrimary();
    L11:
        r0.addEntry(r3);
        r1 = r1 + 1;
        goto L4
    L7:
        Builder.access$1700(r0, new GeneralSecurityException("Keyset-Entry in original keyset at position " + r1 + " has wrong status or key parsing failed"));
    L12:
        return r0;
    }

    public Entry getPrimary() {
        Iterator<Entry> r2 = this.entries.iterator();
    L4:
        if (r2.hasNext() == false) goto L15;
        Entry r0 = r2.next();
        if (r0 == null) goto L4;
        if (r0.isPrimary() == false) goto L4;
        if (r0.getStatus() != KeyStatus.ENABLED) goto L13;
        return r0;
    L13:
        throw new IllegalStateException("Keyset has primary which isn't enabled");
    L15:
        throw new IllegalStateException("Keyset has no valid primary");
    }

    public int size() {
        return this.entries.size();
    }

    public Entry getAt(int i) {
        if (i < 0) goto L8;
        if (i >= size()) goto L8;
        return entryByIndex(i);
    L8:
        throw new IndexOutOfBoundsException("Invalid index " + i + " for keyset of size " + size());
    }

    @Deprecated
    public List<KeyHandle> getKeys() {
        ArrayList r0 = new ArrayList();
        Iterator<Keyset.Key> r6 = this.keyset.getKeyList().iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Keyset.Key r1 = r6.next();
        r0.add(new InternalKeyHandle(new ProtoKey(r1.getKeyData(), KeyTemplate.fromProto(r1.getOutputPrefixType())), r1.getStatus(), r1.getKeyId()));
        goto L4
    L7:
        return Collections.unmodifiableList(r0);
    }

    public KeysetInfo getKeysetInfo() {
        return Util.getKeysetInfo(this.keyset);
    }

    public static final KeysetHandle generateNew(Parameters parameters) throws GeneralSecurityException {
        return newBuilder().addEntry(generateEntryFromParameters(parameters).withRandomId().makePrimary()).build();
    }

    @Deprecated
    public static final KeysetHandle generateNew(com.google.crypto.tink.proto.KeyTemplate keyTemplate) throws GeneralSecurityException {
        return generateNew(TinkProtoParametersFormat.parse(keyTemplate.toByteArray()));
    }

    public static final KeysetHandle generateNew(KeyTemplate keyTemplate) throws GeneralSecurityException {
        return generateNew(keyTemplate.toParameters());
    }

    @Deprecated
    public static final KeysetHandle createFromKey(KeyHandle keyHandle, KeyAccess access) throws GeneralSecurityException {
        KeysetManager r1 = KeysetManager.withEmptyKeyset().add(keyHandle);
        r1.setPrimary(r1.getKeysetHandle().getKeysetInfo().getKeyInfo(0).getKeyId());
        return r1.getKeysetHandle();
    }

    public static final KeysetHandle read(KeysetReader reader, Aead masterKey) throws GeneralSecurityException, IOException {
        return readWithAssociatedData(reader, masterKey, new byte[0]);
    }

    public static final KeysetHandle readWithAssociatedData(KeysetReader reader, Aead masterKey, byte[] associatedData) throws GeneralSecurityException, IOException {
        EncryptedKeyset r0 = reader.readEncrypted();
        assertEnoughEncryptedKeyMaterial(r0);
        return fromKeyset(decrypt(r0, masterKey, associatedData));
    }

    public static final KeysetHandle readNoSecret(KeysetReader reader) throws GeneralSecurityException, IOException {
        return readNoSecret(reader.read().toByteArray());
    L6:
        throw new GeneralSecurityException("invalid keyset");
    }

    @Deprecated
    public static final KeysetHandle readNoSecret(final byte[] serialized) throws GeneralSecurityException {
        Keyset r1 = Keyset.parseFrom(serialized, ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L4
        assertNoSecretKeyMaterial(r1);     // Catch: InvalidProtocolBufferException -> L4
        return fromKeyset(r1);
    L5:
        throw new GeneralSecurityException("invalid keyset");
    }

    public void write(KeysetWriter keysetWriter, Aead masterKey) throws GeneralSecurityException, IOException {
        writeWithAssociatedData(keysetWriter, masterKey, new byte[0]);
    }

    public void writeWithAssociatedData(KeysetWriter keysetWriter, Aead masterKey, byte[] associatedData) throws GeneralSecurityException, IOException {
        keysetWriter.write(encrypt(this.keyset, masterKey, associatedData));
    }

    public void writeNoSecret(KeysetWriter writer) throws GeneralSecurityException, IOException {
        assertNoSecretKeyMaterial(this.keyset);
        writer.write(this.keyset);
    }

    private static EncryptedKeyset encrypt(Keyset keyset, Aead masterKey, byte[] associatedData) throws GeneralSecurityException {
        byte[] r0 = masterKey.encrypt(keyset.toByteArray(), associatedData);
        if (Keyset.parseFrom(masterKey.decrypt(r0, associatedData), ExtensionRegistryLite.getEmptyRegistry()).equals(keyset) == false) goto L8;
        return (EncryptedKeyset) EncryptedKeyset.newBuilder().setEncryptedKeyset(ByteString.copyFrom(r0)).setKeysetInfo(Util.getKeysetInfo(keyset)).build();
    L8:
        throw new GeneralSecurityException("cannot encrypt keyset");     // Catch: InvalidProtocolBufferException -> L9
    L10:
        throw new GeneralSecurityException("invalid keyset, corrupted key material");
    }

    private static Keyset decrypt(EncryptedKeyset encryptedKeyset, Aead masterKey, byte[] associatedData) throws GeneralSecurityException {
        Keyset r0 = Keyset.parseFrom(masterKey.decrypt(encryptedKeyset.getEncryptedKeyset().toByteArray(), associatedData), ExtensionRegistryLite.getEmptyRegistry());     // Catch: InvalidProtocolBufferException -> L4
        assertEnoughKeyMaterial(r0);     // Catch: InvalidProtocolBufferException -> L4
        return r0;
    L5:
        throw new GeneralSecurityException("invalid keyset, corrupted key material");
    }

    public KeysetHandle getPublicKeysetHandle() throws GeneralSecurityException {
        if (this.keyset == null) goto L24;
        Keyset.Builder r0 = Keyset.newBuilder();
        ArrayList r1 = new ArrayList(this.entries.size());
        Iterator<Entry> r2 = this.entries.iterator();
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L21;
        Entry r5 = r2.next();
        if (r5 != null) goto L10;
    L12:
        Keyset.Key r6 = this.keyset.getKey(r4);
        Keyset.Key r7 = (Keyset.Key) ((Keyset.Key.Builder) r6.toBuilder()).setKeyData(getPublicKeyDataFromRegistry(r6.getKeyData())).build();
        Key r8 = toKey(r7);     // Catch: GeneralSecurityException -> L19
        int r9 = r7.getKeyId();     // Catch: GeneralSecurityException -> L19
        KeyStatus r10 = parseStatus(r7.getStatus());     // Catch: GeneralSecurityException -> L19
        if (r9 != this.keyset.getPrimaryKeyId()) goto L16;
        boolean r11 = true;
    L17:
        Entry r13 = new Entry(r8, r10, r9, r11, null);     // Catch: GeneralSecurityException -> L19
    L20:
        r0.addKey(r7);
        r1.add(r13);
        r4 = r4 + 1;
        goto L6
    L16:
        r11 = false;
    L19:
        r13 = null;
        goto L20
    L10:
        if ((r5.getKey() instanceof PrivateKey) == false) goto L12;
        Key r12 = ((PrivateKey) r5.getKey()).getPublicKey();
        r13 = new Entry(r12, r5.getStatus(), r5.getId(), r5.isPrimary(), null);
        r7 = createKeysetKey(r12, r5.getStatus(), r5.getId());
        goto L20
    L21:
        r0.setPrimaryKeyId(this.keyset.getPrimaryKeyId());
        return new KeysetHandle((Keyset) r0.build(), r1, this.annotations);
    L24:
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    private static KeyData getPublicKeyDataFromRegistry(KeyData privateKeyData) throws GeneralSecurityException {
        if (privateKeyData.getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) goto L7;
        return Registry.getPublicKeyData(privateKeyData.getTypeUrl(), privateKeyData.getValue());
    L7:
        throw new GeneralSecurityException("The keyset contains a non-private key");
    }

    public String toString() {
        return getKeysetInfo().toString();
    }

    private static void assertNoSecretKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        Iterator<Keyset.Key> r4 = keyset.getKeyList().iterator();
    L4:
        if (r4.hasNext() == false) goto L14;
        Keyset.Key r0 = r4.next();
        if (r0.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL) goto L13;
        if (r0.getKeyData().getKeyMaterialType() == KeyData.KeyMaterialType.SYMMETRIC) goto L13;
        if (r0.getKeyData().getKeyMaterialType() != KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) goto L4;
    L13:
        throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", new Object[]{r0.getKeyData().getKeyMaterialType().name(), r0.getKeyData().getTypeUrl()}));
    }

    private static void assertEnoughKeyMaterial(Keyset keyset) throws GeneralSecurityException {
        if (keyset == null) goto L7;
        if (keyset.getKeyCount() <= 0) goto L7;
        return;
    L7:
        throw new GeneralSecurityException("empty keyset");
    }

    private static void assertEnoughEncryptedKeyMaterial(EncryptedKeyset keyset) throws GeneralSecurityException {
        if (keyset == null) goto L7;
        if (keyset.getEncryptedKeyset().size() == 0) goto L7;
        return;
    L7:
        throw new GeneralSecurityException("empty keyset");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <B, P> P getPrimitiveWithKnownInputPrimitive(InternalConfiguration r8, Class<P> r9, Class<B> r10) throws GeneralSecurityException {
        Util.validateKeyset(this.keyset);
        PrimitiveSet.Builder r0 = PrimitiveSet.newBuilder(r10);
        r0.setAnnotations(this.annotations);
        int r1 = 0;
    L4:
        if (r1 >= size()) goto L22;
        Keyset.Key r2 = this.keyset.getKey(r1);
        if (r2.getStatus().equals(KeyStatusType.ENABLED) == false) goto L20;
        Entry r3 = this.entries.get(r1);
        if (r3 == null) goto L19;
        Key r4 = r3.getKey();
        Object r5 = r8.getPrimitive(r4, r10);     // Catch: GeneralSecurityException -> L15
        if (r2.getKeyId() != this.keyset.getPrimaryKeyId()) goto L14;
        r0.addPrimaryFullPrimitive(r5, r4, r2);
        goto L20
    L14:
        r0.addFullPrimitive(r5, r4, r2);
    L15:
        e = move-exception;
        throw new GeneralSecurityException("Unable to get primitive " + r10 + " for key of type " + r2.getKeyData().getTypeUrl() + ", see https://developers.google.com/tink/faq/registration_errors", e);
    L19:
        throw new GeneralSecurityException("Key parsing of key with index " + r1 + " and type_url " + r2.getKeyData().getTypeUrl() + " failed, unable to get primitive");
    L20:
        r1 = r1 + 1;
        goto L4
    L22:
        return (P) r8.wrap(r0.build(), r9);
    }

    public <P> P getPrimitive(Configuration r2, Class<P> r3) throws GeneralSecurityException {
        if ((r2 instanceof InternalConfiguration) == false) goto L11;
        InternalConfiguration r4 = (InternalConfiguration) r2;
        Class<?> r0 = r4.getInputPrimitiveClass(r3);
        if (r0 == null) goto L9;
        return (P) getPrimitiveWithKnownInputPrimitive(r4, r3, r0);
    L9:
        throw new GeneralSecurityException("No wrapper found for " + r3.getName());
    L11:
        throw new GeneralSecurityException("Currently only subclasses of InternalConfiguration are accepted");
    }

    public <P> P getPrimitive(Class<P> r2) throws GeneralSecurityException {
        return (P) getPrimitive(RegistryConfiguration.get(), r2);
    }

    @Deprecated
    public KeyHandle primaryKey() throws GeneralSecurityException {
        int r0 = this.keyset.getPrimaryKeyId();
        Iterator<Keyset.Key> r4 = this.keyset.getKeyList().iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        Keyset.Key r1 = r4.next();
        if (r1.getKeyId() != r0) goto L4;
        return new InternalKeyHandle(new ProtoKey(r1.getKeyData(), KeyTemplate.fromProto(r1.getOutputPrefixType())), r1.getStatus(), r1.getKeyId());
    L10:
        throw new GeneralSecurityException("No primary key found in keyset.");
    }

    public boolean equalsKeyset(KeysetHandle other) {
        if (size() == other.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
        boolean r1 = false;
    L7:
        if (r0 >= size()) goto L17;
        Entry r3 = this.entries.get(r0);
        Entry r4 = other.entries.get(r0);
        if (r3 == null) goto L10;
        if (r4 == null) goto L12;
        if (Entry.access$1800(r3, r4) == false) goto L15;
        r1 = r1 | Entry.access$1900(r3);
        r0 = r0 + 1;
        goto L7
    L15:
        return false;
    L12:
        return false;
    L10:
        return false;
    L17:
        if (r1 == true) goto L19;
        return false;
    L19:
        return true;
    }

    private static ProtoKeySerialization toProtoKeySerialization(Keyset.Key protoKey) {
        int r0 = protoKey.getKeyId();
        if (protoKey.getOutputPrefixType() != OutputPrefixType.RAW) goto L5;
        Integer r1 = null;
    L11:
        return ProtoKeySerialization.create(protoKey.getKeyData().getTypeUrl(), protoKey.getKeyData().getValue(), protoKey.getKeyData().getKeyMaterialType(), protoKey.getOutputPrefixType(), r1);
    L8:
        e = move-exception;
        throw new TinkBugException("Creating a protokey serialization failed", e);
    L5:
        r1 = Integer.valueOf(r0);
        goto L11
    }

    private static Key toKey(Keyset.Key protoKey) throws GeneralSecurityException {
        ProtoKeySerialization r2 = toProtoKeySerialization(protoKey);
        return MutableSerializationRegistry.globalInstance().parseKeyWithLegacyFallback(r2, InsecureSecretKeyAccess.get());
    }

    private static Keyset.Key toKeysetKey(int id, KeyStatusType status, ProtoKeySerialization protoKeySerialization) {
        return (Keyset.Key) Keyset.Key.newBuilder().setKeyData(KeyData.newBuilder().setTypeUrl(protoKeySerialization.getTypeUrl()).setValue(protoKeySerialization.getValue()).setKeyMaterialType(protoKeySerialization.getKeyMaterialType())).setStatus(status).setKeyId(id).setOutputPrefixType(protoKeySerialization.getOutputPrefixType()).build();
    }

    private static Keyset.Key createKeysetKey(Key key, KeyStatus keyStatus, int id) throws GeneralSecurityException {
        ProtoKeySerialization r3 = (ProtoKeySerialization) MutableSerializationRegistry.globalInstance().serializeKey(key, ProtoKeySerialization.class, InsecureSecretKeyAccess.get());
        Integer r0 = r3.getIdRequirementOrNull();
        if (r0 == null) goto L10;
        if (r0.intValue() == id) goto L10;
        throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
    L10:
        return toKeysetKey(id, serializeStatus(keyStatus), r3);
    }
}
