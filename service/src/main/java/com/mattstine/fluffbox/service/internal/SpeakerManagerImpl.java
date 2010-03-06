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

package com.mattstine.fluffbox.service.internal;

import com.mattstine.fluffbox.dao.SpeakerDao;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.service.SpeakerManager;
import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

public class SpeakerManagerImpl implements SpeakerManager {

    private ServiceTracker daoServiceTracker;

    public SpeakerManagerImpl(ServiceTracker daoServiceTracker) {
        this.daoServiceTracker = daoServiceTracker;
    }

    public List<Speaker> browse() {
        try {
            return ((SpeakerDao) daoServiceTracker.waitForService(10000)).findAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
