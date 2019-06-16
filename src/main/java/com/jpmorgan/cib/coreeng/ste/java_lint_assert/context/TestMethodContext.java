package com.jpmorgan.cib.coreeng.ste.java_lint_assert.context;

import org.javatuples.Pair;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class TestMethodContext {

    String fileName;
    String methodName;
    String methodSignature;
    String methodDescriptor;
    boolean visible;

    Collection<Pair<Integer, String>> assertMethodsAtLineNumbers;

    public TestMethodContext() {
        this.assertMethodsAtLineNumbers = new LinkedList<>();
    }

    public TestMethodContext(String methodName, String descriptor) {
        this();
        this.methodName = methodName;
        this.methodDescriptor = descriptor;
    }

    public TestMethodContext(TestMethodContext source) {
        this.fileName = source.fileName;
        this.methodName = source.methodName;
        this.methodDescriptor = source.methodDescriptor;
        this.methodSignature = source.methodSignature;
        this.visible = source.visible;
        this.assertMethodsAtLineNumbers = new LinkedList<>(source.assertMethodsAtLineNumbers);
    }

    public void resetMethodDetails() {
        this.methodName = "";
        this.methodSignature = "";
        this.methodDescriptor = "";
        this.visible = false;
    }

    public void resetClassDetails() {
        this.fileName = "";
    }

    public String getMethodName() {
        return this.methodName;
    }

    public Collection<Pair<Integer, String>> getAssertMethodsAtLineNumbers() {
        return this.assertMethodsAtLineNumbers;
    }

    public String getFileName() {
        return this.fileName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestMethodContext that = (TestMethodContext) o;
        return Objects.equals(methodName, that.methodName) &&
                Objects.equals(methodDescriptor, that.methodDescriptor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, methodDescriptor);
    }

    @Override
    public String toString() {
        return "TestMethodContext{" +
                "fileName='" + fileName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", methodSignature='" + methodSignature + '\'' +
                ", methodDescriptor='" + methodDescriptor + '\'' +
                ", visible=" + visible +
                ", assertMethodsAtLineNumbers=" + assertMethodsAtLineNumbers +
                '}';
    }

}