package androidx.fragment.app.strictmode;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.i0.t0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003./0B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010$\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0018\u0010'\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010(\u001a\u00020)H\u0002J0\u0010*\u001a\u00020%2\u0006\u0010\u0010\u001a\u00020\u00062\u000e\u0010+\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0,2\u000e\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120,H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u00061"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode;", "", "()V", "TAG", "", "defaultPolicy", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "getDefaultPolicy", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "setDefaultPolicy", "(Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;)V", "getNearestPolicy", "fragment", "Landroidx/fragment/app/Fragment;", "handlePolicyViolation", "", "policy", "violation", "Landroidx/fragment/app/strictmode/Violation;", "logIfDebuggingEnabled", "onFragmentReuse", "previousFragmentId", "onFragmentTagUsage", "container", "Landroid/view/ViewGroup;", "onGetRetainInstanceUsage", "onGetTargetFragmentRequestCodeUsage", "onGetTargetFragmentUsage", "onPolicyViolation", "onSetRetainInstanceUsage", "onSetTargetFragmentUsage", "violatingFragment", "targetFragment", "requestCode", "", "onSetUserVisibleHint", "isVisibleToUser", "", "onWrongFragmentContainer", "runOnHostThread", "runnable", "Ljava/lang/Runnable;", "shouldHandlePolicyViolation", "fragmentClass", "Ljava/lang/Class;", "violationClass", "Flag", "OnViolationListener", "Policy", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = null;
    private static final String TAG = "FragmentStrictMode";
    private static Policy defaultPolicy;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "", "(Ljava/lang/String;I)V", "PENALTY_LOG", "PENALTY_DEATH", "DETECT_FRAGMENT_REUSE", "DETECT_FRAGMENT_TAG_USAGE", "DETECT_RETAIN_INSTANCE_USAGE", "DETECT_SET_USER_VISIBLE_HINT", "DETECT_TARGET_FRAGMENT_USAGE", "DETECT_WRONG_FRAGMENT_CONTAINER", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum Flag extends Enum<Flag> {
        private static final /* synthetic */ Flag[] $VALUES = null;
        public static final Flag DETECT_FRAGMENT_REUSE = null;
        public static final Flag DETECT_FRAGMENT_TAG_USAGE = null;
        public static final Flag DETECT_RETAIN_INSTANCE_USAGE = null;
        public static final Flag DETECT_SET_USER_VISIBLE_HINT = null;
        public static final Flag DETECT_TARGET_FRAGMENT_USAGE = null;
        public static final Flag DETECT_WRONG_FRAGMENT_CONTAINER = null;
        public static final Flag PENALTY_DEATH = null;
        public static final Flag PENALTY_LOG = null;

        private static final /* synthetic */ Flag[] $values() {
            return new Flag[]{PENALTY_LOG, PENALTY_DEATH, DETECT_FRAGMENT_REUSE, DETECT_FRAGMENT_TAG_USAGE, DETECT_RETAIN_INSTANCE_USAGE, DETECT_SET_USER_VISIBLE_HINT, DETECT_TARGET_FRAGMENT_USAGE, DETECT_WRONG_FRAGMENT_CONTAINER};
        }

        static {
            PENALTY_LOG = new Flag("PENALTY_LOG", 0);
            PENALTY_DEATH = new Flag("PENALTY_DEATH", 1);
            DETECT_FRAGMENT_REUSE = new Flag("DETECT_FRAGMENT_REUSE", 2);
            DETECT_FRAGMENT_TAG_USAGE = new Flag("DETECT_FRAGMENT_TAG_USAGE", 3);
            DETECT_RETAIN_INSTANCE_USAGE = new Flag("DETECT_RETAIN_INSTANCE_USAGE", 4);
            DETECT_SET_USER_VISIBLE_HINT = new Flag("DETECT_SET_USER_VISIBLE_HINT", 5);
            DETECT_TARGET_FRAGMENT_USAGE = new Flag("DETECT_TARGET_FRAGMENT_USAGE", 6);
            DETECT_WRONG_FRAGMENT_CONTAINER = new Flag("DETECT_WRONG_FRAGMENT_CONTAINER", 7);
            $VALUES = $values();
        }

        private Flag(String r1, int r2) {
            super(r1, r2);
        }

        public static Flag valueOf(String r1) {
            return (Flag) Enum.valueOf(Flag.class, r1);
        }

        public static Flag[] values() {
            return (Flag[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "", "onViolation", "", "violation", "Landroidx/fragment/app/strictmode/Violation;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnViolationListener {
        void onViolation(Violation r1);
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016BA\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012 \u0010\u0007\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\n0\b¢\u0006\u0002\u0010\rR\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R.\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\t\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00030\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "allowedViolations", "", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "(Ljava/util/Set;Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;Ljava/util/Map;)V", "getFlags$fragment_release", "()Ljava/util/Set;", "getListener$fragment_release", "()Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "getMAllowedViolations$fragment_release", "()Ljava/util/Map;", "Builder", "Companion", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Policy {
        public static final Companion Companion = null;
        public static final Policy LAX = null;
        private final Set<Flag> flags;
        private final OnViolationListener listener;
        private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\r\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000b2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000bH\u0007J\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\b\u0010\u0015\u001a\u00020\u0000H\u0007J\b\u0010\u0016\u001a\u00020\u0000H\u0007J\b\u0010\u0017\u001a\u00020\u0000H\u0007J\b\u0010\u0018\u001a\u00020\u0000H\u0007J\b\u0010\u0019\u001a\u00020\u0000H\u0007J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u0000H\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\n\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b0\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Builder;", "", "()V", "flags", "", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Flag;", "listener", "Landroidx/fragment/app/strictmode/FragmentStrictMode$OnViolationListener;", "mAllowedViolations", "", "", "Ljava/lang/Class;", "Landroidx/fragment/app/strictmode/Violation;", "allowViolation", "fragmentClass", "Landroidx/fragment/app/Fragment;", "violationClass", "build", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "detectFragmentReuse", "detectFragmentTagUsage", "detectRetainInstanceUsage", "detectSetUserVisibleHint", "detectTargetFragmentUsage", "detectWrongFragmentContainer", "penaltyDeath", "penaltyListener", "penaltyLog", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Builder {
            private final Set<Flag> flags;
            private OnViolationListener listener;
            private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

            public Builder() {
                this.flags = new LinkedHashSet();
                this.mAllowedViolations = new LinkedHashMap();
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(Class<? extends Fragment> r2, Class<? extends Violation> r3) {
                o.f(r2, "fragmentClass");
                o.f(r3, "violationClass");
                String r4 = r2.getName();
                o.e(r4, "fragmentClassString");
                return allowViolation(r4, r3);
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(String r2, Class<? extends Violation> r3) {
                o.f(r2, "fragmentClass");
                o.f(r3, "violationClass");
                Set<Class<? extends Violation>> r0 = this.mAllowedViolations.get(r2);
                if (r0 != null) goto L5;
                r0 = new LinkedHashSet();
            L5:
                r0.add(r3);
                this.mAllowedViolations.put(r2, r0);
                return this;
            }

            public final Policy build() {
                if (this.listener != null) goto L8;
                if (this.flags.contains(Flag.PENALTY_DEATH) == true) goto L8;
                penaltyLog();
            L8:
                return new Policy(this.flags, this.listener, this.mAllowedViolations);
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentReuse() {
                this.flags.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentTagUsage() {
                this.flags.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectRetainInstanceUsage() {
                this.flags.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectSetUserVisibleHint() {
                this.flags.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectTargetFragmentUsage() {
                this.flags.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectWrongFragmentContainer() {
                this.flags.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyDeath() {
                this.flags.add(Flag.PENALTY_DEATH);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyListener(OnViolationListener r2) {
                o.f(r2, "listener");
                this.listener = r2;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyLog() {
                this.flags.add(Flag.PENALTY_LOG);
                return this;
            }
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy$Companion;", "", "()V", "LAX", "Landroidx/fragment/app/strictmode/FragmentStrictMode$Policy;", "fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
            LAX = new Policy(t0.b(), null, m0.h());
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Policy(Set<? extends Flag> r2, OnViolationListener r3, Map<String, ? extends Set<Class<? extends Violation>>> r4) {
            o.f(r2, "flags");
            o.f(r4, "allowedViolations");
            this.flags = r2;
            this.listener = r3;
            LinkedHashMap r5 = new LinkedHashMap();
            Iterator<Map.Entry<String, ? extends Set<Class<? extends Violation>>>> r6 = r4.entrySet().iterator();
        L4:
            if (r6.hasNext() == false) goto L6;
            Map.Entry<String, ? extends Set<Class<? extends Violation>>> r7 = r6.next();
            r5.put(r7.getKey(), r7.getValue());
            goto L4
        L6:
            this.mAllowedViolations = r5;
        }

        public final Set<Flag> getFlags$fragment_release() {
            return this.flags;
        }

        public final OnViolationListener getListener$fragment_release() {
            return this.listener;
        }

        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.mAllowedViolations;
        }
    }

    static {
        INSTANCE = new FragmentStrictMode();
        defaultPolicy = Policy.LAX;
    }

    private FragmentStrictMode() {
    }

    public static /* synthetic */ void a(Policy r0, Violation r1) {
        m18handlePolicyViolation$lambda0(r0, r1);
    }

    public static /* synthetic */ void b(String r0, Violation r1) {
        m19handlePolicyViolation$lambda1(r0, r1);
    }

    private final Policy getNearestPolicy(Fragment r2) {
    L2:
        if (r2 == null) goto L11;
        if (r2.isAdded() == false) goto L9;
        FragmentManager r1 = r2.getParentFragmentManager();
        o.e(r1, "declaringFragment.parentFragmentManager");
        if (r1.getStrictModePolicy() == null) goto L9;
        Policy r3 = r1.getStrictModePolicy();
        o.c(r3);
        return r3;
    L9:
        r2 = r2.getParentFragment();
        goto L2
    L11:
        return defaultPolicy;
    }

    private final void handlePolicyViolation(final Policy r5, final Violation r6) {
        Fragment r0 = r6.getFragment();
        final String r1 = r0.getClass().getName();
        if (r5.getFlags$fragment_release().contains(Flag.PENALTY_LOG) == false) goto L6;
        Log.d(TAG, "Policy violation in " + r1, r6);
    L6:
        if (r5.getListener$fragment_release() == null) goto L9;
        runOnHostThread(r0, new a(r5, r6));
    L9:
        if (r5.getFlags$fragment_release().contains(Flag.PENALTY_DEATH) == false) goto L12;
        runOnHostThread(r0, new b(r1, r6));
        return;
    }

    /* JADX INFO: renamed from: handlePolicyViolation$lambda-0, reason: not valid java name */
    private static final void m18handlePolicyViolation$lambda0(Policy r1, Violation r2) {
        o.f(r1, "$policy");
        o.f(r2, "$violation");
        r1.getListener$fragment_release().onViolation(r2);
    }

    /* JADX INFO: renamed from: handlePolicyViolation$lambda-1, reason: not valid java name */
    private static final void m19handlePolicyViolation$lambda1(String r2, Violation r3) {
        o.f(r3, "$violation");
        Log.e(TAG, "Policy violation with PENALTY_DEATH in " + r2, r3);
        throw r3;
    }

    private final void logIfDebuggingEnabled(Violation r2) {
        if (FragmentManager.isLoggingEnabled(3) == false) goto L6;
        Log.d(FragmentManager.TAG, "StrictMode violation in " + r2.getFragment().getClass().getName(), r2);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentReuse(Fragment r4, String r5) {
        o.f(r4, "fragment");
        o.f(r5, "previousFragmentId");
        FragmentReuseViolation r0 = new FragmentReuseViolation(r4, r5);
        FragmentStrictMode r6 = INSTANCE;
        r6.logIfDebuggingEnabled(r0);
        Policy r1 = r6.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) == true) goto L5;
        return;
    L5:
        if (r6.shouldHandlePolicyViolation(r1, r4.getClass(), r0.getClass()) == false) goto L9;
        r6.handlePolicyViolation(r1, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentTagUsage(Fragment r4, ViewGroup r5) {
        o.f(r4, "fragment");
        FragmentTagUsageViolation r0 = new FragmentTagUsageViolation(r4, r5);
        FragmentStrictMode r6 = INSTANCE;
        r6.logIfDebuggingEnabled(r0);
        Policy r1 = r6.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) == true) goto L5;
        return;
    L5:
        if (r6.shouldHandlePolicyViolation(r1, r4.getClass(), r0.getClass()) == false) goto L9;
        r6.handlePolicyViolation(r1, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetRetainInstanceUsage(Fragment r5) {
        o.f(r5, "fragment");
        GetRetainInstanceUsageViolation r0 = new GetRetainInstanceUsageViolation(r5);
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentRequestCodeUsage(Fragment r5) {
        o.f(r5, "fragment");
        GetTargetFragmentRequestCodeUsageViolation r0 = new GetTargetFragmentRequestCodeUsageViolation(r5);
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentUsage(Fragment r5) {
        o.f(r5, "fragment");
        GetTargetFragmentUsageViolation r0 = new GetTargetFragmentUsageViolation(r5);
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetRetainInstanceUsage(Fragment r5) {
        o.f(r5, "fragment");
        SetRetainInstanceUsageViolation r0 = new SetRetainInstanceUsageViolation(r5);
        FragmentStrictMode r1 = INSTANCE;
        r1.logIfDebuggingEnabled(r0);
        Policy r2 = r1.getNearestPolicy(r5);
        if (r2.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) == true) goto L5;
        return;
    L5:
        if (r1.shouldHandlePolicyViolation(r2, r5.getClass(), r0.getClass()) == false) goto L9;
        r1.handlePolicyViolation(r2, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetTargetFragmentUsage(Fragment r3, Fragment r4, int r5) {
        o.f(r3, "violatingFragment");
        o.f(r4, "targetFragment");
        SetTargetFragmentUsageViolation r0 = new SetTargetFragmentUsageViolation(r3, r4, r5);
        FragmentStrictMode r6 = INSTANCE;
        r6.logIfDebuggingEnabled(r0);
        Policy r7 = r6.getNearestPolicy(r3);
        if (r7.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) == true) goto L5;
        return;
    L5:
        if (r6.shouldHandlePolicyViolation(r7, r3.getClass(), r0.getClass()) == false) goto L9;
        r6.handlePolicyViolation(r7, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetUserVisibleHint(Fragment r4, boolean r5) {
        o.f(r4, "fragment");
        SetUserVisibleHintViolation r0 = new SetUserVisibleHintViolation(r4, r5);
        FragmentStrictMode r6 = INSTANCE;
        r6.logIfDebuggingEnabled(r0);
        Policy r1 = r6.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) == true) goto L5;
        return;
    L5:
        if (r6.shouldHandlePolicyViolation(r1, r4.getClass(), r0.getClass()) == false) goto L9;
        r6.handlePolicyViolation(r1, r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongFragmentContainer(Fragment r4, ViewGroup r5) {
        o.f(r4, "fragment");
        o.f(r5, "container");
        WrongFragmentContainerViolation r0 = new WrongFragmentContainerViolation(r4, r5);
        FragmentStrictMode r6 = INSTANCE;
        r6.logIfDebuggingEnabled(r0);
        Policy r1 = r6.getNearestPolicy(r4);
        if (r1.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) == true) goto L5;
        return;
    L5:
        if (r6.shouldHandlePolicyViolation(r1, r4.getClass(), r0.getClass()) == false) goto L9;
        r6.handlePolicyViolation(r1, r0);
        return;
    }

    private final void runOnHostThread(Fragment r2, Runnable r3) {
        if (r2.isAdded() == false) goto L8;
        Handler r1 = r2.getParentFragmentManager().getHost().getHandler();
        o.e(r1, "fragment.parentFragmentManager.host.handler");
        if (o.a(r1.getLooper(), Looper.myLooper()) == true) goto L8;
        r1.post(r3);
        return;
    L8:
        r3.run();
    }

    private final boolean shouldHandlePolicyViolation(Policy r2, Class<? extends Fragment> r3, Class<? extends Violation> r4) {
        Set<Class<? extends Violation>> r1 = r2.getMAllowedViolations$fragment_release().get(r3.getName());
        if (r1 != null) goto L6;
        return true;
    L6:
        if (o.a(r4.getSuperclass(), Violation.class) == true) goto L12;
        if (r.J(r1, r4.getSuperclass()) == false) goto L12;
        return false;
    L12:
        return !r1.contains(r4);
    }

    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @VisibleForTesting
    public final void onPolicyViolation(Violation r4) {
        o.f(r4, "violation");
        logIfDebuggingEnabled(r4);
        Fragment r0 = r4.getFragment();
        Policy r1 = getNearestPolicy(r0);
        if (shouldHandlePolicyViolation(r1, r0.getClass(), r4.getClass()) == false) goto L6;
        handlePolicyViolation(r1, r4);
        return;
    }

    public final void setDefaultPolicy(Policy r1) {
        o.f(r1, "<set-?>");
        defaultPolicy = r1;
    }
}
