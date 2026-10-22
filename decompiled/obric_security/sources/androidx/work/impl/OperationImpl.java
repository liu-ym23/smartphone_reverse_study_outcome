package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.Operation;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: loaded from: classes.dex */
public class OperationImpl implements Operation {
    private final SettableFuture<Operation.State.SUCCESS> mOperationFuture;
    private final MutableLiveData<Operation.State> mOperationState;

    public OperationImpl() {
        this.mOperationState = new MutableLiveData();
        this.mOperationFuture = SettableFuture.create();
        markState(Operation.IN_PROGRESS);
    }

    @Override // androidx.work.Operation
    public ListenableFuture<Operation.State.SUCCESS> getResult() {
        return this.mOperationFuture;
    }

    @Override // androidx.work.Operation
    public LiveData<Operation.State> getState() {
        return this.mOperationState;
    }

    public void markState(Operation.State state) {
        this.mOperationState.postValue(state);
        if ((state instanceof Operation.State.SUCCESS) == false) goto L6;
        this.mOperationFuture.set((Operation.State.SUCCESS) state);
        return;
    L6:
        if ((state instanceof Operation.State.FAILURE) == false) goto L10;
        this.mOperationFuture.setException(((Operation.State.FAILURE) state).getThrowable());
        return;
    }
}
