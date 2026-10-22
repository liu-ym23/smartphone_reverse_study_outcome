package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: SavedStateHandle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0002*+B\u001d\b\u0016\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0002\u0010\u0005B\u0007\b\u0016¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J\u0011\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002J\u001e\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010\u0017J\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0019\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u0002H\u0016H\u0002¢\u0006\u0002\u0010\u001eJ)\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00160 \"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0016H\u0007¢\u0006\u0002\u0010!J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#H\u0007J\u001d\u0010$\u001a\u0004\u0018\u0001H\u0016\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0017J\b\u0010\r\u001a\u00020\u000eH\u0007J&\u0010%\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00162\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u0001H\u0016H\u0087\u0002¢\u0006\u0002\u0010'J\u0018\u0010(\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u000eH\u0007R\"\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Landroidx/lifecycle/SavedStateHandle;", "", "initialState", "", "", "(Ljava/util/Map;)V", "()V", "flows", "", "Lkotlinx/coroutines/flow/MutableStateFlow;", "liveDatas", "Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", "regular", "savedStateProvider", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "savedStateProviders", "clearSavedStateProvider", "", "key", "contains", "", "get", ExifInterface.GPS_DIRECTION_TRUE, "(Ljava/lang/String;)Ljava/lang/Object;", "getLiveData", "Landroidx/lifecycle/MutableLiveData;", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getLiveDataInternal", "hasInitialValue", "(Ljava/lang/String;ZLjava/lang/Object;)Landroidx/lifecycle/MutableLiveData;", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", SavedStateHandle.KEYS, "", "remove", "set", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "setSavedStateProvider", "provider", "Companion", "SavingStateLiveData", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SavedStateHandle {
    private static final Class<? extends Object>[] ACCEPTABLE_CLASSES = null;
    public static final Companion Companion = null;
    private static final String KEYS = "keys";
    private static final String VALUES = "values";
    private final Map<String, MutableStateFlow<Object>> flows;
    private final Map<String, SavingStateLiveData<?>> liveDatas;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    private final Map<String, SavedStateRegistry.SavedStateProvider> savedStateProviders;

    /* JADX INFO: compiled from: SavedStateHandle.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0007R \u0010\u0003\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\b\u0001\u0012\u00020\u0001\u0018\u00010\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$Companion;", "", "()V", "ACCEPTABLE_CLASSES", "", "Ljava/lang/Class;", "[Ljava/lang/Class;", "KEYS", "", "VALUES", "createHandle", "Landroidx/lifecycle/SavedStateHandle;", "restoredState", "Landroid/os/Bundle;", "defaultState", "validateValue", "", "value", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SavedStateHandle createHandle(Bundle r5, Bundle r6) {
            if (r5 != null) goto L11;
            if (r6 == null) goto L33;
            HashMap r4 = new HashMap();
            Iterator<String> r7 = r6.keySet().iterator();
        L7:
            if (r7.hasNext() == false) goto L10;
            String r0 = r7.next();
            Intrinsics.checkNotNullExpressionValue(r0, "key");
            r4.put(r0, r6.get(r0));
            goto L7
        L10:
            return new SavedStateHandle(r4);
        L33:
            return new SavedStateHandle();
        L11:
            ArrayList r8 = r5.getParcelableArrayList(SavedStateHandle.KEYS);
            ArrayList r9 = r5.getParcelableArrayList(SavedStateHandle.VALUES);
            int r10 = 0;
            if (r8 == null) goto L17;
            if (r9 == null) goto L17;
            if (r8.size() != r9.size()) goto L17;
            boolean r1 = true;
        L18:
            if (r1 == false) goto L29;
            LinkedHashMap r2 = new LinkedHashMap();
            int r3 = r8.size();
        L20:
            if (r10 >= r3) goto L27;
            Object r11 = r8.get(r10);
            if (r11 == null) goto L25;
            r2.put((String) r11, r9.get(r10));
            r10 = r10 + 1;
            goto L20
        L25:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        L27:
            return new SavedStateHandle(r2);
        L29:
            throw new IllegalStateException("Invalid bundle passed as restored state".toString());
        L17:
            r1 = false;
            goto L18
        }

        public final boolean validateValue(Object r6) {
            if (r6 != null) goto L5;
            return true;
        L5:
            Class[] r0 = SavedStateHandle.access$getACCEPTABLE_CLASSES$cp();
            int r1 = r0.length;
            int r3 = 0;
        L6:
            if (r3 >= r1) goto L11;
            Class r4 = r0[r3];
            Intrinsics.checkNotNull(r4);
            if (r4.isInstance(r6) == true) goto L9;
            r3 = r3 + 1;
            goto L6
        L9:
            return true;
        L11:
            return false;
        }
    }

    /* JADX INFO: compiled from: SavedStateHandle.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bB\u0019\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/SavedStateHandle$SavingStateLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MutableLiveData;", "handle", "Landroidx/lifecycle/SavedStateHandle;", "key", "", "value", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;Ljava/lang/Object;)V", "(Landroidx/lifecycle/SavedStateHandle;Ljava/lang/String;)V", "detach", "", "setValue", "(Ljava/lang/Object;)V", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SavingStateLiveData<T> extends MutableLiveData<T> {
        private SavedStateHandle handle;
        private String key;

        public SavingStateLiveData(SavedStateHandle r2, String r3, T r4) {
            Intrinsics.checkNotNullParameter(r3, "key");
            super(r4);
            this.key = r3;
            this.handle = r2;
        }

        public SavingStateLiveData(SavedStateHandle r2, String r3) {
            Intrinsics.checkNotNullParameter(r3, "key");
            this.key = r3;
            this.handle = r2;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(T r4) {
            SavedStateHandle r0 = this.handle;
            if (r0 == null) goto L8;
            SavedStateHandle.access$getRegular$p(r0).put(this.key, r4);
            MutableStateFlow r1 = (MutableStateFlow) SavedStateHandle.access$getFlows$p(r0).get(this.key);
            if (r1 == null) goto L8;
            r1.setValue(r4);
        L8:
            super.setValue(r4);
        }

        public final void detach() {
            this.handle = null;
        }
    }

    public static /* synthetic */ Bundle $r8$lambda$85q68529u9GpNelrug3JBSyWf4c(SavedStateHandle r0) {
        return m49savedStateProvider$lambda0(r0);
    }

    @JvmStatic
    public static final SavedStateHandle createHandle(Bundle r1, Bundle r2) {
        return Companion.createHandle(r1, r2);
    }

    public static final /* synthetic */ Class[] access$getACCEPTABLE_CLASSES$cp() {
        return ACCEPTABLE_CLASSES;
    }

    public static final /* synthetic */ Map access$getFlows$p(SavedStateHandle r0) {
        return r0.flows;
    }

    public static final /* synthetic */ Map access$getRegular$p(SavedStateHandle r0) {
        return r0.regular;
    }

    /* JADX INFO: renamed from: savedStateProvider$lambda-0, reason: not valid java name */
    private static final Bundle m49savedStateProvider$lambda0(SavedStateHandle r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        Iterator r0 = MapsKt.toMap(r5.savedStateProviders).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        r5.set((String) r1.getKey(), ((SavedStateRegistry.SavedStateProvider) r1.getValue()).saveState());
        goto L4
    L6:
        Set<String> r2 = r5.regular.keySet();
        ArrayList r3 = new ArrayList(r2.size());
        ArrayList r4 = new ArrayList(r3.size());
        Iterator<String> r6 = r2.iterator();
    L8:
        if (r6.hasNext() == false) goto L11;
        String r7 = r6.next();
        r3.add(r7);
        r4.add(r5.regular.get(r7));
        goto L8
    L11:
        return BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEYS, r3), TuplesKt.to(VALUES, r4)});
    }

    public SavedStateHandle(Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r3, "initialState");
        LinkedHashMap r0 = new LinkedHashMap();
        this.regular = r0;
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
        r0.putAll(r3);
    }

    public SavedStateHandle() {
        this.regular = new LinkedHashMap();
        this.savedStateProviders = new LinkedHashMap();
        this.liveDatas = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.savedStateProvider = new SavedStateHandle$$ExternalSyntheticLambda0(this);
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    public final boolean contains(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return this.regular.containsKey(r2);
    }

    public final <T> MutableLiveData<T> getLiveData(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return getLiveDataInternal(r3, false, null);
    }

    public final <T> MutableLiveData<T> getLiveData(String r2, T r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return getLiveDataInternal(r2, true, r3);
    }

    private final <T> MutableLiveData<T> getLiveDataInternal(String r3, boolean r4, T r5) {
        SavingStateLiveData<?> r0 = this.liveDatas.get(r3);
        if ((r0 instanceof MutableLiveData) == false) goto L5;
        SavingStateLiveData<?> r1 = r0;
    L6:
        if (r1 == null) goto L9;
        return r1;
    L9:
        if (this.regular.containsKey(r3) == false) goto L11;
        SavingStateLiveData<?> r6 = new SavingStateLiveData(this, r3, this.regular.get(r3));
    L14:
        this.liveDatas.put(r3, r6);
        return r6;
    L11:
        if (r4 == false) goto L13;
        this.regular.put(r3, r5);
        r6 = new SavingStateLiveData(this, r3, r5);
        goto L14
    L13:
        r6 = new SavingStateLiveData(this, r3);
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final <T> StateFlow<T> getStateFlow(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Map<String, MutableStateFlow<Object>> r0 = this.flows;
        MutableStateFlow<Object> r1 = r0.get(r3);
        if (r1 != null) goto L9;
        if (this.regular.containsKey(r3) == true) goto L7;
        this.regular.put(r3, r4);
    L7:
        r1 = StateFlowKt.MutableStateFlow(this.regular.get(r3));
        this.flows.put(r3, r1);
        r0.put(r3, r1);
    L9:
        return FlowKt.asStateFlow(r1);
    }

    public final Set<String> keys() {
        return SetsKt.plus(SetsKt.plus(this.regular.keySet(), this.savedStateProviders.keySet()), this.liveDatas.keySet());
    }

    public final <T> T get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return (T) this.regular.get(r2);
    }

    public final <T> void set(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (Companion.validateValue(r4) == false) goto L16;
        SavingStateLiveData<?> r0 = this.liveDatas.get(r3);
        if ((r0 instanceof MutableLiveData) == false) goto L7;
        SavingStateLiveData<?> r1 = r0;
    L8:
        if (r1 == null) goto L10;
        r1.setValue(r4);
    L11:
        MutableStateFlow<Object> r2 = this.flows.get(r3);
        if (r2 == null) goto L18;
        r2.setValue(r4);
        return;
    L18:
        return;
    L10:
        this.regular.put(r3, r4);
        goto L11
    L7:
        r1 = null;
        goto L8
    L16:
        StringBuilder r5 = new StringBuilder("Can't put value with type ");
        Intrinsics.checkNotNull(r4);
        throw new IllegalArgumentException(r5.append(r4.getClass()).append(" into saved state").toString());
    }

    public final <T> T remove(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        T r0 = (T) this.regular.remove(r3);
        SavingStateLiveData<?> r1 = this.liveDatas.remove(r3);
        if (r1 == null) goto L5;
        r1.detach();
    L5:
        this.flows.remove(r3);
        return r0;
    }

    public final void setSavedStateProvider(String r2, SavedStateRegistry.SavedStateProvider r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.savedStateProviders.put(r2, r3);
    }

    public final void clearSavedStateProvider(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.savedStateProviders.remove(r2);
    }

    static {
        Companion = new Companion(null);
        ACCEPTABLE_CLASSES = new Class[]{Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};
    }
}
