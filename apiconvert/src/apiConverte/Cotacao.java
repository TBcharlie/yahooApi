package apiConverte;

import java.math.BigDecimal;

import yahoofinance.YahooFinance;
import yahoofinance.quotes.fx.FxQuote;
import yahoofinance.quotes.fx.FxSymbols;

public class Cotacao {
	
	
	
	public static BigDecimal RealDolar(BigDecimal valorTroca) {
		BigDecimal valor = null;
		try {
		FxQuote usdbrl = new YahooFinance().getFx("BRL=X");
		valor = usdbrl.getPrice();
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return valorTroca.multiply(valor)  ;
	}}