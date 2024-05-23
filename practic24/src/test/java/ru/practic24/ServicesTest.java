package ru.practic24;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ServicesTest {
  @Mock
  private BankRepository bankRepository;
  @Mock
  private CardRepository cardRepository;
  @InjectMocks
  private BankService bankService;
  @InjectMocks
  private CardService cardService;

  @Test
  public void getBanks() {
    List<Bank> banks = new ArrayList<>();
    banks.add(new Bank(Long.valueOf(1), "bank1", "road1", null));
    banks.add(new Bank(Long.valueOf(2), "bank2", "road2", null));

    Mockito.when(bankRepository.findAll()).thenReturn(banks);

    Iterable<Bank> bankIterable = bankService.getBanks();
    List<Bank> bankList = new ArrayList<>();
    bankIterable.forEach(bankList::add);
    assertEquals(2, bankList.size());
  }

  @Test
  public void addBank() {
    Bank bank = new Bank(Long.valueOf(2), "bank2", "road2", null);
    Mockito.when(bankRepository.save(bank)).thenReturn(bank);

    assertEquals(bank, bankService.saveBank(bank));
  }

  @Test
  public void deleteBank() {
    long bankId = 1;

    Mockito.doNothing().when(bankRepository).deleteById(bankId);

    Assertions.assertDoesNotThrow(() -> bankService.deleteById(bankId));
  }

  @Test
  public void getBankByName() {
    String bankName = "Bank1";
    Bank bank = new Bank(Long.valueOf(1), bankName, "road1", null);


    Mockito.when(bankRepository.getBankByName(bankName)).thenReturn(Optional.of(bank));

    Bank result = bankService.findByName(bankName);

    assertEquals(bank, result);
  }

  @Test
  public void getCards() {
    List<Card> cards = new ArrayList<>();
    cards.add(new Card(Long.valueOf(1), 1, 1, null));
    cards.add(new Card(Long.valueOf(2), 2, 2, null));

    Mockito.when(cardRepository.findAll()).thenReturn(cards);

    Iterable<Card> cardsIterable = cardService.getCards();
    List<Card> cardsList = new ArrayList<>();
    cardsIterable.forEach(cardsList::add);
    assertEquals(2, cardsList.size());
  }

  @Test
  public void addCard() {
    Card card = new Card(Long.valueOf(1), 1, 1, null);

    Mockito.when(cardRepository.save(card)).thenReturn(card);

    assertEquals(card.toString(), cardService.saveCard(card, Long.valueOf(0)));
  }

  @Test
  public void deleteSubject() {
    long cardId = 1;

    Mockito.doNothing().when(cardRepository).deleteById(cardId);

    Assertions.assertDoesNotThrow(() -> cardService.deleteById(cardId));
  }


}

