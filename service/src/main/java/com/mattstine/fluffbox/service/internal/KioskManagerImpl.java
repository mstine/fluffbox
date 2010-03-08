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

import com.mattstine.fluffbox.service.KioskManager;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Speaker;
import com.mattstine.fluffbox.dao.KioskDao;

import java.util.List;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Mar 8, 2010
 * Time: 11:57:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class KioskManagerImpl implements KioskManager {

    private ServiceTracker daoServiceTracker;

    public KioskManagerImpl(ServiceTracker daoServiceTracker) {
        this.daoServiceTracker = daoServiceTracker;
    }

    public List<Kiosk> findKiosksWhereAvailable(Speaker speaker) {
        try {
            return ((KioskDao) daoServiceTracker.waitForService(10000)).findKiosksWhereAvailable(speaker);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
