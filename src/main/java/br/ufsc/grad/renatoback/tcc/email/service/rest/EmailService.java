package br.ufsc.grad.renatoback.tcc.email.service.rest;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private Log logger = LogFactory.getLog(EmailService.class);

	AtomicInteger counter = new AtomicInteger();
	AtomicLong average = new AtomicLong();

	public void sendEmail(Long time) {
		counter.incrementAndGet();
		average.accumulateAndGet(System.nanoTime() - time, (n, m) -> (n + m) / (n == 0 || m == 0 ? 1 : 2));
	}

	public void printStatistics() {
		logger.info(String.format("Sent %d emails in an average of %d ns each", counter.get(), average.get()));
	}

	public void resetStatistics() {
		counter.set(0);
		average.set(0);
	}

}
