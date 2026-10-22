package com.obric.security.cleaner.bigfile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.obric.security.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: BigFileViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u001b\u001a\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bJ\u0006\u0010\f\u001a\u00020\u001cJ\u001e\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#J&\u0010$\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020#J&\u0010)\u001a\u00020\u001c2\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010*\u001a\u00020\nJ\u0016\u0010+\u001a\u00020\u001c2\u0006\u0010*\u001a\u00020\n2\u0006\u0010,\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R'\u0010\u0007\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR6\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0\u0012j\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f`\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\r¨\u0006-"}, d2 = {"Lcom/obric/security/cleaner/bigfile/BigFileViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "ScanBigFileTrashTask", "Lcom/obric/security/cleaner/bigfile/ScanBigFileTrashTask;", "getScanBigFileTrashTask", "()Lcom/obric/security/cleaner/bigfile/ScanBigFileTrashTask;", "bigFileList", "Landroidx/lifecycle/MutableLiveData;", "Ljava/util/ArrayList;", "Lcom/obric/security/cleaner/bigfile/BigFileScanResultItem;", "Lkotlin/collections/ArrayList;", "getBigFileList", "()Landroidx/lifecycle/MutableLiveData;", "selectedChange", "", "getSelectedChange", "selectedItem", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSelectedItem", "()Ljava/util/HashMap;", "setSelectedItem", "(Ljava/util/HashMap;)V", "startLoading", "getStartLoading", "deleteFiles", "", "bigFileScanResultItems", "loadAppIconFromApk", "context", "Landroid/content/Context;", "apkPath", "iconView", "Landroid/widget/ImageView;", "loadMusicThumbnail", "path", "placeholder", "", "imageView", "safeDeleteFile", "bigFileScanResultItem", "updateSelectedItem", "isSelected", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class BigFileViewModel extends ViewModel {
    private final ScanBigFileTrashTask ScanBigFileTrashTask;
    private final MutableLiveData<ArrayList<BigFileScanResultItem>> bigFileList;
    private final MutableLiveData<Boolean> selectedChange;
    private HashMap<String, Boolean> selectedItem;
    private final MutableLiveData<Boolean> startLoading;

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$deleteFiles$1, reason: invalid class name */
    /* JADX INFO: compiled from: BigFileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$deleteFiles$1", f = "BigFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList $bigFileScanResultItems;
        int label;
        final /* synthetic */ BigFileViewModel this$0;

        AnonymousClass1(BigFileViewModel r1, ArrayList r2, Continuation r3) {
            this.this$0 = r1;
            this.$bigFileScanResultItems = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass1(this.this$0, this.$bigFileScanResultItems, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r5);
            ArrayList<BigFileScanResultItem> r6 = new ArrayList();
            Iterator r0 = this.$bigFileScanResultItems.iterator();
        L6:
            if (r0.hasNext() == false) goto L15;
            BigFileScanResultItem r1 = (BigFileScanResultItem) r0.next();
            if (Intrinsics.areEqual(this.this$0.getSelectedItem().get(r1.mPath), Boxing.boxBoolean(true)) == true) goto L9;
            r6.add(r1);
            goto L6
        L9:
            File r2 = new File(r1.mPath);
            if (r2.exists() == false) goto L6;
            if (r2.isFile() == false) goto L6;
            r2.delete();
            goto L6
        L15:
            this.this$0.getBigFileList().postValue(r6);
            return Unit.INSTANCE;
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$getBigFileList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BigFileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$getBigFileList$1", f = "BigFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BigFileViewModel this$0;

        C03611(BigFileViewModel r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            Intrinsics.checkNotNullParameter(r2, "completion");
            return new C03611(this.this$0, r2);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03611) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L13;
            ResultKt.throwOnFailure(r5);
            ArrayList<BigFileScanResultItem> r6 = this.this$0.getScanBigFileTrashTask().findBigFiles();
            Intrinsics.checkNotNullExpressionValue(r6, "bigFiles");
            Iterator<T> r0 = r6.iterator();
        L6:
            if (r0.hasNext() == false) goto L10;
            BigFileScanResultItem r1 = (BigFileScanResultItem) r0.next();
            if (this.this$0.getSelectedItem().containsKey(r1.mPath) == true) goto L6;
            HashMap<String, Boolean> r2 = this.this$0.getSelectedItem();
            String r3 = r1.mPath;
            Intrinsics.checkNotNullExpressionValue(r3, "it.mPath");
            r2.put(r3, Boxing.boxBoolean(true));
            goto L6
        L10:
            this.this$0.getBigFileList().postValue(r6);
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$loadAppIconFromApk$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BigFileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$loadAppIconFromApk$1", f = "BigFileViewModel.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    static final class C03621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apkPath;
        final /* synthetic */ ImageView $iconView;
        int label;

        /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$loadAppIconFromApk$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BigFileViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$loadAppIconFromApk$1$1", f = "BigFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $drawable;
            int label;
            final /* synthetic */ C03621 this$0;

            C00551(C03621 r1, Ref.ObjectRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$drawable = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00551(this.this$0, this.$drawable, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00551) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                this.this$0.$iconView.setImageDrawable((Drawable) this.$drawable.element);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C03621(String r1, ImageView r2, Continuation r3) {
            this.$apkPath = r1;
            this.$iconView = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new C03621(this.$apkPath, this.$iconView, r3);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03621) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, android.graphics.drawable.Drawable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Ref.ObjectRef r7 = new Ref.ObjectRef();
            r7.element = ImageLoadHelper.INSTANCE.getAppIconFromApk(this.$apkPath);
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00551 r3 = new C00551(this, r7, null);
            this.label = 1;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$loadMusicThumbnail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BigFileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$loadMusicThumbnail$1", f = "BigFileViewModel.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {})
    static final class C03631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ ImageView $imageView;
        final /* synthetic */ String $path;
        int label;

        /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$loadMusicThumbnail$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BigFileViewModel.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$loadMusicThumbnail$1$1", f = "BigFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef $imageData;
            int label;
            final /* synthetic */ C03631 this$0;

            C00561(C03631 r1, Ref.ObjectRef r2, Continuation r3) {
                this.this$0 = r1;
                this.$imageData = r2;
                super(2, r3);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                Intrinsics.checkNotNullParameter(r3, "completion");
                return new C00561(this.this$0, this.$imageData, r3);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return ((C00561) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r4) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L10;
                ResultKt.throwOnFailure(r4);
                if (((byte[]) this.$imageData.element) == null) goto L8;
                ImageLoadHelper.INSTANCE.loadImageFromBytes(this.this$0.$context, (byte[]) this.$imageData.element, this.this$0.$imageView, 12);
            L8:
                return Unit.INSTANCE;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C03631(String r1, Context r2, ImageView r3, Continuation r4) {
            this.$path = r1;
            this.$context = r2;
            this.$imageView = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C03631(this.$path, this.$context, this.$imageView, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03631) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r1v2, types: [T, byte[]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r6) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r6);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r6);
            Ref.ObjectRef r7 = new Ref.ObjectRef();
            r7.element = ImageLoadHelper.INSTANCE.loadMusicThumbnail(this.$path);
            MainCoroutineDispatcher r2 = Dispatchers.getMain();
            C00561 r3 = new C00561(this, r7, null);
            this.label = 1;
            if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.security.cleaner.bigfile.BigFileViewModel$safeDeleteFile$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BigFileViewModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.obric.security.cleaner.bigfile.BigFileViewModel$safeDeleteFile$1", f = "BigFileViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C03641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BigFileScanResultItem $bigFileScanResultItem;
        final /* synthetic */ ArrayList $bigFileScanResultItems;
        int label;
        final /* synthetic */ BigFileViewModel this$0;

        C03641(BigFileViewModel r1, BigFileScanResultItem r2, ArrayList r3, Continuation r4) {
            this.this$0 = r1;
            this.$bigFileScanResultItem = r2;
            this.$bigFileScanResultItems = r3;
            super(2, r4);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new C03641(this.this$0, this.$bigFileScanResultItem, this.$bigFileScanResultItems, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((C03641) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r5) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L18;
            ResultKt.throwOnFailure(r5);
            File r6 = new File(this.$bigFileScanResultItem.mPath);
            if (r6.exists() == true) goto L7;
        L9:
            ArrayList<BigFileScanResultItem> r7 = new ArrayList();
            Iterator r0 = this.$bigFileScanResultItems.iterator();
        L11:
            if (r0.hasNext() == false) goto L15;
            BigFileScanResultItem r1 = (BigFileScanResultItem) r0.next();
            if ((!Intrinsics.areEqual(r1.mPath, this.$bigFileScanResultItem.mPath)) == false) goto L11;
            r7.add(r1);
            goto L11
        L15:
            this.this$0.getBigFileList().postValue(r7);
            return Unit.INSTANCE;
        L7:
            if (r6.isFile() == false) goto L9;
            r6.delete();
            goto L9
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public BigFileViewModel() {
        this.ScanBigFileTrashTask = new ScanBigFileTrashTask();
        this.bigFileList = new MutableLiveData();
        this.selectedItem = new HashMap();
        this.startLoading = new MutableLiveData();
        this.selectedChange = new MutableLiveData();
    }

    public final ScanBigFileTrashTask getScanBigFileTrashTask() {
        return this.ScanBigFileTrashTask;
    }

    public final MutableLiveData<ArrayList<BigFileScanResultItem>> getBigFileList() {
        return this.bigFileList;
    }

    public final HashMap<String, Boolean> getSelectedItem() {
        return this.selectedItem;
    }

    public final void setSelectedItem(HashMap<String, Boolean> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.selectedItem = r2;
    }

    public final MutableLiveData<Boolean> getStartLoading() {
        return this.startLoading;
    }

    public final MutableLiveData<Boolean> getSelectedChange() {
        return this.selectedChange;
    }

    /* JADX INFO: renamed from: getBigFileList, reason: collision with other method in class */
    public final void m604getBigFileList() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03611(this, null), 2, null);
    }

    public final void updateSelectedItem(BigFileScanResultItem r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "bigFileScanResultItem");
        HashMap<String, Boolean> r0 = this.selectedItem;
        String r5 = r3.mPath;
        Intrinsics.checkNotNullExpressionValue(r5, "bigFileScanResultItem.mPath");
        r0.put(r5, Boolean.valueOf(r4));
        this.selectedChange.postValue(true);
    }

    public final void deleteFiles(ArrayList<BigFileScanResultItem> r8) {
        Intrinsics.checkNotNullParameter(r8, "bigFileScanResultItems");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, r8, null), 2, null);
    }

    public final void safeDeleteFile(ArrayList<BigFileScanResultItem> r9, BigFileScanResultItem r10) {
        Intrinsics.checkNotNullParameter(r9, "bigFileScanResultItems");
        Intrinsics.checkNotNullParameter(r10, "bigFileScanResultItem");
        this.startLoading.setValue(true);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03641(this, r10, r9, null), 2, null);
    }

    public final void loadMusicThumbnail(Context r9, String r10, int r11, ImageView r12) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r12, "imageView");
        ImageLoadHelper.INSTANCE.loadLocalResourceImage(r9, r11, r12, 12);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03631(r10, r9, r12, null), 2, null);
    }

    public final void loadAppIconFromApk(Context r9, String r10, ImageView r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "apkPath");
        Intrinsics.checkNotNullParameter(r11, "iconView");
        ImageLoadHelper.INSTANCE.loadLocalResourceImage(r9, R.drawable.file_apk, r11);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C03621(r10, r11, null), 2, null);
    }
}
