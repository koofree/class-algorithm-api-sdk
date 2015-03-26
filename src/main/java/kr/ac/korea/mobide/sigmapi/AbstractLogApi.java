package kr.ac.korea.mobide.sigmapi;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Koo Lee on 3/24/2015.
 */
public abstract class AbstractLogApi {
    protected static Log log = LogFactory.getLog(AbstractLogApi.class);

    public static boolean view_log = false;

    protected static void log(String log) {
        if (view_log) {
            AbstractLogApi.log.debug(log);
        }
    }

    public static void setLog(boolean view_log) {
        Sigmapi.view_log = view_log;
    }
}
