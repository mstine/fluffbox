/*
 * Copyright (c) 2010 Matt Stine
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.mattstine.fluffbox.test;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.ops4j.pax.exam.CoreOptions.*;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import com.mattstine.fluffbox.service.KioskManager;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Speaker;

import java.util.List;

@RunWith(JUnit4TestRunner.class)
public class KioskManagerIntegrationTest {

    @Inject
    private BundleContext bundleContext;

    @Configuration
    public static Option[] configuration() {
        return options(equinox(), provision(

                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("model"),
                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("dao"),
                mavenBundle().groupId("com.mattstine.fluffbox").artifactId("service")
        ));
    }

    private KioskManager retrieveKioskManager() throws InterruptedException {
        ServiceTracker tracker = new ServiceTracker(bundleContext,
                KioskManager.class.getName(), null);
        tracker.open();
        KioskManager kioskManager = (KioskManager) tracker.waitForService(5000);
        tracker.close();
        assertNotNull(kioskManager);
        return kioskManager;
    }

    @Test
    public void testFindKiosksWhereSpeakersAvailable() throws InterruptedException {
        KioskManager kioskManager = retrieveKioskManager();
        List<Kiosk> kiosks = kioskManager.findKiosksWhereAvailable(new Speaker(1L, "Matt", "Stine", "OSGi Head", "/images/matt_stine.jpg"));
        assertFalse(kiosks.isEmpty());
        assertEquals("Kroger (Outside)", kiosks.get(0).getBusinessName());
    }
}
