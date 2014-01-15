package com.moowork.apirules.v2.impl;

import java.util.List;

import com.moowork.apirules.v2.Result;
import com.moowork.apirules.v2.Violation;

final class ResultImpl
    implements Result
{
    @Override
    public long getTotalTime()
    {
        return 0;
    }

    @Override
    public int getScannedClasses()
    {
        return 0;
    }

    @Override
    public int getScannedSignatures()
    {
        return 0;
    }

    @Override
    public boolean hasViolations()
    {
        return false;
    }

    @Override
    public List<Violation> getViolations()
    {
        return null;
    }
}
