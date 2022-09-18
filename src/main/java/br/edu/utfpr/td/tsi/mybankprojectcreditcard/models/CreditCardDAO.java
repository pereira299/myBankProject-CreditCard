package br.edu.utfpr.td.tsi.mybankprojectcreditcard.models;

import br.edu.utfpr.td.tsi.mybankprojectcreditcard.domains.CreditCard;

import java.util.ArrayList;
import java.util.List;

public class CreditCardDAO implements ICreditCardDAO {
    private final ArrayList<CreditCard> list;
    private int nextId;

    public CreditCardDAO() {
        this.list = new ArrayList<>();
    }


    @Override
    public CreditCard create(CreditCard creditCard) {
        creditCard.setId(nextId++);
        this.list.add(creditCard);
        return creditCard;
    }

    @Override
    public void update(int id, CreditCard creditCard) {
        list.stream().filter(c -> c.getId() == id).findFirst().ifPresent(c -> {
            c.setName(creditCard.getName() != null ? creditCard.getName() : c.getName());
            c.setCardLevel(creditCard.getCardLevel() != 0 ? creditCard.getCardLevel() : c.getCardLevel());

        });
    }

    @Override
    public void delete(int id) {
        list.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<CreditCard> buscar() {
        return list;
    }

    @Override
    public CreditCard buscarPorNumero(String numero) {
        return list.stream().filter(c -> c.getNumber().equals(numero)).findFirst().orElse(null);
    }

    @Override
    public List<CreditCard> buscar(int userId) {
        return list.stream().filter(c -> c.getUserId() == userId).toList();
    }
}
