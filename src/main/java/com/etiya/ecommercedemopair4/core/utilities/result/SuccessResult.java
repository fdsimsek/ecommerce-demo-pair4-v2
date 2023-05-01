package com.etiya.ecommercedemopair4.core.utilities.result;

public class SuccessResult extends  Result{
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
