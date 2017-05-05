package br.com.gti.profectus.infra.scheduled.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.gti.profectus.tools.dateTime.DateHelper;
import lombok.extern.log4j.Log4j2;

/**
 * TaskExecutor.
 * @author claudio.cesar
 * @since 17/12/2015
 */
@Log4j2
@Service
public class TaskExecutor {

    /**
     * executePurgeScheduled.
     * @author claudio.cesar
     * @since 17/12/2015
     * @throws Exception
     */
    @Transactional
    //@Scheduled(cron = "0 0/2 * * * *")
            public void
            executePurgeScheduled() throws Exception {
        Date dateActual = new Date();
        String strHour = DateHelper.formatDateTime(dateActual, new SimpleDateFormat("HH"));
        String strDate = DateHelper.formatDateTime(dateActual, DateHelper.DATE_YYYY_MM_DD);
        strDate = strDate + " " + strHour + ":00";

        try {
            //Date dateFilter = DateHelper.parseToDateTime(strDate, DateHelper.DATETIME_YYYY_MM_DD_HH_MM);
            //List<PurgeSchedulingDTO> listToPurge = this.purgeSchedulingBo.findNextScheduledPurge(dateFilter);

            //if (listToPurge != null && listToPurge.size() > 0) {
            //for (PurgeSchedulingDTO dto : listToPurge) {
            //this.purgeSchedulingBo.executePurge(dto);
            //log.info("call this.purgeSchedulingBo.executePurge");
            //}
            //}

        } catch (Exception e) {
            log.error("ERROR: TaskExecutor.executePurgeScheduled");
            log.error("Error to execute purge, verify log", e);
        }
    }

}
