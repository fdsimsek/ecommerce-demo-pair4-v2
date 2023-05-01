package com.etiya.ecommercedemopair4.core.utilities.result;

import lombok.Getter;

//Generic => herhangi bir tip olabilir
@Getter
public class DataResult<T> extends Result{

    private T data;

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public DataResult(T data, boolean success, String message) {
        super(success, message);
        this.data = data;
    }
}
