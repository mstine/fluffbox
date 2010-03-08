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

package com.mattstine.fluffbox.dao.internal;

import com.mattstine.fluffbox.dao.KioskDao;
import com.mattstine.fluffbox.model.Kiosk;
import com.mattstine.fluffbox.model.Speaker;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: mstine
 * Date: Mar 8, 2010
 * Time: 11:52:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class KioskDaoImpl implements KioskDao {
    public List<Kiosk> findKiosksWhereAvailable(Speaker speaker) {
        List<Kiosk> kiosks = new ArrayList<Kiosk>();
        kiosks.add(new Kiosk(1L, "Kroger (Outside)", "3095 Goodman Road E", "Southaven", "MS", "38672-8707"));
        kiosks.add(new Kiosk(2L, "Walgreens (Outside)", "2996 Church Road E", "Southaven", "MS", "38671-9825"));
        return kiosks;
    }
}
