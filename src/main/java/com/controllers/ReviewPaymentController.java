package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.services.PaymentService;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.ShippingAddress;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.PayPalRESTException;

@Controller
public class ReviewPaymentController {

	@GetMapping(path="/review_payment")
	public ModelAndView printHello(@RequestParam(name = "paymentId") String paymentId,
									@RequestParam(name = "PayerID") String payerId) {
		
		try {
			ModelAndView mav = new ModelAndView("review.html");

			PaymentService paymentService = new PaymentService();
			Payment payment = paymentService.getPaymentDetails(paymentId);
			
			PayerInfo payerInfo = payment.getPayer().getPayerInfo();
			Transaction transaction = payment.getTransactions().get(0);
			ShippingAddress shippingAddress = transaction.getItemList().getShippingAddress();
			
            mav.addObject("payer", payerInfo);
            mav.addObject("transaction", transaction);
            mav.addObject("shippingAddress", shippingAddress);
            return mav;
			
		} catch(PayPalRESTException ex) {
			ex.printStackTrace();
			ModelAndView mav = new ModelAndView("error.html");
            mav.addObject("errorMessage", "Could not get payment details");
            return mav;
		}		
	}
	
}