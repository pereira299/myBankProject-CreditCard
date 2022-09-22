package br.edu.utfpr.td.tsi.mybankprojectcreditcard.controllers;

import br.edu.utfpr.td.tsi.mybankprojectcreditcard.domains.CreditCard;
import br.edu.utfpr.td.tsi.mybankprojectcreditcard.models.CreditCardDAO;
import br.edu.utfpr.td.tsi.mybankprojectcreditcard.models.ICreditCardDAO;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class CreditCardController {
	
    private final ICreditCardDAO creditCardDAO;

    public CreditCardController() {
        this.creditCardDAO = new CreditCardDAO();
    }

    public CreditCard create(int cardLevel, String name, int userId) {
        //generate card number
        String cardNumber = Integer.toString((int) (Math.random() * 1000000000));
        // expiracy date is 5 years from now
        Calendar expiracyDate = Calendar.getInstance();
        expiracyDate.add(Calendar.YEAR, 5);
        // cvv is 3 random numbers
        String cvv = Integer.toString((int) (Math.random() * 1000));
        CreditCard creditCard = new CreditCard(cardNumber, name, expiracyDate, cvv, cardLevel);

        return creditCardDAO.create(creditCard);
    }

    public void update(int id, CreditCard creditCard) {
        creditCardDAO.update(id, creditCard);
    }

    public void delete(int id) {
        creditCardDAO.delete(id);
    }

    public List<CreditCard> list() {
        return creditCardDAO.buscar();
    }

    public List<CreditCard> list(int userId) {
        return creditCardDAO.buscar(userId);
    }

    public CreditCard listByNumber(String number) {
        return creditCardDAO.buscarPorNumero(number);
    }

    public void pagarFatura(int creditCardId, double value) {
        CreditCard creditCard = creditCardDAO.buscar().stream().filter(c -> c.getId() == creditCardId).findFirst().orElse(null);

        if (creditCard != null
                && creditCard.getExpirationDate().toInstant().isAfter(java.time.Instant.now())
                && creditCard.getBalance() >= value
                && value > 0 ) {
            creditCard.setBalance(creditCard.getBalance() - value);
        }

    }

    public void transferir(int creditCardId, double value)
    {
        CreditCard creditCard = creditCardDAO.buscar().stream().filter(c -> c.getId() == creditCardId).findFirst().orElse(null);

        if (creditCard != null
                && creditCard.getExpirationDate().toInstant().isAfter(java.time.Instant.now())
                && creditCard.getBalance() < creditCard.getLimit()
                && value > 0 ) {
            double availableLimit = creditCard.getCardLevel() - creditCard.getBalance();
            if(availableLimit >= value) {
                creditCard.setBalance(creditCard.getBalance() + value);
            }
        }
    }


}
