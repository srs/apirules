package com.moowork.apirules.v2;

public interface Violation
{
    public String getMessage();

    public String getClassName();

    public String getSignature();

    public String getSourceName();

    public int getLineNumber();
}
