package br.edu.utfpr.td.tsi.mybankprojectcreditcard.models;

import br.edu.utfpr.td.tsi.mybankprojectcreditcard.domains.CreditCard;

import java.util.List;

public interface ICreditCardDAO {
    CreditCard create(CreditCard creditCard);
    void update(int id, CreditCard creditCard);
    void delete(int id);
    List<CreditCard> buscar();
    CreditCard buscarPorNumero(String numero);
    List<CreditCard> buscar(int userId);
}
