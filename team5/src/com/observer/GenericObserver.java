package com.observer;

public interface GenericObserver<T> {

	public void update(T ...data);

}
