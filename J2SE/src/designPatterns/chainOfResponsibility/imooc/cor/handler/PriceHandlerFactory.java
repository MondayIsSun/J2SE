package designPatterns.chainOfResponsibility.imooc.cor.handler;

public class PriceHandlerFactory {

	public static PriceHandler createPriceHandler() {

		PriceHandler sales = new Sales();
		PriceHandler lead = new Lead();
		PriceHandler manager = new Manager();
		PriceHandler director = new Director();
		PriceHandler vicePresident = new VicePresident();
		PriceHandler ceo = new CEO();

		// 指定对象的直接后继
		sales.setSuccessor(lead);
		lead.setSuccessor(manager);
		manager.setSuccessor(director);
		director.setSuccessor(vicePresident);
		vicePresident.setSuccessor(ceo);
		ceo.setSuccessor(null);

		return sales;
	}

}
