package com.comtel.ruta;

enum CardType {
    DangerAttack,
    SolutionDefense,
    SecurityShield,
    DistanceKm
}

/**
 *
 * @author user
 */
public class Card {
    private CardType type;

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }
}
