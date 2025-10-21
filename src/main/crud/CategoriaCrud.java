package main.crud;

import java.util.ArrayList;

import main.models.Categoria;

public class CategoriaCrud extends ConsolaCrud<Categoria> {

    private final ArrayList<Categoria> categorias;
    public CategoriaCrud(ArrayList<Categoria> listaCat){
        this.categorias = listaCat;
    }
    
    @Override
    public void crear() {
        categorias.add(new Categoria(leerTexto("Ingrese el nombre de la categoria:\n")));
        System.out.println("Categoria creada exitosamente...");
    }

    @Override
    public void listar() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias actualmente...");
        } else {
            for (Categoria c : categorias) {
                System.out.println(c);
            }
        }
    }

    @Override
    public void actualizar() {
        listar();
        int id = leerEntero("Ingrese el id de la categoria a modificar nombre:\n");
        for (Categoria categoria : categorias) {
            if(categoria.getId() == id){
                categoria.setNombre(
                    leerTexto("Ingrese un nombre nuevo a la categoria '" + categoria.getNombre() + "':\n"));
                System.out.println("Categoria actualizada:\n " + categoria);
                return;
            }
        }
        System.out.println("No se encontro una categoria con id '" + id +"'...");
    }

    @Override
    public void eliminar() {
        int id = leerEntero("Id de la categoría a eliminar: ");
        boolean eliminado = categorias.removeIf(c -> c.getId() == id);
        System.out.println(eliminado ? "Categoria eliminada...": "No existe ese id...");
    }

}
