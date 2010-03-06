package com.mattstine.fluffbox.service.internal;

import com.mattstine.fluffbox.dao.SpeakerDao;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import java.util.Dictionary;
import java.util.Properties;

/**
 * Extension of the default OSGi bundle activator
 */
public final class ServiceActivator
        implements BundleActivator {

    private ServiceTracker daoServiceTracker;

    /**
     * Called whenever the OSGi framework starts our bundle
     */
    public void start(BundleContext bc)
            throws Exception {
        daoServiceTracker = new ServiceTracker(bc, SpeakerDao.class
                .getName(), null);
        daoServiceTracker.open();

        System.out.println("STARTING com.mattstine.fluffbox.test");

        Dictionary props = new Properties();
        // add specific test properties here...

        System.out.println("REGISTER com.mattstine.fluffbox.test.ExampleService");

        // Register our example test implementation in the OSGi test registry
        bc.registerService(SpeakerManager.class.getName(), new SpeakerManagerImpl(daoServiceTracker), props);
    }

    /**
     * Called whenever the OSGi framework stops our bundle
     */
    public void stop(BundleContext bc)
            throws Exception {
        System.out.println("STOPPING com.mattstine.fluffbox.test");
        daoServiceTracker.close();

        // no need to unregister our test - the OSGi framework handles it for us
    }
}

