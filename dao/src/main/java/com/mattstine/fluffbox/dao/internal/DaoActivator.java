package com.mattstine.fluffbox.dao.internal;

import java.util.Dictionary;
import java.util.Properties;

import com.mattstine.fluffbox.dao.SpeakerDao;
import com.mattstine.fluffbox.dao.KioskDao;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Extension of the default OSGi bundle activator
 */
public final class DaoActivator
    implements BundleActivator
{
    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start( BundleContext bc )
        throws Exception
    {
        System.out.println( "STARTING com.mattstine.fluffbox.dao" );

        Dictionary props = new Properties();
        // add specific test properties here...

        System.out.println( "REGISTER com.mattstine.fluffbox.dao.SpeakerDao" );

        // Register our example test implementation in the OSGi test registry
        bc.registerService( SpeakerDao.class.getName(), new SpeakerDaoImpl(), props );

        System.out.println( "REGISTER com.mattstine.fluffbox.dao.KioskDao" );

        // Register our example test implementation in the OSGi test registry
        bc.registerService( KioskDao.class.getName(), new KioskDaoImpl(), props );
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop( BundleContext bc )
        throws Exception
    {
        System.out.println( "STOPPING com.mattstine.fluffbox.dao" );

        // no need to unregister our test - the OSGi framework handles it for us
    }
}

