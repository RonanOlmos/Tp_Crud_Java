package main.crud;

import java.util.ArrayList;

import main.models.Card;
import main.models.Categoria;

public class CardCrud extends ConsolaCrud<Card>{
    private final ArrayList<Categoria> categorias;
    private final ArrayList<Card> cartas;

    public CardCrud(ArrayList<Card> cartas, ArrayList<Categoria> categorias){
        this.cartas = cartas;
        this.categorias = categorias;
    }
    @Override
    public void crear() {
        
    }

    @Override
    public void listar() {
        if (cartas.isEmpty()) {
            System.out.println("No hay cartas actualmente...");
        } else {
            for (Card c : cartas) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        
    }

    @Override
    public void eliminar() {
        
    }

}
