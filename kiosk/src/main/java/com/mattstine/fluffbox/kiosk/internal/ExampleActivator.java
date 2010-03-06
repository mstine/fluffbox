package com.mattstine.fluffbox.kiosk.internal;

import java.util.Dictionary;
import java.util.Properties;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.mattstine.fluffbox.kiosk.ExampleService;

/**
 * Extension of the default OSGi bundle activator
 */
public final class ExampleActivator
    implements BundleActivator
{
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext bc )
        throws Exception
    {
        System.out.println( "STARTING com.mattstine.fluffbox.kiosk" );

        Dictionary props = new Properties();
        // add specific test properties here...

        System.out.println( "REGISTER com.mattstine.fluffbox.kiosk.ExampleService" );

        // Register our example test implementation in the OSGi test registry
        bc.registerService( ExampleService.class.getName(), new ExampleServiceImpl(), props );
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext bc )
        throws Exception
    {
        System.out.println( "STOPPING com.mattstine.fluffbox.kiosk" );

        // no need to unregister our test - the OSGi framework handles it for us
    }
}

