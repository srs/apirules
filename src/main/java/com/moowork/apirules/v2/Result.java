package com.moowork.apirules.v2;

import java.util.List;

public interface Result
{
    public long getTotalTime();

    public int getScannedClasses();

    public int getScannedSignatures();

    public boolean hasViolations();

    public List<Violation> getViolations();
}
