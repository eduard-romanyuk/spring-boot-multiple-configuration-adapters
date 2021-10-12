package com.example.testmultisec.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
	@GetMapping("/test")
	public Map<String, String> test() {
		return Collections.singletonMap("status", "Wallet API is up!");
	}
}
