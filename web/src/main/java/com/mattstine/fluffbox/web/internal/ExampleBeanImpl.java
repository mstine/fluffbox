package com.mattstine.fluffbox.web.internal;

import com.mattstine.fluffbox.web.ExampleBean;

/**
 * Internal implementation of our example Spring Bean
 */
public class ExampleBeanImpl
    implements ExampleBean
{
    public boolean isABean()
    {
        return true;
    }
}
