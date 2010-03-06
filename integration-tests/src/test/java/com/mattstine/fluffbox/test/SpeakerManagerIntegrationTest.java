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

import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

import static org.junit.Assert.*;
import static org.ops4j.pax.exam.CoreOptions.*;

@RunWith(JUnit4TestRunner.class)
public class SpeakerManagerIntegrationTest {

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

    private SpeakerManager retrieveSpeakerManager() throws InterruptedException {
        ServiceTracker tracker = new ServiceTracker(bundleContext,
                SpeakerManager.class.getName(), null);
        tracker.open();
        SpeakerManager speakerManager = (SpeakerManager) tracker.waitForService(5000);
        tracker.close();
        assertNotNull(speakerManager);
        return speakerManager;
    }

    @Test
    public void testBrowse() throws InterruptedException {
        SpeakerManager speakerManager = retrieveSpeakerManager();
        List<Speaker> speakers = speakerManager.browse();

        assertFalse(speakers.isEmpty());
        assertEquals("Stine", speakers.get(0).getLastName());

        System.out.println(speakers);
    }

}
