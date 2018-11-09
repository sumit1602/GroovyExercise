package linksharing

//import groovy.util.logging.Commons
import groovy.util.logging.Slf4j

@Slf4j
//@Commons
class UtilController {

    def index() {

//        log.trace(">>>>THIS IS TRACE")
//        log.info(">>>>>>THIS IS INDEX")
//        log.warn(">>>>>>>.THIS IS WARN")
//        log.debug(">>>>>>>.THIS IS TRACE")
        log.error(">>>>>>THIS IS error")
        log.info(params.toQueryString())
        render "THIS IS INFO CONTROLLER"
    }

    def level() {
        log.trace(">>>>THIS IS TRACE")
        log.warn(">>>>>>>.THIS IS WARN")
        log.info(">>>>>>THIS IS INDEX")
        log.error(">>>>>>THIS IS ERROR")
        log.info(params.toQueryString())
        render "THIS IS LEVEL CONTROLLER"

//        ALL 	All levels including custom levels.
//                DEBUG 	Designates fine-grained informational events that are most useful to debug an application.
//                ERROR 	Designates error events that might still allow the application to continue running.
//        FATAL 	Designates very severe error events that will presumably lead the application to abort.
//                INFO 	Designates informational messages that highlight the progress of the application at coarse-grained level.
//        OFF 	The highest possible rank and is intended to turn off logging.
//                TRACE 	Designates finer-grained informational events than the DEBUG.
//        WARN 	Designates potentially harmful situations.

//        A log request of level p in a logger with level q is enabled if p >= q.
//                This rule is at the heart of log4j. It assumes that levels are ordered.
//        For the standard levels, we have ALL < DEBUG < INFO < WARN < ERROR < FATAL < OFF<     TRACE.
    }
}
