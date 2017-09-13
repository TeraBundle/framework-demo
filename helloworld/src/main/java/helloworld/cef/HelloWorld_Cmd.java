/*
 * © 2016. All Rights Reserved.
 * TeraBundle Anlytics Pvt. Ltd. http://www.terabundle.com
 * For copyright queries, contact the Founder, Susanta Tewari at tewaris@terabundle.com.
 */
package helloworld.cef;

import cef.command.Command;
import cef.command.CommandException;

/**
 * @since since
 * @version version
 * @author Avrajit Saha
 * @history Created on 9/24/2015.
 */
public class HelloWorld_Cmd extends Command<HelloWorld_Evt>{

    private String name;

    public HelloWorld_Cmd(final HelloWorld_Evt event) {
        super(event);
    }

    @Override
    public void executeImpl() throws CommandException {

        name = getEvent().getName();
    }

    public String getName() {

        checkCmdFinished();

        return name;
    }
}
