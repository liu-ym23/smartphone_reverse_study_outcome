package com.android.settingslib.view.accessibility.data.repository;

import android.icu.text.PluralRules;
import android.view.accessibility.CaptioningManager;
import com.android.settings.search.IndexDatabaseHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CaptioningRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0015\u0016B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepository;", "captioningManager", "Landroid/view/accessibility/CaptioningManager;", "backgroundCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/view/accessibility/CaptioningManager;Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/CoroutineScope;)V", "captioningChanges", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange;", "isSystemAudioCaptioningEnabled", "Lkotlinx/coroutines/flow/StateFlow;", "", "()Lkotlinx/coroutines/flow/StateFlow;", "isSystemAudioCaptioningUiEnabled", "setIsSystemAudioCaptioningEnabled", "", "isEnabled", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "CaptioningChange", "CaptioningChangeProducingListener", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CaptioningRepositoryImpl implements CaptioningRepository {
    private final CoroutineContext backgroundCoroutineContext;
    private final SharedFlow<CaptioningChange> captioningChanges;
    private final CaptioningManager captioningManager;
    private final StateFlow<Boolean> isSystemAudioCaptioningEnabled;
    private final StateFlow<Boolean> isSystemAudioCaptioningUiEnabled;

    /* JADX INFO: compiled from: CaptioningRepository.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange;", "", "IsSystemAudioCaptioningEnabled", "IsSystemUICaptioningEnabled", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange$IsSystemAudioCaptioningEnabled;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange$IsSystemUICaptioningEnabled;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface CaptioningChange {

        /* JADX INFO: compiled from: CaptioningRepository.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange$IsSystemAudioCaptioningEnabled;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange;", "isEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class IsSystemAudioCaptioningEnabled implements CaptioningChange {
            private final boolean isEnabled;

            public static /* synthetic */ IsSystemAudioCaptioningEnabled copy$default(IsSystemAudioCaptioningEnabled r0, boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.isEnabled;
            L6:
                return r0.copy(r1);
            }

            public final boolean component1() {
                return this.isEnabled;
            }

            public final IsSystemAudioCaptioningEnabled copy(boolean r1) {
                return new IsSystemAudioCaptioningEnabled(r1);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof IsSystemAudioCaptioningEnabled) == true) goto L9;
                return false;
            L9:
                if (this.isEnabled == ((IsSystemAudioCaptioningEnabled) r4).isEnabled) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                boolean r0 = this.isEnabled;
                if (r0 == false) goto L6;
                return 1;
            L6:
                return r0 ? 1 : 0;
            }

            public String toString() {
                return "IsSystemAudioCaptioningEnabled(isEnabled=" + this.isEnabled + ')';
            }

            public IsSystemAudioCaptioningEnabled(boolean r1) {
                this.isEnabled = r1;
            }

            public final boolean isEnabled() {
                return this.isEnabled;
            }
        }

        /* JADX INFO: compiled from: CaptioningRepository.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u000f"}, d2 = {"Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange$IsSystemUICaptioningEnabled;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange;", "isEnabled", "", "(Z)V", "()Z", "component1", "copy", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "toString", "", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class IsSystemUICaptioningEnabled implements CaptioningChange {
            private final boolean isEnabled;

            public static /* synthetic */ IsSystemUICaptioningEnabled copy$default(IsSystemUICaptioningEnabled r0, boolean r1, int r2, Object r3) {
                if ((r2 & 1) == 0) goto L6;
                r1 = r0.isEnabled;
            L6:
                return r0.copy(r1);
            }

            public final boolean component1() {
                return this.isEnabled;
            }

            public final IsSystemUICaptioningEnabled copy(boolean r1) {
                return new IsSystemUICaptioningEnabled(r1);
            }

            public boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof IsSystemUICaptioningEnabled) == true) goto L9;
                return false;
            L9:
                if (this.isEnabled == ((IsSystemUICaptioningEnabled) r4).isEnabled) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                boolean r0 = this.isEnabled;
                if (r0 == false) goto L6;
                return 1;
            L6:
                return r0 ? 1 : 0;
            }

            public String toString() {
                return "IsSystemUICaptioningEnabled(isEnabled=" + this.isEnabled + ')';
            }

            public IsSystemUICaptioningEnabled(boolean r1) {
                this.isEnabled = r1;
            }

            public final boolean isEnabled() {
                return this.isEnabled;
            }
        }
    }

    /* JADX INFO: compiled from: CaptioningRepository.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChangeProducingListener;", "Landroid/view/accessibility/CaptioningManager$CaptioningChangeListener;", "scope", "Lkotlinx/coroutines/channels/ProducerScope;", "Lcom/android/settingslib/view/accessibility/data/repository/CaptioningRepositoryImpl$CaptioningChange;", "(Lkotlinx/coroutines/channels/ProducerScope;)V", "emitChange", "", "change", "onSystemAudioCaptioningChanged", IndexDatabaseHelper.IndexColumns.ENABLED, "", "onSystemAudioCaptioningUiChanged", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class CaptioningChangeProducingListener extends CaptioningManager.CaptioningChangeListener {
        private final ProducerScope<CaptioningChange> scope;

        public static final /* synthetic */ ProducerScope access$getScope$p(CaptioningChangeProducingListener r0) {
            return r0.scope;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public CaptioningChangeProducingListener(ProducerScope<? super CaptioningChange> r2) {
            Intrinsics.checkNotNullParameter(r2, "scope");
            this.scope = r2;
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onSystemAudioCaptioningChanged(boolean r2) {
            emitChange(new CaptioningChange.IsSystemAudioCaptioningEnabled(r2));
        }

        @Override // android.view.accessibility.CaptioningManager.CaptioningChangeListener
        public void onSystemAudioCaptioningUiChanged(boolean r2) {
            emitChange(new CaptioningChange.IsSystemUICaptioningEnabled(r2));
        }

        private final void emitChange(CaptioningChange r8) {
            BuildersKt.launch$default(this.scope, null, null, new CaptioningRepositoryImpl$CaptioningChangeProducingListener$emitChange$1(this, r8, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$isSystemAudioCaptioningEnabled$2, reason: invalid class name */
    /* JADX INFO: compiled from: CaptioningRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$isSystemAudioCaptioningEnabled$2", f = "CaptioningRepository.kt", i = {}, l = {66}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CaptioningRepositoryImpl this$0;

        AnonymousClass2(CaptioningRepositoryImpl r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(Boxing.boxBoolean(CaptioningRepositoryImpl.access$getCaptioningManager$p(this.this$0).isSystemAudioCaptioningEnabled()), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$isSystemAudioCaptioningUiEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptioningRepository.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$isSystemAudioCaptioningUiEnabled$2", f = "CaptioningRepository.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    static final class C01652 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ CaptioningRepositoryImpl this$0;

        C01652(CaptioningRepositoryImpl r1, Continuation<? super C01652> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            C01652 r0 = new C01652(this.this$0, r3);
            r0.L$0 = r2;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Boolean> r1, Continuation<? super Unit> r2) {
            return ((C01652) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            this.label = 1;
            if (((FlowCollector) this.L$0).emit(Boxing.boxBoolean(CaptioningRepositoryImpl.access$getCaptioningManager$p(this.this$0).isSystemAudioCaptioningUiEnabled()), this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$setIsSystemAudioCaptioningEnabled$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CaptioningRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.android.settingslib.view.accessibility.data.repository.CaptioningRepositoryImpl$setIsSystemAudioCaptioningEnabled$2", f = "CaptioningRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C01662 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ CaptioningRepositoryImpl this$0;

        C01662(CaptioningRepositoryImpl r1, boolean r2, Continuation<? super C01662> r3) {
            this.this$0 = r1;
            this.$isEnabled = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C01662(this.this$0, this.$isEnabled, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C01662) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            CaptioningRepositoryImpl.access$getCaptioningManager$p(this.this$0).setSystemAudioCaptioningEnabled(this.$isEnabled);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public CaptioningRepositoryImpl(CaptioningManager r10, CoroutineContext r11, CoroutineScope r12) {
        Intrinsics.checkNotNullParameter(r10, "captioningManager");
        Intrinsics.checkNotNullParameter(r11, "backgroundCoroutineContext");
        Intrinsics.checkNotNullParameter(r12, "coroutineScope");
        this.captioningManager = r10;
        this.backgroundCoroutineContext = r11;
        SharedFlow<CaptioningChange> r13 = FlowKt.shareIn(FlowKt.callbackFlow(new CaptioningRepositoryImpl$captioningChanges$1(this, null)), r12, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), 0);
        this.captioningChanges = r13;
        final Flow r1 = FlowKt.filterIsInstance(r13, Reflection.getOrCreateKotlinClass(CaptioningChange.IsSystemAudioCaptioningEnabled.class));
        this.isSystemAudioCaptioningEnabled = FlowKt.stateIn(FlowKt.onStart(new CaptioningRepositoryImpl$special$$inlined$map$1(r1), new AnonymousClass2(this, null)), r12, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), Boolean.valueOf(r10.isSystemAudioCaptioningEnabled()));
        final Flow r14 = FlowKt.filterIsInstance(r13, Reflection.getOrCreateKotlinClass(CaptioningChange.IsSystemUICaptioningEnabled.class));
        this.isSystemAudioCaptioningUiEnabled = FlowKt.stateIn(FlowKt.onStart(new CaptioningRepositoryImpl$special$$inlined$map$2(r14), new C01652(this, null)), r12, SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 0, 0, 3, null), Boolean.valueOf(r10.isSystemAudioCaptioningUiEnabled()));
    }

    public static final /* synthetic */ CaptioningManager access$getCaptioningManager$p(CaptioningRepositoryImpl r0) {
        return r0.captioningManager;
    }

    @Override // com.android.settingslib.view.accessibility.data.repository.CaptioningRepository
    public StateFlow<Boolean> isSystemAudioCaptioningEnabled() {
        return this.isSystemAudioCaptioningEnabled;
    }

    @Override // com.android.settingslib.view.accessibility.data.repository.CaptioningRepository
    public StateFlow<Boolean> isSystemAudioCaptioningUiEnabled() {
        return this.isSystemAudioCaptioningUiEnabled;
    }

    @Override // com.android.settingslib.view.accessibility.data.repository.CaptioningRepository
    public Object setIsSystemAudioCaptioningEnabled(boolean r4, Continuation<? super Unit> r5) {
        Object r3 = BuildersKt.withContext(this.backgroundCoroutineContext, new C01662(this, r4, null), r5);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Unit.INSTANCE;
    }
}
