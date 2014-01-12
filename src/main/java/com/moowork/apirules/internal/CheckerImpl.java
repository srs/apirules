package com.moowork.apirules.internal;

import java.util.Collection;

import org.objectweb.asm.ClassReader;

import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.ClassPath;
import com.moowork.apirules.Checker;
import com.moowork.apirules.Violations;
import com.moowork.apirules.validator.NopValidator;
import com.moowork.apirules.validator.SignatureValidator;

public final class CheckerImpl
    extends Checker
{
    private ClassPath classPath;

    private String[] includePackages;

    private String[] excludePackages;

    private SignatureValidator validator;

    private Collection<ClassPath.ClassInfo> classes;

    public CheckerImpl()
    {
        this.validator = new NopValidator();
        this.includePackages = new String[0];
        this.excludePackages = new String[0];
    }

    @Override
    public Checker classPath( final ClassLoader classLoader )
    {
        try
        {
            this.classPath = ClassPath.from( classLoader );
            return this;
        }
        catch ( final Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    @Override
    public Checker includePackages( final String... packageNames )
    {
        this.includePackages = packageNames;
        return this;
    }

    @Override
    public Checker excludePackages( final String... packageNames )
    {
        this.excludePackages = packageNames;
        return this;
    }

    @Override
    public Checker validator( final SignatureValidator validator )
    {
        this.validator = validator;
        return this;
    }

    @Override
    public Violations check()
    {
        locateClasses();

        try
        {
            return validateAll();
        }
        catch ( final Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    private void locateClasses()
    {
        if ( this.classPath == null )
        {
            this.classes = ImmutableList.of();
            return;
        }

        this.classes = this.classPath.getTopLevelClasses();
        this.classes = Collections2.filter( this.classes, new PackageNameFilter( this.includePackages ) );
        this.classes = Collections2.filter( this.classes, Predicates.not( new PackageNameFilter( this.excludePackages ) ) );
    }

    private Violations validateAll()
        throws Exception
    {
        for ( final ClassPath.ClassInfo info : this.classes )
        {
            // validate( validator, info );
        }

        return null;
    }

    private void validate( final ClassPath.ClassInfo classInfo )
        throws Exception
    {
        final byte[] data = Resources.toByteArray( classInfo.url() );
        final ClassReader reader = new ClassReader( data );

        final ClassVisitorImpl visitor = new ClassVisitorImpl( classInfo.getName(), this.validator );
        reader.accept( visitor, ClassReader.SKIP_FRAMES );
    }
}
