package com.pagoda.android.asm.privacy.compliance.entity

class MethodCalledBean {
    String methodOwner
    String methodName
    String[] methodDescriptor
    String newMethodOwner
    String newMethodName
    int newOpcode

    HashMap<String, String> newMethodDescriptor


    MethodCalledBean(String methodOwner, String methodName, String[] methodDescriptor) {
        this.methodOwner = methodOwner
        this.methodName = methodName
        this.methodDescriptor = methodDescriptor
    }

    MethodCalledBean(String methodOwner, String methodName, String[] methodDescriptor, String newMethodOwner, String newMethodName, int newOpcode, HashMap<String, String> newMethodDescriptor) {
        this.methodOwner = methodOwner
        this.methodName = methodName
        this.methodDescriptor = methodDescriptor
        this.newMethodOwner = newMethodOwner
        this.newMethodName = newMethodName
        this.newOpcode = newOpcode
        this.newMethodDescriptor = newMethodDescriptor
    }

    @Override
    public String toString() {
        return "MethodCalledBean{" +
            "methodOwner='" + methodOwner + '\'' +
            ", methodName='" + methodName + '\'' +
            ", methodDescriptor=" + Arrays.toString(methodDescriptor) +
            ", newMethodOwner='" + newMethodOwner + '\'' +
            ", newMethodName='" + newMethodName + '\'' +
            ", newOpcode=" + newOpcode +
            ", newMethodDescriptor=" + newMethodDescriptor +
            '}';
    }
}
