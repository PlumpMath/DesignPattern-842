package fr.istic.m2miage.aoc.dp.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Handles logging and invocation of target method
 */
public class LoggingHandler implements InvocationHandler {
	protected Object actual;

	public LoggingHandler(Object actual) {
		this.actual = actual;
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		try {
			System.out.println(">>>>>>start executing method: " + method.getName());
			Object result = method.invoke(actual, args);
			return result;
		} catch (InvocationTargetException ite) {
			throw new RuntimeException(ite.getMessage());
		} finally {
			System.out.println("<<<<<<finished executing method: " + method.getName());
		}
	}
}