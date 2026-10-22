package android.os;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class FakeFeatureFlagsImpl extends CustomFeatureFlags {
    private final FeatureFlags mDefaults;
    private final Map<String, Boolean> mFlagMap;

    public FakeFeatureFlagsImpl() {
        this(null);
    }

    public FakeFeatureFlagsImpl(FeatureFlags r4) {
        super(null);
        this.mFlagMap = new HashMap();
        this.mDefaults = r4;
        Iterator<String> r5 = getFlagNames().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r1 = r5.next();
        this.mFlagMap.put(r1, null);
        goto L4
    }

    @Override // android.os.CustomFeatureFlags
    protected boolean getValue(String r2, Predicate<FeatureFlags> r3) {
        Boolean r0 = this.mFlagMap.get(r2);
        if (r0 != null) goto L5;
        FeatureFlags r1 = this.mDefaults;
        if (r1 == null) goto L11;
        return r3.test(r1);
    L11:
        throw new IllegalArgumentException(r2 + " is not set");
    L5:
        return r0.booleanValue();
    }

    public void setFlag(String r2, boolean r3) {
        if (this.mFlagMap.containsKey(r2) == false) goto L7;
        this.mFlagMap.put(r2, Boolean.valueOf(r3));
        return;
    L7:
        throw new IllegalArgumentException("no such flag " + r2);
    }

    public void resetAll() {
        Iterator<Map.Entry<String, Boolean>> r2 = this.mFlagMap.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r2.next().setValue(null);
        goto L4
    }
}
