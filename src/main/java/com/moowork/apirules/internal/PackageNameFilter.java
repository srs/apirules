package com.moowork.apirules.internal;

import com.google.common.base.Predicate;
import com.google.common.reflect.ClassPath;

final class PackageNameFilter
    implements Predicate<ClassPath.ClassInfo>
{
    private final String[] scanPackages;

    public PackageNameFilter( final String... scanPackages )
    {
        this.scanPackages = scanPackages;
    }

    @Override
    public boolean apply( final ClassPath.ClassInfo input )
    {
        for ( final String scanPackage : this.scanPackages )
        {
            if ( input.getPackageName().startsWith( scanPackage ) )
            {
                return true;
            }
        }

        return false;
    }
}
