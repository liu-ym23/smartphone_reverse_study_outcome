package com.bytedanceos.security.debug;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.core.view.ViewCompat;
import com.bytedance.tracing.internal.TracingConstants;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.debug.json.JsonEditorBinder;
import com.bytedanceos.security.debug.settings.SettingsKeyAdapter;
import com.bytedanceos.security.debug.settings.SettingsKeyClassScanner;
import com.bytedanceos.security.debug.settings.SettingsKeyEntry;
import com.bytedanceos.security.debug.settings.SettingsKeyEntryBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.oui.forms.OEditText;
import com.obric.oui.material.MaterialConfigBuilder;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.sheet.v2.OSheet;
import com.obric.oui.sheet.v2.OSheetBase;
import com.obric.security.R;
import com.obric.securitycenter.api.settings.IScope;
import com.obric.securitycenter.api.settings.SettingsManager;
import com.obric.securitycenter.api.settings.Value;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SettingsManageActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u00020%2\b\u0010'\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010(\u001a\u00020%H\u0002J\u0016\u0010)\u001a\u0004\u0018\u00010*2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030,H\u0002J\u001c\u0010-\u001a\u00020.2\n\u0010/\u001a\u0006\u0012\u0002\b\u00030,2\u0006\u00100\u001a\u000201H\u0002J\u0012\u00102\u001a\u00020%2\b\u00103\u001a\u0004\u0018\u000104H\u0014J\b\u00105\u001a\u00020%H\u0014J\b\u00106\u001a\u00020%H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0018\u001a\n \u0013*\u0004\u0018\u00010\u00190\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\u001f\u0010 R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lcom/bytedanceos/security/debug/SettingsManageActivity;", "Lcom/bytedanceos/security/BaseActivity;", "()V", "allEntries", "", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "keyboardListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "lastImeVisible", "", "Ljava/lang/Boolean;", "mockConfig", "Lcom/google/gson/JsonObject;", "mockEnabledClassNames", "Ljava/util/LinkedHashSet;", "", "Lkotlin/collections/LinkedHashSet;", "rvSettingsContainer", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "getRvSettingsContainer", "()Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "rvSettingsContainer$delegate", "Lkotlin/Lazy;", "searchBar", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "getSearchBar", "()Lcom/obric/oui/searchbar/v2/OSearchBar;", "searchBar$delegate", "settingsKeyAdapter", "Lcom/bytedanceos/security/debug/settings/SettingsKeyAdapter;", "getSettingsKeyAdapter", "()Lcom/bytedanceos/security/debug/settings/SettingsKeyAdapter;", "settingsKeyAdapter$delegate", "sheet", "Lcom/obric/oui/sheet/v2/OSheet;", "applyRecyclerViewBottomInset", "", "applySearch", "input", "clearSearchBarFocus", "findValueFieldType", "Ljava/lang/reflect/Type;", "clazz", "Ljava/lang/Class;", "genSheetContentView", "Landroid/view/View;", "settingsClass", MaterialConfigBuilder.SERIALIZATION_FORMAT_JSON, "Lcom/google/gson/JsonElement;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "registerKeyboardDismissFocusClear", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SettingsManageActivity extends BaseActivity {
    public static final Companion Companion = null;
    private static final String TAG = "SettingsManageActivity";
    private HashMap _$_findViewCache;
    private List<? extends SettingsKeyEntry> allEntries;
    private ViewTreeObserver.OnGlobalLayoutListener keyboardListener;
    private Boolean lastImeVisible;
    private JsonObject mockConfig;
    private final LinkedHashSet<String> mockEnabledClassNames;
    private final Lazy rvSettingsContainer$delegate;
    private final Lazy searchBar$delegate;
    private final Lazy settingsKeyAdapter$delegate;
    private OSheet sheet;

    /* JADX INFO: compiled from: SettingsManageActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedanceos/security/debug/SettingsManageActivity$Companion;", "", "()V", "TAG", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.security.debug.SettingsManageActivity$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsManageActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "item", "Lcom/bytedanceos/security/debug/settings/SettingsKeyEntry;", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass2 extends Lambda implements Function1<SettingsKeyEntry, Unit> {
        final /* synthetic */ SettingsManageActivity this$0;

        AnonymousClass2(SettingsManageActivity r1) {
            this.this$0 = r1;
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsKeyEntry r1) {
            invoke2(r1);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsKeyEntry r30) {
            Intrinsics.checkNotNullParameter(r30, "item");
            final SettingsKeyEntry.ChildEntry r7 = (SettingsKeyEntry.ChildEntry) r30;
            final Class<?> r8 = r7.getSettingsClass();
            final JsonElement r9 = SettingsManager.getEffectiveJsonValue(r8);
            if (r9 != null) goto L5;
            return;
        L5:
            final View r10 = SettingsManageActivity.access$genSheetContentView(this.this$0, r8, r9);
            if (SettingsManageActivity.access$getSheet$p(this.this$0) != null) goto L8;
            SettingsManageActivity.access$setSheet$p(this.this$0, new OSheet(this.this$0, 0, 0, false, false, 30, null));
        L8:
            OSheet r11 = SettingsManageActivity.access$getSheet$p(this.this$0);
            if (r11 == null) goto L12;
            OSheetBase.DefaultImpls.setHeader$default(r11, OSheet.Header.ACTION, null, null, r7.getSettingsKeyValue(), r7.getTitleValue(), true, new SettingsManageActivity$onCreate$2$$special$$inlined$apply$lambda$1(this, r7, r10, r9, r8), new SettingsManageActivity$onCreate$2$$special$$inlined$apply$lambda$2(this, r7, r10, r9, r8), null, null, null, null, null, null, 16134, null);
            r11.setHeightMode(OSheet.HeightMode.WRAP_HEIGHT);
            r11.setBodyView(r10);
            View r0 = new View(this.this$0);
            RecyclerView.LayoutParams r1 = new RecyclerView.LayoutParams(-1, -2);
            Resources r3 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r3, "Resources.getSystem()");
            r1.height = MathKt.roundToInt(TypedValue.applyDimension(1, 40, r3.getDisplayMetrics()));
            r0.setLayoutParams(r1);
            Unit r2 = Unit.INSTANCE;
            r11.setFooterView(r0);
            r11.show();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.security.debug.SettingsManageActivity$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: SettingsManageActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass3 implements Runnable {
        final /* synthetic */ SettingsManageActivity this$0;

        AnonymousClass3(SettingsManageActivity r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            List<? extends Class<?>> r0 = SettingsKeyClassScanner.scan$default(SettingsKeyClassScanner.INSTANCE, this.this$0, null, 2, null);     // Catch: Throwable -> L4
            final List<SettingsKeyEntry> r1 = SettingsKeyEntryBuilder.INSTANCE.build(r0);     // Catch: Throwable -> L4
            this.this$0.runOnUiThread(new AnonymousClass1(this, r1));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            th.printStackTrace();
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final RecyclerView getRvSettingsContainer() {
        return (RecyclerView) this.rvSettingsContainer$delegate.getValue();
    }

    private final OSearchBar getSearchBar() {
        return (OSearchBar) this.searchBar$delegate.getValue();
    }

    private final SettingsKeyAdapter getSettingsKeyAdapter() {
        return (SettingsKeyAdapter) this.settingsKeyAdapter$delegate.getValue();
    }

    public void _$_clearFindViewByIdCache() {
        HashMap r0 = this._$_findViewCache;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public View _$_findCachedViewById(int r3) {
        if (this._$_findViewCache != null) goto L5;
        this._$_findViewCache = new HashMap();
    L5:
        View r0 = (View) this._$_findViewCache.get(Integer.valueOf(r3));
        if (r0 != null) goto L9;
        View r1 = findViewById(r3);
        this._$_findViewCache.put(Integer.valueOf(r3), r1);
        return r1;
    L9:
        return r0;
    }

    public SettingsManageActivity() {
        this.searchBar$delegate = LazyKt.lazy(new SettingsManageActivity$searchBar$2(this));
        this.rvSettingsContainer$delegate = LazyKt.lazy(new SettingsManageActivity$rvSettingsContainer$2(this));
        this.settingsKeyAdapter$delegate = LazyKt.lazy(SettingsManageActivity$settingsKeyAdapter$2.INSTANCE);
        this.mockEnabledClassNames = new LinkedHashSet();
        this.allEntries = CollectionsKt.emptyList();
    }

    public static final /* synthetic */ void access$applySearch(SettingsManageActivity r0, String r1) {
        r0.applySearch(r1);
    }

    public static final /* synthetic */ void access$clearSearchBarFocus(SettingsManageActivity r0) {
        r0.clearSearchBarFocus();
    }

    public static final /* synthetic */ View access$genSheetContentView(SettingsManageActivity r0, Class r1, JsonElement r2) {
        return r0.genSheetContentView(r1, r2);
    }

    public static final /* synthetic */ List access$getAllEntries$p(SettingsManageActivity r0) {
        return r0.allEntries;
    }

    public static final /* synthetic */ Boolean access$getLastImeVisible$p(SettingsManageActivity r0) {
        return r0.lastImeVisible;
    }

    public static final /* synthetic */ JsonObject access$getMockConfig$p(SettingsManageActivity r0) {
        return r0.mockConfig;
    }

    public static final /* synthetic */ LinkedHashSet access$getMockEnabledClassNames$p(SettingsManageActivity r0) {
        return r0.mockEnabledClassNames;
    }

    public static final /* synthetic */ OSearchBar access$getSearchBar$p(SettingsManageActivity r0) {
        return r0.getSearchBar();
    }

    public static final /* synthetic */ OSheet access$getSheet$p(SettingsManageActivity r0) {
        return r0.sheet;
    }

    public static final /* synthetic */ void access$setAllEntries$p(SettingsManageActivity r0, List r1) {
        r0.allEntries = r1;
    }

    public static final /* synthetic */ void access$setLastImeVisible$p(SettingsManageActivity r0, Boolean r1) {
        r0.lastImeVisible = r1;
    }

    public static final /* synthetic */ void access$setMockConfig$p(SettingsManageActivity r0, JsonObject r1) {
        r0.mockConfig = r1;
    }

    public static final /* synthetic */ void access$setSheet$p(SettingsManageActivity r0, OSheet r1) {
        r0.sheet = r1;
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        finish();
    }

    private final void applyRecyclerViewBottomInset() {
        RecyclerView r0 = getRvSettingsContainer();
        Intrinsics.checkNotNullExpressionValue(r0, "rvSettingsContainer");
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 != null) goto L8;
        return;
    L8:
        final int r3 = r2.bottomMargin;
        ViewCompat.setOnApplyWindowInsetsListener(getRvSettingsContainer(), new AnonymousClass1(r3));
        ViewCompat.requestApplyInsets(getRvSettingsContainer());
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ViewTreeObserver.OnGlobalLayoutListener r0 = this.keyboardListener;
        if (r0 == null) goto L5;
        Window r1 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r1, "window");
        View r2 = r1.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r2, "window.decorView");
        r2.getViewTreeObserver().removeOnGlobalLayoutListener(r0);
    L5:
        ViewTreeObserver.OnGlobalLayoutListener r3 = (ViewTreeObserver.OnGlobalLayoutListener) null;
        this.keyboardListener = null;
        super.onDestroy();
    }

    private final void registerKeyboardDismissFocusClear() {
        Window r0 = getWindow();
        Intrinsics.checkNotNullExpressionValue(r0, "window");
        View r1 = r0.getDecorView();
        Intrinsics.checkNotNullExpressionValue(r1, "window.decorView");
        final View r2 = r1.getRootView();
        ViewCompat.setOnApplyWindowInsetsListener(r2, new C01411(this));
        ViewCompat.requestApplyInsets(r2);
        ViewTreeObserver.OnGlobalLayoutListener r3 = new SettingsManageActivity$registerKeyboardDismissFocusClear$listener$1(this, r2);
        Intrinsics.checkNotNullExpressionValue(r2, "insetsHostView");
        r2.getViewTreeObserver().addOnGlobalLayoutListener(r3);
        this.keyboardListener = r3;
    }

    private final void clearSearchBarFocus() {
        final OEditText r0 = getSearchBar().getInputView();
        r0.clearFocus();
        final boolean r1 = r0.isFocusable();
        final boolean r2 = r0.isFocusableInTouchMode();
        r0.setFocusable(false);
        r0.setFocusableInTouchMode(false);
        r0.post(new RunnableC01401(r0, r1, r2));
        getSearchBar().clearFocus();
        getRvSettingsContainer().requestFocus();
    }

    private final View genSheetContentView(Class<?> r6, JsonElement r7) {
        Type r0 = findValueFieldType(r6);
        final View r1 = LayoutInflater.from(this).inflate(R.layout.pm_sheet_json_editor, null, false);
        OSwitch r2 = (OSwitch) r1.findViewById(R.id.switch_mock);
        boolean r5 = this.mockEnabledClassNames.contains(r6.getName());
        if (r2 == null) goto L5;
        r2.setChecked(r5);
    L5:
        JsonEditorBinder r8 = JsonEditorBinder.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r1, "root");
        r8.bind(r1, r7, r0, r5);
        if (r2 == null) goto L8;
        r2.setOnCheckedChangeListener(new SettingsManageActivity$genSheetContentView$1$1(r1));
    L8:
        Intrinsics.checkNotNullExpressionValue(r1, "LayoutInflater.from(this…         })\n            }");
        return r1;
    }

    private final Type findValueFieldType(Class<?> r7) {
        Field[] r6 = r7.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(r6, TracingConstants.KEY_FIELDS);
        int r0 = 0;
        if (r6.length != 0) goto L5;
        boolean r8 = true;
    L7:
        if (r8 == false) goto L9;
        return null;
    L9:
        ArrayList r9 = new ArrayList();
        Field r2 = (Field) null;
        int r3 = r6.length;
        Field r4 = null;
    L10:
        if (r0 >= r3) goto L18;
        Field r5 = r6[r0];
        Value r10 = (Value) r5.getAnnotation(Value.class);
        if (r10 == null) goto L17;
        r9.add(r5);
        if (r10.isDefault() == false) goto L17;
        r4 = r5;
    L17:
        r0 = r0 + 1;
        goto L10
    L18:
        if (r4 != null) goto L20;
        r4 = (Field) CollectionsKt.singleOrNull(r9);
    L20:
        if (r4 != null) goto L23;
        return null;
    L23:
        if (Modifier.isStatic(r4.getModifiers()) == true) goto L26;
        return null;
    L26:
        return r4.getGenericType();
    L5:
        r8 = false;
        goto L7
    }

    private final void applySearch(String r12) {
        if (this.allEntries.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12 == null) goto L8;
        final String r13 = StringsKt.trim(r12).toString();
    L9:
        if (r13 != null) goto L12;
        r13 = "";
    L12:
        if (r13.length() != 0) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L18;
        getSettingsKeyAdapter().submitList(this.allEntries);
        return;
    L18:
        Sequence r2 = SequencesKt.filter(CollectionsKt.asSequence(this.allEntries), SettingsManageActivity$applySearch$$inlined$filterIsInstance$1.INSTANCE);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        List r3 = SequencesKt.toList(SequencesKt.filterNot(r2, SettingsManageActivity$applySearch$allChildren$1.INSTANCE));
        Sequence r4 = SequencesKt.filter(CollectionsKt.asSequence(this.allEntries), SettingsManageActivity$applySearch$$inlined$filterIsInstance$2.INSTANCE);
        Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        HashSet r5 = SequencesKt.toHashSet(SequencesKt.map(SequencesKt.filter(r4, new SettingsManageActivity$applySearch$matchedScopeClasses$1(r13)), SettingsManageActivity$applySearch$matchedScopeClasses$2.INSTANCE));
        List r6 = r3;
        List r14 = SequencesKt.toList(SequencesKt.filter(CollectionsKt.asSequence(r6), new SettingsManageActivity$applySearch$matchedChildren$1(r13)));
        List r7 = r14;
        LinkedHashMap r8 = new LinkedHashMap();
        Iterator r9 = r7.iterator();
    L20:
        if (r9.hasNext() == false) goto L25;
        Object r10 = r9.next();
        Class<? extends IScope> r11 = ((SettingsKeyEntry.ChildEntry) r10).getModuleScopeClass();
        Object r15 = r8.get(r11);
        if (r15 != null) goto L24;
        r15 = (List) new ArrayList();
        r8.put(r11, r15);
    L24:
        ((List) r15).add(r10);
        goto L20
    L25:
        LinkedHashMap r16 = new LinkedHashMap();
        Iterator r17 = r6.iterator();
    L27:
        if (r17.hasNext() == false) goto L32;
        Object r18 = r17.next();
        Class<? extends IScope> r19 = ((SettingsKeyEntry.ChildEntry) r18).getModuleScopeClass();
        Object r20 = r16.get(r19);
        if (r20 != null) goto L31;
        r20 = (List) new ArrayList();
        r16.put(r19, r20);
    L31:
        ((List) r20).add(r18);
        goto L27
    L32:
        ArrayList r21 = new ArrayList(r14.size() * 2);
        HashSet r110 = new HashSet();
        Iterator<? extends SettingsKeyEntry> r22 = this.allEntries.iterator();
    L34:
        if (r22.hasNext() == false) goto L57;
        SettingsKeyEntry r23 = r22.next();
        if ((r23 instanceof SettingsKeyEntry.ScopeEntry) == true) goto L38;
        r23 = null;
    L38:
        SettingsKeyEntry.ScopeEntry r24 = (SettingsKeyEntry.ScopeEntry) r23;
        if (r24 == null) goto L34;
        if (r5.contains(r24.getScopeClass()) == false) goto L47;
        List r25 = (List) r16.get(r24.getScopeClass());
        if (r25 != null) goto L46;
        r25 = CollectionsKt.emptyList();
    L46:
        List r26 = CollectionsKt.sortedWith(r25, new SettingsManageActivity$applySearch$$inlined$sortedBy$1());
    L52:
        if (r26.isEmpty() == true) goto L34;
        r21.add(r24);
        r21.addAll(r26);
        Iterator r27 = r26.iterator();
    L55:
        if (r27.hasNext() == false) goto L34;
        r110.add(((SettingsKeyEntry.ChildEntry) r27.next()).getSettingsClass());
        goto L55
    L47:
        List r28 = (List) r8.get(r24.getScopeClass());
        if (r28 != null) goto L50;
        r28 = CollectionsKt.emptyList();
    L50:
        r26 = CollectionsKt.sortedWith(r28, new SettingsManageActivity$applySearch$$inlined$sortedBy$2());
        goto L52
    L57:
        ArrayList r0 = new ArrayList();
        Iterator r29 = r7.iterator();
    L59:
        if (r29.hasNext() == false) goto L63;
        Object r30 = r29.next();
        if ((!r110.contains(((SettingsKeyEntry.ChildEntry) r30).getSettingsClass())) == false) goto L59;
        r0.add(r30);
        goto L59
    L63:
        r21.addAll(CollectionsKt.sortedWith(r0, new SettingsManageActivity$applySearch$$inlined$sortedBy$3()));
        getSettingsKeyAdapter().submitList(r21);
        return;
    L14:
        r1 = false;
        goto L15
    L8:
        r13 = null;
        goto L9
    }
}
