
/*
* � 2016. All Rights Reserved.
* TeraBundle Anlytics Pvt. Ltd. http://www.terabundle.com
* For copyright queries, contact the Founder, Susanta Tewari at tewaris@terabundle.com.
 */
package helloworld.cef.listener;

import cef.command.Command;
import cef.command.listener.CommandOutputEvent;
import cef.command.listener.CommandOutputListener;
import cef.command.listener.CommandOutputListenerException;
import cef.command.listener.CommandPrintWriter;
import helloworld.cef.HelloWorld_Cmd;

/**
 * @since since
 * @version version
 * @author Avrajit Saha
 * @history Created on 9/24/2015.
 */
public class HelloWorldCommandListener extends CommandPrintWriter {

    @Override
    public void receivedEventImpl(final CommandOutputEvent cmdEvent) throws CommandOutputListenerException {

        if (cmdEvent.getSource() instanceof HelloWorld_Cmd) {

            final HelloWorld_Cmd command = (HelloWorld_Cmd) cmdEvent.getSource();

            final String name            = command.getName();

            receivedData = new Object[]{name};

            if(!cmdEvent.hasProxy()) receivedEventDo(receivedData);
        }
    }

    @Override
    public void receivedEventDo(Object[] data) {

        getPrintWriter().println("Hello " + data[0] + ". Welcome to Earth.");
        getPrintWriter().flush();
    }

    @Override
    public Class<? extends Command> getTargetCommandClass() {
        return HelloWorld_Cmd.class;
    }

    @Override
    public CommandOutputListener newInstance() {
        return new HelloWorldCommandListener();
    }
}
