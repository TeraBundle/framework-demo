/*
 * © 2016. All Rights Reserved.
 * TeraBundle Anlytics Pvt. Ltd. http://www.terabundle.com
 * For copyright queries, contact the Founder, Susanta Tewari at tewaris@terabundle.com.
 */
package helloworld.cef.pui;

import cef.event.Event;
import cef.pui.EventConstructionException;
import cef.pui.EventImpl;
import helloworld.cef.HelloWorld_Evt;
import cef.pui.pob.Builder;
import cef.pui.pob.BuilderException;
import cef.pui.pob.Builders;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @since since
 * @version version
 * @author Avrajit Saha
 * @history Created on 9/24/2015.
 */
public final class HelloWorld_EvtImpl extends EventImpl implements HelloWorld_Evt {


    private Builder<String> nameBuilder;

    public HelloWorld_EvtImpl(final Properties props) throws EventConstructionException {

        super(props);

        super.processEventProperties(getImplementedEventInterfaces());

        String prefix    = "helloworld.builder.String";
        String propName  = "name";

        nameBuilder      = Builders.of_String(props, propName, prefix);
    }

    @Override
    protected List<Class<? extends Event>> getImplementedEventInterfaces() {

        final List<Class<? extends Event>> result = new ArrayList<>(2);

        result.add(HelloWorld_Evt.class);
        result.add(Event.class);

        return result;
    }


    @Override
    public String getName() throws BuilderException {
        return nameBuilder.build();
    }

}
