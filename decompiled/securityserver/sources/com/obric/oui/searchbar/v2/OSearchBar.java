package com.obric.oui.searchbar.v2;

import android.view.View;
import com.obric.oui.forms.OEditText;
import com.obric.oui.layout.OUIFrameLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OSearchBar extends OUIFrameLayout {
    public static final /* synthetic */ int k = 0;

    /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$2, reason: invalid class name */
    @Metadata
    final class AnonymousClass2 extends Lambda implements Function4<CharSequence, Integer, Integer, Integer, Unit> {
        @Override // kotlin.jvm.functions.Function4
        public final Object invoke(Object r1, Object r2, Object r3, Object r4) {
            CharSequence r5 = (CharSequence) r1;
            ((Number) r2).intValue();
            ((Number) r3).intValue();
            ((Number) r4).intValue();
            int r0 = OSearchBar.k;
            throw null;
        }
    }

    /* JADX INFO: renamed from: com.obric.oui.searchbar.v2.OSearchBar$3, reason: invalid class name */
    @Metadata
    final class AnonymousClass3 extends Lambda implements Function1<Boolean, Unit> {
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object r1) {
            ((Boolean) r1).booleanValue();
            int r0 = OSearchBar.k;
            throw null;
        }
    }

    @Metadata
    public static final class Companion {

        @Metadata
        public static final enum SearchBarState extends Enum<SearchBarState> {
            public static final /* synthetic */ SearchBarState[] b = null;

            static {
                b = new SearchBarState[]{new SearchBarState("RESTING", 0), new SearchBarState("ACTIVE", 1), new SearchBarState("VALUE", 2)};
            }

            public static SearchBarState valueOf(String r1) {
                return (SearchBarState) Enum.valueOf(SearchBarState.class, r1);
            }

            public static SearchBarState[] values() {
                return (SearchBarState[]) b.clone();
            }
        }
    }

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            new int[Companion.SearchBarState.values().length][0] = 1;
            int[] r0 = new int[Companion.SearchBarState.values().length];
            r0[0] = 1;
            r0[1] = 2;
            r0[2] = 3;
        }
    }

    @NotNull
    public final OEditText getInputView() {
        return null;
    }

    @Nullable
    public final View getPostfixView() {
        throw null;
    }

    @Nullable
    public final View getPrefixView() {
        throw null;
    }

    @NotNull
    public final CharSequence getText() {
        throw null;
    }

    public final void setCanShowClear(boolean r1) {
        if (r1 == true) goto L5;
        throw null;
    L5:
        throw null;
    }

    @Override // com.obric.oui.layout.OUIFrameLayout, android.view.View
    public void setEnabled(boolean r1) {
        throw null;
    }

    public final void setOnInputFocusChange(@NotNull View.OnFocusChangeListener r1) {
        Intrinsics.f(r1, "onFocusChangeListener");
        throw null;
    }

    public final void setPostfixView(@Nullable View r1) {
        throw null;
    }

    public final void setPrefixView(@Nullable View r1) {
        throw null;
    }

    public final void setText(@NotNull String r1) {
        Intrinsics.f(r1, "text");
        throw null;
    }
}
