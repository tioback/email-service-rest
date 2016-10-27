package br.ufsc.grad.renatoback.tcc.email.service.rest;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private Log logger = LogFactory.getLog(EmailService.class);

	AtomicInteger counter = new AtomicInteger();

	public void sendEmail(Long time) {
		logger.info(String.format("OK Email #%d after %d ns", counter.incrementAndGet(), System.nanoTime() - time));
	}

}
