package fr.diginamic.rest.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CronService {

	@Scheduled(cron = "${cron.timing}")
	public void displayDate() {
		System.out.println("*** CRON *** Affichage date : " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}
	
}
