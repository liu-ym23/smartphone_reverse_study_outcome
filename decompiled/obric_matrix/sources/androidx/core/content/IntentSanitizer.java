package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class IntentSanitizer {
    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    /* JADX INFO: renamed from: androidx.core.content.IntentSanitizer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    @RequiresApi(15)
    private static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Intent getSelector(Intent r0) {
            return r0.getSelector();
        }

        @DoNotInline
        static void setSelector(Intent r0, Intent r1) {
            r0.setSelector(r1);
        }
    }

    @RequiresApi(16)
    private static class Api16Impl {

        @RequiresApi(31)
        private static class Api31Impl {
            private Api31Impl() {
            }

            @DoNotInline
            static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
                if (r3.getHtmlText() == null) goto L5;
            L8:
                r4.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
                return;
            L5:
                if (r3.getIntent() != null) goto L8;
                if (r3.getTextLinks() != null) goto L8;
            }
        }

        private Api16Impl() {
        }

        private static void checkOtherMembers(int r2, ClipData.Item r3, Consumer<String> r4) {
            if (r3.getHtmlText() == null) goto L5;
        L6:
            r4.accept("ClipData item at position " + r2 + " contains htmlText, textLinks or intent: " + r3);
            return;
        L5:
            if (r3.getIntent() != null) goto L6;
        }

        @DoNotInline
        static void sanitizeClipData(@NonNull Intent r7, Intent r8, Predicate<ClipData> r9, boolean r10, Predicate<Uri> r11, Consumer<String> r12) {
            ClipData r13 = r7.getClipData();
            if (r13 != null) goto L5;
            return;
        L5:
            if (r9 != null) goto L7;
        L9:
            int r14 = 0;
            ClipData r1 = null;
        L11:
            if (r14 >= r13.getItemCount()) goto L40;
            ClipData.Item r2 = r13.getItemAt(r14);
            if (Build.VERSION.SDK_INT < 31) goto L15;
            Api31Impl.checkOtherMembers(r14, r2, r12);
        L16:
            CharSequence r3 = r2.getText();
            if (r10 == true) goto L22;
            if (r3 == null) goto L21;
            r12.accept("Item text cannot contain value. Item position: " + r14 + ". Text: " + r2.getText());
        L21:
            r3 = null;
        L22:
            Uri r6 = r2.getUri();
            if (r11 != null) goto L27;
            if (r6 == null) goto L32;
            StringBuilder r15 = new StringBuilder();
        L26:
            r15.append("Item URI is not allowed. Item position: ");
            r15.append(r14);
            r15.append(". URI: ");
            r15.append(r2.getUri());
            r12.accept(r15.toString());
        L32:
            Uri r4 = null;
        L34:
            if (r3 != null) goto L36;
            if (r4 != null) goto L36;
        L39:
            r14 = r14 + 1;
        L36:
            if (r1 != null) goto L38;
            r1 = new ClipData(r13.getDescription(), new ClipData.Item(r3, null, r4));
            goto L39
        L38:
            r1.addItem(new ClipData.Item(r3, null, r4));
            goto L39
        L27:
            if (r6 != null) goto L29;
        L33:
            r4 = r2.getUri();
            goto L34
        L29:
            if (r11.test(r2.getUri()) == true) goto L33;
            r15 = new StringBuilder();
            goto L26
        L15:
            checkOtherMembers(r14, r2, r12);
            goto L16
        L40:
            if (r1 == null) goto L48;
            r8.setClipData(r1);
            return;
        L48:
            return;
        L7:
            if (r9.test(r13) == false) goto L9;
            r8.setClipData(r13);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static String getIdentifier(Intent r0) {
            return r0.getIdentifier();
        }

        @DoNotInline
        static Intent setIdentifier(Intent r0, String r1) {
            return r0.setIdentifier(r1);
        }
    }

    public static final class Builder {
        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions;
        private Predicate<String> mAllowedCategories;
        private Predicate<ClipData> mAllowedClipData;
        private Predicate<Uri> mAllowedClipDataUri;
        private Predicate<ComponentName> mAllowedComponents;
        private Predicate<Uri> mAllowedData;
        private Map<String, Predicate<Object>> mAllowedExtras;
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages;
        private Predicate<String> mAllowedTypes;

        public Builder() {
            this.mAllowedActions = e.f265a;
            this.mAllowedData = i.f269a;
            this.mAllowedTypes = a.f261a;
            this.mAllowedCategories = j.f270a;
            this.mAllowedPackages = h.f268a;
            this.mAllowedComponents = o.f275a;
            this.mAllowedExtras = new HashMap();
            this.mAllowClipDataText = false;
            this.mAllowedClipDataUri = b.f262a;
            this.mAllowedClipData = q.f278a;
        }

        static /* synthetic */ boolean a(ComponentName r0) {
            return true;
        }

        static /* synthetic */ boolean b(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean c(String r0, ComponentName r1) {
            return r0.equals(r1.getPackageName());
        }

        static /* synthetic */ boolean d(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean e(Object r0) {
            return true;
        }

        static /* synthetic */ boolean f(Class r1, Predicate r2, Object r3) {
            if (r1.isInstance(r3) == true) goto L5;
        L7:
            return false;
        L5:
            if (r2.test(r1.cast(r3)) == false) goto L7;
            return true;
        }

        static /* synthetic */ boolean g(Object r0) {
            return false;
        }

        static /* synthetic */ boolean h(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean i(String r0, Uri r1) {
            return r0.equals(r1.getAuthority());
        }

        static /* synthetic */ boolean j(String r0) {
            return false;
        }

        static /* synthetic */ boolean k(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean l(String r0) {
            return false;
        }

        static /* synthetic */ boolean m(String r0) {
            return false;
        }

        static /* synthetic */ boolean n(String r0) {
            return false;
        }

        static /* synthetic */ boolean o(ComponentName r0) {
            return false;
        }

        static /* synthetic */ boolean p(Uri r0) {
            return false;
        }

        static /* synthetic */ boolean q(ClipData r0) {
            return false;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedActions = this.mAllowedActions.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAction(@NonNull String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            allowAction(new w(r2));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            this.mAllowedComponents = d.f264a;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedCategories = this.mAllowedCategories.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowCategory(@NonNull String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowCategory(new w(r2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipData(@NonNull Predicate<ClipData> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedClipData = this.mAllowedClipData.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUri(@NonNull Predicate<Uri> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowClipDataUriWithAuthority(@NonNull final String r2) {
            Preconditions.checkNotNull(r2);
            return allowClipDataUri(new g(r2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull final ComponentName r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowComponent(new v(r2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponent(@NonNull Predicate<ComponentName> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowComponentWithPackage(@NonNull final String r2) {
            Preconditions.checkNotNull(r2);
            return allowComponent(new m(r2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowData(@NonNull Predicate<Uri> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedData = this.mAllowedData.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowDataWithAuthority(@NonNull final String r2) {
            Preconditions.checkNotNull(r2);
            allowData(new k(r2));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r2, @NonNull Predicate<Object> r3) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Predicate<Object> r0 = this.mAllowedExtras.get(r2);
            if (r0 != null) goto L5;
            r0 = f.f266a;
        L5:
            Predicate<Object> r4 = r0.or(r3);
            this.mAllowedExtras.put(r2, r4);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtra(@NonNull String r2, @NonNull Class<?> r3) {
            return allowExtra(r2, r3, l.f272a);
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public <T> Builder allowExtra(@NonNull String r2, @NonNull final Class<T> r3, @NonNull final Predicate<T> r4) {
            Preconditions.checkNotNull(r2);
            Preconditions.checkNotNull(r3);
            Preconditions.checkNotNull(r4);
            return allowExtra(r2, new p(r3, r4));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull Predicate<Uri> r3) {
            allowExtra("output", Uri.class, r3);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraOutput(@NonNull final String r3) {
            allowExtra("output", Uri.class, new c(r3));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStream(@NonNull Predicate<Uri> r3) {
            allowExtra("android.intent.extra.STREAM", Uri.class, r3);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowExtraStreamUriWithAuthority(@NonNull final String r3) {
            Preconditions.checkNotNull(r3);
            allowExtra("android.intent.extra.STREAM", Uri.class, new n(r3));
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowFlags(int r2) {
            this.mAllowedFlags = r2 | this.mAllowedFlags;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowHistoryStackFlags() {
            this.mAllowedFlags |= HISTORY_STACK_FLAGS;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedPackages = this.mAllowedPackages.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowPackage(@NonNull String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowPackage(new w(r2));
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowReceiverFlags() {
            this.mAllowedFlags |= RECEIVER_FLAGS;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull Predicate<String> r2) {
            Preconditions.checkNotNull(r2);
            this.mAllowedTypes = this.mAllowedTypes.or(r2);
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder allowType(@NonNull String r2) {
            Preconditions.checkNotNull(r2);
            Objects.requireNonNull(r2);
            return allowType(new w(r2));
        }

        @NonNull
        @SuppressLint({"SyntheticAccessor"})
        public IntentSanitizer build() {
            boolean r0 = this.mAllowAnyComponent;
            if (r0 == true) goto L5;
        L6:
            if (r0 == false) goto L8;
        L12:
            IntentSanitizer r1 = new IntentSanitizer(null);
            IntentSanitizer.access$102(r1, this.mAllowedFlags);
            IntentSanitizer.access$202(r1, this.mAllowedActions);
            IntentSanitizer.access$302(r1, this.mAllowedData);
            IntentSanitizer.access$402(r1, this.mAllowedTypes);
            IntentSanitizer.access$502(r1, this.mAllowedCategories);
            IntentSanitizer.access$602(r1, this.mAllowedPackages);
            IntentSanitizer.access$702(r1, this.mAllowAnyComponent);
            IntentSanitizer.access$802(r1, this.mAllowedComponents);
            IntentSanitizer.access$902(r1, this.mAllowedExtras);
            IntentSanitizer.access$1002(r1, this.mAllowClipDataText);
            IntentSanitizer.access$1102(r1, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(r1, this.mAllowedClipData);
            IntentSanitizer.access$1302(r1, this.mAllowIdentifier);
            IntentSanitizer.access$1402(r1, this.mAllowSelector);
            IntentSanitizer.access$1502(r1, this.mAllowSourceBounds);
            return r1;
        L8:
            if (this.mAllowSomeComponents == true) goto L12;
        L11:
            throw new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
        L5:
            if (this.mAllowSomeComponents == true) goto L11;
            goto L6
        }
    }

    private IntentSanitizer() {
    }

    /* synthetic */ IntentSanitizer(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ void a(String r0) {
    }

    static /* synthetic */ boolean access$1002(IntentSanitizer r0, boolean r1) {
        r0.mAllowClipDataText = r1;
        return r1;
    }

    static /* synthetic */ int access$102(IntentSanitizer r0, int r1) {
        r0.mAllowedFlags = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$1102(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedClipDataUri = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$1202(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedClipData = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1302(IntentSanitizer r0, boolean r1) {
        r0.mAllowIdentifier = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1402(IntentSanitizer r0, boolean r1) {
        r0.mAllowSelector = r1;
        return r1;
    }

    static /* synthetic */ boolean access$1502(IntentSanitizer r0, boolean r1) {
        r0.mAllowSourceBounds = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$202(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedActions = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$302(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedData = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$402(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedTypes = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$502(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedCategories = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$602(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedPackages = r1;
        return r1;
    }

    static /* synthetic */ boolean access$702(IntentSanitizer r0, boolean r1) {
        r0.mAllowAnyComponent = r1;
        return r1;
    }

    static /* synthetic */ Predicate access$802(IntentSanitizer r0, Predicate r1) {
        r0.mAllowedComponents = r1;
        return r1;
    }

    static /* synthetic */ Map access$902(IntentSanitizer r0, Map r1) {
        r0.mAllowedExtras = r1;
        return r1;
    }

    static /* synthetic */ void b(String r1) {
        throw new SecurityException(r1);
    }

    private void putExtra(Intent r1, String r2, Object r3) {
        if (r3 != null) goto L5;
        r1.getExtras().putString(r2, null);
        return;
    L5:
        if ((r3 instanceof Parcelable) == false) goto L8;
        r1.putExtra(r2, (Parcelable) r3);
        return;
    L8:
        if ((r3 instanceof Parcelable[]) == false) goto L11;
        r1.putExtra(r2, (Parcelable[]) r3);
        return;
    L11:
        if ((r3 instanceof Serializable) == false) goto L15;
        r1.putExtra(r2, (Serializable) r3);
        return;
    L15:
        throw new IllegalArgumentException("Unsupported type " + r3.getClass());
    }

    @NonNull
    public Intent sanitize(@NonNull Intent r9, @NonNull Consumer<String> r10) {
        Intent r6 = new Intent();
        ComponentName r0 = r9.getComponent();
        if (this.mAllowAnyComponent == false) goto L6;
        if (r0 != null) goto L6;
    L7:
        r6.setComponent(r0);
        String r1 = r9.getPackage();
        if (r1 != null) goto L12;
    L15:
        r6.setPackage(r1);
    L16:
        int r2 = this.mAllowedFlags | r9.getFlags();
        int r3 = this.mAllowedFlags;
        if (r2 != r3) goto L19;
        r6.setFlags(r9.getFlags());
    L20:
        String r4 = r9.getAction();
        if (r4 != null) goto L23;
    L26:
        r6.setAction(r4);
    L27:
        Uri r5 = r9.getData();
        if (r5 != null) goto L30;
    L33:
        r6.setData(r5);
    L34:
        String r7 = r9.getType();
        if (r7 != null) goto L37;
    L40:
        r6.setDataAndType(r6.getData(), r7);
    L41:
        Set<String> r8 = r9.getCategories();
        if (r8 == null) goto L50;
        Iterator<String> r11 = r8.iterator();
    L45:
        if (r11.hasNext() == false) goto L50;
        String r12 = r11.next();
        if (this.mAllowedCategories.test(r12) == true) goto L48;
        r10.accept("Category is not allowed: " + r12);
        goto L45
    L48:
        r6.addCategory(r12);
    L50:
        Bundle r13 = r9.getExtras();
        if (r13 == null) goto L72;
        Iterator<String> r14 = r13.keySet().iterator();
    L54:
        if (r14.hasNext() == false) goto L72;
        String r15 = r14.next();
        if (r15.equals("android.intent.extra.STREAM") == false) goto L62;
        if ((this.mAllowedFlags & 1) != 0) goto L62;
        String r16 = "Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.";
    L60:
        r10.accept(r16);
    L62:
        if (r15.equals("output") == true) goto L64;
    L66:
        Object r17 = r13.get(r15);
        Predicate<Object> r18 = this.mAllowedExtras.get(r15);
        if (r18 == null) goto L71;
        if (r18.test(r17) == false) goto L71;
        putExtra(r6, r15, r17);
    L71:
        r16 = "Extra is not allowed. Key: " + r15 + ". Value: " + r17;
        goto L60
    L64:
        if (((~this.mAllowedFlags) & 3) == 0) goto L66;
        r16 = "Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.";
    L72:
        int r19 = Build.VERSION.SDK_INT;
        if (r19 < 16) goto L76;
        Api16Impl.sanitizeClipData(r9, r6, this.mAllowedClipData, this.mAllowClipDataText, this.mAllowedClipDataUri, r10);
    L76:
        if (r19 < 29) goto L84;
        if (this.mAllowIdentifier == false) goto L81;
        Api29Impl.setIdentifier(r6, Api29Impl.getIdentifier(r9));
        goto L84
    L81:
        if (Api29Impl.getIdentifier(r9) == null) goto L84;
        r10.accept("Identifier is not allowed: " + Api29Impl.getIdentifier(r9));
    L84:
        if (r19 < 15) goto L92;
        if (this.mAllowSelector == false) goto L89;
        Api15Impl.setSelector(r6, Api15Impl.getSelector(r9));
        goto L92
    L89:
        if (Api15Impl.getSelector(r9) == null) goto L92;
        r10.accept("Selector is not allowed: " + Api15Impl.getSelector(r9));
    L92:
        if (this.mAllowSourceBounds == false) goto L95;
        r6.setSourceBounds(r9.getSourceBounds());
    L97:
        return r6;
    L95:
        if (r9.getSourceBounds() == null) goto L97;
        r10.accept("SourceBounds is not allowed: " + r9.getSourceBounds());
        goto L97
    L37:
        if (this.mAllowedTypes.test(r7) == true) goto L40;
        r10.accept("Type is not allowed: " + r7);
        goto L41
    L30:
        if (this.mAllowedData.test(r5) == true) goto L33;
        r10.accept("Data is not allowed: " + r5);
        goto L34
    L23:
        if (this.mAllowedActions.test(r4) == true) goto L26;
        r10.accept("Action is not allowed: " + r4);
        goto L27
    L19:
        r6.setFlags(r9.getFlags() & r3);
        r10.accept("The intent contains flags that are not allowed: 0x" + Integer.toHexString(r9.getFlags() & (~this.mAllowedFlags)));
        goto L20
    L12:
        if (this.mAllowedPackages.test(r1) == true) goto L15;
        r10.accept("Package is not allowed: " + r1);
    L6:
        if (this.mAllowedComponents.test(r0) == true) goto L7;
        r10.accept("Component is not allowed: " + r0);
        r0 = new ComponentName("android", "java.lang.Void");
        goto L7
    }

    @NonNull
    public Intent sanitizeByFiltering(@NonNull Intent r2) {
        return sanitize(r2, s.f284f);
    }

    @NonNull
    public Intent sanitizeByThrowing(@NonNull Intent r2) {
        return sanitize(r2, r.f279f);
    }
}
