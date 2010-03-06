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

import com.mattstine.fluffbox.dao.SpeakerDao;
import com.mattstine.fluffbox.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerDaoImpl implements SpeakerDao {
    public List<Speaker> findAll() {
        List<Speaker> speakers = new ArrayList<Speaker>();
        speakers.add(new Speaker(1L, "Matt", "Stine", "OSGi Head"));
        speakers.add(new Speaker(2L, "Neal", "Ford", "Thoughtworker"));
        speakers.add(new Speaker(3L, "Ken", "Sipe", "All-around cool dude"));
        return speakers;
    }
}
